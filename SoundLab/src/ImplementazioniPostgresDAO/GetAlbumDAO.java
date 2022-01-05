package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.Connessione;
import DAO.AlbumDAO;
import Modelli.Album;
import Modelli.Traccia;

public class GetAlbumDAO implements AlbumDAO{
	private Connection connection;
	
	public GetAlbumDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
