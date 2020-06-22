package pattern.command.turn_light;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private List<ICommand> commandList;
    private Invoker invoker;


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {

        Receiver receiver = new Light("light");
        ICommand turnOnCommand = new TurnOnCommand(receiver);
        commandList = new ArrayList<>();
        commandList.add(turnOnCommand);

        invoker = new Invoker(turnOnCommand);

        invoker.executeCommand();

        Receiver receiver1 = new Motor("Motor");
        ICommand command = new TurnOnCommand(receiver1);
        commandList.add(command);

        invoker.executeCommand();

        commandList.stream().forEach(backup -> {
            invoker.setCommand(backup);
            invoker.undoCommand();
        });


    }
}
