package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.Connessione;
import DAO.TracciaDAO;
import Modelli.Libreria;
import Modelli.Playlist;
import Modelli.Traccia;

public class GetTracceDAO implements TracciaDAO{
	private Connection connection;
	
	public GetTracceDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Traccia> ritornaTracce(String nomeTraccia) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();

        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        
        try {
        scaricaTracce = connection.prepareStatement(
        		"select nometraccia, anno, genere, tipo_can, a.nome from traccia as t, artista as a "
        		+ "where lower(nometraccia) = lower('"+ nomeTraccia +"') and id_artista in (select album.id_artista from album "
        		+ "where album.id_traccia = t.id_traccia)");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("nome");
             //System.out.println(""+ nome_traccia);
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante);
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
