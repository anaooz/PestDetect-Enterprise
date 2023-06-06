package br.com.fiap.PestDetect;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Peste")
public class Peste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pestes;

    private String nomePopular;
    private String nomeCientifico;
    private String metodoDeControle;

    @ManyToOne
    @JoinColumn(name = "id_cadastro")
    private Cadastro cadastro;

    @OneToMany(mappedBy = "peste")
    private List<Tipo> tipos;

    @OneToMany(mappedBy = "peste")
    private List<Imagem> imagens;
}
