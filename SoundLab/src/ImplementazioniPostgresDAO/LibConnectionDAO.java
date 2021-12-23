package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.LibreriaDAO;

public class LibConnectionDAO implements LibreriaDAO{
	
	private int numero_playlist;
	private Connection connection;
	
	public LibConnectionDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int ritornaLibreria(int id_utente) {
		
		try {	
		String getLibreria = "SELECT num_playlist FROM libreria WHERE id_libreria = '" + id_utente + "'";
		Statement richiestaLibreria = connection.createStatement();
		ResultSet gotLibreria = richiestaLibreria.executeQuery(getLibreria);
		gotLibreria.next();
		numero_playlist = gotLibreria.getInt("num_playlist");
		}catch(SQLException c){
			c.printStackTrace();
		}
		return numero_playlist;
	}
}

