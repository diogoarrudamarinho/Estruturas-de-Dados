import java.util.Scanner;

public class Ex5MainPilha
{
	public static boolean verificaBalanceamento(String expressao) {
        Ex5Pilha pilha = new Ex5Pilha();
        String caracteresAbertura = "([{";
        String caracteresFechamento = ")]}";
        
        for (char ch : expressao.toCharArray()) {

            if (caracteresAbertura.contains(String.valueOf(ch))) {
				pilha.push(ch);
            } else if (caracteresFechamento.contains(String.valueOf(ch))) {

                if (pilha.vazia()) {
                    return false;
                }

                char topo = pilha.pop();

                if (caracteresAbertura.indexOf(topo) != caracteresFechamento.indexOf(ch)) {
                    return false;
                }
            }
        }
        
        return pilha.vazia();
    }

    public static void main(String[] args) {
        String expressao;
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite a expressao");
		expressao = scan.nextLine();
		if(verificaBalanceamento(expressao)){
            System.out.println("Balanceado");
        }else
            System.out.println("Nao Balanceado");
		scan.close();

	}
}


