package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Pessoa;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.PessoaRepository;

public class TestePessoa {
	public static void main(String[] args) {
		
		//Pessoa p = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		
		//System.out.println(p.getNome());
		
		Pessoa p1 = new Pessoa();
		p1.setIdade(23);
		p1.setNome("Jady Bezerra Domingues");
		p1.setRg("");
		p1.setCpf("35017458859");
		
		PessoaRepository.getInstance().insert(p1);
		
		List<Object> lo = (List<Object>) PessoaRepository.getInstance().selectMultiplusObjects(ITables.PESSOA);
		
		for (Object obj : lo) {
			Pessoa p3 = (Pessoa) obj;
			System.out.println(p3.toString());
		}
		
		
	}
}
