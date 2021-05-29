import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class ThreadSafeMap implements Map {

    TreeMap map = new TreeMap();
    private static final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = map.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = false;
        try {
            semaphore.acquire();
            empty = map.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return empty;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = map.containsKey(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contains;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = map.containsValue(value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contains;
    }

    @Override
    public Object get(Object key) {
        Object o = null;
        try {
            semaphore.acquire();
            o = map.get(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Object put(Object key, Object value) {
        Object o = null;
        try {
            semaphore.acquire();
            o = map.put(key, value);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Object remove(Object key) {
        Object o = null;
        try {
            semaphore.acquire();
            o = map.remove(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void putAll(Map m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set keySet() {
        Set set = null;
        try {
            semaphore.acquire();
            set = map.keySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection c = null;
        try {
            semaphore.acquire();
            c = map.values();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> set = null;
        try {
            semaphore.acquire();
            set = map.entrySet();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }
}
