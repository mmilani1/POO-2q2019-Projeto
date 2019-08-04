package Application;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import Application.Views.Vehicle.*;
import Application.Views.Sessions.SessionsCreate;
import Models.Vehicle;

public class VehicleController {
	public static void index() {
		VehicleIndex.render(Vehicle.vehicles());
	}

	public static void create() {
		VehicleCreate.render();
	}

	public static void store(String name, String role, String email, double dailyFee) {
		try {
			Vehicle.create(name, role, email, dailyFee);
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
			Vehicle vehicle = Vehicle.vehicles().stream().filter(v -> v.getId() == (Integer.parseInt(option)))
					.collect(Collectors.toList()).get(0);
			Vehicle.delete(vehicle);
			System.out.println("Veículo removido com sucesso!");
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("Não foi possivel encontrar este veículo, tente novamente");
		}

		VehicleRoot.render();
	}

	public static void update() {
		Vehicle.update();

		System.out.println("Veiculo editado com sucesso!\n");

		VehicleRoot.render();
	}

	public static void search() {
		VehicleFilter.render();
	}

	public static void filter(String model, String manufacturer, String category, double dailyFee) {
		Stream<Vehicle> vehicles = Vehicle.vehicles().stream();
		
		if(!model.equals("X")) vehicles = vehicles.filter(v -> v.getModel().equals(model));
		if(!manufacturer.equals("X")) vehicles = vehicles.filter(v -> v.getManufacturer().equals(manufacturer));
		if(!category.equals("X")) vehicles = vehicles.filter(v -> v.getCategory().equals(category));
		if(Double.compare(dailyFee, 0.0) != 0) vehicles = vehicles.filter(v -> v.getDailyFee() <= dailyFee);


		VehicleIndex.render(vehicles.collect(Collectors.toList()));
	}
}
