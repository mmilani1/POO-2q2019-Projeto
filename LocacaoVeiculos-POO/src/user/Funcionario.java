package user;

import java.util.ArrayList;
import java.util.List;
import orm.Model;

public class Funcionario extends Model {
	static private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	static public List<Funcionario> funcionarios() {
		return funcionarios;
	}

	public Funcionario() {	}
	public Funcionario(String name) {
		setName(name);
	}
	
	public static void load() {
		funcionarios = loadInstances(Funcionario.class);
	}

	@Override
	public String toString() {
		return "Funcionario: " + getName();
	}
}