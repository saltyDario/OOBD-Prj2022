package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.LibreriaDAO;
import Modelli.Libreria;
import Modelli.Playlist;

public class LibConnectionDAO implements LibreriaDAO{
	
	private Connection connection;
	
	public LibConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Libreria ritornaLibreria(int id_utente) {
		PreparedStatement scaricaPlaylistPS;
        Libreria l = new Libreria(0);

        String nome_playlist = null;
        String genere_playlist = null;
        int numerotracce = 0;
        String preferita = "false";
        int id_playlist = 0;
        
        try {
        scaricaPlaylistPS = connection.prepareStatement(
                "SELECT nome, genere, numerotracce, preferita, id_playlist FROM playlist WHERE id_libappartenenza = '" + id_utente + "'");
        ResultSet rs = scaricaPlaylistPS.executeQuery();

        while(rs.next()) {
             nome_playlist = rs.getString("nome");
             genere_playlist = rs.getString("genere");
             numerotracce = rs.getInt("numerotracce");
             preferita = rs.getString("preferita");
             id_playlist = rs.getInt("id_playlist");
             //System.out.println(""+preferita);
             
             Playlist nomeobj = new Playlist(id_utente, nome_playlist, genere_playlist, id_playlist);
             nomeobj.setnumeroTracce(numerotracce);
             nomeobj.setFavorite(preferita);
             
             l.addPlaylist(nomeobj);
             
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        e.printStackTrace();
    }
    return l;
	}

	@Override
	public Libreria leggiLibreria(int id_utente) {
		// TODO Auto-generated method stub
		return null;
	}
}

