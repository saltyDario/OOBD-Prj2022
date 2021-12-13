package Connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LibConnection {
	private int numero_playlist;
	
	public LibConnection() {

		}
	
	public int ritornaLibreria(int id_utente) {
		
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		
		try {
		Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
		
		String getLibreria = "select num_playlist from libreria where id_libreria = '" + id_utente + "'";
		Statement richiestaLibreria = con.createStatement();
		ResultSet gotLibreria = richiestaLibreria.executeQuery(getLibreria);
		gotLibreria.next();
		numero_playlist = gotLibreria.getInt("num_playlist");
		}catch(SQLException c){
			JOptionPane.showMessageDialog(null, "Recupero non riuscito, riprova.");
		}
		
		return numero_playlist;
	}
}

