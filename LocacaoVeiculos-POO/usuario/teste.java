package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teste {


	public static void main(String[] args) {
		
		List<Funcionario> funcionario = new ArrayList<>(); 
		List<Cliente> cliente = new ArrayList<>(); 
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome: ");
		String name = sc.next();
		System.out.println("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.println("Voc� � um cliente ou Funcionario?");
		String op = sc.next();
		
		if(op.equalsIgnoreCase("Cliente")) {
			
			Cliente abc = new Cliente(name, cpf);
			cliente.add(abc);
			
		}
		
		else if (op== "Funcionario") {
			System.out.println("Digite seu c�digo: ");
			int cod = sc.nextInt();
			
			Funcionario abc = new Funcionario(name, cpf, cod);
			if(abc.autentica(cod)==false) {
				System.out.println("Voc� n�o pode ser funcionario");
			}
			else
				funcionario.add(abc);
			
		}
		
		
		
				

	}

}
