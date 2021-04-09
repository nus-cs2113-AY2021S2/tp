package seedu.exceptions;

/**
 * Exception to handle any Find Command that returns nothing.
 */
public class IDNotFoundException extends HealthVaultException{
        private String IDType;

        /**
         * Constructor for IDNotFoundException class.
         *
         * @param IDType Type of ID (Nurse/Doctor/Patient) input.
         */
        public IDNotFoundException(String IDType) {
            this.IDType = IDType;
        }

        public String getMessage() {
            return "The " + IDType + " ID does not exist!";
        }
}
