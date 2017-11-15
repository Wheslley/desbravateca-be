package br.com.sisbrava.teste;

import br.com.sisbrava.bean.TipoEvento;
import br.com.sisbrava.repository.TipoEventoRepository;

public class TesteTipoEvento {
	
	public static void main(String[] args) {
		
		TipoEvento tevento = new TipoEvento();
		tevento.setDescricao("Camporee");
		
		TipoEventoRepository.getInstance().insert(tevento);
		
	}
	
}
