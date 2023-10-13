package BancoDados;

import DadoOperacional.DadoOperacionais;

public class BancoDados extends DadoOperacionais {
	private DadoOperacionais[] dadosArmazenados;
	private int tamanho;

	public BancoDados() {
		super();
	}

	public BancoDados(int capacidade) {
		super();
		dadosArmazenados = new DadoOperacionais[capacidade];
	}

	public DadoOperacionais[] getDadosArmazenados() {
		return dadosArmazenados;
	}

	public void setDadosArmazenados(DadoOperacionais dadoOperacional) {
		if (tamanho < dadosArmazenados.length) {
			dadosArmazenados[tamanho] = dadoOperacional;
			tamanho++;
		} else {
			System.out.println("Banco de dados Cheio...");
		}
	}

}
