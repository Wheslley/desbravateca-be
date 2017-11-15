package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.ClubePossuiCep;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.ClubePossuiCepRepository;

public class TesteClubePossuiCep {
	
	public static void main(String[] args) {
		
		ClubePossuiCepRepository cRepository = new ClubePossuiCepRepository();
		
		List<Object> lista = (List<Object>) cRepository.selectMultiplusObjects(ITables.CLUBE_POSSUI_CEP);
		
		for(Object o : lista) {
			ClubePossuiCep cpcep = (ClubePossuiCep) o;
			System.out.println(cpcep.toString());
		}
		
	}
}
