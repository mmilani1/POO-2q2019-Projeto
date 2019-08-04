package Application;

import Application.Views.Sessions.SessionsCreate;
import Application.Views.User.UserCreate;
import Application.Views.User.UserRoot;
import Models.User;

public class UserController {
	public static void start() {
		UserRoot.render();
	}
	
	public static void create() {
		UserCreate.render();
	}

	public static void store(String name, String username, String password) {
		try {
			User user = User.create(name, username, password);
			SessionController.authenticatedUser = user;
		} catch (Exception e) {
			System.out.println("Um erro ocorreu no seu cadastro, por favor tente novamente");
			SessionsCreate.render();
		}
		
		UserRoot.render();
	}
}
