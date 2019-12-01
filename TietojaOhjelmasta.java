package img;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TietojaOhjelmasta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TietojaOhjelmasta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(TietojaOhjelmasta.class.getResource("/img/favicon.png")));
		splitPane.setRightComponent(lblNewLabel);
		
		JLabel lblTietojaOhjelmastaNytetn = new JLabel("Tietoja ohjelmasta n\u00E4ytet\u00E4\u00E4n t\u00E4\u00E4ss\u00E4 ");
		lblTietojaOhjelmastaNytetn.setBackground(Color.LIGHT_GRAY);
		splitPane.setLeftComponent(lblTietojaOhjelmastaNytetn);
	}
	public static void avaaInfo() {
		TietojaOhjelmasta frame = new TietojaOhjelmasta();
		frame.setVisible(true);
}
}