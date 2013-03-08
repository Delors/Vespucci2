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
package de.opalproject.vespucci.ui.sliceEditor.features.dark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.datamodel.Slice;

/**
 * This class is responsible for updating slices when ensembles are deleted and
 * thus the slices depicting the ensemble need to remove it.
 * 
 * @author marius
 * 
 */
public class DarkRemoveEnsemblesFeature extends RecordingCommand {

	private final List<Ensemble> ensembleList;

	/**
	 * @param editingDomain
	 *            - necessary for the constructor.
	 * @param ensembleList
	 *            - the deleted ensembles
	 */
	public DarkRemoveEnsemblesFeature(TransactionalEditingDomain editingDomain,
			List<Ensemble> ensembleList) {
		super(editingDomain);

		// retrieving all slices featuring the ensembles to be deleted
		this.ensembleList = ensembleList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		// retrieve all diagrams in which the ensemble appear
		for (Ensemble ens : ensembleList) {
			List<Diagram> diagramList = new ArrayList<Diagram>();
			for (Slice slice : ens.getSlices()) {
				diagramList.add((Diagram) slice.eResource().getEObject(
						slice.getDiagram()));
			}
			// Check if the ensemble is actually featured in any slice
			if (!(diagramList.size() == 0)) {
				// Get the feature provider.
				IFeatureProvider ftp = GraphitiUi.getExtensionManager()
						.createFeatureProvider(diagramList.get(0));
				// delete them in every diagram in which they appear
				for (Diagram dia : diagramList) {
					// retrieve linked picture elements
					// and eventually remove them.
					for (PictogramElement pe : (Collection<? extends PictogramElement>) Graphiti
							.getLinkService().getPictogramElements(dia, ens)) {
						RemoveContext removeContext = new RemoveContext(pe);
						IRemoveFeature removeFeature = ftp
								.getRemoveFeature(removeContext);
						if (!(removeFeature == null || removeContext == null)) {
							if (removeFeature.canRemove(removeContext)) {
								removeFeature.remove(removeContext);
							}
						}
					}
				}
			}
		}
	}
}
