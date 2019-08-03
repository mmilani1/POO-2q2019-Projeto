import Models.User;
import Models.Employee;

public class Initializer {
	private static boolean initialized = false;
	protected static void loadData() {
		if(!initialized) {
			User.load();
			Employee.load();
		}
		initialized = true;
	}
}
