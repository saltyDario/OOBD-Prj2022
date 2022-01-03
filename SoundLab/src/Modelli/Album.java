package Modelli;

public class Album {
	String nome_album;
	String artisti;
	int anno;
	
	public Album(String nomeAlbum,  String Artisti, int annoUscita) {
		nome_album = nomeAlbum;
		artisti = Artisti;
		anno = annoUscita;
	}
	
	public String getNomeAlbum() {
		return nome_album;
	}
	
	public String getArtistiAlbum() {
		return artisti;
	}
	
	public int getAnnoUscita() {
		return anno;
	}
}
