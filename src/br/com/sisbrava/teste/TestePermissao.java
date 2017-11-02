package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Permissoes;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.PermissoesRepository;

public class TestePermissao {

	public static void main(String[] args) {

		List<Object> lo = (List<Object>) PermissoesRepository.getInstance().selectMultiplusObjects(ITables.PERMISSOES);

		for (Object obj : lo) {
			Permissoes p3 = (Permissoes) obj;
			System.out.println(p3.toString());
		}
		
		/*Permissoes p = new Permissoes();
		p.setDescricao("Tecnico");

		Permissoes p2 = new Permissoes();
		p2.setDescricao("Global");

		PermissoesRepository.getInstance().insert(p);
		PermissoesRepository.getInstance().insert(p2);
		
		lo = (List<Object>) PermissoesRepository.getInstance().selectMultiplusObjects(ITables.PERMISSOES);

		for (Object obj : lo) {
			Permissoes p3 = (Permissoes) obj;
			System.out.println(p3.toString());
		}
		
		PermissoesRepository.getInstance().delete(p);
		
		lo = (List<Object>) PermissoesRepository.getInstance().selectMultiplusObjects(ITables.PERMISSOES);

		for (Object obj : lo) {
			Permissoes p3 = (Permissoes) obj;
			System.out.println(p3.toString());
		}*/

	}

}
