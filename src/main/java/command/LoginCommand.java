package command;

import canteens.Canteen;
import nusfoodreviews.NusFoodReviews;
import ui.Ui;

import java.util.ArrayList;

public class LoginCommand extends Command {

    NusFoodReviews nusFoodReviews;

    public LoginCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) {
        nusFoodReviews.resetAllIndex();
    }
}
