package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DAO.AscoltoDAO;
import DAO.TracciaDAO;
import ImplementazioniPostgresDAO.GetAscoltoDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AscoltoRimuoviTraccia extends JDialog {
 
	private int mouseX, mouseY;
	private Timestamp ts = new Timestamp(System.currentTimeMillis());
    
	//yyyy/MM/dd HH:mm:ss
	public AscoltoRimuoviTraccia(int id_utente, int id_traccia, String nome_traccia, int grandezza_playlist) {
		initialize(id_utente, id_traccia, nome_traccia, grandezza_playlist);
	}
	
	private void initialize(int id_utente, int id_traccia, String nome_traccia, int grandezza_playlist) {
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.GRAY);
		JDialog trackHearRemove = new JDialog();
		trackHearRemove.getContentPane().setBackground(Color.WHITE);
		trackHearRemove.setResizable(false);
		trackHearRemove.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		trackHearRemove.setTitle("Aggiungi Playlist.");
		trackHearRemove.setUndecorated(true);
		trackHearRemove.setBounds(100, 100, 450, 300);
		trackHearRemove.getContentPane().setLayout(null);
		trackHearRemove.setVisible(true);
		contentPanel.setBounds(0, 0, 450, 300);
		contentPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		trackHearRemove.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel draggablePanel = new JPanel();
			draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					trackHearRemove.setLocation(trackHearRemove.getX() + e.getX() - mouseX, trackHearRemove.getY() + e.getY() - mouseY);
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
							trackHearRemove.dispose();
						}
				});
				exitButton.setFont(new Font("Arial", Font.BOLD, 16));
			}
		}
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(52, 22, 347, 57);
		contentPanel.add(panel_Title);
		
		JLabel lblTitle = new JLabel("Traccia: "+ nome_traccia);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 29));
		lblTitle.setBounds(8, 10, 331, 35);
		panel_Title.add(lblTitle);
		
		JButton btnListen = new JButton("Ascolta");
		btnListen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok;

				Timestamp data = ts;
				String fasciaoraria = null;
				
				LocalTime orario = java.time.LocalTime.now();
				LocalTime mattina = LocalTime.parse("07:00:00");
				LocalTime pomeriggio = LocalTime.parse("13:59:59");
				LocalTime sera = LocalTime.parse("18:59:59");
				LocalTime notte = LocalTime.parse("23:59:59");
				
				AscoltoDAO a = new GetAscoltoDAO();
				
				if(orario.isAfter(mattina) && orario.isBefore(pomeriggio)) {
					fasciaoraria = "Mattina";
				}else if(orario.isAfter(pomeriggio) && orario.isBefore(sera)) {
					fasciaoraria = "Pomeriggio";
				}else if(orario.isAfter(sera) && orario.isBefore(notte)) {
					fasciaoraria = "Sera";
				}else if(orario.isAfter(notte) && orario.isBefore(mattina)) {
					fasciaoraria = "Notte";
				}

				ok = a.inserisciAscolto(id_utente, id_traccia, fasciaoraria, data);
				
				if(ok == true) {
					JOptionPane.showMessageDialog(null, "La traccia "+ nome_traccia +" e' stata ascoltata.");
					trackHearRemove.dispose();
				}
			}
		});
		btnListen.setToolTipText("Ascolta la canzone.");
		btnListen.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnListen.setBackground(Color.WHITE);
		btnListen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnListen.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnListen.setBackground(Color.WHITE);	
			}
		});
		btnListen.setBounds(52, 197, 126, 57);
		contentPanel.add(btnListen);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok;
				
				TracciaDAO t = new GetTracceDAO();
				ok = t.rimuoviTraccia(id_traccia);
				
				if(ok == true) {
					JOptionPane.showMessageDialog(null, "La traccia "+ nome_traccia +" e' stata rimossa dalla playlist.");
					trackHearRemove.dispose();
				}
			}
		});
		btnRimuovi.setToolTipText("Rimuovi la canzone dalla playlist.");
		btnRimuovi.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnRimuovi.setBackground(Color.WHITE);
		btnRimuovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRimuovi.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRimuovi.setBackground(Color.WHITE);	
			}
		});
		btnRimuovi.setBounds(273, 197, 126, 57);
		contentPanel.add(btnRimuovi);
	}
}
