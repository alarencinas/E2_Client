package client.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

import client.remote.ServiceLocator;
import server.data.dto.LoginUserTypeDTO;
import server.data.dto.UserDTO;


//This class implements Controller pattern.
public class LoginController {
	private ServiceLocator serviceLocator;
	//This attibute stores the token when login success
	private long token = -1; //-1 = login has not been done or fails

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password,String nick, LoginUserTypeDTO usertype) {
		try {
			this.token = this.serviceLocator.getService().login(email, password, nick, usertype);			
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
	public UserDTO getUser(String email,String password)throws RemoteException, ParseException{
		return this.serviceLocator.getService().getUser(email, password);
		
	}
	
	public long getToken() {
		return token;
	}
	
}
