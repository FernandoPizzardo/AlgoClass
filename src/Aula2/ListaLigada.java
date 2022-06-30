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
        if(this.totalElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeiro = nova;
            this.ultimo = nova;
        }else {
            Celula nova = new Celula(elemento, this.primeiro);
            this.primeiro.setAnterior(nova);
            this.primeiro = nova;

        }

        this.totalElementos++;

    }
    public void add(Object elemento){
        if (this.totalElementos == 0){
            addFirst(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultimo.setProximo(nova);
            nova.setAnterior(this.ultimo);
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
            Celula proxima = anterior.getProximo();
            Celula nova = new Celula(elemento, anterior.getProximo());
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.totalElementos++;
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
    public void removeLast(){
        if(totalElementos == 1){
            this.removeFirst();
        } else {
            Celula penultima = this.ultimo.getAnterior();
            penultima.setProximo(null);
            this.ultimo = penultima;
            this.totalElementos--;
        }
    }
    public void remove(int posicao){
        if(posicao == 0){
            this.removeFirst();
        } else if (posicao == this.totalElementos - 1) {
            this.removeLast();
        }
        else {
            Celula anterior = this.fetchCelula(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.totalElementos--;
        }
    }
    public int tamanho() {return 0;}
    public boolean contem(Object o) {return false;}
}
