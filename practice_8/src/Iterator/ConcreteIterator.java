package Iterator;

import java.util.Objects;

public class ConcreteIterator implements Iterator {
    private Aggregate aggregate;
    private int current = 0;

    public ConcreteIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object next() {
        Object o = null;
        if(aggregate.count() > current){
            o = aggregate.get(current);
        }
        current++;
        return o;
    }
}
