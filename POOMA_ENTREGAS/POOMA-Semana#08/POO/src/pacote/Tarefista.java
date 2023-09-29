package pacote;

public class Tarefista extends Funcionario{
	private double valorTarefas;
	private int qtdTarefas;
	public Tarefista() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Tarefista(String nome, String dpto, String funcao, double valorTarefas, int qtdTarefas) {
		super(nome, dpto, funcao);
		this.valorTarefas = valorTarefas;
		this.qtdTarefas = qtdTarefas;
	}



	public int getQtdTarefas() {
		return qtdTarefas;
	}



	public void setQtdTarefas(int qtdTarefas) {
		this.qtdTarefas = qtdTarefas;
	}



	public double getValorTarefas() {
		return valorTarefas;
	}

	public void setValorTarefas(double valorTarefas) {
		this.valorTarefas = valorTarefas;
	}
	
	@Override
	public void  calcularSalario() {
		super.setSalario(qtdTarefas * valorTarefas);
		System.out.printf("Funcionario: %s \nTarefas realizadas: %s \nValor por tarefa: R$%.2f \nSalário final: R$%.2f", super.getNome(), this.qtdTarefas, this.valorTarefas, super.getSalario());
	}
	
}
