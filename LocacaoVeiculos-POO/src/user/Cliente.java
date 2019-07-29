package user;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class Cliente extends Model {
	static private List<Cliente> employees = new ArrayList<Cliente>();
	static int idCounter = 0;

	@SuppressWarnings("unused")
	private final int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	static public List<Cliente> employees() {
		return employees;
	}

	public Cliente() {
		id = autoIncrements();
	}

	public Cliente(String name) {
		id = autoIncrements();
		setName(name);
	}

	public static void load() {
		employees = new ArrayList<>(loadInstances(Cliente.class));
		idCounter = employees.size();
	}

	public static void create(String nome) {
		Cliente employee = new Cliente(nome);
		employees.add(employee);

		save(Cliente.class, employees());
	}

	private static int autoIncrements() {
		idCounter += 1;
		return idCounter;
	}

	@Override
	public String toString() {
		return "Employee: " + getName();
	}
}