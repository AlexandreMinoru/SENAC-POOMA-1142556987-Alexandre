package DadoOperacional;


public class DadoOperacionais {
private int tempoFuncionamento;
private int vibracao;
private int temperatura;
private int nivelFluido;
private int pressao;
private int combustivelGasto;
private int nivelRuido;
private boolean status; 


public DadoOperacionais() {
	
}

public int getTempoFuncionamento() {
	return tempoFuncionamento;
}

public void setTempoFuncionamento(int tempoFuncionamento) {
	this.tempoFuncionamento = tempoFuncionamento;
}

public int getVibracao() {
	return vibracao;
}

public void setVibracao(int vibracao) {
	this.vibracao = vibracao;
}

public int getTemperatura() {
	return temperatura;
}

public void setTemperatura(int temperatura) {
	this.temperatura = temperatura;
}

public int getNivelFluido() {
	return nivelFluido;
}

public void setNivelFluido(int nivelFluido) {
	this.nivelFluido = nivelFluido;
}

public int getPressao() {
	return pressao;
}

public void setPressao(int pressao) {
	this.pressao = pressao;
}

public int getCombustivelGasto() {
	return combustivelGasto;
}

public void setCombustivelGasto(int combustivelGasto) {
	this.combustivelGasto = combustivelGasto;
}

public int getNivelRuido() {
	return nivelRuido;
}

public void setNivelRuido(int nivelRuido) {
	this.nivelRuido = nivelRuido;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

}

