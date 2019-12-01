import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
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

public class Lis‰‰Treeni extends JFrame {

	private static final String Lis‰‰Treeni = null;
	private JPanel contentPane;
	private JTextField txtValitseTreeni;
	private JTextField txtJrjestysnumero;
	private JTextField txtPivmr;
	private JTextField txtKilometrit;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public String gettextfield() {
		String kpl = textField.getText();
		return kpl;
	}

	public void settextField(JTextField textField) {
		this.textField = textField;
	}
	public String gettextfield_1() {
		String laji = textField_1.getText();
		return laji;
	}

	public void settextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	public String gettextfield_2() {
		String pvm = textField_2.getText();
		return pvm;
	}

	public void settextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	public String gettextfield_3() {
		String km = textField_3.getText();
		return km;
	}

	public void settextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public Lis‰‰Treeni() {
		setTitle("Lis‰‰ Uusi Treeni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtValitseTreeni = new JTextField();
		txtValitseTreeni.setBounds(12, 98, 116, 35);
		txtValitseTreeni.setText("Valitse treeni");
		contentPane.add(txtValitseTreeni);
		txtValitseTreeni.setColumns(10);
		
		txtJrjestysnumero = new JTextField();
		txtJrjestysnumero.setText("J\u00E4rjestysnumero");
		txtJrjestysnumero.setBounds(12, 50, 116, 35);
		contentPane.add(txtJrjestysnumero);
		txtJrjestysnumero.setColumns(10);
		
		txtPivmr = new JTextField();
		txtPivmr.setText("P\u00E4iv\u00E4m\u00E4\u00E4r\u00E4");
		txtPivmr.setBounds(12, 146, 116, 33);
		contentPane.add(txtPivmr);
		txtPivmr.setColumns(10);
		
		txtKilometrit = new JTextField();
		txtKilometrit.setText("Kilometrit");
		txtKilometrit.setBounds(12, 192, 116, 34);
		contentPane.add(txtKilometrit);
		txtKilometrit.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(157, 50, 116, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 98, 116, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 146, 116, 33);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 192, 116, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Lis\u00E4\u00E4 Treeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uusiKpl= gettextfield();
				String uusiLaji =gettextfield_1();
				String uusiPvm =gettextfield_2();
				String uusiKm = gettextfield_3();
				
				Osoitelista.uusiTreeni(uusiKpl, uusiLaji, uusiPvm, uusiKm);	
			
			
			}	
		});
		btnNewButton.setBounds(308, 85, 112, 48);
		contentPane.add(btnNewButton);
		
		JButton btnTreenipivkija = new JButton("Takaisin");
		btnTreenipivkija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnTreenipivkija.setBounds(308, 156, 112, 57);
		contentPane.add(btnTreenipivkija);
	}
	


	public Lis‰‰Treeni(String uusiKpl, String uusiLaji, String uusiPvm, String uusiKm) {
		// TODO Auto-generated constructor stub
	}

	public static void avaaTreeni() {
		Lis‰‰Treeni frame = new Lis‰‰Treeni();
		frame.setVisible(true);
		
			
	}
	
	}

