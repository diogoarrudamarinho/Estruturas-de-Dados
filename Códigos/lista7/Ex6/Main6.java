package Ex6;

import Arvore.Arvbin;

public class Main6 {
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

        Arvbin<Integer>
            b1 = new Arvbin<Integer>(100),
            b2 = new Arvbin<Integer>(100),
            b3 = new Arvbin<Integer>(100);

        b1.defineEsq(b2);
        b2.defineEsq(b3);

        System.out.println(a1.eBalanceada());
        System.out.println(b1.eBalanceada());
    }
    
}
