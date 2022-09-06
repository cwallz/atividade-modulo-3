

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

	public static void save(Funcionario funcionario){
		
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */
		
		String sql = "INSERT INTO tb_funcionario(nome, email, senha, registro_matricula, perfil)" +
		"VALUES(?,?,?,?,?)";
		
	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	// Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	// Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	// Adicionar o valor do primeiro parâmetro da sql
	pstm.setString(1, funcionario.getNome());
	pstm.setString(2, funcionario.getEmail());
	pstm.setString(3, funcionario.getSenha());
	pstm.setInt(4, funcionario.getRegistroMatricula());
	pstm.setString(5, funcionario.getPerfil());

	//Executa a sql para inserção de dados
	pstm.execute();

	} catch (Exception e) {
		
	e.printStackTrace();
	}finally{
	// fecha as conexões
		
	try {
	if(pstm != null){

	pstm.close();
	}

	}catch(Exception e){
	}
	}
	}

	public static void removeById (int id) {
		
	String sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";

	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	conn = ConnectionFactory.createConnectionToMySQL();
		
	pstm = conn.prepareStatement(sql);

	pstm.setInt(1, id);

	pstm.execute();

	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}finally{

	try {
	if(pstm != null) {
		
	pstm.close();
	}

	if(conn != null) {
	conn.close();
	}

	}catch(Exception e) {
	e.printStackTrace();
	}
	}
	}

	public static void update(Funcionario funcionario){
		
	String sql = "UPDATE tb_funcionario SET nome = ?, email = ?, senha = ?, registro_matricula = ?, perfil = ?" +
	"WHERE id_funcionario = ?";

	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	//Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	//Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	//Adicione o valor do primeiro parâmetro da sql
	pstm.setString(1, funcionario.getNome());
	pstm.setString(2, funcionario.getEmail());
	pstm.setString(3, funcionario.getSenha());
	pstm.setInt(4, funcionario.getRegistroMatricula());
	pstm.setString(5, funcionario.getPerfil());
	pstm.setInt(6, funcionario.getIdFuncionario());

	//Executa a sql para inserção de dados
	pstm.execute();

	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}finally{

	try {
	if(pstm != null) {
		
	pstm.close();
	}

	if(conn != null) {
	conn.close();
	}

	}catch(Exception e) {
	e.printStackTrace();
	}
	}
	}


	public static List<Funcionario> getFuncionarios(){
		
	String sql = "SELECT * FROM tb_funcionario";
		
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
	Connection conn = null;
	PreparedStatement pstm = null;
	//Classe que vai recuperar os dados do banco de dados
	ResultSet rset = null;

	try {
	conn = ConnectionFactory.createConnectionToMySQL();

	pstm = conn.prepareStatement(sql);

	rset = pstm.executeQuery();

	//Enquanto existir dados no banco de dados, faça
	while(rset.next()){

	Funcionario funcionario = new Funcionario();

	//Recupera a id do banco e atribui a ele ao objeto
	funcionario.setIdFuncionario(rset.getInt("id_funcionario"));
	funcionario.setNome(rset.getString("nome"));
	funcionario.setEmail(rset.getString("email"));
	funcionario.setSenha(rset.getString("senha"));
	funcionario.setRegistroMatricula(rset.getInt("registro_matricula"));
	funcionario.setPerfil(rset.getString("perfil"));

	//Adiciono o funcionario recuperado, a lista de funcionarios
	funcionarios.add(funcionario);
	}
	} catch (Exception e) {

	e.printStackTrace();
	}finally {

	try {

	if(rset != null) {

	rset.close();
	}

	if(pstm != null) {

	pstm.close();
	}

	if(conn != null) {

	conn.close();
	}

	} catch (Exception e) {
		
	e.printStackTrace();
	}
	}

	return funcionarios;
	}
}
