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
package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.opalproject.vespucci.datamodel.Constraint;

public class ChangeConstraintDependencyKind extends AbstractCustomFeature {

	private boolean hasDoneChanges = false;

	public ChangeConstraintDependencyKind(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Change Dependency Kind";
	}

	@Override
	public String getDescription() {
		return "Change the dependency kind of a constraint";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow rename if exactly one pictogram element
		// representing a Constraint is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Constraint) {
				ret = true;
			}
		}
		if (pes != null && pes.length == 1) {
			if (pes[0] instanceof ConnectionDecorator) {
				if (((ConnectionDecorator) pes[0]).getGraphicsAlgorithm() instanceof Text)
					return true;
			}
		}
		return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();

		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Constraint) {
				Connection connection = (Connection) pes[0];
				Constraint constraint = (Constraint) bo;
				String currentKind = constraint.getDependencyKind();
				// ask user for a new dependency kind
				String newKind = askString(getName(), getDescription(),
						currentKind);
				// TODO add check to see whether the newly entered is a valid
				// one
				if (newKind != null && !newKind.equals(currentKind)) {
					this.hasDoneChanges = true;
					constraint.setDependencyKind(newKind);
					// hand changes to the connection decorator - label
					for (ConnectionDecorator condec : connection
							.getConnectionDecorators()) {
						if (condec.getGraphicsAlgorithm() instanceof Text) {
							Text text = (Text) condec.getGraphicsAlgorithm();
							text.setValue(newKind);
						}
					}
				}
			}
			if (pes[0] instanceof ConnectionDecorator) {
				ConnectionDecorator cd = (ConnectionDecorator) pes[0];
				Connection connection = cd.getConnection();
				if (getBusinessObjectForPictogramElement(connection) instanceof Constraint) {
					Constraint constraint = (Constraint) getBusinessObjectForPictogramElement(connection);
					String currentKind = constraint.getDependencyKind();
					// ask user for a new dependency kind
					String newKind = askString(getName(), getDescription(),
							currentKind);
					if (newKind != null && !newKind.equals(currentKind)) {
						this.hasDoneChanges = true;
						constraint.setDependencyKind(newKind);
						if (cd.getGraphicsAlgorithm() instanceof Text) {
							Text text = (Text) cd.getGraphicsAlgorithm();
							text.setValue(newKind);
						}
					}
				}
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}

	/**
	 * Opens an simple input dialog with OK and Cancel buttons.
	 * <p>
	 * 
	 * @param dialogTitle
	 *            the dialog title, or <code>null</code> if none
	 * @param dialogMessage
	 *            the dialog message, or <code>null</code> if none
	 * @param initialValue
	 *            the initial input value, or <code>null</code> if none
	 *            (equivalent to the empty string)
	 * @return the string
	 */
	public static String askString(String dialogTitle, String dialogMessage,
			String initialValue) {
		String ret = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		InputDialog inputDialog = new InputDialog(shell, dialogTitle,
				dialogMessage, initialValue, null);
		int retDialog = inputDialog.open();
		if (retDialog == Window.OK) {
			ret = inputDialog.getValue();
		}
		return ret;
	}
}