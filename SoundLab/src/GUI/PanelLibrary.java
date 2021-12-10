package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelLibrary extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLibrary() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JLabel lblBenvenutoNellaLibreria = new JLabel("BENVENUTO NELLA LIBRERIA");
		lblBenvenutoNellaLibreria.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenutoNellaLibreria.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNellaLibreria.setBounds(21, 11, 428, 109);
		add(lblBenvenutoNellaLibreria);
	}

}
