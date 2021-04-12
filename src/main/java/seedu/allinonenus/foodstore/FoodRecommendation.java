package seedu.allinonenus.foodstore;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FoodRecommendation {

    private final static String OUT_OF_BOUNDS_MESSAGE = "Selected location has no stores, please try again.";

    private final ArrayList<FoodStore> foodStoreList = new ArrayList<>();
    FoodStoreParser foodStoreParser = new FoodStoreParser();
    FoodStoreUi foodStoreUi = new FoodStoreUi();

    public FoodRecommendation() {

    }

    public void addStore(FoodStore toAdd) {
        foodStoreUi.addStore(toAdd);
        foodStoreList.add(toAdd);
    }

    public void deleteStore(int index) {
        foodStoreUi.deleteStore(foodStoreList.get(index));
        foodStoreList.remove(index);
    }

    public void clearList() {
        foodStoreUi.clearList();
        foodStoreList.clear();
    }

    public void recommendStore() throws FoodExceptions{
        foodStoreUi.showRecommendAvailableLocations();
        Scanner in = new Scanner(System.in);
        String userLocationInput = in.nextLine();
        boolean activeSystem = true;
        while (activeSystem) {
            switch (userLocationInput) {
            case "1":
                userLocationInput = "Frontier";
                activeSystem = false;
                break;
            case "2":
                userLocationInput = "The Deck";
                activeSystem = false;
                break;
            case "3":
                userLocationInput = "UTown";
                activeSystem = false;
                break;
            case "4":
                userLocationInput = "Techno Edge";
                activeSystem = false;
                break;
            case "5":
                userLocationInput = "";
                activeSystem = false;
                break;
            case "help":
                foodStoreUi.showRecommendAvailableLocations();
                break;
            default:
                foodStoreUi.printInvalidLocationInput();
                break;
            }
        }
        ArrayList<FoodStore> foodStores = new ArrayList<>();
        for (FoodStore foodStore : foodStoreList) {
            if (foodStore.toString().contains(userLocationInput)) {
                foodStores.add(foodStore);
            }
        }
        if (foodStores.isEmpty()) {
            throw new FoodExceptions(OUT_OF_BOUNDS_MESSAGE);
        }
        Random random = new Random();
        FoodStore foodStore = foodStores.get(random.nextInt(foodStores.size()));
        foodStoreUi.recommendStore(foodStore);
    }

    public void handleHalalCommand(Integer index) {
        FoodStore foodStore = foodStoreList.get(index);
        if (foodStore.isHalal) {
            foodStore.clearHalal();
        } else {
            foodStore.setHalal();
        }
        foodStoreUi.printUpdatedStore(foodStore);
    }

    public void handleFindCommand(String keyword) {
        foodStoreUi.showFindMessage();
        int index = 1;
        for (FoodStore foodStore : foodStoreList) {
            String storeInformation = foodStore.toString();
            boolean containsKeyword = storeInformation.contains(keyword);
            if (containsKeyword) {
                foodStoreUi.showToUser(index + ": " + storeInformation);
                index++;
            }
        }
        if (index == 1) {
            foodStoreUi.printFindError();
        } else {
            foodStoreUi.printDivider();
        }
    }

    public int getLocationInput() {
        foodStoreUi.showAvailableLocations();
        Scanner in = new Scanner(System.in);
        String userLocationInput = in.nextLine();
        while (true) {
            switch (userLocationInput) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "help":
                foodStoreUi.showAvailableLocations();
                break;
            default:
                foodStoreUi.printInvalidLocationInput();
                break;
            }
            userLocationInput = in.nextLine();
        }
    }

    public void run() {
        foodStoreUi.printWelcomeMessage();
        try {
            FoodStoreStorage.loadFile(foodStoreList);
        } catch (FileNotFoundException e) {
            foodStoreUi.printFileNotFound();
        }
        foodStoreUi.printAvailableCommands();
        runUntilExit();
        try {
            FoodStoreStorage.saveFile(foodStoreList);
        } catch (IOException e) {
            foodStoreUi.showToUser("Something went wrong: " + e.getMessage());
        }
        foodStoreUi.printExitMessage();
    }

    public void runUntilExit() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        boolean isExit = userInput.equals("bye");
        while (!isExit) {
            String[] inputArguments = userInput.split(" ");
            String keyword = inputArguments[0];
            boolean isAdd = keyword.equals("add");
            boolean isDelete = keyword.equals("delete");
            boolean isList = keyword.equals("list");
            boolean isRecommend = keyword.equals("recommend");
            boolean isClear = keyword.equals("clear");
            boolean isHelp = keyword.equals("help");
            boolean isHalal = keyword.equals("halal");
            boolean isFind = keyword.equals("find");
            if (isAdd) {
                try {
                    int locationIndex = getLocationInput();
                    FoodStore foodStore = foodStoreParser.parseAddCommand(userInput, locationIndex);
                    addStore(foodStore);
                } catch (FoodExceptions e) {
                    foodStoreUi.showToUser(e.getMessage());
                }
            } else if (isDelete) {
                try {
                    int index = foodStoreParser.parseDeleteCommand(userInput, foodStoreList.size());
                    deleteStore(index);
                } catch (FoodExceptions e) {
                    foodStoreUi.showToUser(e.getMessage());
                }
            } else if (isList) {
                foodStoreUi.printList(foodStoreList);
            } else if (isRecommend) {
                try {
                    recommendStore();
                } catch (FoodExceptions e) {
                    foodStoreUi.showToUser(e.getMessage());
                }
            } else if (isClear) {
                clearList();
            } else if (isHelp) {
                foodStoreUi.printAvailableCommands();
            } else if (isHalal) {
                try {
                    int index = foodStoreParser.parseHalalCommand(userInput, foodStoreList.size());
                    handleHalalCommand(index);
                } catch (FoodExceptions e) {
                    foodStoreUi.showToUser(e.getMessage());
                }
            } else if (isFind) {
                try {
                    String findCommandKeyword = foodStoreParser.parseFindCommand(userInput);
                    handleFindCommand(findCommandKeyword);
                } catch (FoodExceptions e) {
                    foodStoreUi.showToUser(e.getMessage());
                }
            } else {
                foodStoreUi.printUnknownCommand();
            }
            userInput = in.nextLine();
            isExit = userInput.equals("bye");
        }
    }


}
