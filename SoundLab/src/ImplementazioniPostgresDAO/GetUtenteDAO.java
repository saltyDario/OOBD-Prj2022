package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.UtenteDAO;

/**
 * Classe di implementazione PostgresDAO che implementa UtenteDAO
 */
public class GetUtenteDAO implements UtenteDAO{
	
	/** id dell'utente recuperato */
	private int ecco_Id = 0;
	
	/** email dell'utente recuperato. */
	private String ecco_Email = null;
	
	/** data nascita utente recuperato */
	private Date ecco_DataN = null;
	
	/** tipo utente dell'utente recuperato */
	private String ecco_TipoUt = null; 
	
	/** Oggetto di tipo Connection in cui viene aperta l'istanza di connessione */
	private Connection con;
	
	/**
	 *  Costruttore che si occupa di aprire la connessione
	 */
	public GetUtenteDAO() {
		
		try {
			con = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the utente in DB.
	 *
	 * @param username username dell'utente
	 */
	public void getUtenteInDB(String username) {
		
		String eccoUs = null;
		String eccoPsd = null;
		
		try {
			
			String getUser = "select id_utente, email, datanascita, tipo_ut from utente where username = '"+ username + "'";
			Statement richiestaUsername = con.createStatement();
			ResultSet gotUser = richiestaUsername.executeQuery(getUser);
			
			while(gotUser.next()) {
                ecco_Id = gotUser.getInt("id_utente");
                ecco_Email = gotUser.getString("email");
                ecco_DataN = gotUser.getDate("datanascita");
                ecco_TipoUt = gotUser.getString("tipo_ut");
            }
			
		}catch(SQLException c) {
			//c.printStackTrace();
		}
	}
	
	/**
	 * Log in DB.
	 *
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return true se login con successo
	 */
	@Override
	public boolean logInDB(String username, String password) {
		boolean ok = false;
		
		String eccoUs = null;
		String eccoPsd = null;
		
		try {
			
		while(!(username.equals(eccoUs) && password.equals(eccoPsd))){
			
		String getUser = "SELECT Username FROM Utente where Username = '" + username + "'";
		Statement richiestaUsername = con.createStatement();
		ResultSet gotUser = richiestaUsername.executeQuery(getUser);
		gotUser.next();
		eccoUs = gotUser.getString("username");
		
		String getPassword = "SELECT Password FROM Utente where Password = '"+ password + "'";
		Statement richiestaPassword = con.createStatement();
		ResultSet gotPassword = richiestaPassword.executeQuery(getPassword);
		gotPassword.next();
		eccoPsd = gotPassword.getString("password");
		ok = true;
		
		con.close();
		}
	}catch(SQLException c) {
		//c.printStackTrace();
	}
		return ok;
	}
	
	/**
	 * Register in DB.
	 *
	 * @param username username utente
	 * @param password password utente
	 * @param email email utente
	 * @param sesso sesso utente
	 * @param data data nascita utente
	 * @return true se registrato con successo
	 */
	@Override
	public boolean registerInDB(String username, String password, String email, String sesso, Date data) {
		
		boolean ok = false;
		
		try {			
			
			PreparedStatement st = con.prepareStatement("INSERT INTO utente(username, password, email, sesso, datanascita) values(?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, email);
			st.setString(4, sesso);
			st.setDate(5, data);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			con.close();
		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "Registrazione non riuscita, ritenta.");
		}
		return ok;
	}
	
	/**
	 * Gets the id utente.
	 *
	 * @return the id utente
	 */
	public int getIdUtente() {
		return ecco_Id;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return ecco_Email;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return ecco_DataN;
	}
	
	/**
	 * Gets the tipo ut.
	 *
	 * @return the tipo ut
	 */
	public String getTipoUt() {
		return ecco_TipoUt;
	}
}
