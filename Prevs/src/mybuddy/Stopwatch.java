package mybuddy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stopwatch {

	JFrame frame;
	private Timer timer;
	int sec=0;
	int min=0;
	int milisecs=0;
	long startTime ;
	JButton stopBtn = new JButton("Stop");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stopwatch window = new Stopwatch();
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
	public Stopwatch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBackground(new Color(255, 0, 128));
		frame.setBounds(100, 100, 450, 300);
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
		btnNewButton.setBounds(10, 11, 149, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel greeting = new JLabel("Hi name! Good morning");
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setFont(new Font("Sylfaen", Font.BOLD, 16));
		greeting.setBounds(236, 9, 188, 43);
		frame.getContentPane().add(greeting);
		
		JLabel lblStopwatch = new JLabel("Stopwatch");
		lblStopwatch.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblStopwatch.setBounds(168, 73, 102, 43);
		frame.getContentPane().add(lblStopwatch);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 127, 385, 120);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel minutes = new JLabel("00");
		minutes.setFont(new Font("MV Boli", Font.PLAIN, 20));
		minutes.setHorizontalAlignment(SwingConstants.CENTER);
		minutes.setEnabled(false);
		minutes.setBackground(Color.RED);
		minutes.setBounds(163, 48, 63, 54);
		panel.add(minutes);
		
		JLabel lblNewLabel = new JLabel("Minutes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 34, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblMinutes = new JLabel("Seconds");
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinutes.setBounds(236, 35, 63, 14);
		panel.add(lblMinutes);
		
		JLabel lblMiliseconds = new JLabel("Milisec");
		lblMiliseconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiliseconds.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMiliseconds.setBounds(309, 35, 63, 14);
		panel.add(lblMiliseconds);
		
		JLabel seconds = new JLabel("00");
		seconds.setHorizontalAlignment(SwingConstants.CENTER);
		seconds.setFont(new Font("MV Boli", Font.PLAIN, 20));
		seconds.setEnabled(false);
		seconds.setBackground(Color.RED);
		seconds.setBounds(236, 48, 63, 54);
		panel.add(seconds);
		
		JLabel milisec = new JLabel("00");
		milisec.setHorizontalAlignment(SwingConstants.CENTER);
		milisec.setFont(new Font("MV Boli", Font.PLAIN, 20));
		milisec.setEnabled(false);
		milisec.setBackground(Color.RED);
		milisec.setBounds(298, 48, 87, 54);
		panel.add(milisec);
		

		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopBtn.setEnabled(true);
				startBtn.setEnabled(false);
				 startTime = System.currentTimeMillis();
				timer= new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
//						milisecs++;
						milisec.setText("loading..");
//						if(milisecs==100) {
//							sec++;
//							seconds.setText(sec+"");
//							milisecs=0;
//						}
						sec++;
						seconds.setText(sec+"");
						if(sec==60) {
							sec=0;
							min++;
							minutes.setText(min+"");
						}
					}
					
				});
				timer.start();
			}
		});
		startBtn.setBounds(10, 11, 89, 23);
		panel.add(startBtn);
		

		stopBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				stopBtn.setEnabled(false);
				startBtn.setEnabled(true);
				startTime-=System.currentTimeMillis();
				double res=(startTime*-1)/sec;
				if(res>1000)res/=10;
				milisec.setText(res+"");
				
			}
		});
		stopBtn.setEnabled(false);
		stopBtn.setBounds(10, 45, 89, 23);
		panel.add(stopBtn);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				minutes.setText("00");
				seconds.setText("00");
				milisec.setText("00");
				if(timer!=null) {					
					timer.stop();
				}
				
			}
		});
		reset.setBounds(10, 79, 89, 23);
		panel.add(reset);
		

		

		

	}
}
