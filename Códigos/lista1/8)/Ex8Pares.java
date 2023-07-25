

public class Ex8Pares {
    
    private int a;
    private int b;

    public Ex8Pares(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ex8Pares pares = (Ex8Pares) o;
        return a == pares.a && b == pares.b;
    }

}
