package com.project.cybernexus.models;

import com.project.cybernexus.enums.TipoTreinamentoEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_TREINAMENTO")
public class TreinamentoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
