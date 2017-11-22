package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Especialidades;
import br.com.sisbrava.bean.Pessoa;
import br.com.sisbrava.bean.PessoaPossuiEspecialidade;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.EspecialidadesRepository;
import br.com.sisbrava.repository.PessoaPossuiEspecialidadeRepository;
import br.com.sisbrava.repository.PessoaRepository;

public class TestePessoaPossuiEspecialidade {
	
	public static void main(String[] args) {
		
		Pessoa pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		Especialidades especialidade = (Especialidades) EspecialidadesRepository.getInstance().getSelectOneObject(1);
		
		PessoaPossuiEspecialidade ppEspecialidade = new PessoaPossuiEspecialidade();
		ppEspecialidade.setEspecialidade(especialidade);
		ppEspecialidade.setPessoa(pessoa);
		ppEspecialidade.setStatus(2);
		ppEspecialidade.setNota(8.5);
		
		PessoaPossuiEspecialidadeRepository.getInstance().insert(ppEspecialidade);
		
		pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		especialidade = (Especialidades) EspecialidadesRepository.getInstance().getSelectOneObject(3);
		
		ppEspecialidade = new PessoaPossuiEspecialidade();
		ppEspecialidade.setEspecialidade(especialidade);
		ppEspecialidade.setPessoa(pessoa);
		ppEspecialidade.setStatus(2);
		ppEspecialidade.setNota(8.5);
		
		PessoaPossuiEspecialidadeRepository.getInstance().insert(ppEspecialidade);
		
		pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		especialidade = (Especialidades) EspecialidadesRepository.getInstance().getSelectOneObject(4);
		
		ppEspecialidade = new PessoaPossuiEspecialidade();
		ppEspecialidade.setEspecialidade(especialidade);
		ppEspecialidade.setPessoa(pessoa);
		ppEspecialidade.setStatus(2);
		ppEspecialidade.setNota(8.5);
		
		PessoaPossuiEspecialidadeRepository.getInstance().insert(ppEspecialidade);
		
		pessoa = (Pessoa) PessoaRepository.getInstance().getSelectOneObject(1);
		especialidade = (Especialidades) EspecialidadesRepository.getInstance().getSelectOneObject(5);
		
		ppEspecialidade = new PessoaPossuiEspecialidade();
		ppEspecialidade.setEspecialidade(especialidade);
		ppEspecialidade.setPessoa(pessoa);
		ppEspecialidade.setStatus(2);
		ppEspecialidade.setNota(8.5);
		
		PessoaPossuiEspecialidadeRepository.getInstance().insert(ppEspecialidade);
		
		List<Object> lista = (List<Object>) PessoaPossuiEspecialidadeRepository.getInstance()
				.selectMultiplusObjects(ITables.PESSOA_POSSUI_ESPECIALIDADE);

		for (Object obj : lista) {
			ppEspecialidade = (PessoaPossuiEspecialidade) obj;
			System.out.println(ppEspecialidade.toString());
		}
		
	}
}
