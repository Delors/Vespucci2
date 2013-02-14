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

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.EmptyEnsemble;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Empty Ensemble</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getParent
 * <em>Parent</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getChildren
 * <em>Children</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#isDerived
 * <em>Derived</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getDescription
 * <em>Description</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getQuery
 * <em>Query</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.EmptyEnsembleImpl#getConstraints
 * <em>Constraints</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EmptyEnsembleImpl extends EObjectImpl implements EmptyEnsemble {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeNode> children;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isDerived() <em>Derived</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EmptyEnsembleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.EMPTY_ENSEMBLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TreeNode getParent() {
		if (eContainerFeatureID() != DatamodelPackage.EMPTY_ENSEMBLE__PARENT)
			return null;
		return (TreeNode) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(TreeNode newParent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent,
				DatamodelPackage.EMPTY_ENSEMBLE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(TreeNode newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != DatamodelPackage.EMPTY_ENSEMBLE__PARENT && newParent != null)) {
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
					DatamodelPackage.EMPTY_ENSEMBLE__PARENT, newParent,
					newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TreeNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<TreeNode>(
					TreeNode.class, this,
					DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN,
					DatamodelPackage.TREE_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.EMPTY_ENSEMBLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.EMPTY_ENSEMBLE__DERIVED, oldDerived,
					derived));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.EMPTY_ENSEMBLE__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.EMPTY_ENSEMBLE__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectResolvingEList<Constraint>(
					Constraint.class, this,
					DatamodelPackage.EMPTY_ENSEMBLE__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((TreeNode) otherEnd, msgs);
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			return basicSetParent(null, msgs);
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			return eInternalContainer().eInverseRemove(this,
					DatamodelPackage.TREE_NODE__CHILDREN, TreeNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			return getParent();
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			return getChildren();
		case DatamodelPackage.EMPTY_ENSEMBLE__NAME:
			return getName();
		case DatamodelPackage.EMPTY_ENSEMBLE__DERIVED:
			return isDerived();
		case DatamodelPackage.EMPTY_ENSEMBLE__DESCRIPTION:
			return getDescription();
		case DatamodelPackage.EMPTY_ENSEMBLE__QUERY:
			return getQuery();
		case DatamodelPackage.EMPTY_ENSEMBLE__CONSTRAINTS:
			return getConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			setParent((TreeNode) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends TreeNode>) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__NAME:
			setName((String) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__DERIVED:
			setDerived((Boolean) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__QUERY:
			setQuery((String) newValue);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__CONSTRAINTS:
			getConstraints().clear();
			getConstraints()
					.addAll((Collection<? extends Constraint>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			setParent((TreeNode) null);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			getChildren().clear();
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__DERIVED:
			setDerived(DERIVED_EDEFAULT);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__QUERY:
			setQuery(QUERY_EDEFAULT);
			return;
		case DatamodelPackage.EMPTY_ENSEMBLE__CONSTRAINTS:
			getConstraints().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DatamodelPackage.EMPTY_ENSEMBLE__PARENT:
			return getParent() != null;
		case DatamodelPackage.EMPTY_ENSEMBLE__CHILDREN:
			return children != null && !children.isEmpty();
		case DatamodelPackage.EMPTY_ENSEMBLE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case DatamodelPackage.EMPTY_ENSEMBLE__DERIVED:
			return derived != DERIVED_EDEFAULT;
		case DatamodelPackage.EMPTY_ENSEMBLE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case DatamodelPackage.EMPTY_ENSEMBLE__QUERY:
			return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT
					.equals(query);
		case DatamodelPackage.EMPTY_ENSEMBLE__CONSTRAINTS:
			return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", derived: ");
		result.append(derived);
		result.append(", description: ");
		result.append(description);
		result.append(", query: ");
		result.append(query);
		result.append(')');
		return result.toString();
	}

} // EmptyEnsembleImpl
