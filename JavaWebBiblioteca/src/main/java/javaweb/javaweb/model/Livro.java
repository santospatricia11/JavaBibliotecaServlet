package javaweb.javaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Livro")
public class Livro {
    @Id
    private String isbn;
    private String nome_livro;
    private String categoria;
    private String descricao;
    private int quantidade;
    private String capa;

    public Livro(String isbn, String nome_livro, String categoria, String descricao, int quantidade, String capa) {
        this.isbn = isbn;
        this.nome_livro = nome_livro;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.capa = capa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}