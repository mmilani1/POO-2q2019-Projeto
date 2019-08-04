package Application.Views.Vehicle;

import Application.VehicleController;
import Application.ApplicationController;
import Application.RentController;
import Application.Views.BaseView;

public class VehicleRoot extends BaseView {
	public static void render() {
		System.out.println("Gerenciamento de veiculos\n");
		
		System.out.println("1 - Lista de veiculos");
		System.out.println("2 - Cadastrar um novo veiculos");
		System.out.println("3 - Remover um veiculo");
		System.out.println("4 - Buscar um veiculos");
		System.out.println("5 - Lista de locações");
		
		System.out.println("\nX - Sair");
		
		vehicleRoutes();
	}
	
	private static void vehicleRoutes() {
		String option = read();
		
		while(true)	{			
			switch (option) {
			case "1":
				VehicleController.index();
				return;
			case "2":
				VehicleController.create();
				return;
			case "3":
				VehicleController.remove();
				return;
			case "4":
				VehicleController.search();
				return;
			case "5":
				RentController.index();
				return;
			case "X":
				ApplicationController.start();
				return;
			default:
				System.out.println("Você deve escolher uma opção válida");
				option = read();
				break;
			}
		}
	}
}
