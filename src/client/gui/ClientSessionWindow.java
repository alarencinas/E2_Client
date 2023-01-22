package client.gui;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import client.controller.CrController;
import client.controller.LoginController;
import server.data.dto.SessionDTO;
import server.data.dto.UserDTO;


public class ClientSessionWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSouth;
	private static JPanel panelCentre;
	private  JLabel lblTitle;
	private  JTextField textTitle;
	private  JLabel lblSport;
	private JTextField textSport;
	private  JLabel lblDist;
	private  JTextField textDist;
	private  JLabel lblOwner;
	private  JTextField textOwner;
	private  JLabel lblDur;
	private  JLabel lblStart;
	private  JTextField textDur;
	private JTextField dateStart;
	
	private JButton btnEnter;
	
	private SimpleDateFormat sdf;
	private CrController controller;

	/**
	 * Launch the application.
	 * @throws RemoteException 
	 */
	//Methods
	


	/**
	 * Create the frame.
	 */
		public ClientSessionWindow(UserDTO user,CrController crController,LoginController loginController ) {
			setTitle("CREATE SESSION");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			panelSouth = new JPanel();
			contentPane.add(panelSouth, BorderLayout.SOUTH);
			
			btnEnter = new JButton("ENTER");
			panelSouth.add(btnEnter);
			
			panelCentre = new JPanel();
			contentPane.add(panelCentre, BorderLayout.CENTER);
			panelCentre.setLayout(new GridLayout(7, 2));
			
			lblTitle = new JLabel("Insert the title:");
			panelCentre.add(lblTitle);
			
			textTitle = new JTextField();
			panelCentre.add(textTitle);
			
			lblSport = new JLabel("Insert the sport:");
			panelCentre.add(lblSport);
			
			textSport = new JTextField();
			panelCentre.add(textSport);

			lblDist = new JLabel("Insert the distance:");
			panelCentre.add(lblDist);
			
			textDist = new JTextField();
			panelCentre.add(textDist);
			
			lblStart = new JLabel("Insert the starting date:");
			panelCentre.add(lblStart);
			
			dateStart= new JTextField();
			panelCentre.add(dateStart);
			
			
			lblDur = new JLabel("Insert the duration:");
			panelCentre.add(lblDur);
			
			textDur =new JTextField();
			panelCentre.add(textDur);
			
			btnEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String title=textTitle.getText();
					sdf = new SimpleDateFormat("dd-MM-yyyy");
					String sport=textSport.getText();
					int distance=Integer.parseInt(textDist.getText());
					Date start = new Date();
					try {
						 start = sdf.parse(dateStart.getText());
						
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					long duration=Long.parseLong(textDur.getText());
					
					
					try {
						crController.createSession(user, title, sport, distance, start, duration);
					
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//TODO add info 
					System.out.println("Session created");
					setVisible(false);

					
				}
			});

			setVisible(true);
		}

}
