package br.com.fiap.PestDetect;

import br.com.fiap.valueObjects.Login;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cadastro")
@NamedQuery(name = "Cadastro.findById", query = "SELECT c FROM Cadastro c WHERE c.id_cadastro =:id")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cadastro;
    private String nome;
    @Embedded
    private Login login;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "cadastro")
    private List<Peste> pestes;
}
