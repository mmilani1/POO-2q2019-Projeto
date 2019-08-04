package Application.Views.Vehicle;

import Application.VehicleController;
import Application.Views.BaseView;

public class VehicleCreate extends BaseView {
	public static void render() {
		System.out.println("\nVocê agora irá cadastrar um novo veiculo");

		System.out.println();

		System.out.println("Digite o modelo:");
		String model = read();

		System.out.println("Digite a fabricante:");
		String manufacturer = read();

		String category = getVehicleCategory();

		System.out.println("Digite a tarifa diaria:");
		double dailyFee = 0.0;
		while(Double.compare(dailyFee, 0.0) == 0){
			try {
				dailyFee = Double.parseDouble(read());
			} catch (Exception e) {
				dailyFee = 0;
			}
		}

		VehicleController.store(model, manufacturer, category, dailyFee);
	}

	private static String getVehicleCategory() {
		System.out.println("1 - Hatch");
		System.out.println("2 - Sedan");
		System.out.println("3 - Esportivo");
		System.out.println("4 - SUV");

		String type = read();

		while (true) {
			switch (type) {
			case "1":
				return "Hatch";
			case "2":
				return "Sedan";
			case "3":
				return "Esportivo";
			case "4":
				return "SUV";
			default:
				System.out.println("Vocï¿½ deve escolher uma opï¿½ï¿½o vï¿½lida");
				type = read();
				break;
			}
		}
	}

}
