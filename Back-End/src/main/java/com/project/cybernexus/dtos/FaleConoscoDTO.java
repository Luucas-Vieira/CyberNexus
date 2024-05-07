package com.project.cybernexus.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FaleConoscoDTO {
    @NotBlank
    private String emailRemetente;

    private String numeroRemetente;

    private Long matriculaRemetente;
    @NotBlank
    private String titulo;
    @NotBlank
    private String corpo;
    private String anexo;

}

