package Modelli;

import java.util.Date;

public class Artista {
	int id_artista;
	String nome_artista;
	Date datanascita_artista;
	String nazionalitÓ;
	
	public Artista(String nomeArtista, Date datanascitaArtista, String NazionalitÓ) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalitÓ = NazionalitÓ;
	}
	
	public String getNomeArtista() {
		return nome_artista;
	}
	
	public Date getDataNascitaArtista() {
		return datanascita_artista;
	}
	
	public String getNazionalitÓArtista() {
		return nazionalitÓ;
	}
}
