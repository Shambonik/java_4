package Mediator;

public class ConcreteMediator implements Mediator {
    private ConcreteColleague concreteColleague;
    private ConcreteColleague2 concreteColleague2;

    public ConcreteMediator(ConcreteColleague concreteColleague, ConcreteColleague2 concreteColleague2) {
        this.concreteColleague = concreteColleague;
        this.concreteColleague2 = concreteColleague2;
    }

    @Override
    public void transferMessage(int message, Colleague sender) {
        if(sender.equals(concreteColleague)){
            concreteColleague2.getMessage(message);
        }
        else{
            concreteColleague.getMessage(message);
        }
    }
}
