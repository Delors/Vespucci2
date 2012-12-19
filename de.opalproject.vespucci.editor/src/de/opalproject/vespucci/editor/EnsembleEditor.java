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
package de.opalproject.vespucci.editor;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * Edits the properties of single Ensembles from the Ensemble Explorer
 * 
 * @author Marco Jacobasch, Roman Uhlig
 * 
 */
public class EnsembleEditor extends EditorPart {

	public static final String ID = "de.opalproject.vespucci.editor.editor";
	private Ensemble ensemble;
	private EditorInput input;
	private Text nameTextField;
	private Text descriptionTextField;
	private Text queryTextField;
	private Button derivedCheckBox;
	private boolean dirty;

	// Will be called before createPartControl
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		if (!(input instanceof EditorInput)) {
			throw new RuntimeException("Wrong input for Ensemble Editor");
		}

		// TODO use EditorInput for persistence
		EditorInput new_name = (EditorInput) input;
		this.input = (EditorInput) input;

		setSite(site);
		setInput(input);
		ensemble = new_name.getEnsemble();

		setPartName("Ensemble ID: " + ensemble.getName());
	}

	@Override
	public void createPartControl(Composite parent) {

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
		textFieldLayoutData.minimumHeight = 50;

		descriptionTextField = new Text(parent, SWT.MULTI | SWT.BORDER
				| SWT.WRAP | SWT.V_SCROLL);
		descriptionTextField.setLayoutData(textFieldLayoutData);
		descriptionTextField.setText(ensemble.getDescription());

		Composite queryNameAndDerivedPanel = new Composite(parent,
				SWT.NO_BACKGROUND);
		queryNameAndDerivedPanel.setLayout(new FillLayout());

		Label queryLabel = new Label(queryNameAndDerivedPanel, SWT.NONE);
		queryLabel.setText("Query");

		Label derivedLabel = new Label(queryNameAndDerivedPanel, SWT.NONE);
		derivedLabel.setText("Derived");

		derivedCheckBox = new Button(queryNameAndDerivedPanel, SWT.CHECK);
		derivedCheckBox.setSelection(ensemble.isDerived());

		queryTextField = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		queryTextField.setLayoutData(textFieldLayoutData);
		queryTextField.setText(ensemble.getQuery());
		queryTextField.setEnabled(!ensemble.isDerived());

		// disables the query field if the query is supposed to be derived
		derivedCheckBox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				queryTextField.setEnabled(!derivedCheckBox.getSelection());
				dirty = true;
				firePropertyChange(PROP_DIRTY);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

	}

	/**
	 * Disposes the toolkit
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		dirty = false;
		// TODO implement real save
		// for now only the name will be forwarded to the original model

		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {

				final Resource r = ensemble.eResource();

				ensemble.setName(nameTextField.getText());
				ensemble.setDerived(derivedCheckBox.getSelection());
				ensemble.setDescription(descriptionTextField.getText());
				ensemble.setQuery(queryTextField.getText());

				try {
					r.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		// for debugging purposes
		// SaveAs will probably not be available in final Version
		System.out.println(ensemble);
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO disable once real saving is possible
		// enabled for debugging purposes, see doSave()
		return true;
	}

	@Override
	public void setFocus() {
	}

}
