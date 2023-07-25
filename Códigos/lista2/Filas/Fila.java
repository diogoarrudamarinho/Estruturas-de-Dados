package list2.Filas;

public class Fila
{
	
	protected int tamanho;	
	protected int[] vetor;	
	protected int ini;	
	protected int n;
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
		ini = 0;
		n = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	//Retiramos o elemento do in�cio da fila
	public int remove()
	{
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(int elemento)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}

	public void imprime()
	{
		int i, j;
		
		if (vazia())
			System.out.println("Fila est� vazia.");
		else
			for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.print(" " + vetor[i]);
	}

	public void alternarFila (Fila f2)
    {

        Fila filaAuxiliar = new Fila((this.tamanho + f2.tamanho));
        int elemento;

        if (this.tamanho > f2.tamanho) {

            while (!f2.vazia()) {
                
                elemento = this.remove();
                filaAuxiliar.insere(elemento);
                elemento = f2.remove();
                filaAuxiliar.insere(elemento);

            }

            while (!this.vazia()) {

                elemento = this.remove();
                filaAuxiliar.insere(elemento);
            }

        }else if(f2.tamanho > this.tamanho){

            while (!this.vazia()) {

                elemento = this.remove();
                filaAuxiliar.insere(elemento);
                elemento = f2.remove();
                filaAuxiliar.insere(elemento);
            }

            while (!f2.vazia()) {

                elemento = f2.remove();
                filaAuxiliar.insere(elemento);
            }

        }else {

            while (!this.vazia() && !f2.vazia()) {
                
                elemento = this.remove();
                filaAuxiliar.insere(elemento);
                elemento = f2.remove();
                filaAuxiliar.insere(elemento);

            }

        }

        filaAuxiliar.imprime();

    }

	public static FilaDupla retornaFilaDupla(Fila fila){

		FilaDupla filaDupla = new FilaDupla(fila.tamanho);

		if (!fila.vazia()) {

			while (!fila.vazia()){

				filaDupla.insere(fila.remove());
			}

			return filaDupla;
		}
		
		return null;

	}
}