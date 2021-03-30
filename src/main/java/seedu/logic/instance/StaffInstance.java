package seedu.logic.instance;

import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.*;
import seedu.logic.command.Command;
import seedu.logic.command.StaffAggregation;
import seedu.logic.parser.staffparser;
import seedu.storage.StaffStorage;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.io.IOException;
import java.util.Scanner;

public class StaffInstance {
    private StaffUI staffUI;
    private StaffAggregation staffAggregation;
    private StaffStorage staffStorage;
    private staffparser staffParser;

    public StaffInstance(String filepath){
        staffUI = new StaffUI();
        staffStorage = new StaffStorage(filepath);
        staffParser = new staffparser();
        staffAggregation = new StaffAggregation();
    }


    public void run(){
        staffStorage.fileHandling(staffAggregation);
        StaffUI.staffMenuHeader();
        Scanner in = new Scanner(System.in);
        while (true) {
            StaffUI.staffMenuPrompt();
            String line;
            line = in.nextLine();
            try {
                Command c = staffParser.commandHandler(line);
                if (c==null){
                    continue;
                }
                c.execute(staffAggregation, staffUI, staffStorage);
                if (c.isExit()) {
                    System.out.println("Returning to start Menu!\n");
                    break;
                }
            } catch (WrongStaffIdException e) {
                StaffUI.wrongStaffIDErrorMessage();
            } catch (WrongListInputException e) {
                StaffUI.wrongStaffListInputErrorMessage();
            } catch (NoInputException e) {
                UI.noInputErrorMessage();
            } catch (AbortException e) {
                UI.abortInputErrorMessage();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExcessInputException e) {
                UI.tooManyInputErrorMessage();
            } catch (InsufficientInputException e) {
                UI.tooLittleInputErrorMessage();
            } catch (BlankInputException e) {
                StaffUI.blankInputErrorMessage();
            } catch (NumberFormatException | PositiveNumberOnlyException e) {
                StaffUI.invalidNumericErrorMessage();
            }
        }
    }
}
