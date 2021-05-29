package Prototype;

public class ConcretePrototype2 implements Prototype {
    private int k;

    public ConcretePrototype2(int k){
        this.k = k;
    }

    public ConcretePrototype2(ConcretePrototype2 target){
        this.k = target.k;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this);
    }
}
