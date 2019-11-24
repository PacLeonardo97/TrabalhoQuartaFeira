package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Funcionario;

public class LoginDAO {
	private Connection conn;
	FornecedorDAO funrnDao;

	public LoginDAO() throws SQLException {
	    new ConexaoBD();
		this.conn = ConexaoBD.conectar();
	 }

	 public boolean checkLogin(String cpf, String senha) {
		String sqlCheck = "SELECT * FROM funcionario WHERE cpf = ? and senha = ?";
        boolean check = false;
        ResultSet rs = null;
        try (PreparedStatement stm = conn.prepareStatement(sqlCheck);){
        	stm.setString(1, cpf);
        	stm.setString(2, senha);
        	
        	rs = stm.executeQuery();
            
            if (rs.next()) {
            	JOptionPane.showMessageDialog(null, "ola, voce entrou com o cpf: " + cpf);
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;
    }
	 
	 public void incluir(Funcionario funcionario) {
		    String sqlInsert = "INSERT INTO funcionario(cpf, nome, senha, created_at) VALUES (?, ?, ?, ?)";

		    try (PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
		       stm.setString(1, funcionario.getCPFFuncionario());
		       stm.setString(2, funcionario.getNomeFuncionario());
		       stm.setString(3, funcionario.getSenhaFuncionario());
		       
		       java.util.Date data = new java.util.Date();  
		       java.sql.Date dataSql = new java.sql.Date(data.getTime());
		       stm.setDate(4, dataSql);
		       
		       stm.execute();
		       System.out.println("sql: " + sqlInsert);
		       System.out.println("stm: " + stm);
			   JOptionPane.showMessageDialog (null, "Foi cadastrado o funcionário: " + funcionario.toString());
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       try {
		          conn.rollback();
		       } 
		       catch (SQLException e1) {
		          System.out.print(e1.getStackTrace());
		       }
		    }
	 }
	 public ArrayList<Funcionario> buscar() {
		    String sqlSelect = 
		       "SELECT * FROM funcionario";
		    ArrayList<Funcionario> lista = new ArrayList<>();
		    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
		        while (rs.next()) {
		        	
		        	Funcionario f = new Funcionario();
		             f.setIduncionario(rs.getInt("id_func"));
		             f.setCPFFuncionario(rs.getString("cpf"));
		             f.setNomeFuncionario(rs.getString("nome"));
		             f.setData(rs.getDate("created_at"));
		             lista.add(f);
		          }
		       
		       } 
		       catch (Exception e) {
		          e.printStackTrace();
		       }
		    return lista;
	 }
	 
	 public void excluir(Funcionario f) {
		    String sqlDelete = "DELETE FROM funcionario WHERE id_func = ?";
		    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		       stm.setInt(1, f.getidFunc());
		    
		       stm.execute(); 
		       JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       try {
		          conn.rollback();
		       } 
		       catch (SQLException e1) {
		          System.out.print(e1.getStackTrace());
		       }
		    } 
	 }
	 
	 public void update(Funcionario f) {
		    String sqlUpdate = "UPDATE funcionario SET cpf = ? , nome = ? WHERE id_func = ?";

		    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
		       stm.setString(1, f.getCPFFuncionario());
		       stm.setString(2, f.getNomeFuncionario());
		       
		       stm.setInt(3, f.getidFunc());
		       
		       
		       stm.execute();
		       JOptionPane.showMessageDialog(null, "atualizado com sucesso!");
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       try {
		          conn.rollback();
		       } 
		       catch (SQLException e1) {
		          System.out.print(e1.getStackTrace());
		       }
		    } 
		 }
}
