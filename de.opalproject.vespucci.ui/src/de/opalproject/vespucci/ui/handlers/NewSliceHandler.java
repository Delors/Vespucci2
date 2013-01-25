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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.datamodel.SliceRepository;
import de.opalproject.vespucci.ui.wizards.NewSliceWizard;

/**
 * Uses NewSliceWizard to create a new slice
 * 
 * @author Lars
 * @author Marco Jacobasch
 * 
 */
public class NewSliceHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);

		final NewSliceWizard wiz = new NewSliceWizard();

		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShell(event), wiz);
		dialog.open();

		if (wiz.getName() != null) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

			SliceRepository sr = (SliceRepository) currentSelection
					.getFirstElement();

			// create new slice
			DatamodelFactory factory = DatamodelFactory.eINSTANCE;
			Slice slice = factory.createSlice();

			// create new diagrams
			Diagram dia = Graphiti.getPeCreateService().createDiagram(
					"sliceEditor", wiz.getName(), true);

			// link diagram with slice
			PictogramLink pl = PictogramsFactory.eINSTANCE
					.createPictogramLink();
			pl.getBusinessObjects().add(slice);
			dia.setLink(pl);

			// Add Diagram to xmi file. Needs to be a single Command
			Command addCommand = new AddCommand(domain, sr.eResource()
					.getContents(), dia);
			domain.getCommandStack().execute(addCommand);

			List<Command> commandList = new ArrayList<Command>();

			// set slice name
			commandList.add(new SetCommand(domain, slice,
					DatamodelPackage.Literals.SLICE__NAME, wiz.getName()));

			// Set slice.diagram to fragment of diagram inside xmi
			commandList.add(new SetCommand(domain, slice,
					DatamodelPackage.Literals.SLICE__DIAGRAM, sr.eResource()
							.getURIFragment(dia)));

			// add slice to slice repository
			commandList
					.add(new AddCommand(
							domain,
							sr,
							DatamodelPackage.Literals.SLICE_REPOSITORY__CONTAINS,
							slice));

			// Merge all commands into a single one
			Command commmand = new CompoundCommand(commandList);

			// execute the command
			domain.getCommandStack().execute(commmand);

			// save xmi
			try {
				sr.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}
}
