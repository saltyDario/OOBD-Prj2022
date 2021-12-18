package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.UtenteDAO;
import GUI.Applet;

public class LogInConnectionDAO implements UtenteDAO {
	
	private Connection connection;
	
	public LogInConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean logInDB(String username, String password) {
		boolean ok = false;
		
		String eccoUs = null;
		String eccoPsd = null;
		
		try {
			
		while(!(username.equals(eccoUs) && password.equals(eccoPsd))){
			
		String getUser = "SELECT Username FROM Utente where Username = '" + username + "'";
		Statement richiestaUsername = connection.createStatement();
		ResultSet gotUser = richiestaUsername.executeQuery(getUser);
		gotUser.next();
		eccoUs = gotUser.getString("username");
		
		String getPassword = "SELECT Password FROM Utente where Password = '"+ password + "'";
		Statement richiestaPassword = connection.createStatement();
		ResultSet gotPassword = richiestaPassword.executeQuery(getPassword);
		gotPassword.next();
		eccoPsd = gotPassword.getString("password");
		ok = true;
		
		connection.close();
		}
	}catch(SQLException c) {
		c.printStackTrace();
	}
		return ok;
	}

	@Override
	public boolean registerInDB(String username, String password, String email, String sesso, Date data) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
