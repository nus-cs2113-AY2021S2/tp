# Developer Guide

## Introduction

`FridgeFriend` is an app for managing food in the fridge, optimised for use via a Command Line Interface (CLI).
If you can type fast, `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
It is written in Java, and has more than 4.3kLoC.

## Contents

* [Introduction](#introduction)
* [Design](#design)
  * [Architecture](#architecture)
  * [Utilities Component](#utilities-component)
  * [Command Component](#command-component)
  * [Food Component](#food-component)
  * [Exception Component](#exception-component)
* [Implementation](#implementation)
  * [Main Logic](#main-logic)
  * [Add Command](#add-command)
  * [List Command](#list-command)
  * [Remove Command](#remove-command)
  * [Search Command](#search-command)
  * [Storage](#storage-command)
* [Product Scope](#product-scope)
  * [Target User Profile](#target-user-profile)
  * [Value Proposition](#value-proposition)
* [User Stories](#user-stories)
* [Non-Functional Requirements](#non-functional-requirements)
* [Glossary](#glossary)
* [Instructions for Manual Testing](#instructions-for-manual-testing)
* [Attribution](#attribution)

## Design

This section focuses on the general architecture of the application as well as the relationships between the classes involved. The overall architecture would be covered first, before the four individual components.

### Architecture

![Architecture Diagram](diagrams/diagram_images/ArchitectureDiagram.png)

The ***Architecture Diagram*** given above explains the high-level design of the App.
Given below is a quick overview of each component.

The Main driver class for the FridgeFriend app is
named **[`FridgeFriend`](https://github.com/AY2021S2-CS2113-T10-1/tp/blob/master/src/main/java/seedu/fridgefriend/FridgeFriend.java)**.
It is responsible for,

* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

The rest of the App consists of four components.

* [**`Utilities`**](#utilities-component): The main component containing the key driver classes in
  FridgeFriend, such as `Parser`, `UI`, and `Storage`.

* [**`Command`**](#command-component): Executes commands based on the input obtained
  and processed from `Parser` in `Utilities`. The list of executable commands can be found in our
  [User Guide](https://ay2021s2-cs2113-t10-1.github.io/tp/UserGuide.html).

* [**`Food`**](#food-component) represents a collection of classes used by the FridgeFriend application.
  Food objects are instantiated by the `Command` Component. Once a `Food` object is created,
  it may be stored to disk using the `Storage` function in `Utilities`.

* [**`Exception`**](#exception-component) represents a collection of classes that represent potential
  exception events that may occur during the usage of `FridgeFriend`. The `Exception` component
  facilitates the return of exceptions to the `UI` class in `Utilities`, which will display
  the error message to the user.

### Utilities Component

The Utilities component contains the main classes that run the main functions of FridgeFriend.

![Utilities Class Diagram](diagrams/diagram_images/UtilitiesClassDiagram.png)

The ***Utilities Class Diagram*** given above shows how the classes in the Utilities component interact with each other and classes from other component.

The Utilities Component consists for 4 classes.

* **`LoggingHandler`**: Logs information during execution to the console.
* **`Parser`**: Breaks down user input into relevant objects.
* **`Storage`**: Reads data from, and writes data to, the local disk.
* **`Ui`**: Handles the input and output of the application.

### Command Component

The Command component contains the sub classes of the features that will be executed.

The command Object is executed by the main method in FridgeFriend.
The execution of the command can affect the fridge.
After the execution, the results of the command object is pass to the UI.
The results of the command instruct the Ui to display the message return to the user.

![Command Class Diagram](diagrams/diagram_images/CommandClassDiagram.png)

The ***Command Class Diagram*** given above shows how the Command interacts with Fridge class.

The Command Component consist of 11 sub class which each command represents a features.

* **`AddCommand`**: Add a new food object to the fridge or add the quantity of existing food item with same parameters when executed.
* **`RemoveCommand`**: Remove a portion of food quantity from a particular food in the fridge when executed.
* **`ListCommand`**: List details of food either by a category, storage location or all off it when executed.
* **`SearchCommand`**: Search for the food that contains a particular food name.
* **`ExpiringCommand`**: Provide the list of item that is expiring in a week when executed.
* **`ClearCommand`**: Clear the list of food objects in the fridge object.
* **`HelpCommand`**: List the instruction on how to use all the commands in FridgeFriend.
* **`RunningLowCommand`**: Provide the food category that are running low compare to the limit set in the Food Category.
* **`SetLimitCommand`**: Change the default quantity limit in that particular Food Category.
* **`HistoryCommand`**: Display the details of food items that has been added to the fridge.  
* **`ByeCommand`**: Indicate to the main method to exit the program.

### Food Component

The Food component represents the basic `Food` object and related class in FridgeFriend.

* `Food` is an abstract class which has multiple child Food classes, distinguished by category.
This is to facilitate different manipulations on different food categories.
* `Fridge` maintains the list of `Food`s and have methods to add, remove or modify the foods.
* `Fridge` uses `UniqueFoodnameChecker` to perform add tasks under different user input scenarios.
* Whenever a `Food` object is created or called, exceptions may be thrown.

![Food Class Diagram](diagrams/diagram_images/FoodClassDiagram.png)

The ***Food Class Diagram*** given above shows all the classes derived from Food or 
used in Food operations.

### Exception Component

The Exception component represents a collection of classes that represent potential
exception events that may occur during the usage of `FridgeFriend`.

The `Exception` component facilitates the return of exceptions to the `UI` class
in `Utilities`, which will display the corresponding error message to the user.

![Exception Class Diagram](diagrams/diagram_images/ExceptionClassDiagram.png)

The ***Exception Class Diagram*** given above shows the custom `Exceptions`
created for the FridgeFriend project, and stored inside the `Exceptions` component.

All exceptions extend from the Java default `Exception` class. They only differ with regard
to the throwable error message.

The `Exceptions` component currently consists of nine (9) custom Exceptions, as of v2.0:

Among these ten custom exceptions, the `Exceptions` component can generally be
classified into three broad categories:

_Exceptions related to invalid user input:_

* **`EmptyDescriptionException`**: Is thrown when an empty input string is detected by `Parser`, where
  an input is expected.
  * Error Message: `"Sorry my friend, the description cannot be empty."`
* **`InvalidDateException`**: Is thrown when user input, where a date is expected, does not
  match the `dd-mm-yy` format.
  * Error Message: `"Sorry my friend, the date must be in the form 'dd-mm-yy'."`
* **`InvalidInputException`**: Is thrown when an unrecognised command is input into FridgeFriend,
  or when the List Command does not recognise the secondary input string.
  * Error Message: `"Sorry my friend, please give a valid input."`
* **`InvalidQuantityException`**: Is thrown when user input is not an integer where an integer is expected for
  `Quantity` related functions, or when excess quantity of food is removed from the Fridge, where the quantity
  of food in the fridge remaining would be negative.
  * Error Message: `"Sorry my friend, the quantity QUANTITY_INPUT must be a number."`
  * Error Message: `"Not enough in fridge to remove!"`

_Exceptions related to Food:_

* **`FoodNameNotFoundException`**: Is thrown when the input string contains the name of a Food that is
  not found in the Fridge, where the name of a food existing in the Fridge is expected.
  * Error Message: `"Food specified not found."`
* **`InvalidFoodCategoryException`**: Is thrown when user input is not a valid `FoodCategory`,
  where a valid `FoodCategory` is expected. Users can check `help` or the
  [User Guide](https://ay2021s2-cs2113-t10-1.github.io/tp/UserGuide.html).
  * Error Message: `"Sorry my friend, FOOD_CATEGORY is not a valid category."`
* **`RepetitiveFoodIdentifierException`**: Is thrown when user attempts to add duplicate Food to the Fridge in a
  different location or with a different expiry date. This is not allowed as of v2.0.
  * Error Message: `"Sorry my friend, you have added this food before but in a different location or have different expiry dates.
      Please specify another foodname."`

_Exceptions related to file storage:_

* **`StorageLoadingException`**: Is thrown when an error occurred during loading of the saved data.
  * Error Message: `"There was an error loading the data for FridgeFriend!"`
* **`StorageSavingException`**: Is thrown when an error occurred during saving of the current data.
  * Error Message: `"There was an error saving the data for FridgeFriend!"`

## Implementation

This section covers the application flow and more specific interactions between classes and their methods. A overview of the main application logic would be covered first, before addressing several specific application commands.

### Main Logic

The main application logic underlines the main executable conditions that make up the bulk of the application. Below is the outline of the logic:

1. `FridgeFriend` uses the `Ui` class to obtain the user input.
2. `FridgeFriend` then uses the `Parser` class to parse the user input.
3. This results in the construction of a `Command` object that is returned to `FridgeFriend`.
4. Following that, `FridgeFriend` then self-invokes a method that executes the `Command` object.
5. In this method, the `Command` object  executes its specified action.
6. From steps 2 to 5, should there be an error thrown, the `Command` class would construct an `Exception` object.
7. Lastly, the `Exception` would be thrown back to `FridgeFriend`, which will then use the `Ui` class to display an error message to the user.

Given below is the sequence diagram for the interactions within the main application logic.

![MainLogicSequenceDiagram](diagrams/diagram_images/MainLogicSequenceDiagram.png)

:information_source: Information:

* The lifeline for `Parser`, `Command`, and `Exception` should end at the destroy marker. However, due to a limitation of PlantUML, the three lifelines reach the end of the diagram.
* Due to the lack of a standard to represent try-catch blocks in UML, the `alt` frame in this diagram is used to indicate a try-catch block.
  Additionally, while the diagram shows the `Exception` object being initialised by `FridgeFriend`, it is actually initialised in the `Parser` or `Command` class and thrown to `FridgeFriend`

### Add Command

AddCommand class is initialized whenever the parser recognize the `add` keyword.

1. The constructor should create a new Food object according to the parsed user input.
2. The UniqueFoodnameChecker will be called from Fridge class to decide whether to add a new `Food` or edit on existing `Food`.

Given below is the sequence diagram for the AddCommand workflow.

![AddCommandSequenceDiagram](diagrams/diagram_images/AddSequenceDiagram.png)

Notes:

* The `UniqueFoodnameChecker` object will be destructed after use, but the `Food` object and `Fridge` object will still exist after the command finishes.
* Some function calls such as showResults() in `Command` is not covered in this diagram. So the `Command` object will only be destructed after all function calls on that iteration.

:information_source: Information:

* The lifeline for `UniqueFoodnameCheck` should end at the destroy marker. However, due to a limitation of PlantUML, the lifelines reach the end of the diagram.

### Remove Command

When the user specify to remove a portion of a food item in the fridge, the `remove` command
will execute the remove operation by:

1. Searching of the food item in the fridge by looping through each food item.  
2. If the food item exist, check if removing the quantity will reduce the quantity to zero.
3. If it does not reduce to zero, then proceed to remove the required quantity.
4. If it does reduce to zero, then remove the food item completely.
5. Otherwise, throw an exception to FridgeFriend.

The sequence diagram below shows how the `remove` operation works:

![RemoveSequenceDiagram](diagrams/diagram_images/RemoveSequenceDiagram.png)

:information_source: Information:

The lifeline for `Food` should end at the destroy marker. However, due to a limitation of PlantUML, the lifeline reach the end of the diagram.

### Search Command

When the user specify to search a food item in the fridge, the `search` command will execute
search operation by:

1. Searching the list of foods in the fridge by that contain the food name entered by the user
  through a loop.
2. Afterwards, pass the success message or failure message to the UI.

The sequence diagram shows how the `search` operation works:

![SearchSequenceDiagram](diagrams/diagram_images/SearchSequenceDiagram.png)

### Running Low Command

The `runningLow` command is implemented by:

1. Checking the total quantity of each FoodCategory in the fridge.
2. Follow by comparing with the default minimum number of quantity in each FoodCategory.
3. Then return all the FoodCategory that has quantity lower than the default minimum number of quantity as a warning message
4. Otherwise, return isStockUp message.

The sequence diagram shows how the `runninglow` operation works:

![RunningLowSequenceDiagram](diagrams/diagram_images/RunningLowSequenceDiagram.png)

### Set Limit Command

The `setlimit` command is implemented by:

1. Calling a setter method in FoodCategory.
2. The setter method will change the FoodCategory predefined minimum number of quantity.
3. The FoodCategory and new minimum number of quantity is specified by the user.

The sequence diagram shows how the `setlimit` operation works:

![SetLimitSequenceDiagram](diagrams/diagram_images/SetLimitSequenceDiagram.png)

### Expiring Command

The `expiring` command is implemented through looping of the food items in the fridge and
return the food item if the expiry date is within one week of calling the command.

The sequence diagram shows how the `expiring` operation works:

![ExpiringSequenceDiagram](diagrams/diagram_images/ExpiringSeqeunceDiagram.png)

### List Command

There are three variations of the `list` command.

1. List all food
2. List by category
3. List by storage location

The first command, list all food, is implemented by iterating through the collection
of food in the fridge. The names of all the food is concatenated using a Java StringBuilder,
and the final result, containing the list of all food, is returned to the main program.

The second and third commands, list by category or storage location, is also implemented by iterating through
the collection of food in the fridge. However, there is an additional check to verify if the given
food contains the correct category/storage location attribute as requested by the user.

If the category/storage location is as requested, the name of the food will be concatenated to the
result using a Java StringBuilder. Otherwise, the name of the food would not be part of the result.
The final result, containing the list of all food belonging to the category/storage location,
is returned to the main program.

The sequence diagram shows how the `list` operation works:

![ListCommandSequenceDiagram](diagrams/diagram_images/ListCommandSequenceDiagram.png)

### History Command

The code related to persistent storage for the `history` command is implemented under the `Storage` class
under the `Utilities` component.

The implementation of the `history` command is as follows:

1. After every `add` command, a copy of the added food will be appended to `historyData.txt`
2. When the user invokes the `history` command, `historyData.txt` will be read, line by line.
3. The line-by-line contents of `historyData.txt` are concatenated into a single output string  
4. The output string that contains the history data will be output to the user.

Additionally, the command `history clear` deletes the contents of `historyData.txt` on the disk.

## Product Scope

### Target User Profile

* is a new homeowner who cooks
* has a needs to manage a significant number of foods in the fridge
* has a tendency to forget expiry date and location of the food stored
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI app

### Value Proposition

This app allows user to monitor their food in a fridge faster than a typical mouse/GUI driven app.
It includes features such as ability to check for the foods that are expiring in a week, and the food item
that requires to top up. It will help new homeowners to keep track of their food into different food 
categories and storage location which provide ease of searching it. In addition, new homeowners will be abe to 
keep track of past food items that has been added to the fridge. 

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v1.0|user|add items into the fridge|keep track of what is in the fridge|
|v1.0|user|remove items from the fridge|keep track of what is in the fridge|
|v1.0|user|list all food items in the fridge|know inside the fridge without having to open the fridge itself|
|v1.0|forgetful user|search for a specific food item|recall if I have that food item inside the fridge|
|v1.0|organised user|tag the food’s category when I add into fridge(e.g. veggies, meat, dairy)|track what kinds of food I have in the fridge|
|v1.0|organised user|list food items by category|check specific categories of food|
|v1.0|organised user|add a storage location for a specific food item|know which part of the fridge is stored in|
|v1.0|organised user|add the expiry date to each food item I put into the fridge|keep track of what is going to expire|
|v1.0|lazy user|search for items that are expiring|see what items are about to expire without having to open the fridge|
|v1.0|lazy user|automatically save information to a data file|safely exit the system without losing information|
|v1.0|lazy user|automatically retrieve previously saved information from a data file|know the list of items I already have in my fridge|
|v2.0|lazy user|list all food stored in a part of the fridge|track how full each location is without having to open the fridge|
|v2.0|meticulous user|specify the weight or quantity of each food item I add into the fridge|know the exact amount of the food item I have left|
|v2.0|meticulous user|remove a certain weight of each food package item that I am going to use|know how much weight of the item it has left|
|v2.0|forgetful user|define the lower limits of each food category that the fridge should contain|receive reminders that the food is depleted|
|v2.0|forgetful user|receive warnings when certain food items are running low after I remove a food item|not personally check for food quantity|
|v2.0|lazy user|request for a list of food items running low or expiring|easily create a shopping list|
|v2.0|health conscious user|view the history of food items that I have bought in the past|better track my food habits|

## Non-Functional Requirements

### Performance and scalability

* Constraint: Single-User

The product should be for a single user i.e. (not a multi-user product).

**Reason**: multi-user systems are hard to test, which is unfair for peer testers who will be graded based on the number of bugs they find.

* Constraint: Typing-Preferred

The product should be targeting users who can type fast and prefer typing over other means of input.

**Reason**: to increase comparability of products, and to make feature evaluation easier for peer evaluators.

### Portability and compatibility

* Constraint: Platform-Independent

The software should work on the Windows, Linux, and OS-X platforms.

**Reason**: Peer testers should be able to use any of these platforms.

* Constraint: Java-Version

The software should work on a computer that has version 11 of Java i.e., no other Java version installed.

### Reliability, availability, maintainability

 As it is a locally-runned command line application, there will be no down time for users.
 It should be available anytime and anywhere.

* Constraint: No-Remote-Server

The software should not depend on any remote servers.

### Security

* Constraint: Human-Editable-File

The data should be stored locally and should be in a human editable text file.
Thus the data is not protected by nature.

**Reason**: To allow advanced users to manipulate the data by editing the data file.

### Usability

It is very easy for a user to use the system. There is a detailed user guide provided as well as a help command.

## Glossary

* **Human-Editable-File**: files with .txt

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

:information_source: **Note:** These instructions only provide a starting point for testers to work on, testers are expected to do more *exploratory* testing.

### Launch and shutdown

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `FridgeFriend` from [here](https://github.com/AY2021S2-CS2113-T10-1/tp/releases/latest).
3. Copy the file to the folder you want to use as the home folder for your `FridgeFriend`.
4. Open your Command Line Terminal in the folder where `FridgeFriend.jar` is located, and run
   `FridgeFriend` with `java -jar FridgeFriend.jar`.
5. Type the command in the command box and press Enter to execute it. e.g. typing list and pressing Enter will show a
   list of all current food.
6. To terminate the app, use the `bye` command. It is also acceptable to interrupt the Command Line Terminal with
   `Ctrl+C` or closing the terminal.

### Adding food

When adding food, the `FridgeFriend` application requires a very specific format, so that all attributes of
a given food can be added to the Fridge. This might be very troublesome for manual testing.

Here are some inputs you can try:

* `add chicken /cat meat /exp 30-06-2021 /loc lower_shelf /qty 100`
  * Inputs a `chicken` of category `meat`, with expiry date of `30-06-2021`, location of `lower_shelf`, and
    quantity of `100`.
* `add milk /cat dairy /exp 31-12-2021 /loc fridge_door /qty 2`
  * Inputs a `milk` of category `dairy`, with expiry date of `31-12-2021`, location of `fridge_door`, and
    quantity of `2`.
* `add Coke /cat beverage /exp 30-07-2021 /loc upper_shelf /qty 5`
  * Inputs a `Coke` of category `beverage`, with expiry date of `30-07-2021`, location of `upper_shelf`, and
    quantity of `5`.
* `add squid /cat seafood /exp 15-08-2021 /loc freezer /qty 100`
  * Inputs a `squid` of category `seafood`, with expiry date of `15-08-2021`, location of `freezer`, and
    quantity of `100`.

For subsequent examples below, this guide assumes that these four foods `chicken`, `milk`, `Coke`, and `squid`
have been added to the Fridge.

### Listing food

The `list` command in `FridgeFriend` has three (3) variations:

* List all food in the fridge.
* List all food of a certain category in the fridge.
* List all food of a certain storage location in the fridge.

The latter two commands will return an output that is a subset of the first command (_List all food_).

No items will be listed if no food in the fridge match the conditions specified in the command.

1. Test case: `list`

* Expected:

  ```lang-none
  Here are the items in your fridge:
    1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 100
    2. Food name: milk, category: DAIRY, expiry: 31-12-2021, stored in: FRIDGE_DOOR, quantity: 2
    3. Food name: Coke, category: BEVERAGE, expiry: 30-07-2021, stored in: UPPER_SHELF, quantity: 5
    4. Food name: squid, category: SEAFOOD, expiry: 15-08-2021, stored in: FREEZER, quantity: 100
  ```
  
2. Test case: `list meat`

* Expected:

  ```lang-none
  These are the MEAT in your fridge:
    1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 100
  ```

3. Test case: `list freezer`

* Expected:

  ```lang-none
  These are the food stored in FREEZER:
   1. Food name: squid, category: SEAFOOD, expiry: 15-08-2021, stored in: FREEZER, quantity: 100
  ```

### Removing a food

Removing a food while all foods are being shown.

1. Prerequisites: List all foods using the `list` command. Multiple food in the list.
2. Test case: `remove squid /qty 100`
    * Expected: `squid` is deleted from the list. Details of the deleted food shown in the status message. Additional
      warning that `seafood` is running low may appear.
3. Test case: `remove chicken /qty 50`
    * Expected: Quantity of `chicken` is reduced by 50. Details of the removed food shown in the status message.
      Additional warning that `meat` is running low may appear.
4. Test case: `remove coke /qty 1`
    * Expected: `Food specified not found.` Note that the search for food name in this command is case sensitive;
      note that when `Coke` was added, it was with a capital 'C'. No food is removed.
5. Test case: `remove Coke /qty 69`
    * Expected: `Not enough in fridge to remove!` User attempted to remove a greater quantity than what was
      available in the fridge. Error message was thrown. No food is removed.
6. Test case: `remove chicken`
    * Expected: `Sorry my friend, please give a valid input.` It is required to specify the quantity to be removed with
      `/qty`.

### Searching for a food

Checks if a food is in the fridge, and if it is found, outputs the location of the food.
If it is not found, outputs `You do not have FOOD_INPUT in your fridge.`

1. Test case: `search chicken`
    * Expected: `You have chicken stored in LOWER_SHELF of your fridge.`
2. Test case: `search pear`
    * Expected: `You do not have pear in your fridge.`
3. Test case: `search chick`
    * Expected: `You do not have chick in your fridge.`

### Expiring food

This feature might be slightly more challenging to test, since the user tester has to input a food
that has an expiry date within 7 days of their **local system time**, as of the date of testing.

1. Prerequisites: Add a food with an expiry date within 7 days of the user's system date.
    * Modify the input in the above [add command](adding-food) in order to fulfil this requirement.
    * Example: The current date on my system time is `29-03-2021`.
      * Prior to testing, I perform the command `add duck /cat meat /exp 30-03-2021 /loc lower_shelf /qty 100`.
      * Thus, this food should expire in 1 day, within the 7 days required to trigger the `expiring` command.
2. Test case: `expiring`
    * Expected:

   ```lang-none
   These are the food expiring in the next week:
        1. Food name: duck, category: MEAT, expiry: 30-03-2021, stored in: LOWER_SHELF, quantity: 100
   ```

### Runninglow and Setlimit

By default, the `limits` for all food is set at `500`. Use `setlimit` to modify this number for a certain food category.

1. Preparation: Change the limits for `meat`, `dairy`, `beverage`, `seafood`, since they are the categories of food
   we have added to the fridge so far.
    * `setlimit meat /qty 200`
    * `setlimit dairy /qty 5`
    * `setlimit beverage /qty 3`
    * `setlimit seafood /qty 50`
2. Test case: `runninglow`
    * Expected:

   ```lang-none
   You are running low on food in these categories:
   1. VEGETABLE quantity: 0 out of 500
   2. FRUIT quantity: 0 out of 500
   3. MEAT quantity: 100 out of 200
   4. EGG quantity: 0 out of 500
   5. DAIRY quantity: 2 out of 5
   6. COOKED_DISH quantity: 0 out of 500
   7. READY_TO_EAT quantity: 0 out of 500
   8. FROZEN quantity: 0 out of 500
   9. OTHER quantity: 0 out of 500
    ```

Note that `SEAFOOD` AND `BEVERAGE` category are omitted from the above list,
as they are not "running low". There is sufficient food from the given category in the
fridge, because it is above the quantity we have specified by `setlimit`.

### History

While the history command may be simple to test, the expected output may vary depending on the food added by
the user during testing.

Therefore, user testers should manually compare the results of the `history` command with their actual input
during testing, and see if they correspond.

1. Prerequisites: Only the input in the above [add command](adding-food) was added to the list.
   No other food was added to the list.
    * Note: To reset the history, use `history clear`.
    * `add chicken /cat meat /exp 30-06-2021 /loc lower_shelf /qty 100`
    * `add milk /cat dairy /exp 31-12-2021 /loc fridge_door /qty 2`
    * `add Coke /cat beverage /exp 30-07-2021 /loc upper_shelf /qty 5`
    * `add squid /cat seafood /exp 15-08-2021 /loc freezer /qty 100`
2. Test case: `history`
    * Expected:

    ```lang-none
    This is the full history of items you've added in the fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 100
        2. Food name: milk, category: DAIRY, expiry: 31-12-2021, stored in: FRIDGE_DOOR, quantity: 2
        3. Food name: Coke, category: BEVERAGE, expiry: 30-07-2021, stored in: UPPER_SHELF, quantity: 5
        4. Food name: squid, category: SEAFOOD, expiry: 15-08-2021, stored in: FREEZER, quantity: 100
    ```

### Saving data

_Dealing with missing/corrupted data files._

All data is stored in the `/data` folder in the same folder as `FridgeFriend.jar`.

Three (3) text files will be generated in the folder during usual execution of `FridgeFriend`.
These text files are used to store data in the disk for various commands during the usual operation of `FridgeFriend`.

1. `fridgeData.txt`
    * Contains the food stored in the fridge.
    * Is automatically loaded when `FridgeFriend` starts. Food in the text file will be stored in the fridge.
    * The text file will be updated with the contents of the fridge when the `FridgeFriend` application is terminated
    using the `bye` command.
    * The text file will **not** be updated if `FridgeFriend` is not terminated with the `bye` command,
    such as when the runtime is interrupted with `Ctrl+C`.
    * _Missing data file:_ A new, blank `fridgeData.txt` will automatically be created upon launching `FridgeFriend`.
    The fridge at program launch will be empty. No further action needed.
    * _Corrupted data file:_ Upon program launch, `FridgeFriend` will throw an exception with
      an accompanying error message:

        ```lang-none
        There was an error loading the data for FridgeFriend!
        Index 1 out of bounds for length 1
        ```

      * `FridgeFriend` will load the contents of the text file until the point in the file where corrupted/invalid
        data is encountered.
      * User can recover the contents of the file by manually inspecting the text file and removing invalid content.  
2. `limitsData.txt`
    * Contains the food quantities used to determine which food is running low in `setlimit` and `runninglow`.
    * Is automatically loaded when `FridgeFriend` starts. The loaded content can be viewed with `runninglow`.
    * The text file will be updated with the contents of the fridge when the `FridgeFriend` application is terminated
     using the `bye` command.
    * The text file will **not** be updated if `FridgeFriend` is not terminated with the `bye` command,
     such as when the runtime is interrupted with `Ctrl+C`.
    * _Missing data file:_ A new, blank `fridgeData.txt` will automatically be created upon launching `FridgeFriend`.
          The limits of all food categories will be reset to the default of 500. No further action needed.  
    * _Corrupted data file:_
        * Test case: Corrupted categories.
           * If the corrupted category is readable: No error message will be shown. User can only identify that data
             has been corrupted when using the `runninglow` command. The quantity of the invalid categories due to
             corruption will be reset to `500`.
           * If the corrupted category is unreadable:

            ```lang-none
            There was an error loading the data for FridgeFriend!
            Index 1 out of bounds for length 1
            ```

              * The quantity limits will be parsed up until the corrupted unreadable category.
                Subsequent quantity limits in the file would not be parsed, and will be reset to the default of `500`.
        * Test case: Corrupted quantities.
          * If the corrupted quantity is an integer: No error message will be shown. User can only identify that
            data has been corrupted when using the `runninglow` command. The limit will be updated to the corrupted
            value.
          * If the corrupted quantity is **not** an integer: Error message will be shown.

            ```lang-none
            There was an error loading the data for FridgeFriend!
            Sorry my friend, the quantity must be a number.
            ```

            * The quantity limits will be parsed up until the corrupted non-integer value. Subsequent quantity limits
                in the file would not be parsed, and will be reset to the default of `500`.
3. `historyData.txt`
    * Contains the logs of food added to the fridge using `add` command.
    * Is automatically updated whenever a successful `add` command is invoked.  
    * Content is loaded from disk only when `history` command is invoked.
    * _Missing data file:_ A new, blank `fridgeData.txt` will automatically be created upon executing the `history`
      command. No further action needed.
    * _Corrupted data file:_
       * Test case: If corrupted data is readable. No error message will be shown. User can only identify that data
             has been corrupted when using the `history` command. The `history` command will continue to print out
            the contents of the file, including the corrupted data.
            * While this corrupted data would not affect program flow, it may create unexpected output. If necessary,
              users can manually inspect the file and remove unwanted data at their own discretion.
       * Test case: If corrupted data is unreadable. No error message will be shown. User can only identify that
         data has been corrupted when using the `history` command. The contents of the entire file will not be parsed,
         even if there is valid content in some parts of the file.
            * The contents of the file will not be affected. If necessary,
              users can manually inspect the file and remove corrupted data, in order to salvage any valid data.

## Attribution

The format of this User Guide was adapted from [AddressBook Level 3(AB3) Developer Guide](https://github.com/se-edu/addressbook-level3/blob/master/docs/DeveloperGuide.md).
