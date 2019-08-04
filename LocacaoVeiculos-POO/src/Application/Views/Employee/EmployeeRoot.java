package Application.Views.Employee;

import Application.EmployeeController;
import Application.SessionController;
import Application.Views.ApplicationRoot;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeRoot extends BaseView {
	static Employee user = SessionController.authenticatedEmployee;
	
	public static void render() {
		System.out.println("Bem Vindo, " + user.getName());
		
		System.out.println();
		
		System.out.println("1 - Lista de funcionários");
		System.out.println("2 - Cadastrar um novo funcionário");
		System.out.println("3 - Remover um funcionario");
		System.out.println("4 - Editar um funcionário");
		System.out.println("\nX - Sair");
		
		
		employeeRoutes();
	}
	
	private static void employeeRoutes() {
		String option = read();
		
		while(true)	{			
			switch (option) {
			case "1":
				EmployeeController.index();
				return;
			case "2":
				EmployeeController.create();
				return;
			case "3":
				EmployeeController.remove();
				return;
			case "4":
				EmployeeController.edit();
				return;
			case "X":
				ApplicationRoot.render();
				return;
			default:
				System.out.println("Você deve escolher uma opção válida");
				option = read();
				break;
			}
		}
	}
}
