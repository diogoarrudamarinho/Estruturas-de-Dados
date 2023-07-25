package ListaDupla;

public class ListaDuplamente
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected int dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(int elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no in�cio da lista. */
	public void insere(int novo)
	{
		Elo p;
		
		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;
	}
	
	/* M�todo auxiliar para busca. */
	private Elo busca(int elem)
	{
		Elo p = null;
		
		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim) 
			prim = prim.prox;
		else 
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se � ultimo elemento */  
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
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
	
	//Metodo Ex1
	//Complexidade O(n^3)
	public ListaDuplamente intersecao(ListaDuplamente l2){

		ListaDuplamente l3 = new ListaDuplamente();

		Elo p;
		Elo q;

		for (p = prim, q = l2.prim; (p != null) && (q != null);p = p.prox, q )
		{
			if (p.dado == q.dado)
				if (l3.busca(p.dado) == null)
					l3.insere(p.dado);
			
		}

		return l3;
	}

	//Metodo Ex4
	//Complexidade O(n)
	public void trocaElos(int indiceElo1, int indiceElo2){

		if (indiceElo1 == indiceElo2)
			return;

		Elo p;
		Elo q;
		Elo aux1 = null;
		Elo aux2 = null;
		int i;

		for (i = 0, p = prim; (p != null) && (i != indiceElo1); p = p.prox, i++);
		for (i = 0, q = prim; (q != null) && (i != indiceElo2); q = q.prox, i++);

		if (p == null || q == null)
		{
			System.out.println("Indice nao encontrado");	
			return;
		}

		if (p.ant != null)
       		p.ant.prox = q;
    	if (p.prox != null)
       		p.prox.ant = q;
    	if (q.ant != null)
       		q.ant.prox = p;
    	if (q.prox != null)
        	q.prox.ant = p;
			
		//Trocando os Elos 
		aux1 = p.ant;
   		aux2 = p.prox;

    	p.ant = q.ant;
    	p.prox = q.prox;
    	q.ant = aux1;
    	q.prox = aux2;
	
	}

	//Metodos Ex5
	//Complexidade O(n)
	public boolean verificaIgualdade(ListaDuplamente lista2) {
		
		if ((lista2 == null && this != null) || (lista2 != null && this == null))
			return false;
	
		return verificaIgualdadeRecursivo(prim, lista2.prim);
	}
	
	private boolean verificaIgualdadeRecursivo(Elo p, Elo q) {
		
		if (p == null && q == null)
			return true;
	
		if (p == null || q == null || p.dado != q.dado)
			return false;
	
		return verificaIgualdadeRecursivo(p.prox, q.prox);
	}
}