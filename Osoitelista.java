import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;

import img.TietojaOhjelmasta;

import java.awt.Toolkit;
import java.awt.Window;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Osoitelista extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	
	public static void main(String[] args) {
		
			
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("J‰rjestysnumero");
		model.addColumn("Laji");
		model.addColumn("P‰iv‰");
		model.addColumn("Kilometrit");
//		
		JFrame ikkuna = new JFrame();
		
		JScrollPane scrollPane = new JScrollPane();

		ikkuna.setTitle("TreeniMuistio");
		ikkuna.getContentPane().add(scrollPane);
		ikkuna.pack();
		ikkuna.setVisible(true);
		
				
		try {
			
			// M‰‰ritell‰‰n tietokannan yhteysosoite ja tietokannan nimi
			String URL = "jdbc:mysql://localhost:3306/treeni";
			// K‰ytt‰j‰tiedot
			String USERID = "root";
			String PASSWORD = "";
			
			// Yhteyden luominen tietokantaan
			Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			System.out.println("Yhteys tietokantaan on luotu.");

			
			Statement stmt = con.createStatement();
//			N‰ytet‰‰n tiedot tietokannasta
			ResultSet rs = stmt.executeQuery("SELECT * FROM TREENI");
			ArrayList<Object[]> data = new ArrayList<Object[]>();
			
			while (rs.next()){
				 data.add(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
			
			for (int i = 0; i < data.size(); i++) {
				model.addRow(data.get(i));
			}
					
			con.close();

		} catch (SQLException e) {
			System.out.println("Virhe tietokannan k‰ytˆss‰!");
			System.out.println(e);
		}
		
		
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Osoitelista frame = new Osoitelista(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param model 
	 */
	public Osoitelista(TableModel model) {
		setTitle("Treenikalenteri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 774, 500);
		
		//yl‰palkki ja tiedosto ja tietoja ohjelmasta menu valikot
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmLopetus = new JMenuItem("Lopetus");
		mntmLopetus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		mnTiedosto.add(mntmLopetus);
		
		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);
		
		JMenuItem mntmTilitysmitenMeni = new JMenuItem("Tilitys,miten meni?");
		mntmTilitysmitenMeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TietojaOhjelmasta.avaaInfo();
			}
		});
		mnTietojaOhjelmasta.add(mntmTilitysmitenMeni);
		
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
 	    
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

//		Window.pack();
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		
		//luodaan alapalkki ja buttons
		JPanel alaPanel = new JPanel();
		alaPanel.setBounds(5, 387, 746, 35);
		contentPane.add(alaPanel);
		
		JButton btnPoistaValittuRivi = new JButton("Poista valittu rivi");
		btnPoistaValittuRivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table_1.getSelectedRow();
				String cell = table_1.getModel().getValueAt(row, 0).toString();
			
				poistaTreeni(cell);

			}
		});
		alaPanel.add(btnPoistaValittuRivi);
		
		
		JButton btnLisRivi = new JButton("Lis\u00E4\u00E4 Treeni");
		btnLisRivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lis‰‰Treeni.avaaTreeni();
			}
		});
		alaPanel.add(btnLisRivi);
		
		
		JButton btnPivitTaulukko = new JButton("P\u00E4ivit\u00E4 taulukko");
		btnPivitTaulukko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				((DefaultTableModel) model).setRowCount(0);
				
				
				try {
						
					// M‰‰ritell‰‰n tietokannan yhteysosoite ja tietokannan nimi
					String URL = "jdbc:mysql://localhost:3306/treeni";
					// K‰ytt‰j‰tiedot
					String USERID = "root";
					String PASSWORD = "";
					
					// Yhteyden luominen tietokantaan
					Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
					System.out.println("Yhteys tietokantaan on luotu.");

					
					Statement stmt = con.createStatement();
					
					
//					N‰ytet‰‰n tiedot tietokannasta
					ResultSet rs = stmt.executeQuery("SELECT * FROM TREENI");
					ArrayList<Object[]> data = new ArrayList<Object[]>();
					
					while (rs.next()){
						 data.add(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
					}
					
					for (int i = 0; i < data.size(); i++) {
						((DefaultTableModel) model).addRow(data.get(i));
					}
							
					con.close();

				} catch (SQLException ei) {
					System.out.println("Virhe tietokannan k‰ytˆss‰!");
					System.out.println(e);
				}
				
				
			}
		});
		
		
		alaPanel.add(btnPivitTaulukko);
		
		table_1 = new JTable(model);
		table_1.setBounds(12, 13, 732, 361);
		contentPane.add(table_1);
		table_1.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 732, 361);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	
			
	}
	
	//T‰‰ll‰ lis‰t‰‰n uusi treeni, muuttujien uudet parametrit saadaan Lis‰‰Treeni luokalta
	
	public static void uusiTreeni(String uusiKpl, String uusiLaji, String uusiPvm, String uusiKm) {
		
		DefaultTableModel model = new DefaultTableModel();
					
			try {
				
				String URL = "jdbc:mysql://localhost:3306/treeni";
				String USERID = "root";
				String PASSWORD = "";
				
				Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			
			String sql = "INSERT INTO TREENI values (?, ?, ?, ?)";
			
		
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
						
			preparedStmt.setString(1, uusiKpl);
			preparedStmt.setString(2, uusiLaji);
			preparedStmt.setString(3, uusiPvm);
			preparedStmt.setString(4, uusiKm);

			preparedStmt.execute();
			

			Statement stmt = con.createStatement();
					

//				N‰ytet‰‰n tiedot tietokannasta
				ResultSet rs = stmt.executeQuery("SELECT * FROM TREENI");
				ArrayList<Object[]> data = new ArrayList<Object[]>();
				
				while (rs.next()){
					 data.add(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
					 model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
				}
				
				for (int i = 0; i < data.size()-1; i++) {
					model.addRow(data.get(i));
				}
				con.close();
						
				
			 
			} catch (SQLException e) {
				System.out.println("Virhe tietokannan k‰ytˆss‰!");
				System.out.println(e);
			}
	}	
	
	
			public static void poistaTreeni(String cell) {
				
	//			DefaultTableModel model = new DefaultTableModel();
				
				try {
					
					String URL = "jdbc:mysql://localhost:3306/treeni";
					String USERID = "root";
					String PASSWORD = "";
					
					Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
				
				
				String sql = "DELETE FROM TREENI WHERE kpl= " +cell;
			
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);			
//				preparedStmt.setString(1, cell);
				preparedStmt.execute();
				

				Statement stmt = con.createStatement();
				stmt.executeQuery("DELETE FROM TREENI WHERE kpl= cell");
				
				JOptionPane.showMessageDialog(null, "Deleted");
				
				}catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}


			
			public static void p‰ivit‰Taulukko() {
				
			DefaultTableModel model = new DefaultTableModel();					
			((DefaultTableModel) model).setRowCount(0);
			
							
			try {
					
				// M‰‰ritell‰‰n tietokannan yhteysosoite ja tietokannan nimi
				String URL = "jdbc:mysql://localhost:3306/treeni";
				// K‰ytt‰j‰tiedot
				String USERID = "root";
				String PASSWORD = "";
				
				// Yhteyden luominen tietokantaan
				Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
				System.out.println("Yhteys tietokantaan on luotu.");

				
				Statement stmt = con.createStatement();
				
				
//				N‰ytet‰‰n tiedot tietokannasta
				ResultSet rs = stmt.executeQuery("SELECT * FROM TREENI");
				ArrayList<Object[]> data = new ArrayList<Object[]>();
				
				while (rs.next()){
					 data.add(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
				}
				
				for (int i = 0; i < data.size(); i++) {
					model.addRow(data.get(i));
				}
						
				con.close();

			} catch (SQLException e) {
				System.out.println("Virhe tietokannan k‰ytˆss‰!");
				System.out.println(e);
			}
			
			
			
			}
		}


			


		

	

