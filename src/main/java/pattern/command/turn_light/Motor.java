package pattern.command.turn_light;

public class Motor extends Receiver {


    public Motor(String name) {
        super(name);
    }

    @Override
    public void on() {
        System.out.println("Turn on the motor " + name);

    }

    @Override
    public void off() {
        System.out.println("Turn off the motor " + name);

    }
}
