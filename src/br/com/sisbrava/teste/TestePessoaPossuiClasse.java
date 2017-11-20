package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Classes;
import br.com.sisbrava.bean.Pessoa;
import br.com.sisbrava.bean.PessoaPossuiClasse;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.ClassesRepository;
import br.com.sisbrava.repository.PessoaPossuiClasseRepository;
import br.com.sisbrava.repository.PessoaRepository;

public class TestePessoaPossuiClasse {

	public static void main(String[] args) {

		Pessoa pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		
		Classes classe = (Classes) ClassesRepository.getInstance().getSelectOneObject(2);
		PessoaPossuiClasse ppClasse = new PessoaPossuiClasse();
		ppClasse.setPessoa(pessoa);
		ppClasse.setClasse(classe);
		ppClasse.setStatus(2);
		
		PessoaPossuiClasseRepository.getInstance().insert(ppClasse);

		List<Object> lista = (List<Object>) PessoaPossuiClasseRepository.getInstance()
				.selectMultiplusObjects(ITables.PESSOA_POSSUI_CLASSE);

		for (Object obj : lista) {
			PessoaPossuiClasse ppClass = (PessoaPossuiClasse) obj;
			System.out.println(ppClass.toString());
		}

	}

}
