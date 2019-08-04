package Application.Views.Vehicle;

import java.util.List;


import Application.VehicleController;
import Application.Views.BaseView;
import Models.Vehicle;

public class VehicleRemove extends BaseView {
	public static void render(List<Vehicle> vehicles) {
		System.out.println("Escolha um veiculo para remover.");
		System.out.println("Caso queira cancelar esta ação, digite 'X'");
		System.out.println();

		printOptions(vehicles);

		String option = read();

		VehicleController.remove(option);

	}

	private static void printOptions(List<Vehicle> vehicles) {
		if (vehicles.size() == 1) {
			System.out.println("Não existe veiculos na lista");
			return;
		}

		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
	}
}
