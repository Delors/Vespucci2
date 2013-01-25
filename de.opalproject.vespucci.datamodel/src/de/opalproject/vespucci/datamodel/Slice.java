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
package de.opalproject.vespucci.datamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Slice</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.opalproject.vespucci.datamodel.Slice#getName <em>Name</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Slice#getDiagram <em>Diagram
 * </em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Slice#getConstraints <em>
 * Constraints</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Slice#getEnsembles <em>Ensembles
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getSlice()
 * @model
 * @generated
 */
public interface Slice extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link de.opalproject.vespucci.datamodel.Constraint}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraints</em>' containment reference
	 *         list.
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getSlice_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Ensembles</b></em>' reference list. The
	 * list contents are of type
	 * {@link de.opalproject.vespucci.datamodel.Ensemble}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Ensembles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ensembles</em>' reference list.
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getSlice_Ensembles()
	 * @model
	 * @generated
	 */
	EList<Ensemble> getEnsembles();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getSlice_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram</em>' attribute.
	 * @see #setDiagram(String)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getSlice_Diagram()
	 * @model
	 * @generated
	 */
	String getDiagram();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getDiagram
	 * <em>Diagram</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Diagram</em>' attribute.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(String value);

} // Slice
