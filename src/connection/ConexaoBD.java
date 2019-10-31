package connection;
import java.sql.*; 

public class ConexaoBD {

	public static Connection conectar () throws SQLException {
	
		String servidor = "127.0.0.1";
		String porta = "3306";
		String database = "simetec";
		String usuario = "root";
		String senha = "guilherme1904";
		String conexao = "jdbc:mysql://" + servidor + ":" + porta + 
				"/" + database + "?useTimezone=true&serverTimezone=UTC";
		return DriverManager.getConnection(conexao, usuario, senha);
	}
	
	public static void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
}

