import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import Application.Application;
import user.Cliente;
import user.Funcionario;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Carregando dados");
		Initializer.loadData();
		
		System.out.println("Inicializando programa");
		Application.start();
	}
}