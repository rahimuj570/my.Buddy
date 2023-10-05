package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

public class LOGIN {

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window = new LOGIN();
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
	public LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 302, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(102, 205, 170));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(45, 227, 186, 20);
		txtEmail.setColumns(10);
		panel.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(45, 271, 186, 20);
		txtPassword.setColumns(10);
		panel.add(txtPassword);
		
		btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setBounds(92, 315, 89, 23);
		btnNewButton_1.setBackground(new Color(139, 0, 139));
		btnNewButton_1.setForeground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("K2D ExtraBold", Font.PLAIN, 11));
		panel.add(btnNewButton_1);
		
		JTextPane txtpnAlreadyYouHave = new JTextPane();
		txtpnAlreadyYouHave.setFont(new Font("K2D SemiBold", Font.PLAIN, 12));
		txtpnAlreadyYouHave.setText("Don't have an account. SIGNUP");
		txtpnAlreadyYouHave.setBounds(46, 347, 186, 20);
		panel.add(txtpnAlreadyYouHave);
		
		lblNewLabel = new JLabel("MAIL");
		lblNewLabel.setBounds(46, 209, 35, 14);
		panel.add(lblNewLabel);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(46, 253, 102, 14);
		panel.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Blood bank project\\Logo.gif"));
		lblNewLabel_1.setBounds(91, 45, 152, 155);
		panel.add(lblNewLabel_1);
	}
}
