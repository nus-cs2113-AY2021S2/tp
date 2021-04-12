package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class WrongModuleFormatException extends Exception{
    public WrongModuleFormatException(){
        super("Please double check your module data format\n");
    }
}
