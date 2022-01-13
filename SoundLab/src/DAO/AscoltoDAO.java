package DAO;

import java.util.ArrayList;
import java.util.Date;

import Modelli.Ascolto;

import java.sql.Timestamp;

/**
 * Classe Data Access Object (DAO) che si occupa del meccanismo dell'inserimento
 * degli ascolti effetuati o del ritorno di quelli visibili dagli admin
 */
public interface AscoltoDAO {

	/**
	 * Metodo di inserimento di un ascolto.
	 *
	 * @param id_utente ovvero l'id che ha l'utente nel DB
	 * @param id_traccia id della traccia nel DB
	 * @param fasciaoraria di ascolto al momento
	 * @param data ovvero la data precisa con orario al momento
	 * @return true se tutto ok
	 */
	public boolean inserisciAscolto(int id_utente, int id_traccia, String fasciaoraria, Timestamp data);

	/**
	 * Metodo che ritorna gli ascolti a partire dal nome di una traccia
	 *
	 * @param nomeTraccia il nome della traccia in input
	 * @return array list di tipo ascolto contenente gli ascolti
	 */
	public ArrayList<Ascolto> ritornaAscoltiDaTraccia(String nomeTraccia);

	/**
	 * Ritorna ascolti a partire dal nome dell'utente.
	 *
	 * @param nome dell'utente in input
	 * @return array list di tipo ascolto contenente gli ascolti effettuati da quell'utente
	 */
	public ArrayList<Ascolto> ritornaAscoltiDaUtente(String nome);
	
}
