package de.opalproject.vespucci.datamodel.provider.extension;

import org.eclipse.emf.common.notify.Adapter;

import de.opalproject.vespucci.datamodel.provider.ConcreteEnsembleItemProvider;
import de.opalproject.vespucci.datamodel.provider.DatamodelItemProviderAdapterFactory;
import de.opalproject.vespucci.datamodel.provider.SliceItemProvider;

/**
 * Custom extension of the {@link DatamodelItemProviderAdapterFactory} of the
 * generated emf.edit code
 * 
 * Used to not touch the generated code, instead subclass it an override the
 * needed methods
 * 
 * @author Marco Jacobasch
 * 
 */
public class DatamodelItemProviderAdapterFactoryExtension extends
		DatamodelItemProviderAdapterFactory {

	/**
	 * Override the {@link ConcreteEnsembleItemProvider} with our custom
	 * extension
	 */
	@Override
	public Adapter createConcreteEnsembleAdapter() {
		if (concreteEnsembleItemProvider == null) {
			concreteEnsembleItemProvider = new ConcreteEnsembleItemProviderExtension(
					this);
		}

		return concreteEnsembleItemProvider;
	}

	/**
	 * Override the {@link SliceItemProvider} with our custom extension
	 */
	@Override
	public Adapter createSliceAdapter() {
		if (sliceItemProvider == null) {
			sliceItemProvider = new SliceItemProviderExtension(this);
		}

		return sliceItemProvider;
	}
}
