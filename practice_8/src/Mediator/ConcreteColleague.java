package Mediator;

public class ConcreteColleague extends Colleague {
    @Override
    public void getMessage(int message) {
        System.out.println("Col1 " + message);
    }
}
