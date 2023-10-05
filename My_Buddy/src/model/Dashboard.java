package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import pojo.UserDetailsTemplate;
import pojo.testPojo;

import java.awt.EventQueue;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Dashboard {
	 private String greeting;
	 private String email;
	 UserDetailsTemplate me;
		ArrayList<String> data=new ArrayList();
	JFrame frame;
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Dashboard window = new Dashboard();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } });
	 * 
	 * }
	 */

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public Dashboard(UserDetailsTemplate me, String greeting) throws IOException, InterruptedException {
		this.me=me;
		this.greeting=greeting;
		/*
		 * HttpRequest request = HttpRequest.newBuilder() .GET()
		 * .uri(URI.create("http://localhost:8080/users/email/"+me)) //
		 * .setHeader("Authorization", "Bearer 123token") .build();
		 * 
		 * HttpResponse<String> response = HttpClient.newHttpClient() .send(request,
		 * HttpResponse.BodyHandlers.ofString()); String jsonStr=response.body();
		 * System.out.println(response.statusCode());
		 * System.out.println(response.body()); for(int i=0; i<jsonStr.length();i++) {
		 * if(jsonStr.charAt(i)==':') { i++; String s=""; for(int j=i;
		 * j<jsonStr.length() ;j++) { if(jsonStr.charAt(j)==',' ||
		 * jsonStr.charAt(j)=='}')break; s+=jsonStr.charAt(j);
		 * System.out.print(jsonStr.charAt(j)); } data.add(s); System.out.println(); } }
		 */
			
			
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
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("POST REQUEST");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("K2D ExtraBold", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setBounds(75, 269, 147, 37);
		panel.add(btnNewButton);
		
		JButton btnFindDonor = new JButton("FIND DONOR");
		btnFindDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindBlood window;
				window = new FindBlood(me);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnFindDonor.setHorizontalAlignment(SwingConstants.LEFT);
		btnFindDonor.setForeground(new Color(255, 255, 255));
		btnFindDonor.setFont(new Font("K2D ExtraBold", Font.PLAIN, 14));
		btnFindDonor.setBackground(new Color(102, 204, 255));
		btnFindDonor.setBounds(13, 323, 124, 37);
		panel.add(btnFindDonor);
		
		JLabel lblNewLabel_1 = new JLabel(greeting+" "+me.getName().toUpperCase()+"!");
		lblNewLabel_1.setFont(new Font("TimeBurner", Font.BOLD, 14));
		lblNewLabel_1.setBounds(13, 11, 257, 27);
		panel.add(lblNewLabel_1);
		
		JButton btnNewsFeed = new JButton("NEWS FEED");
		btnNewsFeed.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewsFeed.setForeground(Color.WHITE);
		btnNewsFeed.setFont(new Font("K2D ExtraBold", Font.PLAIN, 14));
		btnNewsFeed.setBackground(new Color(218, 112, 214));
		btnNewsFeed.setBounds(154, 323, 116, 37);
		panel.add(btnNewsFeed);
		
		JButton btnMyProfile = new JButton("MY PROFILE");
		btnMyProfile.setForeground(Color.WHITE);
		btnMyProfile.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnMyProfile.setBackground(new Color(72, 109, 204));
		btnMyProfile.setBounds(75, 371, 147, 37);
		panel.add(btnMyProfile);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Screenshot 2023-09-30 131211.png"));
		lblNewLabel.setBounds(87, 88, 116, 139);
		panel.add(lblNewLabel);
	}
}
