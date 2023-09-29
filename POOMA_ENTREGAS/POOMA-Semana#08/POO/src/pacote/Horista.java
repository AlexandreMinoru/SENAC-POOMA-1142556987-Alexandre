package pacote;

public class Horista extends Funcionario {
	private int horasTrabalhadas;
	private double valorHora;
	public Horista() {
		super();
	}
	
	
	public Horista(String nome, String dpto, String funcao, int horasTrabalhadas, double valorHora) {
		super(nome, dpto, funcao);
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorHora = valorHora;
	}


	public double getValorHora() {
		return valorHora;
	}


	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}


	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public void  calcularSalario() {
		super.setSalario(horasTrabalhadas * valorHora); 
		System.out.printf("Funcionario: %s \nHoras Trabalhadas: %s \nValor por hora: R$%.2f \nSalário final: R$%.2f", super.getNome(), this.horasTrabalhadas, this.valorHora, super.getSalario());
	}
	
}
