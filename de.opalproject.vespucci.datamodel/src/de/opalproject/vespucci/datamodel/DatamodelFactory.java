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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage
 * @generated
 */
public interface DatamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	DatamodelFactory eINSTANCE = de.opalproject.vespucci.datamodel.impl.DatamodelFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Constraint</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Slice Repository</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Slice Repository</em>'.
	 * @generated
	 */
	SliceRepository createSliceRepository();

	/**
	 * Returns a new object of class '<em>Slice</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Slice</em>'.
	 * @generated
	 */
	Slice createSlice();

	/**
	 * Returns a new object of class '<em>Ensemble Repository</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Ensemble Repository</em>'.
	 * @generated
	 */
	EnsembleRepository createEnsembleRepository();

	/**
	 * Returns a new object of class '<em>Empty Ensemble</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Empty Ensemble</em>'.
	 * @generated
	 */
	EmptyEnsemble createEmptyEnsemble();

	/**
	 * Returns a new object of class '<em>Concrete Ensemble</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Concrete Ensemble</em>'.
	 * @generated
	 */
	ConcreteEnsemble createConcreteEnsemble();

	/**
	 * Returns an instance of data type '<em>Constraint Type</em>' corresponding
	 * the given literal. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            a literal of the data type.
	 * @return a new instance value of the data type.
	 * @generated
	 */
	ConstraintType createConstraintType(String literal);

	/**
	 * Returns a literal representation of an instance of data type '
	 * <em>Constraint Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param instanceValue
	 *            an instance value of the data type.
	 * @return a literal representation of the instance value.
	 * @generated
	 */
	String convertConstraintType(ConstraintType instanceValue);

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	DatamodelPackage getDatamodelPackage();

} // DatamodelFactory
