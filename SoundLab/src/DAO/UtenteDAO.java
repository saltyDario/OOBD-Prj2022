package DAO;

import java.sql.Date;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo di login, registrazione
 * e ottenimento dei prametri di un utente
 */
public interface UtenteDAO {
	
	/**
	 * Log in nel DB.
	 *
	 * @param username input di accesso
	 * @param password input di accesso
	 * @return true se login con successo
	 */
	boolean logInDB(String username, String password);
	
	/**
	 * Register in DB.
	 *
	 * @param username di registrazione
	 * @param password di registrazione
	 * @param email di registrazione
	 * @param sesso di registrazione
	 * @param data di nascita di registrazione
	 * @return true se registraione con successo
	 */
	boolean registerInDB(String username, String password, String email, String sesso, Date data);
	
	/**
	 * Metodo che prende parametri dell'utente dal DB a partire dall'username
	 *
	 * @param username dell'utente loggato
	 */
	public void getUtenteInDB(String username);
	
	
}
