package Model.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.General.DonoVeiculo;
import Model.General.Veiculo;

public class TabelaDonoVeiculo  extends TabelaVeiculo{
	
	public void adicionarDonoVeiculo() { 
		try {
			super.openDB();
			Connection cn = super.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO DonoVeiculo (nome, idade, telefone, cpf, fk_setor)"
							+ "VALUES (?, ?, ?, ?, ?)");            
			ps.setString(1, JOptionPane.showInputDialog("Nome:"));
			ps.setInt(2, Integer.parseInt(JOptionPane.showInputDialog("idade:")));
			ps.setString(3, JOptionPane.showInputDialog("Telefone:"));
			ps.setString(4, JOptionPane.showInputDialog("cpf: "));
			ps.setInt(5, Integer.parseInt(JOptionPane.showInputDialog("setor: ")));
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
			ps.close();   
			cn.close();
			
			System.out.println("ConexÃ£o encerrada.");            
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();
		}    
	}
	
	
	public DonoVeiculo pesquisarDonoVeiculo(int i) throws Exception {
		DonoVeiculo dono = null;
		String queryCmd = "select * from DonoVeiculo where "
				+ "id like " + i;				
		try {
			super.openDB();
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				dono = new DonoVeiculo();
				dono.setId(rs.getInt("id"));
				dono.setNome(rs.getString("nome"));
				dono.setCpf(rs.getString("cpf"));
				dono.setTelefone(rs.getString("telefone"));
				dono.setIdade(rs.getInt("idade"));
				dono.setSetor(this.pesquisarSetor(rs.getInt("fk_setor")));	
				dono.setVeiculos(super.listaVeiculos(dono.getId()));
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();	
		}		
		return dono;
	}
	
	public String pesquisarSetor(int i) throws Exception {
		String queryCmd = "select * from setor where "
				+ "id like " + i;				
		try {
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {				
				return rs.getString("nome");
							
			}
			
		} catch (SQLException e) {
			throw new Exception(e);
		}
		return null;
	}
	
	public DonoVeiculo pesquisarDonoVeiculoNoConnection(int i) throws Exception {
		DonoVeiculo dono = null;
		String queryCmd = "select * from DonoVeiculo where "
				+ "id like " + i;				
		try {

			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				dono = new DonoVeiculo();
				dono.setId(rs.getInt("id"));
				dono.setNome(rs.getString("nome"));
				dono.setCpf(rs.getString("cpf"));
				dono.setTelefone(rs.getString("telefone"));
				dono.setIdade(rs.getInt("idade"));
				dono.setSetor(this.pesquisarSetor(rs.getInt("fk_setor")));	
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();	
		}		
		return dono;
	}
	
}

