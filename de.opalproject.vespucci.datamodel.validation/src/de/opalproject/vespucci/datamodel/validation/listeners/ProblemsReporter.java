package de.opalproject.vespucci.datamodel.validation.listeners;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;

import de.opalproject.vespucci.datamodel.validation.Activator;

public class ProblemsReporter implements IValidationListener {
	public void validationOccurred(ValidationEvent event) {
		if (event.matches(IStatus.INFO | IStatus.WARNING | IStatus.ERROR)) {
			List<IConstraintStatus> results = event.getValidationResults();

			for (IConstraintStatus object : results) {
				try {
					MarkerUtil.updateMarkers(object);
				} catch (CoreException e) {
					Activator
							.getDefault()
							.getLog()
							.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									Arrays.toString(e.getStackTrace())));
				}
			}
		}

	}

}