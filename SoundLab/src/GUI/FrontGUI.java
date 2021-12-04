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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class FrontGUI {

	
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
		LogInWindow.setVisible(true);
		LogInWindow.setTitle("SoundLab");
		LogInWindow.setBounds(100, 100, 649, 488);
		LogInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LogInWindow.getContentPane().setLayout(null);
		
		JPanel TopTitle = new JPanel();
		TopTitle.setBounds(118, 11, 385, 50);
		LogInWindow.getContentPane().add(TopTitle);
		
		JLabel Title = new JLabel("Benvenuto in SoundLab!");
		Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TopTitle.add(Title);
		
		JPanel LogIn_panel = new JPanel();
		LogIn_panel.setBounds(38, 88, 562, 295);
		LogInWindow.getContentPane().add(LogIn_panel);
		LogIn_panel.setLayout(null);
		
		Username_Field = new JTextField();
		Username_Field.setBounds(233, 33, 172, 35);
		LogIn_panel.add(Username_Field);
		Username_Field.setColumns(10);
		
		JLabel User_Label = new JLabel("Username:");
		User_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		User_Label.setBounds(132, 36, 105, 26);
		LogIn_panel.add(User_Label);
		
		JLabel Password_Label = new JLabel("Password:");
		Password_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password_Label.setBounds(131, 79, 105, 26);
		LogIn_panel.add(Password_Label);
		
		Password_Field = new JPasswordField();
		Password_Field.setBounds(233, 79, 172, 35);
		LogIn_panel.add(Password_Field);
		
		JButton LogIn_Button = new JButton("LOGIN");
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
					Applet mainPage = new Applet();
					
				}catch(SQLException c) {
					JOptionPane.showMessageDialog(null, "Log in non riuscito, ritenta.");
				}
			}
		});
		
		LogIn_Button.setBackground(Color.WHITE);
		LogIn_Button.setForeground(Color.BLUE);
		LogIn_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LogIn_Button.setBounds(193, 153, 139, 48);
		LogIn_panel.add(LogIn_Button);
	}
}
