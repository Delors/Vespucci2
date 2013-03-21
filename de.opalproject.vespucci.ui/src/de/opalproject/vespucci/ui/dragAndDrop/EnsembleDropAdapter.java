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
package de.opalproject.vespucci.ui.dragAndDrop;

import java.awt.dnd.DnDConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.TreeNode;
import de.opalproject.vespucci.ui.sliceEditor.features.dark.DarkEnsembleUpdateFeature;
import de.opalproject.vespucci.ui.utils.EmfService;

/**
 * Handles drop support for ensembles
 * 
 * @author Marco Jacobasch
 * 
 */
public class EnsembleDropAdapter extends CommonDropAdapterAssistant {

	/**
	 * Validates if droptarget is a TreeNode (Ensemble or EnsembleRepositor) and
	 * operation is a move.
	 * 
	 */
	@Override
	public IStatus validateDrop(Object target, int operation,
			TransferData transferType) {
		if (target instanceof TreeNode && operation == DnDConstants.ACTION_MOVE) {
			IStatus status = new Status(IStatus.OK,
					"de.opalproject.vespucci.ui", "test");
			return status;
		}
		return null;
	}

	/**
	 * Handle drop event.
	 * 
	 * Only allows drag&drop if target and source are inside the same resource.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

		final TreeNode target = (TreeNode) aTarget;
		TreeSelection sourceTree = (TreeSelection) (aDropTargetEvent.data);
		final TreeNode source = (TreeNode) sourceTree.getFirstElement();

		// Cancel if not inside the same resource
		if (!target.eResource().equals(source.eResource())) {
			return null;
		}

		Command command = new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				source.getParent().getChildren().remove(source);
				source.setParent(target);
			}
		};

		domain.getCommandStack().execute(command);
		EmfService.save(domain);

		
		// Dark Feature update call
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

		List<Ensemble> ensembles = new ArrayList<Ensemble>();
		// Gather relevant ensembles 
		if (source instanceof Ensemble) {
			ensembles.add((Ensemble) source);
		}
		if (target instanceof Ensemble) {
			ensembles.add((Ensemble) target);
		} else {
			ensembles.addAll((Collection<? extends Ensemble>) target
					.getChildren());
		}

		// Fire dark update to get (possible) error decorators in slices 
		DarkEnsembleUpdateFeature operation = new DarkEnsembleUpdateFeature(
				editingDomain, ensembles, true);
		editingDomain.getCommandStack().execute(operation);
		EmfService.save(editingDomain);

		return new Status(IStatus.OK, "de.opalproject.vespucci.ui", "test");
	}
}
