package DAO;

import Modelli.Libreria;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo del ritorno
 * della libreria di un utente
 */
public interface LibreriaDAO {

	/**
	 * Metodo che ritorna la libreria di un utente.
	 *
	 * @param id_utente di cui verrà ritornata la libreria
	 * @return un oggetto di tipo libreria che contiene un array di array di playlist
	 */
	Libreria ritornaLibreria(int id_utente);
	
}
