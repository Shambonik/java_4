package Builder;

public class Director {
    public static Product construct(Builder builder){
        builder.setK(10);
        builder.setN(20);
        return ((ConcreteBuilder) builder).getResult();
    }

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        System.out.println(construct(builder).k);

    }
}
