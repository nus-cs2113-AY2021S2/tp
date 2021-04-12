package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class IncorrectCommandsException extends Exception{

    public IncorrectCommandsException(){
        super("Incorrect Command! Please type 'help' should you require assistance\n");
    }

}
