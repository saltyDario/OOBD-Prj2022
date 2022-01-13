package DAO;

import java.util.ArrayList;

import Modelli.Traccia;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo di ritorno di tracce
 * a partire da vari input e di eliminazione da una playlist
 */
public interface TracciaDAO {
	
	/**
	 * Metodo che ritorna tracce in base al nome inserito.
	 *
	 * @param nomeTraccia il nome della traccia in input
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaTracce(String nomeTraccia);
	
	/**
	 * Metodo che ritorna tracce per artista inserito.
	 *
	 * @param nomeArtista nome artista
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaTraccePerArtista(String nomeArtista);
	
	/**
	 * Metodo che ritorna a partire dal nome album.
	 *
	 * @param nomeAlbum nome dell'album
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaDaAlbum(String nomeAlbum);
	
	/**
	 * Metodo che ritorna tracce di una playlist.
	 *
	 * @param idPlaylist id della playlist che apriamo
	 * @return array list di tracce presenti in quella determinata playlist
	 */
	public ArrayList<Traccia> ritornaTraccePlaylist(int idPlaylist);
	
	/**
	 * Metodo che ritorna tracce a partire dall'anno.
	 *
	 * @param annoTraccia anno inserito in input
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaTracceDaAnno(int annoTraccia);
	
	/**
	 * Metodo che ritorna tracce a partire dal tipo di traccia inserito (Original, Cover, Remaster).
	 *
	 * @param tipoCanzone tipologia della canzone (vedere documentazione metodo)
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaTracceDaTipo(String tipoCanzone);
	
	/**
	 * Ritorna tracce a partire dal genere.
	 *
	 * @param genereTraccia genere in input
	 * @return array list di tracce trovate
	 */
	public ArrayList<Traccia> ritornaTracceDaGenere(String genereTraccia);

	/**
	 * Rimuovi traccia da una playlist a partire dal suo id.
	 *
	 * @param id_traccia l'id della traccia da eliminare
	 * @return true se eliminata con successo
	 */
	public boolean rimuoviTraccia(int id_traccia);
	
}
