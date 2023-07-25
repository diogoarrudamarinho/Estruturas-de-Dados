import java.util.Scanner;

public class Ex7MainPilha
{
    private static boolean retornaLetraOuDigito(char c)
    {
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }
 
    private static int prioridade(char ch)
    {
 
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
     
    private static boolean isOperador(char ch) {
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }
   
    private static boolean verificaString(String expressao)
    {
        
        Ex7PilhaGenerica<Character> PilhaGenerica = new Ex7PilhaGenerica<>();
        int contadorParenteseAberto = 0;
        int contadorParenteseFechado = 0;

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '('){
                contadorParenteseAberto++;
            }else if (c == ')') {
                contadorParenteseFechado++;
            }
        } 

        if (contadorParenteseAberto != contadorParenteseFechado)
            return false;
    
        for (int i = 0; i < expressao.length(); ++i) {
            
            char c = expressao.charAt(i);

            if (retornaLetraOuDigito(c))
                continue;
            else if (c == '(')
                PilhaGenerica.push(c);
            else if (c == ')') {
                while (!PilhaGenerica.vazia()
                       && PilhaGenerica.retornaTopo() != '(')
                    PilhaGenerica.pop();
 
                PilhaGenerica.pop();
            }else {
                while (!PilhaGenerica.vazia() && prioridade(c) <= prioridade(PilhaGenerica.retornaTopo()) && isOperador(c))
                    PilhaGenerica.pop();
                
                PilhaGenerica.push(c);
            }
        }
        
        while (!PilhaGenerica.vazia()) {
            if (PilhaGenerica.retornaTopo() == '(')
                return false;
            PilhaGenerica.pop();
        }
        return true;
    }
 
    public static void main(String[] args)
    {
        String expressao;
        Scanner scanner = new Scanner(System.in);
        
        expressao = scanner.nextLine();

        System.out.println(verificaString(expressao));
        scanner.close();
    }
}


