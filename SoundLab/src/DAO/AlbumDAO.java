package DAO;

import java.util.ArrayList;

import Modelli.Album;
import Modelli.Traccia;

public interface AlbumDAO {
	
	public ArrayList<Album> ritornaAlbumNome(String nome);
	
	public ArrayList<Album> ritornaAlbumDaArtista(String cantante);
	
	public ArrayList<Album> ritornaAlbumAnno(int annoAlbum);
}
