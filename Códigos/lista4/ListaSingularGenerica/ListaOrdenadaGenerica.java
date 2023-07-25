package ListaSingularGenerica;


public class ListaOrdenadaGenerica<T extends Comparable<T>> extends ListaGenerica<T>
{
	/* Complexidade O(n) */
	public void insere(T novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (novo.compareTo(p.dado) > 0)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Complexidade O(n) */
	public boolean remove(T elem)
	{
		Elo p;
		Elo ant = null; 
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;
		
		if (p == null)
			return false;
		
		if (p == prim)
			prim = prim.prox; 
		else
			ant.prox = p.prox;  
	
		p = null;
		
		return true;
	}

}