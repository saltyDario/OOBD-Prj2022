package Modelli;

import java.util.Date;

public class Ascolto {
	
	private String utente;
	private String tipo_can;
	private String cantanti; 
	private int num_ascolti;
	private String fascia_oraria;
	
	public Ascolto(String username, String tipo_canzone, String cantante, String fasciaoraria, int num_asco) {
		utente = username;
		tipo_can = tipo_canzone;
		cantanti = cantante;
		fascia_oraria = fasciaoraria;
		num_ascolti = num_asco;
	}
	
	public String getUtente() {
		return utente;
	}
	
	public String getTipoCanzone() {
		return tipo_can;
	}
	
	public String getCantanti() {
		return cantanti;
	}
	
	public String getFasciaOraria() {
		return fascia_oraria;
	}
	
	public int getNumeroAscolti() {
		return num_ascolti;
	}
}
