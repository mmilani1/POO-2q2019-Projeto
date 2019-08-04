package Application;

import java.util.List;
import java.util.stream.Collectors;

import Application.Views.Rent.RentIndex;
import Application.Views.Rent.RentShow;
import Models.Rent;
import Models.User;
import Models.Vehicle;

public class RentController {
	public static void index() {
		RentIndex.render(Rent.rents());
	}
	
	public static void index(User user) {
		List<Rent> rents = Rent.rents().stream().filter(r -> r.getUserId().equals(user.getId())).collect(Collectors.toList());
		
		RentIndex.render(rents);

	}
	
	public static void show(String rentId) {
		User authUser = SessionController.authenticatedUser;
		try {
			Rent rent = Rent.rents()
					.stream()
					.filter(r -> r.getId().equals(rentId))
					.collect(Collectors.toList()).get(0);
			
			User user = User.users()
					.stream()
					.filter(u -> u.getId().equals(rent.getUserId()))
					.collect(Collectors.toList()).get(0);
			
			Vehicle vehicle = Vehicle.vehicles()
					.stream()
					.filter(v -> v.getId().equals(rent.getVehicleId()))
					.collect(Collectors.toList()).get(0);
			
			RentShow.render(rent, user, vehicle);
		} catch (Exception e) {
			System.out.println("\nNão foi possivel visualizar esta locação");
		}
		
		if(authUser != null) UserController.start();
		EmployeeController.start();
	}

	public static void store(String userId, String vehicleId, String days, double totalToBePaid) {
		try {
			Rent.create(userId, vehicleId, days, totalToBePaid);

			System.out.println("\nVeículo alugado com sucesso!.");

			UserController.start();
		} catch (Exception e) {
			System.out.println("\nNão foi possivel alugar este carro momento.");

			UserController.start();
		}
	}

}