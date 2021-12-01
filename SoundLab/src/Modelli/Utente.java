package Modelli;

public class Utente {
	private String username;
	private String password;
	
	public Utente(String us, String pw) {
		username = us;
		password = pw;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
