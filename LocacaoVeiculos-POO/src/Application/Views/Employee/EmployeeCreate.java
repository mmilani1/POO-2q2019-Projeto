package Application.Views.Employee;

import Application.EmployeeController;
import Application.Views.BaseView;

public class EmployeeCreate extends BaseView {
	public static void render() {
		System.out.println("Você agora irá cadastrar um novo funcionário");
		
		System.out.println();
		
		System.out.println("Digite o nome:");
		String name = read();
		
		System.out.println("Digite o email:");
		String email = read();
		
		System.out.println("Digite a senha de acesso:");
		String password = read();
		
		EmployeeController.store(name, email, password);
	}
}