package de.opalproject.vespucci.datamodel.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

public class NonEmptyNamesConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType != EMFEventType.NULL) {
			Object newValue = ctx.getFeatureNewValue();

			if (newValue == null || ((String) newValue).length() == 0) {
				return ctx.createFailureStatus(eObj.eClass().getName());
			}
		}

		return ctx.createSuccessStatus();
	}
}
