package commands;
import java.util.HashMap;

public class Help {
    private HashMap<String, String> CommandHelpList = new HashMap<String, String>();
    public Help (){
        CommandHelpList.put("help", "The help command will display help for the available commands..");
        CommandHelpList.put("shot", "shot command lets you take a shot.");
        CommandHelpList.put("history", "history command will list all the shots fired.");
        CommandHelpList.put("exit","exit command will terminate the program.");
    }
    public void run(String [] commandParts){
        if (commandParts.length==1)
        {
            System.out.println("List of available commands:\n"  + CommandHelpList.keySet());

        }
        else
        {
            if (CommandHelpList.containsKey(commandParts[1])) {
                System.out.println(CommandHelpList.get(commandParts[1]));
            }
            else
                System.out.println("No such command found");

        }
    }
}
