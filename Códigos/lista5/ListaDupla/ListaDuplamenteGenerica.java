package ListaDupla;

import Ex6.Chamada;

public class ListaDuplamenteGenerica <T>{

    protected Elo prim;
	
	protected class Elo
	{
		protected T dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(T elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(T elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	//Complexidade O(1)
	public ListaDuplamenteGenerica()
	{
		prim = null;
	}
	
	/* Testa se a lista est� vazia. */
	//Complexidade O(1)
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elementos com base na fila de prioridades. */
	//Complexidade O(n)
	public void insere(T novo)
	{
		Elo p;
		p = new Elo(novo);
		
		if (vazia())
        {
            prim = p;
            return;
        }

        Elo q = prim;

        if (((Chamada) p.dado).getCusto() > ((Chamada) q.dado).getCusto()) {
            p.prox = q;
            q.ant = p;
            prim = p;
            return;
        }

        while (q.prox != null && (((Chamada) q.prox.dado).getCusto() >= ((Chamada) p.dado).getCusto()))
            q = q.prox;
        
        
        p.prox = q.prox;
        p.ant = q;
    
        if (q.prox != null) 
            q.prox.ant = p;
         
        q.prox = p;
	}
	
	/* Remove o primeiro elemento da fila de prioridade */
	//Complexidade O(1)
	public boolean remove()
	{
		Elo p = prim;

		if (p == null) 
            return false;

		if (p == prim) 
			prim = prim.prox;
		
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	//Complexidade O(n)
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(((Chamada)p.dado).toString());
            System.out.println();
		}
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
	//Complexidade O(n)
	public void imprimeReversa()
	{
		Elo p;
		Elo ult = null;
		
		System.out.println("Elementos da lista em ordem reversa:");
		
		p = prim;
		
		while(p != null)
		{
			ult = p;
			p = p.prox;
		}
		
		for(p = ult; p != null; p = p.ant)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
    
}
