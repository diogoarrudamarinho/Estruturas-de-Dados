package ListaSingular;

public class ListaOrdenada extends Lista
{
	/* Insere elemento na lista na posi��o adequada, mantendo-a ordenada. */
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* refer�ncia para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p � null ou p.dado != elem, ent�o n�o encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
		 * o Garbage Collector ir� liberar essa mem�ria. */
		p = null;
		
		return true;
	}

	//Metodo ex 2
	//Complexidade O(n)
	public ListaOrdenada concatenaListas(Lista l)
	{
		ListaOrdenada lista = new ListaOrdenada();

		Elo p = this.prim;
		Elo q = l.prim;
		if (p == null)
			{
				lista.prim = q;
				return lista;
			}
			else if (q == null)
			{
				lista.prim = p;
				return lista;			
			}

		if (p.dado < q.dado)
		{
			lista.prim = p;
			p = p.prox;
		}
		else
		{ 
			lista.prim = q;
			q = q.prox;
		}

		Elo r = lista.prim;

		while ((p != null) && (q != null))
		{
			if (p.dado < q.dado)
			{
				r.prox = p;
				p = p.prox;
			}
			else
			{
				r.prox = q;
				q = q.prox;
			}

			r = r.prox;
		}

		if (p != null){
			r.prox = p;
		} else {
			r.prox = q;
		}
		
		p = null;
		q = null;
		r = null;

		return lista;
	}
}