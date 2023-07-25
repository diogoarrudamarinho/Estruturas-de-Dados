package list2.Ex1;

import java.util.Scanner;

public class Ex1Main{

    public static void main(String[] args) {

        SistemaOperacional so = new SistemaOperacional(20);
        menu(so);

        
    }

    public static void menu(SistemaOperacional so){

        int opcao;
        String nome;
        int id;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("==== MENU ====");
            System.out.println("1. Inserir processo");
            System.out.println("2. Remover processo");
            System.out.println("3. Printar processos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 0:
                    break;

                case 1:

                    System.out.println("Digite o nome do Processo: ");
                    nome = scanner.next();

                    System.out.println("Digite o Id do Processo: ");
                    id = scanner.nextInt();

                    Processos processo = new Processos(nome, id);

                    if (so.novoProcesso(processo))
                        System.out.println("Processo adicionado");
                    else 
                        System.out.println("Fila cheia");
                    break;

                case 2:

                    Processos p = so.excluiProcesso();

                    if (p == null)
                        System.out.println("Fila Vazia");
                    else 
                        System.out.println("Removido");
                    break;

                case 3:
                    //TODO: consertar o tostring
                    System.out.println(so.toString());
                    
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