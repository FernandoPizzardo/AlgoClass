package Aula1;

import Aula1.Aluno;
import Aula1.Vetor;

public class VetorTeste {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");
        Aluno a3 = new Aluno("Caçambito");

        Vetor lista = new Vetor();
        lista.add(a1);
        lista.add(a2);
        System.out.println(lista);
        lista.add(1,a3);
        System.out.println(lista);
        lista.remove(1);
        System.out.println(lista);
    }
}
