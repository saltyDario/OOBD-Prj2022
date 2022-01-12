package Modelli;

import java.sql.SQLException;
import java.util.Date;

import ImplementazioniPostgresDAO.GetUtenteDAO;

public class Utente {
	private int id_utente;
	private String username;
	private String email;
	private Date data_nascita;
	private String tipo_ut; 
	private Libreria libreria;
	
	public Utente(String us) {
		username = us;
		GetUtenteDAO utente = new GetUtenteDAO();
		utente.getUtenteInDB(us);
		
		id_utente = utente.getIdUtente();
		email = utente.getEmail();
		data_nascita = utente.getDate();
		tipo_ut = utente.getTipoUt();
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getId() {
		return id_utente;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getDataNascita() {
		return data_nascita;
	}
	
	public String getTipoUtente() {
		return tipo_ut;
	}
	
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
	public Libreria getLibreria() {
		return libreria;
	}
	
}
