/**
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
	 * default value is <code>"0"</code>. The literals are from the enumeration
	 * {@link de.opalproject.vespucci.datamodel.DependencyKind}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dependency Kind</em>' attribute.
	 * @see de.opalproject.vespucci.datamodel.DependencyKind
	 * @see #setDependencyKind(DependencyKind)
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getConstraint_DependencyKind()
	 * @model default="0"
	 * @generated
	 */
	DependencyKind getDependencyKind();

	/**
	 * Sets the value of the '
	 * {@link de.opalproject.vespucci.datamodel.Constraint#getDependencyKind
	 * <em>Dependency Kind</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Dependency Kind</em>' attribute.
	 * @see de.opalproject.vespucci.datamodel.DependencyKind
	 * @see #getDependencyKind()
	 * @generated
	 */
	void setDependencyKind(DependencyKind value);

} // Constraint
