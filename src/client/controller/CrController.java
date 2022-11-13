package client.controller;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import client.remote.ServiceLocator;
import server.data.dto.SessionDTO;
import server.data.domain.Challenge;
import server.data.domain.Session;
import server.data.domain.User;
import server.data.dto.ChallengeDTO;
public class CrController {
	//Reference to the Service locator
	private ServiceLocator serviceLocator;
	public CrController(ServiceLocator serviceLocator) {
		this.serviceLocator= serviceLocator;
	}
	public List<SessionDTO> getSessions(){
		try {
			return this.serviceLocator.getService().getSessions();
			
		}catch(RemoteException e) {
			System.out.println("Error geting all sessions");
			return null;
		}
	}
	public List<ChallengeDTO> getChallenges(){
		try {
			return this.serviceLocator.getService().getChallenges();
			
		}catch(RemoteException e) {
			System.out.println("Error geting all challenges");
			return null;
		}
	}
	public boolean makeCr(long token,String title) {
		try {
			return this.serviceLocator.getService().makeCr(token, title);
		
		}catch(RemoteException e){
			System.out.println("Error doing session or challenge");
			return false;
		}
	}
	public Challenge createChallenge(String name,Date start, Date end, int distance, long time, User Owner) {
		return this.serviceLocator.getService().createChallenge(name, start, end, distance, time, Owner);
	}
	public Session createSession(String title, String sport,int distance,Date start,Date end,User Owner,long duration) {
		return this.serviceLocator.getService().createSession(title, sport, distance, start, end, Owner, duration);
	}
		
}
