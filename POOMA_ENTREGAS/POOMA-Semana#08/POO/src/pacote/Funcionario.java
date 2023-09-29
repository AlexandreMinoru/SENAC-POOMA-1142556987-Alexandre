package pacote;

import javax.swing.JOptionPane;

public class Funcionario {
	private String nome, dpto, funcao;
	private double salario;
	
	public Funcionario() {
		String nome = JOptionPane.showInputDialog("Informe o nome do funcionário");
		String dpto = JOptionPane.showInputDialog("Informe o departamento do funcionário");
		String funcao = JOptionPane.showInputDialog("Informe a função do funcionário");
		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo do funcionário: \n[1]Tarefeiro \n[2]Horista \n[3]Mensaleiro"));
		
		switch(tipo) {
		case 1:
			int qtdTarefas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de tarefas"));
			double valorTarefa = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor por tarefas"));
			Tarefista tarefista = new Tarefista( nome,dpto,  funcao,  valorTarefa, qtdTarefas);
			tarefista.calcularSalario();
			break;
		case 2:
			int qtdHoras = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de horas"));
			double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor por horas"));
			Horista horista = new Horista( nome,dpto,  funcao,  qtdHoras, valorHora);
			horista.calcularSalario();
			break;
		case 3:
			double valorMensal = Double.parseDouble("Informe seu salário mensal");
			Mensalista mensalista = new Mensalista(nome, dpto,  funcao, valorMensal);
			mensalista.calcularSalario();
			break;
		default:
			System.out.println("Valor inválido");
			break;
		}
	}
	
	
	
	public Funcionario(String nome, String dpto, String funcao) {
		super();
		this.nome = nome;
		this.dpto = dpto;
		this.funcao = funcao;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	public void calcularSalario() {
	
	}
}
