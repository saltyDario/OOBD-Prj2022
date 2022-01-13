package Modelli;

import java.sql.SQLException;
import java.util.Date;

import ImplementazioniPostgresDAO.GetUtenteDAO;

/**
 * Classe modello Utente.
 */
public class Utente {
	
	/** The id utente. */
	private int id_utente;
	
	/** The username. */
	private String username;
	
	/** The email. */
	private String email;
	
	/** The data nascita. */
	private Date data_nascita;
	
	/** The tipo ut. */
	private String tipo_ut; 
	
	/** The libreria. */
	private Libreria libreria;
	
	/**
	 * Instantiates a new utente.
	 *
	 * @param us the us
	 */
	public Utente(String us) {
		username = us;
		GetUtenteDAO utente = new GetUtenteDAO();
		utente.getUtenteInDB(us);
		
		id_utente = utente.getIdUtente();
		email = utente.getEmail();
		data_nascita = utente.getDate();
		tipo_ut = utente.getTipoUt();
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id_utente;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Gets the data nascita.
	 *
	 * @return the data nascita
	 */
	public Date getDataNascita() {
		return data_nascita;
	}
	
	/**
	 * Gets the tipo utente.
	 *
	 * @return the tipo utente
	 */
	public String getTipoUtente() {
		return tipo_ut;
	}
	
	/**
	 * Sets the libreria.
	 *
	 * @param libreria the new libreria
	 */
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
	/**
	 * Gets the libreria.
	 *
	 * @return the libreria
	 */
	public Libreria getLibreria() {
		return libreria;
	}
	
}
