package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Connessione.Connessione;
import DAO.PlaylistDAO;
import Modelli.Playlist;

public class GetPlaylistDAO implements PlaylistDAO{
	
	private static Connection connection;
	
	public GetPlaylistDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean ritornaPlaylist(int idutente, String nome, String genere) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
    @Override
	public List<Playlist> scaricaPlaylist(int idutente, int num_playlist) {
		List<Playlist> result = new ArrayList<Playlist>(num_playlist);
		PreparedStatement scaricaPlaylistPS;
		
		String nome_playlist = null;
		String genere_playlist = null;
		int numerotracce = 0;
		
		try {
			//String getPlaylist = "SELECT nome, genere, numerotracce FROM playlist WHERE id_libappartenenza = '" + idutente + "'";
			scaricaPlaylistPS = connection.prepareStatement(
					"SELECT nome, genere, numerotracce FROM playlist WHERE id_libappartenenza = '" + idutente + "'");
			ResultSet rs = scaricaPlaylistPS.executeQuery();
			
			while(rs.next()) {
				 nome_playlist = rs.getString("nome");
				 genere_playlist = rs.getString("genere");
				 numerotracce = rs.getInt("numerotracce");
	             System.out.println(""+nome_playlist);

				 Playlist nomeobj = new Playlist(idutente, nome_playlist, genere_playlist);
				 System.out.println(""+nome_playlist);
				 nomeobj.setnumeroTracce(numerotracce);
				 result.add(nomeobj);
			}
			rs.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
