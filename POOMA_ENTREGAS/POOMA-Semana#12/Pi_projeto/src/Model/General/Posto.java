package Model.General;

import java.util.List;

public class Posto {
	private int id;
	private String marca, localizacao;

	
	public Posto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String nome) {
		this.marca = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Posto [id=" + id + ", marca=" + marca + ", localizacao=" + localizacao + "]";
	}

	
	
}
