package br.com.sisbrava.teste;

import br.com.sisbrava.utilidades.EmailNotification;

public class TesteSendEmail {
	
	public static void main(String[] args) {
		
		EmailNotification mail = new EmailNotification();
		
		mail.envioEmailCadastroLogin("jady_bd@gmail.com", "Jady");
		
	}
	
}
