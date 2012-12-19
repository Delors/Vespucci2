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

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.navigator.wizards.NewEnsembleWizard;

/**
 * Used by NewEnsembleWizard to create a new ensemble
 * 
 * @author Lars
 * @author Marco Jacobasch
 * 
 */
public class NewEnsembleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);

		final NewEnsembleWizard wiz = new NewEnsembleWizard();

		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShell(event), wiz);
		dialog.open();

		if (wiz.name != null) {

			final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");
			final Ensemble selectetDomainObject = (Ensemble) currentSelection
					.getFirstElement();
			final Resource r = selectetDomainObject.eResource();

			domain.getCommandStack().execute(new RecordingCommand(domain) {
				protected void doExecute() {
					DatamodelFactory factory = DatamodelFactory.eINSTANCE;

					Ensemble ens = factory.createEnsemble();

					// selectetDomainObject.getChildren().add(ens);
					ens.setParent(selectetDomainObject);
					ens.setName(wiz.name);
					ens.setDescription(wiz.description);
					ens.setDerived(false);
					ens.setQuery("");

					try {
						r.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}

		return null;

	}
}
