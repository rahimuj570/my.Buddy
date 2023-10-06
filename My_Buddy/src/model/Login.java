package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

import apiCall.LocalDb;
import pojo.LoginTemplate;
import pojo.UserDetailsTemplate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends Thread{

	JFrame frame;
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginTemplate ob1=new LoginTemplate(txtEmail.getText(),txtPassword.getText());
//				System.out.println(ob1.toString());
				
				/*
				 * HttpRequest request = HttpRequest.newBuilder()
				 * .POST(HttpRequest.BodyPublishers.ofString(ob1.toString()))
				 * .uri(URI.create("http://localhost:8080/users/login")) .header("Content-Type",
				 * "application/json") // .setHeader("Authorization", "Bearer 123token")
				 * .build();
				 * 
				 * HttpResponse<String> response = null; try { response =
				 * HttpClient.newHttpClient() .send(request,
				 * HttpResponse.BodyHandlers.ofString()); } catch (IOException |
				 * InterruptedException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
					Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+
	                        "[a-zA-Z0-9_+&*-]+)*@" +
	                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                        "A-Z]{2,7}$");
					UserDetailsTemplate me=new UserDetailsTemplate();
					LocalDb ldb=new LocalDb();
					List<UserDetailsTemplate>allUser=new ArrayList<UserDetailsTemplate>();
					try {
						allUser=ldb.getAllUser();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean foundME=false;
					if(allUser!=null) {
						for(var u:allUser) {
							if(u.getEmail().equals(ob1.email) && u.getPassword().equals(ob1.password)) {
								foundME=true;
								me=u;
								break;
							}else {
								
							}
						}
					}
					
				
				
					
					if(ob1.email.length()==0 || ob1.password.length()==0) {
						JOptionPane.showMessageDialog( frame, "Empty field not allowed!","Invalid", JOptionPane.WARNING_MESSAGE, null);
					}
					else if( p.matcher((CharSequence) ob1.email).matches()==false) {
						JOptionPane.showMessageDialog( frame, "Enter a valid email","Invalid", JOptionPane.WARNING_MESSAGE, null);
					}
					else if(foundME==false) {
						JOptionPane.showMessageDialog( frame, "User not found!","Invalid", JOptionPane.WARNING_MESSAGE, null);
					}else {
						JOptionPane.showMessageDialog( frame, "Successully Logged in!","Congratulations!", JOptionPane.INFORMATION_MESSAGE, null);
						String greeting;
					     Calendar c = Calendar.getInstance();
					        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
					        if(timeOfDay < 12){
					        	greeting= "Good morning";
					        }else if(timeOfDay < 16){
					        greeting= "Good afternoon";
					        }else if(timeOfDay < 21){
					        greeting= "Good evening";
					        }else {
					        greeting= "Good night";
					        }
					        Dashboard window;
							try {
								window = new Dashboard(me,greeting);
								window.frame.setVisible(true);
								frame.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
//						System.out.println(window.getEmail());
//						System.out.println(ob1.email);
//						frame.dispose();
					}
						
						
				
			}
		});
		btnNewButton_1.setBounds(92, 315, 89, 23);
		btnNewButton_1.setBackground(new Color(139, 0, 139));
		btnNewButton_1.setForeground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("K2D ExtraBold", Font.PLAIN, 11));
		panel.add(btnNewButton_1);
		
		JTextPane txtpnAlreadyYouHave = new JTextPane();
		txtpnAlreadyYouHave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		txtpnAlreadyYouHave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup window = new Signup();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		txtpnAlreadyYouHave.setFont(new Font("K2D SemiBold", Font.PLAIN, 12));
		txtpnAlreadyYouHave.setText("Don't have an account?");
		txtpnAlreadyYouHave.setBounds(74, 349, 186, 20);
		panel.add(txtpnAlreadyYouHave);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(46, 209, 35, 14);
		panel.add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 253, 102, 14);
		panel.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Screenshot 2023-09-30 131211.png"));
		lblNewLabel_1.setBounds(91, 45, 152, 155);
		panel.add(lblNewLabel_1);
	}
}
