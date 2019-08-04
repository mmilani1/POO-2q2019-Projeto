package Models;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class Employee extends Model {
	static private List<Employee> employees = new ArrayList<Employee>();
	static int idCounter = 0;

	private final String id;
	private String name;
	private String role;
	private String username;
	private String password;

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	// Constructors
	private Employee() {
		id = autoIncrements();
	}
	
	private Employee(String name, String role, String username, String password) {
		id = autoIncrements();
		this.name= name;
		this.role = role;
		this.username= username;
		this.password= password;
	}

	// List of Employees
	static public List<Employee> employees() {
		return employees;
	}

	// Load data from database
	public static void load() {
		employees = new ArrayList<>(loadInstances(Employee.class));
		idCounter = employees.size();
	}

	// Public interface for creating new Employees (saves to database)
	public static void create(String name, String role, String username, String password) {
		Employee employee = new Employee(name, role, username, password);
		employees.add(employee);

		save(Employee.class, employees());
	}

	public static void delete(Employee employee) {
		employees.remove(employee);
		save(Employee.class, employees());
	}
	
	public static void update() {
		save(Employee.class, employees());
	}
	
	private static String autoIncrements() {
		idCounter += 1;
		return String.valueOf(idCounter);
	}
	
	@Override
	public String toString() {
		return "[ ID: " + getId() + " | Nome: " + getName() + " | Username: " + getUsername() + " ]";
	}
}