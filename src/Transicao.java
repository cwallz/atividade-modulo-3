import java.util.Date;
public class Transicao {

	private int idTransicao;
	private int idCliente;
	private int idDestino;
	private int quantidadeDiarias;
	private Date dataViagem;
	private boolean optanteSeguro;
	private double taxaSeguro;
	
	public int getIdTransicao() {
		return idTransicao;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public int getQuantidadeDiarias() {
		return quantidadeDiarias;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public boolean isOptanteSeguro() {
		return optanteSeguro;
	}
	public double getTaxaSeguro() {
		return taxaSeguro;
	}
	public void setIdTransicao(int idTransicao) {
		this.idTransicao = idTransicao;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public void setQuantidadeDiarias(int quantidadeDiarias) {
		this.quantidadeDiarias = quantidadeDiarias;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	public void setOptanteSeguro(boolean optanteSeguro) {
		this.optanteSeguro = optanteSeguro;
	}
	public void setTaxaSeguro(double taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}
}
