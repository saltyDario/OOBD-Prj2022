package Connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class GetUtente {
	
	
	public GetUtente(String username) {
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		
		try {
			Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
			String eccoUs = username;
			int ecco_Id;
			String ecco_Email;
			Date ecco_DataN;
			String ecco_TipoUt; 
				
			String getUser = "select id_utente, email, datanascita, tipo_ut from utente where username = '"+ username + "'";
			Statement richiestaUsername = con.createStatement();
			ResultSet gotUser = richiestaUsername.executeQuery(getUser);
			gotUser.next();
			ecco_Id = gotUser.getInt("id_utente");
			gotUser.next();
			ecco_Email = gotUser.getString("email");
			gotUser.next();
			ecco_DataN = gotUser.getDate("datanascita");
			gotUser.next();
			ecco_TipoUt = gotUser.getString("tipo_ut");
			
			System.out.println("id ="+ ecco_Id);
			System.out.println("email = "+ ecco_Email);
			System.out.println("data nascita = " + ecco_DataN);
			System.out.println("tipo utente = " + ecco_TipoUt);
			
			
		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "Non andato");
		}
	}
	
}
