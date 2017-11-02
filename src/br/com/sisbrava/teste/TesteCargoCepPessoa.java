package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.CargoCepPessoa;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.CargoCepPessoaRepository;

public class TesteCargoCepPessoa {
	
	
	public static void main(String[] args) {
		
		List<Object> lista = (List<Object>) CargoCepPessoaRepository.getInstance().selectMultiplusObjects(ITables.CARGO_CEP_PESSOA);

		for (Object obj : lista) {
			CargoCepPessoa ccPessoa = (CargoCepPessoa) obj;
			System.out.println(ccPessoa.toString());
		}
	}
	
}
