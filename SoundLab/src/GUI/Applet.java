package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
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
		AppWindow.getContentPane().setBackground(Color.GRAY);
		AppWindow.setTitle("SoundLab");
		AppWindow.setVisible(true);
		AppWindow.setBounds(100, 100, 812, 603);
		AppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppWindow.getContentPane().setLayout(null);
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(Color.BLACK);
		panel_Menu.setBounds(0, 0, 327, 566);
		AppWindow.getContentPane().add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JLabel lbllconLogo = new JLabel("");
		lbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllconLogo.setForeground(new Color(0, 255, 255));
		lbllconLogo.setBounds(0, 0, 327, 243);
		panel_Menu.add(lbllconLogo);
		lbllconLogo.setIcon(new ImageIcon(FrontGUI.class.getResource("/Immagini/FrontLogo.png")));
		
		JPanel panel_Home = new JPanel();
		panel_Home.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Home.setBackground(Color.GRAY);
		panel_Home.setBounds(0, 242, 327, 87);
		panel_Menu.add(panel_Home);
		panel_Home.setLayout(null);
		
		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setForeground(new Color(245, 245, 245));
		homeLabel.setFont(new Font("Arial", Font.BOLD, 27));
		homeLabel.setBounds(119, 21, 89, 44);
		panel_Home.add(homeLabel);
		
		JPanel panel_Library = new JPanel();
		panel_Library.setBackground(Color.GRAY);
		panel_Library.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Library.setBounds(0, 327, 327, 81);
		panel_Menu.add(panel_Library);
		panel_Library.setLayout(null);
		
		JLabel libraryLabel = new JLabel("LIBRARY");
		libraryLabel.setForeground(new Color(245, 245, 245));
		libraryLabel.setFont(new Font("Arial", Font.BOLD, 27));
		libraryLabel.setBounds(119, 19, 126, 44);
		panel_Library.add(libraryLabel);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBackground(Color.GRAY);
		panel_Search.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Search.setBounds(0, 406, 327, 81);
		panel_Menu.add(panel_Search);
		panel_Search.setLayout(null);
		
		JLabel searchLabel = new JLabel("SEARCH");
		searchLabel.setForeground(new Color(245, 245, 245));
		searchLabel.setFont(new Font("Arial", Font.BOLD, 27));
		searchLabel.setBounds(119, 19, 132, 44);
		panel_Search.add(searchLabel);
		
		JPanel panel_Info = new JPanel();
		panel_Info.setBackground(Color.GRAY);
		panel_Info.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Info.setBounds(0, 485, 327, 81);
		panel_Menu.add(panel_Info);
		panel_Info.setLayout(null);
		
		JLabel libraryLabel_1 = new JLabel("SIGN OUT");
		libraryLabel_1.setForeground(new Color(245, 245, 245));
		libraryLabel_1.setFont(new Font("Arial", Font.BOLD, 27));
		libraryLabel_1.setBounds(119, 19, 132, 44);
		panel_Info.add(libraryLabel_1);
		
		JLabel welcomeLabel = new JLabel("Benvenuto:");
		welcomeLabel.setBounds(335, 0, 123, 39);
		AppWindow.getContentPane().add(welcomeLabel);
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel userLabel = new JLabel(utente.getUsername());
		userLabel.setBounds(435, 0, 106, 39);
		AppWindow.getContentPane().add(userLabel);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
	}
	

}
