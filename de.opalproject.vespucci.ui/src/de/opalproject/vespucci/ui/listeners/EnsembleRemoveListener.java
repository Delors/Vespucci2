/*
 * License (BSD Style License):
 * Copyright (c) 2012
 * Software Engineering
 * Department of Computer Science
 * Technische Universitiät Darmstadt
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.ui.editor.EnsembleEditor;
import de.opalproject.vespucci.ui.editor.EnsembleEditorInput;

/**
 * Listens for removed Ensembles and closes their editors
 * 
 * @author Marco Jacobasch
 */
public class EnsembleRemoveListener extends DemultiplexingListener {

	/**
	 * NotificationFilter to select only remove notifications and Ensembles or
	 * EnsembleRepository
	 */
	private static final NotificationFilter REMOVE_FILTER = NotificationFilter
			.createEventTypeFilter(Notification.REMOVE)
			.and(NotificationFilter
					.createNotifierTypeFilter(
							DatamodelPackage.Literals.CONCRETE_ENSEMBLE)
					.or(NotificationFilter
							.createNotifierTypeFilter(DatamodelPackage.Literals.ENSEMBLE_REPOSITORY)));

	/**
	 * Creates Listener with a NotificationFilter
	 */
	public EnsembleRemoveListener() {
		super(REMOVE_FILTER);
	}

	/**
	 * Checks only if removed object was an Ensemble, if true, closes all open
	 * Ensemble Editors.
	 * 
	 * Checking remove event and correct classes is done by the
	 * NotificationFilter
	 */
	@Override
	protected void handleNotification(TransactionalEditingDomain domain,
			Notification notification) {

		if (notification.getOldValue() instanceof Ensemble) {
			final Ensemble oldEnsemble = (Ensemble) notification.getOldValue();

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage page = getActivePage();
					Ensemble ens = oldEnsemble;

					if (page != null) {
						IEditorReference[] editors = page.findEditors(
								new EnsembleEditorInput(ens),
								EnsembleEditor.ID, IWorkbenchPage.MATCH_ID
										| IWorkbenchPage.MATCH_INPUT);

						page.closeEditors(editors, false);
					}
				}
			});
		}
	}

	/**
	 * Get the current active page to close all editors
	 * 
	 * @return
	 */
	private IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;

		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();

			if (window != null) {
				result = window.getActivePage();
			}
		}

		return result;
	}
}
