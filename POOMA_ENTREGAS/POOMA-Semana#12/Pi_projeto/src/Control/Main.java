package Control;

import java.io.IOException;
import java.net.MalformedURLException;

import Model.DataBase.TabelaDonoVeiculo;
import View.Interface;

public class Main {
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
		BancoDados BancoDados = new BancoDados();
		try {
			
			System.out.println(BancoDados.listarPostos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
