package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("BENVENUTO NELLA HOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel.setBounds(37, 11, 412, 109);
		add(lblNewLabel);
	}
}
