package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import orm.Model;

public class Rent extends Model {
	static private List<Rent> rents = new ArrayList<Rent>();
	static int idCounter = 0;

	private final String id;
	private String userId;
	private String vehicleId;
	private String days;
	private double totalPaid;

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getDays() {
		return days;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	// Constructors
	private Rent() {
		id = autoIncrements();
	}

	private Rent(String userId, String vehicleId, String days, double totalPaid) {
		id = autoIncrements();
		this.userId = userId;
		this.vehicleId = vehicleId;
		this.days = days;
		this.totalPaid = totalPaid;
	}

	// List of Employees
	static public List<Rent> rents() {
		return rents;
	}

	public User user() {
		User user = User.users().stream().filter(u -> u.getId().equals(this.userId)).collect(Collectors.toList())
				.get(0);

		return user;
	}

	public Vehicle vehicle() {
		Vehicle vehicle = Vehicle.vehicles().stream().filter(v -> v.getId().equals(this.vehicleId))
				.collect(Collectors.toList()).get(0);

		return vehicle;
	}

	// Load data from database
	public static void load() {
		rents = new ArrayList<>(loadInstances(Rent.class));
		idCounter = rents.size();
	}

	// Public interface for creating new Employees (saves to database)
	public static void create(String userId, String vehicleId, String days, double totalPaid) {
		Rent rent = new Rent(userId, vehicleId, days, totalPaid);
		rents.add(rent);

		save(Rent.class, rents());
	}

	public static void delete(Rent rent) {
		rents.remove(rent);
		save(Rent.class, rents());
	}

	public static void update() {
		save(Rent.class, rents());
	}

	private static String autoIncrements() {
		idCounter += 1;
		return String.valueOf(idCounter);
	}

	@Override
	public String toString() {
		return "[ ID: " + getId() + " | Clinete: " + this.user().getName() + " | Veiculo: " + this.vehicle().getModel()
				+ " | Duração: " + getDays() + " dias | Tarifa Final: " + getTotalPaid() + "]";
	}
}
