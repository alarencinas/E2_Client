package client.gui;

import java.awt.EventQueue;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import client.controller.CrController;
import client.controller.LoginController;
import server.data.dto.LoginUserTypeDTO;
import server.data.dto.UserDTO;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	

	/**
	 * Create the frame.
	 */
	public ClientLoginWindow(LoginController loginController, CrController crController) {
		
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
				String pass = String.valueOf(textPass.getPassword());
				try {
					if(loginController.getUser(mail, pass)!= null){
						new ClientMainWindow(loginController.getUser(mail, pass),crController,loginController);
						
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Password");
					}
					
				}catch (RemoteException e2) {
					e2.printStackTrace();
				}

 catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setVisible(true);
	}

}
