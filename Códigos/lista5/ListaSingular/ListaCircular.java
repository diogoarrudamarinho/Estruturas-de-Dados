package ListaSingular;

public class ListaCircular extends Lista
{
	/* Imprime todos os elementos da lista */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista");
		
		p = prim;
		
		if (p != null)
		{
			do
			{
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}
		
		System.out.println();
	}
	
	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		System.out.print(p.dado + " ");
		
		if(p.prox == prim)
			return;
		
		imprimeRecursivo(p.prox);
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null)
		{
			/* Percorre at� alcancar o in�cio. */
			while (p.prox != prim)
			{
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		}
		else
		{
			prim = q;
			prim.prox = q;     
		}
	}
	
	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		Elo ant = null;

		if (prim == null) return false;

		for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
			ant = p;

		/* Achou */
		if ( p.dado == elem )
		{
			/* � o primeiro */     
			if ( p == prim )
			{
				/* � o �nico */
				if ( prim == prim.prox )
				{
					prim = null;  
				}
				else
				{
					/* Guarda o anterior ao primeiro */
					for( ant = prim; ( ant.prox != prim ); ant = ant.prox);
					
					ant.prox = prim.prox; 
					prim = prim.prox; 
				}     
			}   
			else
			{
				/* No meio */
				ant.prox = p.prox;     
			} 

			/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
			 * o Garbage Collector ir� liberar essa mem�ria. */
			p = null;

			return true;    
		}
		else  
			return false;
	}
	
	//Metodo Ex2
	//Complexidade O(n)
	public ListaCircular merge(ListaCircular l2){

		ListaCircular listaConcatenada = new ListaCircular();
		
		
		if (prim == null && l2.prim == null)
			return listaConcatenada;
		else if (prim == null)
			return l2;
		else if (l2.prim == null)
			return this;
		
		Elo p = prim;
		Elo q = l2.prim;
	
		while ((p.prox != prim) && (q.prox != l2.prim))
		{
			
			listaConcatenada.insere(p.dado);
			listaConcatenada.insere(q.dado);
			p = p.prox;
			q = q.prox;

			if (p.prox == prim)
				listaConcatenada.insere(p.dado);

			if (q.prox == l2.prim)
				listaConcatenada.insere(q.dado);

		}

		if (p.prox == prim){
			for (; q.prox != l2.prim; q = q.prox) 
				listaConcatenada.insere(q.dado);
		}

		if (q == l2.prim){
			for (; p.prox != prim; q = q.prox) 
				listaConcatenada.insere(p.dado);
		}

		return listaConcatenada;
	}

	//Metodo Ex3
	//Complexidade O(n)
	public ListaCircular inverteLista() {

		if (prim == null)
			return this;
	
		Elo p = prim;
		Elo q = p.prox;

		while (q != prim)
		{

			Elo aux = q.prox;
			q.prox = p;
			p = q;
			q = aux;

		}
	
		q.prox = p;
		prim = p;

		return this;
	}
}