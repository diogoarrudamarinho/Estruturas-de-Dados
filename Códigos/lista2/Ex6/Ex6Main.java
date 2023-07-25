package list2.Ex6;

import java.util.Scanner;

import list2.Filas.*;

public class Ex6Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("n: ");
        n = scanner.nextInt();
        
        Fila numeros = new Fila(n);

        for (int i = 1; i <= n; i++){
            numeros.insere(i);
        }

        while (!numeros.vazia()){
            System.out.print(Integer.toBinaryString(numeros.remove()) + " ");
        }

        scanner.close();
    }
    
}
