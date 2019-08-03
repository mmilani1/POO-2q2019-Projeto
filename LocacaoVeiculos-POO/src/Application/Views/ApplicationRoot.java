package Application.Views;

import Application.SessionController;
import Application.UserController;

public abstract class ApplicationRoot extends BaseView {
	public static void render() {
		printOptions();
		
		String option = read();
		
		while(true) {
			switch (option) {
			case "1":
				SessionController.create();
				break;
			case "2":
				UserController.create();
				break;
			case "X":
				System.exit(0);
				return;
			default:
				System.out.println("Você deve escolher uma opção válida.");
				option = read();
				break;
			}
		}
	}
	
	private static void printOptions() {
		System.out.println("Bem Vindo,");
		
		System.out.println("");

		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar");

		System.out.println("");
		
		System.out.println("X para sair");
	}
}
