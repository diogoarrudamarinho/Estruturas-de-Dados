
import ListaDupla.*;

public class Main1 {
    public static void main(String[] args) {
   
        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();
        
        l1.insere(0);
        l1.insere(1);
        l1.insere(2);
        l1.insere(3);
        l1.insere(3);

        l2.insere(3);
        l2.insere(4);
        l2.insere(3);
        l2.insere(5);
        l2.insere(6);
        
        ListaDuplamente l3 = l1.intersecao(l2);
        l3.imprime();


    }  
    
   
}
