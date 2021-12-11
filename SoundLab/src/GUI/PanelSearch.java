package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelSearch extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JLabel lblBenvenutoNellaRicerca = new JLabel("BENVENUTO NELLA RICERCA");
		lblBenvenutoNellaRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenutoNellaRicerca.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNellaRicerca.setBounds(20, 11, 428, 109);
		add(lblBenvenutoNellaRicerca);
	}

}
