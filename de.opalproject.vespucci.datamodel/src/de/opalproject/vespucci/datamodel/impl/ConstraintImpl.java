/**
 */
package de.opalproject.vespucci.datamodel.impl;

import de.opalproject.vespucci.datamodel.Constraint;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.DatamodelPackage;
import de.opalproject.vespucci.datamodel.DependencyKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.ConstraintImpl#getConstraintType
 * <em>Constraint Type</em>}</li>
 * <li>
 * {@link de.opalproject.vespucci.datamodel.impl.ConstraintImpl#getDependencyKind
 * <em>Dependency Kind</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
	/**
	 * The default value of the '{@link #getConstraintType()
	 * <em>Constraint Type</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected static final ConstraintType CONSTRAINT_TYPE_EDEFAULT = ConstraintType.NOT_ALLOWED;

	/**
	 * The cached value of the '{@link #getConstraintType()
	 * <em>Constraint Type</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected ConstraintType constraintType = CONSTRAINT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependencyKind()
	 * <em>Dependency Kind</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDependencyKind()
	 * @generated
	 * @ordered
	 */
	protected static final DependencyKind DEPENDENCY_KIND_EDEFAULT = DependencyKind.ALL;

	/**
	 * The cached value of the '{@link #getDependencyKind()
	 * <em>Dependency Kind</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDependencyKind()
	 * @generated
	 * @ordered
	 */
	protected DependencyKind dependencyKind = DEPENDENCY_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatamodelPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintType getConstraintType() {
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintType(ConstraintType newConstraintType) {
		ConstraintType oldConstraintType = constraintType;
		constraintType = newConstraintType == null ? CONSTRAINT_TYPE_EDEFAULT
				: newConstraintType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE,
					oldConstraintType, constraintType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DependencyKind getDependencyKind() {
		return dependencyKind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDependencyKind(DependencyKind newDependencyKind) {
		DependencyKind oldDependencyKind = dependencyKind;
		dependencyKind = newDependencyKind == null ? DEPENDENCY_KIND_EDEFAULT
				: newDependencyKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND,
					oldDependencyKind, dependencyKind));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
			return getConstraintType();
		case DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND:
			return getDependencyKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
			setConstraintType((ConstraintType) newValue);
			return;
		case DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND:
			setDependencyKind((DependencyKind) newValue);
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
		case DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
			setConstraintType(CONSTRAINT_TYPE_EDEFAULT);
			return;
		case DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND:
			setDependencyKind(DEPENDENCY_KIND_EDEFAULT);
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
		case DatamodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
			return constraintType != CONSTRAINT_TYPE_EDEFAULT;
		case DatamodelPackage.CONSTRAINT__DEPENDENCY_KIND:
			return dependencyKind != DEPENDENCY_KIND_EDEFAULT;
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
		result.append(" (constraintType: ");
		result.append(constraintType);
		result.append(", dependencyKind: ");
		result.append(dependencyKind);
		result.append(')');
		return result.toString();
	}

} // ConstraintImpl
