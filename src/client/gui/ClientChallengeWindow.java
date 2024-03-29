package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;




import server.data.dto.ChallengeDTO;
import server.data.dto.UserDTO;
import client.controller.*;

@SuppressWarnings("serial")
public class ClientChallengeWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private  JPanel panelCentre;
	private  JLabel lblName;
	private  JTextField textName;
	private  JLabel lblDist;
	private  JTextField textDist;
	private  JLabel lblOwner;
	private  JTextField textOwner;
	private  JLabel lblStart;
	private  JLabel lblEnd;
	private  JLabel lblTime;
	private  JTextField textTime;
	private JButton btnEnter;
	private JTextField start, end;
	private SimpleDateFormat sdf;
	private JLabel lblSport;
	private JTextField textSport;
	/**
	 * Launch the application.
	 * @throws RemoteException 
	 */
	//Methods
	
	
		
	
	/**
	 * Create the frame.
	 */
		public ClientChallengeWindow(UserDTO user,CrController crController,LoginController loginController) {
			setTitle("CREATE CHALLENGE");
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
			
			lblName = new JLabel("Insert the name:");
			panelCentre.add(lblName);
			
			textName = new JTextField();
			panelCentre.add(textName);
			
			lblStart = new JLabel("Insert the starting date:");
			panelCentre.add(lblStart);
			
			start = new JTextField();
			panelCentre.add(start);
			
			lblEnd = new JLabel("Insert the ending date:");
			panelCentre.add(lblEnd);
			
			end = new JTextField();
			panelCentre.add(end);
			
			lblDist = new JLabel("Insert the distance:");
			panelCentre.add(lblDist);
			
			textDist = new JTextField();
			panelCentre.add(textDist);
			
			lblTime = new JLabel("Insert the Time:");
			panelCentre.add(lblTime);
			
			textTime = new JTextField();
			panelCentre.add(textTime);
			
		
			
			lblOwner = new JLabel("Insert the owner:");
			panelCentre.add(lblOwner);
			
			textOwner = new JTextField();
			panelCentre.add(textOwner);
			
			lblSport = new JLabel("Insert the Sport:");
			panelCentre.add(lblSport);
			
			textSport = new JTextField();
			panelCentre.add(textSport);
			
			
			btnEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					sdf = new SimpleDateFormat("dd-MM-yyyy");
					String name= textName.getText();
					Date dstart = new Date();
					Date dend  = new Date();
					int dist = Integer.parseInt(textDist.getText());
					float time = Float.parseFloat(textTime.getText());
					String ownerName = textOwner.getText();
					String sport = textSport.getText();
					
					try {
						dstart = sdf.parse(start.getText());
						dend = sdf.parse(end.getText());
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					try {
						crController.createChallenge(user, ownerName, dstart, dend, dist, time, sport);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
					System.out.println("Challege created");
					setVisible(false);
					ClientMainWindow mainwin = new ClientMainWindow(user,crController,loginController);
					mainwin.setVisible(true);
				}
			});

			setVisible(true);
		}

}
