package Mediator;

public class ConcreteColleague2 extends Colleague {
    @Override
    public void getMessage(int message) {
        System.out.println("Col2 " + message);
    }
}
