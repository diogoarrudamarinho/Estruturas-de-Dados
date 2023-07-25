public class Ex5Pilha
{
	private int n;
	private char vetor[];
	private int topo;
	
	public Ex5Pilha()
	{
		n = 10;
		vetor = new char[n];
		topo = -1;
	}
	
	public Ex5Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
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
	
	public char pop()
	{
		char c = '\0';
		
		if (!this.vazia())
		{
			c = vetor[topo];
			
			//Decrementando o topo, o elemento � "removido"
			topo--;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop n�o funcionou.");
		}
		
		return c;
	}
	
	public boolean push(char elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			return true;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push n�o funcionou.\n");
			return false;
		}
	}
	
	public char retornaTopo()
	{
		char elemento = '\0';

		if(!this.vazia())
		{
			elemento = vetor[topo];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}
	
	public int contaPalavras(String s)
	{
		int n = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ')
				n++;
		}

		return n;
	}

	public boolean comparaCaracter(char[] s, String r, int tamVetor)
	{

		int i = 0;
		char c;
		char aux;

		while (i < tamVetor) {
			
			c = s[i];
			aux = r.charAt(i++);
			if(c == aux)
				continue;
			else
			{
				System.out.println("Formato Incorreto");
				return false;
			}
		
		}

		System.out.println("Formato Correto");
		return true;

	}

	
}