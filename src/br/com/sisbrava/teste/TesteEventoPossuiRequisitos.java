package br.com.sisbrava.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.sisbrava.bean.Evento;
import br.com.sisbrava.bean.EventoPossuiRequisitos;
import br.com.sisbrava.bean.Requisitos;
import br.com.sisbrava.repository.EventoPossuiRequisitosRepository;
import br.com.sisbrava.repository.EventoRepository;
import br.com.sisbrava.repository.RequisitosRepository;

public class TesteEventoPossuiRequisitos {

	public static void main(String[] args) {

		Evento evento = (Evento) EventoRepository.getInstance().getSelectOneObject(1);
		List<Requisitos> lista = new ArrayList<>();
		lista.add((Requisitos) RequisitosRepository.getInstance().getSelectOneObject(1));
		lista.add((Requisitos) RequisitosRepository.getInstance().getSelectOneObject(2));

		for (Requisitos r : lista) {
		
			EventoPossuiRequisitos eprequisitos = new EventoPossuiRequisitos();
			eprequisitos.setEvento(evento);
			eprequisitos.setRequisitos(r);
			
			EventoPossuiRequisitosRepository.getInstance().insert(eprequisitos);

		}

	}
}
