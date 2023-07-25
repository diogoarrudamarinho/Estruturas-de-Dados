package Ex5;

import ListaDupla.*;

public class Main5 {
    public static void main(String[] args) {

        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();
        ListaDuplamente l3 = new ListaDuplamente();

        for (int i = 0; i < 5; i++)
        {
            l1.insere(i);
            l2.insere(i);
            l3.insere(i + 1);
        }

        System.out.println(l1.verificaIgualdade(l2));
        System.out.println(l1.verificaIgualdade(l3));
 
    }
}
