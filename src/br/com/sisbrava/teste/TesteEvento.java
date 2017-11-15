package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Evento;
import br.com.sisbrava.bean.TipoEvento;
import br.com.sisbrava.repository.EventoRepository;
import br.com.sisbrava.repository.TipoEventoRepository;

public class TesteEvento {
	
	public static void main(String[] args) {
		
		TipoEvento tevento = (TipoEvento) TipoEventoRepository.getInstance().getSelectOneObject(1);
		Evento evento = new Evento();
		evento.setDescricao("Cronograma 2017");
		evento.setTevento(tevento);
		evento.setTaxa(110.80);
		EventoRepository.getInstance().insert(evento);
		
	}
}
