package DAO;

import java.sql.Date;

public interface UtenteDAO {
	
	boolean logInDB(String username, String password);
	
	boolean registerInDB(String username, String password, String email, String sesso, Date data);
	
	public void getUtenteInDB(String username);
	
	
}
