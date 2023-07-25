import java.util.Scanner;

public class Ex3MainPilha
{
	
	public static void main(String args[])
	{
		//TODO: Separar em metodos

		Scanner scanner = new Scanner(System.in);

		int tamanhoPilha1;
		int tamanhoPilha2;
		int tamanhoMaximo;
				
		System.out.println("Entre o tamanho da 1ª Pilha: ");
		tamanhoPilha1 = scanner.nextInt();
		Ex3Pilha pilha1 = new Ex3Pilha(tamanhoPilha1);
		

		System.out.println("Entre o tamanho da 2ª Pilha: ");
		tamanhoPilha2 = scanner.nextInt();
		Ex3Pilha pilha2 = new Ex3Pilha(tamanhoPilha2);	

		tamanhoMaximo = tamanhoPilha1 + tamanhoPilha2;

		char[] vet = new char[tamanhoMaximo];
		int escolha;
		int i = -1;
		int j = tamanhoPilha1 - 1;
		char c;

		do {
			
			System.out.println("--------------------------------");
			System.out.println("1 - Add na pilha 1");
			System.out.println("2 - Remover da pilha 1");
			System.out.println("3 - Add na pilha 2");
			System.out.println("4 - Remover da pilha 2");
			System.out.println("5 - Mostrar vetor");			
			System.out.println("0 - Sair");

			escolha = scanner.nextInt();

			switch (escolha) {
				case 0:
					System.out.println("Finalizando");
					break;
				
				case 1:
					if (pilha1.cheia())
					{
						System.out.println("Pilha cheia");							
					}else
					{
						System.out.println("Caracter a add: ");
						c = scanner.next().charAt(0);
						pilha1.push(c);
						vet[++i] = c;
						
					}

					break;

				case 2:
					if (pilha1.vazia())
					{
						System.out.println("Pilha vazia");							
					}else
					{
						pilha1.pop();
						vet[i--] = ' ';
					}
				
				break;

				case 3:
					if (pilha2.cheia())
					{
						System.out.println("Pilha cheia");							
					}else
					{
						System.out.println("Caracter a add: ");
						c = scanner.next().charAt(0);
						pilha2.push(c);
						vet[++j] = c;
					}

				break;

				case 4:
					if (pilha2.vazia())
					{
						System.out.println("Pilha vazia");							
					}else
					{
						pilha2.pop();
						vet[j--] = ' ';
					}
				
				break;

				case 5:
					if (!pilha1.vazia() || !pilha2.vazia())
					{
						for (int k = 0; k < vet.length; k++)
						{
							System.out.print(vet[k]);	
						}
						
						System.out.print("\n");

					} else {
						System.out.println("Vetor vazio");
					}

				break;

				default:
					System.out.println("Erro...");
				break;
			}	

		} while (escolha != 0);

		System.out.print("\n");
		scanner.close();
	}

}
