package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Evento;
import br.com.sisbrava.bean.EventoNotificacaoUsuario;
import br.com.sisbrava.bean.Notificacao;
import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.repository.EventoNotificacaoUsuarioRepository;
import br.com.sisbrava.repository.EventoRepository;
import br.com.sisbrava.repository.NotificacaoRepository;
import br.com.sisbrava.repository.UsuarioRepository;

public class TesteEventoNotificacaoUsuario {
	
	public static void main(String[] args) {
		
		Usuario usuario = (Usuario) UsuarioRepository.getInstance().getSelectOneObject(1);
		Evento evento = (Evento) EventoRepository.getInstance().getSelectOneObject(1);
		Notificacao notificacao = (Notificacao) NotificacaoRepository.getInstance().getSelectOneObject(1);
		
		EventoNotificacaoUsuario enusuario = new EventoNotificacaoUsuario();
		enusuario.setEvento(evento);
		enusuario.setNotificacao(notificacao);
		enusuario.setUsuario(usuario);
		
		EventoNotificacaoUsuarioRepository.getInstance().insert(enusuario);
		
	}
}
