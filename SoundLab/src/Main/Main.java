package Main;

import java.awt.EventQueue;

import GUI.Applet;
import GUI.FrontGUI;

/**
 * Classe main che manda in esecuzione il programma
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontGUI LogInPage = new FrontGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
