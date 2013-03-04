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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;

/**
 * RemoveEnsemblesFromSlicesChoicePage
 * 
 * @author Marius-d
 * 
 */
public class RemoveEnsemblesFromSlicesChoicePage extends WizardPage {
	private Text text1;
	private Composite container;
	private Text description;
	final List<Ensemble> ensembleList;

	/**
	 * Creates a new page for the rename wizard.
	 * 
	 * @param eName
	 *            the current name of the object.
	 */
	public RemoveEnsemblesFromSlicesChoicePage() {
		super("Super First Page");
		ensembleList = null;
		setTitle("Are you sure you want to delete");
		setDescription("Are you really sure you want to delete");

	}

	public RemoveEnsemblesFromSlicesChoicePage(List<Ensemble> ensembleList) {
		super("Super First Page");
		this.ensembleList = ensembleList;
		setTitle("Are you sure you want to delete");
		setDescription("Are you really sure you want to delete");

	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("List of Slices \n of Ensembles to be deleted");

		description = new Text(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		StringBuffer str = new StringBuffer();
		Set sliceset = new HashSet();
		for (Ensemble ens : ensembleList) {
			for (Slice slice : ens.getSlices()) {
				if (!sliceset.contains(slice)) {
					str.append(slice.getName() + "\n");
					sliceset.add(slice);
				}
			}
		}

		description.setText(str.toString());
		// description.setEnabled(false);
		description.setEditable(false);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(gd);
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
}
