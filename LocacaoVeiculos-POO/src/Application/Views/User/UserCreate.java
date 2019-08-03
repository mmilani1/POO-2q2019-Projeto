package Application.Views.User;

import Application.UserController;
import Application.Views.BaseView;

public class UserCreate extends BaseView {
	public static void render() {
		System.out.println("Você agora irá se cadastrar como cliente");
		
		System.out.println();
		
		System.out.println("Digite seu nome:");
		String name = read();
		
		System.out.println("Digite seu email:");
		String email = read();
		
		System.out.println("Digite sua senha de acesso:");
		String password = read();
		
		UserController.store(name, email, password);
	}
}