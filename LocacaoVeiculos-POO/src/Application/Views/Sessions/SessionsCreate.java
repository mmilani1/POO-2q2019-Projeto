package Application.Views.Sessions;

import Application.SessionController;
import Application.Views.BaseView;

public class SessionsCreate extends BaseView {
	public static void render() {
		String userType = getUserType();
		String username = getUserUsername();
		String password = getUserPassword();
		
		SessionController.store(userType, username, password);
	}
}
