package Application.Views;

import java.util.Scanner;

public abstract class BaseView {
	static Scanner userInput = new Scanner(System.in);
	
	protected static String read() {
		System.out.printf("\n--> ");

		String selection = userInput.nextLine();

		while(selection == null || selection.isEmpty()) {
			System.out.println("\nVocê deve escolher uma opção válida.");
			selection = userInput.nextLine();
		}

		return selection;
	}

	protected static String getUserEmail() {
		System.out.println("\nPor favor, digite seu email");
		
		String email = read();

		return email;
	}


	protected static String getUserPassword() {
		System.out.println("\nPor favor, digite sua senha");
		
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