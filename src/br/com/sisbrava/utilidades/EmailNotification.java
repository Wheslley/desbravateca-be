package br.com.sisbrava.utilidades;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotification {
	
	public void envioEmailCadastroLogin(String to, String username) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("enterpriseitsmy@gmail.com","Itsmy2017");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("enterpriseitsmy@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Acesso Desbravateca");
			message.setText("Prezado " + username + " ," +
					"\n\nPara confirmar seu cadastro, favor acessar o link abaixo: " +
					"localhost:8080/desbravateca/");

			Transport.send(message);
			
		} catch (MessagingException e) {
			System.out.println(e.getCause() + " : " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
}
