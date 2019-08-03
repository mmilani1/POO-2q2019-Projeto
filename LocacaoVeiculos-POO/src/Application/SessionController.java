package Application;

import java.util.Scanner;

import Application.Views.Employee.EmployeeRoot;
import Application.Views.Sessions.SessionsCreate;
import Application.Views.User.UserRoot;
import Application.AutheticationController;
import Models.User;
import Models.Employee;

public class SessionController {
	private static Scanner scan = new Scanner(System.in);
	static public String authenticated = null;
	static public User authenticatedUser = null;
	static public Employee authenticatedEmployee = null;

	public static void create() {
		SessionsCreate.render();
	}

	public static void store(String userType, String email, String password) {
		switch (userType) {
		case "client":
			authenticatedUser = AutheticationController.authenticateUser(email, password);
			if(authenticatedUser != null) {
				authenticated = "user";
				UserRoot.render();
			}
			break;
		case "employee":
			authenticatedEmployee = AutheticationController.authenticateEmployee(email, password);
			if(authenticatedEmployee != null) {
				authenticated = "employee";
				EmployeeRoot.render();
			}
			break;
		default:
			break;
		}
		
		scan.close();
	}
}
