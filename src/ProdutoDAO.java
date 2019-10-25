import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
	
// a conexão com o banco de dados
private Connection conn;

public ProdutoDAO() throws SQLException {
    this.conn = new ConexaoBD().conectar();
 }

public void incluir(Produto produto) {
    String sqlInsert = 
       "INSERT INTO cliente(id, nome, descricao, peso) VALUES (?, ?, ?)";
 
    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
       stm.setInt(1, produto.getIdProduto());
       stm.setString(2, produto.getNomeProduto());
       stm.setString(3, produto.getDescricaoProduto());
       stm.setInt(4, produto.getPesoProduto());       
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

public void excluir(Produto p) {
    String sqlDelete = "DELETE FROM cliente WHERE id = ?";
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
	
 public void atualizarDescricao(Produto p, String novaDescricao) {
    String sqlUpdate = "UPDATE CLIENTE SET DESCRICAO = ? WHERE ID = ?";
  
    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
       stm.setString(1, novaDescricao);
       stm.setInt(2, p.getIdProduto());
    
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

 public ArrayList<Produto> buscar() {
    String sqlSelect = 
       "SELECT * FROM produto";
    ArrayList<Produto> lista = new ArrayList<Produto>();
    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
        while (rs.next()) {
        	Produto p = new Produto();
             p.setIdProduto(rs.getInt("id"));
             p.setNomeProduto(rs.getString("nome"));
             p.setDescricaoProduto(rs.getString("descricao"));
             p.setPesoProduto(rs.getInt("peso"));
             lista.add(p);
          }
       
       } 
       catch (Exception e) {
          e.printStackTrace();
       }
    return lista;
    }

 } 
 
