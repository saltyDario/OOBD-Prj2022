package DAO;

import java.util.ArrayList;

import Modelli.Album;
import Modelli.Traccia;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo del ritorno
 * degli album situati nel DB in base a vari tipi di input
 */
public interface AlbumDAO {
	
	/**
	 * Ritorna gli album a partire dal nome.
	 *
	 * @param nome il nome dell'album
	 * @return array list degli album da mostrare a video
	 */
	public ArrayList<Album> ritornaAlbumNome(String nome);
	
	/**
	 * Ritorna gli album a partire dal nome dell'artista.
	 *
	 * @param cantante il nome del cantante
	 * @return array list degli album da mostrare a video
	 */
	public ArrayList<Album> ritornaAlbumDaArtista(String cantante);
	
	/**
	 * Ritorna gli album a partire dall'anno.
	 *
	 * @param annoAlbum l'anno inserito per la ricerca
	 * @return array list degli album da mostrare
	 */
	public ArrayList<Album> ritornaAlbumAnno(int annoAlbum);
}
