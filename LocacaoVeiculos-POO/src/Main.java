import Application.ApplicationController;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Carregando dados");
		Initializer.loadData();
		
		System.out.println("Inicializando programa");
		ApplicationController.start();
	}
}