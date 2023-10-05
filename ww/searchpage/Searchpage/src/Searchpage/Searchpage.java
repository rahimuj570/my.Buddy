package Searchpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTable;

public class Searchpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchpage window = new Searchpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Searchpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Donors");
		lblNewLabel.setBounds(57, 30, 172, 25);
		lblNewLabel.setForeground(new Color(205, 92, 92));
		lblNewLabel.setBackground(new Color(218, 112, 214));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Show more");
		btnNewButton_3.setBounds(84, 366, 118, 25);
		btnNewButton_3.setBackground(new Color(173, 216, 230));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_3);
		frame.setBounds(100, 100, 302, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
