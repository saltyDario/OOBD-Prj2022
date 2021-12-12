package Connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class GetUtente {
	
	private String eccoUs;
	private int ecco_Id = 0;
	private String ecco_Email = null;
	private Date ecco_DataN = null;
	private String ecco_TipoUt = null; 
	
	public GetUtente(String username) {
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		eccoUs = username;
		try {
			Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
			
				
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
			JOptionPane.showMessageDialog(null, "Non andato");
		}
	}
	
	public int getIdUtente() {
		return ecco_Id;
	}
	
	public String getEmail() {
		return ecco_Email;
	}
	
	public Date getDate() {
		return ecco_DataN;
	}
	
	public String getTipoUt() {
		return ecco_TipoUt;
	}
}
