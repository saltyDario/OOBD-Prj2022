package DAO;

import java.util.ArrayList;

import Modelli.Artista;

public interface ArtistaDAO {
	
	public ArrayList<Artista> ritornaArtistiDaNome(String nome);
	
	public ArrayList<Artista> ritornaArtistiNazionalita(String nazione);

}
