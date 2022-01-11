package Modelli;

public class Traccia {
	
	String nome_traccia, genere_traccia, tipo_can, cantanti;
	int annoUscita, id_traccia;
	
	public Traccia(String nomeTraccia, int anno, String genereTraccia, String tipoCan, String cantante, int idTraccia) {
		nome_traccia = nomeTraccia;
		annoUscita = anno;
		genere_traccia = genereTraccia;
		tipo_can = tipoCan;
		cantanti = cantante;
		id_traccia = idTraccia;
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
	
	public int getIdTraccia() {
		return id_traccia;
	}
	
}
