import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

public static void save(Cliente cliente){
	
	/*
	 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
	 * na base de dados
	 */
	
	String sql = "INSERT INTO tb_cliente(nome, email ,senha ,cpf, data_nascimento)" +
	"VALUES(?,?,?,?,?)";
	
Connection conn = null;
PreparedStatement pstm = null;

try {
// Cria uma conexão com o banco
conn = ConnectionFactory.createConnectionToMySQL();

// Cria um PreparedStatement, classe usada para executar a query
pstm = conn.prepareStatement(sql);

// Adicionar o valor do primeiro parâmetro da sql
pstm.setString(1, cliente.getNome());
pstm.setString(2, cliente.getEmail());
pstm.setString(3, cliente.getSenha());
pstm.setString(4, cliente.getCpf());
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
pstm.setString(5, dateFormat.format(cliente.getDataDeNascimento()));

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
	
String sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";

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

public static void update(Cliente cliente){
	
String sql = "UPDATE tb_cliente SET nome = ?, email = ?, senha = ?, cpf = ?, data_nascimento = ?" +
"WHERE id_cliente = ?";

Connection conn = null;
PreparedStatement pstm = null;

try {
//Cria uma conexão com o banco
conn = ConnectionFactory.createConnectionToMySQL();

//Cria um PreparedStatement, classe usada para executar a query
pstm = conn.prepareStatement(sql);

//Adicione o valor do primeiro parâmetro da sql
pstm.setString(1, cliente.getNome());
pstm.setString(2, cliente.getEmail());
pstm.setString(3, cliente.getSenha());
pstm.setString(4, cliente.getCpf());
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
pstm.setString(5, dateFormat.format(cliente.getDataDeNascimento()));
pstm.setInt(6, cliente.getIdCliente());

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

public static List<Cliente> getClientes(){
	
String sql = "SELECT * FROM tb_cliente";
	
List<Cliente> clientes = new ArrayList<Cliente>();
	
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

Cliente cliente = new Cliente();

//Recupera a id do banco e atribui a ele ao objeto
cliente.setIdCliente(rset.getInt("id_cliente"));
cliente.setNome(rset.getString("nome"));
cliente.setEmail(rset.getString("email"));
cliente.setSenha(rset.getString("senha"));
cliente.setCpf(rset.getString("cpf"));
cliente.setDataDeNascimento(rset.getDate("data_nascimento"));

//Adiciono o cliente recuperado, a lista de clientes
clientes.add(cliente);
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

return clientes;
}
}
