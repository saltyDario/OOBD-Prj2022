package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GUI.Applet.PanelButtonMouseAdapter;

import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class FrontGUI {
	private JTextField Username_Field;
	private JPasswordField Password_Field;
	private int mouseX, mouseY;
	/**
	 * Create the application.
	 */
	public FrontGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame LogInWindow = new JFrame();
		LogInWindow.setUndecorated(true);
		LogInWindow.setResizable(false);
		LogInWindow.getContentPane().setBackground(Color.GRAY);
		LogInWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dario\\Pictures\\Sfondi\\Sfondi\\PfP\\gonlino.PNG"));
		LogInWindow.setForeground(Color.WHITE);
		LogInWindow.setBackground(new Color(255, 255, 255));
		LogInWindow.setVisible(true);
		LogInWindow.setTitle("SoundLab");
		LogInWindow.setBounds(100, 100, 774, 488);
		LogInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LogInWindow.getContentPane().setLayout(null);
		BorderFactory.createLineBorder(Color.black);
		
		JPanel draggablePanel = new JPanel();
		draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				LogInWindow.setLocation(LogInWindow.getX() + e.getX() - mouseX, LogInWindow.getY() + e.getY() - mouseY);
			}
		});
		draggablePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		draggablePanel.setBackground(Color.BLACK);
		draggablePanel.setBounds(0, 0, 774, 20);
		LogInWindow.getContentPane().add(draggablePanel);
		draggablePanel.setLayout(null);
		
		JLabel exitButton = new JLabel("");
		exitButton.setBounds(744, -3, 30, 27);
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
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel minimizeButton = new JLabel("");
		minimizeButton.setBounds(717, -3, 30, 27);
		draggablePanel.add(minimizeButton);
		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInWindow.setExtendedState(JFrame.ICONIFIED);
			}
		});
		minimizeButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/minimize.png")).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
		minimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel LogInScreen = new JPanel();
		LogInScreen.setBackground(Color.GRAY);
		LogInScreen.setBorder(new LineBorder(Color.BLACK, 2));
		LogInScreen.setBounds(0, 19, 774, 469);
		LogInWindow.getContentPane().add(LogInScreen);
		LogInScreen.setLayout(null);
		
		JPanel User_panel = new JPanel();
		User_panel.setBackground(Color.WHITE);
		User_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		User_panel.setBounds(234, 232, 309, 53);
		LogInScreen.add(User_panel);
		User_panel.setLayout(null);
		
		Username_Field = new JTextField();
		Username_Field.setFont(new Font("Arial", Font.PLAIN, 16));
		Username_Field.setBounds(10, 11, 215, 35);
		User_panel.add(Username_Field);
		Username_Field.setColumns(10);
		
		JLabel UsernameLogo = new JLabel("");
		UsernameLogo.setBounds(221, -10, 103, 74);
		User_panel.add(UsernameLogo);
		UsernameLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		UsernameLogo.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/listen.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		
		JPanel Password_panel = new JPanel();
		Password_panel.setBackground(Color.WHITE);
		Password_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Password_panel.setBounds(234, 289, 309, 53);
		LogInScreen.add(Password_panel);
		Password_panel.setLayout(null);
		
		Password_Field = new JPasswordField();
		Password_Field.setFont(new Font("Arial", Font.PLAIN, 16));
		Password_Field.setBounds(10, 11, 215, 35);
		Password_panel.add(Password_Field);
		
		JLabel PasswordLogo = new JLabel("");
		PasswordLogo.setBounds(222, -5, 92, 62);
		Password_panel.add(PasswordLogo);
		PasswordLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		PasswordLogo.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLogo.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/key.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		
		
		JPanel Iscriviti_panel = new JPanel();
		Iscriviti_panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		Iscriviti_panel.addMouseListener(new PanelButtonMouseAdapter(Iscriviti_panel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationGUI registrationPage = new RegistrationGUI();
			}
		});
		Iscriviti_panel.setFont(new Font("Arial", Font.PLAIN, 12));
		Iscriviti_panel.setBounds(550, 414, 214, 44);
		Iscriviti_panel.setBackground(Color.WHITE);
		LogInScreen.add(Iscriviti_panel);
		Iscriviti_panel.setLayout(null);
		
		JLabel iscrizioneLabel = new JLabel("Iscriviti");
		iscrizioneLabel.setForeground(Color.BLACK);
		iscrizioneLabel.setBounds(13, 9, 189, 26);
		Iscriviti_panel.add(iscrizioneLabel);
		iscrizioneLabel.setBackground(Color.DARK_GRAY);
		iscrizioneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iscrizioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel registerLogo = new JLabel("");
		registerLogo.setBounds(130, -10, 78, 62);
		Iscriviti_panel.add(registerLogo);
		registerLogo.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/register.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		
		JButton LogIn_Button = new JButton("LOGIN");
		LogIn_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LogIn_Button.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LogIn_Button.setBackground(Color.WHITE);	
			}
		});
		LogIn_Button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		LogIn_Button.setBounds(281, 361, 214, 62);
		LogInScreen.add(LogIn_Button);
		LogIn_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = Username_Field.getText();
				String psd = Password_Field.getText();
				
				String url = "jdbc:postgresql://localhost:5432/SoundLab";
				try {
					Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
					String eccoUs = null;
					String eccoPsd = null;
					
					while(!(uname.equals(eccoUs) && psd.equals(eccoPsd))){
						
					String getUser = "SELECT Username FROM Utente where Username = '" + uname + "'";
					Statement richiestaUsername = con.createStatement();
					ResultSet gotUser = richiestaUsername.executeQuery(getUser);
					gotUser.next();
					eccoUs = gotUser.getString("username");
					
					String getPassword = "SELECT Password FROM Utente where Password = '"+ psd + "'";
					Statement richiestaPassword = con.createStatement();
					ResultSet gotPassword = richiestaPassword.executeQuery(getPassword);
					gotPassword.next();
					eccoPsd = gotPassword.getString("password");
					
					con.close();
					}
					JOptionPane.showMessageDialog(null, "Log in effettuato con successo!.");
					
					LogInWindow.setVisible(false);
					Applet mainPage = new Applet(uname, psd);
					
				}catch(SQLException c) {
					JOptionPane.showMessageDialog(null, "Log in non riuscito, ritenta o registrati se non l'hai ancora fatto");
				}
			}
		});
		
		LogIn_Button.setBackground(Color.WHITE);
		LogIn_Button.setForeground(Color.BLACK);
		LogIn_Button.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel FrontLogo = new JLabel("");
		FrontLogo.setBounds(272, 20, 230, 200);
		LogInScreen.add(FrontLogo);
		FrontLogo.setHorizontalAlignment(SwingConstants.CENTER);
		FrontLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/FrontLogo.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		
		JLabel creditLabel = new JLabel("App delivered by: Marucci, Morace");
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setForeground(Color.WHITE);
		creditLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		creditLabel.setBounds(-48, 434, 327, 44);
		LogInScreen.add(creditLabel);
		
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
			panel.setBackground(Color.WHITE);	
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
