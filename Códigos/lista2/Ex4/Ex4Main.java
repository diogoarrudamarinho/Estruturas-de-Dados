package list2.Ex4;

import list2.Filas.Fila;
import list2.Filas.FilaDupla;

public class Ex4Main {

    public static void main(String[] args) {

        Fila fila = new Fila(10);

        for (int i = 0; i < 10; i++) {

            fila.insere(i);
            
        }

        FilaDupla filaDupla = FilaDupla.retornaFilaDupla(fila);

        filaDupla.imprime();

        
    }
    
    

    
}
