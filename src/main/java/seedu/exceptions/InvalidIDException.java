package seedu.exceptions;

public class InvalidIDException extends HealthVaultException{
    private String IDType;
    public InvalidIDException(String IDType){
        this.IDType = IDType;
    }
    public String getError() {
        return("Your " + IDType + " is Invalid");
    }
}