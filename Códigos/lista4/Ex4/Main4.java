package Ex4;

import ListaSingularGenerica.ListaGenerica;

public class Main4 {

    public static void main(String[] args) {
        
        ListaGenerica<String> lista = new ListaGenerica<String>();
        lista.insereNaFrente("O");
        lista.insereNaFrente("rato");
        lista.insereNaFrente("roeu");
        lista.insereNaFrente("a");
        lista.insereNaFrente("roupa");
        lista.insereNaFrente("do");
        lista.insereNaFrente("rei");
        lista.insereNaFrente("de");
        lista.insereNaFrente("roma");
        lista.insereNaFrente(".");

        lista.imprime();
    }
    
}
