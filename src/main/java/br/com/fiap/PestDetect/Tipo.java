package br.com.fiap.PestDetect;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;

    private String tipo;
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_pestes")
    private Peste peste;
}
