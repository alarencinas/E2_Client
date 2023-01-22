package client.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.controller.CrController;
import client.controller.LoginController;
import server.data.dto.ChallengeDTO;
import server.data.dto.UserDTO;

public class ShowChallengesWindow extends JFrame{
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private List<ChallengeDTO> array = new ArrayList<>();
	
	public ShowChallengesWindow(UserDTO user,CrController crController,LoginController loginController){
		
		String [] titles = {"CHALLENGE", "SPORT", "DISTANCE", "OWNER"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(titles);
        table = new JTable(model);
        table.setVisible(true);
        scroll = new JScrollPane(table);
        scroll.setVisible(true);
        
        array = crController.getChallenges();
		for(ChallengeDTO ch : array) {
		    Object[] row =    {ch.getName(),ch.getSport(),String.valueOf(ch.getDistance()),String.valueOf(ch.getOwner().getNickname())};
		    model.addRow(row);
		}
		
		
		setTitle("CHALLENGES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnAccept = new JButton("Accept");
		panelSouth.add(btnAccept);
		
		panel.add(scroll);
		
		btnAccept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pos = table.getSelectedRow();
				ChallengeDTO ch = array.get(pos);
//				try {
//					crController.acceptChallenge(user, ch);
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

				System.out.println("Challenge Accepted");
				dispose();
				ClientLoginWindow wind = new ClientLoginWindow( loginController, crController);
				wind.setVisible(true);
			}
			
		});
		setVisible(true);
	}

}
