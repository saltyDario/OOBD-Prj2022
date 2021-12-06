package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setBounds(0, 0, 465, 573);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("BENVENUTO NELLA HOME");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel.setBounds(27, 245, 412, 109);
		add(lblNewLabel);
	}
}
