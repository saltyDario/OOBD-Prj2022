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
	String nazionalit�;
	
	/**
	 * Instantiates a new artista.
	 *
	 * @param nomeArtista the nome artista
	 * @param datanascitaArtista the datanascita artista
	 * @param Nazionalit� the nazionalit�
	 */
	public Artista(String nomeArtista, Date datanascitaArtista, String Nazionalit�) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalit� = Nazionalit�;
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
	public String getNazionalit�Artista() {
		return nazionalit�;
	}
}
