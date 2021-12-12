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
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.border.LineBorder;
import GUI.FrontGUI;
import java.awt.event.MouseMotionAdapter;

public class Applet {

	private PanelHome paneHome;
	private PanelLibrary paneLibrary;
	private PanelSearch paneSearch;
	private PanelInfo paneInfo;
	private int mouseX, mouseY;
	
	public Applet(String uname) {
		initialize(uname);
	}


	private void initialize(String uname) {
		Utente utente = new Utente(uname);
		JFrame AppWindow = new JFrame();
		AppWindow.setResizable(false);
		AppWindow.setUndecorated(true);
		AppWindow.getContentPane().setBackground(Color.GRAY);
		AppWindow.setTitle("SoundLab");
		AppWindow.setVisible(true);
		AppWindow.setBounds(100, 100, 823, 616);
		AppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppWindow.getContentPane().setLayout(null);
		
		paneHome = new PanelHome();
		paneHome.setBorder(new LineBorder(Color.BLACK, 2, true));
		paneHome.setBounds(0, 0, 486, 588);
		paneLibrary = new PanelLibrary(utente.getUsername(), utente.getId());
		paneLibrary.setBorder(new LineBorder(Color.BLACK, 2, true));
		paneLibrary.setBounds(0, 0, 486, 588);
		paneSearch = new PanelSearch();
		paneSearch.setBorder(new LineBorder(Color.BLACK, 2, true));
		paneSearch.setBounds(0, 0, 486, 588);
		paneInfo = new PanelInfo();
		paneInfo.setBorder(new LineBorder(Color.BLACK, 2, true));
		paneInfo.setBounds(0, 0, 486, 588);
		
		JPanel draggablePanel = new JPanel();
		draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				AppWindow.setLocation(AppWindow.getX() + e.getX() - mouseX, AppWindow.getY() + e.getY() - mouseY);
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
		draggablePanel.setBounds(-2, 0, 825, 20);
		AppWindow.getContentPane().add(draggablePanel);
		
		JLabel exitButton = new JLabel("");
		exitButton.setBounds(798, -2, 27, 24);
		draggablePanel.add(exitButton);
		exitButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/closered.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		exitButton.setForeground(Color.WHITE);
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
		
		JLabel minimizeButton = new JLabel("");
		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AppWindow.setExtendedState(JFrame.ICONIFIED);
			}
		});
		minimizeButton.setBounds(769, -3, 30, 27);
		draggablePanel.add(minimizeButton);
		minimizeButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/minimize.png")).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
		minimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(Color.BLACK);
		panel_Menu.setBounds(0, 0, 327, 616);
		AppWindow.getContentPane().add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JLabel lbllconLogo = new JLabel("");
		lbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllconLogo.setForeground(new Color(0, 255, 255));
		lbllconLogo.setBounds(0, 20, 327, 205);
		panel_Menu.add(lbllconLogo);
		lbllconLogo.setIcon(new ImageIcon(FrontGUI.class.getResource("/Immagini/FrontLogo.png")));
		
		JPanel panel_Home = new JPanel();
		panel_Home.addMouseListener(new PanelButtonMouseAdapter(panel_Home) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneHome);
			}
		});
		panel_Home.setBounds(0, 251, 327, 65);
		panel_Menu.add(panel_Home);
		panel_Home.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Home.setBackground(Color.GRAY);
		panel_Home.setLayout(null);
		
		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setForeground(new Color(245, 245, 245));
		homeLabel.setFont(new Font("Arial", Font.BOLD, 27));
		homeLabel.setBounds(0, 0, 327, 65);
		panel_Home.add(homeLabel);
		
		JLabel homeIcon = new JLabel("");
		homeIcon.setBounds(56, 11, 50, 40);
		panel_Home.add(homeIcon);
		homeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		homeIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/musichome.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		
		JPanel panel_Library = new JPanel();
		panel_Library.addMouseListener(new PanelButtonMouseAdapter(panel_Library){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneLibrary);
			}
		});
		panel_Library.setBounds(0, 314, 327, 65);
		panel_Menu.add(panel_Library);
		panel_Library.setBackground(Color.GRAY);
		panel_Library.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Library.setLayout(null);
		
		JLabel libraryLabel = new JLabel("LIBRARY");
		libraryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		libraryLabel.setForeground(new Color(245, 245, 245));
		libraryLabel.setFont(new Font("Arial", Font.BOLD, 27));
		libraryLabel.setBounds(0, 0, 327, 65);
		panel_Library.add(libraryLabel);
		
		JLabel libraryIcon = new JLabel("");
		libraryIcon.setBounds(56, 11, 50, 40);
		panel_Library.add(libraryIcon);
		libraryIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/library.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		libraryIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_Search = new JPanel();
		panel_Search.addMouseListener(new PanelButtonMouseAdapter(panel_Search){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneSearch);
			}
		});
		panel_Search.setBounds(0, 377, 327, 65);
		panel_Menu.add(panel_Search);
		panel_Search.setBackground(Color.GRAY);
		panel_Search.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_Search.setLayout(null);
		
		JLabel searchLabel = new JLabel("SEARCH");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setForeground(new Color(245, 245, 245));
		searchLabel.setFont(new Font("Arial", Font.BOLD, 27));
		searchLabel.setBounds(0, 0, 327, 65);
		panel_Search.add(searchLabel);
		
		JLabel searchIcon = new JLabel("");
		searchIcon.setBounds(56, 11, 50, 40);
		panel_Search.add(searchIcon);
		searchIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/searchb.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_SignOut = new JPanel();
		panel_SignOut.addMouseListener(new PanelButtonMouseAdapter(panel_SignOut) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire?", "Conferma", JOptionPane.YES_NO_OPTION) == 0) {
					FrontGUI FrontGUI = new FrontGUI();
					AppWindow.setVisible(false);
					AppWindow.dispose();	
				}
			}
		});
		panel_SignOut.setBounds(0, 440, 327, 65);
		panel_Menu.add(panel_SignOut);
		panel_SignOut.setBackground(Color.GRAY);
		panel_SignOut.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_SignOut.setLayout(null);
		
		JLabel signOutLabel = new JLabel("SIGN OUT");
		signOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signOutLabel.setForeground(new Color(245, 245, 245));
		signOutLabel.setFont(new Font("Arial", Font.BOLD, 27));
		signOutLabel.setBounds(0, 0, 327, 65);
		panel_SignOut.add(signOutLabel);
		
		JLabel signOutIcon = new JLabel("");
		signOutIcon.setBounds(57, 11, 50, 40);
		panel_SignOut.add(signOutIcon);
		signOutIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/logout.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		signOutIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_Info = new JPanel();
		panel_Info.addMouseListener(new PanelButtonMouseAdapter(panel_Info){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneInfo);
			}
		});
		panel_Info.setBounds(0, 503, 327, 65);
		panel_Menu.add(panel_Info);
		panel_Info.setLayout(null);
		panel_Info.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Info.setBackground(Color.GRAY);
		
		JLabel infoLabel = new JLabel("INFO");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setForeground(new Color(245, 245, 245));
		infoLabel.setFont(new Font("Arial", Font.BOLD, 27));
		infoLabel.setBounds(0, 0, 327, 65);
		panel_Info.add(infoLabel);
		
		JLabel infoIcon = new JLabel("");
		infoIcon.setBounds(56, 11, 50, 40);
		panel_Info.add(infoIcon);
		infoIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/group.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		infoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(332, 24, 486, 588);
		AppWindow.getContentPane().add(paneMainContent);
		paneMainContent.setLayout(null);
		
		paneMainContent.add(paneHome);
		paneMainContent.add(paneHome);
		paneMainContent.add(paneLibrary);
		paneMainContent.add(paneSearch);
		paneMainContent.add(paneInfo);
		
		menuClicked(paneHome);
		
		JPanel panel_welcome = new JPanel();
		panel_welcome.setBorder(new LineBorder(Color.BLACK, 2));
		panel_welcome.setBackground(Color.GRAY);
		panel_welcome.setBounds(0, 225, 327, 28);
		panel_Menu.add(panel_welcome);
		panel_welcome.setLayout(null);
		
		
		JLabel welcomeLabel = new JLabel("Benvenuto:");
		welcomeLabel.setBounds(10, -19, 101, 68);
		panel_welcome.add(welcomeLabel);
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel userLabel = new JLabel(utente.getUsername());
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setBounds(98, -4, 106, 39);
		panel_welcome.add(userLabel);
		userLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel creditLabel = new JLabel("App delivered by: Marucci, Morace");
		creditLabel.setBounds(0, 572, 327, 44);
		panel_Menu.add(creditLabel);
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setForeground(Color.WHITE);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
	
	public void menuClicked(JPanel panel) {
		paneHome.setVisible(false);
		paneLibrary.setVisible(false);
		paneSearch.setVisible(false);
		paneInfo.setVisible(false);
		
		panel.setVisible(true);
	}
	
	public class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(Color.DARK_GRAY);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.GRAY);	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.DARK_GRAY);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.LIGHT_GRAY);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.DARK_GRAY);
		}
	}
}
