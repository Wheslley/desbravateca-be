package br.com.sisbrava.teste;

import br.com.sisbrava.repository.UsuarioRepository;

public class TesteUsuario {

	public static void main(String[] args) {
		
		if(UsuarioRepository.getInstance().validateUsernamePassword("wheslley", "senha123")) {
			System.out.println("sucesso");
		} else {
			System.out.println("erro na validação");
		}

	}

}
