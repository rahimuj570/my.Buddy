package model;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import pojo.PostRequest;
import pojo.UserDetailsTemplate;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import apiCall.LocalDb;

public class NewsFeed {

	DefaultTableModel model;
	JFrame frame;
	private JTable table;
	boolean cnfrm = false;
	UserDetailsTemplate me;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsFeed window = new NewsFeed();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public NewsFeed() {
		initialize();
	}

	public NewsFeed(UserDetailsTemplate me) {
		this.me = me;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 0, 775, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Back to Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard window = null;
				try {
					window = new Dashboard(me, "Welcome Back");
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(18, 18, 149, 32);
		frame.getContentPane().add(btnNewButton);

//		JLabel greeting = new JLabel("Hi name! Good morning");
		JLabel greeting = new JLabel("Hi "+me.getName().toUpperCase()+"!");
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 16));
		greeting.setBounds(396, 16, 188, 43);
		frame.getContentPane().add(greeting);

		JLabel lblStopwatch = new JLabel("News Feed");
		lblStopwatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblStopwatch.setBounds(300, 70, 157, 43);
		frame.getContentPane().add(lblStopwatch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 116, 720, 486);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel();
		Object column[] = { "Patient's Name", "Blood", "Why Need", "Location", "Hospital", "Date", "Mobile" };
		Object row[] = new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		String[] str1 = { "A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-" };

		String[] str2 = { "Dhaka", "Natore", "Pabna" };

		JButton btnNewButton_2_1 = new JButton("Copy Number");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBounds(308, 613, 149, 43);
		frame.getContentPane().add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = (String) model.getValueAt(table.getSelectedRow(), 6);
				System.out.println(str);
				StringSelection strse1 = new StringSelection(str);
				clip.setContents(strse1, strse1);
				JOptionPane.showMessageDialog(null, "MOBILE NUMBER IS COPIED!");
					}
				

			
		});

		LocalDb todos = new LocalDb();
		try {
			if (todos.getAllPost() == null) {
			} else {

				for (var posts : todos.getAllPost()) {
					row[0] = posts.getName();
					row[1] = posts.getBlood();
					row[2] = posts.getCause();
					row[3] = posts.getArea();
					row[4] = posts.getHospital();
					row[5] = posts.getDate();
					row[6] = posts.getMobile();
					model.addRow(row);
				}
			}
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
