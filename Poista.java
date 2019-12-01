

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;


import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class Poista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnPoistaRivi;
	
	public String gettextfield() {
		String poista = textField.getText();
		return poista;
	}

	public void settextField(JTextField textField) {
		this.textField = textField;
	}


	public Poista() {
		setTitle("PoistaTreeni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKirjoitaPoistettavanTreenin = new JLabel("ANNA POISTETTAVAN J\u00C4RJESTYSNUMERO");
		lblKirjoitaPoistettavanTreenin.setBounds(5, 5, 422, 25);
		lblKirjoitaPoistettavanTreenin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblKirjoitaPoistettavanTreenin);
// Sulje ruutu dispose		
		JButton btnPoista = new JButton("Palaa Treenimuistioon");
		btnPoista.setBounds(5, 197, 422, 51);
		btnPoista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		contentPane.add(btnPoista);
		
		textField = new JTextField();
		textField.setBounds(12, 80, 143, 51);
		contentPane.add(textField);
		textField.setColumns(10);

// Poista rivi etsii poistettavan tekstikentän ja palauttaa sen osoitelistan metodille poistaTreeni		
		btnPoistaRivi = new JButton("Poista rivi");
		btnPoistaRivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				String poistettava = gettextfield();
				Osoitelista.poistaTreeni(poistettava);	
			
			}
		});
		btnPoistaRivi.setBounds(216, 80, 143, 51);
		contentPane.add(btnPoistaRivi);
	}

	public static void avaaPoista() {
		Poista frame = new Poista();
		frame.setVisible(true);
					
	}
}
