package Application.Views.Vehicle;

import java.util.List;

import Application.VehicleController;
import Application.Views.BaseView;
import Application.Views.Vehicle.VehicleRoot;
import Models.Vehicle;

public class VehicleIndex extends BaseView {
	public static void render(List<Vehicle> vehicles) {
		System.out.println("Lista de veiculos:");
		System.out.println("Escolha um veiculo para ver detalhes.");
		System.out.println("Caso queira sair, digite 'X'\n");
		
		printList(vehicles);
		
		String option = read();
		if(option.equals("X")) {
			VehicleRoot.render();;
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
}
