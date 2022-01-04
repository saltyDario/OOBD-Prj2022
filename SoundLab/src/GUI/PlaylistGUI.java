package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.TracciaDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;
import Modelli.Traccia;

public class PlaylistGUI extends JPanel {
	
	DefaultTableModel modelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	String headers[] = { "Nome", "Genere", "Tipo Canzone", "Anno", "Artista" };
	
	private JTable table;
	private ArrayList<Traccia> list = new ArrayList<Traccia>();
	private int grandezza;
	
	public PlaylistGUI(ArrayList<Traccia> list) {
		
		setBackground(Color.GRAY);
		setLayout(null);
		setVisible(true);
		
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
		
		modelTable.setColumnIdentifiers(headers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(0, 53, 477, 420);
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
		
	}
}
