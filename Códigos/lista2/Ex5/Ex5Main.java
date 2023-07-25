package list2.Ex5;

import java.util.Scanner;
import list2.Filas.*;

public class Ex5Main {

    public static void main(String[] args) {
        
        exibirMenu();
        
    }

    public static void exibirMenu(){

        int opcao;
        FilaGenerica<Cliente> filaDeIdosos = new FilaGenerica<>(20);
        FilaGenerica<Cliente> fila = new FilaGenerica<>(20);
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("==== MENU ====");
            System.out.println("1. Inserir Cliente na Fila");
            System.out.println("2. Remover Cliente");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 0:
                    break;

                case 1:

                    System.out.println("Digite a idade do cliente: ");
                    System.out.println("OBS: Cliente prioritario se idade for maior que 64 ");
                    Cliente cliente = new Cliente(scanner.nextInt());

                    if (cliente.idoso()) {
                        filaDeIdosos.insere(cliente);
                    }else
                        fila.insere(cliente);
                   
                    break;

                case 2:

                    if (!filaDeIdosos.vazia()) 
                        filaDeIdosos.remove();   
                    else
                        fila.remove();

                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();

        } while(opcao != 0);

        scanner.close();

    }
    
}
