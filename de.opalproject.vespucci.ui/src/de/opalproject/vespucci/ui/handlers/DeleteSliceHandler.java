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

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.ui.sliceEditor.SliceEditorDiagramTypeProvider;

/**
 * Handles delete requests for a selection of ensembles.
 * 
 * @author Marco Jacobasch
 * 
 */
public class DeleteSliceHandler extends AbstractCommandHandler {

	@Override
	public Command getCommand(IStructuredSelection selection,
			final ExecutionEvent event) {

		@SuppressWarnings("unchecked")
		final List<Slice> sliceList = selection.toList();

		Command deleteCommand = new RecordingCommand(getEditingDomain()) {
			private IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindow(event);

			@Override
			protected void doExecute() {
				for (final Slice slice : sliceList) {
					// Resolve diagram string to diagram object
					Diagram diagram = (Diagram) slice.eResource().getEObject(
							slice.getDiagram());

					closeEditor(diagram);

					// Delete Slice and Diagram
					EcoreUtil.delete(slice, true);
					EcoreUtil.delete(diagram);
				}
			}

			private void closeEditor(Diagram diagram) {
				IWorkbenchPage page = window.getActivePage();
				DiagramEditorInput editorInput = DiagramEditorInput
						.createEditorInput(
								diagram,
								SliceEditorDiagramTypeProvider.DIAGRAM_TYPE_PROVIDER_ID);
				IEditorPart openEditor = page.findEditor(editorInput);
				if (openEditor != null) {
					page.closeEditor(openEditor, false);
				}
			}
		};

		return deleteCommand;
	}
}