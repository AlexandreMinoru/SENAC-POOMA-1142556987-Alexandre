package Model.DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.General.Abastecimento;
import Model.General.DonoVeiculo;
import Model.General.Posto;
import Model.General.Veiculo;

public class TabelaAbastecimento extends TabelaPosto{
	
	
	
	
	public Double calcularMediaKm(double kmAntigo, double kmAtual, double quantidadeAbastecida) {
		double kmAndado = kmAntigo - kmAtual;
		return kmAndado/ quantidadeAbastecida;
	}
	
	
	
	
	public Double buscarPrecoGasolina(int i) throws Exception {
		String queryCmd = "select * from tipogasolina where id like " + i;				
		try {
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				return rs.getDouble("valor");
				
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} 	
		return null;
	}
	
	
	public String buscarNomeGasolina(int i) throws Exception {
		String queryCmd = "select * from tipogasolina where id like " + i;				
		try {
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				return rs.getNString("nome");
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} 	
		return null;
	}
	
	
	public Double encontrarAbastecimentoAnteriorKm( int i) throws Exception {
		Double anterior = null;
		String queryCmd = "SELECT *"
				+ "FROM abastecimento"
				+ "WHERE veiculo like ?"
				+ "ORDER BY data DESC"
				+ "LIMIT 1";				
		try {

			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ps1.setInt(1, i);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				return rs.getDouble("kmViajados");
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();	
		}		
		return null;
	}
	
	
	
	public Double calcularQuantidade(Double valorTotal, Double valorGasolina) {
		return valorTotal / valorGasolina;
	}
	
	public Abastecimento buscarAbastecimento(int i) throws Exception {
		Abastecimento abastecimento = null;
		String queryCmd = "select * from abastecimento where "
				+ "id like " + i;				
		try {
			super.openDB();
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				abastecimento = new Abastecimento();
				abastecimento.setId(rs.getInt("id"));
				abastecimento.setResponsavel(super.pesquisarDonoVeiculo(rs.getInt("responsavel")));
				abastecimento.setVeiculo(pesquisarVeiculo(rs.getInt("veiculo")));
				abastecimento.setPosto(pesquisarPosto(rs.getInt("posto")));
				abastecimento.setTipoCombustivel(buscarNomeGasolina(rs.getInt("tipoGasolina")));
				abastecimento.setQuantidade(rs.getDouble("quantidade"));	
				abastecimento.setPreco(rs.getDouble("valor"));
				abastecimento.setKmViajados(rs.getDouble("kmViajados"));
				abastecimento.setMediaKm(rs.getDouble("mediaKM"));
				abastecimento.setData(rs.getDate("data"));
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} 
		return abastecimento;
	}
	
	public ArrayList<Abastecimento> listarAbastecimentos() throws Exception {
		ArrayList<Abastecimento> listaAbastecimentos = new ArrayList<Abastecimento>();
		String queryCmd = "select * from abastecimento";		
		try {
			super.openDB();
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				Abastecimento abastecimento = null;
				abastecimento = new Abastecimento();
				abastecimento.setId(rs.getInt("id"));
				abastecimento.setResponsavel(super.pesquisarDonoVeiculo(rs.getInt("responsavel")));
				abastecimento.setVeiculo(pesquisarVeiculo(rs.getInt("veiculo")));
				abastecimento.setPosto(pesquisarPosto(rs.getInt("posto")));
				abastecimento.setTipoCombustivel(buscarNomeGasolina(rs.getInt("tipoGasolina")));
				abastecimento.setQuantidade(rs.getDouble("quantidade"));	
				abastecimento.setPreco(rs.getDouble("valor"));
				abastecimento.setKmViajados(rs.getDouble("kmViajados"));
				abastecimento.setMediaKm(rs.getDouble("mediaKM"));
				abastecimento.setData(rs.getDate("data"));
				listaAbastecimentos.add(abastecimento);
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} 
		return listaAbastecimentos;
	}
	
	
	
	public void adicionarAbastecimento(int id, DonoVeiculo responsavel, Veiculo veiculo, Posto posto, int tipoCombustivel, double quantidadeViajada, double valor) throws Exception {
		try {
			super.openDB();
			Connection cn = super.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO veiculo (responsavel, veiculo,  posto, valor,quantidade, tipoGasolina,kmViajados, mediaKM)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");     
			double valorGasolina = this.buscarPrecoGasolina(tipoCombustivel);
			double kmAnterior = this.encontrarAbastecimentoAnteriorKm(veiculo.getId());
			ps.setInt(1,responsavel.getId());
			ps.setInt(2, veiculo.getId());
			ps.setInt(3,posto.getId());
			ps.setDouble(4, valor);
			ps.setDouble(5, this.calcularQuantidade(valor, valorGasolina));
			ps.setInt(6, tipoCombustivel);
			ps.setDouble(7, quantidadeViajada);
			ps.setDouble(8, calcularMediaKm(kmAnterior, quantidadeViajada, valorGasolina));
			ps.executeUpdate();
			ps.close();   
			
          
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();
		}    
	}
}




