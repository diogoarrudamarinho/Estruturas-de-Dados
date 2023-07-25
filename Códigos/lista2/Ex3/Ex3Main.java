package list2.Ex3;
import list2.Filas.*;

public class Ex3Main {

    public static void main(String[] args) {
        
        int tam = 10;
        int tam2 = 5;

        //Fila de fila
        FilaDeFila<Fila> filaDeFila = new FilaDeFila<>(tam);
        
        for (int i = 0; i < tam; i++) {

            Fila fila = new Fila(tam2);

            for (int j = 0; j < tam2; j++) {
                
                fila.insere(j);
                
            }

            filaDeFila.insere(fila);
            
        }

        filaDeFila.imprime();
        System.out.println();

        //Fila de Pilha
        FilaDePilhas<Pilha> filaDePilhas = new FilaDePilhas<>(tam);
        
        for (int i = 0; i < tam; i++) {

            Pilha pilha = new Pilha(tam2);

            for (int j = 97; j < tam2 + 97; j++) {
                
                pilha.push((char)j);
                
            }

            filaDePilhas.insere(pilha);
            
        }

        filaDePilhas.imprime();
        System.out.println();

        //Pilha de Filas
        PilhaDeFilas<Fila> PilhaDeFilas = new PilhaDeFilas<>(tam);
        
        for (int i = 0; i < tam; i++) {

            Fila fila2 = new Fila(tam2);

            for (int j = 0; j < tam2; j++) {
                
                fila2.insere(j);
                
            }

            PilhaDeFilas.push(fila2);
            
        }

        
        while (!PilhaDeFilas.vazia()) {
            System.out.println(PilhaDeFilas.pop());
        }
        
    }
    
}
