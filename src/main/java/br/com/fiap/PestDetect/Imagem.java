package br.com.fiap.PestDetect;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Imagem")
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_imagem;

    private String nomeImg;

    @ManyToOne
    @JoinColumn(name = "id_pestes")
    private Peste peste;
}
