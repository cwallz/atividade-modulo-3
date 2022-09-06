public class Funcionario extends Usuario {

	private int idFuncionario;
	private int registroMatricula;
	private String perfil;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public int getRegistroMatricula() {
		return registroMatricula;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public void setRegistroMatricula(int registroMatricula) {
		this.registroMatricula = registroMatricula;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}

    