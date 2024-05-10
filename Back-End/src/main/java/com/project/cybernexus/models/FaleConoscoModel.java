package com.project.cybernexus.models;

import com.project.cybernexus.enums.StatusEmailEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "TB_FALE_CONOSCO")
public class FaleConoscoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    @Column
    private String nomeCompletoRemetente;
    @Column
    private String emailRemetente;
    @Column
    private String matriculaRemetente;
    @Column
    private String telefoneRemetente;
    @Column
    private String assuntoEmail;
    @Column(columnDefinition = "TEXT")
    private String menssagemEmail;
    @Column
    private String nomeAnexosEmail;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] anexosEmail;
    @Column
    private String emailDestinatario = "cyberneexus@gmail.com";
    @Column(columnDefinition = "DATE")
    private LocalDateTime dataEnvioEmail;
    @Column
    private StatusEmailEnum statusEmailEnum;
}