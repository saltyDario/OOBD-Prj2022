package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelLibrary extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLibrary() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JLabel lblBenvenutoNellaLibreria = new JLabel("BENVENUTO NELLA LIBRERIA");
		lblBenvenutoNellaLibreria.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNellaLibreria.setBounds(10, 246, 428, 109);
		add(lblBenvenutoNellaLibreria);
	}

}
