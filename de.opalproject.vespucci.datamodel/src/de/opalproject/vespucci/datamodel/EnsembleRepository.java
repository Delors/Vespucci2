/**
 */
package de.opalproject.vespucci.datamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Ensemble Repository</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.opalproject.vespucci.datamodel.EnsembleRepository#getContains
 * <em>Contains</em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getEnsembleRepository()
 * @model
 * @generated
 */
public interface EnsembleRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link de.opalproject.vespucci.datamodel.Ensemble}. It is bidirectional
	 * and its opposite is '
	 * {@link de.opalproject.vespucci.datamodel.Ensemble#getContainer
	 * <em>Container</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see de.opalproject.vespucci.datamodel.DatamodelPackage#getEnsembleRepository_Contains()
	 * @see de.opalproject.vespucci.datamodel.Ensemble#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Ensemble> getContains();

} // EnsembleRepository
