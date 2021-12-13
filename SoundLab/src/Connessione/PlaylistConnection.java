package Connessione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PlaylistConnection {

	public boolean ritornaPlaylist(int idutente, String nome, String genere, int numeroPlaylist) {
		String url = "jdbc:postgresql://localhost:5432/SoundLab";
		boolean ok = false;
		try {			
			Connection con = DriverManager.getConnection(url, "Gesualdo", "pippo");
			
			PreparedStatement st = con.prepareStatement("INSERT INTO playlist(id_libappartenenza, nome, genere) values(?, ?, ?)");
			st.setInt(1, idutente);
			st.setString(2, nome);
			st.setString(3, genere);
			st.executeUpdate();
			st.close();
			

			
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			con.close();
			
			ok = false;
			Connection conn = DriverManager.getConnection(url, "Gesualdo", "pippo");
			
			PreparedStatement st2 = conn.prepareStatement("UPDATE libreria set num_playlist = '"+ numeroPlaylist + "' where id_libreria = '" + idutente +"'");
			st2.executeUpdate();
			st2.close();
			int colonne2 = Statement.RETURN_GENERATED_KEYS;
			if(colonne2 > 0) {
				ok = true;
			}
			

		}catch(SQLException c) {
			JOptionPane.showMessageDialog(null, "SQL exception.");
		}
		return ok;
	}
	
	
	
}
