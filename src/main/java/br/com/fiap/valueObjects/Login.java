package br.com.fiap.valueObjects;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Embeddable
public class Login {
    private String email;
    private String senha;
}
