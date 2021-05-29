package Mediator;

public abstract class Colleague {
    private Mediator mediator;
    public void sendMessage(int message){
        mediator.transferMessage(message, this);
    }
    public abstract void getMessage(int message);
}
