package Ex5;
import Conjunto.ConjGenerico;

public class Main5 {
    public static void main(String[] args) {

        ConjGenerico<Integer> conj1= new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(2);
        conj1.insere(4);
        conj1.insere(5);
        conj1.insere(6);
        conj1.insere(7);
            
        conj2.insere(1);
        conj2.insere(2);
        conj2.insere(3);
        conj2.insere(4);
        conj2.insere(5);
        conj2.insere(6);

        ConjGenerico<Integer> dif = conj1.diferenca(conj2);
        ConjGenerico<Integer> dif2 = conj2.diferenca(conj1);

        dif.imprime();
        dif2.imprime();
    }
}
