package Control;

import java.util.List;

import Model.General.Abastecimento;
import Model.General.Posto;
import Model.General.Veiculo;

public class SistemaAbastecimento {
	List<Veiculo> veiculos;
	List<Posto>postos;
	List<Abastecimento>abastecimentos;
	
	public SistemaAbastecimento() {
		// TODO Auto-generated constructor stub
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Posto> getPostos() {
		return postos;
	}

	public void setPostos(List<Posto> postos) {
		this.postos = postos;
	}

	public List<Abastecimento> getAbastecimentos() {
		return abastecimentos;
	}

	public void setAbastecimentos(List<Abastecimento> abastecimentos) {
		this.abastecimentos = abastecimentos;
	}
	
	
}
