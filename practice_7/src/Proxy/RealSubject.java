package Proxy;

public class RealSubject implements Subject {

    @Override
    public int request() {
        return 1;
    }
}
