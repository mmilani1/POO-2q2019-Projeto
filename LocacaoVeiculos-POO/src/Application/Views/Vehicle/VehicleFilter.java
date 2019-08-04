package Application.Views.Vehicle;

import Application.VehicleController;
import Application.Views.BaseView;

public class VehicleFilter extends BaseView {
	public static void render() {
		System.out.println("\nBusca de veículos por atributos");
		System.out.println("Caso não queira utilizar um parametro da busca, preencha 'X'");

		System.out.println("\nDigite o modelo que deseja:");
		String model = read();
		
		System.out.println("\nDigite a fabricante que deseja:");
		String manufacturer = read();
		
		System.out.println("\nDigite a categoria que deseja:");
		String category = read();
		
		System.out.println("\nDigite a tarifa diária máxima que deseja:");
		System.out.println("Obs: valores não numéricos serão ignorados");
		double dailyFee = 0;
		try {
			dailyFee = Double.parseDouble(read());			
		} catch (Exception e) {}
		
		VehicleController.filter(model, manufacturer, category, dailyFee);
	}
}
