import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ThreadSafeSet implements Set {

    TreeSet set = new TreeSet();

    @Override
    public synchronized int size() {
        return set.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return set.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return set.toArray();
    }

    @Override
    public synchronized boolean add(Object o) {
        return set.add(o);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return set.addAll(c);
    }

    @Override
    public synchronized void clear() {
        set.clear();
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return set.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return set.retainAll(c);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return set.containsAll(c);
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return set.toArray(a);
    }
}
