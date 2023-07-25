import java.util.Vector;

public class Ex1PilhaGenerica<T>
{
	private int n;
	private Vector<T> vetor;
	private int topo;
	
	public Ex1PilhaGenerica(int tamanho)
	{		
		n = tamanho;
		vetor = new Vector<T>(tamanho);
		topo = -1;
	}

	public Ex1PilhaGenerica()
	{		
		n = 30;
		vetor = new Vector<T>(n);
		topo = -1;
	}

	public boolean vazia()
	{
		return topo == -1 ? true : false; 
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public T pop()
	{
		T elemento;
		
		if (!this.vazia())
		{
			elemento = vetor.get(topo--);
			return elemento;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop nao funcionou.");
			return null;
		}
	}
	
	public boolean push(T elemento)
	{
		if (!this.cheia())
		{
			vetor.add(++topo, elemento);
			return true;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
	public T retornaTopo()
	{
		T elemento = null;

		if(!this.vazia())
		{
			elemento = vetor.get(topo);         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}	

	public int retornaElementos(){

		int n = 0;
		
		if (!this.vazia()) {
			while (n != topo) {
				n++;
			}
		}

		return n;
	}

	public void limparPilha(){
		topo = -1;
	}
}