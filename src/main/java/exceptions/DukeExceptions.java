package exceptions;

public class DukeExceptions extends Exception {
    // Exception when invalid instructions are provided
    @Override
    public String getMessage(){
        return "Invalid input given" + super.getMessage();
    }
}
