package Maquinas;

public class Maquina {
	private String tipo;
	private String protocolo;
	private DadoOperacional.DadoOperacionais[] DadoOperacional;

	public Maquina() {

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public DadoOperacional.DadoOperacionais[] getDadoOperacional() {
		return DadoOperacional;
	}

	public void setDadoOperacional(DadoOperacional.DadoOperacionais[] dadoOperacional) {
		DadoOperacional = dadoOperacional;
	}

}
