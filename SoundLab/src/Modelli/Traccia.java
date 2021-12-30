package Modelli;

public class Traccia {
	
	String nome_traccia, genere_traccia, tipo_can, cantanti;
	int annoUscita;
	
	public Traccia(String nomeTraccia, int anno, String genereTraccia, String tipoCan, String cantante) {
		nome_traccia = nomeTraccia;
		annoUscita = anno;
		genere_traccia = genereTraccia;
		tipo_can = tipoCan;
		cantanti = cantante;
	}
	
	public String getNomeTraccia() {
		return nome_traccia;
	}
	
	public String getGenereTraccia() {
		return genere_traccia;
	}
	
	public int getAnnoTraccia() {
		return annoUscita;
	}
	
	public String getTipoTraccia() {
		return tipo_can;
	}
	
	public String getCantanti() {
		return cantanti;
	}
	
}
