package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	@Override
	public ArrayList<Album> ritornaAlbumNome(String nome) {
		PreparedStatement scaricaAlbum;
        ArrayList<Album> list = new ArrayList<Album>();
        
        String nome_album = null;
        String nome_artista = null;
        int anno_album;
        
        try {
            scaricaAlbum = connection.prepareStatement("select nomealbum, nome, anno\n"
            		+ "from album as al, artista as ar\n"
            		+ "where al.id_artista = ar.id_artista and lower(nomealbum) = lower('" + nome +"')");
            ResultSet rs = scaricaAlbum.executeQuery();

            while(rs.next()) {
                 nome_album = rs.getString("nomealbum");
                 nome_artista = rs.getString("nome");
                 anno_album = rs.getInt("anno");
                 
                 Album nomeobj = new Album(nome_album, nome_artista, anno_album);
                 list.add(nomeobj);
                 connection.close();
            }
            rs.close();
        }catch(SQLException e) {
            //e.printStackTrace();
        }
        return list;
	}

	@Override
	public ArrayList<Album> ritornaAlbumDaArtista(String cantante) {
		PreparedStatement scaricaAlbum;
        ArrayList<Album> list = new ArrayList<Album>();
        
        String nome_album = null;
        String nome_artista = null;
        int anno_album;
        
        try {
            scaricaAlbum = connection.prepareStatement("select nomealbum, ar.nome, anno\n"
            		+ "from album as al, artista as ar\n"
            		+ "where al.id_artista=ar.id_artista and lower(ar.nome) = lower('" + cantante +"')");
            ResultSet rs = scaricaAlbum.executeQuery();

            while(rs.next()) {
                 nome_album = rs.getString("nomealbum");
                 nome_artista = rs.getString("nome");
                 anno_album = rs.getInt("anno");
                 //System.out.println(""+ nome_traccia);
                 
                 Album nomeobj = new Album(nome_album, nome_artista, anno_album);
                 list.add(nomeobj);
                 connection.close();
            }
            rs.close();
        }catch(SQLException e) {
            //e.printStackTrace();
        }
        return list;
	}

	@Override
	public ArrayList<Album> ritornaAlbumAnno(int annoAlbum) {
		PreparedStatement scaricaAlbum;
        ArrayList<Album> list = new ArrayList<Album>();
        
        String nome_album = null;
        String nome_artista = null;
        int anno_album;
        
        try {
            scaricaAlbum = connection.prepareStatement("select nomealbum, ar.nome, anno\n"
            		+ "from album as al, artista as ar\n"
            		+ "where al.id_artista=ar.id_artista and anno = " + annoAlbum +"");
            ResultSet rs = scaricaAlbum.executeQuery();

            while(rs.next()) {
                 nome_album = rs.getString("nomealbum");
                 nome_artista = rs.getString("nome");
                 anno_album = rs.getInt("anno");
                 //System.out.println(""+ nome_traccia);
                 
                 Album nomeobj = new Album(nome_album, nome_artista, anno_album);
                 list.add(nomeobj);
                 connection.close();
            }
            rs.close();
        }catch(SQLException e) {
            //e.printStackTrace();
        }
        return list;
	}
	
	
	
}
