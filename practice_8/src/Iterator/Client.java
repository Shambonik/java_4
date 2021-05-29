package Iterator;

public class Client {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 1, 4, 6};
        Aggregate aggregate = new ConcreteAggregate(arr);
        Iterator iterator = aggregate.createIterator();
        Integer x = null;
        do{
            x = (Integer) iterator.next();
            System.out.println(x);
        }while(x!=null);
    }
}
