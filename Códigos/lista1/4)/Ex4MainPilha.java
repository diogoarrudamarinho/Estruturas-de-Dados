import java.util.Scanner;

public class Ex4MainPilha<T>
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String s;
		Object c;
		char elementoASerRemovido;

		System.out.println("Entre com a string: ");
		s = scanner.nextLine();
	
		Ex4PilhaGenerica pilha = new Ex4PilhaGenerica(s.length());

		int i = 0;
		
		while ( i < s.length() )
		{
			c = s.charAt(i);
			pilha.push(c);
			i++;
		}

		System.out.println("Entre com o elemento para a remocao: ");
		elementoASerRemovido = scanner.next().charAt(0);

		Ex4PilhaGenerica aux = new Ex4PilhaGenerica<>(s.length() - 1);
		while (!pilha.vazia())
		{
			c = pilha.pop();
			if (c.equals(elementoASerRemovido))
				continue;
			else
			{
				aux.push(c);
			}
		}

		while (!aux.vazia())
		{
			c = aux.pop();
			System.out.print(c);
		}

		System.out.print("\n");
		scanner.close();

	}	

}

