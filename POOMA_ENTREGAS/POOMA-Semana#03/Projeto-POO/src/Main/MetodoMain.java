package Main;

import Monitoramentos.Monitoramento;
import DadoOperacional.DadoOperacionais;
import Maquinas.Maquina;


public class MetodoMain {
public static void main(String []args) {
	
	Monitoramento monitoramento = new Monitoramento(50, 100);
	DadoOperacionais dado1 = new DadoOperacionais();
	
	
	
	
	dado1.setTemperatura(150);
	dado1.setTempoFuncionamento(5);
	dado1.setStatus(true);
	
	
	
	Maquina maquina1 = new Maquina();
	
	maquina1.setTipo("Tipo2");
	maquina1.setProtocolo("1 - protocolo");
	maquina1.getDadoOperacional();
	
	
	
	
	monitoramento.CadastrarMaquina("tipo 1","3-Protocolo", maquina1.getDadoOperacional());
	monitoramento.ArmazenarDados();
	
	
	monitoramento.CriarRelatorio();
	monitoramento.gerarAlerta();
}


}
