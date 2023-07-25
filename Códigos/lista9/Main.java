
import ArvoreBusca.*;

public class Main
{
	public static void main(String args[])
	{
		ArvBinBusca<Integer, Integer> arvBinaria = new ArvBinBusca<>();
		
		int[] vetor = new int[10];
		for (int i = 0; i < 10; i++) 
			vetor[i] = i+1;

		arvBinaria.constroiArvore(vetor);
		arvBinaria.mostra();	
		
		Arvbin<Integer> 
            a1 = new Arvbin<Integer>(1),
            a2 = new Arvbin<Integer>(2),
            a3 = new Arvbin<Integer>(3),
            a4 = new Arvbin<Integer>(4),
            a5 = new Arvbin<Integer>(5),
            a6 = new Arvbin<Integer>(6);

		a1.defineEsq(a2);
		a1.defineDir(a3);
	
		a2.defineEsq(a4);
		a2.defineDir(a5);
	
		a3.defineEsq(a6);

		ArvBinBusca<Integer, Integer> a = new ArvBinBusca<>();
		
		a.transformaArvBinBusca(a1);
		a.mostra();

		a.removeForaIntervalo(1, 4);
		a.mostra();
		
	}
}
