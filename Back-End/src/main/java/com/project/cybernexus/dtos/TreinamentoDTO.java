package com.project.cybernexus.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TreinamentoDTO {

    @NotBlank
    private String tituloAula;
    @NotBlank
    private String videoAula;
}
