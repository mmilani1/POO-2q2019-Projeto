package Application.Views.Employee;

import Application.EmployeeController;
import Application.SessionController;
import Application.Views.BaseView;
import Models.Employee;

public class EmployeeCreate extends BaseView {
	private static Employee authUser = SessionController.authenticatedEmployee;

	public static void render() {
		if (authUser.getRole().equals("super-admin")) {
			System.out.println("\nVoc� agora ir� cadastrar um novo funcion�rio");

			System.out.println();

			System.out.println("Digite o nome:");
			String name = read();

			String role = getEmployeeRole();

			System.out.println("Digite o username:");
			String username = read();

			System.out.println("Digite a senha de acesso:");
			String password = read();

			EmployeeController.store(name, role, username, password);
		}

		System.out.println("\nVoc� n�o tem permiss�es suficientes para esta a��o\n");
		EmployeeController.start();
	}

	private static String getEmployeeRole() {
		System.out.println("1 - Administrador");
		System.out.println("2 - Super-Administrador");

		String type = read();

		while (true) {
			switch (type) {
			case "1":
				return "admin";
			case "2":
				return "super-admin";
			default:
				System.out.println("Voc� deve escolher uma op��o v�lida");
				type = read();
				break;
			}
		}
	}
}