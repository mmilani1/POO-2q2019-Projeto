package Application.Views.Vehicle;

import Application.VehicleController;
import Application.SessionController;
import Application.Views.ApplicationRoot;
import Application.Views.BaseView;
import Models.Employee;

public class VehicleRoot extends BaseView {
	static Employee user = SessionController.authenticatedEmployee;
	
	public static void render() {
		System.out.println("Gerenciamento de veiculos\n");
		
		System.out.println("1 - Lista de veiculos");
		System.out.println("2 - Cadastrar um novo veiculos");
		System.out.println("3 - Remover um veiculos");
		System.out.println("4 - Buscar um veiculos");
		
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
			case "X":
				ApplicationRoot.render();
				return;
			default:
				System.out.println("Voc� deve escolher uma op��o v�lida");
				option = read();
				break;
			}
		}
	}
}
