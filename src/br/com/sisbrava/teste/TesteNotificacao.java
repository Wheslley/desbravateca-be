package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Notificacao;
import br.com.sisbrava.repository.NotificacaoRepository;

public class TesteNotificacao {
	
	public static void main(String[] args) {
		
		Notificacao notificacao = new Notificacao();
		notificacao.setDescricao("Testando Notificacao");
		
		NotificacaoRepository.getInstance().insert(notificacao);
		
	}
	
}
