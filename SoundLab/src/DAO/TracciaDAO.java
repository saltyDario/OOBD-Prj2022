package DAO;

import java.util.ArrayList;

import Modelli.Traccia;

public interface TracciaDAO {
	
	public ArrayList<Traccia> ritornaTracce(String nomeTraccia);
	
	public ArrayList<Traccia> ritornaTraccePerArtista(String nomeArtista);
	
	public ArrayList<Traccia> ritornaDaAlbum(String nomeAlbum);
	
	public ArrayList<Traccia> ritornaTraccePlaylist(int idPlaylist);
	
	public ArrayList<Traccia> ritornaTracceDaAnno(int annoTraccia);
	
	public ArrayList<Traccia> ritornaTracceDaTipo(String tipoCanzone);
	
	public ArrayList<Traccia> ritornaTracceDaGenere(String genereTraccia);


}
