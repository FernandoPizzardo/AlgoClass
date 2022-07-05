package Aula5;

import java.util.LinkedList;
import java.util.List;

public class Conjunto {
    private LinkedList<LinkedList<String>> tabela = new LinkedList<LinkedList<String>>();

    public Conjunto(){
        for (int i = 0; i < 26; i++) {
            tabela.add(new LinkedList<String>());
        }
    }
    public void add(String palavra){
        int index = calculaIndexTable(palavra);
        List<String> lista = tabela.get(index);
        lista.add(palavra);
    }

    public void remove(String palavra){
        if(!contem(palavra)){
            int index = calculaIndexTable(palavra);
            List<String> list = tabela.get(index);
            list.remove(palavra);
        }
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "tabela=" + tabela +
                '}';
    }

    private boolean contem(String palavra){
        int index = calculaIndexTable(palavra);
        return tabela.get(index).contains(palavra);
    }

    private int calculaIndexTable(String palavra) {
        return palavra.toLowerCase().charAt(0) % 26;
    }
}
