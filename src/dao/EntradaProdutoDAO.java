package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.EntradaProduto;
import model.Produto;

public class EntradaProdutoDAO {
	private Connection conn;
	EntradaProdutoDAO entradaDAO;
	
	public EntradaProdutoDAO() throws SQLException {
	    new ConexaoBD();
		this.conn = ConexaoBD.conectar();
	 }

	public void incluir(EntradaProduto entradaProduto) {
	    String sqlInsert = 
	       "INSERT INTO entradaProduto(data_entrada, quantidade, prod_id, created_at) VALUES (?, ?, ?, ?)";
	 
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	       
	       java.sql.Date dataSql1 = new java.sql.Date( entradaProduto.getDataEntrada().getTime() );
	       stm.setDate(1, dataSql1);
	       
	       stm.setInt(2, entradaProduto.getQuantidade());
	       stm.setInt(3, entradaProduto.getProduto().getIdProduto());   
	       
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
	    String sqlSelect = 
	       "SELECT * FROM entprod;";
	    ArrayList<Object> lista = new ArrayList<Object>();
	    
	    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
	        while (rs.next()) {
	        	
	        	 EntradaProduto f = new EntradaProduto();
	        	 
	             f.setDataEntrada(rs.getDate("data_entrada"));
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
	    System.out.println(lista);
	    return lista;
	 }
}
