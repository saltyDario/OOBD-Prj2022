package Modelli;

import java.util.Date;

public class Artista {
	int id_artista;
	String nome_artista;
	Date datanascita_artista;
	String nazionalit�;
	
	public Artista(String nomeArtista, Date datanascitaArtista, String Nazionalit�) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalit� = Nazionalit�;
	}
	
	public String getNomeArtista() {
		return nome_artista;
	}
	
	public Date getDataNascitaArtista() {
		return datanascita_artista;
	}
	
	public String getNazionalit�Artista() {
		return nazionalit�;
	}
}
