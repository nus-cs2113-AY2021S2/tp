package command;

import canteens.Canteen;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import storage.Storage;
import ui.Ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewStoreCommand extends Command {

    private final NusFoodReviews nusFoodReviews;
    public static final String LINESPACING = "====================================================";

    public ViewStoreCommand(NusFoodReviews nusFoodReviews) {
        this.nusFoodReviews = nusFoodReviews;
    }

    @Override
    public void execute(ArrayList<Canteen> canteens, Ui ui) throws IOException, DukeExceptions {
        nusFoodReviews.setCanteenIndex();
        int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
        if (currentCanteenIndex == -1) {
            ui.showStoreNotAdded();
            return;
        }
        ui.showDisplayStores(canteens.get(currentCanteenIndex));
        System.out.println("Please enter the keyword:" + "'back' " + "to go back to the previous page");
        System.out.println(LINESPACING);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean check = true;
        while (check) {
            if (input.equals("back")) {
                check = false;
                System.out.println(LINESPACING);
                return;
            } else {
                System.out.println(LINESPACING);
                System.out.println("Please Input correctly");
                System.out.println(LINESPACING);
                input = sc.nextLine();
            }
        }
    }

}
