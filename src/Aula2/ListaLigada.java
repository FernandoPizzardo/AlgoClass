package Aula2;

public class ListaLigada {
    private Celula primeiro = null;
    private Celula ultimo = null;

    @Override
    public String toString() {
        if (this.totalElementos == 0) {
            return "[]";
        }
        Celula atual = primeiro;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < totalElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }
        builder.append("]");

        return builder.toString();
    }

    private int totalElementos = 0;

    public void addFirst(Object elemento){
        Celula nova = new Celula(elemento, primeiro);
        this.primeiro = nova;
        if (this.totalElementos == 0) this.ultimo = this.primeiro;
        this.totalElementos++;

    }
    public void add(Object elemento){
        if (this.totalElementos == 0){
            addFirst(elemento);
        } else {
            Celula nova = new Celula(elemento, null);
            this.ultimo.setProximo(nova);
            this.ultimo = nova;
            this.totalElementos++;
        }

    }
    private boolean posicaoOcupada(int posicao){
       return posicao >= 0 && posicao < this.totalElementos;
    }
    private Celula fetchCelula(int posicao){
        Celula atual = primeiro;

        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Fora do range");
        }

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }
    public void add(int posicao, Object elemento){
        if (posicao == 0){
            addFirst(elemento);
        }else if (posicao == this.totalElementos){
            add(elemento);
        }else {
            Celula anterior = this.fetchCelula(posicao - 1);
            Celula nova = new Celula(elemento, anterior.getProximo());
            anterior.setProximo(nova);
        }

    }
    public Object pega(int posicao){
        return this.fetchCelula(posicao).getElemento();
    }
    public void removeFirst(){
        if(this.totalElementos == 0){
            throw new IllegalArgumentException("Lista vazia");
        }
        this.primeiro = this.primeiro.getProximo();
        this.totalElementos--;

        if(this.totalElementos == 0){
            this.ultimo = null;
        }
    }
    public void remove(int posicao){}
    public int tamanho() {return 0;}
    public boolean contem(Object o) {return false;}
}
