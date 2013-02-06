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
package de.opalproject.vespucci.datamodel.util;

import de.opalproject.vespucci.datamodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage
 * @generated
 */
public class DatamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DatamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DatamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DatamodelSwitch<Adapter> modelSwitch = new DatamodelSwitch<Adapter>() {
		@Override
		public Adapter caseEnsemble(Ensemble object) {
			return createEnsembleAdapter();
		}

		@Override
		public Adapter caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		@Override
		public Adapter caseSliceRepository(SliceRepository object) {
			return createSliceRepositoryAdapter();
		}

		@Override
		public Adapter caseSlice(Slice object) {
			return createSliceAdapter();
		}

		@Override
		public Adapter caseEnsembleRepository(EnsembleRepository object) {
			return createEnsembleRepositoryAdapter();
		}

		@Override
		public Adapter caseTreeNode(TreeNode object) {
			return createTreeNodeAdapter();
		}

		@Override
		public Adapter caseEmptyEnsemble(EmptyEnsemble object) {
			return createEmptyEnsembleAdapter();
		}

		@Override
		public Adapter caseConcreteEnsemble(ConcreteEnsemble object) {
			return createConcreteEnsembleAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.Ensemble <em>Ensemble</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.Ensemble
	 * @generated
	 */
	public Adapter createEnsembleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.SliceRepository <em>Slice Repository</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.SliceRepository
	 * @generated
	 */
	public Adapter createSliceRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link de.opalproject.vespucci.datamodel.Slice <em>Slice</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.Slice
	 * @generated
	 */
	public Adapter createSliceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.EnsembleRepository <em>Ensemble Repository</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.EnsembleRepository
	 * @generated
	 */
	public Adapter createEnsembleRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.TreeNode
	 * @generated
	 */
	public Adapter createTreeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.EmptyEnsemble <em>Empty Ensemble</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.EmptyEnsemble
	 * @generated
	 */
	public Adapter createEmptyEnsembleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.opalproject.vespucci.datamodel.ConcreteEnsemble <em>Concrete Ensemble</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.opalproject.vespucci.datamodel.ConcreteEnsemble
	 * @generated
	 */
	public Adapter createConcreteEnsembleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // DatamodelAdapterFactory
