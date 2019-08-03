package Application.Views.Employee;

import java.util.List;

import Application.EmployeeController;
import Application.SessionController;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeEdit extends BaseView {
	private static Employee authUser = SessionController.authenticatedEmployee;
	
	public static void render(List<Employee> employees) {
		System.out.println("Escolha um funcionario para editar.");
		System.out.println("Caso queira cancelar esta ação, digite 'X'");
		
		printOptions(employees);
		
		String option = read();
		
		EmployeeController.edit(option);
	}
	
	private static void printOptions(List<Employee> employees) {
		if (employees.isEmpty()) {
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