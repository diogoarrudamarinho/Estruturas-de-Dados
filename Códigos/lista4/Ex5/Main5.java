package Ex5;

import ListaSingularGenerica.*;

public class Main5 {
    public static void main(String[] args) {
        
        ListaGenerica<Character> lista = new ListaGenerica<>();

        /*
         * Como o metodo insere() insere no 1° Elemento, 
         * Eu fiz um metodo para inserir no final, 
         * assim, a frase fica na mesma posicao original na inserção
         * 
         */

        String teste = "to ficando maluco";

        for (int i = 0; i < teste.length(); i++)
            lista.insereNaFrente(teste.charAt(i));    

        lista.imprime();
        lista.inverteFrase();
        lista.imprime();
    }
}
