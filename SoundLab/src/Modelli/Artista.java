package Modelli;

import java.util.Date;

/**
 * Classe modello Artista.
 */
public class Artista {
	
	/** The id artista. */
	int id_artista;
	
	/** The nome artista. */
	String nome_artista;
	
	/** The datanascita artista. */
	Date datanascita_artista;
	
	/** The nazionalit�. */
	String nazionalita;
	
	/**
	 * Instantiates a new artista.
	 *
	 * @param nomeArtista the nome artista
	 * @param datanascitaArtista the datanascita artista
	 * @param Nazionalit� the nazionalit�
	 */
	public Artista(String nomeArtista, Date datanascitaArtista, String Nazionalita) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalita = Nazionalita;
	}
	
	/**
	 * Gets the nome artista.
	 *
	 * @return the nome artista
	 */
	public String getNomeArtista() {
		return nome_artista;
	}
	
	/**
	 * Gets the data nascita artista.
	 *
	 * @return the data nascita artista
	 */
	public Date getDataNascitaArtista() {
		return datanascita_artista;
	}
	
	/**
	 * Gets the nazionalit� artista.
	 *
	 * @return the nazionalit� artista
	 */
	public String getNazionalitaArtista() {
		return nazionalita;
	}
}
