package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Especialidades;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.EspecialidadesRepository;

public class TesteEspecialidades {

	public static void main(String[] args) {
		
		/*
		Especialidades especialidades = new Especialidades();
		especialidades.setDescricao("ACAMPAMENTO I");
		especialidades.setDificuldade(IDificuldades.FACIL);
		
		EspecialidadesRepository.getInstance().insert(especialidades);		
		
		especialidades = new Especialidades();
		especialidades.setDescricao("ACAMPAMENTO II");
		especialidades.setDificuldade(IDificuldades.FACIL);
		
		EspecialidadesRepository.getInstance().insert(especialidades);
		
		especialidades = new Especialidades();
		especialidades.setDescricao("ACAMPAMENTO III");
		especialidades.setDificuldade(IDificuldades.FACIL);
		
		EspecialidadesRepository.getInstance().insert(especialidades);
		
		especialidades = new Especialidades();
		especialidades.setDescricao("ACAMPAMENTO VI");
		especialidades.setDificuldade(IDificuldades.MEDIO);
		
		EspecialidadesRepository.getInstance().insert(especialidades);
		
		especialidades = new Especialidades();
		especialidades.setDescricao("ACAMPAMENTO V");
		especialidades.setDificuldade(IDificuldades.MEDIO);
		
		EspecialidadesRepository.getInstance().insert(especialidades);
		*/
		
		List<Object> lo = (List<Object>) EspecialidadesRepository.getInstance().selectMultiplusObjects(ITables.ESPECIALIDADES);

		for (Object obj : lo) {
			Especialidades e = (Especialidades) obj;
			System.out.println(e.toString());
		}

	}

}
