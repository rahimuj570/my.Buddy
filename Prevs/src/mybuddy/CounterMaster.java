package mybuddy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CounterMaster {
	String op[][]={
			{"Sentence", "00"},
			{"Word", "00"},
			{"Character", "00"},
			{"Vowel", "00"},
			{"Consonent", "00"},
			{"Numerical Digit", "00"},
			{"Whitespace", "00"},
		};
	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CounterMaster window = new CounterMaster();
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
	public CounterMaster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 552, 494);
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
		btnNewButton.setBounds(10, 30, 149, 32);
		btnNewButton.setBackground(Color.PINK);
		frame.getContentPane().add(btnNewButton);
		
		JLabel greeting = new JLabel("Hi name! Good morning");
		greeting.setBounds(338, 28, 188, 43);
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 16));
		frame.getContentPane().add(greeting);
		
		JLabel lblStopwatch = new JLabel("Counter Master");
		lblStopwatch.setBounds(184, 82, 157, 43);
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		frame.getContentPane().add(lblStopwatch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 133, 459, 168);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btnNewButton_1 = new JButton("Count");
		btnNewButton_1.setBounds(52, 330, 139, 32);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordCount(textArea.getText());
				senCount(textArea.getText());
				vowelCount(textArea.getText());
				op[2][1]=textArea.getText().length()+"";
				table.setModel(new DefaultTableModel(op,
						new String[] {
							"Operaton", "Count"
						}
					));
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton_1);
      
table = new JTable();
table.setBounds(247, 320, 253, 112);
table.setFillsViewportHeight(true);
table.setRowSelectionAllowed(false);
table.setEnabled(false);
table.setShowHorizontalLines(false);
table.setModel(new DefaultTableModel(op,
	new String[] {
		"Operaton", "Count"
	}
));
table.getColumnModel().getColumn(0).setPreferredWidth(110);
table.getColumnModel().getColumn(1).setPreferredWidth(48);
table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(table);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.setBounds(52, 383, 139, 32);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
		        op[3][1]="00";
		        op[4][1]="00";
		        op[5][1]="00";
		        op[6][1]="00";
		        op[1][1]="00";
		        op[0][1]="00";
		        op[2][1]="00";
		        table.setModel(new DefaultTableModel(op,
		        		new String[] {
		        			"Operaton", "Count"
		        		}
		        	));
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton_1_1);
		

	}
	
	void wordCount(String s) {
		String[] words = s.split(" ");
		op[1][1]=words.length+"";
	}
	void senCount(String s) {
		String[] words = s.split("[!?.:]+");
		op[0][1]=words.length+"";
	}
	void vowelCount(String s) {
		int v=0;
		int white=0,cons=0,digit=0;
		 s = s.toLowerCase();
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
	                || s.charAt(i) == 'i'
	                || s.charAt(i) == 'o'
	                || s.charAt(i) == 'u') {
	                v++;
	            }else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
	                ++cons;
	            }
	            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
	              ++digit;
	            }
	            else if (s.charAt(i) == ' ') {
	              ++white;
	            }
	        }
	        op[3][1]=v+"";
	        op[4][1]=cons+"";
	        op[5][1]=digit+"";
	        op[6][1]=white+"";
	}
}
