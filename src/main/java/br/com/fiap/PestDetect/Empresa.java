package br.com.fiap.PestDetect;

import br.com.fiap.valueObjects.CNPJ;
import br.com.fiap.valueObjects.Login;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empresa;
    private String razaoSocial;
    @Embedded
    private CNPJ CNPJ;
    @Embedded
    private Login login;

    @OneToMany(mappedBy = "empresa")
    private List<Cadastro> cadastros;

}
