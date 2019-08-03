package Application.Views.Employee;

import Application.EmployeeController;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeUpdate extends BaseView {
	public static void render(Employee employee) {
		employee.setName(getNewName(employee.getName()));
		employee.setEmail(getNewEmail(employee.getEmail()));
		
		EmployeeController.update();
	}
	
	private static String getNewName(String originalName) {
		System.out.println("Digite o novo nome do funcionario. Caso não queira alterar, digite o nome atual");
		System.out.println("Nome: " + originalName + "\n");
		
		String name = read();
		
		return name;
	}
	
	private static String getNewEmail(String originalEmail) {
		System.out.println("Digite o novo email do funcionario. Caso não queira alterar, digite o email atual");
		System.out.println("Email: " + originalEmail + "\n");
		
		String email = read();
		
		return email;
	}
}
