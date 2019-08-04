package Models;

import java.util.ArrayList;
import java.util.List;

import orm.Model;

public class Vehicle extends Model {
	static private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	static int idCounter = 0;

	private final String id;
	private String model;
	private String manufacturer;
	private String category;
	private String status = "available";
	private double dailyFee;

	public String getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public String getStatus() {
		return status;
	}

	public double getDailyFee() {
		return this.dailyFee;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Constructors
	private Vehicle() {
		id = autoIncrements();
	}

	private Vehicle(String model, String manufacturer, String category, double dailyFee) {
		id = autoIncrements();
		this.model = model;
		this.manufacturer = manufacturer;
		this.category = category;
		this.dailyFee = dailyFee;
	}

	// List of Employees
	static public List<Vehicle> vehicles() {
		return vehicles;
	}

	// Load data from database
	public static void load() {
		vehicles = new ArrayList<>(loadInstances(Vehicle.class));
		idCounter = vehicles.size();
	}

	// Public interface for creating new Employees (saves to database)
	public static void create(String model, String manufacturer, String category, double dailyFee) {
		Vehicle vehicle = new Vehicle(model, manufacturer, category, dailyFee);
		vehicles.add(vehicle);

		save(Vehicle.class, vehicles());
	}

	public static void delete(Vehicle vehicle) {
		vehicles.remove(vehicle);
		save(Vehicle.class, vehicles());
	}

	public static void update() {
		save(Vehicle.class, vehicles());
	}

	private static String autoIncrements() {
		idCounter += 1;
		return String.valueOf(idCounter);
	}

	@Override
	public String toString() {
		return "[ ID: " + getId() + " | Modelo: " + getModel() + " | Fabricante: " + getManufacturer() + " | Estado: "
				+ getStatus() + " | Tarifa: " + getDailyFee() + "]";
	}
}
