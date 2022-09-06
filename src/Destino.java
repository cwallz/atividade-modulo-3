
public class Destino {

	private int idDestino;
	private int idFuncionario;
	private String nome;
	private String cidade;
	private String estado;
	private double precoDoPacote;
	private boolean promocao;
	private double desconto;
	
	public int getIdDestino() {
		return idDestino;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public double getPrecoDoPacote() {
		return precoDoPacote;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPrecoDoPacote(double precoDoPacote) {
		this.precoDoPacote = precoDoPacote;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double calcularPromocao() {
		if (this.promocao == true) {
		return this.precoDoPacote * this.desconto;
		} else {
		return this.precoDoPacote;
		}
	}
}
