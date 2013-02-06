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
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.datamodel.SliceRepository;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Slice Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link de.opalproject.vespucci.datamodel.impl.SliceRepositoryImpl#getEmptyEnsemble <em>Empty Ensemble</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SliceRepositoryImpl extends EObjectImpl implements SliceRepository {
	/**
	 * The cached value of the '{@link #getSlices() <em>Slices</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSlices()
	 * @generated
	 * @ordered
	 */
	protected EList<Slice> slices;

	/**
	 * The cached value of the '{@link #getEmptyEnsemble() <em>Empty Ensemble</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmptyEnsemble()
	 * @generated
	 * @ordered
	 */
	protected Ensemble emptyEnsemble;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SliceRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.SLICE_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Slice> getSlices() {
		if (slices == null) {
			slices = new EObjectContainmentWithInverseEList<Slice>(Slice.class,
					this, DatamodelPackage.SLICE_REPOSITORY__SLICES,
					DatamodelPackage.SLICE__SLICE_REPOSITORY);
		}
		return slices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Ensemble getEmptyEnsemble() {
		return emptyEnsemble;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmptyEnsemble(Ensemble newEmptyEnsemble,
			NotificationChain msgs) {
		Ensemble oldEmptyEnsemble = emptyEnsemble;
		emptyEnsemble = newEmptyEnsemble;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE,
					oldEmptyEnsemble, newEmptyEnsemble);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmptyEnsemble(Ensemble newEmptyEnsemble) {
		if (newEmptyEnsemble != emptyEnsemble) {
			NotificationChain msgs = null;
			if (emptyEnsemble != null)
				msgs = ((InternalEObject) emptyEnsemble)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE,
								null, msgs);
			if (newEmptyEnsemble != null)
				msgs = ((InternalEObject) newEmptyEnsemble)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE,
								null, msgs);
			msgs = basicSetEmptyEnsemble(newEmptyEnsemble, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE,
					newEmptyEnsemble, newEmptyEnsemble));
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
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSlices())
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
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			return ((InternalEList<?>) getSlices()).basicRemove(otherEnd, msgs);
		case DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE:
			return basicSetEmptyEnsemble(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			return getSlices();
		case DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE:
			return getEmptyEnsemble();
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
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			getSlices().clear();
			getSlices().addAll((Collection<? extends Slice>) newValue);
			return;
		case DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE:
			setEmptyEnsemble((Ensemble) newValue);
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
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			getSlices().clear();
			return;
		case DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE:
			setEmptyEnsemble((Ensemble) null);
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
		case DatamodelPackage.SLICE_REPOSITORY__SLICES:
			return slices != null && !slices.isEmpty();
		case DatamodelPackage.SLICE_REPOSITORY__EMPTY_ENSEMBLE:
			return emptyEnsemble != null;
		}
		return super.eIsSet(featureID);
	}

} // SliceRepositoryImpl
