package DAO;

import Modelli.Libreria;

public interface LibreriaDAO {

	int ritornaLibreria(int id_utente);
	
	



	public Libreria leggiLibreria(int idutente);








	public boolean addPlaylist(int idutente, String nome, String genere);
	
	
	
}
