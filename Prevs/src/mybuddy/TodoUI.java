package mybuddy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import entity.Todo;

import java.text.SimpleDateFormat;
import java.util.*;

public class TodoUI {
	DefaultTableModel model;
	JFrame frame;
	private JTable table;
	private JTextField titlef;
	private JTextField descf;
	boolean cnfrm=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TodoUI window = new TodoUI();
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
	public TodoUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 656, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back to Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard window = new Dashboard();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(18, 18, 149, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel greeting = new JLabel("Hi name! Good morning");
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 16));
		greeting.setBounds(396, 16, 188, 43);
		frame.getContentPane().add(greeting);
		
		JLabel lblStopwatch = new JLabel("Todo List");
		lblStopwatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblStopwatch.setBounds(182, 70, 157, 43);
		frame.getContentPane().add(lblStopwatch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 235, 612, 236);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel();
		Object column[]= {"Title","Description","Date"};
		Object row[]=new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(86, 118, 64, 43);
		frame.getContentPane().add(lblNewLabel);
		
		titlef = new JTextField();
		titlef.setBounds(143, 124, 220, 32);
		frame.getContentPane().add(titlef);
		titlef.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(58, 168, 92, 43);
		frame.getContentPane().add(lblDescription);
		
		descf = new JTextField();
		descf.setColumns(10);
		descf.setBounds(143, 174, 220, 32);
		frame.getContentPane().add(descf);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				SimpleDateFormat DateFor = new SimpleDateFormat("dd-M-yyyy   hh:mm:ss");
				String stringDate = DateFor.format(date);
				Todo todo=new Todo(titlef.getText(),descf.getText(),stringDate);
				if(todo.getTitle().length()==0 || todo.getDesc().length()==0) {
					JOptionPane.showMessageDialog( frame, "Empty field is not allowed","Invalid", JOptionPane.WARNING_MESSAGE, null);
				}else {
					try {
						LocalDb localDb=new LocalDb(todo);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					row[0]=todo.getTitle();
					row[1]=todo.getDesc();
					row[2]=todo.getDate();
					model.addRow(row);
					JOptionPane.showMessageDialog( frame, "Successully Added!","Done", JOptionPane.INFORMATION_MESSAGE, null);
					titlef.setText("");
					descf.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(401, 125, 89, 81);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				int rmv =table.getSelectedRow();
				if(table.isRowSelected(rmv)) {
					List<Todo>tdo=new ArrayList<Todo>();
					model.removeRow(rmv);
					   for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
						   Todo ent=new Todo();
						   for (int j = 0; j < table.getColumnCount(); j++) {
							  String s=model.getValueAt(i, j).toString();
							  row[j]=s;
						   }
						   ent.setTitle(row[0].toString());
						   ent.setDesc(row[1].toString());
						   ent.setDate(row[2].toString());
						   tdo.add(ent);
					     }
					   try {
						LocalDb aftrDlt=new LocalDb(tdo);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   JOptionPane.showMessageDialog( frame, "Successully Deleted!","Done", JOptionPane.INFORMATION_MESSAGE, null);
						titlef.setText("");
						descf.setText("");
				}else {
					JOptionPane.showMessageDialog( frame, "Which data you want to delete?!","???", JOptionPane.WARNING_MESSAGE, null);
				}
				
				   
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(182, 493, 113, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Edit");

		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int edt =table.getSelectedRow();
				if(table.isRowSelected(edt)) {
					if(cnfrm==false) {
						titlef.setText(model.getValueAt(edt, 0).toString());
						descf.setText(model.getValueAt(edt, 1).toString());
						cnfrm=true;
						btnNewButton_2_1.setText("Confirm Edit");
						btnNewButton_2_1.setBackground(Color.GREEN);
					}else {
						JOptionPane.showMessageDialog( frame, "Successully Edited!","Done", JOptionPane.INFORMATION_MESSAGE, null);
						btnNewButton_2_1.setBackground(null);
						btnNewButton_2_1.setText("Edit");
						List<Todo>tdo=new ArrayList<Todo>();
						model.setValueAt(titlef.getText(), edt, 0);
						model.setValueAt(descf.getText(), edt, 1);
						for (int i = 0; i < table.getRowCount(); i++) {  // Loop through the rows
							Todo ent=new Todo();
							for (int j = 0; j < table.getColumnCount(); j++) {
								String s=model.getValueAt(i, j).toString();
								row[j]=s;
							}
							ent.setTitle(row[0].toString());
							ent.setDesc(row[1].toString());
							ent.setDate(row[2].toString());
							tdo.add(ent);
						}
						try {
							LocalDb aftrDlt=new LocalDb(tdo);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						cnfrm=false;
						titlef.setText("");
						descf.setText("");
					}
				}else {
					JOptionPane.showMessageDialog( frame, "Which data you want to edit?!","???", JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBounds(326, 493, 113, 43);
		frame.getContentPane().add(btnNewButton_2_1);
		LocalDb todos=new LocalDb();
		try {
			for(var tod: todos.getAllTodo()) {
				row[0]=tod.getTitle();
				row[1]=tod.getDesc();
				row[2]=tod.getDate();
				model.addRow(row);
			}
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
