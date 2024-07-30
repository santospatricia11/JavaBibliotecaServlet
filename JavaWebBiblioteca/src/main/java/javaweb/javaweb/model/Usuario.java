package javaweb.javaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;

    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario logger = (Usuario) o; // Faz o cast para Logger
        return Objects.equals(email, logger.email) && Objects.equals(password, logger.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);

    }
}