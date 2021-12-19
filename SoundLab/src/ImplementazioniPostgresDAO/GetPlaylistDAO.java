package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connessione.Connessione;
import Modelli.Libreria;
import Modelli.Playlist;

public class GetPlaylistDAO {

	private Libreria libreria;
	private Connection connection;
	private ResultSet rs = null;
	
	public GetPlaylistDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Libreria scaricaPlaylist(int idutente) {
		
		try {
			String sqlQuery = "select nome, genere, numerotracce from playlist where id_libappartenenza in(select id_libreria from libreria where id_libreria = '"+ idutente +"')";
			Statement st = connection.createStatement();
			rs = st.executeQuery(sqlQuery);
			
			Libreria library = new Libreria();
			library.creaLibreria();
			
			while(rs.next()) {
				 String nome_playlist = rs.getString("nome");
				 String genere_playlist = rs.getString("genere");
				 int numero_tracce = rs.getInt("numerotracce");
				 
				 Playlist nomeobj = new Playlist(idutente, nome_playlist, genere_playlist);
				 nomeobj.setnumeroTracce(numero_tracce);
				 
				 library.aggiungiPlaylist();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return libreria;
	}
	
}
