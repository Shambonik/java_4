package AbstractFactory;

public class SecondFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new SecondProductA();
    }

    @Override
    public ProductB createProductB() {
        return new SecondProductB();
    }
}
