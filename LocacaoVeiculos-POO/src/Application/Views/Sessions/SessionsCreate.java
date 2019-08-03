package Application.Views.Sessions;

import Application.SessionController;
import Application.Views.BaseView;

public class SessionsCreate extends BaseView {
	public static void render() {
		String userType = getUserType();
		String email = getUserEmail();
		String password = getUserPassword();
		
		SessionController.store(userType, email, password);
	}
}
