package com.project.cybernexus.services;

import com.project.cybernexus.enums.StatusEmailEnum;
import com.project.cybernexus.models.FaleConoscoModel;
import com.project.cybernexus.repositories.FaleConoscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FaleConoscoService {

    @Autowired
    private FaleConoscoRepository faleConoscoRepository;

    @Autowired
    private JavaMailSender faleConoscoSender;

    public FaleConoscoModel enviarEmail(FaleConoscoModel faleConoscoModel){
        faleConoscoModel.setDataEnvioEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(faleConoscoModel.getEmailRemetente());
            message.setTo(faleConoscoModel.getEmailDestinatario());
            message.setSubject(faleConoscoModel.getTitulo());
            message.setText(faleConoscoModel.getCorpo());
            faleConoscoSender.send(message);

            faleConoscoModel.setStatusEmailEnum(StatusEmailEnum.SENT);

        }catch (MailException e){
            faleConoscoModel.setStatusEmailEnum(StatusEmailEnum.ERROR);
        }finally {
            return faleConoscoRepository.save(faleConoscoModel);
        }
    }
}
