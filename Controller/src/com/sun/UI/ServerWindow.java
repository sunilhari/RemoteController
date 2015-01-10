package com.sun.UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.sun.constants.CONSTANTS;
import com.sun.server.WSocketServer;

public class ServerWindow {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerWindow window = new ServerWindow();
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
	public ServerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Server");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 221, 189);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server");
		lblNewLabel.setBounds(74, 23, 65, 25);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(CONSTANTS.SERVER_IP + ":"+CONSTANTS.PORT_NUMBER);
		lblNewLabel_1.setBounds(18, 60, 178, 16);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 134, 209, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		final JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					WSocketServer server = new WSocketServer();
					lblNewLabel_2.setText("Server Started");
					btnStart.setEnabled(false);
					
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStart.setBounds(74, 93, 75, 29);
		frame.getContentPane().add(btnStart);
		
		
	}
}
