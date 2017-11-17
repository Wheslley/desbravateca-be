package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Permissoes;
import br.com.sisbrava.bean.Pessoa;
import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.PermissoesRepository;
import br.com.sisbrava.repository.PessoaRepository;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteUsuario {

	public static void main(String[] args) {
		
		
		Pessoa pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		Permissoes permissao = (Permissoes) PermissoesRepository.getInstance().getSelectOneObject(2);
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("jady");
		usuario.setPessoa(pessoa);
		usuario.setPermissao(permissao);
		
		UsuarioRepository.getInstance().insert(usuario);
		
		List<Object> lo = (List<Object>) UsuarioRepository.getInstance().selectMultiplusObjects(ITables.USUARIO);

		for (Object obj : lo) {
			Usuario us = (Usuario) obj;
			System.out.println(us.toString());
		}

	}

}
