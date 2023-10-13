package Monitoramentos;

import DadoOperacional.DadoOperacionais;
import Maquinas.Maquina;
import BancoDados.BancoDados;

public class Monitoramento {
	private Maquinas.Maquina[] maquinas;
	private BancoDados bancoDados;

	public Monitoramento(int CapacidadeBancoDados, int CapacidadeMaquina) {
		maquinas = new Maquina[CapacidadeMaquina];
		bancoDados = new BancoDados(CapacidadeBancoDados);
	}

	public void CadastrarMaquina(String tipo, String protocolo, DadoOperacionais[] DadoOperacional) {
		for (int i = 0; i < maquinas.length; i++) {
			if (maquinas[i] == null) {
				Maquina maquina = new Maquina();
				maquina.setTipo(tipo);
				maquina.setProtocolo(protocolo);
				maquina.setDadoOperacional(DadoOperacional);
				maquinas[i] = maquina;
				break;
			}
		}
	}

	public void ArmazenarDados() {
		for (int i = 0; i < maquinas.length; i++) {
			Maquina maquina = maquinas[i];
			if (maquina != null) {
				maquina.getDadoOperacional();
				bancoDados.setDadosArmazenados(null);

			}
		}
	}

	public void gerarAlerta() {
		System.out.println("Alerta!!!");
	}

	public void CriarRelatorio() {
		DadoOperacionais exibe = new DadoOperacionais();

		System.out.println("Tempo de Funcionamento: " + exibe.getTempoFuncionamento());
		System.out.println("\nVibração: " + exibe.getVibracao());
		System.out.println("\nTemperatura: " + exibe.getTemperatura());
		System.out.println("\nNivel de Fluídos: " + exibe.getNivelFluido());
		System.out.println("\nPressão: " + exibe.getPressao());
		System.out.println("\nCombustível Gasto: " + exibe.getCombustivelGasto());
		System.out.println("\nNivel de Ruído: " + exibe.getNivelRuido());
		System.out.println("\nVibração: " + exibe.getVibracao());
		System.out.println("\nStatus: " + exibe.isStatus());
	}

}
