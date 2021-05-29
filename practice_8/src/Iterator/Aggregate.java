package Iterator;

public interface Aggregate<T> {
    T get(int n);
    int count();
    Iterator createIterator();
}
