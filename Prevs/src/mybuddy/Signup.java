package mybuddy;

import java.awt.EventQueue;
import entity.Users;
import mybuddy.LocalDb;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup {

	JFrame frame;
	private JTextField email;
	private JTextField password;
	private JTextField repassword;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
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
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel.setBounds(100, 90, 73, 22);
		frame.getContentPane().add(lblNewLabel);
		
		email = new JTextField();
		email.setToolTipText("Your Email");
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setColumns(10);
		email.setBounds(174, 84, 169, 28);
		frame.getContentPane().add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblPassword.setBounds(100, 123, 73, 22);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setToolTipText("Your Email");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		password.setBounds(174, 123, 169, 28);
		frame.getContentPane().add(password);
		
		JButton btnSignup = new JButton("Sign up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$");
				LocalDb ldb=new LocalDb();
				List<Users>allUser=new ArrayList<Users>();
				try {
					allUser=ldb.getAllUser();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean availEmail=true;
				for(var u:allUser) {
					if(u.getEmail().equals(email.getText())) {
						availEmail=false;
						break;
					}}
				if(name.getText().length()<3)JOptionPane.showMessageDialog( btnSignup, "Enter a valid name","Invalid", JOptionPane.WARNING_MESSAGE, null);
				else if(p.matcher((CharSequence) email.getText()).matches()==false)JOptionPane.showMessageDialog( btnSignup, "Enter a valid email","Invalid", JOptionPane.WARNING_MESSAGE, null);
				else if(availEmail==false)JOptionPane.showMessageDialog( btnSignup, "Enter already registered!","Email Exist", JOptionPane.WARNING_MESSAGE, null);
				else if(!password.getText().equals(repassword.getText()))
				JOptionPane.showMessageDialog( frame, "Password is not matched","Invalid", JOptionPane.WARNING_MESSAGE, null);
				else {
					 Users u=new Users(name.getText(), email.getText(), password.getText());
					try {
						LocalDb ldb2=new LocalDb(u);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog( frame, "Successully Registered","Congratulations!", JOptionPane.INFORMATION_MESSAGE, null);
					Login window = new Login();
					window.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnSignup.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSignup.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnSignup.setBounds(174, 201, 84, 37);
		frame.getContentPane().add(btnSignup);
		
		JTextPane txtpnAlreadyHaveAn = new JTextPane();
		txtpnAlreadyHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login window = new Login();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		txtpnAlreadyHaveAn.setText("Already have an account?");
		txtpnAlreadyHaveAn.setEditable(false);
		txtpnAlreadyHaveAn.setBackground(SystemColor.menu);
		txtpnAlreadyHaveAn.setBounds(278, 201, 92, 37);
		txtpnAlreadyHaveAn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(txtpnAlreadyHaveAn);
		
		JLabel lblRetypePassword = new JLabel("Re-type Password");
		lblRetypePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetypePassword.setForeground(Color.BLACK);
		lblRetypePassword.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblRetypePassword.setBounds(42, 168, 131, 22);
		frame.getContentPane().add(lblRetypePassword);
		
		repassword = new JTextField();
		repassword.setToolTipText("Your Email");
		repassword.setHorizontalAlignment(SwingConstants.CENTER);
		repassword.setColumns(10);
		repassword.setBounds(174, 162, 169, 28);
		frame.getContentPane().add(repassword);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(146, 11, 169, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_2.setBounds(100, 51, 73, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		name = new JTextField();
		name.setToolTipText("Your Email");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setColumns(10);
		name.setBounds(174, 45, 169, 28);
		frame.getContentPane().add(name);
	}

}
