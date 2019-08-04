package Application.Views.Rent;

import Application.SessionController;
import Application.UserController;
import Application.EmployeeController;
import Application.Views.BaseView;
import Models.Employee;
import Models.User;
import Models.Vehicle;
import Models.Rent;

public class RentShow extends BaseView {
	private static Employee employeeUser;
	
	public static void render(Rent rent, User user, Vehicle vehicle) {	
		employeeUser = SessionController.authenticatedEmployee;
		
		System.out.println("\nDetalhes da loca��o\n");
		
		System.out.println("ID: " + vehicle.getId());
		System.out.println("Usu�rio: " + user.getName());
		System.out.println("Modelo: " + vehicle.getModel());
		System.out.println("Tarifa total" + rent.getTotalPaid());

		System.out.println("\nDigite X para sair");
		
		getUserOption();
	}
	
	private static void getUserOption() {
		String option = read();
		
		switch (option) {
		case "X":
			returnToRoot();
			break;
		default:
			break;
		}
	}
	
	private static void returnToRoot() {
		if(employeeUser != null) {
			EmployeeController.start();
		}
		
		UserController.start();
	}
}
