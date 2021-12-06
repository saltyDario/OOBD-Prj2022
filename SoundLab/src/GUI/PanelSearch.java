package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelSearch extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JLabel lblBenvenutoNellaRicerca = new JLabel("BENVENUTO NELLA RICERCA");
		lblBenvenutoNellaRicerca.setFont(new Font("Arial", Font.BOLD, 29));
		lblBenvenutoNellaRicerca.setBounds(10, 239, 428, 109);
		add(lblBenvenutoNellaRicerca);
	}

}
