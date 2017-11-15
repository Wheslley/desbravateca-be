package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteUsuario {

	public static void main(String[] args) {
		
		
		/*Pessoa pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		Permissoes permissao = (Permissoes) PermissoesRepository.getInstance().getSelectOneObject(1);
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("wheslley");
		usuario.setPessoa(pessoa);
		usuario.setPermissao(permissao);
		
		UsuarioRepository.getInstance().insert(usuario);
		
		pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(2);
		
		usuario = new Usuario();
		usuario.setUsuario("whislley");
		usuario.setPessoa(pessoa);
		usuario.setPermissao(permissao);
		
		UsuarioRepository.getInstance().insert(usuario);
		
		Usuario u = (Usuario) UsuarioRepository.getInstance().getUsuarioUsername("whislley");
		
		System.out.println(u.getPermissao().toString());*/
		
		List<Object> lo = (List<Object>) UsuarioRepository.getInstance().selectMultiplusObjects(ITables.USUARIO);

		for (Object obj : lo) {
			Usuario us = (Usuario) obj;
			System.out.println(us.toString());
		}

	}

}
