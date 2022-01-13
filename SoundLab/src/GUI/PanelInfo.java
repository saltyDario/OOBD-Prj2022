package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AscoltoDAO;
import DAO.TracciaDAO;
import DAO.UtenteDAO;
import ImplementazioniPostgresDAO.GetAscoltoDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;
import ImplementazioniPostgresDAO.GetUtenteDAO;
import Modelli.Ascolto;
import Modelli.Traccia;

/**
 * Classe GUI che permette ad un utente di tipo admin controllare le statistiche in base a vari valori di input
 */
public class PanelInfo extends JPanel {

	/** The search field. */
	private JTextField searchField;
	
	/** Lista ascolti ritornata. */
	private ArrayList<Ascolto> lista_ascolti = new ArrayList<Ascolto>();
	
	/** Modello della tabella a partire dalla ricerca di una traccia. */
	DefaultTableModel modelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	/** Header tabella per ricerca a partire da una traccia */
	String headers[] = { "Nome", "Numero Ascolti", "Tipo Canzone", "Artista" };
	
	/** Tabella ascolti a partire da una traccia. */
	private JTable table = new JTable();
	
	
	/** Modello della tabella a partire dalla ricerca di un utente. */
	DefaultTableModel modelTableAsc = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	/** Header tabella per ricerca a partire da un utente */
	String headers_asc[] = { "Nome", "Fascia Oraria", "Numero Ascolti"};
	
	/** Tabella ascolti a partire da un utente. */
	private JTable table_asc = new JTable();
	
	
	/**
	 * Costruttore PanelInfo
	 *
	 * @param id_utente per utilizzare le funzioni di richiesta
	 * @param tipo_ut ci permette di accedere a questo pannello
	 */
	public PanelInfo(int id_utente, String tipo_ut) {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		
		JScrollPane scrollPaneAsc = new JScrollPane();
		scrollPaneAsc.setVisible(false);
		
		if(tipo_ut.equals("Admin")) {
			searchPanel.setVisible(true);
			scrollPane.setVisible(true);
		}
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(68, 0, 347, 57);
		add(panel_Title);
		
		JLabel lblRicercaInfo = new JLabel("Info");
		lblRicercaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaInfo.setForeground(Color.WHITE);
		lblRicercaInfo.setFont(new Font("Arial", Font.BOLD, 29));
		lblRicercaInfo.setBounds(8, 10, 331, 35);
		panel_Title.add(lblRicercaInfo);
		
		searchPanel.setLayout(null);
		searchPanel.setBackground(Color.GRAY);
		searchPanel.setBounds(2, 60, 477, 180);
		add(searchPanel);
		
		searchField = new JTextField();
		searchField.setBorder(new LineBorder(Color.BLACK, 2, true));
		searchField.setBounds(150, 75, 176, 35);
		searchPanel.add(searchField);
		searchField.setColumns(10);
		
		JComboBox tipoQueryBox = new JComboBox();
		tipoQueryBox.setBorder(new LineBorder(Color.BLACK, 2, true));
		tipoQueryBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Traccia", "Utente"}));
		tipoQueryBox.setBounds(150, 20, 176, 53);
		searchPanel.add(tipoQueryBox);
		
		JButton searchButton = new JButton("Ricerca");
		searchButton.setForeground(Color.BLACK);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchButton.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchButton.setBackground(Color.WHITE);	
			}
		});
		searchButton.setBorder(new LineBorder(Color.BLACK, 2, true));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int box = tipoQueryBox.getSelectedIndex();
				String nome = searchField.getText(); 
				int grandezza;
				AscoltoDAO a = new GetAscoltoDAO();
				scrollPaneAsc.setVisible(false);
				
				switch (box) {
				case 1:
				
				scrollPane.setVisible(true);
				lista_ascolti = a.ritornaAscoltiDaTraccia(nome);
				
				grandezza = lista_ascolti.size();
				
				table = new JTable();
				modelTable.setRowCount(0);
				for (int i = 0; i < grandezza; i++) {
					modelTable.addRow(new Object[] { String.valueOf(lista_ascolti.get(i).getUtente()),
							String.valueOf(lista_ascolti.get(i).getNumeroAscolti()),
							String.valueOf(lista_ascolti.get(i).getTipoCanzone()),
							String.valueOf(lista_ascolti.get(i).getCantanti()),
					});
					}
				
				break;
				case 2:
					
					scrollPane.setVisible(false);
					scrollPaneAsc.setVisible(true);
					lista_ascolti = a.ritornaAscoltiDaUtente(nome);
					
					grandezza = lista_ascolti.size();
					
					table = new JTable();
					modelTableAsc.setRowCount(0);
					for (int i = 0; i < grandezza; i++) {
						modelTableAsc.addRow(new Object[] { String.valueOf(lista_ascolti.get(i).getUtente()),
								String.valueOf(lista_ascolti.get(i).getFasciaOraria()),
								String.valueOf(lista_ascolti.get(i).getNumeroAscolti())
						});
						}
					
				break;
				default:
					JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
				}
			}
		});
		
		modelTable.setColumnIdentifiers(headers);
		modelTableAsc.setColumnIdentifiers(headers_asc);
		
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(2, 241, 477, 344);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		scrollPaneAsc.getViewport().setBackground(Color.WHITE);
		scrollPaneAsc.setBackground(Color.GRAY);
		scrollPaneAsc.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPaneAsc.setBounds(2, 241, 477, 344);
		add(scrollPaneAsc);
		scrollPaneAsc.setViewportView(table_asc);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table = (JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	
		        }
		    }
		});
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modelTable);
		table.setRowHeight(45);
		
		
		table_asc.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table = (JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

		        }
		    }
		});
		table_asc.setGridColor(Color.BLACK);
		table_asc.setFont(new Font("Arial", Font.PLAIN, 14));
		table_asc.setForeground(Color.BLACK);
		table_asc.setBackground(Color.WHITE);
		table_asc.setShowVerticalLines(false);
		table_asc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_asc.setModel(modelTableAsc);
		table_asc.setRowHeight(45);
		
		searchButton.setBounds(188, 122, 98, 29);
		searchPanel.add(searchButton);
	}
}
