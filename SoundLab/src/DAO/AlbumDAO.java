package DAO;

import java.util.ArrayList;

import Modelli.Album;

public interface AlbumDAO {
	
	public ArrayList<Album> ritornaAlbum(String nomeAlbum);
	
}
