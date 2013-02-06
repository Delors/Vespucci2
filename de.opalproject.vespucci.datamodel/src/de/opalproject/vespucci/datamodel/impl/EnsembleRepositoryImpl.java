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
package de.opalproject.vespucci.datamodel.impl;

import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.EnsembleRepository;
import de.opalproject.vespucci.datamodel.TreeNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Ensemble Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link de.opalproject.vespucci.datamodel.impl.EnsembleRepositoryImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnsembleRepositoryImpl extends EObjectImpl implements
		EnsembleRepository {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeNode> children;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EnsembleRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.ENSEMBLE_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode getParent() {
		if (eContainerFeatureID() != DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT)
			return null;
		return (TreeNode) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TreeNode newParent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent,
				DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TreeNode newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this,
						DatamodelPackage.TREE_NODE__CHILDREN, TreeNode.class,
						msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT, newParent,
					newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<TreeNode>(
					TreeNode.class, this,
					DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN,
					DatamodelPackage.TREE_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((TreeNode) otherEnd, msgs);
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			return basicSetParent(null, msgs);
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			return eInternalContainer().eInverseRemove(this,
					DatamodelPackage.TREE_NODE__CHILDREN, TreeNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			return getParent();
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			setParent((TreeNode) newValue);
			return;
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends TreeNode>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			setParent((TreeNode) null);
			return;
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			getChildren().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DatamodelPackage.ENSEMBLE_REPOSITORY__PARENT:
			return getParent() != null;
		case DatamodelPackage.ENSEMBLE_REPOSITORY__CHILDREN:
			return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // EnsembleRepositoryImpl
