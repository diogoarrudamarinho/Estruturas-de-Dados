package list2.Ex2;

import list2.Filas.Fila;

public class Ex2Main {

    public static void main(String[] args) {

        Fila f1 = new   Fila(3);
        Fila f2 = new   Fila(5);
        int i = 0;
        for(i = 0; i < 3; i++){

            f1.insere(i);
        }

        for(; i < 8; i++){

            f2.insere(i);
        }

        f1.imprime();
        System.out.println();
        f2.imprime();
        System.out.println();

        f1.alternarFila(f2);
    }
}

