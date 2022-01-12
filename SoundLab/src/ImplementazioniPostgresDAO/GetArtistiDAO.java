package ImplementazioniPostgresDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.Connessione;
import DAO.ArtistaDAO;
import DAO.TracciaDAO;
import Modelli.Artista;

public class GetArtistiDAO implements ArtistaDAO{
	private Connection connection;
	
	public GetArtistiDAO() {
		try {
			connection = Connessione.getInstance().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Artista> ritornaArtistiDaNome(String nome) {
		PreparedStatement scaricaArtisti;
		ArrayList<Artista> list = new ArrayList<Artista>();
		
		String nome_artista = null;
		Date data_nascita = null;
		String nazionalita = null;
		
		try {
			scaricaArtisti = connection.prepareStatement("select nome, datanascita, nazionalità\n"
					+ "from artista\n"
					+ "where lower(nome) = lower('" + nome + "')");
			ResultSet rs = scaricaArtisti.executeQuery();
			
			while(rs.next()) {
				nome_artista = rs.getString("nome");
				data_nascita = rs.getDate("datanascita");
				nazionalita = rs.getString("nazionalità");
				
				Artista nomeobj = new Artista(nome_artista, data_nascita, nazionalita);
				list.add(nomeobj);
				connection.close();
			}
			rs.close();
		}catch(SQLException e) {
			//e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Artista> ritornaArtistiNazionalita(String nazione) {
		PreparedStatement scaricaArtisti;
		ArrayList<Artista> list = new ArrayList<Artista>();
		
		String nome_artista = null;
		Date data_nascita = null;
		String nazionalita = null;
		
		try {
			scaricaArtisti = connection.prepareStatement("select nome, datanascita, nazionalità\n"
					+ "from artista\n"
					+ "where lower(nazionalità) = lower('" + nazione + "')");
			ResultSet rs = scaricaArtisti.executeQuery();
			
			while(rs.next()) {
				nome_artista = rs.getString("nome");
				data_nascita = rs.getDate("datanascita");
				nazionalita = rs.getString("nazionalità");
				
				Artista nomeobj = new Artista(nome_artista, data_nascita, nazionalita);
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

