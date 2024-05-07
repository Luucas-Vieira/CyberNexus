package com.project.cybernexus.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MidiaDTO {

    @NotBlank
    private String Titulo;
    @NotBlank
    private String Conteudo;
}
