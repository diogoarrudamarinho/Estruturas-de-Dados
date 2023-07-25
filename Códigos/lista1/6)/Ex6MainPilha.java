import java.util.Scanner;

public class Ex6MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String s;
		
		do {

			System.out.println("Entre com a String: ");
			s = scanner.nextLine();

		} while (s.isEmpty());  

        String resultado = inverterLetras(s);
        System.out.println(resultado);
		System.out.print("\n");		
		scanner.close();
	}	

	public static String inverterLetras(String s)
	{
		String[] palavras = s.split(" ");
		StringBuilder frase = new StringBuilder();

		for (String string : palavras)
		{
			Ex6Pilha pilha = new Ex6Pilha();
			for (int i = 0; i < string.length(); i++)
				pilha.push(string.charAt(i));	
			
			while (!pilha.vazia()) 			
				frase.append(pilha.pop());
			
			frase.append(" ");
		}

      return frase.toString();
	}
}

