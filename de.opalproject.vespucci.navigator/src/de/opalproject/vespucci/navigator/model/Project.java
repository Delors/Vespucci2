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
package de.opalproject.vespucci.navigator.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.opalproject.vespucci.datamodel.DatamodelFactory;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * A Project containing Ensembles
 * 
 * TODO: Should be IProject
 * 
 * @author Marco Jacobasch
 * 
 */
public class Project {

	/**
	 * TODO: remove, should be provided datamodel.persistence
	 */
	private ResourceSet resourceSet;

	/**
	 * TODO: remove, should be provided datamodel.persistence
	 */
	private Resource resource;

	/**
	 * Used to "simulate" an eclipse project as root node
	 * 
	 * TODO: temporary parent, should be a project
	 */
	private Ensemble[] children;

	private final String name;

	private final Object parent;

	public Project(String name, Object parent) {
		this.name = name;
		this.parent = parent;
		resourceSet = new ResourceSetImpl();
		initializeData();
	}

	public String getName() {
		return name;
	}

	public Object[] getChildren() {
		return children;
	}

	public Object getParent() {
		return parent;
	}

	/**
	 * Init code for empty model Temporary dummy data
	 * 
	 * TODO: remove if persistence is available
	 */
	private void initializeData() {
		resource = this.resourceSet.createResource(URI
				.createURI("datamodel.xmi"));

		this.children = new Ensemble[3];
		for (int i = 0; i < this.children.length; i++) {
			this.children[i] = newEnsemble(i, "" + i);

			// this.parents[i].setParent((Ensemble) parentElement);
			Ensemble[] children = new Ensemble[3];
			for (int j = 0; j < children.length; j++) {
				children[j] = newEnsemble(i, "" + i + j);
				this.children[i].getChildren().add(children[j]);

				Ensemble[] children2 = new Ensemble[3];
				for (int k = 0; k < children2.length; k++) {
					children2[k] = newEnsemble(i, "" + i + j + k);
					this.children[i].getChildren().get(j).getChildren()
							.add(children2[k]);
				}

			}
		}
	}

	/**
	 * TODO: as initializeData, remove if persistence
	 */
	private Ensemble newEnsemble(int layer, String string) {
		DatamodelPackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		DatamodelFactory factory = DatamodelFactory.eINSTANCE;

		Ensemble ens = factory.createEnsemble();

		ens.setName(layer + ". Layer " + string);
		ens.setDescription("f safsahflljdsafl jsdaj fsj flksaj fljsa lfjas ldkjflsa jfdlksa jdflksajd fljdsa flksajd fl lskajdf lksajdfj flksajdflkjsad flksajd flksa jflksajd fsa "
				+ string); // Was Desc
		ens.setDerived(false);
		ens.setQuery("");

		// TODO persistence
		// this.resource.getContents().add(ens);

		return ens;
	}

}
