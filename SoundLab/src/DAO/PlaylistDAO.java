package DAO;

import Modelli.Libreria;
import Modelli.Playlist;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo di inserimento di una playlist, toggle
 * on/off di una playlist preferita ed eliminazione di una playlist
 */
public interface PlaylistDAO {

	/**
	 * Metodo che ritorna l'ok quando una playlist è stata correttamente creata nel DB.
	 *
	 * @param idutente id dell utente che crea la playlist
	 * @param nome della playlist
	 * @param genere della playlist non obbligatorio
	 * @return true se è stata inserita correttamente
	 */
	boolean ritornaPlaylist(int idutente, String nome, String genere);

	/**
	 * Metodo che effettua uno switch on/off per capire se la playlist è una delle preferite associate a quell'utente
	 *
	 * @param id_playlist_loc id della playlist in cui si è al momento per effettuare on/off preferita
	 * @param pref_loc per sapere se la playlist è su on o off
	 * @return la stringa che ci dice se è on/off
	 */
	String togglePreferita(int id_playlist_loc, String pref_loc);
	
	/**
	 * Metodo che elimina una playlist a partire dall'id playlist.
	 *
	 * @param id_playlist della playlist da eliminare
	 * @return true se eliminata con successo
	 */
	public boolean eliminaPlaylist(int id_playlist);
	
}
