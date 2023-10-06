package model;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import pojo.UserDetailsTemplate;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;

public class Main {
	private Timer timer;
	JProgressBar progressBar;
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
	int flag=0;
	boolean homeGone=false;
	public Main() {
		initialize();
		timer= new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag++;
				progressBar.setValue(flag*1000);
				if(flag==6) {
					homeGone=true;
					frame.dispose();
					Login window = new Login();
					window.frame.setVisible(true);
					if(homeGone==true)timer.stop();
				}
				
			}
			
		});
		timer.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Screenshot 2023-09-30 131211.png"));
		lblNewLabel.setFont(f1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setBounds(125, 78, 187, 147);
		frame.getContentPane().add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 128, 128));
		progressBar.setMaximum(5000);
//		progressBar.setValue(40);
		progressBar.setBounds(125, 262, 200, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("version - test-0.01");
		lblNewLabel_1.setForeground(new Color(255, 128, 128));
		lblNewLabel_1.setBounds(171, 376, 127, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
