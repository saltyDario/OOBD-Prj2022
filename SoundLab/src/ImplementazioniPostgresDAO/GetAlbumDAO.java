package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.Connessione;
import DAO.AlbumDAO;
import Modelli.Album;
import Modelli.Traccia;

public class GetAlbumDAO implements AlbumDAO{
	private Connection connection;
	
	public GetAlbumDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Album> ritornaAlbum(String nomeAlbum) {
		PreparedStatement scaricaTracce;
        ArrayList<Album> list = new ArrayList<Album>();
        
        String nome_album = null;
        String artisti = null;
        int anno;
        
        try {
        scaricaTracce = connection.prepareStatement("select id_traccia ,nomealbum, string_agg(distinct nome, ',') from album as al, artista as ar\n"
        		+ "where al.id_artista = ar.id_artista and lower(nomealbum) = lower('"+ nomeAlbum +"')\n"
        		+ "group by id_traccia, nomealbum");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
             nome_album = rs.getString("nomealbum");
             artisti = rs.getString("string_agg");
             anno = rs.getInt("anno");
             //System.out.println(""+ nome_album);
             
             Album nomeobj = new Album(nome_album, artisti, anno);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        e.printStackTrace();
    }
    return list;
	}
	
}
