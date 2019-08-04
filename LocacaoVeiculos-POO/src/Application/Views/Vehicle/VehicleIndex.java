package Application.Views.Vehicle;

import java.util.List;

import Application.SessionController;
import Application.UserController;
import Application.VehicleController;
import Application.Views.BaseView;
import Models.Employee;
import Models.Vehicle;

public class VehicleIndex extends BaseView {
	private static Employee loggedEmployee;
	
	public static void render(List<Vehicle> vehicles) {
		loggedEmployee = SessionController.authenticatedEmployee;
		
		System.out.println("Lista de veiculos:");
		System.out.println("Escolha um veiculo para ver detalhes.");
		System.out.println("Caso queira sair, digite 'X'\n");
		
		printList(vehicles);
		
		String option = read();
		if(option.equals("X")) {
			returnToRoot();
		}
		
		VehicleController.show(option);
	}
	
	private static void printList(List<Vehicle> vehicles) {
		if (vehicles.isEmpty()) {
			System.out.println("\nNão existe veículos na lista");
			return;
		}
		
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
	}
	
	private static void returnToRoot() {
		if(loggedEmployee != null) {
			VehicleController.start();
		}
		
		UserController.start();
	}
}
