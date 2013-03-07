package de.opalproject.vespucci.datamodel.validation.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IClientSelector;

/**
 * Selects all {@link EObject} belonging to the vespucci datamodell.
 * 
 * @author Marco Jacobasch
 */
public class ValidationDelegateClientSelector implements IClientSelector {

	/**
	 * namespace prefix to select if an object belongs to vespucci datamodell
	 */
	public static final String DATAMODEL_PACKAGE = "de.opalproject.vespucci.datamodel";

	/**
	 * Selects all objects which are an instance of {@link EObject} and matching
	 * the datamodell
	 */
	public boolean selects(Object object) {
		if (object instanceof EObject) {
			EObject eobject = (EObject) object;
			return eobject.eClass().getEPackage().getNsPrefix()
					.equals(DATAMODEL_PACKAGE);
		}
		return false;
	}
}
