package Application;

import java.util.Scanner;

import user.Cliente;
import user.Funcionario;
import user.Usuario;

public class Session {
	static Usuario authenticatedUser;
	
	static void login() {
		System.out.println("Deseja entrar como cliente ou funcionário?");
		String type = getUserType();
		
		switch (type) {
		case "client":
			authenticateClient();
			break;
		case "employee":
			authenticateEmployee();
			break;
		default:
			break;
		}
	}
	
	static void signup() {
		System.out.println("Deseja se cadastrar como cliente ou funcionário?");
		String type = getUserType();
		
		// TODO
	}
	
	private static boolean authenticateClient() {
		// TODO
		return true;
	}
	
	private static boolean authenticateEmployee() {
		// TODO	
		return true;
	}
	
	private static String getUserType() {
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		
		Scanner scan = new Scanner(System.in);
		String type = scan.next();
		
		while(true) {
			switch (type) {
			case "1":
				scan.close();
				return "client";
			case "2":
				scan.close();
				return "employee";
			default:
				System.out.println("Você deve escolher uma opção válida");
				scan.next();
				break;
			}
		}
		
	}
}
