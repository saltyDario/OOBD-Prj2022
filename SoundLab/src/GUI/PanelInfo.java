package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInfo() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JLabel lblBenvenutoNelleInfo = new JLabel("BENVENUTO NELLE INFO");
		lblBenvenutoNelleInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenutoNelleInfo.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNelleInfo.setBounds(26, 11, 428, 109);
		add(lblBenvenutoNelleInfo);
	}

}
