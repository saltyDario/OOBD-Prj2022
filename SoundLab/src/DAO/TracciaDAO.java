package DAO;

import java.util.ArrayList;

import Modelli.Traccia;

public interface TracciaDAO {
	
	public ArrayList<Traccia> ritornaTracce(String nomeTraccia);
	
	public ArrayList<Traccia> ritornaTraccePerArtista(String nomeArtista);
}
