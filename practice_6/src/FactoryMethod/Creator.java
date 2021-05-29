package FactoryMethod;

public abstract class Creator {
    public abstract Product factoryMethod(ProductType type);
    public Product anOperation(ProductType type){
       return factoryMethod(type);
    }
}
