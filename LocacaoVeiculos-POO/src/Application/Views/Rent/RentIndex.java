package Application.Views.Rent;

import java.util.List;

import Application.EmployeeController;
import Application.SessionController;
import Application.UserController;
import Application.Views.BaseView;
import Models.Employee;
import Models.Rent;

public class RentIndex extends BaseView {
	private static Employee employeeUser;
	public static void render(List<Rent> rents) {
		employeeUser = SessionController.authenticatedEmployee;
		
		System.out.println("Lista de locações");
		System.out.println("Caso queira sair, digite 'X'\n");
		
		printList(rents);
		
		String option = read();
		while(!option.equals("X")) {
			option = read();
		}
		
		if(employeeUser != null)
			EmployeeController.start();
		
		UserController.start();
	}
	
	private static void printList(List<Rent> rents) {
		if (rents.isEmpty()) {
			System.out.println("Não existe locações na lista");
			return;
		}
		
		for (Rent rent : rents) {
			System.out.println(rent.toString());
		}
	}
}
