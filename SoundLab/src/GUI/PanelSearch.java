package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AlbumDAO;
import DAO.TracciaDAO;
import ImplementazioniPostgresDAO.GetAlbumDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;
import Modelli.Album;
import Modelli.Traccia;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelSearch extends JPanel {
	private JTextField searchField;

	DefaultTableModel modelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	String headers[] = { "Nome", "Genere", "Tipo Canzone", "Anno", "Artista" };
	
	private JTable table = new JTable();
	
	public PanelSearch() {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setLayout(null);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBounds(68, 0, 347, 57);
		add(panel_Title);
		
		JLabel lblRicercaTracce = new JLabel("Ricerca tracce");
		lblRicercaTracce.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercaTracce.setForeground(Color.WHITE);
		lblRicercaTracce.setFont(new Font("Arial", Font.BOLD, 29));
		lblRicercaTracce.setBounds(8, 10, 331, 35);
		panel_Title.add(lblRicercaTracce);
		
		JPanel searchPanel = new JPanel();
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
		tipoQueryBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Traccia", "Artista", "Album"}));
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
				
				ArrayList<Traccia> list = new ArrayList<Traccia>();
				
				TracciaDAO t = new GetTracceDAO();
				
				int grandezza;
				
				switch (box) {
				case 1:

				list = t.ritornaTracce(nome);
				
				grandezza = list.size();
				
				table = new JTable();
				modelTable.setRowCount(0);
				for (int i = 0; i < grandezza; i++) {
					modelTable.addRow(new Object[] { String.valueOf(list.get(i).getNomeTraccia()),
							String.valueOf(list.get(i).getGenereTraccia()),
							String.valueOf(list.get(i).getTipoTraccia()),
							String.valueOf(list.get(i).getAnnoTraccia()),
							String.valueOf(list.get(i).getCantanti())
					});
					}
				
				break;
				case 2:
					
					list = t.ritornaTraccePerArtista(nome);
					
					grandezza = list.size();
					
					table = new JTable();
					modelTable.setRowCount(0);
					for (int i = 0; i < grandezza; i++) {
						modelTable.addRow(new Object[] { String.valueOf(list.get(i).getNomeTraccia()),
								String.valueOf(list.get(i).getGenereTraccia()),
								String.valueOf(list.get(i).getTipoTraccia()),
								String.valueOf(list.get(i).getAnnoTraccia()),
								String.valueOf(list.get(i).getCantanti())
						});
						}
					
				break;
				case 3:
					
					list = t.ritornaDaAlbum(nome);
					
					grandezza = list.size();
					
					table = new JTable();
					modelTable.setRowCount(0);
					for (int i = 0; i < grandezza; i++) {
						modelTable.addRow(new Object[] { String.valueOf(list.get(i).getNomeTraccia()),
								String.valueOf(list.get(i).getGenereTraccia()),
								String.valueOf(list.get(i).getAnnoTraccia()),
								String.valueOf(list.get(i).getTipoTraccia()),
								String.valueOf(list.get(i).getCantanti())});
						}
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
				}
			}
		});
		
		modelTable.setColumnIdentifiers(headers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(2, 241, 477, 344);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            System.out.println("okokok");
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
		
		searchButton.setBounds(188, 122, 98, 29);
		searchPanel.add(searchButton);
	}
}
