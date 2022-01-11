package DAO;

import java.util.Date;
import java.sql.Timestamp;

public interface AscoltoDAO {

	public boolean inserisciAscolto(int id_utente, int id_traccia, String fasciaoraria, Timestamp data);

}
