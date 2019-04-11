package Parse;


import Movement.*;

import java.util.*;


public class StringCommandParser {


    // The movement letters are the key and the value is a new instance of the turn left class
    private static Map<String, IMovement> stringToCommandMap = new HashMap<String, IMovement>() {{
        put("L", new TurnLeft());
        put("R", new TurnRight());
        put("M", new Move());
    }};

    private String commandString;

    // Constructor
    public StringCommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<IMovement> toCommands() {
        if(isNullOrEmpty(commandString)) return new ArrayList<IMovement>();
        return buildCommandsList(commandString);
    }

    private List<IMovement> buildCommandsList(final String commandString) {
        List<IMovement> commands = new ArrayList<IMovement>();

        for(String commandCharacter : commandCharactersFrom(commandString)) {
            if (commandCharacter == null) break;
            IMovement mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(""), 0, commandString.length() + 1);
    }

    private IMovement lookupEquivalentCommand(final String commandString) {
        return stringToCommandMap.get(commandString);
    }
}
