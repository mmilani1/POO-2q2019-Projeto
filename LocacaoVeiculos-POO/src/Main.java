import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import employee.Employee;
import employee.Funcionario;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		Initializer.loadData();
		
		System.out.println(Employee.employees());
		Employee.create("Matheus");
		System.out.println(Employee.employees());
		Employee.create("Jose");
	}
}