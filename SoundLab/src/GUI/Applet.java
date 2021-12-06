package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import Modelli.Utente;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.border.LineBorder;

public class Applet {

	
	/**
	 * Create and launch the frame.
	 */
	public Applet(String uname, String psd) {
		initialize(uname, psd);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String uname, String psd) {
		Utente utente = new Utente(uname , psd);
		JFrame AppWindow = new JFrame();
		AppWindow.setResizable(false);
		AppWindow.setUndecorated(true);
		AppWindow.getContentPane().setBackground(Color.GRAY);
		AppWindow.setTitle("SoundLab");
		AppWindow.setVisible(true);
		AppWindow.setBounds(100, 100, 812, 603);
		AppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppWindow.getContentPane().setLayout(null);
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(Color.BLACK);
		panel_Menu.setBounds(0, 0, 327, 603);
		AppWindow.getContentPane().add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JLabel lbllconLogo = new JLabel("");
		lbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllconLogo.setForeground(new Color(0, 255, 255));
		lbllconLogo.setBounds(0, 0, 327, 243);
		panel_Menu.add(lbllconLogo);
		lbllconLogo.setIcon(new ImageIcon(FrontGUI.class.getResource("/Immagini/FrontLogo.png")));
		
		JPanel panel_Home = new JPanel();
		panel_Home.setBounds(0, 243, 327, 65);
		panel_Menu.add(panel_Home);
		panel_Home.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Home.setBackground(Color.GRAY);
		panel_Home.setLayout(null);
		
		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setForeground(new Color(245, 245, 245));
		homeLabel.setFont(new Font("Arial", Font.BOLD, 27));
		homeLabel.setBounds(119, 11, 89, 44);
		panel_Home.add(homeLabel);
		
		JPanel panel_Library = new JPanel();
		panel_Library.setBounds(0, 306, 327, 65);
		panel_Menu.add(panel_Library);
		panel_Library.setBackground(Color.GRAY);
		panel_Library.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Library.setLayout(null);
		
		JLabel libraryLabel = new JLabel("LIBRARY");
		libraryLabel.setForeground(new Color(245, 245, 245));
		libraryLabel.setFont(new Font("Arial", Font.BOLD, 27));
		libraryLabel.setBounds(104, 11, 126, 44);
		panel_Library.add(libraryLabel);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(0, 369, 327, 65);
		panel_Menu.add(panel_Search);
		panel_Search.setBackground(Color.GRAY);
		panel_Search.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Search.setLayout(null);
		
		JLabel searchLabel = new JLabel("SEARCH");
		searchLabel.setForeground(new Color(245, 245, 245));
		searchLabel.setFont(new Font("Arial", Font.BOLD, 27));
		searchLabel.setBounds(96, 11, 132, 44);
		panel_Search.add(searchLabel);
		
		JPanel panel_SignOut = new JPanel();
		panel_SignOut.setBounds(0, 432, 327, 65);
		panel_Menu.add(panel_SignOut);
		panel_SignOut.setBackground(Color.GRAY);
		panel_SignOut.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_SignOut.setLayout(null);
		
		JLabel signOutLabel = new JLabel("SIGN OUT");
		signOutLabel.setForeground(new Color(245, 245, 245));
		signOutLabel.setFont(new Font("Arial", Font.BOLD, 27));
		signOutLabel.setBounds(97, 11, 152, 44);
		panel_SignOut.add(signOutLabel);
		
		JPanel panel_Info = new JPanel();
		panel_Info.setBounds(0, 495, 327, 65);
		panel_Menu.add(panel_Info);
		panel_Info.setLayout(null);
		panel_Info.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Info.setBackground(Color.GRAY);
		
		JLabel infoLabel = new JLabel("INFO");
		infoLabel.setForeground(new Color(245, 245, 245));
		infoLabel.setFont(new Font("Arial", Font.BOLD, 27));
		infoLabel.setBounds(122, 11, 73, 44);
		panel_Info.add(infoLabel);
		
		JLabel creditLabel = new JLabel("App delivered by: Marucci, Morace");
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setForeground(Color.WHITE);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		creditLabel.setBounds(0, 559, 327, 44);
		panel_Menu.add(creditLabel);
		
		JLabel welcomeLabel = new JLabel("Benvenuto:");
		welcomeLabel.setBounds(337, 11, 231, 68);
		AppWindow.getContentPane().add(welcomeLabel);
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel userLabel = new JLabel(utente.getUsername());
		userLabel.setBounds(431, 26, 106, 39);
		AppWindow.getContentPane().add(userLabel);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel exitButton = new JLabel("X");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire?", "Conferma", JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
		});
		
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.setBounds(782, 0, 30, 24);
		AppWindow.getContentPane().add(exitButton);
		
		
	}
}
