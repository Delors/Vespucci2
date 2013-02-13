package de.opalproject.vespucci.sliceEditor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class SliceUpdateBehavior extends DefaultUpdateBehavior {
	

	public SliceUpdateBehavior(DiagramEditor diagramEditor) {
		super(diagramEditor);
	}

	@Override
	protected void createEditingDomain() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("de.opalproject.vespucci.navigator.domain.DatamodelEditingDomain");
		initializeEditingDomain(domain);
	}

	@Override
	protected void disposeEditingDomain() {
		// static domain, dispose not possible
	}
}
