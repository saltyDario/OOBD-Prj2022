package Modelli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class Playlist {
	
	int id_appar;
	int id_playlist;
	int numero_tracce;
	String preferita;
	String nome_playlist;
	String genere_playlist;
	
	public Playlist(int id_utente, String nome, String genere, int idPlaylist) {
		id_appar = id_utente;
		nome_playlist = nome;
		genere_playlist = genere;
		id_playlist = idPlaylist;
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
	
	public String getFavorite() {
		return preferita;
	}
	
	public void setnumeroTracce(int numerotracce) {
		numero_tracce = numerotracce;
	}
	
	public void setFavorite(String pref) {
		
		if(pref.equals("true")) {
			preferita = "Pref";
		}else {
			preferita = " ";
		}
	}
	
	public int getIDPlaylist() {
		return id_playlist;
	}
}
