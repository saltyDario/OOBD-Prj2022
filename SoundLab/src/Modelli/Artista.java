package Modelli;

import java.util.Date;

public class Artista {
	int id_artista;
	String nome_artista;
	Date datanascita_artista;
	String nazionalità;
	
	public Artista(String nomeArtista, Date datanascitaArtista, String Nazionalità) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalità = Nazionalità;
	}
	
	public String getNomeArtista() {
		return nome_artista;
	}
	
	public Date getDataNascitaArtista() {
		return datanascita_artista;
	}
	
	public String getNazionalitàArtista() {
		return nazionalità;
	}
}
