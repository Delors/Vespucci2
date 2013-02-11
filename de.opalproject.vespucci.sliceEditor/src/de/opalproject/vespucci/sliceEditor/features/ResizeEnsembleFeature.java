package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Lars
 *
 */
public class ResizeEnsembleFeature extends DefaultResizeShapeFeature {
    
    /**
     * @param fp
     */
    public ResizeEnsembleFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature#canResizeShape(org.eclipse.graphiti.features.context.IResizeShapeContext)
     */
    @Override
    public boolean canResizeShape(IResizeShapeContext context) {
        boolean canResize = super.canResizeShape(context);
 
        // perform further check only if move allowed by default feature
        if (canResize) {
            // don't allow resize if the ensemble is collapsed
            Shape shape = context.getShape();
                if (Graphiti.getPeService().getPropertyValue(shape, "iscollapsed") == "true") {
                    canResize = false;
                }
            }
        return canResize;
    }
 }

