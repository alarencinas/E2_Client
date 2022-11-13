package client.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.remote.ServiceLocator;
import server.data.domain.User;


//This class implements Controller pattern.
public class LoginController {
	private ServiceLocator serviceLocator;
	//This attibute stores the token when login success
	private long token = -1; //-1 = login has not been done or fails

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().login(email, password);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}
	public User RegisterUser(String nickname,String password) {
		return this.serviceLocator.getService().RegisterUser(nickname, password);
	}
	public long getToken() {
		return token;
	}
	
}
