package Application.Views.Vehicle;

import Application.Views.BaseView;
import Models.Vehicle;

public class VehicleShow extends BaseView {

	public static void render(Vehicle vehicle) {
		System.out.println("\nDetalhes do veículo\n");
		System.out.println("ID: " + vehicle.getId());
		System.out.println("Modelo: " + vehicle.getId());
		System.out.println("Fabricante: " + vehicle.getId());
		System.out.println("Categoria: " + vehicle.getId());
		System.out.println("Status: " + vehicle.getId());
		System.out.println("Tarifa diária: " + vehicle.getId());
		
		System.out.println("Locações: TODO");

		
		System.out.println("\nDigite X para sair");
		
		String option = read();
		while(!option.equals("X")) {
			option = read();
		}
		
		VehicleRoot.render();
	}

}
