package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Clube;
import br.com.sisbrava.repository.ClubeRepository;

public class TesteClube {
	
	public static void main(String[] args) {
				
		Clube c = (Clube) ClubeRepository.getInstance().getSelectOneObject(1);
		System.out.println(c.toString());
		
	}
	
}
