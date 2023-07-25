package list2.Filas;

import java.util.Vector;

public class FilaGenerica<T>{

    protected int tamanho;	
	protected Vector<T> vetor;	
	protected int ini;	
	protected int n;
	
	public FilaGenerica(int tam)
	{
		tamanho = tam;
		vetor = new Vector<>(tamanho);
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
	public T remove()
	{
		T elemento = null;
		
		if (!this.vazia())
		{
			elemento = vetor.get(ini);
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(T elemento)
	{
	  int fim;
	  
	  if (!cheia()) {
	    fim = (ini + n) % tamanho;
	    vetor.add(fim, elemento);
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
				System.out.println(j + "- " + vetor.get(i));
	}

	public int getIni() {
		return ini;
	}

	public int getN() {
		return n;
	}

	public int getTamanho() {
		return tamanho;
	}

}