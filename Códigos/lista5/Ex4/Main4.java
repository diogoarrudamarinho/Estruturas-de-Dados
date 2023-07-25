package Ex4;

import ListaDupla.*;

public class Main4 {
    public static void main(String[] args) {
        
        ListaDuplamente lista = new ListaDuplamente();

        for (int i = 5; i >= 0; i--)
            lista.insere(i);
    
        lista.imprime();
        lista.trocaElos(5, 3);
        lista.imprime();


    }
}
