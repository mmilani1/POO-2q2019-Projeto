package Application;

import java.util.Scanner;

public class Application {
	public static void start() {
		printOptions();
		
		String option = catchUserOption();
		
		while(true) {
			switch (option) {
			case "1":
				Session.login();
				break;
			case "2":
				Session.signup();
				break;
			case "X":
				return;
			default:
				System.out.println("Você deve escolher uma ação válida");
				option = catchUserOption();
				break;
			}
		}
	}
	
	private static String catchUserOption() {
		Scanner scan = new Scanner(System.in);
		String selection = scan.next();

		if(selection == null || selection.isEmpty()) {
			System.out.println("Você deve escolher uma ação");
			scan.close();
			catchUserOption();
		}
		
		scan.close();
		return selection;
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
