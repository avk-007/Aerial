package com.Flight_Reservation_app.Utilities;

import org.springframework.stereotype.Component;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("ITINERARY OF FLIGHT");
			messageHelper.setText("Please Find The Attached");
			messageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
