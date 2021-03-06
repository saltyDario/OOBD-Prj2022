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

/**
 * Classe di implementazione PostgresDAO che implementa TracciaDAO
 */
public class GetTracceDAO implements TracciaDAO{
	
	/** Oggetto di tipo Connection in cui viene aperta l'istanza di connessione */
	private Connection connection;
	
	/**
	 * Costruttore che si occupa di aprire la connessione
	 */
	public GetTracceDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ritorna tracce a partire da un nome.
	 *
	 * @param nomeTraccia da cui fare la ricerca
	 * @return lista di tracce da mandare a display
	 */
	public ArrayList<Traccia> ritornaTracce(String nomeTraccia) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia ,nometraccia, t.anno, genere, tipo_can, string_agg(a.nome, ',')\n"
        		+ "from traccia as t, artista as a, collab as c\n"
        		+ "where t.id_traccia = c.id_traccia and c.id_artista = a.id_artista and LOWER(nometraccia) = lower('"+ nomeTraccia + "')\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
	
	/**
	 * Ritorna tracce per artista.
	 *
	 * @param nomeArtista da cui fare la ricerca
	 * @return lista di tracce dello stesso artista cercato
	 */
	public ArrayList<Traccia> ritornaTraccePerArtista(String nomeArtista) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia ,nometraccia, anno, genere, tipo_can, string_agg(distinct a1.nome, ',')\n"
        		+ "from traccia as t, collab as c, artista as a, artista as a1\n"
        		+ "where lower(a.nome) = lower('"+ nomeArtista +"') and t.id_traccia=c.id_traccia and a.id_artista in (select c1.id_artista\n"
        		+ "                                                                             from collab as c1\r\n"
        		+ "                                                                             where c1.id_traccia=t.id_traccia)\n"
        		+ "                                                        and a1.id_artista in (select c2.id_artista\n"
        		+ "                                                                             from collab as c2\n"
        		+ "                                                                             where c2.id_traccia=t.id_traccia)\n"
        		+ "\n"
        		+ "\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
	/**
	 * Ritorna da album.
	 *
	 * @param nomeAlbum dell'album
	 * @return lista di tracce a partire dall'album cercato
	 */
	public ArrayList<Traccia> ritornaDaAlbum(String nomeAlbum) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia , nometraccia, t.anno, genere, tipo_can, string_agg(art.nome, ',')\r\n"
        		+ "from traccia as t, artista as art, album as al, collab as c\r\n"
        		+ "where t.id_album = al.id_album and al.id_artista=al.id_artista and lower(nomealbum) = lower('"+ nomeAlbum + "') and t.id_traccia = c.id_traccia and c.id_artista=art.id_artista\r\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	id_traccia = rs.getInt("id_traccia");
            nome_traccia = rs.getString("nometraccia");
            anno = rs.getInt("anno");
            genere_traccia = rs.getString("genere");
            tipo_can = rs.getString("tipo_can");
            cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
	/**
	 * Ritorna tracce playlist.
	 *
	 * @param idPlaylist della playlist di cui si vogliono vedere le tracce
	 * @return lista di tracce di una playlist
	 */
	public ArrayList<Traccia> ritornaTraccePlaylist(int idPlaylist) {
        PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();

        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia, nometraccia, t.genere, tipo_can, anno, string_agg(art.nome, ',') \r\n"
                + "from traccia as t, aggiungi as a, playlist as p, artista as art, collab as c\r\n"
                + "where t.id_traccia=a.id_traccia and p.id_playlist=a.id_playlist and t.id_traccia=c.id_traccia and c.id_artista=art.id_artista and p.id_playlist = '" + idPlaylist + "'"
                + "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");

             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
    }

	/**
	 * Ritorna tracce da anno.
	 *
	 * @param annoTraccia delle tracce cercate
	 * @return lista di tracce a partire dall'anno cercato
	 */
	@Override
	public ArrayList<Traccia> ritornaTracceDaAnno(int annoTraccia) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia ,nometraccia, t.anno, genere, tipo_can, string_agg(a.nome, ',')\n"
        		+ "from traccia as t, artista as a, collab as c\n"
        		+ "where t.id_traccia = c.id_traccia and c.id_artista = a.id_artista and t.anno = '"+ annoTraccia + "'\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}

	/**
	 * Ritorna tracce da tipo.
	 *
	 * @param tipoCanzone (vedere documentazione Traccia per le tipologie)
	 * @return lista di tracce in base al tipo
	 */
	@Override
	public ArrayList<Traccia> ritornaTracceDaTipo(String tipoCanzone) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia ,nometraccia, t.anno, genere, tipo_can, string_agg(a.nome, ',')\n"
        		+ "from traccia as t, artista as a, collab as c\n"
        		+ "where t.id_traccia = c.id_traccia and c.id_artista = a.id_artista and LOWER(tipo_can) = lower('"+ tipoCanzone + "')\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}

	/**
	 * Ritorna tracce da genere.
	 *
	 * @param genereTraccia cercato
	 * @return lista di tracce in base al genere
	 */
	@Override
	public ArrayList<Traccia> ritornaTracceDaGenere(String genereTraccia) {
		PreparedStatement scaricaTracce;
        ArrayList<Traccia> list = new ArrayList<Traccia>();
        
        String nome_traccia = null;
        int anno;
        String genere_traccia = null;
        String tipo_can = null;
        String cantante = null;
        int id_traccia;
        
        try {
        scaricaTracce = connection.prepareStatement("select t.id_traccia ,nometraccia, t.anno, genere, tipo_can, string_agg(a.nome, ',')\n"
        		+ "from traccia as t, artista as a, collab as c\n"
        		+ "where t.id_traccia = c.id_traccia and c.id_artista = a.id_artista and lower(genere) = lower('"+ genereTraccia + "')\n"
        		+ "group by t.id_traccia");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 id_traccia = rs.getInt("id_traccia");
             nome_traccia = rs.getString("nometraccia");
             anno = rs.getInt("anno");
             genere_traccia = rs.getString("genere");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             
             Traccia nomeobj = new Traccia(nome_traccia, anno, genere_traccia, tipo_can, cantante, id_traccia);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
	/**
	 * Rimuovi traccia.
	 *
	 * @param id_traccia della traccia che si vuole rimuovere
	 * @return true se eliminata
	 */
	@Override
	public boolean rimuoviTraccia(int id_traccia) {
		boolean ok = false;
		PreparedStatement rimuoviTraccia;
        
        try {
        rimuoviTraccia = connection.prepareStatement("delete from aggiungi where id_traccia = '"+ id_traccia +"'");
        rimuoviTraccia.executeUpdate(); 
        
        ok = true;
        connection.close();
        
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return ok;
	}
}
