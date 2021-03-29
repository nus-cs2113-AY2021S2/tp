package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.NusMap;
import seedu.duke.ui.NoteUi;
import seedu.duke.ui.UiManager;
import seedu.duke.data.History;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.Favourite;
import seedu.duke.NotesCommandParser;

import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.NoLocationForNotesCommandException;
import seedu.duke.exception.NonExistentLocationForNotesCommandException;
import seedu.duke.exception.WrongInputFormatException;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.NotesCommandParser.note;

public class AddNoteCommand extends Command {

    protected NoteUi ui;
    public AddNoteCommand() {
        this.ui = new NoteUi();
    }

    @Override
    public void execute(NusMap nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, Favourite favourite) {
        try {
            NotesCommandParser.parseAddNotesCommand(userInput, nusMap);
            nusMap.map.get(location).addNotes(); //add notes to block given by user
            ui.showMessageWithDivider("This note has been added and tagged to " + location + ":" + "\t" + note);
        } catch (WrongInputFormatException | NoLocationForNotesCommandException
                | NonExistentLocationForNotesCommandException | EmptyNoteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
