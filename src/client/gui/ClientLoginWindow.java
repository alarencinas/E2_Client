package client.gui;

import java.awt.EventQueue;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import client.controller.LoginController;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ClientLoginWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private JPanel panelCentre;
	private  static JLabel lblNick;
	private JTextField textNick;
	private JLabel lblPass;
	private JPasswordField textPass;
	private JButton btnLogin;
	private LoginController lController;
	/**
	 * Launch the application.
	 */
	//Methods
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLoginWindow frame = new ClientLoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientLoginWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		btnLogin = new JButton("LOG IN");
		panelSouth.add(btnLogin);
		
		panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNick = new JLabel("Insert your Nickname:");
		panelCentre.add(lblNick);
		
		textNick = new JTextField();
		panelCentre.add(textNick);
		textNick.setColumns(10);
		
		lblPass = new JLabel("Insert your password:");
		panelCentre.add(lblPass);
		
		textPass = new JPasswordField();
		panelCentre.add(textPass);
		textPass.setColumns(10);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = textNick.getText();
				String pass = textPass.getText();
				
				//TODO log in to menu windows
				System.out.println("Succesfully Loged in");
				setVisible(false);
				ClientMainWindow mainwin = new ClientMainWindow();
			}
		});
		setVisible(true);
	}

}
