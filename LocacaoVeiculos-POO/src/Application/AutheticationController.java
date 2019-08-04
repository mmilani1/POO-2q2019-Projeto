package Application;

import java.util.List;
import java.util.stream.Collectors;

import Application.Views.ApplicationRoot;
import Models.Employee;
import Models.User;

public class AutheticationController {
	public static User authenticateUser(String username, String password) {
		List<User> users = User.users();
		User authUser = null;

		try {
			authUser = users.stream()
					.filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
					.collect(Collectors.toList()).get(0);
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("Não foi possivel encontrar um usuário com essas credenciais");
			ApplicationRoot.render();
		}

		return authUser;
	}

	public static Employee authenticateEmployee(String username, String password) {
		List<Employee> users = Employee.employees();
		Employee authUser = null;

		try {
			authUser = users.stream()
					.filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
					.collect(Collectors.toList()).get(0);
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("Não foi possivel encontrar um usuário com essas credenciais");
			ApplicationRoot.render();
		}

		return authUser;
	}
}
