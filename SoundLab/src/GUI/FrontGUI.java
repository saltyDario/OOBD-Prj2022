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

public class FrontGUI {
	//private Image img_logo = new ImageIcon(FrontGUI.class.getResource("Immagini/FrontLogo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private JTextField Username_Field;
	private JPasswordField Password_Field;

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
		
		JPanel LogInScreen = new JPanel();
		LogInScreen.setBackground(Color.GRAY);
		LogInScreen.setBorder(new LineBorder(Color.BLACK, 2));
		LogInScreen.setBounds(0, 0, 758, 449);
		LogInWindow.getContentPane().add(LogInScreen);
		LogInScreen.setLayout(null);
		
		JLabel User_Label = new JLabel("Username:");
		User_Label.setBounds(149, 216, 124, 53);
		LogInScreen.add(User_Label);
		User_Label.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel User_panel = new JPanel();
		User_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		User_panel.setBounds(269, 216, 309, 53);
		LogInScreen.add(User_panel);
		User_panel.setLayout(null);
		
		Username_Field = new JTextField();
		Username_Field.setFont(new Font("Arial", Font.PLAIN, 12));
		Username_Field.setBounds(10, 11, 215, 35);
		User_panel.add(Username_Field);
		Username_Field.setColumns(10);
		
		JLabel Password_Label = new JLabel("Password:");
		Password_Label.setBounds(155, 264, 118, 62);
		LogInScreen.add(Password_Label);
		Password_Label.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel Password_panel_1 = new JPanel();
		Password_panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Password_panel_1.setBounds(269, 273, 309, 53);
		LogInScreen.add(Password_panel_1);
		Password_panel_1.setLayout(null);
		
		Password_Field = new JPasswordField();
		Password_Field.setFont(new Font("Arial", Font.PLAIN, 12));
		Password_Field.setBounds(10, 11, 215, 35);
		Password_panel_1.add(Password_Field);
		
		JPanel TopTitle = new JPanel();
		TopTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		TopTitle.setBounds(534, 57, 183, 46);
		TopTitle.setBackground(Color.DARK_GRAY);
		LogInScreen.add(TopTitle);
		TopTitle.setLayout(null);
		
		JLabel Title = new JLabel("Accedi a SoundLab!");
		Title.setBounds(0, 0, 183, 45);
		TopTitle.add(Title);
		Title.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton LogIn_Button = new JButton("LOGIN");
		LogIn_Button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		LogIn_Button.setBounds(287, 356, 214, 62);
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
					JOptionPane.showMessageDialog(null, "Log in non riuscito, ritenta.");
				}
			}
		});
		
		LogIn_Button.setBackground(Color.WHITE);
		LogIn_Button.setForeground(Color.BLACK);
		LogIn_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel FrontLogo = new JLabel("");
		FrontLogo.setBounds(271, 11, 230, 200);
		LogInScreen.add(FrontLogo);
		FrontLogo.setHorizontalAlignment(SwingConstants.CENTER);
		FrontLogo.setIcon(new ImageIcon(FrontGUI.class.getResource("/Immagini/FrontLogo.png")));

	}
}
