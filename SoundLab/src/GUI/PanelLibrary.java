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
import DAO.PlaylistDAO;
import DAO.TracciaDAO;
import ImplementazioniPostgresDAO.GetTracceDAO;
import ImplementazioniPostgresDAO.LibConnectionDAO;
import ImplementazioniPostgresDAO.PlaylistConnectionDAO;
import Modelli.Libreria;
import Modelli.Playlist;
import Modelli.Traccia;
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
import javax.swing.DebugGraphics;

public class PanelLibrary extends JPanel {
	
	private int numero_playlist;
	private int id_playlist;
	private String[] str;
	private String playlist_pref;
	
	private Libreria libs;
	private ArrayList<Playlist> lista_playlist = new ArrayList<Playlist>();
	private ArrayList<Traccia> list = new ArrayList<Traccia>();
	
	DefaultTableModel modelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	String headers[] = { "Nome", "Tracce", "Genere", "Preferita" };
	private JTable table = new JTable();
	
	
	DefaultTableModel modelTableTracce = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	String headersTracce[] = {  "Nome", "Genere", "Tipo Canzone", "Anno", "Artista" };
	private JTable tableTracce = new JTable();
	
	public PanelLibrary(String username, int id_utente) {
		Utente u = new Utente(username);
		
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
				AddPlaylist addplaylist = new AddPlaylist(id_utente);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		
		JPanel refreshPanelPlaylist = new JPanel();
		refreshPanelPlaylist.setToolTipText("Refresh Playlist.");
		refreshPanelPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshPanelPlaylist.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refreshPanelPlaylist.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refreshPanelPlaylist.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				refreshPanelPlaylist.setBackground(Color.DARK_GRAY);
				
	        	TracciaDAO t = new GetTracceDAO();
	            int id_playlist_loc = id_playlist;
	      
	            list = t.ritornaTraccePlaylist(id_playlist_loc);
	            
		        System.out.println(""+ id_playlist_loc);
		        
					modelTableTracce.setRowCount(0);
					for (int i = 0; i < list.size(); i++) {
						modelTableTracce.addRow(new Object[] { String.valueOf(list.get(i).getNomeTraccia()),
								String.valueOf(list.get(i).getGenereTraccia()),
								String.valueOf(list.get(i).getTipoTraccia()),
								String.valueOf(list.get(i).getAnnoTraccia()),
								String.valueOf(list.get(i).getCantanti())});
						}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		refreshPanelPlaylist.setLayout(null);
		refreshPanelPlaylist.setBorder(new LineBorder(Color.BLACK, 2, true));
		refreshPanelPlaylist.setBackground(Color.GRAY);
		refreshPanelPlaylist.setBounds(396, 72, 38, 37);
		add(refreshPanelPlaylist);
		refreshPanelPlaylist.setVisible(false);
		
		JLabel refreshLabelPl = new JLabel("");
		refreshLabelPl.setBounds(0, 0, 38, 37);
		refreshPanelPlaylist.add(refreshLabelPl);
		refreshLabelPl.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLabelPl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/refreshing.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		
		JPanel refreshPanel = new JPanel();
		refreshPanel.setToolTipText("Refresh Libreria.");
		refreshPanel.setLayout(null);
		refreshPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		refreshPanel.setBackground(Color.GRAY);
		refreshPanel.setBounds(396, 72, 38, 37);
		add(refreshPanel);
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
				LibreriaDAO l = new LibConnectionDAO();
				
				libs = l.ritornaLibreria(u.getId());
				lista_playlist = libs.getPlaylist();
				
				modelTable.setRowCount(0);
				for (int i = 0; i < lista_playlist.size(); i++) {
					modelTable.addRow(new Object[] { String.valueOf(lista_playlist.get(i).getNomePlaylist()),
							String.valueOf(lista_playlist.get(i).getNumeroTracce()),
							String.valueOf(lista_playlist.get(i).getGenere()),
							String.valueOf(lista_playlist.get(i).getFavorite())});
					}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		JPanel downloadLibPanel = new JPanel();
		downloadLibPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				downloadLibPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				downloadLibPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				downloadLibPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				downloadLibPanel.setBackground(Color.DARK_GRAY);
				LibreriaDAO l = new LibConnectionDAO();
				
				libs = l.ritornaLibreria(u.getId());
				lista_playlist = libs.getPlaylist();
				
				modelTable.setRowCount(0);
				for (int i = 0; i < lista_playlist.size(); i++) {
					modelTable.addRow(new Object[] { String.valueOf(lista_playlist.get(i).getNomePlaylist()),
							String.valueOf(lista_playlist.get(i).getNumeroTracce()),
							String.valueOf(lista_playlist.get(i).getGenere()),
							String.valueOf(lista_playlist.get(i).getFavorite())});
					}
			}
		});
		downloadLibPanel.setLayout(null);
		downloadLibPanel.setToolTipText("Avvia libreria.");
		downloadLibPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		downloadLibPanel.setBackground(Color.GRAY);
		downloadLibPanel.setBounds(219, 72, 38, 37);
		add(downloadLibPanel);
		
		JLabel downloadLabel = new JLabel("");
		downloadLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/power.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		downloadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		downloadLabel.setBounds(0, 0, 38, 37);
		downloadLibPanel.add(downloadLabel);
		
		JPanel prefPlaylistPanel = new JPanel();
		prefPlaylistPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				prefPlaylistPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prefPlaylistPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				prefPlaylistPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				prefPlaylistPanel.setBackground(Color.DARK_GRAY);
				
				String ok = null;

				if(playlist_pref.equals("Pref")) {
					playlist_pref = "true";
				}else {
					playlist_pref = "false";
				}
				//System.out.println(""+ playlist_pref);
				int id_playlist_loc = id_playlist;
				
				PlaylistDAO p = new PlaylistConnectionDAO();
				ok = p.togglePreferita(id_playlist_loc, playlist_pref);
				
				if(ok.equals("true")) {
					JOptionPane.showMessageDialog(null, "La Playlist � adesso preferita.");
				}else if(ok.equals("false")){
					JOptionPane.showMessageDialog(null, "La Playlist � adesso non pi� preferita.");
				}
			}
		});
		prefPlaylistPanel.setLayout(null);
		prefPlaylistPanel.setToolTipText("Inserisci/rimuovi la playlist dai preferiti.");
		prefPlaylistPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		prefPlaylistPanel.setBackground(Color.GRAY);
		prefPlaylistPanel.setBounds(219, 72, 38, 37);
		add(prefPlaylistPanel);
		prefPlaylistPanel.setVisible(false);
		
		JLabel prefLabel = new JLabel("");
		prefLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/star.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		prefLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prefLabel.setBounds(0, 0, 38, 37);
		prefPlaylistPanel.add(prefLabel);
		
		
		modelTable.setColumnIdentifiers(headers);
		modelTableTracce.setColumnIdentifiers(headersTracce);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(0, 0, 477, 473);
		playlistPanel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPaneTracce = new JScrollPane();
		scrollPaneTracce.getViewport().setBackground(Color.WHITE);
		scrollPaneTracce.setBackground(Color.GRAY);
		scrollPaneTracce.setBorder(new LineBorder(Color.GRAY, 2));
		scrollPaneTracce.setBounds(0, 0, 477, 473);
		playlistPanel.add(scrollPaneTracce);
		scrollPaneTracce.setViewportView(tableTracce);
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setToolTipText("Torna alla Libreria.");
		backPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		backPanel.setBackground(Color.GRAY);
		backPanel.setBounds(4, 72, 82, 37);
		add(backPanel);
		backPanel.setVisible(false);
		
		JPanel binPanel = new JPanel();
		binPanel.setToolTipText("Elimina Playlist.");
		binPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				binPanel.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				binPanel.setBackground(Color.GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				binPanel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				binPanel.setBackground(Color.DARK_GRAY);
				
				if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare la playlist?", "Conferma", JOptionPane.YES_NO_OPTION) == 0) {
					PlaylistDAO p = new PlaylistConnectionDAO();
					boolean ok;
					
					ok = p.eliminaPlaylist(id_playlist);
					if(ok == true) {
						JOptionPane.showMessageDialog(null, "Playlist eliminata con successo.");
						
						scrollPaneTracce.setVisible(false);
						backPanel.setVisible(false);
						prefPlaylistPanel.setVisible(false);
						refreshPanelPlaylist.setVisible(false);
						binPanel.setVisible(false);
			            scrollPane.setVisible(true);
			            refreshPanel.setVisible(true);
			            plusPanel.setVisible(true);
			            downloadLibPanel.setVisible(true);
					}
					
				}	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		binPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		binPanel.setBackground(Color.GRAY);
		binPanel.setBounds(433, 72, 38, 37);
		add(binPanel);
		binPanel.setLayout(null);
		binPanel.setVisible(false);
		
		JLabel binLabel = new JLabel("");
		binLabel.setBounds(0, 0, 38, 37);
		binPanel.add(binLabel);
		binLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/bin.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		binLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
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
				
				scrollPaneTracce.setVisible(false);
				backPanel.setVisible(false);
				prefPlaylistPanel.setVisible(false);
				refreshPanelPlaylist.setVisible(false);
				binPanel.setVisible(false);
	            scrollPane.setVisible(true);
	            refreshPanel.setVisible(true);
	            plusPanel.setVisible(true);
	            downloadLibPanel.setVisible(true);
			}
		});
		
		JLabel backLabel = new JLabel("");
		backLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/arrow.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backLabel.setBounds(0, 0, 82, 37);
		backPanel.add(backLabel);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table = (JTable) mouseEvent.getSource();
		        Point punto = mouseEvent.getPoint();
		        int righe = table.rowAtPoint(punto);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            
		        	TracciaDAO t = new GetTracceDAO();
		            Object obj = GetData(table, table.getSelectedRow(), 0);
		            
		            id_playlist = lista_playlist.get(table.getSelectedRow()).getIDPlaylist();
		            playlist_pref = lista_playlist.get(table.getSelectedRow()).getFavorite();
		            list = t.ritornaTraccePlaylist(id_playlist);
		            
		            if(list.size() > 0) {
			            scrollPane.setVisible(false);
			            refreshPanel.setVisible(false);
			            plusPanel.setVisible(false);
			            downloadLibPanel.setVisible(false);
			            
						modelTableTracce.setRowCount(0);
						for (int i = 0; i < list.size(); i++) {
							modelTableTracce.addRow(new Object[] { String.valueOf(list.get(i).getNomeTraccia()),
									String.valueOf(list.get(i).getGenereTraccia()),
									String.valueOf(list.get(i).getTipoTraccia()),
									String.valueOf(list.get(i).getAnnoTraccia()),
									String.valueOf(list.get(i).getCantanti())});
							}
						prefPlaylistPanel.setVisible(true);
						refreshPanelPlaylist.setVisible(true);
						backPanel.setVisible(true);
			            scrollPaneTracce.setVisible(true);
			            binPanel.setVisible(true);
		            }else {
		            	JOptionPane.showMessageDialog(null, "La Playlist "+ obj +" e' vuota");
		            }
		        }
		    }
		});
		
		tableTracce.setGridColor(Color.BLACK);
		tableTracce.setFont(new Font("Arial", Font.PLAIN, 14));
		tableTracce.setForeground(Color.BLACK);
		tableTracce.setBackground(Color.WHITE);
		tableTracce.setShowVerticalLines(false);
		tableTracce.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTracce.setModel(modelTableTracce);
		tableTracce.setRowHeight(45);
		
		
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modelTable);
		table.setRowHeight(45);
		
		JLabel refreshLabel = new JLabel("");
		refreshLabel.setBounds(0, 0, 38, 37);
		refreshPanel.add(refreshLabel);
		refreshLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Immagini/refreshing.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		
		//playlist_open.setVisible(true);
		//paneMainContent.add(playlistPane);
	}

	 public Object GetData(JTable table, int row_index, int col_index){
		  return table.getModel().getValueAt(row_index, col_index);
		  }
}
