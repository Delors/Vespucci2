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
package de.opalproject.vespucci.ui.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.sliceEditor.features.dark.DarkEnsembleUpdateFeature;
import de.opalproject.vespucci.ui.utils.EmfService;

/**
 * Edits the properties of single Ensembles from the Ensemble Explorer
 * 
 * @author Marco Jacobasch, Roman Uhlig
 * 
 */
public class EnsembleEditor extends EditorPart {

	public static final String ID = "de.opalproject.vespucci.editor.editor";

	private static final int DESCRIPTION_MIN_HEIGTH = 50;

	private Ensemble ensemble;
	private Text nameTextField;
	private Text descriptionTextField;
	private Text queryTextField;
	private Button derivedCheckBox;
	private boolean dirty;
	private Control lastControlInFocus;

	// Will be called before createPartControl
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		if (!(input instanceof EnsembleEditorInput)) {
			throw new PartInitException("Wrong input for Ensemble Editor");
		}

		setSite(site);
		setInput(input);
		ensemble = ((EnsembleEditorInput) input).getEnsemble();

		setPartName(ensemble.getName());
	}

	@Override
	public void createPartControl(Composite parent) {

		createUIElements(parent);
		createInputChangeListeners();
		createFocusChangeListeners();

	}

	/*
	 * Creates all text fields and checkboxes
	 */
	private void createUIElements(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		parent.setLayout(layout);

		Label nameLabel = new Label(parent, SWT.NONE);
		nameLabel.setText("Name");

		nameTextField = new Text(parent, SWT.BORDER);
		nameTextField.setText(ensemble.getName());
		nameTextField.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
				false));

		Label descriptionLabel = new Label(parent, SWT.NONE);
		descriptionLabel.setText("Description");

		// layout data for the text fields, used to adjust their size
		GridData textFieldLayoutData = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		textFieldLayoutData.minimumHeight = DESCRIPTION_MIN_HEIGTH;

		descriptionTextField = new Text(parent, SWT.MULTI | SWT.BORDER
				| SWT.WRAP | SWT.V_SCROLL);
		descriptionTextField.setLayoutData(textFieldLayoutData);
		descriptionTextField.setText(ensemble.getDescription());

		Composite queryNameAndDerivedPanel = new Composite(parent,
				SWT.NO_BACKGROUND);
		queryNameAndDerivedPanel.setLayout(new FillLayout());

		Label queryLabel = new Label(queryNameAndDerivedPanel, SWT.NONE);
		queryLabel.setText("Query");

		derivedCheckBox = new Button(queryNameAndDerivedPanel, SWT.CHECK);
		derivedCheckBox.setSelection(ensemble.isDerived());
		derivedCheckBox.setText("Derived");

		queryTextField = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		queryTextField.setLayoutData(textFieldLayoutData);
		queryTextField.setText(ensemble.getQuery());
		queryTextField.setEnabled(!ensemble.isDerived());
	}

	/**
	 * Adds a change listener to each editable field. The Listeners are meant to
	 * detect any deviation from the currently saved state.
	 */
	private void createInputChangeListeners() {

		// on any change in user input, check if the state should be dirty
		ModifyListener modifyListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				checkAndSetDirty();
			}
		};

		nameTextField.addModifyListener(modifyListener);
		queryTextField.addModifyListener(modifyListener);
		descriptionTextField.addModifyListener(modifyListener);

		// another listener for the query field that disables the query field if
		// the query is supposed to be derived
		derivedCheckBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				queryTextField.setEnabled(!derivedCheckBox.getSelection());
				checkAndSetDirty();
			}
		});

	}

	/*
	 * Adds a focus listener to each control. The listeners are meant to
	 * remember which element was the last to gain the input focus.
	 */
	private void createFocusChangeListeners() {
		FocusListener focusListener = new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (e.getSource() instanceof Control) {
					lastControlInFocus = (Control) e.getSource();
				}
			}
		};
		nameTextField.addFocusListener(focusListener);
		queryTextField.addFocusListener(focusListener);
		descriptionTextField.addFocusListener(focusListener);
		derivedCheckBox.addFocusListener(focusListener);

		lastControlInFocus = nameTextField;
	}

	/**
	 * Checks if any user input differs from the saved data.
	 * 
	 * If it does, the Editor state is set to dirty and vice versa.
	 */
	private void checkAndSetDirty() {

		boolean isDirty = false;

		// the editor state becomes dirty if any user input differs from the
		// saved data
		if (!ensemble.getName().equals(nameTextField.getText())) {
			isDirty = true;
		} else if (!ensemble.getDescription().equals(
				descriptionTextField.getText())) {
			isDirty = true;
		} else if (!ensemble.getQuery().equals(queryTextField.getText())) {
			isDirty = true;
		} else if (!ensemble.isDerived() == derivedCheckBox.getSelection()) {
			isDirty = true;
		}

		// set the new state and fire a property change if necessary
		if (isDirty != dirty) {
			dirty = isDirty;
			firePropertyChange(PROP_DIRTY);
		}

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		dirty = false;

		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

		Command saveCommand = new RecordingCommand(domain) {
			protected void doExecute() {
				// saving in our case means writing the data back into the
				// original model
				ensemble.setName(nameTextField.getText());
				ensemble.setDerived(derivedCheckBox.getSelection());
				ensemble.setDescription(descriptionTextField.getText());
				ensemble.setQuery(queryTextField.getText());
			}
		};

		domain.getCommandStack().execute(saveCommand);

		EmfService.save(domain);

		updateEnsembleRepresentationInSlice(domain);

		// set the editor name, as the ensemble name may have changed
		setPartName(ensemble.getName());

		// tell Eclipse that the dirty state has changed
		firePropertyChange(PROP_DIRTY);
	}

	/**
	 * Updates the graphical representation of this editors ensemble in all
	 * Slices that it is part of, whether they are closed or not.
	 * 
	 * @param domain
	 */
	private void updateEnsembleRepresentationInSlice(
			TransactionalEditingDomain domain) {
		// the ensemble has to be put in a list to be used for the dark feature
		// update
		ArrayList<Ensemble> toBeRenamed = new ArrayList<Ensemble>();

		toBeRenamed.add(ensemble);
		// Execute
		DarkEnsembleUpdateFeature operation = new DarkEnsembleUpdateFeature(
				domain, toBeRenamed);
		domain.getCommandStack().execute(operation);
	}

	@Override
	public void doSaveAs() {
		// for debugging purposes
		// SaveAs will probably not be available in final Version
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public void setFocus() {
		lastControlInFocus.setFocus();
	}

	@Override
	public boolean isSaveAsAllowed() {
		// There is no actual save location, therefore the user should not try
		// to change it.
		return false;
	}

	/**
	 * Disposes all allocated swt resources
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (nameTextField != null) {
			nameTextField.dispose();
		}
		if (descriptionTextField != null) {
			descriptionTextField.dispose();
		}
		if (queryTextField != null) {
			queryTextField.dispose();
		}
		if (derivedCheckBox != null) {
			derivedCheckBox.dispose();
		}
		if (lastControlInFocus != null) {
			lastControlInFocus.dispose();
		}
	}
}
