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
package de.opalproject.vespucci.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.sliceEditor.features.dark.DarkRemoveEnsemblesFeature;
import de.opalproject.vespucci.ui.Activator;
import de.opalproject.vespucci.ui.utils.EmfService;

/**
 * Wizard for renaming existing ensembles
 * 
 * @author Marius-d
 * 
 */
public class RemoveEnsemblesFromSlicesChoiceWizard extends Wizard {

	/**
	 * Page belonging to this wizard.
	 */
	private RemoveEnsemblesFromSlicesChoicePage page;

	/**
	 * List of selected Ensembles to be deleted.
	 */
	private final List<Ensemble> ensembleList;
	/**
	 * List of Ensembles to be deleted, including all their derived children.
	 */
	private final List<Ensemble> ensembleListParam;

	/**
	 * Default Constructor.
	 * 
	 * @param ensembleList
	 */
	public RemoveEnsemblesFromSlicesChoiceWizard(List<Ensemble> ensembleList) {
		super();
		this.ensembleList = ensembleList;

		List<Ensemble> ensembleListParam = new ArrayList<Ensemble>();
		ensembleListParam.addAll(ensembleList);

		// retrieve all children for each ensemble since these are going to be
		// removed as well
		for (Ensemble ens : ensembleList) {
			TreeIterator<EObject> it = ens.eAllContents();
			while (it.hasNext()) {
				EObject next = it.next();
				if (next instanceof Ensemble) {
					ensembleListParam.add((Ensemble) next);
				}
			}
		}
		this.ensembleListParam = ensembleListParam;

		setNeedsProgressMonitor(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page = new RemoveEnsemblesFromSlicesChoicePage(ensembleListParam);
		addPage(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

					// call darkremovefeature to remove the graphical
					// representations prior to the removal from the
					// businessmodel
					DarkRemoveEnsemblesFeature operation = new DarkRemoveEnsemblesFeature(
							editingDomain, ensembleListParam);
					editingDomain.getCommandStack().execute(operation);

					Command delete = new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							// Iterate over every ensemble which should be
							// deleted
							for (final Ensemble ensemble : ensembleList) {
								// Remove every constraint which used the
								// deleted
								// ensemble
								// as source or target
								for (Constraint constraint : ensemble
										.getConstraints()) {
									EcoreUtil.delete(constraint);
								}

								EcoreUtil.delete(ensemble);
							}
						}
					};

					editingDomain.getCommandStack().execute(delete);
					EmfService.save(editingDomain);

				} catch (Exception exception) {
					Activator
							.getDefault()
							.getLog()
							.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									Arrays.toString(exception.getStackTrace())));

				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (InvocationTargetException | InterruptedException exception) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Arrays
							.toString(exception.getStackTrace())));
		}

		return true;

	}
}
