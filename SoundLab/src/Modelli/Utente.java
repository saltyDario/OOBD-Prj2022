package Modelli;

import java.util.Date;

import Connessione.GetUtente;

public class Utente {
	private int id_utente;
	private String username;
	private String email;
	private Date data_nascita;
	private String tipo_ut; 
	
	
	public Utente(String us) {
		username = us;
		GetUtente utente = new GetUtente(username);
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
}
