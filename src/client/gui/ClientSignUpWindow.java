package client.gui;

import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.controller.CrController;
import client.controller.LoginController;
import server.data.dto.LoginUserTypeDTO;
import server.data.dto.UserDTO;

public class ClientSignUpWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private static JPanel panelCentre;
	private  JLabel lblNick;
	private  JTextField textNIck;
	private static JLabel lblPass;
	private static JPasswordField textPass;
	private static JLabel lblMail;
	private static JTextField textMail;
	private JButton btnRegister;
	private JButton btnRegisterGoogle;
	private JButton btnFacebookRegister;
	private static JLabel lblLogin;
	private JButton btnLogin;
	private LoginController LController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ClientSignUpWindow frame = new ClientSignUpWindow(LController, null);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientSignUpWindow(LoginController loginController,CrController crController) {
		setTitle("SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		btnRegister = new JButton("SIGN UP");
		panelSouth.add(btnRegister);
		btnFacebookRegister= new JButton("SIGN UP WITH FACEBOOK");
		panelSouth.add(btnFacebookRegister);
		btnRegisterGoogle= new JButton("SIGN UP WITH GOOGLE");
		panelSouth.add(btnRegisterGoogle);
		lblLogin = new JLabel("Already signed up?");
		panelSouth.add(lblLogin);
		
		btnLogin = new JButton("LOG IN");
		panelSouth.add(btnLogin);
		
		panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNick = new JLabel("Insert your nickname:");
		panelCentre.add(lblNick);
		
		textNIck = new JTextField();
		panelCentre.add(textNIck);
		textNIck.setColumns(10);
		

		
		lblMail = new JLabel("Insert your email:");
		panelCentre.add(lblMail);
		
		textMail = new JTextField();
		panelCentre.add(textMail);
		textNIck.setColumns(10);

		lblPass = new JLabel("Insert your password:");
		panelCentre.add(lblPass);
		
		textPass = new JPasswordField();
		panelCentre.add(textPass);
		textPass.setColumns(10);
		
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = textNIck.getText();
				String mail = textMail.getText();
				//TODO
				//Change
				String pass = textPass.getText();
				try {
					loginController.createUser(LoginUserTypeDTO.Email, nick, pass, mail);
					 new ClientSignUpWindow(loginController, crController);
					 dispose();
				}catch (Exception e3) {
					e3.printStackTrace();
				}
				
				
				
			}
		});
		btnFacebookRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = textNIck.getText();
				String mail = textMail.getText();
				//TODO
				//Change
				String pass = textPass.getText();
				try {
					loginController.createUser(LoginUserTypeDTO.Facebook, nick, pass, mail);
					 new ClientSignUpWindow(loginController, crController);
					 dispose();
				}catch (Exception e3) {
					e3.printStackTrace();
				}
				
				
				
			}
		});
		
	btnRegisterGoogle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = textNIck.getText();
				String mail = textMail.getText();
				//TODO
				//Change
				String pass = textPass.getText();
				try {
					loginController.createUser(LoginUserTypeDTO.Google, nick, pass, mail);
					 new ClientSignUpWindow(loginController, crController);
					 dispose();
				}catch (Exception e3) {
					e3.printStackTrace();
				}
				
				
				
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Log in window
				setVisible(false);
			ClientLoginWindow log = new ClientLoginWindow(loginController, crController);
				
			}
		});
		setVisible(true);
	}

}
