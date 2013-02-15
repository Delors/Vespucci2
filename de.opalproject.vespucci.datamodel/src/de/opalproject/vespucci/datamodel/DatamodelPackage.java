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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
	 * The package content type ID. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	String eCONTENT_TYPE = "vespucci";

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
	 * {@link de.opalproject.vespucci.datamodel.TreeNode <em>Tree Node</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.TreeNode
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getTreeNode()
	 * @generated
	 */
	int TREE_NODE = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__CHILDREN = 1;

	/**
	 * The number of structural features of the '<em>Tree Node</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble <em>Ensemble</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.Ensemble
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEnsemble()
	 * @generated
	 */
	int ENSEMBLE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__PARENT = TREE_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__CHILDREN = TREE_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__NAME = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__DERIVED = TREE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__DESCRIPTION = TREE_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__QUERY = TREE_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__CONSTRAINTS = TREE_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE__SLICES = TREE_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Ensemble</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TARGET = 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl
	 * <em>Slice Repository</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getSliceRepository()
	 * @generated
	 */
	int SLICE_REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE_REPOSITORY__SLICES = 0;

	/**
	 * The feature id for the '<em><b>Empty Ensemble</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE_REPOSITORY__EMPTY_ENSEMBLE = 1;

	/**
	 * The number of structural features of the '<em>Slice Repository</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE_REPOSITORY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.SliceImpl <em>Slice</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.SliceImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getSlice()
	 * @generated
	 */
	int SLICE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE__DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE__CONSTRAINTS = 2;

	/**
	 * The feature id for the '<em><b>Ensembles</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE__ENSEMBLES = 3;

	/**
	 * The feature id for the '<em><b>Slice Repository</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE__SLICE_REPOSITORY = 4;

	/**
	 * The number of structural features of the '<em>Slice</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLICE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl
	 * <em>Ensemble Repository</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEnsembleRepository()
	 * @generated
	 */
	int ENSEMBLE_REPOSITORY = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE_REPOSITORY__PARENT = TREE_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE_REPOSITORY__CHILDREN = TREE_NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Ensemble Repository</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENSEMBLE_REPOSITORY_FEATURE_COUNT = TREE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl
	 * <em>Empty Ensemble</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEmptyEnsemble()
	 * @generated
	 */
	int EMPTY_ENSEMBLE = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__PARENT = ENSEMBLE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__CHILDREN = ENSEMBLE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__NAME = ENSEMBLE__NAME;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__DERIVED = ENSEMBLE__DERIVED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__DESCRIPTION = ENSEMBLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__QUERY = ENSEMBLE__QUERY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__CONSTRAINTS = ENSEMBLE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE__SLICES = ENSEMBLE__SLICES;

	/**
	 * The number of structural features of the '<em>Empty Ensemble</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMPTY_ENSEMBLE_FEATURE_COUNT = ENSEMBLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link de.opalproject.vespucci.datamodel.impl.ConcreteEnsembleImpl
	 * <em>Concrete Ensemble</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.opalproject.vespucci.datamodel.impl.ConcreteEnsembleImpl
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConcreteEnsemble()
	 * @generated
	 */
	int CONCRETE_ENSEMBLE = 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__PARENT = ENSEMBLE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__CHILDREN = ENSEMBLE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__NAME = ENSEMBLE__NAME;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__DERIVED = ENSEMBLE__DERIVED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__DESCRIPTION = ENSEMBLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__QUERY = ENSEMBLE__QUERY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__CONSTRAINTS = ENSEMBLE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE__SLICES = ENSEMBLE__SLICES;

	/**
	 * The number of structural features of the '<em>Concrete Ensemble</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCRETE_ENSEMBLE_FEATURE_COUNT = ENSEMBLE_FEATURE_COUNT + 0;

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
	int CONSTRAINT_TYPE = 8;

	/**
	 * The meta object id for the '<em>EEnsemble</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see java.lang.Object
	 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEEnsemble()
	 * @generated
	 */
	int EENSEMBLE = 9;

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
	 * Returns the meta object for the reference list '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getConstraints
	 * <em>Constraints</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getConstraints()
	 * @see #getEnsemble()
	 * @generated
	 */
	EReference getEnsemble_Constraints();

	/**
	 * Returns the meta object for the reference list '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getSlices
	 * <em>Slices</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Slices</em>'.
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getSlices()
	 * @see #getEnsemble()
	 * @generated
	 */
	EReference getEnsemble_Slices();

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
	 * Returns the meta object for the reference '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getSource
	 * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.opalproject.vespucci.datamodel.Constraint#getSource()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Source();

	/**
	 * Returns the meta object for the reference '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getTarget
	 * <em>Target</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.opalproject.vespucci.datamodel.Constraint#getTarget()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Target();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.SliceRepository
	 * <em>Slice Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Slice Repository</em>'.
	 * @see de.opalproject.vespucci.datamodel.SliceRepository
	 * @generated
	 */
	EClass getSliceRepository();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link de.opalproject.vespucci.datamodel.SliceRepository#getSlices
	 * <em>Slices</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Slices</em>'.
	 * @see de.opalproject.vespucci.datamodel.SliceRepository#getSlices()
	 * @see #getSliceRepository()
	 * @generated
	 */
	EReference getSliceRepository_Slices();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link de.opalproject.vespucci.datamodel.SliceRepository#getEmptyEnsemble
	 * <em>Empty Ensemble</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '
	 *         <em>Empty Ensemble</em>'.
	 * @see de.opalproject.vespucci.datamodel.SliceRepository#getEmptyEnsemble()
	 * @see #getSliceRepository()
	 * @generated
	 */
	EReference getSliceRepository_EmptyEnsemble();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.Slice <em>Slice</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Slice</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice
	 * @generated
	 */
	EClass getSlice();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getConstraints
	 * <em>Constraints</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Constraints</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice#getConstraints()
	 * @see #getSlice()
	 * @generated
	 */
	EReference getSlice_Constraints();

	/**
	 * Returns the meta object for the reference list '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getEnsembles
	 * <em>Ensembles</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Ensembles</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice#getEnsembles()
	 * @see #getSlice()
	 * @generated
	 */
	EReference getSlice_Ensembles();

	/**
	 * Returns the meta object for the container reference '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getSliceRepository
	 * <em>Slice Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the container reference '
	 *         <em>Slice Repository</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice#getSliceRepository()
	 * @see #getSlice()
	 * @generated
	 */
	EReference getSlice_SliceRepository();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice#getName()
	 * @see #getSlice()
	 * @generated
	 */
	EAttribute getSlice_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link de.opalproject.vespucci.datamodel.Slice#getDiagram
	 * <em>Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Diagram</em>'.
	 * @see de.opalproject.vespucci.datamodel.Slice#getDiagram()
	 * @see #getSlice()
	 * @generated
	 */
	EAttribute getSlice_Diagram();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.EnsembleRepository
	 * <em>Ensemble Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Ensemble Repository</em>'.
	 * @see de.opalproject.vespucci.datamodel.EnsembleRepository
	 * @generated
	 */
	EClass getEnsembleRepository();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tree Node</em>'.
	 * @see de.opalproject.vespucci.datamodel.TreeNode
	 * @generated
	 */
	EClass getTreeNode();

	/**
	 * Returns the meta object for the container reference '
	 * {@link de.opalproject.vespucci.datamodel.TreeNode#getParent
	 * <em>Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.opalproject.vespucci.datamodel.TreeNode#getParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link de.opalproject.vespucci.datamodel.TreeNode#getChildren
	 * <em>Children</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Children</em>'.
	 * @see de.opalproject.vespucci.datamodel.TreeNode#getChildren()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Children();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.EmptyEnsemble
	 * <em>Empty Ensemble</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Empty Ensemble</em>'.
	 * @see de.opalproject.vespucci.datamodel.EmptyEnsemble
	 * @generated
	 */
	EClass getEmptyEnsemble();

	/**
	 * Returns the meta object for class '
	 * {@link de.opalproject.vespucci.datamodel.ConcreteEnsemble
	 * <em>Concrete Ensemble</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Concrete Ensemble</em>'.
	 * @see de.opalproject.vespucci.datamodel.ConcreteEnsemble
	 * @generated
	 */
	EClass getConcreteEnsemble();

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
	 * Returns the meta object for data type '{@link java.lang.Object
	 * <em>EEnsemble</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>EEnsemble</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getEEnsemble();

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
		 * {@link de.opalproject.vespucci.datamodel.Ensemble <em>Ensemble</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.Ensemble
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
		 * The meta object literal for the '<em><b>Constraints</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENSEMBLE__CONSTRAINTS = eINSTANCE.getEnsemble_Constraints();

		/**
		 * The meta object literal for the '<em><b>Slices</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENSEMBLE__SLICES = eINSTANCE.getEnsemble_Slices();

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
		 * The meta object literal for the '<em><b>Source</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__SOURCE = eINSTANCE.getConstraint_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT__TARGET = eINSTANCE.getConstraint_Target();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl
		 * <em>Slice Repository</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getSliceRepository()
		 * @generated
		 */
		EClass SLICE_REPOSITORY = eINSTANCE.getSliceRepository();

		/**
		 * The meta object literal for the '<em><b>Slices</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SLICE_REPOSITORY__SLICES = eINSTANCE
				.getSliceRepository_Slices();

		/**
		 * The meta object literal for the '<em><b>Empty Ensemble</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SLICE_REPOSITORY__EMPTY_ENSEMBLE = eINSTANCE
				.getSliceRepository_EmptyEnsemble();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.SliceImpl
		 * <em>Slice</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.SliceImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getSlice()
		 * @generated
		 */
		EClass SLICE = eINSTANCE.getSlice();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SLICE__CONSTRAINTS = eINSTANCE.getSlice_Constraints();

		/**
		 * The meta object literal for the '<em><b>Ensembles</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SLICE__ENSEMBLES = eINSTANCE.getSlice_Ensembles();

		/**
		 * The meta object literal for the '<em><b>Slice Repository</b></em>'
		 * container reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SLICE__SLICE_REPOSITORY = eINSTANCE
				.getSlice_SliceRepository();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SLICE__NAME = eINSTANCE.getSlice_Name();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SLICE__DIAGRAM = eINSTANCE.getSlice_Diagram();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl
		 * <em>Ensemble Repository</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEnsembleRepository()
		 * @generated
		 */
		EClass ENSEMBLE_REPOSITORY = eINSTANCE.getEnsembleRepository();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.TreeNode <em>Tree Node</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.TreeNode
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getTreeNode()
		 * @generated
		 */
		EClass TREE_NODE = eINSTANCE.getTreeNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_NODE__PARENT = eINSTANCE.getTreeNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_NODE__CHILDREN = eINSTANCE.getTreeNode_Children();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl
		 * <em>Empty Ensemble</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEmptyEnsemble()
		 * @generated
		 */
		EClass EMPTY_ENSEMBLE = eINSTANCE.getEmptyEnsemble();

		/**
		 * The meta object literal for the '
		 * {@link de.opalproject.vespucci.datamodel.impl.ConcreteEnsembleImpl
		 * <em>Concrete Ensemble</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.opalproject.vespucci.datamodel.impl.ConcreteEnsembleImpl
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getConcreteEnsemble()
		 * @generated
		 */
		EClass CONCRETE_ENSEMBLE = eINSTANCE.getConcreteEnsemble();

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
		 * The meta object literal for the '<em>EEnsemble</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.lang.Object
		 * @see de.opalproject.vespucci.datamodel.impl.DatamodelPackageImpl#getEEnsemble()
		 * @generated
		 */
		EDataType EENSEMBLE = eINSTANCE.getEEnsemble();

	}

} // DatamodelPackage
