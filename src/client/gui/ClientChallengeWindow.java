package client.gui;


import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import server.data.domain.Challenge;
import server.data.domain.Session;
import server.data.domain.User;
import server.remote.*;
import client.controller.*;
public class ClientChallengeWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private static JPanel panelCentre;
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
	private JDateChooser calendarStart;
	private JDateChooser calendarEnd;
	private SimpleDateFormat sdf;
	private CrController controller;

	/**
	 * Launch the application.
	 */
	//Methods
	public Challenge createChallenge(String name,Date start, Date end, int distance, long time, User Owner) {
		System.out.println("Creating Challenge");
		Challenge c=this.controller.createChallenge(name, end, end, distance, time, Owner);
		return c;
	}
	
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientChallengeWindow frame = new ClientChallengeWindow();
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
		public ClientChallengeWindow() {
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
			panelCentre.setLayout(new GridLayout(6, 2));
			
			lblName = new JLabel("Insert the name:");
			panelCentre.add(lblName);
			
			textName = new JTextField();
			panelCentre.add(textName);
			
			lblStart = new JLabel("Insert the starting date:");
			panelCentre.add(lblStart);
			
			calendarStart = new JDateChooser();
			panelCentre.add(calendarStart);
			
			lblEnd = new JLabel("Insert the ending date:");
			panelCentre.add(lblEnd);
			
			calendarEnd = new JDateChooser();
			panelCentre.add(calendarEnd);
			
			lblDist = new JLabel("Insert the distance:");
			panelCentre.add(lblDist);
			
			textDist = new JTextField();
			panelCentre.add(textDist);
			
			lblTime = new JLabel("Insert the Time:");
			panelCentre.add(lblTime);
			
			textTime = new JTextField();
			panelCentre.add(textTime);

			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dact = new Date(System.currentTimeMillis());
			calendarStart.getJCalendar().setMaxSelectableDate(dact);
			calendarEnd.getJCalendar().setMaxSelectableDate(dact);	
		
			
			lblOwner = new JLabel("Insert the owner:");
			panelCentre.add(lblOwner);
			
			textOwner = new JTextField();
			panelCentre.add(textOwner);
			
			
			btnEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name= textName.getText();
					Date start = calendarStart.getDate();
					Date end  = calendarEnd.getDate();
					int dist = Integer.parseInt(textDist.getText());
					float time = Float.parseFloat(textTime.getText());
					String owner = textOwner.getText();
					createChallenge(name, start, end, dist, dist, null );
					//TODO add info 
				}
			});

			setVisible(true);
		}

}
