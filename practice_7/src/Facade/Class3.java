package Facade;

public class Class3 {
    private Class1 obj1;
    private int k;

    public Class3(Class1 obj1, int k) {
        this.obj1 = obj1;
        this.k = k;
    }

    public void changeK(){
        obj1.setK(k);
    }
}
