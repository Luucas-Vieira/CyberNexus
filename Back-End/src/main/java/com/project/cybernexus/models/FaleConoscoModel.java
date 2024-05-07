package com.project.cybernexus.models;
import com.project.cybernexus.enums.StatusEmailEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_FALE_CONOSCO")
public class FaleConoscoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    @Column
    private String RefRemetente;
    @Column
    private String emailRemetente;
    @Column
    private String numeroRemetente;
    @Column
    private Long matriculaRemetente;
    @Column
    private String emailDestinatario = "cyberneexus@gmail.com";
    @Column
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String corpo;
    @Column
    private String anexo;
    @Column(columnDefinition = "DATE")
    private LocalDateTime dataEnvioEmail;
    @Column
    private StatusEmailEnum statusEmailEnum;
}
