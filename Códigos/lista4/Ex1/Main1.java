package Ex1;

import ListaSingular.Lista;

public class Main1 {

    /* O método tamanho está na melhor complexidade possivel, ja que para calcula-la
     * é preciso percorrer a lista toda.
     * 
     * Mas, para gerar um metodo O(1), seria necesario um Time Memory Tradeoff, ou seja
     * consumir mais memoria para ganhar eficiencia, como na variavel tamanho na lista
     * 
     */

    public static void main(String[] args) {

        Lista lista = new Lista();

        for (int i = 0; i < 5; i++)
            lista.insere(i);

        System.out.println(lista.getTamanho());    
        
    }

    
    
}
