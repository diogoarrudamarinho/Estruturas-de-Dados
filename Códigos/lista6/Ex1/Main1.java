import Conjunto.ConjGenerico;

public class Main1 {
    
    public static void main(String[] args) {

        ConjGenerico<Integer> conj = new ConjGenerico<>();

        conj.insere(20);
        conj.insere(10);
        conj.insere(50);
        conj.insere(1);

        System.out.println(conj.retornaMenor());
        System.out.println(conj.retornaMaior());

        conj.remove(50);
        System.out.println(conj.retornaMaior());

    }
}
