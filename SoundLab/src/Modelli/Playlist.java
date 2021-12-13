package Modelli;

import java.util.Date;

public class Playlist {
	
	int id_appar;
	int id_playlist;
	int numero_tracce;
	boolean preferita;
	String nome_playlist;
	String genere_playlist;
	
	public Playlist(int id_utente, String nome, String genere) {
		id_appar = id_utente;
		nome_playlist = nome;
		genere_playlist = genere;
	}
	
	public String getNomePlaylist() {
		return nome_playlist;
	}
	
	public String getGenere() {
		return genere_playlist;
	}
	
	public int getNumeroTracce() {
		return numero_tracce;
	}
	
	public boolean getFavorite() {
		return preferita;
	}
	
	
	
}
