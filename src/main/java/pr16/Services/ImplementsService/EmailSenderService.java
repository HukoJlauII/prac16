package pr16.Services.ImplementsService;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class EmailSenderService implements pr16.Services.EmailSenderService {

    private JavaMailSender mailSender;

    @Override
    public void sendMail(String text) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("nikpuk637@gmail.com");
        mailMessage.setText(text);
        mailMessage.setSubject("Test message");
        mailSender.send(mailMessage);
    }
}
