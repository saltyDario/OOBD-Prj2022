package Modelli;

import java.util.ArrayList;

/**
 * Classe modello Libreria.
 */
public class Libreria {

    /** The playlist. */
    private ArrayList<Playlist> playlist;

    /**
     * Instantiates a new libreria.
     *
     * @param id_libreria the id libreria
     */
    public Libreria(int id_libreria) {
        playlist = new ArrayList<Playlist>();
    }

    /**
     * Gets the playlist.
     *
     * @return the playlist
     */
    public ArrayList<Playlist> getPlaylist(){
        return playlist;
    }

    /**
     * Crea libreria.
     */
    public void creaLibreria() {
        // TODO Auto-generated method stub
    }

    /**
     * Adds the playlist.
     *
     * @param p the p
     */
    public void addPlaylist(Playlist p) {
        playlist.add(p);
    }

}
