package de.opalproject.vespucci.sliceEditor;
 
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
 
public class ImageProvider extends AbstractImageProvider {
 
    // The prefix for all identifiers of this image provider
    protected static final String PREFIX = 
              "de.opalproject.vespucci.sliceEditor.";
 
    // The image identifier for a constraint
    public static final String IMG_CONSTRAINT = PREFIX + "constraint";
    
    // The image identifier for an Empty Ensemble
    public static final String IMG_EMPTYENSEMBLE = PREFIX + "emptyEnsemble";
    
    // The image identifier for a generic ensemble
    public static final String IMG_ENSEMBLEICON = PREFIX + "ensembleIcon";
 
    @Override
    protected void addAvailableImages() {
        // register the path for each image identifier
        addImageFilePath(IMG_CONSTRAINT, "res/arrow2.gif");
        addImageFilePath(IMG_EMPTYENSEMBLE, "res/EmptyEnsemble4.gif");
        addImageFilePath(IMG_ENSEMBLEICON, "res/Ensemble.gif");
    }
}

