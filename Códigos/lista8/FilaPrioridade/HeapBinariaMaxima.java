package FilaPrioridade;
import Arvore.Arvbin;

public class HeapBinariaMaxima
{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho m�ximo do heap. */
	private int[] vetor;          /* Vetor com elementos. */

	/* Construtor Ex2 */
	/* Complexidade O(n) */
	public HeapBinariaMaxima(HeapBinariaMinima heapMinima)
	{
		n = heapMinima.getN();
		tam = heapMinima.getTamanho();
		vetor = new int[tam + 1];

		for (int i = 0; i < tam; i++)
			vetor[i + 1] = heapMinima.getElementos(i + 1);

		constroiHeap();
	}

	/* Constr�i heap vazio. */
	public HeapBinariaMaxima(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new int[tamanho+1];
	}

	/* Constr�i heap a partir de vetor v. */
	public HeapBinariaMaxima(int tamanho, int[] v)
	{
		tam = tamanho;
		vetor = new int[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	/* Metodos Auxiliares Ex3, Todos O(1) */
	public int getTamanho(){
		return tam;
	}

	public int getN(){
		return n;
	}

	public int getElementos(int i){
		return vetor[i];
	}

	/* Testa se a fila de prioridade est� logicamente vazia.
	   Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}
	
	/* Imprime os elementos da heap at� o tamanho m�ximo do vetor, a contar de 1.
	 * Este m�todo � utilizado somente ap�s a aplica��o do Heapsort. */
	public void imprimeTamanho()
	{
		for(int i = 1; i <= tam; i++)
			System.out.print(vetor[i] + " ");
		
		System.out.println();
	}

	/* Busca o maior item na fila de prioridades.
	   Retorna o maior item em itemMin e true, ou falso se a heap estiver vazia. */
	public int max()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MIN_VALUE;
		}

		return vetor[1];
	}

	/* Remove o maior item da lista de prioridades e coloca ele em itemMax. */
	public int removeMax()
	{
		int itemMax;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MIN_VALUE;
		}

		itemMax = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMax;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		/* As posi��es n at� a posi��o (n / 2) + 1 j� constituem uma heap,
		 * pois s�o folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho � o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se � maior que o filho esquerdo. */
				if(vetor[ filhoDir ] > vetor[ filhoEsq ])
					maiorFilho = filhoDir;
			}

			if(vetor[ maiorFilho ] > x)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x > vetor[pos/2])
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	/* Implementa o algoritmo de ordena��o Heapsort. */
	public void heapsort()
	{
		int x;           
		int resta = n;
		int raiz = 1;
		constroiHeap();
		
		while (resta > 1)
		{
			x = vetor[raiz];
			vetor[raiz] = vetor[resta];
			vetor[resta] = x;
			resta--;
			n--;
			refaz(raiz);
		}
	}

	//Metodos Ex4

	/*Complexidade O(n) */
	public void transformaHeapMaxima(Arvbin<Integer> arvore){
		
		if (arvore == null)
			return;
	
		int tamanho = arvore.contaNos();//O(n)
		int[] elementos = new int[tamanho];
	
		percorreArvore(arvore, elementos, 0);
	
		HeapBinariaMaxima heap = new HeapBinariaMaxima(tamanho, elementos);
	
		substituirElementos(arvore, heap, 1);
	}
	
	/* Complexidade O(n) */
	private int percorreArvore(Arvbin<Integer> no, int[] elementos, int indice) {
		
		if (no == null) 
			return indice;
		
		elementos[indice] = no.retornaVal();
		indice++;
	
		indice = percorreArvore(no.retornaEsq(), elementos, indice);

		indice = percorreArvore(no.retornaDir(), elementos, indice);
	
		return indice;
	}
	
	/*Complexidade O(n) */
	private void substituirElementos(Arvbin<Integer> no, HeapBinariaMaxima heap, int indice) {
		
		if (no == null) 
			return;
	
		no.defineVal(heap.getElementos(indice));
	
		substituirElementos(no.retornaEsq(), heap, 2 * indice);
		substituirElementos(no.retornaDir(), heap, 2 * indice + 1);
	}

	//Metodo Ex5

	/*Complexidade O(log n) */
	public boolean verificaPropriedadeHeap(int[] vetor){

		int n = vetor.length - 1;

        for (int i = 1; i < n / 2; i++)
		{
            int filhoEsquerdo = 2 * i;
            int filhoDireito = 2 * i + 1;

            if (filhoEsquerdo < n && vetor[filhoEsquerdo] > vetor[i])
                return false;

            if (filhoDireito < n && vetor[filhoDireito] > vetor[i])
                return false;
        }

        return true;
	}

	//Metodos Ex6
	
	/*Complexidade O(n) */
	public int remove(int i){

		if (i == 0 || i > n) 
			return Integer.MIN_VALUE;

		int x = vetor[i];

		for (int j = i; j < n; j++)
			vetor[j] = vetor[j + 1];

		n--;
		
		for (int j = n/2; j > 0; j--)
			refaz(j);
		
		return x;
	}
}