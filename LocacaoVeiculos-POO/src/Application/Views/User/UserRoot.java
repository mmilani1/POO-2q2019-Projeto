package Application.Views.User;

import Application.VehicleController;
import Application.ApplicationController;
import Application.RentController;
import Application.SessionController;
import Application.Views.BaseView;
import Models.User;

public class UserRoot extends BaseView {
	private static User user = SessionController.authenticatedUser;
	
	public static void render() {
		System.out.println("Bem Vindo, " + user.getName() + "\n");
		
		System.out.println("1 - Lista de veiculos para loca��o");
		System.out.println("2 - Buscar ve�culos");
		System.out.println("3 - Minhas loca��es");

		System.out.println("\nX - Sair");
		
		userRoutes();
	}
	
	private static void userRoutes() {
		String option = read();
		
		while(true)	{			
			switch (option) {
			case "1":
				VehicleController.rentIndex();
				return;
			case "2":
				VehicleController.search();
				return;
			case "3":
				RentController.index(user);
				return;
			case "X":
				ApplicationController.start();
				return;
			default:
				System.out.println("Voc� deve escolher uma op��o v�lida");
				option = read();
				break;
			}
		}
	}
}
