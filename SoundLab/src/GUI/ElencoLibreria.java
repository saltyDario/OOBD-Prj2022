package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JButton;

public class ElencoLibreria extends JPanel {

	private JPanel panel;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ElencoLibreria(int id_utente, String username) {
		setBounds(0, 0, 481, 592);
		panel=this;
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		contentPane.add(table);
		
		JButton btnOK = new JButton("OK");
		add(btnOK);
		

	}

}
