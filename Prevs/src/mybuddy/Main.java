package mybuddy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import java.awt.Color;

public class Main {
	private Timer timer;
	Font  f1  = new Font(Font.SERIF, Font.BOLD,  30);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	boolean homeGone=false;
	public Main() {
		initialize();
		timer= new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeGone=true;
				frame.dispose();
				Login window = new Login();
				window.frame.setVisible(true);
				if(homeGone==true)timer.stop();
				
			}
			
		});
		timer.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setFont(f1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setBounds(125, 78, 156, 90);
		frame.getContentPane().add(lblNewLabel);
	}
}
//Server: sql12.freemysqlhosting.net
//Name: sql12644179
//Username: sql12644179
//Password: 1wn4whHKxR
//Port number: 3306

//`uid` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NULL DEFAULT NULL , `email` VARCHAR(50) NULL DEFAULT NULL , `password` VARCHAR(20) NULL DEFAULT NULL , PRIMARY KEY (`uid`)