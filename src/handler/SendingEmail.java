package handler;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendingEmail {
	@SuppressWarnings("deprecation")
	public static void email1(String subject, String message, String emailTo) {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");  
			email.setSSL(true);
			email.setAuthentication("pacleonardo97@gmail.com","Guga983838753a");  
			email.addTo(emailTo); //pode ser qualquer email  
			email.setFrom("pacleonardo97@gmail.com"); //ser� passado o email que voc� far� a autentica��o
			email.setSubject(subject);  
			email.setMsg(message);  
			email.send();  
			
		} catch (EmailException e) {

			e.printStackTrace();
		}
	}
}
