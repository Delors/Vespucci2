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
package de.opalproject.vespucci.ui.sliceEditor.features.constraints;

import org.eclipse.graphiti.features.IFeatureProvider;

import de.opalproject.vespucci.datamodel.ConcreteEnsemble;
import de.opalproject.vespucci.datamodel.ConstraintType;
import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.ui.sliceEditor.SliceEditorImageProvider;

/**
 * Checks if it is possible to add a "Local Incoming" Constraint between two ensembles and does so.
 * Concrete Implementation of the CreateConstraintFeature for the "Local Incoming" Constraint
 * @author Roman Uhlig, Marius
 *
 */
public class CreateLocalIncomingConstraintFeature extends
		CreateConstraintFeature {

	public CreateLocalIncomingConstraintFeature(IFeatureProvider fp) {
		// provide name and description for the UI, e.g. the palette
		super(fp, "Local Incoming", "Create Local Incoming Constraint",
				ConstraintType.LOCAL_INCOMING);
	}

	@Override
	public String getCreateImageId() {
		return SliceEditorImageProvider.IMG_LOCALINCOMING;
	}

	@Override
	protected boolean isAnchorSensibleSource(Ensemble ensemble) {
		return true;
	}

	@Override
	protected boolean isAnchorSensibleTarget(Ensemble ensemble) {
		return ensemble instanceof ConcreteEnsemble;
	}
}
