package Questoes;

public class Respostas {

    /*  Questão 1)
     *  
     *      Uma heap é uma estrutura de dados em forma de árvore implementada como um array que
     * possui a seguinte propriedade: Em uma heap Máxima, todos os nós são maiores ou iguais aos seus filhos,
     * e, em uma heap Mínima, os nós são menores ou iguais aos seus filhos. Os filhos de um nó 'i' estão armazenados 
     * em '2*i' (Filho Esquerdo), e '2*i + 1' (Filho direito)
     * 
     *      Exemplo de heap Maxima 
     *        
     *             90
     *           /     \            Posicao 0 do vetor é ignorada
     *          85      82          Heap = {90, 85, 82, 72, 70, 65, 50, 40, 30, 20}
     *         /  \    /  \         
     *        72  70  65  50
     *      /  \  /
     *     40  30 20
     * 
     * 
     *  Questão 7)
     *  
     *      {22, 4, 35, 12, 3, 18, 12, 55}
     *
     *      Passo 1: constroiHeap()
     * 
     *       Vetor: {22, 4, 35, 12, 3, 18, 12, 55}
     * 
     *       Após o refaz(4):
     *       Vetor: {22, 4, 35, 55, 3, 18, 12, 12}
     * 
     *       Após o refaz(3):
     *       Vetor: {22, 4, 35, 55, 3, 18, 12, 12}
     * 
     *       Após o refaz(2):
     *       Vetor: {22, 55, 35, 12, 3, 18, 12, 4}
     * 
     *       Após o refaz(1):
     *       Vetor: {55, 22, 35, 12, 3, 18, 12, 4}
     *
     *       Heap Construida.
     * 
     *      Passo 2: Ordenação da Heap
     *          
     *      Variaveis 
     *      {
     *          resta = 8
     *          raiz = 1
     *      }
     * 
     *      interações do while (resta > 1)
     * 
     *      Vetor: {55, 22, 35, 12, 3, 18, 12, 4}
     * 
     *      Após a primeira iteração do while:
     *      Vetor: {4, 22, 35, 12, 3, 18, 12, 55} // Troca o primeiro com o ultimo e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {35, 22, 18, 12, 3, 4, 12, 55}
     * 
     *      Após a segunda iteração do while:
     *      Vetor: {12, 22, 18, 12, 3, 4, 35, 55} // Troca o primeiro com o ultimo decrementado e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {22, 12, 18, 12, 3, 4, 35, 55}
     * 
     *      Após a terceira iteração do while:
     *      Vetor: {4, 12, 18, 12, 3, 22, 35, 55} // Troca o primeiro com o ultimo decrementado e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {18, 12, 4, 12, 3, 22, 35, 55}
     * 
     *      Após a quarta iteração do while:
     *      Vetor: {3, 12, 4, 12, 18, 22, 35, 55} // Troca o primeiro com o ultimo decrementado e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {12, 12, 4, 3, 18, 22, 35, 55}
     *
     *      Após a quinta iteração do while:
     *      Vetor: {3, 12, 4, 12, 18, 22, 35, 55} // Troca o primeiro com o ultimo decrementado e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {12, 3, 4, 12, 18, 22, 35, 55}
     * 
     *      Após a sexta iteração do while:
     *      Vetor: {4, 3, 12, 12, 18, 22, 35, 55} // Troca o primeiro com o ultimo decrementado e decrementa n e resta
     *      Refaz a heap passando a raiz
     *      Vetor: {4, 3, 12, 12, 18, 22, 35, 55}
     *      
     *      Ultima interacao do while:
     *      Vetor: {3, 4, 12, 12, 18, 22, 35, 55}
     *      Refaz heap
     *      Vetor: {3, 4, 12, 12, 18, 22, 35, 55}
     *      
     *      Resumindo o algoritmo: Como a heap Maxima garante que o maior valor seja a raiz,
     *      pega-se a raiz e troca com o ultimo elemento, decrementa o ultimo elemento e refaz
     *      a heap para a propriedade garantir o maior valor na raiz.
     * 
     */
}
