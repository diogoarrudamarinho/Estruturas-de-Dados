package Ex3;

import Arvore.Arvbin;

public class Main3 {
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
        b1.defineDir(b3);

        Arvbin<Integer>
            c1 = new Arvbin<Integer>(10),
            c2 = new Arvbin<Integer>(20),
            c3 = new Arvbin<Integer>(30),
            c4 = new Arvbin<Integer>(40),
            c5 = new Arvbin<Integer>(50),
            c6 = new Arvbin<Integer>(60);
 
        c1.defineEsq(c2);
        c1.defineDir(c3);

        c2.defineDir(c4);

        c3.defineEsq(c5);
        c3.defineDir(c6); 

        Arvbin<Integer>
            d1 = new Arvbin<Integer>(null),
            d2 = new Arvbin<Integer>(null);
            
        System.out.println(a1.eSimilar(c1));
        System.out.println(a1.eSimilar(b1));
        System.out.println(d1.eSimilar(d2));
        
    }
}
