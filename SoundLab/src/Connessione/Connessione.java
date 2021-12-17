package Connessione;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connessione {
	
	private static Connessione instance;
	private Connection connection = null;
	private String url = "jdbc:postgresql://localhost:5432/SoundLab";
	private String username = "Gesualdo";
	private String password = "pippo";
	private String driver = "org.postgresql.Driver";
	
	public Connessione() throws SQLException{
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Problema DataBase: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static Connessione getInstance() throws SQLException{
		if(instance == null) {
			instance = new Connessione();
		}else if(instance.getConnection().isClosed()) {
			instance = new Connessione();
		}
		return instance;
	}
	
}
