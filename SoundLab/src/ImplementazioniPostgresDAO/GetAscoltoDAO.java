package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Connessione.Connessione;
import DAO.AscoltoDAO;
import Modelli.Ascolto;
import Modelli.Traccia;

/**
 * Classe di implementazione PostgresDAO che implementa AscoltoDAO
 */
public class GetAscoltoDAO implements AscoltoDAO{
	
	/** Oggetto di tipo Connection in cui viene aperta l'istanza di connessione*/
	private Connection connection;
	
	/**
	 * Costruttore che si occupa di aprire la connessione
	 */
	public GetAscoltoDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserisci ascolto.
	 *
	 * @param id_utente id dell'utente
	 * @param id_traccia id della traccia
	 * @param fasciaoraria dell'ascolto effettuato
	 * @param data dell'ascolto effettuato
	 * @return true se effettuato con successo
	 */
	public boolean inserisciAscolto(int id_utente, int id_traccia, String fasciaoraria, Timestamp data) {
		
		boolean ok = false;
		 
		try {
			PreparedStatement st = connection.prepareStatement("INSERT INTO ascolto(id_utente, id_traccia, fasciaoraria, data) values(?, ?, ?, ?)");
			st.setInt(1, id_utente);
			st.setInt(2, id_traccia);
			st.setString(3, fasciaoraria);
			st.setTimestamp(4, data);
			st.executeUpdate();
			st.close();
			
			int colonne = Statement.RETURN_GENERATED_KEYS;
			if(colonne > 0) {
				ok = true;
			}
			connection.close();
		}catch(SQLException c) {
			//c.printStackTrace();
		}
		return ok;
	}
	
	
	/**
	 * Ritorna ascolti da traccia.
	 *
	 * @param nomeTraccia ricercata
	 * @return lista di ascolti ritornata
	 */
	public ArrayList<Ascolto> ritornaAscoltiDaTraccia(String nomeTraccia) {
		PreparedStatement scaricaTracce;
        ArrayList<Ascolto> list = new ArrayList<Ascolto>();
        
        String username = null;
        String tipo_can = null;
        String cantante = null;
        String fasciaoraria = null;
        int num_ascolti;
        
        try {
        scaricaTracce = connection.prepareStatement("select username, tipo_can, string_agg(distinct art.nome, ','), count(a.id_traccia)/num_artisti as ascolti\n"
        		+ "from utente as u join ascolto as a on a.id_utente=u.id_utente\n"
        		+ "join traccia as t on t.id_traccia=a.id_traccia \n"
        		+ "join collab as c on c.id_traccia=t.id_traccia\n"
        		+ "join artista as art on art.id_artista=c.id_artista\n"
        		+ "where lower(nometraccia) = lower('"+ nomeTraccia +"')\n"
        		+ "group by username, tipo_can, num_artisti\n"
        		+ "order by ascolti desc");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 username = rs.getString("username");
             tipo_can = rs.getString("tipo_can");
             cantante = rs.getString("string_agg");
             num_ascolti = rs.getInt("ascolti");
             
             Ascolto nomeobj = new Ascolto(username, tipo_can, cantante, fasciaoraria, num_ascolti);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
	/**
	 * Ritorna ascolti da utente.
	 *
	 * @param nomeUtente ricercato
	 * @return lista di ascolti
	 */
	public ArrayList<Ascolto> ritornaAscoltiDaUtente(String nomeUtente) {
		PreparedStatement scaricaTracce;
        ArrayList<Ascolto> list = new ArrayList<Ascolto>();
        
        String username = null;
        String fasciaoraria = null;
        int num_ascolti;
        String tipo_canzone = null;
        String cantante = null;
        
        try {
        scaricaTracce = connection.prepareStatement("select username, fasciaoraria, count(a.id_utente) as ascolti\n"
        		+ "from utente as u join ascolto as a on u.id_utente=a.id_utente\n"
        		+ "where lower(username) = lower('"+ nomeUtente +"')\n"
        		+ "group by username, fasciaoraria\n"
        		+ "order by ascolti desc");
        ResultSet rs = scaricaTracce.executeQuery();

        while(rs.next()) {
        	 username = rs.getString("username");
             fasciaoraria= rs.getString("fasciaoraria");
             num_ascolti = rs.getInt("ascolti");
             
             Ascolto nomeobj = new Ascolto(username, tipo_canzone, cantante, fasciaoraria, num_ascolti);
             list.add(nomeobj);
             connection.close();
        }
        rs.close();
    }catch(SQLException e) {
        //e.printStackTrace();
    }
    return list;
	}
	
}
