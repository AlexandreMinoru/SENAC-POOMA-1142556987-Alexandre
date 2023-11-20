package Model.General;

import java.util.Date;

public class Abastecimento {
	private int id;
	private DonoVeiculo responsavel;
	private Veiculo veiculo;
	private Posto posto;
	private Double preco;
	private String tipoCombustivel;
	private double quantidade, kmViajados, mediaKm;
	private Date data;
	
	public Abastecimento() {
		// TODO Auto-generated constructor stub
	}
	
	

	



	public double getMediaKm() {
		return mediaKm;
	}







	public void setMediaKm(double mediaKm) {
		this.mediaKm = mediaKm;
	}







	public Abastecimento(int id, DonoVeiculo responsavel, Veiculo veiculo, Posto posto, Double preco,
			String tipoCombustivel, double quantidade, double kmViajados, double mediaKm, Date data) {
		super();
		this.id = id;
		this.responsavel = responsavel;
		this.veiculo = veiculo;
		this.posto = posto;
		this.preco = preco;
		this.tipoCombustivel = tipoCombustivel;
		this.quantidade = quantidade;
		this.kmViajados = kmViajados;
		this.mediaKm = mediaKm;
		this.data = data;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DonoVeiculo getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(DonoVeiculo responsavel) {
		this.responsavel = responsavel;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getKmViajados() {
		return kmViajados;
	}

	public void setKmViajados(double kmViajados) {
		this.kmViajados = kmViajados;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	



	
	
}
