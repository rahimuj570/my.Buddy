package model;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import apiCall.LocalDb;
import pojo.PostRequest;
import pojo.UserDetailsTemplate;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class PostGui {

	DefaultTableModel model;
	JFrame frame;
	private JTable table;
	private JTextField nameF;
	boolean cnfrm = false;
	UserDetailsTemplate me;
	private JTextField hospitaF;
	private JTextField causeF;
	private JTextField dateF;
	private JTextField mobileF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostGui window = new PostGui();
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
	public PostGui() {
		initialize();
	}

	public PostGui(UserDetailsTemplate me) {
		this.me = me;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 0, 699, 706);
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

		JLabel lblStopwatch = new JLabel("My Post");
		lblStopwatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblStopwatch.setBounds(237, 76, 157, 43);
		frame.getContentPane().add(lblStopwatch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 340, 655, 262);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel();
		Object column[] = { "Patient's Name", "Blood", "Why Need", "Location", "Hospital", "Date", "Mobile" };
		Object row[] = new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Pataitn Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 124, 132, 32);
		frame.getContentPane().add(lblNewLabel);

		nameF = new JTextField();
		nameF.setBounds(198, 130, 275, 26);
		frame.getContentPane().add(nameF);
		nameF.setColumns(10);

		JLabel lblDescription = new JLabel("Blood Group");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(98, 159, 92, 32);
		frame.getContentPane().add(lblDescription);

		String[] str1 = { "A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-" };
		JComboBox comboBox = new JComboBox(str1);
		comboBox.setBounds(198, 166, 81, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblHospitalName = new JLabel("Hospital Name");
		lblHospitalName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHospitalName.setBounds(73, 191, 132, 32);
		frame.getContentPane().add(lblHospitalName);

		hospitaF = new JTextField();
		hospitaF.setColumns(10);
		hospitaF.setBounds(200, 196, 273, 26);
		frame.getContentPane().add(hospitaF);

		JLabel lblArea = new JLabel("Area");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(324, 159, 81, 32);
		frame.getContentPane().add(lblArea);

		String[] str2 = { "Dhaka", "Natore", "Pabna" };
		JComboBox comboBox_1 = new JComboBox(str2);
		comboBox_1.setBounds(392, 167, 81, 22);
		frame.getContentPane().add(comboBox_1);

		JLabel lblWhyNeedBlood = new JLabel("Why Need Blood?");
		lblWhyNeedBlood.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhyNeedBlood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWhyNeedBlood.setBounds(64, 227, 140, 32);
		frame.getContentPane().add(lblWhyNeedBlood);

		causeF = new JTextField();
		causeF.setColumns(10);
		causeF.setBounds(200, 234, 273, 26);
		frame.getContentPane().add(causeF);

		JLabel lblWhenNeedBlood = new JLabel("When Need Blood?");
		lblWhenNeedBlood.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhenNeedBlood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWhenNeedBlood.setBounds(55, 262, 149, 32);
		frame.getContentPane().add(lblWhenNeedBlood);

		dateF = new JTextField();
		dateF.setColumns(10);
		dateF.setBounds(200, 270, 273, 26);
		frame.getContentPane().add(dateF);
		mobileF = new JTextField();
		mobileF.setColumns(10);
		mobileF.setBounds(199, 303, 273, 26);
		frame.getContentPane().add(mobileF);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PostRequest posts = new PostRequest();
				posts.setArea(comboBox_1.getSelectedItem().toString());
				posts.setBlood(comboBox.getSelectedItem().toString());
				posts.setCause(causeF.getText());
				posts.setDate(dateF.getText());
				posts.setHospital(hospitaF.getText());
				posts.setMobile(mobileF.getText());
				posts.setName(nameF.getText());
				posts.setAuthorMail(me.getEmail());
				if (posts.getName().length() == 0 || posts.getBlood().length() == 0 || posts.getArea().length() == 0
						|| posts.getCause().length() == 0 || posts.getMobile().length() == 0) {
					JOptionPane.showMessageDialog(frame, "Empty field is not allowed", "Invalid",
							JOptionPane.WARNING_MESSAGE, null);
				} else {
					try {
						LocalDb localDb = new LocalDb(posts);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					row[0] = posts.getName();
					row[1] = posts.getBlood();
					row[2] = posts.getCause();
					row[3] = posts.getArea();
					row[4] = posts.getHospital();
					row[5] = posts.getDate();
					row[6] = posts.getMobile();
					model.addRow(row);
					JOptionPane.showMessageDialog(frame, "Successully Added!", "Done", JOptionPane.INFORMATION_MESSAGE,
							null);
					nameF.setText("");
					causeF.setText("");
					dateF.setText("");
					hospitaF.setText("");
					mobileF.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(505, 124, 89, 205);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				int rmv = table.getSelectedRow();
				if (table.isRowSelected(rmv)) {
					List<PostRequest> tdo = new ArrayList<PostRequest>();
					model.removeRow(rmv);
					for (int i = 0; i < table.getRowCount(); i++) { // Loop through the rows
						PostRequest ent = new PostRequest();
						for (int j = 0; j < table.getColumnCount(); j++) {
							String s = model.getValueAt(i, j).toString();
							row[j] = s;
						}
						ent.setArea(row[3].toString());
						ent.setBlood(row[1].toString());
						ent.setCause(row[2].toString());
						ent.setDate(row[5].toString());
						ent.setHospital(row[4].toString());
						ent.setMobile(row[6].toString());
						ent.setName(row[0].toString());
						ent.setAuthorMail(me.getEmail());

						tdo.add(ent);
					}
					try {
						LocalDb aftrDlt = new LocalDb(tdo);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Successully Deleted!", "Done",
							JOptionPane.INFORMATION_MESSAGE, null);
					nameF.setText("");
					causeF.setText("");
					dateF.setText("");
					hospitaF.setText("");
					mobileF.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "Which data you want to delete?!", "???",
							JOptionPane.WARNING_MESSAGE, null);
				}

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(172, 613, 113, 43);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobile.setBounds(100, 293, 100, 32);
		frame.getContentPane().add(lblMobile);

		JButton btnNewButton_2_1 = new JButton("Edit");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBounds(320, 613, 113, 43);
		frame.getContentPane().add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int edt = table.getSelectedRow();
				if (table.isRowSelected(edt)) {
					if (cnfrm == false) {
						nameF.setText(model.getValueAt(edt, 0).toString());
						causeF.setText(model.getValueAt(edt, 2).toString());
						hospitaF.setText(model.getValueAt(edt, 4).toString());
						dateF.setText(model.getValueAt(edt, 5).toString());
						mobileF.setText(model.getValueAt(edt, 6).toString());
						cnfrm = true;
						btnNewButton_2_1.setText("Confirm Edit");
						btnNewButton_2_1.setBackground(Color.GREEN);
					} else {
						JOptionPane.showMessageDialog(frame, "Successully Edited!", "Done",
								JOptionPane.INFORMATION_MESSAGE, null);
						btnNewButton_2_1.setBackground(null);
						btnNewButton_2_1.setText("Edit");
						List<PostRequest> tdo = new ArrayList<PostRequest>();
						model.setValueAt(nameF.getText(), edt, 0);
						model.setValueAt(comboBox.getSelectedItem().toString(), edt, 1);
						model.setValueAt(causeF.getText(), edt, 2);
						model.setValueAt(comboBox_1.getSelectedItem().toString(), edt, 3);
						model.setValueAt(hospitaF.getText(), edt, 4);
						model.setValueAt(dateF.getText(), edt, 5);
						model.setValueAt(mobileF.getText(), edt, 6);
						for (int i = 0; i < table.getRowCount(); i++) { // Loop through the rows
							PostRequest ent = new PostRequest();
							for (int j = 0; j < table.getColumnCount(); j++) {
								String s = model.getValueAt(i, j).toString();
								row[j] = s;
							}
							ent.setArea(row[3].toString());
							ent.setBlood(row[1].toString());
							ent.setCause(row[2].toString());
							ent.setDate(row[5].toString());
							ent.setHospital(row[4].toString());
							ent.setMobile(row[6].toString());
							ent.setName(row[0].toString());
							ent.setAuthorMail(me.getEmail());
							tdo.add(ent);
						}
						try {
							LocalDb aftrDlt = new LocalDb(tdo);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						cnfrm = false;
						nameF.setText("");
						causeF.setText("");
						dateF.setText("");
						hospitaF.setText("");
						mobileF.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Which data you want to edit?!", "???",
							JOptionPane.WARNING_MESSAGE, null);
				}

			}
		});

		LocalDb todos = new LocalDb();
		ArrayList<PostRequest>myPost=new ArrayList<PostRequest>();

		try {
			if (todos.getAllPost() == null) {
			} else {
				
				for(var elm: todos.getAllPost()) {
					if(elm.getAuthorMail().equals(me.getEmail())) {
						myPost.add(elm);
					}
				}
				
				if(myPost!=null) {
					for (var posts : myPost) {
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
			}
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
