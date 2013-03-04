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

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * Collapse Ensembles
 * 
 * @author Lars
 * 
 */
public class CollapseFeature extends AbstractCustomFeature {

	public CollapseFeature(IFeatureProvider fp) {
		super(fp);
	}

	// used by tooltip
	@Override
	public String getName() {
		return "Collapse Ensemble-Description";
	}

	// used by tooltip
	@Override
	public String getDescription() {
		return "Collapses the description area of an ensemble";
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

		PictogramElement pictogramElements[] = context.getPictogramElements();

		for (PictogramElement pe : pictogramElements) {
			if (pe instanceof ContainerShape) {
				// graphiti provides some sort of datatable in the PEService
				// we use this to store the state "iscollapsed" and the
				// former width and height
				if (Graphiti.getPeService().getPropertyValue(pe, "iscollapsed")
						.equals("false")) {
					int width = pe.getGraphicsAlgorithm().getWidth();
					int height = pe.getGraphicsAlgorithm().getHeight();
					Graphiti.getPeService().setPropertyValue(pe,
							"initial_width", String.valueOf(width));
					Graphiti.getPeService().setPropertyValue(pe,
							"initial_height", String.valueOf(height));
					Graphiti.getPeService().setPropertyValue(pe, "iscollapsed",
							"true");

					pe.getGraphicsAlgorithm().setHeight(20);
					pe.getGraphicsAlgorithm().setWidth(100);

				} else {
					pe.getGraphicsAlgorithm().setWidth(
							Integer.parseInt(Graphiti.getPeService()
									.getPropertyValue(pe, "initial_width")));
					pe.getGraphicsAlgorithm().setHeight(
							Integer.parseInt(Graphiti.getPeService()
									.getPropertyValue(pe, "initial_height")));
					Graphiti.getPeService().setPropertyValue(pe, "iscollapsed",
							"false");
				}
			}
		}

	}
}