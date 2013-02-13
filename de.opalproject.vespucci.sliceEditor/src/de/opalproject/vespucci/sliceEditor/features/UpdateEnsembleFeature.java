package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * Feature to handle graphical updates of ensemble elements upon detected changes.
 * 
 * @author Lars
 * @author Marius
 *
 */
public class UpdateEnsembleFeature extends AbstractUpdateFeature {
 
    /**
     * @param fp
     */
    public UpdateEnsembleFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.graphiti.func.IUpdate#canUpdate(org.eclipse.graphiti.features.context.IUpdateContext)
     */
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a Ensemble
        Object bo =
            getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof Ensemble);
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.graphiti.func.IUpdate#updateNeeded(org.eclipse.graphiti.features.context.IUpdateContext)
     */
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        // and retrieve description from pictogram model
        String pictogramDescription = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramName = text.getValue();
                }
                if (shape.getGraphicsAlgorithm() instanceof MultiText){
                	MultiText multiText = (MultiText) shape.getGraphicsAlgorithm();
                	pictogramDescription = multiText.getValue();
                }
            }
        }
 
        // retrieve name and description from business model
        String businessName = null;
        String businessDescription = null;
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Ensemble) {
            Ensemble ensemble = (Ensemble) bo;
            businessName = ensemble.getName();
            businessDescription = ensemble.getDescription();
        }
        

 
        // update needed, if names or description are different
        boolean updateNameNeeded =
            ((pictogramName == null && businessName != null) || 
                (pictogramName != null && !pictogramName.equals(businessName)));
        boolean updateDescriptionNeeded =  ((pictogramDescription == null && businessDescription != null) || 
                (pictogramDescription != null && !pictogramDescription.equals(businessDescription)));
        if (updateNameNeeded) {
            return Reason.createTrueReason("Name is out of date");
        }
        else if(updateDescriptionNeeded){
        	return Reason.createTrueReason("Description is out of date");
        }else {
            return Reason.createFalseReason();
        }
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.graphiti.func.IUpdate#update(org.eclipse.graphiti.features.context.IUpdateContext)
     */
    public boolean update(IUpdateContext context) {
        // retrieve name and description from business model
        String businessName = null;
        String businessDescription = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Ensemble) {
        	Ensemble ensemble = (Ensemble) bo;
            businessName = ensemble.getName();
            businessDescription = ensemble.getDescription();
        }
 
        
        // Set name and description in pictogram model
        boolean nameUpdated = false;
        boolean descriptionUpdated = false;
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    nameUpdated = true;
                }
                if (shape.getGraphicsAlgorithm() instanceof MultiText) {
                	 MultiText multiText = (MultiText) shape.getGraphicsAlgorithm();
                     multiText.setValue(businessDescription);
                     descriptionUpdated = true;
                }
                if(nameUpdated && descriptionUpdated){
                	return true;
                }
            }
        }
 
        return false;
    }
} 

