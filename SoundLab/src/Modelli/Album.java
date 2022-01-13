package Modelli;

/**
 * Classe modello Album.
 */
public class Album {
	
	/** The nome album. */
	String nome_album;
	
	/** The artisti. */
	String artisti;
	
	/** The anno. */
	int anno;
	
	/**
	 * Instantiates a new album.
	 *
	 * @param nomeAlbum the nome album
	 * @param Artisti the artisti
	 * @param annoUscita the anno uscita
	 */
	public Album(String nomeAlbum,  String Artisti, int annoUscita) {
		nome_album = nomeAlbum;
		artisti = Artisti;
		anno = annoUscita;
	}
	
	/**
	 * Gets the nome album.
	 *
	 * @return the nome album
	 */
	public String getNomeAlbum() {
		return nome_album;
	}
	
	/**
	 * Gets the artisti album.
	 *
	 * @return the artisti album
	 */
	public String getArtistiAlbum() {
		return artisti;
	}
	
	/**
	 * Gets the anno uscita.
	 *
	 * @return the anno uscita
	 */
	public int getAnnoUscita() {
		return anno;
	}
}
