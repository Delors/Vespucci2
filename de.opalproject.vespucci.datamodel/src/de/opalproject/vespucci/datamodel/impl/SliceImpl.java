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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.datamodel.SliceRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Slice</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.SliceImpl#getName <em>Name
 * </em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.SliceImpl#getDiagram <em>
 * Diagram</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.SliceImpl#getConstraints
 * <em>Constraints</em>}</li>
 * <li>{@link de.opalproject.vespucci.datamodel.impl.SliceImpl#getEnsembles <em>
 * Ensembles</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.SliceImpl#getSliceRepository
 * <em>Slice Repository</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SliceImpl extends EObjectImpl implements Slice {
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
	 * The default value of the '{@link #getDiagram() <em>Diagram</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected String diagram = DIAGRAM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getEnsembles() <em>Ensembles</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEnsembles()
	 * @generated
	 * @ordered
	 */
	protected EList<Ensemble> ensembles;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SliceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.SLICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(
					Constraint.class, this, DatamodelPackage.SLICE__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Ensemble> getEnsembles() {
		if (ensembles == null) {
			ensembles = new EObjectWithInverseResolvingEList.ManyInverse<Ensemble>(
					Ensemble.class, this, DatamodelPackage.SLICE__ENSEMBLES,
					DatamodelPackage.ENSEMBLE__SLICES);
		}
		return ensembles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SliceRepository getSliceRepository() {
		if (eContainerFeatureID() != DatamodelPackage.SLICE__SLICE_REPOSITORY)
			return null;
		return (SliceRepository) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSliceRepository(
			SliceRepository newSliceRepository, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSliceRepository,
				DatamodelPackage.SLICE__SLICE_REPOSITORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSliceRepository(SliceRepository newSliceRepository) {
		if (newSliceRepository != eInternalContainer()
				|| (eContainerFeatureID() != DatamodelPackage.SLICE__SLICE_REPOSITORY && newSliceRepository != null)) {
			if (EcoreUtil.isAncestor(this, newSliceRepository))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSliceRepository != null)
				msgs = ((InternalEObject) newSliceRepository).eInverseAdd(this,
						DatamodelPackage.SLICE_REPOSITORY__SLICES,
						SliceRepository.class, msgs);
			msgs = basicSetSliceRepository(newSliceRepository, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.SLICE__SLICE_REPOSITORY,
					newSliceRepository, newSliceRepository));
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
		case DatamodelPackage.SLICE__ENSEMBLES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEnsembles())
					.basicAdd(otherEnd, msgs);
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetSliceRepository((SliceRepository) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
					DatamodelPackage.SLICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagram(String newDiagram) {
		String oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.SLICE__DIAGRAM, oldDiagram, diagram));
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
		case DatamodelPackage.SLICE__CONSTRAINTS:
			return ((InternalEList<?>) getConstraints()).basicRemove(otherEnd,
					msgs);
		case DatamodelPackage.SLICE__ENSEMBLES:
			return ((InternalEList<?>) getEnsembles()).basicRemove(otherEnd,
					msgs);
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			return basicSetSliceRepository(null, msgs);
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
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			return eInternalContainer().eInverseRemove(this,
					DatamodelPackage.SLICE_REPOSITORY__SLICES,
					SliceRepository.class, msgs);
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
		case DatamodelPackage.SLICE__NAME:
			return getName();
		case DatamodelPackage.SLICE__DIAGRAM:
			return getDiagram();
		case DatamodelPackage.SLICE__CONSTRAINTS:
			return getConstraints();
		case DatamodelPackage.SLICE__ENSEMBLES:
			return getEnsembles();
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			return getSliceRepository();
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
		case DatamodelPackage.SLICE__NAME:
			setName((String) newValue);
			return;
		case DatamodelPackage.SLICE__DIAGRAM:
			setDiagram((String) newValue);
			return;
		case DatamodelPackage.SLICE__CONSTRAINTS:
			getConstraints().clear();
			getConstraints()
					.addAll((Collection<? extends Constraint>) newValue);
			return;
		case DatamodelPackage.SLICE__ENSEMBLES:
			getEnsembles().clear();
			getEnsembles().addAll((Collection<? extends Ensemble>) newValue);
			return;
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			setSliceRepository((SliceRepository) newValue);
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
		case DatamodelPackage.SLICE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DatamodelPackage.SLICE__DIAGRAM:
			setDiagram(DIAGRAM_EDEFAULT);
			return;
		case DatamodelPackage.SLICE__CONSTRAINTS:
			getConstraints().clear();
			return;
		case DatamodelPackage.SLICE__ENSEMBLES:
			getEnsembles().clear();
			return;
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			setSliceRepository((SliceRepository) null);
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
		case DatamodelPackage.SLICE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case DatamodelPackage.SLICE__DIAGRAM:
			return DIAGRAM_EDEFAULT == null ? diagram != null
					: !DIAGRAM_EDEFAULT.equals(diagram);
		case DatamodelPackage.SLICE__CONSTRAINTS:
			return constraints != null && !constraints.isEmpty();
		case DatamodelPackage.SLICE__ENSEMBLES:
			return ensembles != null && !ensembles.isEmpty();
		case DatamodelPackage.SLICE__SLICE_REPOSITORY:
			return getSliceRepository() != null;
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
		result.append(", diagram: ");
		result.append(diagram);
		result.append(')');
		return result.toString();
	}

} // SliceImpl
