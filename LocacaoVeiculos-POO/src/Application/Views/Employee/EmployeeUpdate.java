package Application.Views.Employee;

import Application.EmployeeController;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeUpdate extends BaseView {
	public static void render(Employee employee) {
		employee.setName(getNewName(employee.getName()));
		employee.setUsername(getNewUsername(employee.getUsername()));
		
		EmployeeController.update();
	}
	
	private static String getNewName(String originalName) {
		System.out.println("Digite o novo nome do funcionario. Caso não queira alterar, digite o nome atual");
		System.out.println("Nome: " + originalName + "\n");
		
		String name = read();
		
		return name;
	}
	
	private static String getNewUsername(String originalUsername) {
		System.out.println("Digite o novo username do funcionario. Caso não queira alterar, digite usernameil atual");
		System.out.println("Username: " + originalUsername + "\n");
		
		String username = read();
		
		return username;
	}
}
