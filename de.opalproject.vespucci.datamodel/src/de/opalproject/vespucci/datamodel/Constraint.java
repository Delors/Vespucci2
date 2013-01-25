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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.opalproject.vespucci.datamodel.Constraint#getConstraintType
 * <em>Constraint Type</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Constraint#getDependencyKind
 * <em>Dependency Kind</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Constraint#getSource <em>Source
 * </em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.Constraint#getTarget <em>Target
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link de.opalproject.vespucci.datamodel.ConstraintType}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Type</em>' attribute.
	 * @see de.opalproject.vespucci.datamodel.ConstraintType
	 * @see #setConstraintType(ConstraintType)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint_ConstraintType()
	 * @model
	 * @generated
	 */
	ConstraintType getConstraintType();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getConstraintType
	 * <em>Constraint Type</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Constraint Type</em>' attribute.
	 * @see de.opalproject.vespucci.datamodel.ConstraintType
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(ConstraintType value);

	/**
	 * Returns the value of the '<em><b>Dependency Kind</b></em>' attribute. The
	 * default value is <code>"ALL"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dependency Kind</em>' attribute.
	 * @see #setDependencyKind(String)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint_DependencyKind()
	 * @model default="ALL"
	 * @generated
	 */
	String getDependencyKind();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getDependencyKind
	 * <em>Dependency Kind</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Dependency Kind</em>' attribute.
	 * @see #getDependencyKind()
	 * @generated
	 */
	void setDependencyKind(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Ensemble)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint_Source()
	 * @model required="true"
	 * @generated
	 */
	Ensemble getSource();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getSource
	 * <em>Source</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Ensemble value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Ensemble)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint_Target()
	 * @model required="true"
	 * @generated
	 */
	Ensemble getTarget();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getTarget
	 * <em>Target</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Ensemble value);

} // Constraint
