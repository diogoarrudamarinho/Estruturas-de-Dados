public class Conjunto {
    
    private boolean[] elemento;
    private int tamanho;

    public Conjunto(int N){

        tamanho = N;
        elemento = new boolean[tamanho];

        for (int i = 0; i < tamanho; i++)
            elemento[i] = false;
    }

    /* Complexidade O(n) */
    public boolean isVazio(){

        for (int i = 0; i < tamanho; i++)
            if (elemento[i] == true)
                return false;
            
        return true;
    }

    /* Complexidade O(n) */
    public boolean isUniverso(){

        for (int i = 0; i < tamanho; i++)
            if (elemento[i] == false)
                return false;
            
        return true;
    }

    /* Verifica se o conjunto é subconjunto de b */
    /* Complexidade O(n) */
    public boolean isSubconjunto(Conjunto b){

        if (b.tamanho < tamanho)
            return false;
                 
        for (int i = 0; i < tamanho; i++)
            if (b.elemento[i] == false && elemento[i] == true)
                return false;
        
        return true;
    }

    /* Verifica se o conjunto é subconjunto proprio de b */
    /* Complexidade O(n) */
    public boolean isSubconjuntoProprio(Conjunto b){

        if (b.tamanho < tamanho)
            return false;

        boolean isIguais = true;

        for (int i = 0; i < tamanho; i++)
        {
            if (b.elemento[i] == false && elemento[i] == true)
                return false;

            if (b.elemento[i] == true && elemento[i] == false)
                isIguais = false;
               
        }

        if (isIguais)
            return false;

        return true;
    }

    /* Complexidade O(n) */
    public void esvaziarConjunto(){

        for (int i = 0; i < tamanho; i++)
            elemento[i] = false;
    }

    /*Complexidade O(1) */
    public void insere(int elem){

        elemento[elem] = true;     

    }

    /*Complexidade O(1) */
    public void remove(int elem){

        elemento[elem] = false;  
    }

    /*Complexidade O(1) */
    public boolean verificaElemento(int elem){

        return elemento[elem] == true;
    }

    /*Complexidade O(n) */
    public int menorElemento(){

        for (int i = 0; i < tamanho; i++)
            if (elemento[i] == true)
                return i;     

        return Integer.MIN_VALUE;
    }

    /* Complexidade O(n) */
    public int maiorElemento(){

        for (int i = tamanho; i != 0; i--)
            if (elemento[i] == true)
                return i;
         
        return Integer.MIN_VALUE;       
    }

    /* Complexidade O(n) */
    public Conjunto retornaUniao(Conjunto b){

        int t = Math.max(tamanho, b.tamanho);

        Conjunto uniao = new Conjunto(t);

        for (int i = 0; i < uniao.tamanho; i++)
            if ((i < tamanho && elemento[i] == true) || (i < b.tamanho && b.elemento[i] == true))
                uniao.elemento[i] = true;

        return uniao;
    }

    /* Complexidade O(n) */
    public Conjunto retornaIntersecao(Conjunto b){

        Conjunto intersecao = new Conjunto(tamanho);

        for (int i = 0; i < tamanho; i++)
            if (elemento[i] == true && b.elemento[i] == true)
                intersecao.elemento[i] = true;

        return intersecao;
    }

    /* Complexidade O(n) */
    public int retortaCardinalidade(){

        int cardinalidade = 0;

        for (int i = 0; i < tamanho; i++)
            if (elemento[i] == true)
                cardinalidade++;

        return cardinalidade;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("{");

        for (int i = 0; i < tamanho; i++) {
            if (elemento[i]) {
                string.append(i);
                string.append(", ");
            }
        }

        if (string.length() > 1) 
            string.setLength(string.length() - 2);
    
        string.append("}");

        return string.toString();
    }
}
