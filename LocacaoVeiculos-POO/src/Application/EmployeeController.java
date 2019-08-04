package Application;

import java.util.stream.Collectors;

import Application.Views.Employee.*;
import Application.Views.Sessions.SessionsCreate;
import Models.Employee;

public class EmployeeController {
	public static void index() {
		EmployeeIndex.render(Employee.employees());
	}
	
	public static void create() {
		EmployeeCreate.render();
	}

	public static void store(String name, String role, String email, String password) {
		try {
			Employee.create(name, role, email, password);
			System.out.println("Funcionario criado com sucesso!");
			EmployeeRoot.render();
		} catch (Exception e) {
			System.out.println("Um erro ocorreu no seu cadastro, por favor tente novamente");
			SessionsCreate.render();
		}
	}

	public static void remove() {
		EmployeeRemove.render(Employee.employees());
	}
	
	public static void remove(String option) {
		if (option.equals("X"))
			EmployeeRoot.render();

		try {
			Employee employee = Employee.employees()
				.stream()
				.filter(e -> e.getId() == (Integer.parseInt(option)))
				.collect(Collectors.toList()).get(0);
			Employee.delete(employee);
			System.out.println("Funcionaario removido com sucesso!");
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("Não foi possivel encontrar este funcionário, tente novamente");
		}
		
		EmployeeRoot.render();
	}

	public static void edit() {
		EmployeeEdit.render(Employee.employees());
	}
	
	public static void edit(String option) {
		if (option.equals("X"))
			EmployeeRoot.render();
		
		Employee fetchedEmployee = null;

		try {
			fetchedEmployee = Employee.employees()
				.stream()
				.filter(employee -> employee.getId() == (Integer.parseInt(option)))
				.collect(Collectors.toList()).get(0);
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("Não foi possivel encontrar este funcionário, tente novamente");
			EmployeeRoot.render();
		}
		
		EmployeeUpdate.render(fetchedEmployee);
	}

	public static void update() {
		Employee.update();
		
		System.out.println("Funcionario editado com sucesso!\n");
		
		EmployeeRoot.render();
	}
}
