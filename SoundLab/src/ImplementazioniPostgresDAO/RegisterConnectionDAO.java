package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RegisterConnectionDAO {

	public boolean ritornaRegistrazione(String username, String password, String email, String sesso, Date data) {
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		boolean ok = false;
		try {			
			Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
			
			PreparedStatement st = con.prepareStatement("INSERT INTO utente(username, password, email, sesso, datanascita) values(?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, email);
			st.setString(4, sesso);
			st.setDate(5, data);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			con.close();
		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "Registrazione non riuscita, ritenta.");
		}
		return ok;
	}
}
