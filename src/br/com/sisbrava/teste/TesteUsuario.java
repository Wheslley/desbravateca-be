package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteUsuario {

	public static void main(String[] args) {
		
		/*
		Pessoa pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		Permissoes permissao = (Permissoes) PermissoesRepository.getInstance().getSelectOneObject(1);
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("wheslley");
		usuario.setSenha("senha123");
		usuario.setPessoa(pessoa);
		usuario.setPermissao(permissao);
		
		UsuarioRepository.getInstance().insert(usuario);
		
		pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(2);
		
		usuario = new Usuario();
		usuario.setUsuario("whislley");
		usuario.setSenha("senha123");
		usuario.setPessoa(pessoa);
		usuario.setPermissao(permissao);
		
		UsuarioRepository.getInstance().insert(usuario);
		*/
		
		List<Object> lo = (List<Object>) UsuarioRepository.getInstance().selectMultiplusObjects(ITables.USUARIO);

		for (Object obj : lo) {
			Usuario u = (Usuario) obj;
			System.out.println(u.toString());
		}

	}

}
