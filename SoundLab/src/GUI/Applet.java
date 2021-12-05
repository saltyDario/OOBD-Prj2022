package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import Modelli.Utente;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		AppWindow.setTitle("SoundLab");
		AppWindow.setVisible(true);
		AppWindow.setBounds(100, 100, 812, 603);
		AppWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppWindow.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(116, 11, 505, 376);
		AppWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(utente.getUsername());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 463, 110);
		panel.add(lblNewLabel);
	}
}
