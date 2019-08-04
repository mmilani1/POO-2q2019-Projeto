package Models;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class User extends Model {
	static private List<User> users = new ArrayList<User>();
	static int idCounter = 0;

	private final String id;
	private String name;
	private String username;
	private String password;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	
	// Constructors
	public String getPassword() {
		return password;
	}
	
	private User() {
		id = autoIncrements();
	}
	
	private User(String name, String username, String password) {
		id = autoIncrements();
		this.name= name;
		this.username = username;
		this.password= password;
	}

	// List of users
	static public List<User> users() {
		return users;
	}

	// Load data from database
	public static void load() {
		users = new ArrayList<>(loadInstances(User.class));
		idCounter = users.size();
	}

	// Public interface for creating new users (saves to database)
	public static void create(String name, String username, String password) {
		User employee = new User(name, username, password);
		users.add(employee);

		save(User.class, users());
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