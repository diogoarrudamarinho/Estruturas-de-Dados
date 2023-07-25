import java.util.Scanner;

public class Ex1MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Ex1Pilha pilha = new Ex1Pilha(20);
		String s;
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

		char vet[] = new char[s.length()/2];
		
		int j = 0;

		while (s.charAt(i - 1) != 'C') {

			c = s.charAt(i - 1);
			vet[j] = pilha.pop();
			j++;
			i--;

		}

		pilha.comparaCaracter(vet, s);

		System.out.print("\n");
		
		scanner.close();
	}
}
