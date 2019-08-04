import Models.User;
import Models.Vehicle;
import Models.Employee;
import Models.Rent;

public class Initializer {
	private static boolean initialized = false;
	protected static void loadData() {
		if(!initialized) {
			User.load();
			Employee.load();
			Vehicle.load();
			Rent.load();
		}
		initialized = true;
	}
}
