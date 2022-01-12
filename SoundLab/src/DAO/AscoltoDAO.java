package DAO;

import java.util.ArrayList;
import java.util.Date;

import Modelli.Ascolto;

import java.sql.Timestamp;

public interface AscoltoDAO {

	public boolean inserisciAscolto(int id_utente, int id_traccia, String fasciaoraria, Timestamp data);

	public ArrayList<Ascolto> ritornaAscoltiDaTraccia(String nomeTraccia);

	public ArrayList<Ascolto> ritornaAscoltiDaUtente(String nome);
	
}
