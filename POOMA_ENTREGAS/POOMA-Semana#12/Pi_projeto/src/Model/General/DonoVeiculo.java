package Model.General;

import java.util.ArrayList;
import java.util.List;

public class DonoVeiculo {
	int id, idade;
	String nome, cpf, telefone, setor;
	ArrayList<Veiculo> veiculos = new  ArrayList<Veiculo>();
	
	public DonoVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DonoVeiculo(int id, String nome, String cpf, String telefone, int idade, String setor, Veiculo veiculos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
		this.setor = setor;
		this.veiculos.add(veiculos);
	}
	
	public DonoVeiculo(int id, String nome, String cpf, String telefone, int idade, String setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
		this.setor = setor;
	}

	
	
	public void adicionarVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
	
	public String getTelefone() {
		return telefone;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public int getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}



	public String getSetor() {
		return setor;
	}



	public void setSetor(String setor) {
		this.setor = setor;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}



	@Override
	public String toString() {
		return "DonoVeiculo [id=" + id + ", idade=" + idade + ", nome=" + nome + ", cpf=" + cpf + ", telefone="
				+ telefone + ", setor=" + setor + ", veiculos=" + veiculos + "]";
	}

	
}
