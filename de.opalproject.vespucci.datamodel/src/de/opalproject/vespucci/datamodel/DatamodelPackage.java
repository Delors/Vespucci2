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
package de.opalproject.vespucci.datamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelFactory
 * @model kind="package"
 * @generated
 */
public interface DatamodelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "datamodel";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://de/opalproject/vespucci/datamodel/1.0";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "de.opalproject.vespucci.datamodel";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	DatamodelPackage eINSTANCE = de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.EnsembleImpl
	 * <em>Ensemble</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.EnsembleImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEnsemble()
	 * @generated
	 */
	int ENSEMBLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__DERIVED = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__QUERY = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__PARENT = 5;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__CONSTRAINTS = 6;

	/**
	 * The number of structural features of the '<em>Ensemble</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.ConstraintImpl
	 * <em>Constraint</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.ConstraintImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Constraint Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Dependency Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DEPENDENCY_KIND = 1;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.ConstraintType
	 * <em>Constraint Type</em>}' enum. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.ConstraintType
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConstraintType()
	 * @generated
	 */
	int CONSTRAINT_TYPE = 2;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.DependencyKind
	 * <em>Dependency Kind</em>}' enum. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.DependencyKind
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getDependencyKind()
	 * @generated
	 */
	int DEPENDENCY_KIND = 3;

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble <em>Ensemble</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ensemble</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble
	 * @generated
	 */
	EClass getEnsemble();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getName <em>Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getName()
	 * @see #getEnsemble()
	 * @generated
	 */
	EAttribute getEnsemble_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#isDerived
	 * <em>Derived</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Derived</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#isDerived()
	 * @see #getEnsemble()
	 * @generated
	 */
	EAttribute getEnsemble_Derived();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getDescription()
	 * @see #getEnsemble()
	 * @generated
	 */
	EAttribute getEnsemble_Description();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getQuery
	 * <em>Query</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getQuery()
	 * @see #getEnsemble()
	 * @generated
	 */
	EAttribute getEnsemble_Query();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getChildren
	 * <em>Children</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Children</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getChildren()
	 * @see #getEnsemble()
	 * @generated
	 */
	EReference getEnsemble_Children();

	/**
	 * Returns the meta object for the container reference '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getParent
	 * <em>Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getParent()
	 * @see #getEnsemble()
	 * @generated
	 */
	EReference getEnsemble_Parent();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getConstraints
	 * <em>Constraints</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Constraints</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getConstraints()
	 * @see #getEnsemble()
	 * @generated
	 */
	EReference getEnsemble_Constraints();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.Constraint <em>Constraint</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.opalproject.vespucci.datamodel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getConstraintType
	 * <em>Constraint Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Constraint Type</em>'.
	 * @see de.opalproject.vespucci.datamodel.Constraint#getConstraintType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_ConstraintType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getDependencyKind
	 * <em>Dependency Kind</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dependency Kind</em>'.
	 * @see de.opalproject.vespucci.datamodel.Constraint#getDependencyKind()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_DependencyKind();

	/**
	 * Returns the meta object for enum '
	 * {@link de.opalproject.vespucci.datamodel.ConstraintType
	 * <em>Constraint Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Constraint Type</em>'.
	 * @see de.opalproject.vespucci.datamodel.ConstraintType
	 * @generated
	 */
	EEnum getConstraintType();

	/**
	 * Returns the meta object for enum '
	 * {@link de.opalproject.vespucci.datamodel.DependencyKind
	 * <em>Dependency Kind</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Dependency Kind</em>'.
	 * @see de.opalproject.vespucci.datamodel.DependencyKind
	 * @generated
	 */
	EEnum getDependencyKind();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatamodelFactory getDatamodelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.EnsembleImpl
		 * <em>Ensemble</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.EnsembleImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEnsemble()
		 * @generated
		 */
		EClass ENSEMBLE = eINSTANCE.getEnsemble();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENSEMBLE__NAME = eINSTANCE.getEnsemble_Name();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENSEMBLE__DERIVED = eINSTANCE.getEnsemble_Derived();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENSEMBLE__DESCRIPTION = eINSTANCE.getEnsemble_Description();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENSEMBLE__QUERY = eINSTANCE.getEnsemble_Query();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENSEMBLE__CHILDREN = eINSTANCE.getEnsemble_Children();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENSEMBLE__PARENT = eINSTANCE.getEnsemble_Parent();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENSEMBLE__CONSTRAINTS = eINSTANCE.getEnsemble_Constraints();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.ConstraintImpl
		 * <em>Constraint</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.ConstraintImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Type</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONSTRAINT__CONSTRAINT_TYPE = eINSTANCE
				.getConstraint_ConstraintType();

		/**
		 * The meta object literal for the '<em><b>Dependency Kind</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONSTRAINT__DEPENDENCY_KIND = eINSTANCE
				.getConstraint_DependencyKind();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.ConstraintType
		 * <em>Constraint Type</em>}' enum. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.ConstraintType
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConstraintType()
		 * @generated
		 */
		EEnum CONSTRAINT_TYPE = eINSTANCE.getConstraintType();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.DependencyKind
		 * <em>Dependency Kind</em>}' enum. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.DependencyKind
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getDependencyKind()
		 * @generated
		 */
		EEnum DEPENDENCY_KIND = eINSTANCE.getDependencyKind();

	}

} // DatamodelPackage
