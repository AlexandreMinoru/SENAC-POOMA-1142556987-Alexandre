package BancoDados;

import DadoOperacional.DadoOperacionais;


	public class BancoDados {
		 private DadoOperacionais[] dadosArmazenados;
		 private int tamanho;

		 public BancoDados (int capacidade) {
			dadosArmazenados = new DadoOperacionais[capacidade];
		}

		public DadoOperacionais[] getDadosArmazenados() {
			return dadosArmazenados;
		}
		public void setDadosArmazenados(DadoOperacionais dadoOperacional) {
			if(tamanho < dadosArmazenados.length) {
				dadosArmazenados[tamanho] = dadoOperacional;
				tamanho++;
			}else {
				System.out.println("Banco de dados Cheio...");
			}
		}

		}

