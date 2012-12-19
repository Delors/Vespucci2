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
package de.opalproject.vespucci.navigator.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * Handles delete requests for a selection of ensembles.
 * 
 * @author Marius-d
 * 
 */
public class DeleteHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * Initiates the deletion of the first element of the current selection.
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get selected Elements
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);
		
		System.out.println("Current Selection : "  + currentSelection.toString());
		
		// Initiate handler to close open editors of the ensemble to be deleted
		IHandlerService handlerService = (IHandlerService) HandlerUtil
				.getActiveWorkbenchWindow(event).getWorkbench()
				.getService(IHandlerService.class);

		// Cast selection to ensembles
		@SuppressWarnings("unchecked")
		List<Ensemble> ensembleList = currentSelection.toList();

		Event e = new Event();
		e.data = currentSelection;


		try {
			handlerService.executeCommand(
					"de.opalproject.vespucci.editor.closeEditor", null);
		} catch (Exception ex) {
			throw new RuntimeException(
					"de.opalproject.vespucci.editor.closeEditor not found");
		}

		// Get first selected element and delete it with all its children
		Ensemble current = ensembleList.get(0);
		// for (Ensemble current : ensembleList) {
		if (current != null) {
			current.getParent().getChildren().remove(current);
		}
		// }

		return null;
	}
}