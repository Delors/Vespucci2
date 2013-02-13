package de.opalproject.vespucci.datamodel.validation.constraints;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * Selects constraints for the constraint binding when the
 * {@link org.eclipse.emf.validation.examples.general.actions.BatchValidationDelegate}
 * or the {@link LiveValidationContentAdapter} was the entry point into
 * validation.
 * 
 * @author Chris McGee
 */
public class ValidationDelegateClientSelector

// NOTE: This is _NOT_ a recommended approach to writing a client selector.
// Suggested approaches:
// -Check the resource of the EObject either by identity or by URI
// as long as this resource is somehow unique to this application
// -Check the identity of the resource set to ensure that it is some
// private object
// -Check the identity of the EObject itself to see if it belongs to
// some private collection
// -Check the EClass of the EObject but only if the metamodel is private
// to this application and will not be used by other contexts

		implements IClientSelector {

	public static boolean running = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.validation.model.IClientSelector#selects(java.lang.Object
	 * )
	 */
	public boolean selects(Object object) {
		return running;
	}
}
