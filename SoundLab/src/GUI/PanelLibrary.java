package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Connessione.LibConnection;
import Modelli.Libreria;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PanelLibrary extends JPanel {
	
	private int numero_playlist;
	
	public PanelLibrary(String username, int id_utente) {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBounds(68, 0, 347, 57);
		add(panel_Title);
		panel_Title.setLayout(null);
		
		JLabel labelBenvenuto = new JLabel("Libreria di "+ username);
		labelBenvenuto.setForeground(Color.WHITE);
		labelBenvenuto.setBounds(8, 10, 331, 35);
		panel_Title.add(labelBenvenuto);
		labelBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		labelBenvenuto.setFont(new Font("Arial", Font.BOLD, 29));
		
		JPanel plusPanel = new JPanel();
		plusPanel.setToolTipText("Aggiungi Playlist.");
		plusPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				plusPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				plusPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				plusPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				plusPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPlaylist addplaylist = new AddPlaylist(id_utente, numero_playlist);
				System.out.println(""+ numero_playlist);
			}
		});
		plusPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		plusPanel.setBackground(Color.GRAY);
		plusPanel.setBounds(433, 72, 38, 37);
		add(plusPanel);
		plusPanel.setLayout(null);
		
		JLabel plusLabel = new JLabel("");
		plusLabel.setBounds(0, 0, 38, 37);
		plusPanel.add(plusLabel);
		plusLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/plus.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		plusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel refreshPanel = new JPanel();
		refreshPanel.setToolTipText("Refresh Playlist.");
		refreshPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refreshPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refreshPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				refreshPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				LibConnection libreria = new LibConnection();
				numero_playlist = libreria.ritornaLibreria(id_utente);
				
				Libreria libreria_utente = new Libreria(numero_playlist);
				System.out.println(""+ numero_playlist);
			}
		});
		refreshPanel.setLayout(null);
		refreshPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		refreshPanel.setBackground(Color.GRAY);
		refreshPanel.setBounds(396, 72, 38, 37);
		add(refreshPanel);
		
		JLabel refreshLabel = new JLabel("");
		refreshLabel.setBounds(0, 0, 38, 37);
		refreshPanel.add(refreshLabel);
		refreshLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/refreshing.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		
		JPanel playlistPanel = new JPanel();
		playlistPanel.setBackground(Color.GRAY);
		playlistPanel.setBounds(2, 113, 477, 473);
		add(playlistPanel);
		playlistPanel.setLayout(null);
	}
}
