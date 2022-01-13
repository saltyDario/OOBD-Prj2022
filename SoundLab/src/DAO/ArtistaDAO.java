package DAO;

import java.util.ArrayList;

import Modelli.Artista;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo del ritorno
 * degli artisti situati nel DB in base a vari tipi di input
 */
public interface ArtistaDAO {
	
	/**
	 * Ritorna artisti a partire dal nome.
	 *
	 * @param nome dell'artista
	 * @return array list di artisti da mandare a display
	 */
	public ArrayList<Artista> ritornaArtistiDaNome(String nome);
	
	/**
	 * Ritorna artisti a partire dalla loro nazionalita.
	 *
	 * @param nazione degli artisti ritornati
	 * @return array list diartisti da mandare a display
	 */
	public ArrayList<Artista> ritornaArtistiNazionalita(String nazione);

}
