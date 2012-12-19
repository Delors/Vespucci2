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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import de.opalproject.vespucci.datamodel.Ensemble;

/**
 * This feature allows to create new EReference links
 * 
 * @author Lars
 * 
 */
public class CreateEReferenceFeature extends AbstractCreateConnectionFeature {

	/*
	 * constructor
	 */
	public CreateEReferenceFeature(IFeatureProvider fp) {
		// provide name and description for the UI, e.g. the palette
		super(fp, "Connection", "Create EReference");
	}
	
	@Override
	public String getCreateImageId() {
		return "de.opalproject.vespucci.sliceEditor.ereference";
	}

	/*
	 * checks if both anchors belong to an Ensemble and those Ensembles are not
	 * identical
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#canCreate(org.eclipse.graphiti
	 * .features.context.ICreateConnectionContext)
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext context) {

		Ensemble source = getEnsemble(context.getSourceAnchor());
		Ensemble target = getEnsemble(context.getTargetAnchor());
		if (source != null && target != null && source != target) {
			return true;
		}
		return false;
	}

	/*
	 * checks if start anchor belongs to a Ensemble
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#canStartConnection(org.eclipse
	 * .graphiti.features.context.ICreateConnectionContext)
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getEnsemble(context.getSourceAnchor()) != null) {
			return true;
		}
		return false;
	}

	/*
	 * create the connection
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.ICreateConnection#create(org.eclipse.graphiti
	 * .features.context.ICreateConnectionContext)
	 */
	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// get ensembles which should be connected
		Ensemble source = getEnsemble(context.getSourceAnchor());
		Ensemble target = getEnsemble(context.getTargetAnchor());

		if (source != null && target != null) {
			// create new business object
			EReference eReference = createEReference(source, target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(eReference);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
		}

		return newConnection;
	}

	/**
	 * Returns the Ensemble belonging to the anchor, or null if not available.
	 */
	private Ensemble getEnsemble(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor
					.getParent());
			if (object instanceof Ensemble) {
				return (Ensemble) object;
			}
		}
		return null;
	}

	/**
	 * Creates a EReference between two ensembles.
	 */
	private EReference createEReference(Ensemble source, Ensemble target) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName("new EReference");
		eReference.setEType(target.eClass());
		eReference.setLowerBound(0);
		eReference.setUpperBound(1);
		getDiagram().eResource().getContents().add(eReference);
		//source.eClass().getEStructuralFeatures().add(eReference);
		return eReference;
	}
}
