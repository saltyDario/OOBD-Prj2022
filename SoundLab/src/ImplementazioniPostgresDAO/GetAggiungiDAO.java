package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.AggiungiDAO;

/**
 * Classe di implementazione PostgresDAO che implementa AggiungiDAO
 */
public class GetAggiungiDAO implements AggiungiDAO{
	
	/** Oggetto di tipo Connection in cui viene aperta l'istanza di connessione*/
	private Connection connection;
	
	/**
	 * Costruttore che si occupa di aprire la connessione
	 */
	public GetAggiungiDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserisci traccia in playlist.
	 *
	 * @param id_playlist id della playlist
	 * @param id_traccia id della traccia
	 * @return true se è stata inserita con successo
	 */
	public boolean inserisciTracciaInPlaylist(int id_playlist, int id_traccia) {
		
		boolean ok = false;
		 
		try {			
			PreparedStatement st = connection.prepareStatement("INSERT INTO aggiungi(id_playlist, id_traccia) values(?, ?)");
			st.setInt(1, id_playlist);
			st.setInt(2, id_traccia);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			connection.close();
		}catch(SQLException c) {
			//c.printStackTrace();
			JOptionPane.showMessageDialog(null, "La traccia è già presente nella playlist.");
		}
		return ok;
	}
	
}
