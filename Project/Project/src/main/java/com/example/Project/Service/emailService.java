//package com.example.Project.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import com.example.Project.Entity.smtpEntiy;
//import com.example.Project.repo.emailrepo;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//@Service
//
//public class emailService {
//	@Autowired JavaMailSender sender;
//    @Autowired emailrepo repo;
//
//public String sendEmail(String receiver, String subject, String content) {
//	 
//		try
//		{
//			MimeMessage msg = sender.createMimeMessage();
//			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
//			msgHelper.setTo(receiver);
//			msgHelper.setSubject(subject);
//			msgHelper.setText(content);
//			sender.send(msg);
//			
//			smtpEntiy smtp = new smtpEntiy();
//			smtp.setReceiver(receiver);
//			smtp.setSubject(subject);;
//			smtp.setContent(content);
// 
//	        repo.save(smtp);
//			return "Mail sent successfully";
//		}
//		catch(MessagingException e)
//		{
//			return "Mail not sent "+e.getMessage();
//		}
//		
//	}
//
//
//}
//
//
//
//
package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.Project.Entity.smtpEntiy;
import com.example.Project.repo.emailrepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {
	@Autowired 
	private JavaMailSender sender;
	
	@Autowired 
	private emailrepo repo;

	public String sendEmail(String receiver, String subject, String content) {
		try {
			MimeMessage msg = sender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			msgHelper.setFrom("kvenmadhi@gmail.com"); 
			msgHelper.setTo(receiver);
			msgHelper.setSubject(subject);
			msgHelper.setText(content, true); // Enables HTML email support

			sender.send(msg);

			// Store email in DB only if successfully sent
			smtpEntiy smtp = new smtpEntiy();
			smtp.setReceiver(receiver);
			smtp.setSubject(subject);
			smtp.setContent(content);
			repo.save(smtp);

			return "Mail sent successfully";
		} catch (MessagingException e) {
			e.printStackTrace(); // Log error
			return "Mail not sent: " + e.getMessage();
		}
	}
}

