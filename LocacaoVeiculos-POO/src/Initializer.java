import employee.Employee;
import employee.Funcionario;

public class Initializer {
	private static boolean initialized = false;
	protected static void loadData() {
		if(!initialized) {
			Employee.load();
			Funcionario.load();
		}
		initialized = true;
	}
}
