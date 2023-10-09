package model;

import java.util.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import pojo.UserDetailsTemplate;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.*;
import javax.swing.text.*;

public class Main {
	private Timer timer;
	JProgressBar progressBar;
	Font f1 = new Font(Font.SERIF, Font.BOLD, 30);
	private JFrame frame;
	static String quote;
	static String quoteAuthore;
	static String q;
	static String a;
	static ArrayList<String> s = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		////////// =======
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://api.quotable.io/quotes/random"))
				// .setHeader("Authorization", "Bearer 123token")
				.build();

		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(response.statusCode());
//		System.out.println(response.body());
		String res = response.body().toString();
		String temp = "";
		for (int i = 0; i < res.length(); i++) {
			if (res.charAt(i) == ':') {
				s.add(temp);
				temp = "";
			} else {
				temp += res.charAt(i);
			}
		}

		quote = s.get(2);
		quoteAuthore = s.get(3);
//			String q=quote.substring(1, quote.length()-10);
		String q2 = quote.replaceFirst("\",\"author\"", "");
		q = q2.substring(1);
		String a2 = quoteAuthore.replaceFirst("\",\"tags\"", "");
		a = a2.substring(1);
//		System.out.println(quote + "\n " + quoteAuthore);
//		System.out.println(q);
//		System.out.println(a);

		/////////// =========

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setIconImage(new Logo().fav.getImage());
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
	int flag = 0;
	boolean homeGone = false;

	public Main() {
		initialize();
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag++;
				progressBar.setValue(flag * 1000);
				if (flag == 6) {
					homeGone = true;
					frame.dispose();
					Login window = new Login();
					window.frame.setIconImage(new Logo().fav.getImage());
					window.frame.setVisible(true);
					if (homeGone == true)
						timer.stop();
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
		lblNewLabel.setIcon(new Logo().logo);
		lblNewLabel.setFont(f1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setBounds(125, 22, 187, 147);
		frame.getContentPane().add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 128, 128));
		progressBar.setMaximum(5000);
//		progressBar.setValue(40);
		progressBar.setBounds(125, 323, 200, 14);
		frame.getContentPane().add(progressBar);

		JLabel lblNewLabel_1 = new JLabel("version - test-0.01");
		lblNewLabel_1.setForeground(new Color(255, 128, 128));
		lblNewLabel_1.setBounds(171, 376, 127, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("___"+a);
		lblNewLabel_2.setBackground(SystemColor.controlHighlight);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(70, 275, 293, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setUnderline(bSet, true);
        StyleConstants.setFontSize(bSet, 18);
  
        
        JTextPane textPane = new JTextPane();
        textPane.setToolTipText(q);
        textPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
        textPane.setEditable(false);
        textPane.setForeground(Color.black);
        textPane.setBackground(SystemColor.control);
        textPane.setText(q);
        StyledDocument doc = textPane.getStyledDocument();
        textPane.setBounds(69, 169, 293, 104);
//        doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);
        doc.setParagraphAttributes(0, 104, bSet, false);
        frame.getContentPane().add(textPane);
	}
}
