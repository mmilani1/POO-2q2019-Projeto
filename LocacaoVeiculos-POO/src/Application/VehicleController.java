package Application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Application.Views.Vehicle.*;
import Application.Views.Sessions.SessionsCreate;
import Models.Rent;
import Models.User;
import Models.Vehicle;

public class VehicleController {
	public static void start() {
		VehicleRoot.render();
	}

	public static void index() {
		VehicleIndex.render(Vehicle.vehicles());
	}

	public static void create() {
		VehicleCreate.render();
	}

	public static void store(String name, String role, String username, double dailyFee) {
		try {
			Vehicle.create(name, role, username, dailyFee);
			System.out.println("Veiculo criado com sucesso!");
			VehicleRoot.render();
		} catch (Exception e) {
			System.out.println("Um erro ocorreu no cadastro do veiculo, por favor tente novamente");
			SessionsCreate.render();
		}
	}

	public static void remove() {
		VehicleRemove.render(Vehicle.vehicles());
	}

	public static void remove(String option) {
		if (option.equals("X"))
			VehicleRoot.render();

		try {
			Vehicle vehicle = Vehicle.vehicles().stream().filter(v -> v.getId().equals(option))
					.collect(Collectors.toList()).get(0);
			Vehicle.delete(vehicle);
			System.out.println("Ve�culo removido com sucesso!");
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("N�o foi poss�vel encontrar este ve�culo, tente novamente");
		}

		VehicleRoot.render();
	}

	public static void update() {
		Vehicle.update();

		System.out.println("Ve�culo editado com sucesso!\n");

		VehicleRoot.render();
	}

	public static void search() {
		VehicleFilter.render();
	}

	public static void filter(String model, String manufacturer, String category, double dailyFee) {
		Stream<Vehicle> vehicles = Vehicle.vehicles().stream();

		if (!model.equals("X"))
			vehicles = vehicles.filter(v -> v.getModel().equals(model));
		if (!manufacturer.equals("X"))
			vehicles = vehicles.filter(v -> v.getManufacturer().equals(manufacturer));
		if (!category.equals("X"))
			vehicles = vehicles.filter(v -> v.getCategory().equals(category));
		if (Double.compare(dailyFee, 0.0) != 0)
			vehicles = vehicles.filter(v -> v.getDailyFee() <= dailyFee);

		VehicleIndex.render(vehicles.collect(Collectors.toList()));
	}

	public static void show(String id) {
		try {
			Vehicle vehicle = Vehicle.vehicles().stream().filter(v -> v.getId().equals(id))
					.collect(Collectors.toList()).get(0);
			VehicleShow.render(vehicle);
		} catch (Exception e) {
			System.out.println("N�o foi possivel encontrar este ve�culo");
			VehicleRoot.render();
		}
	}

	public static void rentIndex() {
		List<Vehicle> vehiclesToRent = Vehicle.vehicles().stream()
				.filter(v -> v.getStatus().equals("available"))
				.collect(Collectors.toList());
		
		VehicleIndex.render(vehiclesToRent);
	}
	
	public static void rent(User authUser, String vehicleId, String days) {
		Vehicle vehicle;
		double totalToBePaid;
		
		try {
			vehicle = Vehicle.vehicles().stream()
					.filter(v -> v.getStatus().equals("available"))
					.filter(v -> v.getId().equals(vehicleId))
					.collect(Collectors.toList()).get(0);
			totalToBePaid = vehicle.getDailyFee() * Integer.parseInt(days);
			
			vehicle.setStatus("rented");
			Rent.create(authUser.getId(),  vehicle.getId(), days, totalToBePaid);
		} catch (Exception e) {
			System.out.println("\nN�o foi possivel alugar este carro momento.");
		}
		
		System.out.println("\nVe�culo alugado com sucesso!.");
		
		UserController.start();
	}
}
