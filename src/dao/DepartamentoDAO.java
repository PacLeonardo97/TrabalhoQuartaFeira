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
}
