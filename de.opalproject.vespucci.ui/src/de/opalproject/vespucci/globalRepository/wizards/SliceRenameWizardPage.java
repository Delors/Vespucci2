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

public class SliceRenameWizardPage extends WizardPage {
	private Text text;
	private Composite container;

	/**
	 * The current name for the slice.
	 */
	private final String name;

	/**
	 * Creates a new page for the rename wizard.
	 * 
	 * @param eName
	 *            the current name of the object.
	 */
	public SliceRenameWizardPage(String eName) {
		super("Super First Page");
		setTitle("Rename Slice");
		setDescription("Choose a name for the Slice");
		name = eName;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Slice Name");

		text = new Text(container, SWT.BORDER | SWT.SINGLE);
		text.setText(name + "");
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!text.getText().isEmpty()) {
					setPageComplete(true);

				}
			}

		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

	/**
	 * @return String - the new name for the object to be renamed.
	 */
	public String getNewName() {
		return text.getText();
	}

	/**
	 * Disposes all allocated swt resources
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (text != null) {
			text.dispose();
		}
		if (container != null) {
			container.dispose();
		}
	}
}
