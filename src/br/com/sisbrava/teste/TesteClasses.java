package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Classes;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteClasses {
	
	public static void main(String[] args) {
		
		List<Object> lo = (List<Object>) UsuarioRepository.getInstance().selectMultiplusObjects(ITables.CLASSES);

		for (Object obj : lo) {
			Classes c = (Classes) obj;
			System.out.println(c.toString());
		}
		
	}
	
}
