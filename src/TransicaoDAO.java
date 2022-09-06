import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransicaoDAO {
	public static void save(Transicao transicao){
		
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */
		
		String sql = "INSERT INTO tb_transicao(id_cliente, id_destino, quantidade_diarias, data_viagem, optante_seguro, taxa_seguro)" +
		"VALUES(?, ?, ?, ?, ?, ?)";
		
	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	// Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	// Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	// Adicionar o valor do primeiro parâmetro da sql
	pstm.setInt(1, transicao.getIdCliente());
	pstm.setInt(2, transicao.getIdDestino());
	pstm.setInt(3, transicao.getQuantidadeDiarias());
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	pstm.setString(4, dateFormat.format(transicao.getDataViagem()));
	pstm.setBoolean(5, transicao.isOptanteSeguro());
	pstm.setDouble(6, transicao.getTaxaSeguro());

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
		
	String sql = "DELETE FROM tb_transicao WHERE id_transicao = ?";

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

	public static void update(Transicao transicao){
		
	String sql = "UPDATE tb_transicao SET id_cliente = ?, id_destino = ?, quantidade_diarias = ?, data_viagem = ?, optante_seguro = ?, taxa_seguro = ?" +
	"WHERE id_transicao = ?";

	Connection conn = null;
	PreparedStatement pstm = null;

	try {
	//Cria uma conexão com o banco
	conn = ConnectionFactory.createConnectionToMySQL();

	//Cria um PreparedStatement, classe usada para executar a query
	pstm = conn.prepareStatement(sql);

	//Adicione o valor do primeiro parâmetro da sql
	pstm.setInt(1, transicao.getIdCliente());
	pstm.setInt(2, transicao.getIdDestino());
	pstm.setInt(3, transicao.getQuantidadeDiarias());
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	pstm.setString(4, dateFormat.format(transicao.getDataViagem()));
	pstm.setBoolean(5, transicao.isOptanteSeguro());
	pstm.setDouble(6, transicao.getTaxaSeguro());

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

	public static List<Transicao> getTransicoes(){
		
	String sql = "SELECT * FROM tb_transicao";
		
	List<Transicao> transicoes = new ArrayList<Transicao>();
		
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

	Transicao transicao = new Transicao();

	//Recupera a id do banco e atribui a ele ao objeto
	transicao.setIdTransicao(rset.getInt("id_transicao"));
	transicao.setIdCliente(rset.getInt("id_cliente"));
	transicao.setIdDestino(rset.getInt("id_destino"));
	transicao.setQuantidadeDiarias(rset.getInt("quantidade_diarias"));
	transicao.setDataViagem(rset.getDate("data_viagem"));
	transicao.setOptanteSeguro(rset.getBoolean("optante_seguro"));
	transicao.setTaxaSeguro(rset.getDouble("taxa_seguro"));

	//Adiciono o transicao recuperado, a lista de transicoes
	transicoes.add(transicao);
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

	return transicoes;
	}
}
