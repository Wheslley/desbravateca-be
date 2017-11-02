package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.PessoaPossuiCep;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.PessoaPossuiCepRepository;

public class TestePessoaPossuiCep {
	
	public static void main(String[] args) {
		
		List<Object> lista = (List<Object>) PessoaPossuiCepRepository.getInstance()
				.selectMultiplusObjects(ITables.PESSOA_POSSUI_CEP);

		for (Object obj : lista) {
			PessoaPossuiCep ppEspecialidade = (PessoaPossuiCep) obj;
			System.out.println(ppEspecialidade.toString());
		}
		
	}
	
}
