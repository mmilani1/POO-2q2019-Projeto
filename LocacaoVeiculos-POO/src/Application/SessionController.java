package Application;

import Application.Views.Employee.EmployeeRoot;
import Application.Views.Sessions.SessionsCreate;
import Application.Views.User.UserRoot;
import Application.AutheticationController;
import Models.User;
import Models.Employee;

public class SessionController {
	static public User authenticatedUser = null;
	static public Employee authenticatedEmployee = null;

	public static void create() {
		SessionsCreate.render();
	}

	public static void store(String userType, String username, String password) {
		switch (userType) {
		case "client":
			authenticatedUser = AutheticationController.authenticateUser(username, password);
			if(authenticatedUser != null) {
				authenticatedEmployee = null;
				UserRoot.render();
			}
			break;
		case "employee":
			authenticatedEmployee = AutheticationController.authenticateEmployee(username, password);
			if(authenticatedEmployee != null) {
				authenticatedUser = null;
				EmployeeRoot.render();
			}
			break;
		default:
			break;
		}
	}
}
