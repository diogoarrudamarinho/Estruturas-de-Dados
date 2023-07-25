package list2.Ex1;

import list2.Filas.FilaGenerica;

public class SistemaOperacional {

    private FilaGenerica<Processos> processos;

    public SistemaOperacional(int tam){

        processos = new FilaGenerica<>(tam);

    }

    @Override
    public String toString() {
        return processos.toString();
    }

    public boolean novoProcesso(Processos p){
        return processos.insere(p);
    }

    public Processos excluiProcesso(){
        return processos.remove();
    }

    public boolean filaDeProcessosCheia(){
        return processos.cheia();
    }

    public boolean filaDeProcessosvazia(){
        return processos.vazia();
    }

    
}
