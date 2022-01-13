package Modelli;

/**
 * Classe modello Traccia.
 */
public class Traccia {
	
	/** The cantanti. */
	String nome_traccia, genere_traccia, tipo_can, cantanti;
	
	/** The id traccia. */
	int annoUscita, id_traccia;
	
	/**
	 * Instantiates a new traccia.
	 *
	 * @param nomeTraccia the nome traccia
	 * @param anno the anno
	 * @param genereTraccia the genere traccia
	 * @param tipoCan the tipo can
	 * @param cantante the cantante
	 * @param idTraccia the id traccia
	 */
	public Traccia(String nomeTraccia, int anno, String genereTraccia, String tipoCan, String cantante, int idTraccia) {
		nome_traccia = nomeTraccia;
		annoUscita = anno;
		genere_traccia = genereTraccia;
		tipo_can = tipoCan;
		cantanti = cantante;
		id_traccia = idTraccia;
	}
	
	/**
	 * Gets the nome traccia.
	 *
	 * @return the nome traccia
	 */
	public String getNomeTraccia() {
		return nome_traccia;
	}
	
	/**
	 * Gets the genere traccia.
	 *
	 * @return the genere traccia
	 */
	public String getGenereTraccia() {
		return genere_traccia;
	}
	
	/**
	 * Gets the anno traccia.
	 *
	 * @return the anno traccia
	 */
	public int getAnnoTraccia() {
		return annoUscita;
	}
	
	/**
	 * Gets the tipo traccia.
	 *
	 * @return the tipo traccia
	 */
	public String getTipoTraccia() {
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
	 * Gets the id traccia.
	 *
	 * @return the id traccia
	 */
	public int getIdTraccia() {
		return id_traccia;
	}
	
}
