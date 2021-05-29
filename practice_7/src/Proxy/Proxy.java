package Proxy;

public class Proxy implements Subject{
    RealSubject realSubject = new RealSubject();

    @Override
    public synchronized int request() {
        System.out.println("Proxy");
        return realSubject.request();
    }
}
