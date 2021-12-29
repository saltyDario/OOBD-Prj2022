package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.LibreriaDAO;
import ImplementazioniPostgresDAO.LibConnectionDAO;
import Modelli.Libreria;
import Modelli.Playlist;
import Modelli.Utente;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.Component;

public class PanelLibrary extends JPanel {
	
	private int numero_playlist;
	private String[] str;
	
	//private DefaultListModel<String> model = new DefaultListModel<>();
	//private JList<String> list = new JList<>(model);
	
	DefaultTableModel modelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	String headers[] = { "Nome", "Tracce" };
	private JTable table = new JTable();
	
	public PanelLibrary(String username, int id_utente) {
		setBackground(Color.GRAY);
		setBounds(0, 0, 481, 592);
		setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBackground(Color.GRAY);
		panel_Title.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_Title.setBounds(68, 0, 347, 57);
		add(panel_Title);
		panel_Title.setLayout(null);
		
		JLabel labelBenvenuto = new JLabel("Libreria di "+ username);
		labelBenvenuto.setForeground(Color.WHITE);
		labelBenvenuto.setBounds(8, 10, 331, 35);
		panel_Title.add(labelBenvenuto);
		labelBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		labelBenvenuto.setFont(new Font("Arial", Font.BOLD, 29));
		
		JPanel plusPanel = new JPanel();
		plusPanel.setToolTipText("Aggiungi Playlist.");
		plusPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				plusPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				plusPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				plusPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				plusPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPlaylist addplaylist = new AddPlaylist(id_utente);
			}
		});
		plusPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		plusPanel.setBackground(Color.GRAY);
		plusPanel.setBounds(433, 72, 38, 37);
		add(plusPanel);
		plusPanel.setLayout(null);
		
		JLabel plusLabel = new JLabel("");
		plusLabel.setBounds(0, 0, 38, 37);
		plusPanel.add(plusLabel);
		plusLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/plus.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		plusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel playlistPanel = new JPanel();
		playlistPanel.setBackground(Color.GRAY);
		playlistPanel.setBounds(2, 111, 477, 473);
		add(playlistPanel);
		playlistPanel.setLayout(null);
		
		JPanel refreshPanel = new JPanel();
		refreshPanel.setToolTipText("Refresh Playlist.");
		refreshPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refreshPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refreshPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				refreshPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Libreria libs;
				
				Utente u = new Utente(username);
				LibreriaDAO l = new LibConnectionDAO();
				libs = l.ritornaLibreria(id_utente);
				
				ArrayList<Playlist> lista_playlist = new ArrayList<Playlist>();
				lista_playlist = libs.getPlaylist();
				
				/*str = new String[lista_playlist.size()];
				for(int i = 0; i < lista_playlist.size(); i++) {
					str[i] = lista_playlist.get(i).getNomePlaylist();
				}
				
				list = new JList<>(str);
				for (int i=0; i < lista_playlist.size(); i++){
				    model.addElement(str[i]);
				}*/
				
				table = new JTable();
				modelTable.setRowCount(0);
				for (int i = 0; i < lista_playlist.size(); i++) {
					modelTable.addRow(new Object[] { String.valueOf(lista_playlist.get(i).getNomePlaylist()),
							String.valueOf(lista_playlist.get(i).getNumeroTracce())});
					}
			}
		});
		

		
		//JList<Object> list = new JList<Object>(str);
		/*list.setBounds(286, 21, 167, 387);
		playlistPanel.add(list);*/
		
		/*table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            
	        }
	    });*/
		//table = new JTable();
		modelTable.setColumnIdentifiers(headers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(0, 0, 477, 473);
		playlistPanel.add(scrollPane);
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
		
		refreshPanel.setLayout(null);
		refreshPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		refreshPanel.setBackground(Color.GRAY);
		refreshPanel.setBounds(396, 72, 38, 37);
		add(refreshPanel);
		
		JLabel refreshLabel = new JLabel("");
		refreshLabel.setBounds(0, 0, 38, 37);
		refreshPanel.add(refreshLabel);
		refreshLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/refreshing.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		
	}
}
