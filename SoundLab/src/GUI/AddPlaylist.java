package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.PlaylistDAO;
import ImplementazioniPostgresDAO.PlaylistConnectionDAO;
import Modelli.Playlist;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPlaylist extends JDialog {
 
	private int mouseX, mouseY;
	private JTextField playlistName_field;
	private JTextField playlistGenre_field;
	
	public AddPlaylist(int idutente) {
		initialize(idutente);
	}
	
	private void initialize(int idutente) {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.GRAY);
		JDialog addPlaylistDialog = new JDialog();
		addPlaylistDialog.getContentPane().setBackground(Color.WHITE);
		addPlaylistDialog.setResizable(false);
		addPlaylistDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addPlaylistDialog.setTitle("Aggiungi Playlist.");
		addPlaylistDialog.setUndecorated(true);
		addPlaylistDialog.setBounds(100, 100, 450, 300);
		addPlaylistDialog.getContentPane().setLayout(null);
		addPlaylistDialog.setVisible(true);
		contentPanel.setBounds(0, 0, 450, 300);
		contentPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		addPlaylistDialog.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel draggablePanel = new JPanel();
			draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					addPlaylistDialog.setLocation(addPlaylistDialog.getX() + e.getX() - mouseX, addPlaylistDialog.getY() + e.getY() - mouseY);
				}
			});
			draggablePanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mouseX = e.getX();
					mouseY = e.getY();
				}
			});
			draggablePanel.setLayout(null);
			draggablePanel.setBackground(Color.BLACK);
			draggablePanel.setBounds(0, 0, 450, 20);
			contentPanel.add(draggablePanel);
			{
				JLabel exitButton = new JLabel("");
				exitButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/closered.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
				exitButton.setBounds(420, 0, 30, 20);
				draggablePanel.add(exitButton);
				exitButton.setHorizontalAlignment(SwingConstants.CENTER);
				exitButton.setForeground(Color.WHITE);
				exitButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							addPlaylistDialog.dispose();
						}
				});
				exitButton.setFont(new Font("Arial", Font.BOLD, 16));
			}
		}
		{
			JPanel playlistName_panel = new JPanel();
			playlistName_panel.setLayout(null);
			playlistName_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			playlistName_panel.setBackground(Color.WHITE);
			playlistName_panel.setBounds(71, 105, 309, 53);
			contentPanel.add(playlistName_panel);
			{
				playlistName_field = new JTextField();
				playlistName_field.setFont(new Font("Arial", Font.PLAIN, 16));
				playlistName_field.setColumns(10);
				playlistName_field.setBounds(10, 11, 215, 35);
				playlistName_panel.add(playlistName_field);
			}
			{
				JLabel playlistName_Label = new JLabel("Nome");
				playlistName_Label.setFont(new Font("Arial", Font.BOLD, 12));
				playlistName_Label.setBounds(230, 0, 69, 53);
				playlistName_panel.add(playlistName_Label);
				playlistName_Label.setHorizontalTextPosition(SwingConstants.CENTER);
				playlistName_Label.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JPanel playlistGenre_panel = new JPanel();
			playlistGenre_panel.setLayout(null);
			playlistGenre_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			playlistGenre_panel.setBackground(Color.WHITE);
			playlistGenre_panel.setBounds(71, 160, 309, 53);
			contentPanel.add(playlistGenre_panel);
			{
				playlistGenre_field = new JTextField();
				playlistGenre_field.setFont(new Font("Arial", Font.PLAIN, 16));
				playlistGenre_field.setColumns(10);
				playlistGenre_field.setBounds(10, 11, 215, 35);
				playlistGenre_panel.add(playlistGenre_field);
			}
			{
				JLabel playlistGenre_Label = new JLabel("Genere*");
				playlistGenre_Label.setBounds(235, 0, 64, 53);
				playlistGenre_panel.add(playlistGenre_Label);
				playlistGenre_Label.setFont(new Font("Arial", Font.BOLD, 12));
				playlistGenre_Label.setHorizontalTextPosition(SwingConstants.CENTER);
				playlistGenre_Label.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(52, 22, 347, 57);
		contentPanel.add(panel_Title);
		
		JLabel lblAggiungiPlaylist = new JLabel("Aggiungi Playlist");
		lblAggiungiPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiPlaylist.setForeground(Color.WHITE);
		lblAggiungiPlaylist.setFont(new Font("Arial", Font.BOLD, 29));
		lblAggiungiPlaylist.setBounds(8, 10, 331, 35);
		panel_Title.add(lblAggiungiPlaylist);
		{
						
						JButton okButton = new JButton("Aggiungi");
						okButton.setForeground(Color.BLACK);
						okButton.setFont(new Font("Tahoma", Font.BOLD, 16));
						okButton.setBackground(Color.WHITE);
						okButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								okButton.setBackground(Color.DARK_GRAY);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								okButton.setBackground(Color.WHITE);	
							}
						});
						okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String nome = playlistName_field.getText();
								String genere = playlistGenre_field.getText();
								boolean ok;
								
								PlaylistDAO newplaylist = new PlaylistConnectionDAO();

								ok = newplaylist.ritornaPlaylist(idutente, nome, genere);
								
								if(ok == true) {
									JOptionPane.showMessageDialog(null, "Playlist creata con successo!.");
									addPlaylistDialog.dispose();
								}
							}
						});
						okButton.setBounds(154, 233, 141, 47);
						okButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
						contentPanel.add(okButton);
						okButton.setActionCommand("OK");
						getRootPane().setDefaultButton(okButton);
					}
	}
}
