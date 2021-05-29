package Prototype;

public class ConcretePrototype1 implements Prototype {
    private int n;

    public int getN() {
        return n;
    }

    public ConcretePrototype1(int n){
        this.n = n;
    }

    public ConcretePrototype1(ConcretePrototype1 target){
        this.n = target.n;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this);
    }
}
