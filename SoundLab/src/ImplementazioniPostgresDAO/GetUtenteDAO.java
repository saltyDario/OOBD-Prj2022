package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import Connessione.Connessione;

public class GetUtenteDAO {
	
	private String eccoUs;
	private int ecco_Id = 0;
	private String ecco_Email = null;
	private Date ecco_DataN = null;
	private String ecco_TipoUt = null; 
	private Connection con;
	
	public GetUtenteDAO(String username) {
		
		eccoUs = username;
		try {
			
			con = Connessione.getInstance().getConnection();
				
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
			JOptionPane.showMessageDialog(null, "Non è stato possibile ricevere l'utente.");
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
