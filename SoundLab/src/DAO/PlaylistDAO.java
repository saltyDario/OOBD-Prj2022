package DAO;

import java.util.ArrayList;
import java.util.List;

import Modelli.Libreria;
import Modelli.Playlist;

public interface PlaylistDAO {

	boolean ritornaPlaylist(int idutente, String nome, String genere);
	
	public List<Playlist> scaricaPlaylist(int idutente, int num_playlist);
}


