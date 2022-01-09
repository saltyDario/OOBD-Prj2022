package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

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
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

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
	private JTextField fieldArtisti;
	private JTextField fieldAlbum;
	private JTextField fieldTracce;


	public PanelHome() {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel esploraPanel = new JPanel();
		esploraPanel.setBackground(Color.GRAY);
		esploraPanel.setBounds(3, 87, 475, 497);
		add(esploraPanel);
		esploraPanel.setLayout(null);
		
		JScrollPane scrollPaneArtisti = new JScrollPane();
		scrollPaneArtisti.getViewport().setBackground(Color.WHITE);
		scrollPaneArtisti.setBackground(Color.GRAY);
		scrollPaneArtisti.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPaneArtisti.setBounds(10, 118, 455, 466);
		add(scrollPaneArtisti);
		scrollPaneArtisti.setViewportView(tableArtisti);
		scrollPaneArtisti.setVisible(false);
		
		JScrollPane scrollPaneAlbum = new JScrollPane();
		scrollPaneAlbum.getViewport().setBackground(Color.WHITE);
		scrollPaneAlbum.setBackground(Color.GRAY);
		scrollPaneAlbum.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPaneAlbum.setBounds(10, 118, 455, 466);
		add(scrollPaneAlbum);
		scrollPaneAlbum.setViewportView(tableAlbum);
		scrollPaneAlbum.setVisible(false);
		
		JScrollPane scrollPaneTracce = new JScrollPane();
		scrollPaneTracce.getViewport().setBackground(Color.WHITE);
		scrollPaneTracce.setBackground(Color.GRAY);
		scrollPaneTracce.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPaneTracce.setBounds(10, 118, 455, 466);
		add(scrollPaneTracce);
		scrollPaneTracce.setViewportView(tableTracce);
		scrollPaneTracce.setVisible(false);
		
		JPanel backPanel = new JPanel();
		backPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				backPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				backPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				backPanel.setBackground(Color.DARK_GRAY);
				esploraPanel.setVisible(true);
				backPanel.setVisible(false);
				scrollPaneArtisti.setVisible(false);
				scrollPaneAlbum.setVisible(false);
				scrollPaneTracce.setVisible(false);
			}
		});
		backPanel.setLayout(null);
		backPanel.setToolTipText("Torna in esplora.");
		backPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		backPanel.setBackground(Color.GRAY);
		backPanel.setBounds(4, 72, 82, 37);
		add(backPanel);
		backPanel.setVisible(false);
		
		JLabel backLabel = new JLabel("");
		backLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/arrow.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backLabel.setBounds(0, 0, 82, 37);
		backPanel.add(backLabel);
		
		tableArtisti.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            System.out.println("okokok");
		        }
		    }
		});
		tableArtisti.setGridColor(Color.BLACK);
		tableArtisti.setFont(new Font("Arial", Font.PLAIN, 14));
		tableArtisti.setForeground(Color.BLACK);
		tableArtisti.setBackground(Color.WHITE);
		tableArtisti.setShowVerticalLines(false);
		tableArtisti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableArtisti.setModel(modelArtisti);
		tableArtisti.setRowHeight(45);
		//tableArtisti.setVisible(false);
		
		tableAlbum.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            System.out.println("okokok");
		        }
		    }
		});
		tableAlbum.setGridColor(Color.BLACK);
		tableAlbum.setFont(new Font("Arial", Font.PLAIN, 14));
		tableAlbum.setForeground(Color.BLACK);
		tableAlbum.setBackground(Color.WHITE);
		tableAlbum.setShowVerticalLines(false);
		tableAlbum.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAlbum.setModel(modelAlbum);
		tableAlbum.setRowHeight(45);
		//tableAlbum.setVisible(false);
		
		tableTracce.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            System.out.println("okokok");
		        }
		    }
		});
		tableTracce.setGridColor(Color.BLACK);
		tableTracce.setFont(new Font("Arial", Font.PLAIN, 14));
		tableTracce.setForeground(Color.BLACK);
		tableTracce.setBackground(Color.WHITE);
		tableTracce.setShowVerticalLines(false);
		tableTracce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTracce.setModel(modelTracce);
		tableTracce.setRowHeight(45);
		//tableTracce.setVisible(false);
		
		modelArtisti.setColumnIdentifiers(headersArtisti);
		modelAlbum.setColumnIdentifiers(headersAlbum);
		modelTracce.setColumnIdentifiers(headersTracce);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(68, 0, 347, 57);
		add(panel_Title);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Arial", Font.BOLD, 29));
		lblHome.setBounds(8, 10, 331, 35);
		panel_Title.add(lblHome);
		
		JPanel esploraArtisti = new JPanel();
		esploraArtisti.setBorder(new LineBorder(Color.BLACK, 2, true));
		esploraArtisti.setBackground(Color.GRAY);
		esploraArtisti.setBounds(20, 90, 433, 125);
		esploraPanel.add(esploraArtisti);
		esploraArtisti.setLayout(null);
		
		JLabel lblArtisti = new JLabel("Artisti");
		lblArtisti.setForeground(Color.WHITE);
		lblArtisti.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArtisti.setBounds(186, 11, 51, 25);
		esploraArtisti.add(lblArtisti);
		
		JComboBox comboBoxArtisti = new JComboBox();
		comboBoxArtisti.setBorder(new LineBorder(Color.BLACK, 2, true));
		comboBoxArtisti.setForeground(Color.BLACK);
		comboBoxArtisti.setBackground(Color.WHITE);
		comboBoxArtisti.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxArtisti.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nome", "Nazionalità"}));
		comboBoxArtisti.setBounds(10, 55, 128, 35);
		esploraArtisti.add(comboBoxArtisti);
		
		JButton goButtonArtisti = new JButton("VAI");
		goButtonArtisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goButtonArtisti.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goButtonArtisti.setBackground(Color.WHITE);	
			}
		});
		goButtonArtisti.setBorder(new LineBorder(Color.BLACK, 2, true));
		goButtonArtisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxArtisti.getSelectedIndex();
				String testo = fieldArtisti.getText();
				
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
					
					if(lista_artisti.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneArtisti.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
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
					
					if(lista_artisti.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneArtisti.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}
					break;
					default:
						JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
	           }
				
			}
		});
		
		goButtonArtisti.setFont(new Font("Arial", Font.BOLD, 12));
		goButtonArtisti.setBounds(343, 55, 61, 35);
		esploraArtisti.add(goButtonArtisti);
		
		fieldArtisti = new JTextField();
		fieldArtisti.setBorder(new LineBorder(Color.BLACK, 2, true));
		fieldArtisti.setBounds(162, 55, 148, 35);
		esploraArtisti.add(fieldArtisti);
		fieldArtisti.setColumns(10);
		
		JPanel esploraAlbum = new JPanel();
		esploraAlbum.setBorder(new LineBorder(Color.BLACK, 2, true));
		esploraAlbum.setBackground(Color.GRAY);
		esploraAlbum.setBounds(20, 220, 433, 125);
		esploraPanel.add(esploraAlbum);
		esploraAlbum.setLayout(null);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setForeground(Color.WHITE);
		lblAlbum.setBackground(Color.BLACK);
		lblAlbum.setBounds(189, 11, 53, 18);
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 16));
		esploraAlbum.add(lblAlbum);
		
		JComboBox comboBoxAlbum = new JComboBox();
		comboBoxAlbum.setBorder(new LineBorder(Color.BLACK, 2, true));
		comboBoxAlbum.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxAlbum.setForeground(Color.BLACK);
		comboBoxAlbum.setBackground(Color.WHITE);
		comboBoxAlbum.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nome", "Artista", "Anno"}));
		comboBoxAlbum.setBounds(10, 48, 128, 35);
		esploraAlbum.add(comboBoxAlbum);
		
		JButton goButtonAlbum = new JButton("VAI");
		goButtonAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goButtonAlbum.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goButtonAlbum.setBackground(Color.WHITE);	
			}
		});
		goButtonAlbum.setBorder(new LineBorder(Color.BLACK, 2, true));
		goButtonAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxAlbum.getSelectedIndex();
				String testo = fieldAlbum.getText();
				
				ArrayList<Album> lista_album = new ArrayList<Album>();
				
				AlbumDAO al = new GetAlbumDAO();
				
				switch(box) {
				case 1:
					
					lista_album = al.ritornaAlbumNome(testo);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelAlbum.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
					
					if(lista_album.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneAlbum.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}
				break;
				case 2:
                    lista_album = al.ritornaAlbumDaArtista(testo);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelAlbum.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
					
					if(lista_album.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneAlbum.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}
				break;
				case 3:
					int num = Integer.parseInt(testo);
                    lista_album = al.ritornaAlbumAnno(num);
					
				    tableAlbum = new JTable();
				    modelAlbum.setRowCount(0);
					for (int i = 0; i < lista_album.size(); i++) {
						modelAlbum.addRow(new Object[] { String.valueOf(lista_album.get(i).getNomeAlbum()),
								String.valueOf(lista_album.get(i).getArtistiAlbum()),
								String.valueOf(lista_album.get(i).getAnnoUscita())});
						}
					
					if(lista_album.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneAlbum.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");					
				}
			}
		});
		goButtonAlbum.setFont(new Font("Arial", Font.BOLD, 12));
		goButtonAlbum.setBounds(344, 48, 61, 35);
		esploraAlbum.add(goButtonAlbum);
		
		fieldAlbum = new JTextField();
		fieldAlbum.setColumns(10);
		fieldAlbum.setBorder(new LineBorder(Color.BLACK, 2, true));
		fieldAlbum.setBounds(163, 48, 148, 35);
		esploraAlbum.add(fieldAlbum);
		
		JPanel esploraTracce = new JPanel();
		esploraTracce.setBorder(new LineBorder(Color.BLACK, 2, true));
		esploraTracce.setBackground(Color.GRAY);
		esploraTracce.setBounds(20, 350, 433, 125);
		esploraPanel.add(esploraTracce);
		esploraTracce.setLayout(null);
		
		JLabel lblTracce = new JLabel("Tracce");
		lblTracce.setHorizontalAlignment(SwingConstants.CENTER);
		lblTracce.setForeground(Color.WHITE);
		lblTracce.setBounds(181, 11, 73, 18);
		lblTracce.setFont(new Font("Tahoma", Font.BOLD, 16));
		esploraTracce.add(lblTracce);
		
		JComboBox comboBoxTracce = new JComboBox();
		comboBoxTracce.setBorder(new LineBorder(Color.BLACK, 2, true));
		comboBoxTracce.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBoxTracce.setModel(new DefaultComboBoxModel(new String[] {"Select", "Anno", "Genere", "Tipo Canzone"}));
		comboBoxTracce.setBounds(10, 48, 128, 35);
		esploraTracce.add(comboBoxTracce);
		
		JButton goButtonTracce = new JButton("VAI");
		goButtonTracce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goButtonTracce.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goButtonTracce.setBackground(Color.WHITE);	
			}
		});
		goButtonTracce.setBorder(new LineBorder(Color.BLACK, 2, true));
		goButtonTracce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = comboBoxTracce.getSelectedIndex();
				String testo = fieldTracce.getText(); 
				
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
				
				if(lista_traccia.size() > 0) {
					esploraPanel.setVisible(false);
					scrollPaneTracce.setVisible(true);
					backPanel.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
				}
				break;
				case 2:
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
					
					if(lista_traccia.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneTracce.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}	
				break;
				case 3:
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
					
					if(lista_traccia.size() > 0) {
						esploraPanel.setVisible(false);
						scrollPaneTracce.setVisible(true);
						backPanel.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "La ricerca non ha prodotto risultati.");
					}
					
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
				
			}
		}});
		goButtonTracce.setBounds(345, 48, 61, 35);
		esploraTracce.add(goButtonTracce);
		goButtonTracce.setFont(new Font("Arial", Font.BOLD, 12));
		
		fieldTracce = new JTextField();
		fieldTracce.setColumns(10);
		fieldTracce.setBorder(new LineBorder(Color.BLACK, 2, true));
		fieldTracce.setBounds(165, 48, 148, 35);
		esploraTracce.add(fieldTracce);
		
		JLabel lblEsplora = new JLabel("Esplora categorie:");
		lblEsplora.setForeground(Color.BLACK);
		lblEsplora.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEsplora.setBounds(10, 11, 160, 29);
		esploraPanel.add(lblEsplora);
	}
}
