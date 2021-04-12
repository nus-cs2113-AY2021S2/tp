package seedu.allinonenus;

import seedu.allinonenus.capcalculatorclasses.CapCalculator;
import seedu.allinonenus.foodstore.FoodRecommendation;
import seedu.allinonenus.moduleplanner.ModulePlanner;
import seedu.allinonenus.teamplannerclasses.TeamPlanner;

import java.util.Scanner;

public class OverallParser {

    public OverallParser() {

    }

    public void run() {
        requestForFeatureMode();
        displayExitMessage();
    }

    public void displayExitMessage() {
        System.out.println("Thank you for using All-in-oneNUS, we hope to see you again!");
    }

    void greetUserAndDisplayFeatures() {
        System.out.print("Welcome to All-in-OneNUS app!\n");
        System.out.print(
                "Enter 1 to access Team Planner\n"
                        + "Enter 2 to access Cap Calculator\n"
                        + "Enter 3 to access Module Planner\n"
                        + "Enter 4 to access Food Recommendation app\n"
                        + "Enter bye to exit app\n");
    }

    void requestForFeatureMode() {
        while (true) {
            greetUserAndDisplayFeatures();
            Scanner choice = new Scanner(System.in);
            String chosen = choice.nextLine();

            switch (chosen.toLowerCase()) {
            case "bye":
                return;
            case "1":
                new TeamPlanner().run();
                break;
            case "2":
                new CapCalculator().run();
                break;
            case "3":
                new ModulePlanner().run();
                break;
            case "4":
                new FoodRecommendation().run();
                break;
            default:
                System.out.print("Invalid input. Please try again!\n");
                break;
            }
        }
    }
}