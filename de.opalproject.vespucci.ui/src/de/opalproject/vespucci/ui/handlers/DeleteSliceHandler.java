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
package de.opalproject.vespucci.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.opalproject.vespucci.datamodel.Slice;

/**
 * Handles delete requests for a selection of ensembles.
 * 
 * @author Marco Jacobasch
 * 
 */
public class DeleteSliceHandler extends AbstractCommandHandler {

	@Override
	public Command getCommand(IStructuredSelection selection,
			ExecutionEvent event) {

		// List to store the single commands for compound
		List<Command> commandList = new ArrayList<Command>();

		@SuppressWarnings("unchecked")
		final List<Slice> sliceList = selection.toList();

		for (final Slice slice : sliceList) {
			Command c = new RecordingCommand(getEditingDomain()) {

				@Override
				protected void doExecute() {
					// Resolv diagram string to diagram object
					Diagram diagram = (Diagram) slice.eResource().getEObject(
							slice.getDiagram());

					// Delete Slice and Diagram
					EcoreUtil.remove(diagram);
					EcoreUtil.remove(slice);
				}
			};

			// Add command to list
			commandList.add(c);
		}

		// Combine command list to a single compund command
		Command deleteCommand = new CompoundCommand(commandList);
		return deleteCommand;
	}
}