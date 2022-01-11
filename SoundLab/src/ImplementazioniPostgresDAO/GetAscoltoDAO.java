package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.AscoltoDAO;
import Modelli.Traccia;

public class GetAscoltoDAO implements AscoltoDAO{
	
	private Connection connection;
	
	public GetAscoltoDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean inserisciAscolto(int id_utente, int id_traccia, String fasciaoraria, Timestamp data) {
		
		boolean ok = false;
		 
		try {			
			System.out.println(""+ fasciaoraria);
			PreparedStatement st = connection.prepareStatement("INSERT INTO ascolto(id_utente, id_traccia, fasciaoraria, data) values(?, ?, ?, ?)");
			st.setInt(1, id_utente);
			st.setInt(2, id_traccia);
			st.setString(3, fasciaoraria);
			st.setTimestamp(4, data);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			connection.close();
		}catch(SQLException c) {
			c.printStackTrace();
			JOptionPane.showMessageDialog(null, "SQL Exception.");
		}
		return ok;
	}
	
}
