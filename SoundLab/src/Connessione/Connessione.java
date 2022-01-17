package Connessione;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 * La classe connessione che si occupa di aprire una connessione col database
 * se non vi è già una aperta in precedenza.
 */
public class Connessione {
	
	/** Istanza di tipo Connessione */
	private static Connessione instance;
	
	/** Istanziato l'oggetto connection di tipo Connection posto a null */
	private Connection connection = null;
	
	/** Url che si riferisce al database di riferimento */
	private String url = "jdbc:postgresql://localhost:5432/SoundLab";
	
	/** Username utilizzato per il login nel database */
	private String username = "postgres";
	
	/** Password utilizzata per il login nel database */
	private String password = "admin";
	
	/** Driver del database da noi utilizzato */
	private String driver = "org.postgresql.Driver";
	
	/**
	 * Effettiva istanza della connessione col DB tramite url, username e password
	 *
	 * @throws SQLException Se vi è un problema con la connessione vi sarà un errore in console
	 */
	public Connessione() throws SQLException{
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Problema DataBase: " + ex.getMessage());
			//ex.printStackTrace();
		}
	}
	
	/**
	 * Metodo che ritorna la connessione prima effettuata
	 *
	 * @return oggetto connection di tipo Connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Metodo che ritorna la singola istanza di connessione, se la connessione è chiusa la riapre
	 *
	 * @return istanza di tipo Connection
	 * @throws SQLException Eccezzione nel caso di connessione non restituita correttamente
	 */
	public static Connessione getInstance() throws SQLException{
		if(instance == null) {
			instance = new Connessione();
		}else if(instance.getConnection().isClosed()) {
			instance = new Connessione();
		}
		return instance;
	}
	
}
