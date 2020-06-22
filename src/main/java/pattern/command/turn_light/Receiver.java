package pattern.command.turn_light;

public abstract class Receiver {

    protected String name;

    public Receiver(String name) {
        this.name = name;
    }

    public abstract void on();

    public abstract void off();
}
