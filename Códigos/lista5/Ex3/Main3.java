package Ex3;

import ListaSingular.*;

public class Main3 {
    public static void main(String[] args) {
        
        ListaCircular lista = new ListaCircular();

        for (int i = 0; i < 6; i++)
            lista.insere(i);

        lista.imprime();
        lista.inverteLista();
        lista.imprime();
        
    }
}
