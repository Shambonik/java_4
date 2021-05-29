package FactoryMethod;

public class ConcreteCreator extends Creator {

    @Override
    public ConcreteProduct factoryMethod(ProductType type){
        switch (type) {
            case CONCRETE:
                return new ConcreteProduct();
            default:
                return null;
        }
    }
}
