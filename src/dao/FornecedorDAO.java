package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConexaoBD;
import model.Endereco;
import model.Fornecedor;

public class FornecedorDAO {
	

	private Connection conn;
	FornecedorDAO funrnDao;
	// a conex�o com o banco de dados
	public FornecedorDAO() throws SQLException {
	    new ConexaoBD();
		this.conn = ConexaoBD.conectar();
	 }

	public void incluir(Fornecedor fornecedor, Endereco endereco) {
	    String sqlInsert = "INSERT INTO fornecedor(nome_forn, telefone, cnpj, created_at) VALUES (?, ?, ?, ?)";
	
	    try (PreparedStatement stm = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);) {
	       stm.setString(1, fornecedor.getNome());
	       
	       stm.setString(2, fornecedor.getTelefone());
	       stm.setString(3, fornecedor.getCNPJ());
	       
	       java.util.Date data = new java.util.Date();  
	       java.sql.Date dataSql = new java.sql.Date(data.getTime());
	       stm.setDate(4, dataSql);

	       stm.execute();
	       
	       ResultSet rs = stm.getGeneratedKeys();
	       rs.next();
	       int idFunc = rs.getInt(1);
	       rs.close();
	       
	       String sqlInsertEndereco = "INSERT INTO endereco_forn(estado, cidade, rua, bairro, numero, cep, forn_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	       PreparedStatement pstm = conn.prepareStatement(sqlInsertEndereco);
		   pstm.setString(1, endereco.getEstado());
		   pstm.setString(2, endereco.getCidade());
		   pstm.setString(3, endereco.getRua());
		   pstm.setString(4, endereco.getBairro());
		   pstm.setString(5, Integer.toString(endereco.getNumero()));
		   pstm.setString(6, endereco.getCep());
		   pstm.setString(7, Integer.toString(idFunc));
		   pstm.execute();
		   
		   JOptionPane.showMessageDialog (null, "Foi cadastrado o fornecedor: " + fornecedor.toString() + "\n\n" + endereco.toString());
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
	    String sqlDelete = "DELETE FROM fornecedor WHERE id_forn = ?";
	    try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
	       stm.setInt(1, f.getIdFornecedor());
	    
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
	
	 public void update(Fornecedor f) {
	    String sqlUpdate = "UPDATE FORNECEDOR SET nome_forn = ? ,TELEFONE = ?,cnpj = ? WHERE id_forn = ?";

	    try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
	       stm.setString(1, f.getNome());
	       stm.setString(2, f.getTelefone());
	       stm.setString(3, f.getCNPJ());
	       stm.setInt(4, f.getIdFornecedor());
	       
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

	 public ArrayList<Fornecedor> buscar() {
	    String sqlSelect = 
	       "SELECT * FROM fornecedor";
	    ArrayList<Fornecedor> lista = new ArrayList<>();
	    try (PreparedStatement stm = conn.prepareStatement(sqlSelect);ResultSet rs = stm.executeQuery();){
	        while (rs.next()) {
	        	
	        	 Fornecedor f = new Fornecedor();
	             f.setIdFornecedor(rs.getInt("id_forn"));
	             f.setNome(rs.getString("nome_forn"));
	             f.setTelefone(rs.getString("telefone"));
	             f.setCNPJ(rs.getString("cnpj"));
	             f.setData(rs.getDate("created_at"));
	             lista.add(f);
	          }
	       
	       } 
	       catch (Exception e) {
	          e.printStackTrace();
	       }
	    return lista;
	    }
 }