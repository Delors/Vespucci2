package de.opalproject.vespucci.datamodel.provider.extension;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.opalproject.vespucci.datamodel.Slice;
import de.opalproject.vespucci.datamodel.provider.SliceItemProvider;

/**
 * Custom extension of the {@link SliceItemProvider} of the generated emf.edit
 * code
 * 
 * Used to not touch the generated code, instead subclass it an override the
 * needed methods
 * 
 * @author Marco Jacobasch
 * 
 */
public class SliceItemProviderExtension extends SliceItemProvider {

	public SliceItemProviderExtension(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Removes the classname "slice" from {@link Slice}
	 */
	@Override
	public String getText(Object object) {
		String label = ((Slice) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Slice_type")
				: label;
	}

}
