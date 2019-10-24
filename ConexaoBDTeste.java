import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoBDTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexaoBD conexao = new ConexaoBD();
		try {
			Connection c = conexao.conectar();
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
