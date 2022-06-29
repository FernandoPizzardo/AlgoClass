package Aula1;

import java.util.Objects;

public class Aluno {
    private String nome;

    public Aluno(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Aula1.Aluno{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Aluno outro = (Aluno) o;
        return outro.getNome().equals(this.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
