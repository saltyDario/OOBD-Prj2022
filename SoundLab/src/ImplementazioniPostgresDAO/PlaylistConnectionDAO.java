package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.LibreriaDAO;
import DAO.PlaylistDAO;
import Modelli.Libreria;
import Modelli.Playlist;

public class PlaylistConnectionDAO implements LibreriaDAO{
	
	private Connection connection;
	
	public PlaylistConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public boolean ritornaPlaylist(int idutente, String nome, String genere) {
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

	public ArrayList<Playlist> scaricaPlaylist(int idutente, int num_playlist) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int ritornaLibreria(int id_utente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addPlaylist(int idutente, String nome, String genere) {
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

	@Override
	public Libreria leggiLibreria(int idutente) {
		PreparedStatement scaricaPlaylistPS;
		Libreria l = new Libreria(0);
		
		String nome_playlist = null;
		String genere_playlist = null;
		int numerotracce = 0;
		
		try {
		scaricaPlaylistPS = connection.prepareStatement(
				"SELECT nome, genere, numerotracce FROM playlist WHERE id_libappartenenza = '" + idutente + "'");
		ResultSet rs = scaricaPlaylistPS.executeQuery();
		
		while(rs.next()) {
			 nome_playlist = rs.getString("nome");
			 genere_playlist = rs.getString("genere");
			 numerotracce = rs.getInt("numerotracce");
             System.out.println(""+nome_playlist);

			 Playlist nomeobj = new Playlist(idutente, nome_playlist, genere_playlist);
			 nomeobj.setnumeroTracce(numerotracce);
			 l.addPlaylist(nomeobj);
			 connection.close();
		}
		rs.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return l;
	}




	
	
}
