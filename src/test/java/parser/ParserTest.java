package parser;

import command.Command;
import command.DisplayMenusCommand;
import command.ExitCommand;
import command.HomeCommand;
import command.ReadReviewsCommand;
import command.ResetStoreCommand;
import nusfoodreviews.NusFoodReviews;
import stores.Store;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;
import canteens.Canteen;
import ui.Ui;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParserTest {

    private int maxStores = 1;
    Canteen canteen = new Canteen("The Deck");
    Store store = new Store("Techno Edge");
    NusFoodReviews nusFoodReviews = new NusFoodReviews("\"data/storage.txt\"");
    Ui ui = new Ui();

    @Test
    public void parse_list_displayCommand() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        Command c = parser.parse("list",store, maxStores);
        assertTrue(c instanceof ResetStoreCommand);
    }

    @Test
    public void parse_menu_success() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        Command c = parser.parse("menu",store, maxStores);
        assertTrue(c instanceof DisplayMenusCommand);
    }

    @Test
    public void parse_ExceedStoreIndex_exceptionThrown() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        try {
            parser.parseInt("0",1, 1);
        } catch (Exception e) {
            assertEquals("Please enter a valid index!", e.getMessage());
        }
    }

    @Test
    public void parse_exit_displayCommand() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        Command c = parser.parse("exit",store, maxStores);
        assertTrue(c instanceof ExitCommand);
    }

    @Test
    public void parse_home_displayCommand() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        Command c = parser.parse("home",store, maxStores);
        assertTrue(c instanceof HomeCommand);
    }

    @Test
    public void parse_reviews_displayCommand() throws DukeExceptions {
        Parser parser = new Parser(nusFoodReviews);
        Command c = parser.parse("reviews",store, maxStores);
        assertTrue(c instanceof ReadReviewsCommand);
    }


}