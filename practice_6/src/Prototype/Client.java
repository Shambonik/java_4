package Prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype1_1 = new ConcretePrototype1(1);
        Prototype prototype1_2 = prototype1_1.clone();
        System.out.println(((ConcretePrototype1)prototype1_2).getN());
    }
}
