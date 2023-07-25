package Ex7;

public class ListaInimigos {
    
    private Elo prim;

    private class Elo{

        Inimigo inimigo;
        Elo prox;

        public Elo(Inimigo inimigo)
        {
            this.inimigo = inimigo;
            this.prox = null;
        }
    }

    /* Complexidade O(1) */
    public void inserir(Inimigo inimigo) {

        Elo p = new Elo(inimigo);
        p.prox = prim;
		prim = p;
    }

    /* Complexidade O(n) */
    public Inimigo localizar(Inimigo inimigo) {

        Elo p = prim;

        for (p = prim; p != null; p = p.prox) 
            if (p.inimigo.equals(inimigo)) 
                return p.inimigo;
        
        return null;
    }

    /* Complexidade O(n) */
    public int efetuarDano(Inimigo inimigo, double dano) {

        Elo p;
        Elo ant = null;

        for(p = prim; p != null; p = p.prox) 
        {
            if (p.inimigo.equals(inimigo)) 
            {
                int vidaRestante = p.inimigo.getVida() - (int) dano;

                if (vidaRestante <= 0) 
                {
                    if (ant == null) 
                        prim = p.prox;
                    else 
                        ant.prox = p.prox;
                    
                    return 0; 

                } else 
                {
                    p.inimigo.setVida(vidaRestante);
                    return vidaRestante;
                }
            }

            ant = p;
        }

        return Integer.MIN_VALUE; 
    }

    /* Complexidade O(n) */
    public void imprimeInimigos(){

        Elo p;
        int i;

        for (p = prim, i = 1; p != null; p = p.prox, i++)
            System.out.println("Inimigo " + i +  " " + p.inimigo.toString());
        
    }
}
