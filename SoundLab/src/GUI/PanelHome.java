package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AlbumDAO;
import DAO.ArtistaDAO;
import DAO.TracciaDAO;
import ImplementazioniPostgresDAO.GetAlbumDAO;
import ImplementazioniPostgresDAO.GetArtistiDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;
import Modelli.Album;
import Modelli.Artista;
import Modelli.Traccia;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelHome extends JPanel {
	
	DefaultTableModel modelArtisti = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	DefaultTableModel modelAlbum = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	DefaultTableModel modelTracce = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	String headersArtisti[] = { "Nome", "Data Nascita", "Nazionalità"};
	String headersAlbum[] = { "Nome", "Cantante", "Anno"};
	String headersTracce[] = { "Nome", "Genere", "Tipo Canzone", "Anno", "Artista"};


	
	private JTable tableArtisti = new JTable();
	private JTable tableAlbum = new JTable();
	private JTable tableTracce = new JTable();


	public PanelHome() {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(64, 0, 347, 57);
		add(panel_Title);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Arial", Font.BOLD, 29));
		lblHome.setBounds(8, 10, 331, 35);
		panel_Title.add(lblHome);
		
		JPanel esploraPanel = new JPanel();
		esploraPanel.setBackground(Color.GRAY);
		esploraPanel.setBounds(3, 69, 475, 515);
		add(esploraPanel);
		esploraPanel.setLayout(null);
		
		JPanel esploraArtistiPanel = new JPanel();
		esploraArtistiPanel.setBackground(Color.DARK_GRAY);
		esploraArtistiPanel.setBounds(20, 58, 433, 125);
		esploraPanel.add(esploraArtistiPanel);
		esploraArtistiPanel.setLayout(null);
		
		JLabel lblArtisti = new JLabel("Artisti");
		lblArtisti.setForeground(Color.LIGHT_GRAY);
		lblArtisti.setFont(new Font("Arial", Font.BOLD, 15));
		lblArtisti.setBounds(198, 10, 51, 25);
		esploraArtistiPanel.add(lblArtisti);
		
		JComboBox comboBoxArtisti = new JComboBox();
		comboBoxArtisti.setForeground(Color.BLACK);
		comboBoxArtisti.setBackground(Color.WHITE);
		comboBoxArtisti.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxArtisti.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nome", "Nazionalità"}));
		comboBoxArtisti.setBounds(10, 55, 128, 35);
		esploraArtistiPanel.add(comboBoxArtisti);
		
		JTextPane textArtisti = new JTextPane();
		textArtisti.setBounds(164, 55, 163, 35);
		esploraArtistiPanel.add(textArtisti);
		
		JButton goButton_1 = new JButton("VAI");
		goButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxArtisti.getSelectedIndex();
				String testo = textArtisti.getText();
				
				ArrayList<Artista> lista_artisti = new ArrayList<Artista>();
				
				ArtistaDAO a = new GetArtistiDAO();
				
				switch(box) {
				case 1:
					
					lista_artisti = a.ritornaArtistiDaNome(testo);
					
					tableArtisti = new JTable();
					modelArtisti.setRowCount(0);
					for (int i = 0; i < lista_artisti.size(); i++) {
						modelArtisti.addRow(new Object[] { String.valueOf(lista_artisti.get(i).getNomeArtista()),
								String.valueOf(lista_artisti.get(i).getDataNascitaArtista()),
								String.valueOf(lista_artisti.get(i).getNazionalitàArtista())});
						}
					break;
				case 2:
					
					lista_artisti = a.ritornaArtistiNazionalita(testo);
					
					tableArtisti = new JTable();
					modelArtisti.setRowCount(0);
					for (int i = 0; i < lista_artisti.size(); i++) {
						modelArtisti.addRow(new Object[] { String.valueOf(lista_artisti.get(i).getNomeArtista()),
								String.valueOf(lista_artisti.get(i).getDataNascitaArtista()),
								String.valueOf(lista_artisti.get(i).getNazionalitàArtista())});
						}
					break;
					default:
						JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
	           }
				
			}
		});
		
		modelArtisti.setColumnIdentifiers(headersArtisti);
		goButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		goButton_1.setBounds(362, 55, 61, 35);
		esploraArtistiPanel.add(goButton_1);
		
		JPanel esploraTracce = new JPanel();
		esploraTracce.setBackground(Color.DARK_GRAY);
		esploraTracce.setBounds(20, 328, 433, 125);
		esploraPanel.add(esploraTracce);
		esploraTracce.setLayout(null);
		
		JLabel lblTracce = new JLabel("Tracce");
		lblTracce.setForeground(Color.LIGHT_GRAY);
		lblTracce.setBounds(195, 5, 52, 18);
		lblTracce.setFont(new Font("Arial", Font.BOLD, 15));
		esploraTracce.add(lblTracce);
		
		JComboBox comboBoxTracce = new JComboBox();
		comboBoxTracce.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxTracce.setModel(new DefaultComboBoxModel(new String[] {"Select", "Anno", "Genere", "Tipo Canzone"}));
		comboBoxTracce.setBounds(10, 48, 128, 35);
		esploraTracce.add(comboBoxTracce);
		
		JTextPane textTracce = new JTextPane();
		textTracce.setBounds(167, 48, 163, 35);
		esploraTracce.add(textTracce);
		
		JButton goButton_3 = new JButton("VAI");
		goButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxTracce.getSelectedIndex();
				String testo = textTracce.getText(); 
				
				ArrayList<Traccia> lista_traccia = new ArrayList<Traccia>();
				
				TracciaDAO t = new GetTracceDAO();
				
				int grandezza;
				
				switch (box) {
				case 1:
				int anno = Integer.parseInt(testo);	
					
				lista_traccia = t.ritornaTracceDaAnno(anno);
				
				grandezza = lista_traccia.size();
				
				tableTracce = new JTable();
				modelTracce.setRowCount(0);
				for (int i = 0; i < grandezza; i++) {
					modelTracce.addRow(new Object[] { String.valueOf(lista_traccia.get(i).getNomeTraccia()),
							String.valueOf(lista_traccia.get(i).getGenereTraccia()),
							String.valueOf(lista_traccia.get(i).getTipoTraccia()),
							String.valueOf(lista_traccia.get(i).getAnnoTraccia()),
							String.valueOf(lista_traccia.get(i).getCantanti())
					});
					}
				
				break;
				case 2:
					
					lista_traccia = t.ritornaTracceDaTipo(testo);
					
					grandezza = lista_traccia.size();
					
					tableTracce = new JTable();
					modelTracce.setRowCount(0);
					for (int i = 0; i < grandezza; i++) {
						modelTracce.addRow(new Object[] { String.valueOf(lista_traccia.get(i).getNomeTraccia()),
								String.valueOf(lista_traccia.get(i).getGenereTraccia()),
								String.valueOf(lista_traccia.get(i).getTipoTraccia()),
								String.valueOf(lista_traccia.get(i).getAnnoTraccia()),
								String.valueOf(lista_traccia.get(i).getCantanti())
						});
						}
					
				break;
				case 3:
					
                    lista_traccia = t.ritornaTracceDaGenere(testo);
					
					grandezza = lista_traccia.size();
					
					tableTracce = new JTable();
					modelTracce.setRowCount(0);
					for (int i = 0; i < grandezza; i++) {
						modelTracce.addRow(new Object[] { String.valueOf(lista_traccia.get(i).getNomeTraccia()),
								String.valueOf(lista_traccia.get(i).getGenereTraccia()),
								String.valueOf(lista_traccia.get(i).getTipoTraccia()),
								String.valueOf(lista_traccia.get(i).getAnnoTraccia()),
								String.valueOf(lista_traccia.get(i).getCantanti())
						});
						}
					
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
				
			}
		}});
		goButton_3.setBounds(362, 48, 61, 35);
		esploraTracce.add(goButton_3);
		goButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel esploraAlbum = new JPanel();
		esploraAlbum.setBackground(Color.DARK_GRAY);
		esploraAlbum.setBounds(20, 193, 433, 125);
		esploraPanel.add(esploraAlbum);
		esploraAlbum.setLayout(null);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setForeground(Color.LIGHT_GRAY);
		lblAlbum.setBackground(Color.BLACK);
		lblAlbum.setBounds(198, 10, 53, 18);
		lblAlbum.setFont(new Font("Arial", Font.BOLD, 15));
		esploraAlbum.add(lblAlbum);
		
		JComboBox comboBoxAlbum = new JComboBox();
		comboBoxAlbum.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxAlbum.setForeground(Color.BLACK);
		comboBoxAlbum.setBackground(Color.WHITE);
		comboBoxAlbum.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nome", "Artista", "Anno"}));
		comboBoxAlbum.setBounds(10, 48, 128, 35);
		esploraAlbum.add(comboBoxAlbum);
		
		JTextPane textAlbum = new JTextPane();
		textAlbum.setBounds(165, 48, 163, 35);
		esploraAlbum.add(textAlbum);
		
		JButton goButton_2 = new JButton("VAI");
		goButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxAlbum.getSelectedIndex();
				String testo = textAlbum.getText();
				
				ArrayList<Album> lista_album = new ArrayList<Album>();
				
				AlbumDAO al = new GetAlbumDAO();
				
				switch(box) {
				case 1:
					
					lista_album = al.ritornaAlbumNome(testo);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelArtisti.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
				break;
				case 2:
                    lista_album = al.ritornaAlbumDaArtista(testo);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelArtisti.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
				break;
				case 3:
					int num = Integer.parseInt(testo);
                    lista_album = al.ritornaAlbumAnno(num);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelArtisti.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");					
				}
			}
		});
		goButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		goButton_2.setBounds(362, 48, 61, 35);
		esploraAlbum.add(goButton_2);
		
		JLabel lblEsplora = new JLabel("Esplora categorie:");
		lblEsplora.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEsplora.setBounds(10, 11, 146, 29);
		esploraPanel.add(lblEsplora);
		setVisible(true);
	}
}
