package Model.DataBase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConectarBanco {
	
	private final static String url = "jdbc:mysql://localhost:3306/GerenciamentoAbastecimento";
	private final static String username ="root";
	private final static String password = "admin";
	private static Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ConectarBanco() {
		
	}
	
	

	public static Connection getCon() {
		return con;
	}



	public static void setCon(Connection con) {
		ConectarBanco.con = con;
	}



	public Statement getStmt() {
		return stmt;
	}



	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}



	public ResultSet getRs() {
		return rs;
	}



	public void setRs(ResultSet rs) {
		this.rs = rs;
	}



	public static String getUrl() {
		return url;
	}



	public static String getUsername() {
		return username;
	}



	public static String getPassword() {
		return password;
	}




	public void closeDB() {
		try {
			con.close();
		}catch(Exception e) {
			System.out.println("não foi possível fechar a conexão");
			System.exit(1);
		}
		
	}

	public Connection openDB() {
	
	    try {
	    	
	        con = DriverManager.getConnection(url, username, password);
	        stmt = con.createStatement();
	        System.out.println("Conexão estabelecida com sucesso");
	        return con;
	    	
	    } catch (Exception e) {
	        System.out.println("Não foi possível conectar. Motivo: " + e.getMessage());
	        System.exit(1);
	    }
	    return null;
	}
	
	public void fechaConexao(Connection cn, Statement stmt, ResultSet rs2) throws SQLException {
		if(con!= null) {
			cn.close();
		}if(stmt != null) {
			stmt.close();
		}if(rs2 != null) {
			rs2.close();
		}
		
	}

}