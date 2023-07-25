package Conjunto;

public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim; /* Refer�ncia para primeiro elemento. */
	private T maior;  

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo
	{                 
		T dado;
		Elo prox;

		public Elo()
		{ 
			prox = null;
		}

		public Elo(T elem)
		{
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo proxElem)
		{ 
			dado = elem;
			prox = proxElem;
		}
	}

	/* Construtor que cria um conjunto vazio. */
	public ConjGenerico()
	{
		prim = null;
		maior = null;
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	private void copia(ConjGenerico<T> conj2)
	{
		Elo ult = null, q;

		prim = null;
		
		for (Elo p = conj2.prim; p != null; p = p.prox)
		{
			q = new Elo(p.dado);
			
			if (ult == null)
				prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	public void apaga()
	{
		for (Elo p = prim; p != null; p = prim)
		{
			prim = prim.prox;
			p.prox = null;
		}
	}

	/* Simula uma sobrecarga do operador de atribui��o. */
	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
		if (this != conj2)
		{
			apaga();
			copia(conj2);
		}
		
		return this;
	}

	/* Testa se o conjunto est� vazio. */
	public boolean vazio()
	{
		return prim == null;
	}

	/* Teste de pertin�ncia. Usa fato de estar ordenado. */
	public boolean pertence(T valor)
	{
		Elo p;
		
		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;	  

		return true;
	}

	/* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento j� estava l�. */
	public boolean insere(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;
			
			ant = p;
		}
		
		Elo q = new Elo(valor);
		
		if (p == prim) 
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;

		if (maior == null)		
			maior = valor;
		else
			if (maior.compareTo(valor) < 0)
				maior = valor;
		
		return true;
	}

	/* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento n�o estava l�. */
	public boolean remove(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) > 0) return false;
			if (p.dado.compareTo(valor) == 0) break;	 
			
			ant = p;
		}
		
		if (p == null)
			return false;
		
		if (p == prim) 
			prim = prim.prox;
		else
			ant.prox = p.prox;

		if (maior.compareTo(valor) == 0) 
			maior = ant.dado;	
	
		p = null;
		
		return true;
	}

	/* M�todo para uni�o de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a uni�o. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> uniao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>(); 
		
		while ( (p1 != null) || (p2 != null) )
		{
			if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
			}
			else
			{
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado.compareTo(p2.dado) == 0))
					p1 = p1.prox;
				p2 = p2.prox;
			} 

			if (ult == null) 
				uniao.prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
		
		return uniao;
	}

	/* M�todo para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> intersecao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado.compareTo(p2.dado) < 0)
			{
				p1 = p1.prox;
			}
			else if(p2.dado.compareTo(p1.dado) < 0)
			{
				p2 = p2.prox;
			}
			else
			{
				q = new Elo(p1.dado);
				
				p1 = p1.prox;
				p2 = p2.prox;
				
				if (ult == null) 
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}

		return inter;
	}

	/* Retorna cardinalidade do conjunto */
	public int tamanho()
	{
		int tam = 0;
		Elo p;

		for(p = prim; p != null; p = p.prox)
			tam++;
		
		return tam;
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos do conjunto");
		
		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		
		System.out.println();
	}

	//Metodos Ex1
	/* Complexidade O(1) */
	public T retornaMenor(){
		return prim.dado;
	}

	/* Complexidade O(1) */
	public T retornaMaior(){
		return maior;
	}

	//Metodo Ex2
	/* Complexidade O(n) */
	public boolean eIgual(ConjGenerico<T> conj2){

		if (prim == null || conj2 == null)		
			return false;

		Elo p = prim;
		Elo q = conj2.prim;

		while (p != null && q != null)
		{			
			if (p.dado.compareTo(q.dado) != 0)
				return false;	
			
			p = p.prox;
			q = q.prox;
		}
		
		if ((p == null && q != null) || (p != null && q == null)) 
			return false;

		return true;
	}

	//Metodos Ex3
	/* Complexidade O(n + m) */
	private boolean eUniverso (ConjGenerico<T> conj){

		Elo p = conj.prim;
		Elo q = prim;

		while (q != null && p != null) 
			{
				if (q.dado.compareTo(p.dado) > 0) {
					return false;
				}else if (q.dado.compareTo(p.dado) == 0) 
				{
					q = q.prox;
					p = p.prox;
				}else
					q = q.prox;

				if(q == null && p != null)
					return false;
			}

		return true;
	}

	/* Complexidade O(n + m) */
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception {

		if (prim == null) 
			return null;

			if(!universo.eUniverso(this))
				throw new Exception("O conjunto contém elementos fora do universo.");

			Elo p = prim;
			Elo q = universo.prim;
		
			ConjGenerico<T> complemento = new ConjGenerico<>();
			Elo aux, ult = null;

			while (p != null && q != null) 
			{
				if (p.dado.compareTo(q.dado) == 0) 
				{
					p = p.prox;
					q = q.prox;
				} else if (p.dado.compareTo(q.dado) > 0) 
				{
					aux = new Elo(q.dado);

					if (ult == null) 
						complemento.prim = aux;
					else
						ult.prox = aux;
					
					ult = aux;
					q = q.prox;
				} 
			}

			while (q != null)
			{
				aux = new Elo(q.dado);

				if (ult == null) 
					complemento.prim = aux;
				else
					ult.prox = aux;
				
				ult = aux;
				q = q.prox;
			}

			return complemento;
	}

	//Metodo Ex4
	/* Complexidade O(n) */
	public boolean eSubconjunto(ConjGenerico<T> conj2){

		if (prim == null) 
			return false;
		
		if (this.tamanho() > conj2.tamanho())
			return false;
			
		Elo p = prim;
		Elo q = conj2.prim;

		while(p != null)
		{
			if (q == null && p != null)
					return false;

			if ((p == prim) && (p.dado.compareTo(q.dado) < 0)) 
				return false;				
	
			if (p.dado.compareTo(q.dado) == 0)
			{
				p = p.prox;
				q = q.prox;
			}else{

				if (p.dado.compareTo(q.dado) < 0)
					p = p.prox;
				else
					q = q.prox;

			}
		}

		return true;
	}

	//Metodo Ex5
	/* Conj Corrente - Conj2 */
	/* Complexidade O(n + m) */
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2){

		if (prim == null || conj2 == null)		
			return null;

		ConjGenerico<T> diferenca = new ConjGenerico<>();

		Elo p = prim;
		Elo q = conj2.prim;
		Elo ant = null;

		while(p != null && q != null)
		{
			if (p.dado.compareTo(q.dado) == 0)
			{
				p = p.prox;
				q = q.prox;
			}else
			{
				if (p.dado.compareTo(q.dado) < 0){

					Elo valor = new Elo(p.dado);

					if (ant == null)
						diferenca.prim = valor;
					else
						ant.prox = valor;

					ant = valor;
					p = p.prox;
				}else
					q = q.prox;
			}
		}
		
		while (p != null)
		{
			Elo valor = new Elo(p.dado);

				if (ant == null)
					diferenca.prim = valor;
				else
					ant.prox = valor;

				ant = valor;

			p = p.prox;
		}

		return diferenca;
	}

	//Metodos Ex6
	/* Complexidade: O(1) * n = O(n) */
	public boolean eIgualRecursivo(ConjGenerico<T> conj2){

		if (prim == null && conj2.prim == null)		
			return true;
		
		if ((prim == null && conj2.prim != null) || (prim != null && conj2.prim == null)) 
			return false;

		return eIgualRecursivo(prim, conj2.prim);
	}

	private boolean eIgualRecursivo(Elo p, Elo q){

		if (p == null && q == null)
			return true;

		if ((p == null && q != null) || (p != null && q == null)) 
			return false;

		if (p.dado.compareTo(q.dado) != 0)
			return false;	

		return eIgualRecursivo(p.prox, q.prox);

	}

	/* Metodo Ex7 */
	/* Complexidade O(n + m) */
	public static <T extends Comparable<T>> ConjGenerico<T> aplicaDeMorgan(ConjGenerico<T> universo, ConjGenerico<T> conj1, ConjGenerico<T> conj2) {
		
		if ( (conj1.prim == null) || (conj2.prim == null) )		
			return null;

		if ( (!universo.eUniverso(conj2)) || (!universo.eUniverso(conj1)) )
			return null;
			
		try
		{
			ConjGenerico<T> compConj1 = conj1.complementar(universo);
			ConjGenerico<T> compConj2 = conj2.complementar(universo);
			
			return compConj1.intersecao(compConj2);
		} catch (Exception e) 
		{
			return null;
		}
	}
}