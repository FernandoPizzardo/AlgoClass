package Aula1;

import Aula1.Aluno;

import java.util.Arrays;

public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int totalAlunos = 0;

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < totalAlunos;
    }
    private void garanteEspaco(){
        if(totalAlunos == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];

            }
            this.alunos = novoArray;
        }
    }
    public void add(Aluno aluno){
       this.alunos[totalAlunos] = aluno;
       totalAlunos++;
        }

    public Aluno pega(int posicao){
        if(posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        return alunos[posicao];
    }
    public void remove(int posicao){
        for (int i = posicao; i < this.totalAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
        }
        totalAlunos--;

    }
    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= totalAlunos;
    }

    public void add(int posicao, Aluno aluno){
        this.garanteEspaco();
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Deu ruim! Posição fora do alcance");
        }
        for (int i = totalAlunos - 1; i >= posicao; i-=1) {
            alunos[i+1] = alunos[i];

        }
        alunos[posicao] = aluno;
        totalAlunos++;

    }
    public boolean contem(Aluno aluno){
        for (int i = 0; i < totalAlunos; i++) {
            if(aluno.equals(alunos[i])) return true;

        }
        return false;
    }

    public int tamanho() {
        return totalAlunos;
    }

    public String toString(){
        return Arrays.toString(alunos);
    }
}
