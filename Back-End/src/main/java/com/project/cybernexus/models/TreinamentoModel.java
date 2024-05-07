package com.project.cybernexus.models;

import com.project.cybernexus.enums.TipoTreinamentoEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_TREINAMENTO")
public class TreinamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;
    @Column
    private String tituloAula;
    @Column
    private String videoAula;
    @Column
    private TipoTreinamentoEnum tipoTreinamentoEnum;
}
