package employee;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class Employee extends Model {
	static private List<Employee> employees = new ArrayList<Employee>();
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

	static public List<Employee> employees() {
		return employees;
	}

	public Employee() {
		id = autoIncrements();
	}

	public Employee(String name) {
		id = autoIncrements();
		setName(name);
	}

	public static void load() {
		employees = new ArrayList<>(loadInstances(Employee.class));
		idCounter = employees.size();
	}

	public static void create(String nome) {
		Employee employee = new Employee(nome);
		employees.add(employee);

		save(Employee.class, employees());
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