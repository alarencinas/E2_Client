package client.gui;

import java.awt.EventQueue;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import client.controller.LoginController;
import server.data.domain.LoginUserType;
import server.data.domain.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ClientLoginWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private JPanel panelCentre;
	private  static JLabel lblMail;
	private JTextField textMail;
	private JLabel lblPass;
	private JPasswordField textPass;
	private JButton btnLogin;
	private LoginController lController;
	private JComboBox<String> comboLogin;
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
		
		comboLogin = new JComboBox<>();
		comboLogin.addItem("Normal");
		comboLogin.addItem("Google");
		comboLogin.addItem("Facebook");
		
		panelSouth = new JPanel();
		panelSouth.add(comboLogin);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		btnLogin = new JButton("LOG IN");
		panelSouth.add(btnLogin);
		
		panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblMail = new JLabel("Insert your email:");
		panelCentre.add(lblMail);
		
		textMail = new JTextField();
		panelCentre.add(textMail);
		textMail.setColumns(10);
		
		lblPass = new JLabel("Insert your password:");
		panelCentre.add(lblPass);
		
		textPass = new JPasswordField();
		panelCentre.add(textPass);
		textPass.setColumns(10);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mail = textMail.getText();
				String pass = textPass.getText();
				
				//TODO log in to menu windows
				User u = new User();
				u.setEmail(mail);
				u.setPassword(pass);
				String op = (String) comboLogin.getSelectedItem();
				
				if(op=="Google") {
				
					u.setUsertype(LoginUserType.Google);
				
				}else if(op=="Facebook"){
					u.setUsertype(LoginUserType.Facebook);
				}else {
					u.setUsertype(LoginUserType.Email);
				}
				System.out.println("Succesfully Loged in");
				setVisible(false);
				ClientMainWindow mainwin = new ClientMainWindow();
			}
		});
		setVisible(true);
	}

}
