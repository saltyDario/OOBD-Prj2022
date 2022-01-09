package DAO;

import Modelli.Libreria;
import Modelli.Playlist;

public interface PlaylistDAO {

	boolean ritornaPlaylist(int idutente, String nome, String genere);

	String togglePreferita(int id_playlist_loc, String pref_loc);
	
	public boolean eliminaPlaylist(int id_playlist);
	
}
