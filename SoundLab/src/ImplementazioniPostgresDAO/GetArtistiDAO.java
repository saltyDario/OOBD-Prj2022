package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.Connessione;
import DAO.ArtistaDAO;
import DAO.TracciaDAO;
import Modelli.Artista;

/**
 * Classe di implementazione PostgresDAO che implementa ArtistaDAO
 */
public class GetArtistiDAO implements ArtistaDAO{
	
	/** Oggetto di tipo Connection in cui viene aperta l'istanza di connessione*/
	private Connection connection;
	
	/**
	 * Costruttore che si occupa di aprire la connessione
	 */
	public GetArtistiDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ritorna artisti da nome.
	 *
	 * @param nome artista ricercato
	 * @return lista di artisti ritornata da mandare a display
	 */
	@Override
	public ArrayList<Artista> ritornaArtistiDaNome(String nome) {
		PreparedStatement scaricaArtisti;
		ArrayList<Artista> list = new ArrayList<Artista>();
		
		String nome_artista = null;
		Date data_nascita = null;
		String nazionalita = null;
		
		try {
			scaricaArtisti = connection.prepareStatement("select nome, datanascita, nazionalita \n"
					+ "from artista\n"
					+ "where lower(nome) = lower('" + nome + "')");
			ResultSet rs = scaricaArtisti.executeQuery();
			
			while(rs.next()) {
				nome_artista = rs.getString("nome");
				data_nascita = rs.getDate("datanascita");
				nazionalita = rs.getString("nazionalita");
				
				Artista nomeobj = new Artista(nome_artista, data_nascita, nazionalita);
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
	 * Ritorna artisti per nazionalita.
	 *
	 * @param nazione ricercata
	 * @return lista di artisti ritornata da mandare a display
	 */
	@Override
	public ArrayList<Artista> ritornaArtistiNazionalita(String nazione) {
		PreparedStatement scaricaArtisti;
		ArrayList<Artista> list = new ArrayList<Artista>();
		
		String nome_artista = null;
		Date data_nascita = null;
		String nazionalita = null;
		
		try {
			scaricaArtisti = connection.prepareStatement("select nome, datanascita, nazionalita\n"
					+ "from artista\n"
					+ "where lower(nazionalita) = lower('" + nazione + "')");
			ResultSet rs = scaricaArtisti.executeQuery();
			
			while(rs.next()) {
				nome_artista = rs.getString("nome");
				data_nascita = rs.getDate("datanascita");
				nazionalita = rs.getString("nazionalita");
				
				Artista nomeobj = new Artista(nome_artista, data_nascita, nazionalita);
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

