package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.SaidaProduto;

public class SaidaProdutoDAO {
	private Connection conn;
	EntradaProdutoDAO entradaDAO;
	
	public SaidaProdutoDAO() throws SQLException {
	    new ConexaoBD();
		this.conn = ConexaoBD.conectar();
	 }
	
	public void incluir(SaidaProduto saidaProduto) {
	    String sqlInsert = 
	       "INSERT INTO saidaproduto(data_saida, quantidade, prod_entrada_id, created_at) VALUES (?, ?, ?, ?)";
	 
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	       
	       java.sql.Date dataSql1 = new java.sql.Date( saidaProduto.getDate().getTime() );
	       stm.setDate(1, dataSql1);
	       
	       stm.setInt(2, saidaProduto.getQuantidade());
	       stm.setInt(3, saidaProduto.getProduto().getIdEntradaProduto());   
	       
	       java.util.Date data = new java.util.Date();  
	       java.sql.Date dataSql2 = new java.sql.Date(data.getTime());
	       
	       stm.setDate(4, dataSql2);
	       stm.execute();
	       JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
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
