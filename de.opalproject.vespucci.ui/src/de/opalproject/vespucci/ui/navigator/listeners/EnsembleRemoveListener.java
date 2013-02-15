/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ResourceLoadedListener.java,v 1.4 2007/11/14 18:13:57 cdamus Exp $
 */

package de.opalproject.vespucci.ui.navigator.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.opalproject.vespucci.datamodel.Ensemble;
import de.opalproject.vespucci.ui.editor.EnsembleEditor;
import de.opalproject.vespucci.ui.editor.EnsembleEditorInput;

/**
 * 
 * @author Marco Jacobasch
 */
public class EnsembleRemoveListener extends DemultiplexingListener {
	private static EnsembleRemoveListener instance;

	public EnsembleRemoveListener() {
		// TODO add NotificationFilter to recieve only remove events
		instance = this;
	}

	/**
	 * Returns the default listener instance.
	 * 
	 * @return the instance associated with the editing domain that manages the
	 *         specified resource set, or <code>null</code> if none is found
	 */
	public static EnsembleRemoveListener getDefault() {
		return instance;
	}

	@Override
	protected void handleNotification(TransactionalEditingDomain domain,
			Notification notification) {

		if (notification instanceof ENotificationImpl) {
			if (notification.getEventType() == ENotificationImpl.REMOVE
					&& notification.getOldValue() instanceof Ensemble) {
				final Ensemble ensemble = (Ensemble) notification.getOldValue();

				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						IWorkbenchPage page = getActivePage();
						Ensemble ens = ensemble;

						if (page != null) {
							IEditorReference[] editors = page.findEditors(
									new EnsembleEditorInput(ens),
									EnsembleEditor.ID, //$NON-NLS-1$
									IWorkbenchPage.MATCH_ID
											| IWorkbenchPage.MATCH_INPUT);

							page.closeEditors(editors, false);
						}
					}
				});

			}
		}
	}

	private IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;

		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();

			if (window != null) {
				result = window.getActivePage();
			}
		}

		return result;
	}
}
