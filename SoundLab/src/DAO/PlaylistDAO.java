package DAO;

import Modelli.Libreria;
import Modelli.Playlist;

public interface PlaylistDAO {

	boolean ritornaPlaylist(int idutente, String nome, String genere);
	
}
