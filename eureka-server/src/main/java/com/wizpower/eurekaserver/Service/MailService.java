package com.wizpower.eurekaserver.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String formMail;

    public void sendSimpleMail(String toMail,String subject,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(formMail);
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            sender.send(simpleMailMessage);
            logger.info("发送给" + toMail + "邮件已经发送。 subject：" + subject);
        } catch (Exception e) {
            logger.info("发送给" + toMail + "send mail error subject：" + subject);
            e.printStackTrace();
        }
    }

}
