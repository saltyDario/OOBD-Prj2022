package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSearch extends JPanel {
	private JTable resultTable;
	private JTextField searchField;

	/**
	 * Create the panel.
	 */
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
		searchPanel.setBounds(2, 88, 477, 473);
		add(searchPanel);
		
		resultTable = new JTable();
		resultTable.setShowVerticalLines(false);
		resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultTable.setGridColor(Color.BLACK);
		resultTable.setForeground(Color.WHITE);
		resultTable.setFont(new Font("Arial", Font.PLAIN, 14));
		resultTable.setBackground(Color.GRAY);
		resultTable.setBounds(38, 199, 396, 239);
		searchPanel.add(resultTable);
		
		searchField = new JTextField();
		searchField.setBounds(249, 43, 165, 37);
		searchPanel.add(searchField);
		searchField.setColumns(10);
		
		JComboBox tipoQueryBox = new JComboBox();
		tipoQueryBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Traccia", "Artista", "Album"}));
		tipoQueryBox.setBounds(38, 41, 162, 38);
		searchPanel.add(tipoQueryBox);
		
		JButton searchButton = new JButton("Ricerca");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int box = tipoQueryBox.getSelectedIndex();
				switch (box) {
				case 1:
				//System.out.print("1");
				
				break;
				case 2:
				//System.out.println("2");
				break;
				case 3:
				//System.out.println("3");
				break;
				default:
				JOptionPane.showMessageDialog(null, "Non hai selezionato un tipo di ricerca, selezionane uno.");
				}
			}
		});
		searchButton.setBounds(188, 122, 89, 23);
		searchPanel.add(searchButton);
	}
}
