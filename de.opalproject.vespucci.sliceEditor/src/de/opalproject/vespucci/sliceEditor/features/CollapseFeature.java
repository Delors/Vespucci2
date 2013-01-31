package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import de.opalproject.vespucci.datamodel.Ensemble;

public class CollapseFeature extends AbstractCustomFeature {

	public CollapseFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Ensemble) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_EDIT_COLLAPSE;
	}

	@Override
	public void execute(ICustomContext context) {
		
		PictogramElement pictogramElements [] = context.getPictogramElements();
		
		for(PictogramElement pe : pictogramElements)
		{
			if (pe instanceof ContainerShape) {

				if (Graphiti.getPeService().getPropertyValue(pe, "iscollapsed").equals("false")) {
					int width = pe.getGraphicsAlgorithm().getWidth();
					int height = pe.getGraphicsAlgorithm().getHeight();
					Graphiti.getPeService().setPropertyValue(pe, "initial_width",
							String.valueOf(width));
					Graphiti.getPeService().setPropertyValue(pe, "initial_height",
							String.valueOf(height));
					Graphiti.getPeService().setPropertyValue(pe, "iscollapsed", "true");
					
					pe.getGraphicsAlgorithm().setHeight(20);
					pe.getGraphicsAlgorithm().setWidth(100);

				} else {
					pe.getGraphicsAlgorithm().setWidth(
							Integer.parseInt(Graphiti.getPeService().getPropertyValue(pe, "initial_width")));
					pe.getGraphicsAlgorithm().setHeight(
							Integer.parseInt(Graphiti.getPeService().getPropertyValue(pe, "initial_height")));
					Graphiti.getPeService().setPropertyValue(pe, "iscollapsed", "false");
					}
				}
			}	

	}
}