package model;

import java.util.*;
import java.util.List;

import apiCall.LocalDb;

import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.awt.event.ActionEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Login;
import pojo.UserDetailsTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup {

	JFrame frame;
	private JTextField nameF;
	private JTextField mailF;
	private JTextField passF;
	private JTextField mobileF;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 315, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Screenshot 2023-09-30 131211.png"));
		lblNewLabel.setBounds(90, 35, 152, 155);
		panel.add(lblNewLabel);

		nameF = new JTextField();
		nameF.setBounds(91, 196, 185, 20);
		panel.add(nameF);
		nameF.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 198, 35, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mail");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(58, 233, 29, 14);
		panel.add(lblNewLabel_1_1);

		String[] str = { "Male", "Female" };
		JComboBox gender = new JComboBox(str);
		gender.setBounds(89, 297, 89, 22);
		panel.add(gender);

		String[] str1 = { "A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-" };
		JComboBox bloodGroup = new JComboBox(str1);
		bloodGroup.setBounds(90, 330, 89, 22);
		panel.add(bloodGroup);

		mailF = new JTextField();
		mailF.setColumns(10);
		mailF.setBounds(91, 231, 185, 20);
		panel.add(mailF);

		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(40, 299, 44, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Area");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(52, 264, 35, 14);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Password");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(29, 363, 58, 14);
		panel.add(lblNewLabel_1_1_1_2);

		passF = new JTextField();
		passF.setColumns(10);
		passF.setBounds(90, 361, 186, 20);
		panel.add(passF);

		JCheckBox checkDhaka = new JCheckBox("Dhaka");
		checkDhaka.setFont(new Font("Tahoma", Font.PLAIN, 10));
		checkDhaka.setBounds(91, 262, 58, 23);
		panel.add(checkDhaka);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Blood Group");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(11, 333, 76, 14);
		panel.add(lblNewLabel_1_1_1_3);

		JCheckBox chckbxPabna = new JCheckBox("Pabna");
		chckbxPabna.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxPabna.setBounds(155, 261, 58, 23);
		panel.add(chckbxPabna);

		JCheckBox chckbxNatore = new JCheckBox("Natore");
		chckbxNatore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxNatore.setBounds(219, 260, 58, 23);
		panel.add(chckbxNatore);

		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDetailsTemplate user = new UserDetailsTemplate();
				user.setBloodGroup(bloodGroup.getSelectedItem().toString());
				user.setCanDonate(1);
				user.setEmail(mailF.getText());
				user.setLastDonation("0");
				user.setTotalDonation(0);
				user.setPassword(passF.getText());
				user.setName(nameF.getText());
				user.setGender(gender.getSelectedItem().toString());
				user.setMobile(mobileF.getText());
				ArrayList<String> areas = new ArrayList<String>();
				if (checkDhaka.isSelected())
					areas.add("Dhaka");
				if (chckbxPabna.isSelected())
					areas.add("Pabna");
				if (chckbxNatore.isSelected())
					areas.add("Natore");
				/*
				 * String str[]=new String[areas.size()]; for(int i=0; i<str.length; i++) {
				 * str[i]="\""+areas.get(i)+"\""; }
				 */
				user.setArea(areas);

//				System.out.println(user.toString());

//				String requestBody = "{\"name\": \"Example\", \"data\": {\"Attribute 1\": 123, \"Attribute 2\": \"POST Request in Java\"}}";
				/*
				 * HttpRequest request = HttpRequest.newBuilder()
				 * .POST(HttpRequest.BodyPublishers.ofString(user.toString()))
				 * .uri(URI.create("http://localhost:8080/users/signup"))
				 * .header("Content-Type", "application/json") // .setHeader("Authorization",
				 * "Bearer 123token") .build();
				 * 
				 * HttpResponse<String> response = null; try { response =
				 * HttpClient.newHttpClient() .send(request,
				 * HttpResponse.BodyHandlers.ofString()); } catch (IOException |
				 * InterruptedException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */

				Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
						+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$");

				LocalDb ldb = new LocalDb();
				List<UserDetailsTemplate> allUser = new ArrayList<UserDetailsTemplate>();
				try {
					allUser = ldb.getAllUser();
				} catch (ClassNotFoundException | IOException e1) { // TODO Auto-generated catch
					e1.printStackTrace();
				}
				boolean availEmail = true;
				for (var u : allUser) {
					if (u.getEmail().equals(mailF.getText())) {
						availEmail = false;
						break;
					}
				}

				if (user.getArea() == null || user.getBloodGroup().length() == 0 || user.getName().length() == 0
						|| user.getGender().length() == 0 || user.getPassword().length() == 0) {
					JOptionPane.showMessageDialog(frame, "Empty field not allowed!", "Invalid",
							JOptionPane.WARNING_MESSAGE, null);
				} else if (p.matcher((CharSequence) mailF.getText()).matches() == false) {
					JOptionPane.showMessageDialog(frame, "Enter a valid email", "Invalid", JOptionPane.WARNING_MESSAGE,
							null);
				} else if (availEmail == false)
					JOptionPane.showMessageDialog(frame, "Email already registered!", "Email Exist",
							JOptionPane.WARNING_MESSAGE, null);
				else {
					try {
						LocalDb ldb2=new LocalDb(user);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Successully Registered", "Congratulations!",
							JOptionPane.INFORMATION_MESSAGE, null);
					 Login window = new Login(); 
					 window.frame.setVisible(true); 
					frame.dispose();
				}

			}
		});

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setBounds(38, 431, 89, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Already have an account?");
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login window = new Login();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_2.setBounds(139, 433, 150, 19);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Mobile");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2_1.setBounds(43, 392, 44, 14);
		panel.add(lblNewLabel_1_1_1_2_1);

		mobileF = new JTextField();
		mobileF.setColumns(10);
		mobileF.setBounds(90, 391, 186, 20);
		panel.add(mobileF);

	}
}
