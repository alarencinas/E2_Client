package client;
import client.controller.CrController;
import client.controller.LoginController;
import client.gui.*;
import client.remote.*;
public class MainProgram {
	public static void main(String[] args) {	 
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		LoginController loginController = new LoginController(serviceLocator);
		LoginDialog loginDialog = new LoginDialog(loginController);			
		CrController crController = new CrController(serviceLocator);
		//Login
		loginDialog.login();
		ClientSignUpWindow Csup = new ClientSignUpWindow(loginController,crController);
		
	}
}
