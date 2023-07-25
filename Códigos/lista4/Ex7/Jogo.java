package Ex7;

public class Jogo {

    public static void main(String[] args) {
        
        ListaInimigos listaInimigos = new ListaInimigos();
        Inimigo inimigo1 = new Inimigo(100, 20.0);
        Inimigo inimigo2 = new Inimigo(150, 15.0);
        
        listaInimigos.inserir(inimigo1);
        listaInimigos.inserir(inimigo2);

        listaInimigos.imprimeInimigos();
    
        int vidaRestante = listaInimigos.efetuarDano(inimigo1, 50.0);
        System.out.println("Vida restante do inimigo: " + vidaRestante);
        vidaRestante = listaInimigos.efetuarDano(inimigo1, 50.0);
        System.out.println("Vida restante do inimigo: " + vidaRestante);

        listaInimigos.imprimeInimigos();
    
    }
    
}
