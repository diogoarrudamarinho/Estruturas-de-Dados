import java.util.Scanner;

public class Ex2MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Ex2Pilha pilha = new Ex2Pilha(20);
		String s;
		String subString;
		char c;	
		
		do
		{
			System.out.println("Entre com a String: ");
			s = scanner.nextLine();
		
		}while(pilha.elementosCorretos(s) == false || pilha.stringCorreta(s) == false);

		int i = 0;
	
		while ( i < s.length())
		{
			c = s.charAt(i);
			pilha.push(c);
			i++;
		}

		int n = 0;
		int j;
		int indiceFinal = i - 1;
		char vet[] = new char[s.length()];

		while (indiceFinal >=0)
		{
			
			n = pilha.percorreVetor(indiceFinal);
			
			j = 0;

			while (s.charAt(i - 1) != 'C')
			{
				c = s.charAt(i - 1);
				vet[j] = pilha.pop();
				j++;
				i--;
			}

			subString = s.substring(indiceFinal - n + 1, indiceFinal - (n/2));
			pilha.comparaCaracter(vet, subString, j);
			indiceFinal = indiceFinal - n - 1;
		}

		System.out.print("\n");
		
		scanner.close();
	}
}
