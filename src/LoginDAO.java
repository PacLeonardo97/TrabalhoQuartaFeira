import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class LoginDAO {
	private Connection conn;
	FornecedorDAO funrnDao;

	public LoginDAO() throws SQLException {
	    this.conn = new ConexaoBD().conectar();
	 }
	
	 public boolean checkLogin(String cpf, String senha) {
		String sqlCheck = "SELECT * FROM funcionario WHERE cpf = ? and senha = ?";
        boolean check = false;
        ResultSet rs = null;
        try (PreparedStatement stm = conn.prepareStatement(sqlCheck);){
        	stm.setString(1, cpf);
        	stm.setString(2, senha);
        	
        	rs = stm.executeQuery();
            
            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            System.out.println("erro caralho, " +ex);
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;
    }
	 public void incluir(Funcionario funcionario) {
		    String sqlInsert = "INSERT INTO funcionario(cpf, nome, senha) VALUES (?, ?, ?)";

		    try (PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
		       stm.setString(1, funcionario.getCPFFuncionario());
		       stm.setString(2, funcionario.getNomeFuncionario());
		       stm.setString(3, funcionario.getSenhaFuncionario());
		       stm.execute();
		       System.out.println("sql: "+sqlInsert);
		       System.out.println("stm: "+stm);
			   JOptionPane.showMessageDialog (null, "Foi cadastrado o fornecedor: " + funcionario.toString());
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
