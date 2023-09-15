package pacote;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Produto implements Cloneable{
	private int id;
	private int classificacao;
	private String nomeProduto;
	private double precoProduto;
	
	public Produto()  {
		ArrayList<Object> lista = new ArrayList<>();
		Produto padrao = new Produto(1, 2, "teste", 11);
		
		
		
		
		int decisao = 0;
		
		do {
			decisao = Integer.parseInt(JOptionPane.showInputDialog("Você deseja: \n"
					+ "[1] Cadastrar um novo produto \n"
					+ "[2] Visualizar um produto \n"
					+ "[3] Remover um produto \n"
					+ "[4] Alterar um produto \n"
					+ "[5] Ver toda a lista \n"
					+ "[0] Encerrar o programa"));
			
			switch(decisao) {
			case 1:
				Produto novo;
				try {
					novo = (Produto) padrao.clone();
					novo.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID")));
					novo.setClassificacao(Integer.parseInt(JOptionPane.showInputDialog("Informe a classificação")));
					novo.setNomeProduto(JOptionPane.showInputDialog("Informe o nome"));
					novo.setPrecoProduto(Double.parseDouble(JOptionPane.showInputDialog("Informe o preço")));
					lista.add(novo);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				break;
			case 2:
				int pegar = Integer.parseInt(JOptionPane.showInputDialog("Informe o indice do produto"))-1 ;
				if(pegar > lista.size()) {
					System.out.println("Valor inválido");
					System.out.println();
				}else {
					System.out.println("Produto no indice: " + (pegar + 1) + "\n");
					System.out.println(lista.get(pegar));
					System.out.println();
				}
				break;
			case 3:
				int remover = Integer.parseInt(JOptionPane.showInputDialog("Informe o indice do produto"))- 1;
				if(remover > lista.size()) {
					System.out.println("Valor inválido");
					System.out.println();
				}else {
				lista.remove(remover);
				System.out.println();
				System.out.println("Produto removido \n" );
				}
				break;
			case 4:
				int i = Integer.parseInt(JOptionPane.showInputDialog("Informe o indice do item a ser alterado")) -1;
				if(i > lista.size()) {
					System.out.println("Valor inválido");
					System.out.println();
				}else {
				Produto alterar;
				try {
					alterar = (Produto) padrao.clone();
					alterar.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID")));
					alterar.setClassificacao(Integer.parseInt(JOptionPane.showInputDialog("Informe a classificação")));
					alterar.setNomeProduto(JOptionPane.showInputDialog("Informe o nome"));
					alterar.setPrecoProduto(Double.parseDouble(JOptionPane.showInputDialog("Informe o preço")));
					lista.set(i, alterar);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				break;
			case 5:
				
				System.out.println("Lista: \n");
				for (int j = 0; j < lista.size(); j++) {
					System.out.println(lista.get(j));
				}
				
				break;
			case 0:
				System.out.println("Fim do programa");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}while(decisao != 0);
		
		
	
	}
	
	
	
	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getClassificacao() {
		return classificacao;
	}





	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}





	public String getNomeProduto() {
		return nomeProduto;
	}





	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}





	public double getPrecoProduto() {
		return precoProduto;
	}





	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}



@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}

	public Produto(int id, int classificacao, String nomeProduto, double precoProduto) {
		super();
		this.id = id;
		this.classificacao = classificacao;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
	}

	@Override
	public String toString() {
		return "Produto " +"\nNome do produto= " + nomeProduto + "\nID= " + id + "\nClassificacao= " + classificacao
				+ "\nPreço do produto= R$" + precoProduto+ "\n" + "\n";
	}
	
	
	
}
