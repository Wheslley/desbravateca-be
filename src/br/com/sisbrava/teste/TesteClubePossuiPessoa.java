package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.ClubePossuiPessoa;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.ClubePossuiPessoaRepository;

public class TesteClubePossuiPessoa {
	
	public static void main(String[] args) {
		
		List<Object> lo = (List<Object>) ClubePossuiPessoaRepository.getInstance().selectMultiplusObjects(ITables.CLUBE_POSSUI_PESSOA);

		for (Object obj : lo) {
			ClubePossuiPessoa cpPessoa = (ClubePossuiPessoa) obj;
			System.out.println(cpPessoa.toString());
		}
		
	}
	
}
