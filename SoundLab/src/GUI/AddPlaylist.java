package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
		JDialog addPlaylistDialog = new JDialog();
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
						
						JButton okButton = new JButton("Aggiungi");
						okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String nome = playlistName_field.getText();
								String genere = playlistGenre_field.getText();
								Playlist newPlaylist = new Playlist(idutente, nome, genere);
								addPlaylistDialog.dispose();
							}
						});
						okButton.setBounds(164, 220, 141, 60);
						contentPanel.add(okButton);
						okButton.setActionCommand("OK");
						getRootPane().setDefaultButton(okButton);
					}
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
			playlistName_panel.setBounds(78, 105, 309, 53);
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
				playlistName_Label.setBounds(215, 0, 94, 53);
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
			playlistGenre_panel.setBounds(78, 160, 309, 53);
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
				playlistGenre_Label.setBounds(220, 0, 98, 53);
				playlistGenre_panel.add(playlistGenre_Label);
				playlistGenre_Label.setFont(new Font("Arial", Font.BOLD, 12));
				playlistGenre_Label.setHorizontalTextPosition(SwingConstants.CENTER);
				playlistGenre_Label.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JPanel dialog_Panel = new JPanel();
			dialog_Panel.setBounds(101, 31, 262, 53);
			contentPanel.add(dialog_Panel);
			dialog_Panel.setLayout(null);
			{
				JLabel titleLabel = new JLabel("Aggiungi una playlist:");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
				titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				titleLabel.setBounds(0, 0, 262, 53);
				dialog_Panel.add(titleLabel);
			}
		}
	}

}
