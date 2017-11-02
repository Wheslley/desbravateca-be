package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.PessoaPossuiEspecialidade;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.PessoaPossuiEspecialidadeRepository;

public class TestePessoaPossuiEspecialidade {
	
	public static void main(String[] args) {
	
		List<Object> lista = (List<Object>) PessoaPossuiEspecialidadeRepository.getInstance()
				.selectMultiplusObjects(ITables.PESSOA_POSSUI_ESPECIALIDADE);

		for (Object obj : lista) {
			PessoaPossuiEspecialidade ppEspecialidade = (PessoaPossuiEspecialidade) obj;
			System.out.println(ppEspecialidade.toString());
		}
		
	}
}
