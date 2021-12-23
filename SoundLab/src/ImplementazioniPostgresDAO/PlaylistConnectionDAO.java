package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.PlaylistDAO;
import Modelli.Libreria;
import Modelli.Playlist;

public class PlaylistConnectionDAO implements PlaylistDAO{
	private Connection connection;
	
	public PlaylistConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean ritornaPlaylist(int idutente, String nome, String genere) {
		boolean ok = false;
		
		try {			
			PreparedStatement st = connection.prepareStatement("INSERT INTO playlist(id_libappartenenza, nome, genere) values(?, ?, ?)");
			st.setInt(1, idutente);
			st.setString(2, nome);
			st.setString(3, genere);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			connection.close();

		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "SQL exception.");
		}
		return ok;
	}
	
}
