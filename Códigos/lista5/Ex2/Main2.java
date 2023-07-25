package Ex2;

import ListaSingular.*;

public class Main2 {
    public static void main(String[] args) {
        
        ListaCircular l1 = new ListaCircular();
        ListaCircular l2 = new ListaCircular();
        int i = 0;
        
        for (; i < 5; i++)
            l1.insere(i);
        
        for (; i < 10; i++) 
            l2.insere(i);
            
        l1.imprime();
        l2.imprime();

        ListaCircular l3 = l1.merge(l2);

        l3.imprime();

    }
}
