package client.controller;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import client.remote.ServiceLocator;
import server.data.dto.SessionDTO;
import server.data.dto.UserDTO;
import server.data.dto.ChallengeDTO;


public class CrController {
	//Reference to the Service locator
	protected ServiceLocator serviceLocator;
	public CrController(ServiceLocator serviceLocator) {
		this.serviceLocator= serviceLocator;
	}
	
	public List<ChallengeDTO> getChallenges(){
		try {
			return this.serviceLocator.getService().getChallenges();
			
		}catch(RemoteException e) {
			System.out.println("Error geting all challenges");
			return null;
		}
	}
	public float challAcomplished(UserDTO user,ChallengeDTO challenge)throws RemoteException{
		return this.serviceLocator.getService().challAcomplished(user, challenge);
	}
	public void createChallenge(UserDTO userDTO,String name, Date start, Date end ,int distance ,float time,String Sport ) throws RemoteException{
		this.serviceLocator.getService().createChallenge(userDTO, name, start, end, distance, time, Sport);
	}
	
	public void DelChallenge(String title)throws RemoteException{
		this.serviceLocator.getService().DelChallenge(title);
	}
	
	public void createSession(UserDTO userDTO, String title , String sport, int distance, Date start, long duration)throws RemoteException{
		 this.serviceLocator.getService().createSession(userDTO, title, sport, distance, start, duration);
	}
	public void acceptChallenge(UserDTO userDTO, ChallengeDTO challengeAccepted) throws RemoteException {
		this.serviceLocator.getService().acceptChallenge(userDTO, challengeAccepted);
	}
	
	
}
		
		

