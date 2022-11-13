package client.controller;
import java.rmi.RemoteException;
import java.util.List;
import client.remote.ServiceLocator;
import server.data.dto.SessionDTO;
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

}
