package list2.Ex5;

public class Cliente {

    private int idade;

    public Cliente(int i){

        idade = i;
    }

    public boolean idoso(){
        return idade >= 65;
    }

    public int getIdade() {
        return idade;
    }
    
}
