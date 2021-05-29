package Facade;

public class Facade {
    private Class1 class1;
    private Class2 class2;
    private Class3 class3;
    private Class4 class4;

    public Facade() {
        this.class1 = new Class1(10, 5);
        this.class2 = class1.CreateObject2();
        this.class3 = new Class3(class1, 7);
        this.class4 = new Class4();
    }

    public void startFacade(){
        class1.printN();
        class2.printSomething();
        class4.printClass1K(class1);
        class3.changeK();
        class4.printClass1K(class1);
    }
}
