package AbstractFactory;

public class Client {
    private ProductA productA;
    private ProductB productB;

    public Client(AbstractFactory factory){
        productA = factory.createProductA();
        productB = factory.createProductB();
    }
}
