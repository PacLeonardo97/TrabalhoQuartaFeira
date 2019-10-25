import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {
	
// a conexão com o banco de dados
private Connection conn;

public FornecedorDAO() throws SQLException {
    this.conn = new ConexaoBD().conectar();
 }

public void incluir(Fornecedor fornecedor) {
    String sqlInsert = 
       "INSERT INTO fornecedor(idFornecedor, nome, telefone, endereco, cnpj) VALUES (?, ?, ?)";
 
    try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
       stm.setInt(1, fornecedor.getIdFornecedor());
       stm.setString(2, fornecedor.getNome());
       stm.setString(3, fornecedor.getTelefone());
//       stm.setString(4, fornecedor.getEndereco());
       stm.setString(5, fornecedor.getCNPJ());
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

public void excluir(Fornecedor f) {
    String sqlDelete = "DELETE FROM fornecedor WHERE id = ?";
    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
       stm.setInt(1, f.getIdFornecedor());
    
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
	
 public void atualizarTelefone(Fornecedor f, String novoTelefone) {
    String sqlUpdate = "UPDATE FORNECEDOR SET TELEFONE = ? WHERE ID = ?";
  
    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
       stm.setString(1, novoTelefone);
       stm.setInt(2, f.getIdFornecedor());
    
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

 public ArrayList<Fornecedor> buscar() {
    String sqlSelect = 
       "SELECT * FROM fornecedor";
    ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
        while (rs.next()) {
//        	Fornecedor f = new Fornecedor();
        	Fornecedor f = new Fornecedor();
             f.setIdFornecedor(rs.getInt("id"));
             f.setNome(rs.getString("nome"));
             f.setTelefone(rs.getString("telefone"));
//             f.setEndereco(rs.getString("endereco"));
             f.setCNPJ(rs.getString("cnpj"));
             lista.add(f);
          }
       
       } 
       catch (Exception e) {
          e.printStackTrace();
       }
    return lista;
    }

 }