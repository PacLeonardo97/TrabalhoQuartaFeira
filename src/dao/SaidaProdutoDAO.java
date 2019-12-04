package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Produto;
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
	       "INSERT INTO saidaproduto(data_saida, quantidade, prod_id, created_at) VALUES (?, ?, ?, ?)";
	 
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	       
	       java.sql.Date dataSql1 = new java.sql.Date( saidaProduto.getDataSaida().getTime());
	       stm.setDate(1, dataSql1);
	       
	       stm.setInt(2, saidaProduto.getQuantidade());
	       stm.setInt(3, saidaProduto.getProduto().getIdProduto());   
	       
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
	 public ArrayList<Object> buscar() {
		    String sqlSelect = "SELECT * FROM saidaProd";
		    ArrayList<Object> lista = new ArrayList<Object>();
		    
		    try (PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
		        while (rs.next()) {
		        	
		        	 SaidaProduto f = new SaidaProduto();
		        	 f.setIdSaidaProduto(rs.getInt("id_saida_prod"));
		        	 f.setDataSaida(rs.getDate("data_saida"));
		             f.setQuantidade(rs.getInt("quantidade"));
		        	 
		             Produto produto = new Produto();
		             produto.setNomeProduto(rs.getString("nome_produto"));
		             produto.setDescricaoProduto(rs.getString("descricao_produto"));
		             produto.setPesoProduto(rs.getInt("peso_produto"));
		             
		             f.setDataCriada(rs.getDate("created_at"));
		             lista.add(f);
		             lista.add(produto);
		          }
		       
		       } 
		       catch (Exception e) {
		          e.printStackTrace();
		       }
		    return lista;
		 }
	
	
	public void excluir(SaidaProduto sp) {
	    String sqlDelete = "DELETE FROM saidaProduto WHERE id_saida_prod = ?";
	    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
	       stm.setInt(1, sp.getIdSaidaProduto());
	    
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
	
	public void update(SaidaProduto sp) {
	    String sqlUpdate = "UPDATE saidaProduto SET data_saida = ?, quantidade = ? WHERE id_saida_prod = ?";

	    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
	    	
			java.sql.Date dataSql = new java.sql.Date(sp.getDataSaida().getTime());
	    	
	    	stm.setDate(1, dataSql);
	    	stm.setInt(2, sp.getQuantidade());
	    	stm.setInt(3, sp.getIdSaidaProduto());
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
