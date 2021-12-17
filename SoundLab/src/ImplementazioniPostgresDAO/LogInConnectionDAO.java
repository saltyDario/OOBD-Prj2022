package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import GUI.Applet;

public class LogInConnectionDAO {
	
	public boolean ritornaConnessione(String username, String password) {
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		boolean ok = false;
		try {
			Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
			String eccoUs = null;
			String eccoPsd = null;
			
			while(!(username.equals(eccoUs) && password.equals(eccoPsd))){
				
			String getUser = "SELECT Username FROM Utente where Username = '" + username + "'";
			Statement richiestaUsername = con.createStatement();
			ResultSet gotUser = richiestaUsername.executeQuery(getUser);
			gotUser.next();
			eccoUs = gotUser.getString("username");
			
			String getPassword = "SELECT Password FROM Utente where Password = '"+ password + "'";
			Statement richiestaPassword = con.createStatement();
			ResultSet gotPassword = richiestaPassword.executeQuery(getPassword);
			gotPassword.next();
			eccoPsd = gotPassword.getString("password");
			ok = true;
			con.close();
			}
		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "Log in non riuscito, ritenta o registrati se non l'hai ancora fatto.");
		}
		return ok;
	}
	
}
