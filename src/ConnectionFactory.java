

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usuário do mysql
	private static final String USERNAME = "wallz";
	
	//Senha do mysql
	private static final String PASSWORD = "1234";
	
	//Dados de caminho, porta e nome da base de banco de dados que irá ser feita a conexão
	private static final String DATABASE_URL = 
	"jdbc:mysql://localhost:3306/db_wallztour";
	/**
	 * Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e senha forneceidos
	 * @param wallz
	 * @param 1234
	 * @return uma conexão com o banco de dados
	 * @throws Exception
	 */
	public static Connection createConnectionToMySQL() throws
	Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
		
		//Cria a conexão com o banco de dados
		Connection connection =
	DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	public static void main(String[] args) throws Exception{
		
		//Recupera uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testa se a conexão é nula
		if(con !=null){
			System.out.println("Conexão obtida com sucesso!" + con);
			con.close();
		}
	
	}
}
