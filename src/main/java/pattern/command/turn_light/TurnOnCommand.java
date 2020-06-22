package pattern.command.turn_light;

public class TurnOnCommand implements ICommand{

    private Receiver receiver;

    public TurnOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.on();
    }

    @Override
    public void undo() {
        this.receiver.off();

    }
}
