package list2.Ex1;

public class Processos {
    
    private String nome;
    private int id;

    public Processos(String s, int i){

        nome = s;
        id = i;

    }

    @Override
    public String toString() {
        
        return String.format("(%s, %d)", nome, id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
