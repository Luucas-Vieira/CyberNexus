package com.project.cybernexus.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
public class FaleConoscoDTO {

    @NotBlank
    private String nomeCompletoRemetente;
    @NotBlank
    private String emailRemetente;
    @NotBlank
    private String matriculaRemetente;
    private String telefoneRemetente;
    @NotBlank
    private String assuntoEmail;
    @NotBlank
    private String menssagemEmail;
    private List<MultipartFile> anexosEmail;
}
