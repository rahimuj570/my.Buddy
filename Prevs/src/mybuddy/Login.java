package mybuddy;

import java.awt.EventQueue;
import mybuddy.LocalDb;
import java.util.*;
import entity.Users;
import entity.CurrentUser;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class Login {

	JFrame frame;
	private JTextField email;
	private JLabel lblPassword;
	private JTextField password;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		email = new JTextField();
		email.setToolTipText("Your Email");
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(163, 107, 169, 28);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel.setBounds(89, 113, 73, 22);
		frame.getContentPane().add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblPassword.setBounds(89, 152, 73, 22);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setToolTipText("Your Email");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		password.setBounds(163, 146, 169, 28);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(email.getText().length()==0 || password.getText().length()==0) {
					JOptionPane.showMessageDialog( frame, "Empty Field is Not Allowed","Invalid Email or Password", JOptionPane.WARNING_MESSAGE, null);
				}else {
					LocalDb ldb=new LocalDb();
					List<Users>allUser=new ArrayList<Users>();
					try {
						allUser=ldb.getAllUser();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean foundME=false;
					for(var u:allUser) {
						if(u.getEmail().equals(email.getText()) && u.getPassword().equals(password.getText())) {
							CurrentUser me=new CurrentUser(u.getName(), u.getEmail(), u.getPassword());
							Dashboard window = new Dashboard();
							window.frame.setVisible(true);
							frame.dispose();
							foundME=true;
							break;
						}else {
							
						}
					}
					if(!foundME)JOptionPane.showMessageDialog( frame, "User don't exist!","Invalid Email or Password", JOptionPane.WARNING_MESSAGE, null);
				
				}
				}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnNewButton.setBounds(163, 185, 84, 37);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnDontHaveAn = new JTextPane();
		txtpnDontHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup window = new Signup();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		txtpnDontHaveAn.setEditable(false);
		txtpnDontHaveAn.setBackground(new Color(240, 240, 240));
		txtpnDontHaveAn.setText("Don't have an account?");
		txtpnDontHaveAn.setBounds(267, 185, 92, 37);
		txtpnDontHaveAn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(txtpnDontHaveAn);
		
		lblNewLabel_1 = new JLabel("SIGN IN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 26));
		lblNewLabel_1.setBounds(137, 50, 169, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
