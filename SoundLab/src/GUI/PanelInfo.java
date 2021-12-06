package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInfo() {
		setBounds(0, 0, 465, 573);
		setLayout(null);
		
		JLabel lblBenvenutoNelleInfo = new JLabel("BENVENUTO NELLE INFO");
		lblBenvenutoNelleInfo.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNelleInfo.setBounds(10, 220, 428, 109);
		add(lblBenvenutoNelleInfo);
	}

}
