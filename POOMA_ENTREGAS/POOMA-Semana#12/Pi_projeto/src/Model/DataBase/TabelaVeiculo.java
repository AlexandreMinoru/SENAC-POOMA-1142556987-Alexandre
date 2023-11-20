package Model.DataBase;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import Control.BancoDados;
import Model.General.DonoVeiculo;
import Model.General.Veiculo;

public class TabelaVeiculo extends ConectarBanco {

	public TabelaVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public void adicionarVeiculo() { 
		try {
			super.openDB();
			Connection cn = super.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO veiculo (placa, cor, modelo, dono)"
							+ "VALUES (?, ?, ?, ?)");            
			ps.setString(3, JOptionPane.showInputDialog("Modelo:"));
			ps.setString(1, 
					JOptionPane.showInputDialog("Placa:"));
			ps.setString(2, JOptionPane.showInputDialog("Cor:"));
			ps.setInt(4, Integer.parseInt(JOptionPane.showInputDialog("Dono: ")));
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
			ps.close();   
			
			System.out.println("ConexÃ£o encerrada.");            
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();
		}    
	}
	
	public void editarVeiculo() {
		
	}
	
	public Veiculo pesquisarVeiculo(int i) throws java.lang.Exception {
		Veiculo veiculo = null;
		BancoDados banco = new BancoDados();
		String queryCmd = "select * from veiculo where "
				+ "id like " + i;				
		try {
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {				
				int id = rs.getInt("id");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				String modelo = rs.getString("modelo");	
				DonoVeiculo dono = null;
				try {
					dono = banco.pesquisarDonoVeiculo(rs.getInt("dono"));
					veiculo = new Veiculo(id,modelo,placa,cor,dono);
				} catch (java.lang.Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();
		}		
		return veiculo;
	}
	
	
	
	public ArrayList<Veiculo> listaVeiculos(int i ) throws Exception{
		BancoDados banco = new BancoDados();
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		String queryCmd = "select * from veiculo where "
				+ "dono like " + i;				
		try {
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				
				int id = rs.getInt("id");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				String modelo = rs.getString("modelo");	
				DonoVeiculo dono = null;
				try {
					dono = banco.pesquisarDonoVeiculoNoConnection(rs.getInt("dono"));
					listaVeiculos.add(new Veiculo(id,modelo,placa,cor,dono));
				} catch (java.lang.Exception e) {
					e.printStackTrace();
				}	
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		}	
		return listaVeiculos;
	}
	
}
