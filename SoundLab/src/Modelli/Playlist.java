package Modelli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Classe modello Playlist.
 */
public class Playlist {
	
	/** The id appar. */
	int id_appar;
	
	/** The id playlist. */
	int id_playlist;
	
	/** The numero tracce. */
	int numero_tracce;
	
	/** The preferita. */
	String preferita;
	
	/** The nome playlist. */
	String nome_playlist;
	
	/** The genere playlist. */
	String genere_playlist;
	
	/**
	 * Instantiates a new playlist.
	 *
	 * @param id_utente the id utente
	 * @param nome the nome
	 * @param genere the genere
	 * @param idPlaylist the id playlist
	 */
	public Playlist(int id_utente, String nome, String genere, int idPlaylist) {
		id_appar = id_utente;
		nome_playlist = nome;
		genere_playlist = genere;
		id_playlist = idPlaylist;
	}
	
	/**
	 * Gets the nome playlist.
	 *
	 * @return the nome playlist
	 */
	public String getNomePlaylist() {
		return nome_playlist;
	}
	
	/**
	 * Gets the genere.
	 *
	 * @return the genere
	 */
	public String getGenere() {
		return genere_playlist;
	}
	
	/**
	 * Gets the numero tracce.
	 *
	 * @return the numero tracce
	 */
	public int getNumeroTracce() {
		return numero_tracce;
	}
	
	/**
	 * Gets the favorite.
	 *
	 * @return the favorite
	 */
	public String getFavorite() {
		return preferita;
	}
	
	/**
	 * Sets the numero tracce.
	 *
	 * @param numerotracce the new numero tracce
	 */
	public void setnumeroTracce(int numerotracce) {
		numero_tracce = numerotracce;
	}
	
	/**
	 * Sets the favorite.
	 *
	 * @param pref the new favorite
	 */
	public void setFavorite(String pref) {
		
		if(pref.equals("true")) {
			preferita = "Pref";
		}else {
			preferita = " ";
		}
	}
	
	/**
	 * Gets the ID playlist.
	 *
	 * @return the ID playlist
	 */
	public int getIDPlaylist() {
		return id_playlist;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return nome_playlist;
	}
}
