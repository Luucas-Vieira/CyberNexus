package com.project.cybernexus.services;

import com.project.cybernexus.dtos.FaleConoscoDTO;
import com.project.cybernexus.enums.StatusEmailEnum;
import com.project.cybernexus.models.FaleConoscoModel;
import com.project.cybernexus.repositories.FaleConoscoRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FaleConoscoService {

    @Autowired
    private FaleConoscoRepository faleConoscoRepository;

    @Autowired
    private JavaMailSender faleConoscoSender;

    public void enviarEmail(FaleConoscoDTO faleConoscoDTO, List<MultipartFile> anexos){
        FaleConoscoModel faleConoscoModel = new FaleConoscoModel();
        BeanUtils.copyProperties(faleConoscoDTO, faleConoscoModel);
        faleConoscoModel.setDataEnvioEmail(LocalDateTime.now());
        try {
            MimeMessage message = faleConoscoSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(faleConoscoModel.getEmailRemetente(), faleConoscoModel.getNomeCompletoRemetente());
            helper.setTo(faleConoscoModel.getEmailDestinatario());
            helper.setSubject(faleConoscoModel.getAssuntoEmail());
            helper.setText("Matricula: "+ faleConoscoModel.getMatriculaRemetente() + "\n\n"+ "Telefone/Whatsapp: "+ faleConoscoModel.getTelefoneRemetente() + "\n\n\n\n" + faleConoscoModel.getMenssagemEmail());
            helper.setReplyTo(faleConoscoModel.getEmailRemetente(),faleConoscoModel.getNomeCompletoRemetente());

            byte[] anexoBytes = null;
            String nomeOriginalAnexos = null;
            for (MultipartFile anexo : anexos) {
                nomeOriginalAnexos= anexo.getOriginalFilename();
                anexoBytes = anexo.getBytes();
                helper.addAttachment(anexo.getOriginalFilename(), new ByteArrayResource(anexoBytes));
            }
            faleConoscoSender.send(message);
            faleConoscoModel.setNomeAnexosEmail(nomeOriginalAnexos);
            faleConoscoModel.setAnexosEmail(anexoBytes);
            faleConoscoModel.setStatusEmailEnum(StatusEmailEnum.SENT);

        }catch (MailException | IOException e){
            faleConoscoModel.setStatusEmailEnum(StatusEmailEnum.ERROR);
        }finally {

            faleConoscoRepository.save(faleConoscoModel);
            return;
        }
    }




}
