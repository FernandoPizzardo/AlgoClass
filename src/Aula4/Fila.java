package Aula4;

import java.util.LinkedList;
import java.util.List;

public class Fila {
    private List<String> alunos = new LinkedList<>();


    @Override
    public String toString() {
        return "Fila{" +
                "alunos=" + alunos +
                '}';
    }

    public void add(String aluno){
        alunos.add(aluno);
    }
    public String remove(){
        return alunos.remove(0);
    }

    public boolean vazia(){
        return alunos.isEmpty();
    }
}
