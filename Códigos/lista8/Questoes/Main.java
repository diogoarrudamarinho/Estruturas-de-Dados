package Questoes;

import FilaPrioridade.*;
import Arvore.Arvbin;

public class Main {

    public static void main(String[] args) {
        
        int[] vetor = {22, 4, 35, 12, 3, 18, 12, 55};

        int[] vetorHeapMaxima = {0, 55, 22, 35, 12, 3, 18, 12, 4};

        HeapBinariaMaxima heapMaxima = new HeapBinariaMaxima(8, vetor);
        HeapBinariaMinima heapMinima = new HeapBinariaMinima(8, vetor);

        heapMaxima.imprime();
        heapMinima.imprime();
        System.out.println();

        HeapBinariaMaxima hmax = new HeapBinariaMaxima(heapMinima);
        HeapBinariaMinima hmin = new HeapBinariaMinima(heapMaxima);

        hmax.imprime();
        hmin.imprime();

        System.out.println(heapMaxima.verificaPropriedadeHeap(vetor));
        System.out.println(heapMaxima.verificaPropriedadeHeap(vetorHeapMaxima));

        System.out.println(heapMaxima.remove(0));
        System.out.println(heapMaxima.remove(9));

        System.out.println(heapMaxima.remove(4));
        heapMaxima.imprime();

        Arvbin<Integer> 
            a1 = new Arvbin<Integer>(1),
            a2 = new Arvbin<Integer>(2),
            a3 = new Arvbin<Integer>(3),
            a4 = new Arvbin<Integer>(4),
            a5 = new Arvbin<Integer>(5),
            a6 = new Arvbin<Integer>(6);

        a1.defineEsq(a2);
        a1.defineDir(a3);

        a2.defineEsq(a4);
        a2.defineDir(a5);

        a3.defineEsq(a6); 

        a1.imprimePreOrdem();
        heapMaxima.transformaHeapMaxima(a1);
        System.out.println();
        a1.imprimePreOrdem();

    }
}
