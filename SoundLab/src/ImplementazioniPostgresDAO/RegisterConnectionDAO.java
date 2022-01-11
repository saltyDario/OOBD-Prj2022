package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.UtenteDAO;

public class RegisterConnectionDAO implements UtenteDAO {

	private Connection connection;
	
	public RegisterConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean registerInDB(String username, String password, String email, String sesso, Date data) {
		
		boolean ok = false;
		
		try {			
			
			PreparedStatement st = connection.prepareStatement("INSERT INTO utente(username, password, email, sesso, datanascita) values(?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, email);
			st.setString(4, sesso);
			st.setDate(5, data);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			connection.close();
		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "Registrazione non riuscita, ritenta.");
		}
		return ok;
	}
	
	@Override
	public boolean logInDB(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
}


