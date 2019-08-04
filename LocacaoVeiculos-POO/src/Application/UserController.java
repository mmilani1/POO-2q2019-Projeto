package Application;

import Application.Views.Sessions.SessionsCreate;
import Application.Views.User.UserCreate;
import Models.User;

public class UserController {
	public static void create() {
		UserCreate.render();
	}

	public static void store(String name, String email, String password) {
		try {
			User.create(name, email, password);
		} catch (Exception e) {
			System.out.println("Um erro ocorreu no seu cadastro, por favor tente novamente");
			SessionsCreate.render();
		}
	}
}
