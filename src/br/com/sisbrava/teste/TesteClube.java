package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Cep;
import br.com.sisbrava.bean.Clube;
import br.com.sisbrava.padroesEnum.ERegiao;
import br.com.sisbrava.repository.CepRepository;
import br.com.sisbrava.repository.ClubeRepository;

public class TesteClube {
	
	public static void main(String[] args) {
		
		Cep cep = (Cep) CepRepository.getInstance().getSelectOneObject(3);
		Clube clube = new Clube();
		clube.setCep(cep);
		clube.setDescricao("LEÃO DE JUDÁ");
		clube.setRegiao(ERegiao.TERCEIRA.getValue());
		
		ClubeRepository.getInstance().insert(clube);
		
		Clube c = (Clube) ClubeRepository.getInstance().getSelectOneObject(2);
		System.out.println(c.toString());
		
	}
	
}
