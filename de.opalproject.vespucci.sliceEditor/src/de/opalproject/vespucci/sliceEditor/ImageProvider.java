package de.opalproject.vespucci.sliceEditor;
 
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
 
public class ImageProvider extends AbstractImageProvider {
 
    // The prefix for all identifiers of this image provider
    protected static final String PREFIX = 
              "de.opalproject.vespucci.sliceEditor.";
 
    // The image identifier for an EReference.
    public static final String IMG_EREFERENCE = PREFIX + "ereference";
    
    // The image identifier for an Empty Ensemble
    public static final String IMG_EMPTYENSEMBLE = PREFIX + "emptyEnsemble";
 
    @Override
    protected void addAvailableImages() {
        // register the path for each image identifier
        addImageFilePath(IMG_EREFERENCE, "res/arrow2.gif");
        addImageFilePath(IMG_EMPTYENSEMBLE, "res/EmptyEnsemble4.gif");
    }
}

