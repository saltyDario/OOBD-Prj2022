package Modelli;

import java.util.Date;

/**
 * Classe modello Ascolto.
 */
public class Ascolto {
	
	/** The utente. */
	private String utente;
	
	/** The tipo can. */
	private String tipo_can;
	
	/** The cantanti. */
	private String cantanti; 
	
	/** The num ascolti. */
	private int num_ascolti;
	
	/** The fascia oraria. */
	private String fascia_oraria;
	
	/**
	 * Instantiates a new ascolto.
	 *
	 * @param username the username
	 * @param tipo_canzone the tipo canzone
	 * @param cantante the cantante
	 * @param fasciaoraria the fasciaoraria
	 * @param num_asco the num asco
	 */
	public Ascolto(String username, String tipo_canzone, String cantante, String fasciaoraria, int num_asco) {
		utente = username;
		tipo_can = tipo_canzone;
		cantanti = cantante;
		fascia_oraria = fasciaoraria;
		num_ascolti = num_asco;
	}
	
	/**
	 * Gets the utente.
	 *
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}
	
	/**
	 * Gets the tipo canzone.
	 *
	 * @return the tipo canzone
	 */
	public String getTipoCanzone() {
		return tipo_can;
	}
	
	/**
	 * Gets the cantanti.
	 *
	 * @return the cantanti
	 */
	public String getCantanti() {
		return cantanti;
	}
	
	/**
	 * Gets the fascia oraria.
	 *
	 * @return the fascia oraria
	 */
	public String getFasciaOraria() {
		return fascia_oraria;
	}
	
	/**
	 * Gets the numero ascolti.
	 *
	 * @return the numero ascolti
	 */
	public int getNumeroAscolti() {
		return num_ascolti;
	}
}
