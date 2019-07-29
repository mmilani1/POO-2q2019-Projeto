import user.Cliente;
import user.Funcionario;

public class Initializer {
	private static boolean initialized = false;
	protected static void loadData() {
		if(!initialized) {
			Cliente.load();
			Funcionario.load();
		}
		initialized = true;
	}
}
