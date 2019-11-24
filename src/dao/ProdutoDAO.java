package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Produto;

public class ProdutoDAO {
	
// a conex�o com o banco de dados
private Connection conn;

public ProdutoDAO() throws SQLException {
    new ConexaoBD();
	this.conn = ConexaoBD.conectar();
 }

public void incluir(Produto produto) {
    String sqlInsert = 
       "INSERT INTO produto(nome_produto, descricao_produto, peso_produto, created_at) VALUES (?, ?, ?, ?)";
 
    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
       stm.setString(1, produto.getNomeProduto());
       stm.setString(2, produto.getDescricaoProduto());
       stm.setInt(3, produto.getPesoProduto());
       
       java.util.Date data = new java.util.Date();  
       java.sql.Date dataSql = new java.sql.Date(data.getTime());
       stm.setDate(4, dataSql);
       stm.execute();
       
       JOptionPane.showMessageDialog (null, produto.toString());
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

public void excluir(Produto p) {
    String sqlDelete = "DELETE FROM produto WHERE Id_prod = ?";
    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
       stm.setInt(1, p.getIdProduto());
    
       stm.execute();
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
	
 public void update(Produto p) {
    String sqlUpdate = "UPDATE produto SET nome_produto = ?, Descricao_produto = ?, Peso_produto = ? WHERE Id_prod = ?";
  
    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
       stm.setString(1, p.getNomeProduto());
       stm.setString(2, p.getDescricaoProduto());
       stm.setInt(3, p.getPesoProduto());
       stm.setInt(4, p.getIdProduto());
    
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

 public ArrayList<Produto> buscar() {
    String sqlSelect = 
       "SELECT * FROM produto";
    ArrayList<Produto> lista = new ArrayList<Produto>();
    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
        while (rs.next()) {
        	Produto p = new Produto();
             p.setIdProduto(rs.getInt("id_prod"));
             p.setNomeProduto(rs.getString("nome_produto"));
             p.setDescricaoProduto(rs.getString("descricao_produto"));
             p.setPesoProduto(rs.getInt("peso_produto"));
             p.setDataCriacao(rs.getDate("created_at"));
             lista.add(p);
          }
       
       } 
       catch (Exception e) {
          e.printStackTrace();
       }
    return lista;
    }

 } 
