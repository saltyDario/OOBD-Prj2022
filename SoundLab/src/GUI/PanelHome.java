package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class PanelHome extends JPanel {

	public PanelHome() {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(64, 0, 347, 57);
		add(panel_Title);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Arial", Font.BOLD, 29));
		lblHome.setBounds(8, 10, 331, 35);
		panel_Title.add(lblHome);
		
		JPanel esploraPanel = new JPanel();
		esploraPanel.setBackground(Color.GRAY);
		esploraPanel.setBounds(3, 69, 475, 515);
		add(esploraPanel);
		esploraPanel.setLayout(null);
		
		JPanel esploraArtistiPanel = new JPanel();
		esploraArtistiPanel.setBounds(10, 48, 135, 125);
		esploraPanel.add(esploraArtistiPanel);
		
		JPanel esploraTracce = new JPanel();
		esploraTracce.setBounds(155, 48, 135, 125);
		esploraPanel.add(esploraTracce);
		
		JPanel esploraAlbum = new JPanel();
		esploraAlbum.setBounds(300, 48, 135, 125);
		esploraPanel.add(esploraAlbum);
		
		JLabel lblEsplora = new JLabel("Esplora:");
		lblEsplora.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEsplora.setBounds(10, 11, 75, 29);
		esploraPanel.add(lblEsplora);
		setVisible(true);
	}
}
