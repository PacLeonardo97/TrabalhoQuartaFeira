package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Departamento;

public class DepartamentoDAO {
	private Connection conn;
	DepartamentoDAO dptoDao;
	
	public DepartamentoDAO() throws SQLException {
	    this.conn = new ConexaoBD().conectar();
	 }
	
	public void incluir(Departamento departamento) {
	    String sqlInsert = 
	       "INSERT INTO produto(nome_departamento, local_departamento) VALUES (?, ?)";
	 
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	       stm.setString(1, departamento.getNomeDepartamento());
	       stm.setString(2, departamento.getLocaDepartamento());
	          
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
}
