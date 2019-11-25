package connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties; 

public class ConexaoBD {
	private static Properties config = new Properties();
    private static String arquivo = "config.ini";
    
	public static Connection conectar () throws SQLException {
		 try {
			config.load(new FileInputStream(arquivo));
			
			String servidor = "127.0.0.1";
			String porta = config.getProperty("porta");
			String database = config.getProperty("database");
			String usuario = config.getProperty("usuario");
			String senha = config.getProperty("senha");
			
			String conexao = "jdbc:mysql://" + servidor + ":" + porta + 
					"/" + database + "?useTimezone=true&serverTimezone=UTC";
			
			return DriverManager.getConnection(conexao, usuario, senha);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		
	}
	
	public static void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
}

