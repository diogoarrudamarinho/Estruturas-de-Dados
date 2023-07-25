package Ex3;
import Conjunto.ConjGenerico;

public class Main3 {
    public static void main(String[] args) {

        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> conj3 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(2);
        conj1.insere(3);
        conj1.insere(4);
        conj1.insere(5);
        conj1.insere(6);
        conj1.insere(7);

        conj2.insere(1);
        conj2.insere(2);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(6);

        conj3.insere(1);
        conj3.insere(2);
        conj3.insere(3);
        conj3.insere(4);
        conj3.insere(7);
        conj3.insere(9);

        ConjGenerico<Integer> conjcomp1;

            try{

                conjcomp1 = conj2.complementar(conj1);
                conjcomp1.imprime(); 
            } catch (Exception e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        
            try {
                
                ConjGenerico<Integer> conjcomp2 = conj3.complementar(conj1);
                conjcomp2.imprime(); 
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }    
    }
}
