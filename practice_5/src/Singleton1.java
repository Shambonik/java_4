public class Singleton1 {
    private Singleton1 instance;
    private Singleton1(){}
    public synchronized Singleton1 getInstance() {
        if(instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
