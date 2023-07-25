package ArvoreBusca;

import java.util.Deque;
import java.util.Iterator;

public class Arvbin<T extends Comparable<T>>
{
	private T val;   /* Valor armazenado na raiz. */

	/* Refer�ncias para sub�rvores. */
	private Arvbin<T> esq, dir;

	/* Construtor de �rvore sem sub-�vores (dir = esq = null). � fornecido apenas o valor da raiz. */
	public Arvbin(T valor)
	{
		val = valor;
		esq = null;
		dir = null;
	}

	/* Construtor de �rvore com sub-�vores. S�o fornecidos
	o valor da raiz e as sub�rvores, que devem ter sido 
	constru�das previamente.*/
	public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir)
	{
		val = valor;
		esq = arvEsq;
		dir = arvDir;
	}

	/* Retorna o valor armazenado na raiz. */
	public T retornaVal()
	{
		return val;
	}

	/* Retorna a sub�rvore esquerda 
	   (ou null se n�o houver). */
	public Arvbin<T> retornaEsq()
	{
		return esq;
	}

	/* Retorna a sub�rvore direita 
    (ou null se n�o houver). */
	public Arvbin<T> retornaDir()
	{
		return dir;
	}

	/* Modifica o valor armazenado na raiz. */
	public void defineVal(T valor)
	{
		val = valor;
	}

	/* Redefine a sub�rvore esquerda, apagando a antiga se houver. */
	public void defineEsq(Arvbin<T> filho)
	{
		esq = filho;
	} 

	/* Redefine a sub�rvore direita, apagando a antiga se houver. */
	public void defineDir(Arvbin<T> filho)
	{
		dir = filho;
	}
	
	/* Verifica se um valor est� na �rvore. Se estiver, retorna um ponteiro para o
	   o n� que tem esse valor. Caso contr�rio, retorna null. */
	public Arvbin<T> busca(T valor)
	{
		Arvbin<T> ret;

		/* Se � igual ao valor armazenado, n�o precisa procurar mais. O n� � a raiz. */
		if (valor.compareTo(val) == 0)
		{
			return this;
		}

		/* Sen�o, come�a procurando na sub�rvore esquerda. */
		if (esq != null)
		{
			ret = esq.busca(valor);
			
			if (ret != null)
				return ret;
		}

		/* Se chega a esse ponto, estar� na �rvore se, e somente se, 
	     estiver na sub�rvore direita */
		if (dir != null) 
			return dir.busca(valor);
		
		return null;
	}
	
	/* Calcula e retorna o n�mero de n�s na �rvore. */
	public int contaNos()
	{
		if((esq == null) && (dir == null))
			return 1;
		
		int nosEsq = 0, nosDir = 0;
		
		if(esq != null)
			nosEsq = esq.contaNos();
		
		if(dir != null)
			nosDir = dir.contaNos();
		
		return 1 + nosEsq + nosDir;
	}
	
	/* Calcula e retorna a altura da �rvore. */
	public int calculaAltura()
	{
		if((esq == null) && (dir == null))
			return 0;
		
		int altEsq = 0, altDir = 0;
		
		if(esq != null)
			altEsq = esq.calculaAltura();
		
		if(dir != null)
			altDir = dir.calculaAltura();
		
		return 1 + Math.max(altEsq, altDir);
	}
	
	/* Calcula e retorna o maior valor contido na �rvore. */
	public T calculaMaximo()
	{
		if((esq == null) && (dir == null))
			return val;
		
		T maiorFilhos, maiorEsq, maiorDir; 
		
		if((esq != null) && (dir == null))
		{
			maiorFilhos = esq.calculaMaximo();
		}
		else if((esq == null) && (dir != null))
		{
			maiorFilhos = dir.calculaMaximo();
		}
		else
		{
			maiorEsq = esq.calculaMaximo();
			maiorDir = dir.calculaMaximo();
			
			if(maiorEsq.compareTo(maiorDir) > 0)
				maiorFilhos = maiorEsq;
			else
				maiorFilhos = maiorDir;
		}
		
		if(maiorFilhos.compareTo(val) > 0)
			return maiorFilhos;
		
		return val;
	}
	
	/* Calcula a soma dos valores dos n�s de uma �rvore de inteiros. */
	public static int calculaSoma(Arvbin<Integer> no)
	{
		if(no == null)
			return 0;

		int acumulado = 0;
						
		acumulado += calculaSoma(no.esq);
		
		acumulado += calculaSoma(no.dir);
		
		acumulado += no.val;
		
		return acumulado;
	}
	
	/* Resolu��o da quest�o 1 dispon�vel no moodle. */
	public int contaNosIntervalo(T min, T max)
	{
		if((esq == null) && (dir == null))
		{
			if((val.compareTo(min)) >= 0 && (val.compareTo(max) <= 0))
				return 1;
			else
				return 0;
		}
		
		int nosEsq = 0, nosDir = 0, noCont = 0;
		
		if(esq != null)
			nosEsq = esq.contaNosIntervalo(min, max);
		
		if(dir != null)
			nosDir = dir.contaNosIntervalo(min, max);
		
		if((val.compareTo(min) >= 0) && (val.compareTo(max) <= 0))
			noCont = 1;
		
		return noCont + nosEsq + nosDir;
	}
	
	/* Resolu��o da quest�o 2 dispon�vel no moodle. */
	public static int verificaArvoreSoma(Arvbin<Integer> arvore)
	{
		/* Caso base: se � uma sub�rvore vazia, deve retornar 0. */
		if(arvore == null)
			return 0;
		
		/* Caso base: se � uma folha, retorna o valor contido no n�. */
		if((arvore.esq == null) && (arvore.dir == null))
			return arvore.val;
		
		/* Caso geral: deve chamar para a esquerda e para a direita, verificando
		 * a soma. */
		int somaEsquerda = 0, somaDireita = 0;
		
		if(arvore.esq != null)
			somaEsquerda = verificaArvoreSoma(arvore.esq);
		
		if(arvore.dir != null)
			somaDireita = verificaArvoreSoma(arvore.dir);
			
		/* Agora devemos verificar se o valor do n� corresponde � soma dos valores
		 * contidos nas sub�rvores esquerda e direita. */
		if((somaEsquerda != Integer.MIN_VALUE) && (somaDireita != Integer.MIN_VALUE)
				&& (arvore.val == somaEsquerda + somaDireita))
			return arvore.val + somaEsquerda + somaDireita;
		
		return Integer.MIN_VALUE;
	}
	
	/* Resolu��o da quest�o 3 dispon�vel no moodle. */
	public boolean eIgual(Arvbin<T> outra)
	{
		if(this.esq == null && this.dir == null)
		{
			if(outra.esq == null && outra.dir == null)
			{
				if(this.val.compareTo(outra.val) == 0)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		
		boolean esqIgual = true, dirIgual = true;
		
		if(this.esq != null)
		{
			if(outra.esq == null)
				return false;
			else
				esqIgual = this.esq.eIgual(outra.esq);
		}
		else
		{
			if(outra.esq != null)
				return false;
		}
		
		if(this.dir != null)
		{
			if(outra.dir == null)
				return false;
			else
				dirIgual = this.dir.eIgual(outra.dir);
		}
		else
		{
			if(outra.dir != null)
				return false;
		}
		
		if(this.val.compareTo(outra.val) == 0)
			return esqIgual && dirIgual;
		else
			return false;
	}
	
	/* Calcula e retorna o di�metro da �rvore, isto �, o n�mero
	 * de n�s contido no maior caminho de um n� para outro n� da
	 * �rvore. */
	public int calculaDiametro()
	{
		/* Caso base, quando � uma folha. */
		if((esq == null) && (dir == null))
		{
			return 1;
		}
		
		/* Calcula a altura das sub�rvores esquerda e direita do n�. */
		int alturaEsq = 0, alturaDir = 0;
		
		if(esq != null)
			alturaEsq = esq.calculaAltura();
		
		if(dir != null)
			alturaDir = dir.calculaAltura();
		
		int maxDistanciaNo = alturaEsq + alturaDir + 1;
		
		/* Nesse ponto, temos a maior dist�ncia entre dois n�s da �rvore
		 * que passa pelo n� corrente (this). Agora devemos calcular esse
		 * valor para as sub�rvores esquerda e direita, comparando depois. */		
		
		int maxDistanciaEsq = 0, maxDistanciaDir = 0;
		
		if(esq != null)
			maxDistanciaEsq = esq.calculaDiametro();
		
		if(dir != null)
			maxDistanciaDir = dir.calculaDiametro();
		
		int maxDistanciaFilhos = Math.max(maxDistanciaEsq,  maxDistanciaDir);
		
		if(maxDistanciaNo > maxDistanciaFilhos)
			return maxDistanciaNo;
		else
			return maxDistanciaFilhos;
	}
	
	/* M�todo que realiza a impress�o de todos os caminhos da raiz para uma folha. */
	public void imprimeTodosCaminhos(Deque<T> caminhos)
	{
		/* Adiciona o n� no caminho. */
		caminhos.addLast(val);

		/* Caso base: quando � uma folha. */
		if((esq == null) && (dir == null))
		{
			/* Chegou-se ao fim do caminho, portanto deve-se imprimi-lo. */
			imprimeCaminho(caminhos);
		}

		/* Caso geral: deve-se fazer a recurs�o para os n�s esquerdo (se houver) e 
		 * para o direito (se houver). */
		
		if(esq != null)
			esq.imprimeTodosCaminhos(caminhos);

		if(dir != null)
			dir.imprimeTodosCaminhos(caminhos);
		
		/* Remove o n� corrente do caminho ap�s as chamadas recursivas para os
		 * n�s esquerdo e direito. */ 
		caminhos.removeLast();
	}

	/* M�todo privado auxiliar que imprime os n�s contidos na estrutura caminhos. */
	private void imprimeCaminho(Deque<T> caminhos)
	{
		Iterator<T> iterator = caminhos.iterator();

		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " -> ");
		}

		System.out.println();
	}

	//Metodos Ex1

	/* Complexidade: O(1) * n = O(n) */
	public void imprimePreOrdem(){

		System.out.print("(" + val);
		if (esq != null)
			esq.imprimePreOrdem();
		if (dir != null)
			dir.imprimePreOrdem();
		System.out.print(")");
	}

	/* Complexidade: O(1) * n = O(n) */
	public void imprimePosOrdem(){

		System.out.print("(");

		if (esq != null) 
			esq.imprimePosOrdem();

		if (dir != null) 
			dir.imprimePosOrdem();
		
		System.out.print(val + ")");
	}

	/* Complexidade: O(1) * n = O(n) */
	public void imprimeEmOrdem(){

		System.out.print("(");
		if (esq != null) 
			esq.imprimePosOrdem();

		System.out.print(val);

		if (dir != null) 
			dir.imprimePosOrdem();
		
		System.out.print(")");
	}

	//Metodo Ex2
	/* Complexidade: O(1) * n = O(n) */
	public static Integer retornaSomaSubArvore(Arvbin<Integer> no){

		if (no == null) 
			return 0;
			
		int soma = 0;

		if(no.eFolha())
			return no.val;

		else
		{
			if (no.esq != null)
				soma += retornaSomaSubArvore(no.esq);
			if (no.dir != null)	
				soma += retornaSomaSubArvore(no.dir);
		}

		soma += no.val;
		
		return soma;
	}

	//Metodo Ex3
	/* Complexidade: O(1) * n = O(n) */
	public boolean eSimilar(Arvbin<T> arvore){

		if(this.eFolha())
		{
			if (!arvore.eFolha()) 
				return false;

			return true;
		}

		boolean direita = true, esquerda = true;

		if (esq != null)
		{
			if (arvore.esq == null)
				return false;
			else 
				esquerda = esq.eSimilar(arvore.esq);
		}else
		{
			if (arvore.esq != null) 
				return false;
		}		

		if (dir != null)
		{
			if (arvore.dir == null)
				return false;
			else 
				direita = dir.eSimilar(arvore.dir);
		}else 
		{
			if (arvore.dir != null) 
				return false;
		}	

		return esquerda && direita;
	}

	//Metodos Ex4
	/* Complexidade: O(n) + busca O(n) + buscaPai O(n) = O(n)*/
	public void delete(T valor){

		Arvbin<T> no = busca(valor);
		if (no == null) 
			System.out.println("Valor nao encontrado.");
		else
		{
			Arvbin<T> pai = buscaPai(valor);
			delete(no, pai);
		} 
	}

	/* Complexidade: O(1) * n = O(n) */
	private void delete(Arvbin<T> no, Arvbin<T> pai){

        if (no.eFolha()) 
		{
            if (pai == null)
                no.val = null;

            if (pai != null) 
			{
                if (pai.esq == no)
                    pai.esq = null;

                 else if (pai.dir == no)
                    pai.dir = null;
            }
        }
           
        else if (!no.eFolha()) 
		{
            if (no.esq != null) 
			{
                no.val = no.esq.val;

                if (no.esq.eFolha())
                    no.esq = null;

                else if (!no.esq.eFolha()) 
				{
                    if (no.esq.esq != null) 
					{
                        no.esq.val = no.esq.esq.val;
                        delete(no.esq.esq.val);
                    } else if (no.esq.dir != null) 
					{
                        no.esq.val = no.esq.dir.val;
                        delete(no.esq.dir.val);
                    }
                }
            }
            else if (no.dir != null) 
			{
                no.val = no.dir.val;

                if (no.dir.eFolha())
                    no.dir = null;

                else if (!no.dir.eFolha()) 
				{
                    if (no.dir.esq != null) 
					{
                        no.dir.val = no.dir.esq.val;
                        delete(no.dir.esq.val);
                    } else if (no.dir.dir != null) 
					{
                        no.dir.val = no.dir.dir.val;
                        delete(no.dir.dir.val);
                    }
                }
            }
        }
	}

	//Metodo Ex5
	/* Complexidade: O(1) + buscaPai( O(n)) + busca( O(n)) + defEsq( O(1)) + defDir ( O(1)) = O(n) */
	public void tornaRaiz(T valor){
		
		Arvbin<T> no = busca(valor);

		if (no == null){
			System.out.println("Valor inexistente na arvore");
		} else
		{	
			Arvbin<T> pai = buscaPai(no.val);
			Arvbin<T> raiz = this;

			if (raiz == pai) 
			{
				Arvbin<T> raizAuxiliar = new Arvbin<T>(raiz.val);

				if (raiz.esq == no)
					raiz.esq = null;

				else if (raiz.dir == no)
					raiz.dir = null;

				raizAuxiliar.defineEsq(no.esq);
				raizAuxiliar.defineDir(no.dir);

				no.defineEsq(raiz.esq);
				no.defineDir(raiz.dir);

				raiz.defineEsq(raizAuxiliar.esq);
				raiz.defineDir(raizAuxiliar.dir);

				if (no.esq == null)
					no.esq = raiz;

				else if (no.dir == null)
					no.dir = raiz;
			}else 
			{
				Arvbin<T> noAux = new Arvbin<T>(no.val);

				noAux.defineEsq(raiz.esq);
				noAux.defineDir(raiz.dir);

				if (pai.esq == no)
					pai.esq = raiz;

				else if (pai.dir == no)
					pai.dir = raiz;

				raiz.defineEsq(no.esq);
				raiz.defineDir(no.dir);

				no.defineEsq(noAux.esq);
				no.defineDir(noAux.dir);
			}
        }
    }

	//Metodos Ex6
	/* Complexidade: O(1) + verificaBalanceamento O(n) = O(n) */
	public boolean eBalanceada(){
		
		return eBalanceada(this) != -1;
	}

	/* Complexidade: O(1) * n = O(n) */
	private int eBalanceada(Arvbin<T> arvore) {

		if (arvore.eFolha())
			return 0;

		int alturaEsq = -1, alturaDir = -1;

		if (arvore.esq != null)
		{
			alturaEsq = eBalanceada(arvore.esq);

			if (alturaEsq == -1)
				return -1;
		}

		if (arvore.dir != null)
		{
			alturaDir = eBalanceada(arvore.dir);

			if (alturaDir == -1)
				return -1;
		}

		int diferencaAlturas = alturaEsq - alturaDir;

		if (Math.abs(diferencaAlturas) > 1)
			return -1;

		return Math.max(alturaEsq, alturaDir) + 1;
	}

	//Metodos auxiliares

	/* Complexidade O(1) */	
	private boolean eFolha(){

		return esq == null && dir == null; 
	}

	/* Complexidade: O(1) * n = O(n) */
	private Arvbin<T> buscaPai (T valor){

		Arvbin<T> pai = null;

		if ( (esq != null && esq.val.compareTo(valor) == 0) || (dir != null && dir.val.compareTo(valor) == 0) )
			pai = this;
		
		if (esq != null && pai == null)
            pai = esq.buscaPai(valor);

        if (dir != null && pai == null)
            pai = dir.buscaPai(valor);
	
		return pai;
	}
}