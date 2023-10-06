package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import pojo.UserDetailsTemplate;
import com.google.gson.*;

import pojo.UserDetailsTemplate;
import apiCall.LocalDb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class FindBlood {

	DefaultTableModel modelT;
	JFrame frame;
	private JTable table;
	boolean cnfrm = false;
	UserDetailsTemplate me = new UserDetailsTemplate();
	LocalDb allUsers;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FindBlood window = new FindBlood(null);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FindBlood(UserDetailsTemplate me) {
		this.me = me;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 656, 661);
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

//		JLabel greeting = new JLabel("! Good morning");
		JLabel greeting = new JLabel("Hi "+me.getName()+"! Good morning");
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 16));
		greeting.setBounds(393, 16, 226, 43);
		frame.getContentPane().add(greeting);

		JLabel lblStopwatch = new JLabel("Find Blood");
		lblStopwatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblStopwatch.setBounds(219, 66, 157, 43);
		frame.getContentPane().add(lblStopwatch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 253, 612, 294);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		modelT = new DefaultTableModel();
		Object column[] = { "Name", "Blood Group", "Email", "Phone" };
		Object row[] = new Object[4];
		modelT.setColumnIdentifiers(column);
		table.setModel(modelT);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Blood Group");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(104, 118, 107, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblDescription = new JLabel("Area");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(114, 156, 92, 43);
		frame.getContentPane().add(lblDescription);

		String[] str1 = { "A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-" };
		JComboBox comboBox = new JComboBox(str1);
		comboBox.setBounds(221, 124, 74, 22);
		frame.getContentPane().add(comboBox);

		String[] str2 = { "Dhaka", "Natore", "Pabna" };
		JComboBox comboBox_1 = new JComboBox(str2);
		comboBox_1.setBounds(221, 168, 74, 22);
		frame.getContentPane().add(comboBox_1);

		JLabel lblSearchResult = new JLabel("All Records Here");
//		JLabel lblSearchResult = new JLabel("Search Result \"12\" Record Founds");
		lblSearchResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResult.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblSearchResult.setBounds(124, 210, 364, 43);
		frame.getContentPane().add(lblSearchResult);

		ArrayList<UserDetailsTemplate> foundUser = new ArrayList<>();
		ArrayList<UserDetailsTemplate> allUser = new ArrayList<>();
		try {
			allUsers = new LocalDb();
			allUser.addAll(allUsers.getAllUser());
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foundUser.clear();
				allUsers = new LocalDb();
				try {
					for (UserDetailsTemplate elm : allUsers.getAllUser()) {
						if (elm.getBloodGroup().equals(comboBox.getSelectedItem().toString())
								&& elm.getCanDonate() == 1) {
							for (String s : elm.getArea()) {
								if (s.equals(comboBox_1.getSelectedItem().toString())) {
									System.out.println(elm.toString());
									foundUser.add(elm);
									break;
								}
							}
						}
					}
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblSearchResult.setText("Search Result " + "\"" + foundUser.size() + "\"" + " Record Founds");

				while (modelT.getRowCount() > 0) {
					System.out.println("CLEARrrrRRRR");
					modelT.removeRow(0);
				}

				if (modelT.getRowCount() == 0) {

					Object column[] = { "Name", "Blood Group", "Email", "Phone" };
					Object row[] = new Object[4];
					modelT.setColumnIdentifiers(column);
					table.setModel(modelT);
					scrollPane.setViewportView(table);
					for (var tod : foundUser) {
						System.out.println(tod.getName());
						row[0] = tod.getName();
						row[1] = tod.getBloodGroup();
						row[2] = tod.getEmail();
						row[3] = tod.getMobile();
						modelT.addRow(row);
					}
				}
			}
		});
		btnNewButton_1.setToolTipText("Search");
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\icons8-search-blood-53.png"));
		btnNewButton_1.setBounds(313, 124, 89, 69);
		frame.getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(104, 558, 451, 39);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnNewButton_2 = new JButton("Copy Full Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = "Name= "+modelT.getValueAt(table.getSelectedRow(), 0)+" || Blood Group= "+modelT.getValueAt(table.getSelectedRow(), 1)+" || Email= "+modelT.getValueAt(table.getSelectedRow(), 2)+" || Mobile= "+modelT.getValueAt(table.getSelectedRow(), 3);
				System.out.println(str);
				StringSelection strse1 = new StringSelection(str);
				clip.setContents(strse1, strse1);
				JOptionPane.showMessageDialog(null, "DETAILS IS COPIED!");
			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Copy Email");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = (String) modelT.getValueAt(table.getSelectedRow(), 1);
				System.out.println(str);
				StringSelection strse1 = new StringSelection(str);
				clip.setContents(strse1, strse1);
				JOptionPane.showMessageDialog(null, "EMAIL IS COPIED!");
			}
		});
		panel.add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Copy Mobile Number");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				String str = (String) modelT.getValueAt(table.getSelectedRow(), 3);
				System.out.println(str);
				StringSelection strse1 = new StringSelection(str);
				clip.setContents(strse1, strse1);
				JOptionPane.showMessageDialog(null, "MOBILE NUMBER IS COPIED!");
			}
		});
		panel.add(btnNewButton_2_1_1);

		for (var tod : allUser) {
			if(tod.getCanDonate()==1) {	
				row[0] = tod.getName();
				row[1] = tod.getBloodGroup();
				row[2] = tod.getEmail();
				row[3] = tod.getMobile();
				modelT.addRow(row);
			}
		}
	}

}
