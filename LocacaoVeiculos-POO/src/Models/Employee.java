package Models;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class Employee extends Model {
	static private List<Employee> employees = new ArrayList<Employee>();
	static int idCounter = 0;

	private final int id;
	private String name;
	private String email;
	private String password;

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	// Constructors
	private Employee() {
		id = autoIncrements();
	}
	
	private Employee(String name, String email, String password) {
		id = autoIncrements();
		this.name= name;
		this.email= email;
		this.password= password;
	}

	// List of Employees
	static public List<Employee> employeess() {
		return employees;
	}

	// Load data from database
	public static void load() {
		employees = new ArrayList<>(loadInstances(Employee.class));
		idCounter = employees.size();
	}

	// Public interface for creating new Employees (saves to database)
	public static void create(String name, String email, String password) {
		Employee employee = new Employee(name, email, password);
		employees.add(employee);

		save(Employee.class, employeess());
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