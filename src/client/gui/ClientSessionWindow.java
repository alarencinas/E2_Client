package client.gui;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import client.controller.CrController;
import server.data.dto.SessionDTO;


public class ClientSessionWindow extends JFrame {

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
	private  JLabel lblEnd;
	private  JTextField textDur;
	private JButton btnEnter;
	private JDateChooser calendarStart;
	private JDateChooser calendarEnd;
	private SimpleDateFormat sdf;
	private CrController controller;

	/**
	 * Launch the application.
	 * @throws RemoteException 
	 */
	//Methods
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSessionWindow frame = new ClientSessionWindow();
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
		public ClientSessionWindow() {
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
			
			calendarStart = new JDateChooser();
			panelCentre.add(calendarStart);
			
			lblEnd = new JLabel("Insert the ending date:");
			panelCentre.add(lblEnd);
			
			calendarEnd = new JDateChooser();
			panelCentre.add(calendarEnd);
			
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dact = new Date(System.currentTimeMillis());
			calendarStart.getJCalendar().setMaxSelectableDate(dact);
			calendarEnd.getJCalendar().setMaxSelectableDate(dact);	
		
			
			lblOwner = new JLabel("Insert the owner:");
			panelCentre.add(lblOwner);
			
			textOwner = new JTextField();
			panelCentre.add(textOwner);
			
			lblDur = new JLabel("Insert the duration:");
			panelCentre.add(lblDur);
			
			textDur =new JTextField();
			panelCentre.add(textDur);
			
			btnEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String title=textTitle.getText();
					String sport=textSport.getText();
					int distance=Integer.parseInt(textDist.getText());
					Date start=calendarStart.getDate();
					Date end=calendarEnd.getDate();
					String owner=textOwner.getText();
					long duration=Long.parseLong(textDur.getText());
					
					SessionDTO s = new SessionDTO();
					
					try {
						s.setDistance(distance);
						s.setDuration(duration);
						s.setSport(sport);
						s.setStart(start);
						s.setTitle(title);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//TODO add info 
					System.out.println("Session created");
					setVisible(false);
//					ClientMainWindow mainwin = new ClientMainWindow();
					
				}
			});

			setVisible(true);
		}

}
