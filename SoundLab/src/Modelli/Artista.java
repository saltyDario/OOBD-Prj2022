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
	
	/** The nazionalità. */
	String nazionalità;
	
	/**
	 * Instantiates a new artista.
	 *
	 * @param nomeArtista the nome artista
	 * @param datanascitaArtista the datanascita artista
	 * @param Nazionalità the nazionalità
	 */
	public Artista(String nomeArtista, Date datanascitaArtista, String Nazionalità) {
		nome_artista = nomeArtista;
		datanascita_artista = datanascitaArtista;
		nazionalità = Nazionalità;
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
	 * Gets the nazionalità artista.
	 *
	 * @return the nazionalità artista
	 */
	public String getNazionalitàArtista() {
		return nazionalità;
	}
}
