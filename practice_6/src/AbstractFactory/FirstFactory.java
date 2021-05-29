package AbstractFactory;

public class FirstFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new FirstProductA();
    }

    @Override
    public ProductB createProductB() {
        return new FirstProductB();
    }
}
