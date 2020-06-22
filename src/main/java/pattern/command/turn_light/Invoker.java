package pattern.command.turn_light;

public class Invoker {

    private ICommand command;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public void setCommand(ICommand command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }

    public void undoCommand(){
        this.command.undo();
    }
}
