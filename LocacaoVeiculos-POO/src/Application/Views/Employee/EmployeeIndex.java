package Application.Views.Employee;

import java.util.List;

import Application.Views.BaseView;
import Models.Employee;

public class EmployeeIndex extends BaseView {
	public static void render(List<Employee> employees) {
		System.out.println("Lista de funcionários:");
		System.out.println("Caso queira sair, digite 'X'\n");
		
		printList(employees);
		
		String option = read();
		while(!option.equals("X")) {
			option = read();
		}
		
		EmployeeRoot.render();
	}
	
	private static void printList(List<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Não existe funcionarios na lista");
			return;
		}
		
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
}