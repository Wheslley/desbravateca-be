package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Requisitos;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.RequisitosRepository;

public class TesteRequisitos {
	
	public static void main(String[] args) {
		
		RequisitosRepository rRepository = new RequisitosRepository();
		/*
		Requisitos r = new Requisitos();
		r.setDescricao("Teste1");
		
		rRepository.insert(r);
		
		r = new Requisitos();
		r.setDescricao("Teste2");
		
		rRepository.insert(r);
		*/
		
		List<Object> lista = (List<Object>) rRepository.selectMultiplusObjects(ITables.REQUISITOS);
		
		for(Object o : lista) {
			Requisitos requisito = (Requisitos) o;
			System.out.println(requisito.toString());
		}
		
	}
}
