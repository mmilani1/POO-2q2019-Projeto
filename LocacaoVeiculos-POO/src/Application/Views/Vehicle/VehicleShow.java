package Application.Views.Vehicle;

import Application.SessionController;
import Application.VehicleController;
import Application.Views.BaseView;
import Models.Employee;
import Models.User;
import Models.Vehicle;

public class VehicleShow extends BaseView {
	private static User authUser = SessionController.authenticatedUser;
	private static Employee employeeUser = SessionController.authenticatedEmployee;
	private static Vehicle viewdVehicle;
	public static void render(Vehicle vehicle) {
		viewdVehicle = vehicle;
		
		System.out.println("\nDetalhes do ve�culo\n");
		
		System.out.println("ID: " + vehicle.getId());
		System.out.println("Modelo: " + vehicle.getModel());
		System.out.println("Fabricante: " + vehicle.getManufacturer());
		System.out.println("Categoria: " + vehicle.getCategory());
		System.out.println("Status: " + vehicle.getStatus());
		System.out.println("Tarifa di�ria: " + vehicle.getDailyFee());

		if(employeeUser == null) {
			System.out.println("\nPara reservar este carro para loca��o, digite 'S'");			
		}
		
		System.out.println("\nDigite X para sair");
		
		getUserOption();
	}
	
	private static void getUserOption() {
		String option = read();
		
		switch (option) {
		case "S":
			System.out.println("\nDigite por quantos dias deseja alugar este veiculo:");
			String days = read();
			
			VehicleController.rent(authUser, viewdVehicle.getId(), days);
			break;
		case "X":
			VehicleController.start();
			break;
		default:
			break;
		}
	}
}
