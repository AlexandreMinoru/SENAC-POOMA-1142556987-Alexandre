package Model.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.General.DonoVeiculo;
import Model.General.Posto;

public class TabelaPosto extends TabelaDonoVeiculo {
	
	
	public void adicionarPosto() {
		try {
			super.openDB();
			Connection cn = super.getCon();
			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO posto (endereco, marca)"
							+ "VALUES (?, ?)");            
			ps.setString(1, JOptionPane.showInputDialog("Endereço:"));
			ps.setString(2, 
					JOptionPane.showInputDialog("Marca:"));
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
			ps.close();   
			
			System.out.println("ConexÃ£o encerrada.");            
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();
		}    
	}
	
	public Posto pesquisarPosto(int i) throws Exception {
		Posto posto = null;
		String queryCmd = "select * from posto where "
				+ "id like " + i;				
		try {
			super.openDB();
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				posto = new Posto();
				posto.setId(rs.getInt("id"));
				posto.setMarca(rs.getString("marca"));
				posto.setLocalizacao(rs.getString("endereco"));
				
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();	
		}		
		return posto;
	}
	public ArrayList<Posto> listarPostos() throws Exception {
		ArrayList<Posto> listaPostos = new ArrayList<Posto>();
		String queryCmd = "select * from posto";				
		try {
			super.openDB();
			Connection con = super.getCon();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ResultSet rs = ps1.executeQuery();			
			if(rs.next()) {		
				Posto posto = new Posto();
				posto.setId(rs.getInt("id"));
				posto.setMarca(rs.getString("marca"));
				posto.setLocalizacao(rs.getString("endereco"));
				
				listaPostos.add(posto);
				
			}
		} catch (SQLException e) {
			throw new Exception(e); 
		} finally {
			super.closeDB();	
		}		
		return listaPostos;
	}
}
