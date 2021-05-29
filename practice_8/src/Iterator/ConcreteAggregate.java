package Iterator;

public class ConcreteAggregate implements Aggregate {

    private int[] array;

    public ConcreteAggregate(int[] array){
        this.array = array;
    }

    @Override
    public Integer get(int i) {
        return array[i];
    }

    @Override
    public int count() {
        return array.length;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
