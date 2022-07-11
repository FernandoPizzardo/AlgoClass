package Aula6;

public class TesteProduto {
    public static void main(String[] args) {


        Produto[] produtos = new Produto[4];
        produtos[0] = new  Produto(" PONTO G", 455555);
        produtos[1] = new Produto("Lamborghini", 10000);
        produtos[3] = new Produto("Ford k", 5444);
        produtos[2] = new Produto("Faustão", 6777);

        int maisBarato = 0;

        maisBarato = getMaisBarato(produtos, maisBarato, 0, 2);

        System.out.println("o mais barato é o " + produtos[maisBarato].getNome() + " seu pão duro!");

    }

    private static int getMaisBarato(Produto[] produtos, int maisBarato, int inicio, int termino) {
        for (int i = inicio; i < termino; i++) {
            if (produtos[i].getPreco() < produtos[maisBarato].getPreco()){
                maisBarato = i;
            }
        }
        return maisBarato;
    }
}
