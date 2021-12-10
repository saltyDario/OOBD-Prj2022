package Main;

import java.awt.EventQueue;

import GUI.Applet;
import GUI.FrontGUI;

public class Main {

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
