package de.opalproject.vespucci.datamodel.provider.extension;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.opalproject.vespucci.datamodel.ConcreteEnsemble;
import de.opalproject.vespucci.datamodel.provider.ConcreteEnsembleItemProvider;

/**
 * Custom extension of the {@link ConcreteEnsembleItemProvider} of the generated
 * emf.edit code
 * 
 * Used to not touch the generated code, instead subclass it an override the
 * needed methods
 * 
 * @author Marco Jacobasch
 * 
 */
public class ConcreteEnsembleItemProviderExtension extends
		ConcreteEnsembleItemProvider {

	public ConcreteEnsembleItemProviderExtension(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Removes the classname "concrete ensemble" from {@link ConcreteEnsemble}
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConcreteEnsemble) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ConcreteEnsemble_type")
				: label;
	}
}
