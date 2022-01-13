package DAO;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo dell'aggiunta
 * delle tracce nelle playlist situate nel DB
 */
public interface AggiungiDAO {
	
	/**
	 * Metodo che inserisce tracce in una playlist specificata.
	 *
	 * @param id_playlist dove aggiungeremo la traccia
	 * @param id_traccia da aggiungere alla playlist
	 * @return true, se aggiunta con successo
	 */
	public boolean inserisciTracciaInPlaylist(int id_playlist, int id_traccia);
	
}
