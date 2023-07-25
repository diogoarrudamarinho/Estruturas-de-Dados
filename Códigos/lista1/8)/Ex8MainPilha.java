import java.util.ArrayList;
import java.util.Scanner;

public class Ex8MainPilha
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int tamanho;

        System.out.println("Tamanho da sequencia: ");
        tamanho = scanner.nextInt();
        scanner.close();

       // Pilha pilha = new Pilha(tamanho);
		
        int[] sequencia= new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            sequencia[i] = i + 1;
        }

        //boolean flag = false;

        Ex8PilhaGenerica<Integer> PilhaGenerica = new Ex8PilhaGenerica<>();
        ArrayList<Ex8Pares> paresImpressos = new ArrayList<>();

        System.out.println("Sequencia: ");

        for (int i = 0; i < tamanho; i++) {
            for (int j = i; j < tamanho; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(sequencia[k] + " ");
                }
                System.out.println();
            }
        }

        System.out.println("Pares: ");

        for (int i = 0; i < tamanho; i++) {
            for (int j = i; j < tamanho; j++) {
                for (int k = i; k <= j; k++) {
                    PilhaGenerica.push(sequencia[k]);
                }
                if (PilhaGenerica.retornaElementos() > 0) {
                    int a = PilhaGenerica.retornaTopo();
                    PilhaGenerica.pop();
                    int b = PilhaGenerica.retornaTopo();
                    if (a != b && a > b) {
                        Ex8Pares par = new Ex8Pares(a, b);
                        if (paresImpressos.contains(par)) {
                            continue;   
                        }else{
                            System.out.print("(" + a + ", " + b + ") ");
                            paresImpressos.add(par);
                        }
                        
                    }
                }     
                PilhaGenerica.limparPilha();

            }
        }
    }
}


