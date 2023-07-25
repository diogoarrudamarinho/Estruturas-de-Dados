package Ex6;

import Conjunto.ConjGenerico;

public class Main6 {
    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> conj3 = new ConjGenerico<>();

        for (int i = 0; i < 10; i++) {
           conj1.insere(i);
           conj2.insere(i); 
        }

        for (int i = 0; i < 15; i++) 
            conj3.insere(i);
        
        System.out.println(conj1.eIgualRecursivo(conj2));
        System.out.println(conj1.eIgualRecursivo(conj3));
    }
}
