package Ex2;

import ListaSingular.*;

public class Main2 {

    public static void main(String[] args) {

        ListaOrdenada lista1 = new ListaOrdenada();
        ListaOrdenada lista2 = new ListaOrdenada();
        ListaOrdenada listaConcatenada = new ListaOrdenada();
        int i;

        for (i = 0; i < 3; i++) {
            lista1.insere(i);   
        }

        for (; i < 6; i++) {
            lista2.insere(i);
        }

        lista1.imprime();
        lista2.imprime();
        listaConcatenada = lista2.concatenaListas(lista1);

        listaConcatenada.imprime();
    }
}
