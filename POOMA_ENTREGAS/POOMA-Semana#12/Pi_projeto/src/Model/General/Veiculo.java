package Model.General;

public class Veiculo {
	int id;
	String modelo, placa, cor;
	DonoVeiculo dono;
	
	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Veiculo(int id, String modelo, String placa, String cor, DonoVeiculo dono) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.dono = dono;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}



	@Override
	public String toString() {
		return " Veiculo " + modelo + "Id= " + id + " placa= " + placa + " cor= " + cor + " dono= " + dono.getNome()+"";
	}
	
	
	
	
}
