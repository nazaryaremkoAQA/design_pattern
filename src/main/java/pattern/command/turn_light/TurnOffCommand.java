package pattern.command.turn_light;

public class TurnOffCommand implements ICommand{

    private Receiver receiver;

    public TurnOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.off();
    }

    @Override
    public void undo() {
        this.receiver.on();

    }
}
