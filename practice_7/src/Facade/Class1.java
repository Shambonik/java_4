package Facade;

public class Class1 {
    private int k;
    private int n;

    public Class1(int k, int n) {
        this.k = k;
        this.n = n;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Class2 CreateObject2(){
        return new Class2(k);
    }

    public void printN(){
        System.out.println(n);
    }
}
