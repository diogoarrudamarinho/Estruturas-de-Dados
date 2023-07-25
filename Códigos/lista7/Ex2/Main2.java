package Ex2;

import Arvore.Arvbin;

public class Main2 {
    public static void main(String[] args) {

        Arvbin<Integer> 
            a1 = new Arvbin<Integer>(1),
            a2 = new Arvbin<Integer>(2),
            a3 = new Arvbin<Integer>(3),
            a4 = new Arvbin<Integer>(4),
            a5 = new Arvbin<Integer>(5),
            a6 = new Arvbin<Integer>(6);

        a1.defineEsq(a2);
        a1.defineDir(a3);

        a2.defineDir(a4);

        a3.defineEsq(a5);
        a3.defineDir(a6); 

        System.out.println("Soma = " + Arvbin.retornaSomaSubArvore(a1));
        
    }
}
