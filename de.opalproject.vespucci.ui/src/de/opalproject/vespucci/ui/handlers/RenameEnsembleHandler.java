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
package de.opalproject.vespucci.ui.handlers;

import java.awt.List;
import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.sliceEditor.features.dark.DarkEnsembleUpdateFeature;
import de.opalproject.vespucci.sliceEditor.features.dark.DarkSliceUpdateFeature;
import de.opalproject.vespucci.ui.utils.EmfService;
import de.opalproject.vespucci.ui.wizards.EnsembleWizardRename;

/**
 * Used by EnsembleRenameWizard to rename an existing ensemble.
 * 
 * @author Marius-d
 * @author Marco Jacobasch
 * 
 */
public class RenameEnsembleHandler extends AbstractEnsembleCommandHandler {

	@Override
	public Command getCommand(IStructuredSelection selection,
			ExecutionEvent event) {
		EnsembleWizardRename wizard = createAndOpenWizard(selection, event);

		EObject owner = getOwner(selection);
		Object feature = DatamodelPackage.Literals.ENSEMBLE__NAME;

		Command add = SetCommand.create(getEditingDomain(), owner, feature,
				wizard.getName());

		return add;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = getSelection(event);
		Command command = getCommand(selection, event);

		getEditingDomain().getCommandStack().execute(command);

		EmfService.save(getEditingDomain());

		// Get the editing Domain
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

		// the ensemble has to be put in a list to be used for the dark feature
		// update
		ArrayList<Ensemble> toBeRenamed = new ArrayList<Ensemble>();
		if (selection.getFirstElement() instanceof Ensemble) {
			toBeRenamed.add((Ensemble) selection.getFirstElement());
			// Execute
			DarkEnsembleUpdateFeature operation = new DarkEnsembleUpdateFeature(
					editingDomain, toBeRenamed);
			editingDomain.getCommandStack().execute(operation);
		}
		return null;
	}

	/**
	 * Opens the rename wizard
	 * 
	 * @param selection
	 * @param event
	 * @return
	 */
	private EnsembleWizardRename createAndOpenWizard(
			IStructuredSelection selection, ExecutionEvent event) {
		final Ensemble ensemble = (Ensemble) getOwner(selection);
		final EnsembleWizardRename wizard = new EnsembleWizardRename(
				ensemble.getName());

		// Launch renamewizard
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShell(event), wizard);
		dialog.open();

		return wizard;
	}

}