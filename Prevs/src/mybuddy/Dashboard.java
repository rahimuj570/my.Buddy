package mybuddy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 559, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel greeting = new JLabel("Hi name! Good morning");
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 18));
		greeting.setBounds(337, 11, 196, 61);
		frame.getContentPane().add(greeting);
		
		JLabel lblNewLabel = new JLabel("logo");
		lblNewLabel.setBackground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 32, 70, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblD = new JLabel("DASHBOARD");
		lblD.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblD.setBounds(204, 61, 144, 61);
		frame.getContentPane().add(lblD);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 523, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Stopwatch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stopwatch window = new Stopwatch();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 145, 60);
		panel.add(btnNewButton);
		
		JButton btnCounterMaster = new JButton("Counter Master");
		btnCounterMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CounterMaster window = new CounterMaster();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnCounterMaster.setBounds(10, 82, 145, 60);
		panel.add(btnCounterMaster);
		
		JButton btnNotepad = new JButton("Todo-list");
		btnNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoUI window = new TodoUI();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNotepad.setBounds(10, 153, 145, 60);
		panel.add(btnNotepad);
	}
}
