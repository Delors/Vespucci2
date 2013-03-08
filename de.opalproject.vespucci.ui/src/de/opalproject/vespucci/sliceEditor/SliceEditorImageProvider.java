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
package de.opalproject.vespucci.sliceEditor;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

/**
 * Provides all the images stored in the res folder
 *
 * @author Lars, Marius
 *
 */
public class SliceEditorImageProvider extends AbstractImageProvider {

	// The prefix for all identifiers of this image provider
	protected static final String PREFIX = "de.opalproject.vespucci.sliceEditor.";

	// The image identifier for a constraint
	public static final String IMG_CONSTRAINT = PREFIX + "constraint";

	// The image identifier for a constraint
	public static final String IMG_NOTALLOWED = PREFIX + "notAllowedConstraint";
	public static final String IMG_GLOBALINCOMING = PREFIX
			+ "globalIncomingConstraint";
	public static final String IMG_LOCALINCOMING = PREFIX
			+ "localIncomingConstraint";
	public static final String IMG_GLOBALOUTGOING = PREFIX
			+ "globalOutgoingConstraint";
	public static final String IMG_LOCALOUTGOING = PREFIX
			+ "localOutgoingConstraint";
	public static final String IMG_EXPECTED = PREFIX + "expectedConstraint";

	// The image identifier for an Empty Ensemble
	public static final String IMG_EMPTYENSEMBLE = PREFIX + "emptyEnsemble";

	// The image identifier for a generic ensemble
	public static final String IMG_ENSEMBLEICON = PREFIX + "ensembleIcon";

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.platform.AbstractImageProvider#addAvailableImages()
	 */
	@Override
	protected void addAvailableImages() {
		// register the path for each image identifier
		addImageFilePath(IMG_CONSTRAINT, "res/arrow2.gif");
		addImageFilePath(IMG_GLOBALINCOMING,
				"res/ConstraintIcons/GlobalIncoming.gif");
		addImageFilePath(IMG_GLOBALOUTGOING,
				"res/ConstraintIcons/GlobalOutgoing.gif");
		addImageFilePath(IMG_LOCALINCOMING,
				"res/ConstraintIcons/Incoming.gif");
		addImageFilePath(IMG_LOCALOUTGOING,
				"res/ConstraintIcons/Outgoing.gif");
		addImageFilePath(IMG_EXPECTED, "res/ConstraintIcons/Expected.gif");
		addImageFilePath(IMG_NOTALLOWED,
				"res/ConstraintIcons/NotAllowed.gif");
		addImageFilePath(IMG_EMPTYENSEMBLE,
				"res/EmptyEnsemble4.gif");
		addImageFilePath(IMG_ENSEMBLEICON,
				"res/Ensemble.gif");
	}
}
