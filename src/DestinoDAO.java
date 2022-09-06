import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {
	public static void save(Destino destino){
		
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */
		
		String sql = "INSERT INTO tb_destino(id_funcionario, nome, cidade, estado, preco_pacote, promocao, desconto)" +
		"VALUES(?, ?, ?, ?, ?, ?, ?)";
		
	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	// Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	// Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	// Adicionar o valor do primeiro parâmetro da sql
	pstm.setInt(1, destino.getIdFuncionario());
	pstm.setString(2, destino.getNome());
	pstm.setString(3, destino.getCidade());
	pstm.setString(4, destino.getEstado());
	pstm.setDouble(5, destino.getPrecoDoPacote());
	pstm.setBoolean(6, destino.isPromocao());
	pstm.setDouble(7, destino.getDesconto());


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
		
	String sql = "DELETE FROM tb_destino WHERE id_destino = ?";

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

	public static void update(Destino destino){
		
	String sql = "UPDATE tb_destino SET id_funcionario = ?, nome = ?, cidade = ?, estado = ?, preco_pacote = ?, promocao = ?, descont = ?" +
	"WHERE id_destino = ?";

	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	//Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	//Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	//Adicione o valor do primeiro parâmetro da sql
	pstm.setInt(1, destino.getIdFuncionario());
	pstm.setString(2, destino.getNome());
	pstm.setString(3, destino.getCidade());
	pstm.setString(4, destino.getEstado());
	pstm.setDouble(5, destino.getPrecoDoPacote());
	pstm.setBoolean(6, destino.isPromocao());
	pstm.setDouble(7, destino.getDesconto());

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


	public static List<Destino> getDestinos(){
		
	String sql = "SELECT * FROM tb_destino";
		
	List<Destino> destinos = new ArrayList<Destino>();
		
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

	Destino destino = new Destino();

	//Recupera a id do banco e atribui a ele ao objeto
	destino.setIdDestino(rset.getInt("id_destino"));
	destino.setIdFuncionario(rset.getInt("id_funcionario"));
	destino.setNome(rset.getString("nome"));
	destino.setCidade(rset.getString("cidade"));
	destino.setEstado(rset.getString("estado"));
	destino.setPrecoDoPacote(rset.getDouble("preco_pacote"));
	destino.setPromocao(rset.getBoolean("promocao"));
	destino.setDesconto(rset.getDouble("desconto"));

	//Adiciono o destino recuperado, a lista de destinos
	destinos.add(destino);
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

	return destinos;
	}
}

