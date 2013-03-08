package de.opalproject.vespucci.globalRepository.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewEnsembleWizardQueryPage extends WizardPage {

	private static final int QUERY_HEIGTH = 200;

	private Text query;
	private Composite container;

	public NewEnsembleWizardQueryPage() {
		super("Second Page");
		setTitle("New Ensemble");
		setDescription("Enter query");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		Label queryLabel = new Label(container, SWT.NULL);
		queryLabel.setText("Query");
		queryLabel
				.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		query = new Text(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		query.setText("");
		query.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!query.getText().isEmpty()) {
					setPageComplete(true);

				}
			}

		});

		GridData queryGD = new GridData(GridData.FILL_HORIZONTAL);
		queryGD.heightHint = QUERY_HEIGTH;
		query.setLayoutData(queryGD);
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);

	}

	public String getEnsembleQuery() {
		return query.getText();
	}

	/**
	 * Disposes all allocated swt resources
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (container != null) {
			container.dispose();
		}
		if (query != null) {
			query.dispose();
		}
	}

}
