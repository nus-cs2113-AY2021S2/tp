package seedu.exceptions;

public class IDNotFoundException extends HealthVaultException{
        private String IDType;

        public IDNotFoundException(String IDType) {
            this.IDType = IDType;
        }

        public String getMessage() {
            return "The " + IDType + " ID does not exist!";
        }
}
