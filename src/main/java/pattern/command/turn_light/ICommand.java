package pattern.command.turn_light;

public interface   ICommand {

    public abstract void execute();
    public abstract void undo();
}
