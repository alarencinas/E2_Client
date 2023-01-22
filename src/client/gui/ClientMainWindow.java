package client.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.controller.CrController;
import client.controller.LoginController;
import server.data.dto.UserDTO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClientMainWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnChallenge;
	private JButton btnSession;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientMainWindow frame = new ClientMainWindow(null, null, null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClientMainWindow(UserDTO user,CrController crController,LoginController loginController) {
		setTitle("STRAVA MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		 btnChallenge = new JButton("CREATE CHALLENGE");
		panel.add(btnChallenge);
		
		 btnSession = new JButton("CREATE SESSION");
		panel.add(btnSession);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnExit = new JButton("Exit");
		panelSouth.add(btnExit);
		btnChallenge.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				// TODO 
				
				new ClientChallengeWindow(user, crController,loginController); //TODO de donde sacamos el CrController que hay que pasar aqui?
				dispose();
			}
		});
		btnSession.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO 
				
				ClientSessionWindow sessionwin = new ClientSessionWindow(user, crController, loginController);
				sessionwin.setVisible(true);
			}
		});
		setVisible(true);
	}

}
