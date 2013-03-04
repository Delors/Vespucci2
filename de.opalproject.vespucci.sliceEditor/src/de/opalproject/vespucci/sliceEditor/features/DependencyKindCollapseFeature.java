/*
 * License (BSD Style License):
 * Copyright (c) 2012
 * Software Engineering
 * Department of Computer Science
 * Technische Universitiät Darmstadt
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Software Engineering Group or Technische
 * Universität Darmstadt nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package de.opalproject.vespucci.sliceEditor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;

/**
 * Feature to toggle visibility of constraint-kind labels displaying "ALL". 
 * 
 * @author marius-d
 *
 */
public class DependencyKindCollapseFeature extends AbstractCustomFeature {
	
	/**
	 * @param fp
	 */
	public DependencyKindCollapseFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.impl.AbstractFeature#getName()
	 */
	@Override
	public String getName() {
		
		return "Toggle \"ALL\" Constraint-Labels";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.custom.AbstractCustomFeature#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Hides all constraint-kind text labels displaying \"ALL\"";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.custom.AbstractCustomFeature#canExecute(org.eclipse.graphiti.features.context.ICustomContext)
	 */
	@Override
	public boolean canExecute(ICustomContext context) {
		// Check if clicking into a diagram
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			if (pes[0] instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.custom.AbstractCustomFeature#getImageId()
	 */
	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_EDIT_COLLAPSE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.features.custom.ICustomFeature#execute(org.eclipse.graphiti.features.context.ICustomContext)
	 */
	@Override
	public void execute(ICustomContext context) {
		// get pictogram elements from current context
		PictogramElement pictogramElements[] = context.getPictogramElements();
		// get the related diagram
		Diagram dia = (Diagram) pictogramElements[0];
		// default value as property reference saved in diagram to remember the current toggle state
		String collapsed = "false";

		// retrieve all connections
		EList<Connection> connections = dia.getConnections();
		for (Connection connection : connections) {
			// get all relevant connection decorators(text labels) out of the connections
			for (ConnectionDecorator cd : connection.getConnectionDecorators()) {
				if (cd.getGraphicsAlgorithm() instanceof Text
						) {
					// check which state is currently active and if the connection decorator holds the string "ALL"
					if (Graphiti.getPeService().getPropertyValue(dia, "dependenciescollapsed").equals("false") && ((Text) cd.getGraphicsAlgorithm()).getValue()
					.equals("ALL")) {
						// set visibility of those affected and set collapsed value to be stored in diagram to remember the state
						cd.setVisible(false);
						collapsed = "true";
					} else {
						cd.setVisible(true);
						collapsed = "false";
					}
				}
		
			}
			// save the new state in the diagram -> string collapsed
		} Graphiti.getPeService().setPropertyValue(dia, "dependenciescollapsed", collapsed);
	}
}