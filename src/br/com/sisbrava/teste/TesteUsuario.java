package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteUsuario {

	public static void main(String[] args) {
		
		Usuario usuario = (Usuario) UsuarioRepository.getInstance().getSelectOneObject(4);
		
		System.out.println(usuario.toString());
		
		UsuarioRepository.getInstance().delete(usuario);

	}

}
