package usuario;

public class Funcionario{
	
	public static int codigo = 246;
	String nome;
	String cpf;

	
	public Funcionario(String nome, String cpf, int codigo) {
		this.nome = nome;
		this.cpf =cpf;
	}
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean autentica(int codigo) {
		
		if(this.codigo==codigo) {
			return true;
		}
	
		return false;
	}



}
