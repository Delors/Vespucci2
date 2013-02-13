package de.opalproject.vespucci.sliceEditor;

import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class SliceDiagramEditor extends DiagramEditor {

	public static String DIAGRAM_EDITOR_ID = "de.opalproject.vespucci.sliceEditor";

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new SliceUpdateBehavior(this);
	}

}
