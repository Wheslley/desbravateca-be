package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Cep;
import br.com.sisbrava.bean.Evento;
import br.com.sisbrava.bean.EventoPossuiCep;
import br.com.sisbrava.repository.CepRepository;
import br.com.sisbrava.repository.EventoPossuiCepRepository;
import br.com.sisbrava.repository.EventoRepository;

public class TesteEventoPossuiCep {
	
	public static void main(String[] args) {
		
		Cep cep = (Cep) CepRepository.getInstance().getSelectOneObject(1);
		Evento evento = (Evento) EventoRepository.getInstance().getSelectOneObject(1);
		EventoPossuiCep epcep = new EventoPossuiCep();
		epcep.setCep(cep);
		epcep.setEvento(evento);
		EventoPossuiCepRepository.getInstance().insert(epcep);
		
		
	}
}
