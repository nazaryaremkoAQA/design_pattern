package pattern.command.turn_light;

public class Light extends Receiver {

    public Light(String name) {
        super(name);
    }

    @Override
    public void on() {
        System.out.println("Turn on the light " + name);
    }

    @Override
    public void off() {
        System.out.println("Turn off the light " + name);

    }
}
