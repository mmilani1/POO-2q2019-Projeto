import Models.User;
import Models.Vehicle;
import Models.Employee;

public class Initializer {
	private static boolean initialized = false;
	protected static void loadData() {
		if(!initialized) {
			User.load();
			Employee.load();
			Vehicle.load();
		}
		initialized = true;
	}
}
