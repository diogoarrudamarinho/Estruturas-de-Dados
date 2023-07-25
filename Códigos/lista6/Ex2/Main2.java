package Ex2;

import Conjunto.ConjGenerico;

public class Main2 {
    public static void main(String[] args) {

        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> conj3 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(2);
        conj1.insere(4);
        conj1.insere(5);
        conj1.insere(6);
        //conj1.insere(7);
            
        conj2.insere(1);
        conj2.insere(2);
        conj2.insere(3);
        conj2.insere(4);
        conj2.insere(5);
        conj2.insere(6);

        conj3.insere(1);
        conj3.insere(2);
        conj3.insere(4);
        conj3.insere(5);
        conj3.insere(6);
        
        System.out.println(conj1.eIgual(conj2));
        System.out.println(conj1.eIgual(conj3));
    }
}
