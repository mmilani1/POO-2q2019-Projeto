package Models;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class User extends Model {
	static private List<User> employees = new ArrayList<User>();
	static int idCounter = 0;

	private final int id;
	private String name;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	// Constructors
	public String getPassword() {
		return password;
	}
	
	private User() {
		id = autoIncrements();
	}
	
	private User(String name, String email, String password) {
		id = autoIncrements();
		this.name= name;
		this.email= email;
		this.password= password;
	}

	// List of users
	static public List<User> users() {
		return employees;
	}

	// Load data from database
	public static void load() {
		employees = new ArrayList<>(loadInstances(User.class));
		idCounter = employees.size();
	}

	// Public interface for creating new users (saves to database)
	public static void create(String name, String email, String password) {
		User employee = new User(name, email, password);
		employees.add(employee);

		save(User.class, users());
	}

	private static int autoIncrements() {
		idCounter += 1;
		return idCounter;
	}

	@Override
	public String toString() {
		return "[ ID: " + getId() + " | Nome: " + getName() + " | Email: " + getEmail() + " ]";
	}
}