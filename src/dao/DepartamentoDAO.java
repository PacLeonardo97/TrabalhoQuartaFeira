package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Departamento;
import model.Funcionario;

public class DepartamentoDAO {
	private Connection conn;
	DepartamentoDAO dptoDao;
	
	public DepartamentoDAO() throws SQLException {
	    new ConexaoBD();
		this.conn = ConexaoBD.conectar();
	 }
	
	public void incluir(Departamento departamento) {
	    String sqlInsert = 
	       "INSERT INTO departamento(nome_departamento, local, func_id) VALUES (?, ?, ?)";
	 
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	       stm.setString(1, departamento.getNomeDepartamento());
	       stm.setString(2, departamento.getLocalDepartamento());
	       stm.setInt(3, departamento.getFuncionario().getidFunc());
	       stm.execute();
	       
	       JOptionPane.showMessageDialog (null, departamento.toString());
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
	
	public ArrayList<Object> buscar() {
	    String sqlSelect = "SELECT * FROM DptoFunc;";
	    ArrayList<Object> lista = new ArrayList<Object>();
	    
	    try (PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
	        while (rs.next()) {
	        	
	        	 Departamento dpto = new Departamento();
	             dpto.setIdDepartamento(rs.getInt("id_departamento"));
	             dpto.setNomeDepartamento(rs.getString("nome_departamento"));
	             dpto.setLocaDepartamento(rs.getString("local"));
	             
	             Funcionario func = new Funcionario();
	             func.setCPFFuncionario(rs.getString("cpf"));
	             func.setNomeFuncionario(rs.getString("nome"));
	             
	             lista.add(dpto);
	             lista.add(func);
	          }
	       
	       } 
	       catch (Exception e) {
	          e.printStackTrace();
	       }
	    return lista;
	 }
	
	public void excluir(Departamento dpto) {
	    String sqlDelete = "DELETE FROM departamento WHERE id_departamento = ?";
	    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
	       stm.setInt(1, dpto.getIdDepartamento());
	    
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
	
	public void update(Departamento dpto) {
	    String sqlUpdate = "UPDATE departamento SET nome_departamento = ? , local = ? WHERE id_departamento = ?";

	    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
	    	stm.setString(1, dpto.getNomeDepartamento());
	    	stm.setString(2, dpto.getLocalDepartamento());
	    	stm.setInt(3, dpto.getIdDepartamento());
	    	System.out.println(stm);
	    	
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
