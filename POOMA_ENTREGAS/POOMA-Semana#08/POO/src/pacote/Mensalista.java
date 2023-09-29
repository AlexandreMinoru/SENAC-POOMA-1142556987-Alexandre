package pacote;

public class Mensalista extends Funcionario {
	private double valorMes;
	
	public Mensalista() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public Mensalista(String nome, String dpto, String funcao, double valorMes) {
		super(nome, dpto, funcao);
		this.valorMes = valorMes;
	}





	public double getValorMes() {
		return valorMes;
	}

	public void setValorMes(double valorMes) {
		this.valorMes = valorMes;
	}
	@Override
	public void  calcularSalario() {
		super.setSalario(valorMes);
		System.out.printf("Funcionario: %s\nSalário final: R$%.2f", super.getNome(), super.getSalario());
	}
}
