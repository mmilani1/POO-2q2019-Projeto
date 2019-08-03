package Application.Views;

import java.util.Scanner;

public abstract class BaseView {
	static Scanner userInput = new Scanner(System.in);
	
	protected static String read() {
		String selection = userInput.nextLine();

		if(selection == null || selection.isEmpty()) {
			System.out.println("Você deve escolher uma opção válida.");
			read();
		}

		return selection;
	}

	protected static String getUserPassword() {
		System.out.println("Por favor, digite seu email");
		
		String email = read();

		return email;
	}


	protected static String getUserEmail() {
		System.out.println("Por favor, digite sua senha");
		
		String password = read();

		return password;
	}


	protected static String getUserType() {
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");

		String type = read();
		
		while(true) {
			switch (type) {
			case "1":
				return "client";
			case "2":
				return "employee";
			default:
				System.out.println("Você deve escolher uma opção válida");
				type = read();
				break;
			}
		}
	}
}