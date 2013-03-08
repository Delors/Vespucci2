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
package de.opalproject.vespucci.globalRepository.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.opalproject.vespucci.globalRepository.utils.EmfService;

/**
 * Abstract command handler for every emf transaction
 * 
 * @author Marco Jacobasch
 * 
 */
public abstract class AbstractCommandHandler extends AbstractHandler {

	/**
	 * Transactional editing domain which is used for every command.
	 */
	private final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = getSelection(event);
		Command command = getCommand(selection, event);

		getEditingDomain().getCommandStack().execute(command);

		EmfService.save(getEditingDomain());

		return null;
	}

	/**
	 * Returns the current selection as {@link IStructuredSelection}
	 * 
	 * @param event
	 * @return the current selection
	 */
	public IStructuredSelection getSelection(ExecutionEvent event) {
		return (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
	}

	/**
	 * Returns the used editing domain
	 * 
	 * @return
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return domain;
	}

	/**
	 * Returns the command which will be executed
	 * 
	 * Must be implemented by subclasses
	 * 
	 * @param selection
	 * @param event
	 * @return
	 */
	public abstract Command getCommand(IStructuredSelection selection,
			ExecutionEvent event);

}
