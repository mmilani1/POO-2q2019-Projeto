package Application.Views.Employee;

import java.util.List;

import Application.EmployeeController;
import Application.SessionController;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeRemove extends BaseView {
	private static Employee authUser = SessionController.authenticatedEmployee;
	
	public static void render(List<Employee> employees) {
		if(authUser.getRole().equals("super-admin")) {
			System.out.println("Escolha um funcionario para remover.");
			System.out.println("Caso queira cancelar esta ação, digite 'X'");
			System.out.println();
			
			printOptions(employees);
			
			String option = read();
			
			EmployeeController.remove(option);			
		}
		
		System.out.println("Você não tem permissões suficientes para esta ação");
		EmployeeRoot.render();
	}

	private static void printOptions(List<Employee> employees) {
		if (employees.toArray().length == 1) {
			System.out.println("Não existe funcionarios na lista");
			return;
		}
		
		for (Employee employee : employees) {
			if(!employee.equals(authUser)) {
				System.out.println(employee.getId() + " - " + employee.getName());
			}
		}
	}
}