package Application;

import java.util.Scanner;

import Application.Views.Sessions.SessionsCreate;
import Models.User;
import Models.Employee;

public class SessionController {
	private static Scanner scan = new Scanner(System.in);
	static User authenticatedUser = null;
	static Employee authenticatedEmployee = null;
	
	public static void create() {
		SessionsCreate.render();
	}
	
	public static void store(String userType, String email, String password) {
		switch (userType) {
		case "client":
			if(authenticateClient(email, password)) System.out.println("TODO"); //ClientRoot.render();
			break;
		case "employee":
			if(authenticateEmployee(email, password)) System.out.println("TODO"); //EmployeeRoot.render();
			break;
		default:
			break;
		}
		
		scan.close();
	}
	
	private static boolean authenticateClient(String email, String password) {
		System.out.println("client");
		return true;
	}
	
	private static boolean authenticateEmployee(String email, String password) {
		System.out.println("employee");
		return true;
	}
	
	
}
