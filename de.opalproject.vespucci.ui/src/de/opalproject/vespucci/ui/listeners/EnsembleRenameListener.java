/*
 * License (BSD Style License):
 * Copyright (c) 2012
 * Software Engineering
 * Department of Computer Science
 * Technische Universität Darmstadt
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Software Engineering Group or Technische
 * Universität Darmstadt nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package de.opalproject.vespucci.ui.listeners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.ui.sliceEditor.features.dark.DarkEnsembleUpdateFeature;
import de.opalproject.vespucci.ui.utils.EmfService;

/**
 * Listens for renamed Ensembles and triggers an update for graphiti diagrams
 * 
 * @author Marco Jacobasch
 */
public class EnsembleRenameListener extends DemultiplexingListener {

	/**
	 * NotificationFilter to select only set notifications and Ensembles and
	 * only name changes
	 */
	private static final NotificationFilter SET_FILTER = NotificationFilter
			.createEventTypeFilter(Notification.SET)
			.and(NotificationFilter
					.createNotifierTypeFilter(
							DatamodelPackage.Literals.CONCRETE_ENSEMBLE)
					.and(NotificationFilter
							.createFeatureFilter(
									DatamodelPackage.Literals.ENSEMBLE__NAME)
							.or(NotificationFilter
									.createFeatureFilter(DatamodelPackage.Literals.ENSEMBLE__DESCRIPTION))));

	/**
	 * Creates Listener with a NotificationFilter
	 */
	public EnsembleRenameListener() {
		super(SET_FILTER);
	}

	/**
	 * Checks if the event is not a touch (not changed) and then triggers an
	 * graphiti dark feature to update the changed ensemble
	 */
	@Override
	protected void handleNotification(TransactionalEditingDomain domain,
			Notification notification) {
		if (!notification.isTouch()) {
			final Ensemble ensemble = (Ensemble) notification.getNotifier();

			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

					List<Ensemble> ensembles = new ArrayList<Ensemble>();
					ensembles.add(ensemble);

					DarkEnsembleUpdateFeature operation = new DarkEnsembleUpdateFeature(
							editingDomain, ensembles);
					editingDomain.getCommandStack().execute(operation);
					EmfService.save(editingDomain);
				}
			});

		}
	}
}
