package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DAO.UtenteDAO;
import ImplementazioniPostgresDAO.GetUtenteDAO;

import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class RegistrationGUI {
	int mouseX, mouseY;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	
	public RegistrationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame RegistrationFrame = new JFrame();
		RegistrationFrame.setUndecorated(true);
		RegistrationFrame.setResizable(false);
		RegistrationFrame.setTitle("Registration");
		RegistrationFrame.setVisible(true);
		RegistrationFrame.setBounds(100, 100, 568, 624);
		RegistrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RegistrationFrame.getContentPane().setLayout(null);
		
		JPanel draggablePanel = new JPanel();
		draggablePanel.setBounds(0, 0, 568, 20);
		RegistrationFrame.getContentPane().add(draggablePanel);
		draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				RegistrationFrame.setLocation(RegistrationFrame.getX() + e.getX() - mouseX, RegistrationFrame.getY() + e.getY() - mouseY);
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
		
		JLabel exitButton = new JLabel("");
		exitButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/closered.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		exitButton.setForeground(Color.WHITE);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire?", "Conferma", JOptionPane.YES_NO_OPTION) == 0) {
					RegistrationFrame.dispose();
				}
			}
		});
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.setBounds(541, -3, 27, 24);
		draggablePanel.add(exitButton);
		
		JLabel minimizeButton = new JLabel("");
		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		minimizeButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/minimize.png")).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
		minimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setFont(new Font("Arial", Font.BOLD, 16));
		minimizeButton.setBounds(512, -3, 30, 27);
		draggablePanel.add(minimizeButton);
		
		JPanel panelRegistration = new JPanel();
		panelRegistration.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelRegistration.setBackground(Color.GRAY);
		panelRegistration.setBounds(0, 20, 568, 604);
		RegistrationFrame.getContentPane().add(panelRegistration);
		panelRegistration.setLayout(null);
		
		JLabel FrontLogo = new JLabel("");
		FrontLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/FrontLogo.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		FrontLogo.setHorizontalAlignment(SwingConstants.CENTER);
		FrontLogo.setBounds(164, 11, 230, 200);
		panelRegistration.add(FrontLogo);
		
		JPanel UsernamePanel = new JPanel();
		UsernamePanel.setLayout(null);
		UsernamePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		UsernamePanel.setBackground(Color.WHITE);
		UsernamePanel.setBounds(122, 222, 309, 53);
		panelRegistration.add(UsernamePanel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameField.setColumns(10);
		usernameField.setBounds(10, 11, 215, 35);
		UsernamePanel.add(usernameField);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(225, 2, 68, 53);
		UsernamePanel.add(usernameLabel);
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel PasswordPanel = new JPanel();
		PasswordPanel.setLayout(null);
		PasswordPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		PasswordPanel.setBackground(Color.WHITE);
		PasswordPanel.setBounds(122, 277, 309, 53);
		panelRegistration.add(PasswordPanel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(10, 11, 215, 35);
		PasswordPanel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(225, 2, 68, 53);
		PasswordPanel.add(passwordLabel);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel EmailPanel = new JPanel();
		EmailPanel.setLayout(null);
		EmailPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		EmailPanel.setBackground(Color.WHITE);
		EmailPanel.setBounds(122, 332, 309, 53);
		panelRegistration.add(EmailPanel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Arial", Font.PLAIN, 16));
		emailField.setColumns(10);
		emailField.setBounds(10, 11, 215, 35);
		EmailPanel.add(emailField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(224, 2, 46, 53);
		EmailPanel.add(emailLabel);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel GenderPanel = new JPanel();
		GenderPanel.setLayout(null);
		GenderPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GenderPanel.setBackground(Color.WHITE);
		GenderPanel.setBounds(122, 387, 309, 53);
		panelRegistration.add(GenderPanel);
		
		JComboBox genderBox = new JComboBox();
		genderBox.setBorder(new LineBorder(Color.BLACK, 2, true));
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Uomo", "Donna", "Altro"}));
		genderBox.setBounds(10, 11, 215, 35);
		GenderPanel.add(genderBox);
		
		JLabel genderLabel = new JLabel("Sesso");
		genderLabel.setBounds(225, 2, 46, 53);
		GenderPanel.add(genderLabel);
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel DataPanel = new JPanel();
		DataPanel.setLayout(null);
		DataPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		DataPanel.setBackground(Color.WHITE);
		DataPanel.setBounds(122, 442, 309, 53);
		panelRegistration.add(DataPanel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 11, 215, 35);
		DataPanel.add(dateChooser);
        dateChooser.setDateFormatString("y/MM/d");
        
        JLabel nascitaLabel = new JLabel("Data nascita");
        nascitaLabel.setBounds(215, 0, 102, 53);
        DataPanel.add(nascitaLabel);
        nascitaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nascitaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton Register_Button = new JButton("REGISTER");
		Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eccoUs = usernameField.getText();
				String eccoPsd = passwordField.getText();
				String eccoEmail = emailField.getText();
				String eccoGender = null;
				
				int box = genderBox.getSelectedIndex();
				
				switch(box){
					case 0:
						eccoGender = "Uomo";
					break;
					case 1:
						eccoGender = "Donna";
					break;
					case 2:
						eccoGender = "Altro";
					break;
				}
				
				Date eccoData = new Date(dateChooser.getDate().getTime());
				boolean ok;
					
				UtenteDAO registrazione = new GetUtenteDAO();
				ok = registrazione.registerInDB(eccoUs, eccoPsd, eccoEmail, eccoGender, eccoData);
				
				if(ok == true) {
					JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo!.");
					RegistrationFrame.dispose();
				}
			}
		});
		
		Register_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Register_Button.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Register_Button.setBackground(Color.WHITE);	
			}
		});
		Register_Button.setForeground(Color.BLACK);
		Register_Button.setFont(new Font("Tahoma", Font.BOLD, 16));
		Register_Button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Register_Button.setBackground(Color.WHITE);
		Register_Button.setBounds(169, 510, 214, 62);
		panelRegistration.add(Register_Button);
	}
}
