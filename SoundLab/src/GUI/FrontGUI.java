package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontGUI {

	private JFrame Applicazione;
	private JTextField Username_Field;
	private JPasswordField Password_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontGUI window = new FrontGUI();
					window.Applicazione.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

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
		Applicazione = new JFrame();
		Applicazione.setTitle("SoundLab");
		Applicazione.setBounds(100, 100, 649, 488);
		Applicazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Applicazione.getContentPane().setLayout(null);
		
		JPanel TopTitle = new JPanel();
		TopTitle.setBounds(118, 11, 385, 50);
		Applicazione.getContentPane().add(TopTitle);
		
		JLabel Title = new JLabel("Benvenuto in SoundLab!");
		Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TopTitle.add(Title);
		
		JPanel LogIn_panel = new JPanel();
		LogIn_panel.setBounds(38, 88, 562, 295);
		Applicazione.getContentPane().add(LogIn_panel);
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
				
			}
		});
		LogIn_Button.setBackground(Color.CYAN);
		LogIn_Button.setForeground(Color.BLUE);
		LogIn_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LogIn_Button.setBounds(193, 153, 139, 48);
		LogIn_panel.add(LogIn_Button);
	}
}
