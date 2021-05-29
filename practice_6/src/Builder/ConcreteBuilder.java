package Builder;

public class ConcreteBuilder implements Builder {
    private int k;
    private int n;

    @Override
    public void setK(int k) {
        this.k = k;
    }

    @Override
    public void setN(int n) {
        this.n = n;
    }

    public Product getResult(){
        return new Product(k, n);
    }
}
