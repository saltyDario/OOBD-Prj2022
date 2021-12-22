package Modelli;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
	
	private ArrayList<Playlist> playlist;
	
	public Libreria(int id_libreria) {		
		playlist = new ArrayList<Playlist>();
	}
	
	public ArrayList<Playlist> getPlaylist(){
		return playlist;
	}

	public void creaLibreria() {
		// TODO Auto-generated method stub
		
	}


	public void addPlaylist(Playlist p) {
		playlist.add(p);
	}
	
}
