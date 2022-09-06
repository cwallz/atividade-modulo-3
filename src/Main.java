import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	
	private static void mostrarMenu() {
		System.out.println("Digite a opção desejada no menu abaixo para que possamos te ajudar.");
		System.out.println();
		System.out.println("Digite 1 para menu CLIENTE");
		System.out.println("Digite 2 para menu FUNCIONARIO");
		System.out.println("Digite 3 para menu DESTINO");
		System.out.println("Digite 4 para menu TRANSICOES");
		System.out.println("Digite 5 para SAIR e fechar o programa");
		System.out.println();
		System.out.printf("Digite a opção escolhida: \n");
		
		int opcaoMenuIniciar;
		opcaoMenuIniciar = scan.nextInt();
		
		if (opcaoMenuIniciar == 1) {
			menuCliente();
		} else if (opcaoMenuIniciar == 2) {
			menuFuncionario();
		} else if (opcaoMenuIniciar == 3) {
			menuDestino();
		} else if (opcaoMenuIniciar == 4) {
			menuTransicao();
		} else if (opcaoMenuIniciar == 5) {
			System.out.println("Obrigado pela visita. Até logo!");
		} else {
			System.out.println("Opção inválida!");
			mostrarMenu();
		}
	}
	
	private static void menuCliente() {
		System.out.println("O que gostaria de fazer com o Cliente?");
		System.out.println();
		System.out.println("Digite 1 para CADASTRAR");
		System.out.println("Digite 2 para CONSULTAR");
		System.out.println("Digite 3 para ATUALIZAR");
		System.out.println("Digite 4 para DELETAR");
		System.out.println("Digite 5 para VOLTAR");
		
		int opcaoMenuCliente;
		
		opcaoMenuCliente = scan.nextInt();
		
		if (opcaoMenuCliente == 1) {
			menuCadastrarCliente();
		} else if (opcaoMenuCliente == 2) {
			menuConsultarCliente();
		} else if (opcaoMenuCliente == 3) {
			menuAtualizarCliente();
		} else if (opcaoMenuCliente == 4) {
			menuDeletarCliente();
		} else if (opcaoMenuCliente == 5) {
			System.out.println("Obrigado pela visita. Até logo!");
		} else {
			System.out.println("Opção inválida!");
			menuCliente();
		}
		
	}
	
	private static void menuCadastrarCliente() {
		String nome, email, senha, cpf, dataNascimento;
		System.out.println("Digite o NOME do Cliente");
		nome = scan.next();
		System.out.println("Digite o EMAIL do Cliente");
		email = scan.next();
		System.out.println("Digite a SENHA (temporária) para o Cliente entrar no sistema");
		senha = scan.next();
		System.out.println("Digite o CPF do Cliente");
		cpf = scan.next();
		System.out.println("Digite a DATA DE NASCIMENTO do Cliente (dd/MM/yyyy)");
		dataNascimento = scan.next();
		System.out.println();
		
		Cliente novoCliente = new Cliente();
		
		novoCliente.setCpf(cpf);
		novoCliente.setEmail(email);
		novoCliente.setNome(nome);
		novoCliente.setSenha(senha);
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		try {
			novoCliente.setDataDeNascimento(sdf1.parse(dataNascimento));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ClienteDAO.save(novoCliente);
		
		System.out.println("Cliente cadastrado com SUCESSO!");
		
		mostrarMenu();
	}
	
	private static void menuConsultarCliente() {
		List<Cliente> clientes = ClienteDAO.getClientes();
		
		for (Cliente cliente : clientes) {
			System.out.print("Cliente ID: ");
			System.out.println(cliente.getIdCliente());
			System.out.print("    NOME: ");
			System.out.println(cliente.getNome());
			System.out.print("    EMAIL: ");
			System.out.println(cliente.getEmail());
			System.out.print("    CPF: ");
			System.out.println(cliente.getCpf());
			System.out.print("    Data de Nascimento: ");
			System.out.println(cliente.getDataDeNascimento());
			
		}
		
		mostrarMenu();
	}
	
	private static void menuAtualizarCliente() {
		int idCliente;
		String nome, email, senha, cpf, dataNascimento;
		System.out.println("Digite o ID do Cliente");
		idCliente = scan.nextInt();
		System.out.println("Digite o NOME do Cliente");
		nome = scan.next();
		System.out.println("Digite o EMAIL do Cliente");
		email = scan.next();
		System.out.println("Digite a SENHA (temporária) para o Cliente entrar no sistema");
		senha = scan.next();
		System.out.println("Digite o CPF do Cliente");
		cpf = scan.next();
		System.out.println("Digite a DATA DE NASCIMENTO do Cliente (dd/MM/yyyy)");
		dataNascimento = scan.next();
		System.out.println();
		
		Cliente cliente = new Cliente();

		cliente.setIdCliente(idCliente);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setNome(nome);
		cliente.setSenha(senha);
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		try {
			cliente.setDataDeNascimento(sdf1.parse(dataNascimento));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ClienteDAO.update(cliente);
		
		System.out.println("Cliente " + idCliente + " atualizado com SUCESSO");
		
		mostrarMenu();
	}

	private static void menuDeletarCliente() {
		int idCliente;
		System.out.println("Digite o ID do Cliente que deseja excluir:");
		idCliente = scan.nextInt();
		
		System.out.println("Tem certeza que deseja excluir o cliente ID: " + idCliente + "?");
		String opcaoRemover;
		System.out.println("Digite Sim / Não");
		opcaoRemover = scan.next();
		
		if (opcaoRemover.equalsIgnoreCase("sim")) {
			ClienteDAO.removeById(idCliente);
			
			System.out.println("Cliente " + idCliente + " removido com sucesso!");
		} else {
			System.out.println("Nada foi feito =]");
		}		
		
		mostrarMenu();
	}
	
	private static void menuFuncionario() {
		System.out.println("O que gostaria de fazer com o Funcionario?");
		System.out.println();
		System.out.println("Digite 1 para CADASTRAR");
		System.out.println("Digite 2 para CONSULTAR");
		System.out.println("Digite 3 para ATUALIZAR");
		System.out.println("Digite 4 para DELETAR");
		System.out.println("Digite 5 para VOLTAR");
		
		int opcaoMenuFuncionario;
		
		opcaoMenuFuncionario = scan.nextInt();
		
		if (opcaoMenuFuncionario == 1) {
			menuCadastrarFuncionario();
		} else if (opcaoMenuFuncionario == 2) {
			menuConsultarFuncionario();
		} else if (opcaoMenuFuncionario == 3) {
			menuAtualizarFuncionario();
		} else if (opcaoMenuFuncionario == 4) {
			menuDeletarFuncionario();
		} else if (opcaoMenuFuncionario == 5) {
			System.out.println("Obrigado pela visita. Até logo!");
		} else {
			System.out.println("Opção inválida!");
			menuFuncionario();
		}
		
	}
	
	private static void menuCadastrarFuncionario() {
		int registroMatricula;
		String nome, email, senha, perfil;
		System.out.println("Digite o NOME do Funcionário");
		nome = scan.next();
		System.out.println("Digite o EMAIL do Funcionário");
		email = scan.next();
		System.out.println("Digite a SENHA (temporária) para o Funcionário entrar no sistema");
		senha = scan.next();
		System.out.println("Digite o REGISTRO MATRICULA do Funcionário");
		registroMatricula = scan.nextInt();
		System.out.println("Digite o PERFIL que funcionário possuirá (CONSULTOR / EDITOR / GESTOR)");
		perfil = scan.next();
		System.out.println();
		
		Funcionario novoFuncionario = new Funcionario();
		
		novoFuncionario.setNome(nome);
		novoFuncionario.setEmail(email);
		novoFuncionario.setSenha(senha);	
		novoFuncionario.setRegistroMatricula(registroMatricula);
		novoFuncionario.setPerfil(perfil);
		
		
		FuncionarioDAO.save(novoFuncionario);
		
		System.out.println("Funcionário cadastrado com SUCESSO!");
		
		mostrarMenu();
	}
	
	private static void menuConsultarFuncionario() {
		List<Funcionario> funcionarios = FuncionarioDAO.getFuncionarios();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.print("Funcionário ID: ");
			System.out.println(funcionario.getIdFuncionario());
			System.out.print("    NOME: ");
			System.out.println(funcionario.getNome());
			System.out.print("    EMAIL: ");
			System.out.println(funcionario.getEmail());
			System.out.print("    REGISTRO DA MATRÍCULA: ");
			System.out.println(funcionario.getRegistroMatricula());
			System.out.print("    PERFIL: ");
			System.out.println(funcionario.getPerfil());
			
		}
		
		mostrarMenu();
	}
	
	private static void menuAtualizarFuncionario() {
		int idFuncionario, registroMatricula;
		String nome, email, senha, perfil;
		System.out.println("Digite o ID do Funcionário");
		idFuncionario = scan.nextInt();
		System.out.println("Digite o NOME do Funcionário");
		nome = scan.next();
		System.out.println("Digite o EMAIL do Funcionário");
		email = scan.next();
		System.out.println("Digite a SENHA (temporária) para o Funcionário entrar no sistema");
		senha = scan.next();
		System.out.println("Digite o REGISTRO DA MATRÍCULA do Funcionário");
		registroMatricula = scan.nextInt();
		System.out.println("Digite o PERFIL que funcionário possuirá (CONSULTOR / EDITOR / GESTOR)");
		perfil = scan.next();
		System.out.println();
		
		Funcionario funcionario = new Funcionario();

		funcionario.setIdFuncionario(idFuncionario);
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		funcionario.setRegistroMatricula(registroMatricula);
		funcionario.setPerfil(perfil);

		
		
		FuncionarioDAO.update(funcionario);
		
		System.out.println("Funcionário " + idFuncionario + " atualizado com SUCESSO!");
		
		mostrarMenu();
	}

	private static void menuDeletarFuncionario() {
		int idFuncionario;
		System.out.println("Digite o ID do Funcionário que deseja excluir:");
		idFuncionario = scan.nextInt();
		
		System.out.println("Tem certeza que deseja excluir o funcionário ID: " + idFuncionario + "?");
		String opcaoRemover;
		System.out.println("Digite Sim / Não");
		opcaoRemover = scan.next();
		
		if (opcaoRemover.equalsIgnoreCase("sim")) {
			FuncionarioDAO.removeById(idFuncionario);
			
			System.out.println("Funcionário " + idFuncionario + " removido com sucesso!");
		} else {
			System.out.println("Nada foi feito =]");
		}		
		
		mostrarMenu();
	}

	private static void menuDestino() {
		System.out.println("O que gostaria de fazer com o Destino?");
		System.out.println();
		System.out.println("Digite 1 para CADASTRAR");
		System.out.println("Digite 2 para CONSULTAR");
		System.out.println("Digite 3 para ATUALIZAR");
		System.out.println("Digite 4 para DELETAR");
		System.out.println("Digite 5 para VOLTAR");
		
		int opcaoMenuDestino;
		
		opcaoMenuDestino = scan.nextInt();
		
		if (opcaoMenuDestino == 1) {
			menuCadastrarDestino();
		} else if (opcaoMenuDestino == 2) {
			menuConsultarDestino();
		} else if (opcaoMenuDestino == 3) {
			menuAtualizarDestino();
		} else if (opcaoMenuDestino == 4) {
			menuDeletarDestino();
		} else if (opcaoMenuDestino == 5) {
			System.out.println("Obrigado pela visita. Até logo!");
		} else {
			System.out.println("Opção inválida!");
			menuDestino();
		}
		
	}
	
	private static void menuCadastrarDestino() {
		int idFuncionario;
		String nome, cidade, estado;
		double precoDoPacote, desconto;
		boolean promocao;
		System.out.println("Digite a ID DO FUNCIONÁRIO responsável por esse cadastramento");
		idFuncionario = scan.nextInt();
		System.out.println("Digite o NOME do Destino");
		nome = scan.next();
		System.out.println("Digite a CIDADE do Destino");
		cidade = scan.next();
		System.out.println("Digite o ESTADO do Destino");
		estado = scan.next();
		System.out.println("Digite o PREÇO DO PACOTE desse Destino (Digitar apenas o valor)");
		precoDoPacote = scan.nextDouble();
		System.out.println("Esse Destino é uma PROMOÇÃO? Digite Sim/Não");
		String opcaoPromocao;
		opcaoPromocao = scan.next();
		if (opcaoPromocao.equalsIgnoreCase("sim")) {
			promocao = true;			
		} else {
			promocao = false;
		}	
		System.out.println("Se sim, qual é o percentual de DESCONTO?");
		int converterParaDecimal;
		converterParaDecimal = scan.nextInt();
		desconto = converterParaDecimal / 100;
		System.out.println();
		
		Destino novoDestino = new Destino();
		
		novoDestino.setIdFuncionario(idFuncionario);
		novoDestino.setNome(nome);
		novoDestino.setCidade(cidade);
		novoDestino.setEstado(estado);	
		novoDestino.setPrecoDoPacote(precoDoPacote);
		novoDestino.setPromocao(promocao);
		novoDestino.setDesconto(desconto);
		
		
		DestinoDAO.save(novoDestino);
		
		System.out.println("Destino cadastrado com SUCESSO!");
		
		mostrarMenu();
	}
	
	private static void menuConsultarDestino() {
		List<Destino> destinos = DestinoDAO.getDestinos();
		
		for (Destino destino : destinos) {
			System.out.print("Destino ID: ");
			System.out.println(destino.getIdDestino());
			System.out.print("Funcionário ID: ");
			System.out.println(destino.getIdFuncionario());
			System.out.print("    NOME: ");
			System.out.println(destino.getNome());
			System.out.print("    CIDADE: ");
			System.out.println(destino.getCidade());
			System.out.print("    ESTADO: ");
			System.out.println(destino.getEstado());
			System.out.print("    PREÇO DO PACOTE: ");
			System.out.println(destino.getPrecoDoPacote());
			System.out.print("    PROMOÇÃO: ");
			System.out.println(destino.isPromocao());
			System.out.print("    DESCONTO: ");
			System.out.println(destino.getDesconto());
			
		}
		
		mostrarMenu();
	}
	
	private static void menuAtualizarDestino() {
		int idDestino, idFuncionario;
		String nome, cidade, estado;
		double precoDoPacote, desconto;
		boolean promocao;
		System.out.println("Digite o ID do Destino");
		idDestino = scan.nextInt();
		System.out.println("Digite a ID DO FUNCIONÁRIO responsável por esse cadastramento");
		idFuncionario = scan.nextInt();
		System.out.println("Digite o NOME do Destino");
		nome = scan.next();
		System.out.println("Digite a CIDADE do Destino");
		cidade = scan.next();
		System.out.println("Digite o ESTADO do Destino");
		estado = scan.next();
		System.out.println("Digite o PREÇO DO PACOTE desse Destino (Digitar apenas o valor)");
		precoDoPacote = scan.nextDouble();
		System.out.println("Esse Destino é uma PROMOÇÃO? Digite Sim/Não");
		String opcaoPromocao;
		opcaoPromocao = scan.next();
		if (opcaoPromocao.equalsIgnoreCase("sim")) {
			promocao = true;			
		} else {
			promocao = false;
		}
		System.out.println("Se sim, qual é o percentual de DESCONTO?");
		int converterParaDecimal;
		converterParaDecimal = scan.nextInt();
		desconto = converterParaDecimal / 100;
		System.out.println();
		
		Destino destino = new Destino();

		destino.setIdDestino(idDestino);
		destino.setIdFuncionario(idFuncionario);
		destino.setNome(nome);
		destino.setCidade(cidade);
		destino.setEstado(estado);
		destino.setPrecoDoPacote(precoDoPacote);
		destino.setPromocao(promocao);
		destino.setDesconto(desconto);

		
		
		DestinoDAO.update(destino);
		
		System.out.println("Destino " + idDestino + " atualizado com SUCESSO!");
		
		mostrarMenu();
	}

	private static void menuDeletarDestino() {
		int idDestino;
		System.out.println("Digite o ID do Destino que deseja excluir:");
		idDestino = scan.nextInt();
		
		System.out.println("Tem certeza que deseja excluir o destino ID: " + idDestino + "?");
		String opcaoRemover;
		System.out.println("Digite Sim / Não");
		opcaoRemover = scan.next();
		
		if (opcaoRemover.equalsIgnoreCase("sim")) {
			DestinoDAO.removeById(idDestino);
			
			System.out.println("Destino " + idDestino + " removido com sucesso!");
		} else {
			System.out.println("Nada foi feito =]");
		}		
		
		mostrarMenu();
	}

	private static void menuTransicao() {
		System.out.println("O que gostaria de fazer com o Transicao?");
		System.out.println();
		System.out.println("Digite 1 para CADASTRAR");
		System.out.println("Digite 2 para CONSULTAR");
		System.out.println("Digite 3 para ATUALIZAR");
		System.out.println("Digite 4 para DELETAR");
		System.out.println("Digite 5 para VOLTAR");
		
		int opcaoMenuTransicao;
		
		opcaoMenuTransicao = scan.nextInt();
		
		if (opcaoMenuTransicao == 1) {
			menuCadastrarTransicao();
		} else if (opcaoMenuTransicao == 2) {
			menuConsultarTransicao();
		} else if (opcaoMenuTransicao == 3) {
			menuAtualizarTransicao();
		} else if (opcaoMenuTransicao == 4) {
			menuDeletarTransicao();
		} else if (opcaoMenuTransicao == 5) {
			System.out.println("Obrigado pela visita. Até logo!");
		} else {
			System.out.println("Opção inválida!");
			menuTransicao();
		}
		
	}
	
	private static void menuCadastrarTransicao() {
		int idCliente, idDestino, quantidadeDiarias;
		String dataViagem;
		boolean optanteSeguro;
		double taxaSeguro;
		System.out.println("Digite o ID DO CLIENTE que realizou essa transição");
		idCliente = scan.nextInt();
		System.out.println("Digite qual é o ID DO DESTINO dessa Transição");
		idDestino = scan.nextInt();
		System.out.println("Digite a QUANTIDADE DE DIÁRIAS dessa Transição");
		quantidadeDiarias = scan.nextInt();
		System.out.println("Digite a DATA DA VIAGEM dessa Transição");
		dataViagem = scan.next();
		System.out.println("O cliente é OPTANTE POR SEGURO? Digite Sim / Não");
		String opcaoSeguro;
		opcaoSeguro = scan.next();
		if (opcaoSeguro.equalsIgnoreCase("sim")) {
			optanteSeguro = true;			
		} else {
			optanteSeguro = false;
		}			
		System.out.println("Se sim, digite a TAXA DO SEGURO do Transição");
		int converterParaDecimal;
		converterParaDecimal = scan.nextInt();
		taxaSeguro = converterParaDecimal / 100;
		System.out.println();
		
		Transicao novaTransicao = new Transicao();
		
		novaTransicao.setIdCliente(idCliente);
		novaTransicao.setIdDestino(idDestino);
		novaTransicao.setQuantidadeDiarias(quantidadeDiarias);	
		novaTransicao.setOptanteSeguro(optanteSeguro);
		novaTransicao.setTaxaSeguro(taxaSeguro);		
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		try {
			novaTransicao.setDataViagem(sdf1.parse(dataViagem));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		TransicaoDAO.save(novaTransicao);
		
		System.out.println("Transição cadastrada com SUCESSO!");
		
		mostrarMenu();
	}
	
	private static void menuConsultarTransicao() {
		List<Transicao> transicoes = TransicaoDAO.getTransicoes();
		
		for (Transicao transicao : transicoes) {
			System.out.print("Transição ID: ");
			System.out.println(transicao.getIdTransicao());
			System.out.print("Cliente ID: ");
			System.out.println(transicao.getIdCliente());
			System.out.print("Destino ID: ");
			System.out.println(transicao.getIdDestino());
			System.out.print("    QUANTIDADE DE DIÁRIAS: ");
			System.out.println(transicao.getQuantidadeDiarias());
			System.out.print("    DATA DA VIAGEM: ");
			System.out.println(transicao.getDataViagem());
			System.out.print("    OPTANTE POR SEGURO: ");
			System.out.println(transicao.isOptanteSeguro());
			System.out.print("    TAXA DO SEGURO: ");
			System.out.println(transicao.getTaxaSeguro());
			
		}
		
		mostrarMenu();
	}
	
	private static void menuAtualizarTransicao() {
		int idTransicao, idCliente, idDestino, quantidadeDiarias;
		String dataViagem;
		boolean optanteSeguro;
		double taxaSeguro;
		System.out.println("Digite o ID do Transição");
		idTransicao = scan.nextInt();
		System.out.println("Digite o ID DO CLIENTE que realizou essa transição");
		idCliente = scan.nextInt();
		System.out.println("Digite qual é o ID DO DESTINO dessa Transição");
		idDestino = scan.nextInt();
		System.out.println("Digite a QUANTIDADE DE DIÁRIAS dessa Transição");
		quantidadeDiarias = scan.nextInt();
		System.out.println("Digite a DATA DA VIAGEM dessa Transição");
		dataViagem = scan.next();
		System.out.println("O cliente é OPTANTE POR SEGURO? Digite Sim / Não");
		String opcaoSeguro;
		opcaoSeguro = scan.next();
		if (opcaoSeguro.equalsIgnoreCase("sim")) {
			optanteSeguro = true;			
		} else {
			optanteSeguro = false;
		}	
		System.out.println("Se sim, digite a TAXA DO SEGURO do Transição (em decimal)");
		int converterParaDecimal;
		converterParaDecimal = scan.nextInt();
		taxaSeguro = converterParaDecimal / 100;
		System.out.println();
		
		Transicao transicao = new Transicao();

		transicao.setIdTransicao(idTransicao);
		transicao.setIdCliente(idCliente);
		transicao.setIdDestino(idDestino);
		transicao.setQuantidadeDiarias(quantidadeDiarias);
		transicao.setOptanteSeguro(optanteSeguro);
		transicao.setTaxaSeguro(taxaSeguro);

		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		try {
			transicao.setDataViagem(sdf1.parse(dataViagem));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TransicaoDAO.update(transicao);
		
		System.out.println("Transição " + idTransicao + " atualizado com SUCESSO!");
		
		mostrarMenu();
	}

	private static void menuDeletarTransicao() {
		int idTransicao;
		System.out.println("Digite o ID do Transição que deseja excluir:");
		idTransicao = scan.nextInt();
		
		System.out.println("Tem certeza que deseja excluir o transição ID: " + idTransicao + "?");
		String opcaoRemover;
		System.out.println("Digite Sim / Não");
		opcaoRemover = scan.next();
		
		if (opcaoRemover.equalsIgnoreCase("sim")) {
			TransicaoDAO.removeById(idTransicao);
			
			System.out.println("Transição " + idTransicao + " removido com sucesso!");
		} else {
			System.out.println("Nada foi feito =]");
		}		
		
		mostrarMenu();
	}

	
	public static void main(String[] args) {
		
		System.out.println("Seja bem vindo ao WALLZ TOUR!");
		mostrarMenu();

				
		
	}

}
