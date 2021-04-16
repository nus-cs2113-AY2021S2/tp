# easyLog Developer Guide

By: `Ong Wei Sheng`, `Zhu Zikun`, `Qiu Yi Wen`, `Li Kexuan`, `Jiang Qixiong`

Last Updated: `12 April 2021` <br>

![Supported Java versions](https://img.shields.io/badge/Java-11-blue.svg)
![Supported OS](https://img.shields.io/badge/Supported%20OS-Windows|MacOS|Linux-yellow.svg)
![Java CI](https://github.com/AY2021S1-CS2113T-T09-4/tp/workflows/Java%20CI/badge.svg)

<p align="center">
<img src="https://user-images.githubusercontent.com/75139323/114268337-233ad580-9a33-11eb-9834-952e9a86fbaa.png" width="500">
</p>

***

## Table of Contents

- [1. **Introduction**](#1-introduction)
    - [1.1. Software Overview](#11-software-overview)
    - [1.2. Prerequisites](#12-prerequisites)
    - [1.3. Setting Up](#13-setting-up)
- [2. **Design**](#2-design)
    - [2.1. Architecture](#21-architecture)
    - [2.2. EasyLog Component](#22-easylog-component)
    - [2.3. UI Component](#23-ui-component)
    - [2.4. Parser Component](#24-parser-component)
    - [2.5. Command Component](#25-command-component)
    - [2.6. Model Component](#26-model-component)
    - [2.7. Storage Component](#27-storage-component)
    - [2.8. Common Component](#28-common-component)
- [3. **Implementation**](#3-implementation)
    - [3.1. App Initialization](#31-app-initialization)
    - [3.2. Processing of user inputs](#32-processing-of-user-inputs)
    - [3.3. Loading of save data](#33-loading-of-save-data)
    - [3.4. Items add](#34-items-add)
    - [3.5. Items update](#35-items-update)
    - [3.6. Orders add](#36-orders-add)
    - [3.7. Orders delete](#37-orders-delete)
    - [3.8. Marking an order as done and generation of receipts](#38-marking-an-order-as-done-and-generation-of-receipts)
    - [3.9. Exit command and creating and/or saving of save data](#39-exit-command-and-creating-andor-saving-of-save-data)
- [4. **Documentation**](#4-documentation)
- [5. **Testing**](#5-testing)
    - [5.1. Types of Tests](#51-types-of-tests)
    - [5.2. Running Tests](#52-running-tests)
- [6. **Dev Ops**](#6-dev-ops)
    - [6.1. Build Automation](#61-build-automation)
    - [6.2. Continuous Integration](#62-continuous-integration)
    - [6.3. Coverage Report](#63-coverage-report)
    - [6.4. Making a Release](#64-making-a-release)
    - [6.5. Managing Dependencies](#65-managing-dependencies)
- [**Appendices**](#appendices)
    - [Appendix A: Product Scope](#appendix-a-product-scope)
    - [Appendix B: User Stories](#appendix-b-user-stories)
    - [Appendix C: Non-Functional Requirements](#appendix-c-non-functional-requirements)
    - [Appendix D: Glossary](#appendix-d-glossary)
    - [Appendix E: Instructions for Manual Testing](#appendix-e-instructions-for-manual-testing)

***

## 1. Introduction

### 1.1 Software Overview

easyLog is a Command Line Interface (CLI) application for home based businesses to manage items and orders in their
inventory. easyLog allows users to add new items and orders, view existing items and orders, remove specific items and
orders and clear all existing items and orders in the inventory at ease. If the user types fast, easyLog can get
logistic management tasks done faster than traditional Graphical User Interface (GUI) applications.

easyLog, comprises a Parser component, Ui component, Storage component, Item component, Order component and Command
component. Each component consists of various classes that work in tandem, to ensure it meets the purpose of our
program.

The purpose of this developer guide is to allow any interested contributors who wish to develop this application
further or just curious about the workings of this application. This would allow potential contributors to be able to
dive right in to improving the code, performance, features or even adding new features much more easily due to the
understanding of the structure of the codebase and implementation of existing features.

[Return to Table Of Content](#table-of-contents)

### 1.2 Prerequisites

- Java 11 (can be downloaded from [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html))
- IntelliJ IDEA (can be downloaded from [here](https://www.jetbrains.com/idea/download/#section=mac))

[Return to Table Of Content](#table-of-contents)

### 1.3 Setting Up

1. Fork the easyLog repository [here](https://github.com/AY2021S2-CS2113T-T09-4/tp) and git clone it to any location on
   your computer.

2. Open any IDE (IntelliJ Idea preferred as mentioned in the prerequisites) and click `Configure` -> `Project Defaults`
   -> `Project Structure` -> `New`

3. Next, go to `Import Project` and select the build.gradle file.

4. After opening the project, go to `src` -> `main` -> `java` -> `seedu.easylog` -> EasyLog and right click on the
   EasyLog class.

5. Upon successful run, the following opening message will be shown:

```
____________________________________________________________
Hello! I'm easyLog!
What can I do for you? Enter help to view commands.
____________________________________________________________

Looking for save data.
Save data not found.
____________________________________________________________
```

[Return to Table Of Contents](#table-of-contents)

***

## 2. Design

In this section, we discuss the various design of the different components of the application.

[Return to Table Of Contents](#table-of-contents)

### 2.1 Architecture

![Architecture Diagram](https://user-images.githubusercontent.com/57165946/112990632-ddf7e780-9198-11eb-99ec-f29aafbfc04f.png)

The EasyLog component contains the main method which is required by Java to run the application. Its main 
responsibility is to initialize the app and after initialization continuously ask for user's input until the exit
command is executed. More details of the EasyLog component will be explained in the future sections.

Apart from the `EasyLog` component, the application also consists of the following components:
- `Ui`: Handles asking for user's input and printing of feedback from user's input.
- `Parser`: Processes user's input to decide what command should be executed.
- `Command`: Executes actions related to the command.
- `Model`: Holds data related to inputs from the user.
- `Storage`: Handles loading, creating and saving of data into `.txt` files.
- `Common`: Contains variables and messages commonly used in all the components.

[Return to Table Of Contents](#table-of-contents)

### 2.2 EasyLog Component

The EasyLog component is responsible for initializing the app. It initializes the app by
instantiating classes from the `Ui`, `Parser`, `Model` and `Storage` components. More details regarding the
initialization will be covered in the [Implementation](#3-implementation) section.

[Return to Table Of Contents](#table-of-contents)

### 2.3 Ui Component

The UI component does the following:
1. It asks for users input.
2. It is responsible for printing and showing responses to the user's input while executing commands related to the
user's input.

[Return to Table Of Contents](#table-of-contents)

### 2.4 Parser Component

![Parser Diagram](https://user-images.githubusercontent.com/57165946/114297222-f8f42100-9ae1-11eb-9460-00f8045a2dc6.png)

The Parser component deals with the input of the user. It makes sense of the users input and executes respective
commands according to the user's input. This component consists of 3 different classes:
1. `Parser` class to determine the type of feature the user wants to use. (e.g. items or orders feature)
2. `ItemsParser` class to process inputs related to `items` features.
3. `OrdersParser` class to process inputs related to `orders` features.

[Return to Table Of Contents](#table-of-contents)

### 2.5 Command Component

![Command Class Diagram](https://user-images.githubusercontent.com/60378963/113397031-ff421900-93ce-11eb-8e31-a9207d23f2f1.png)
All four ExitCommand, OrdersCommand, ItemsCommand and HelpCommand classes extend the abstract Command class.
OrdersCommand and ItemsCommand Classes are abstract class, and it has various Command classes 
(e.g. OrdersXXXCommand, ItemsXXXCommand) extending them, in order to deal with different command actions ask by the 
user.

1. Once the user input is been parsed by the `Parser` class new `Command` object will be created.
2. Different actions will be executed by the execute method in different `Command` class.
3. Command execution takes place, and it will affect the `Model` and its data (e.g. adding a new item).

[Return to Table Of Contents](#table-of-contents)

### 2.6 Model Component

![Model Diagram](https://user-images.githubusercontent.com/57165946/114408329-e1995e80-9bdb-11eb-99af-52120b495c09.png)

The model component consists of four classes, namely, `Item`, `ItemManager`, `Order` and `OrderManager` classes. `Item` 
and `Order` classes represent real-world item and order objects easyLog is tasked to keep track of. Note that the UML 
diagram above omits less important details for more comprehensibility.

1. `Item` class is used to store item attributes (i.e., item description, unit price, stock and sales). Primarily, `Item`
  class has all necessary getter and setter methods for`itemManager` to modify a particular item's attributes when
  necessary.

2. `ItemManager` class stores the item list (the list of items existing in the inventory) and a founded item list (the
  list of items found when the user gives `items find` command). Primarily, `ItemManager` includes methods which various
  item-related commands (e.g., `ItemsAddCommand`) required to perform neccesary operations to modify (e.g., add) items in
  the item list.

3. `Order` class is used to store order attributes (i.e., customer's name, descriptions of items ordered, quantities of
  items ordered and whether the order is done). Primarily, `Order` class has all necessary getter and setter methods
  for `orderManager` to modify a particular order's attributes when necessary.

4. `OrderManager` class stores the order list (the list of orders placed by customers) and a founded order list (the list
  of orders founded when the user gives `orders find` command). Primarily, `OrderManager` has methods which various
  orders-related commands (e.g., `OrdersAddCommand`) required to perform neccesary operations to modify (e.g., add)
  orders in the orders list.

[Return to Table Of Contents](#table-of-contents)

### 2.7 Storage Component

![image](https://user-images.githubusercontent.com/57165946/113095572-3d500900-9226-11eb-83b0-44d3729442b7.png)

The Storage component consists of 3 different classes
1. `Storage` class to initialize required classes for it's subclasses.
2. `SaveData` class to deal with the loading, saving and creation of save data.
3. `Receipt` class to deal with the generation of receipts when an order is done.
4. `Logging` class to setup logging environment and allow log messages to be entered. (Not shown in storage diagram)
`Logging` class is not related to the above 3 classes.

[Return to Table Of Contents](#table-of-contents)

### 2.8 Common Component

The Common component consists of 2 different classes:
1. `Constants` class to store all variables that are frequently used in the various components.
2. `Messages` class to store all the texts for the UI to print onto the command line.

[Return to Table Of Contents](#table-of-contents)

***

## 3. Implementation

In this section, we explain the details and implementation of the more important features of easyLog.

[Return to Table Of Contents](#table-of-contents)

### 3.1. App Initialization

![App Initialization Diagram](https://user-images.githubusercontent.com/57165946/113379984-99916500-93ad-11eb-8fa7-f3c00fd71163.png)

As seen from the sequence diagram above, upon initialization,
1. The main class located in `EasyLog` will show the user a greeting message.
2. Proceed to load save file if any. Details on the [implementation of loading save files](#33-loading-of-save-data) 
   can be seen here
3. Set up the environment for logging messages to be logged.
4. Proceed to ask for user's input.
5. Write a log to show that user's input has been requested.
6. Proceed to process user input to determine the type of command to execute. More details on the implementation of
[processing inputs](#32-processing-of-user-inputs) will be discussed in the next section.
7. Repeat steps 4-6 if user does not input exit command.

[Return to Table Of Contents](#table-of-contents)

### 3.2. Processing of user inputs

As mentioned in the design of the [Parser component](#24-parser-component), the Parser component handles the processing
of inputs.

We will now explain the steps to how user inputs is being processed:
1. User input is firstly being split using the `splitCommandWordAndArgs` method in the `Parser` class. This is to
determine the type of feature that the user wants to use e.g., `items` feature, `orders` feature, `help` feature, or the
   `exit`feature.
2. The `processUserInput` in the `Parser` class then determines the type of feature to be executed using
the command word provided by the user. If `items` and `orders` feature are being executed, the remaining arguments being
   typed by the user is being processed using the `processItemsInput` method from the `ItemsParser` class or the
   `processOrdersInput` method using the `OrdersParser` class respectively.
3. Note that if `help` command or `exit` command is being inputted by the user, the `processUserInput` from the `Parser`
class will directly call the `execute` method of the relevant command.
4. `processItemsInput` and `processOrdersInput` will then also use the `splitCommandWordAndArgs` method to similarly
determine the type of `items` and `orders` features to execute e.g., `items add`, `orders add`, `items update` etc.
5. After determining the type of `items` and `orders` feature to execute, the `execute` methods of the respective 
   commands will be called by either the `processItemsInput` or `processOrdersInput` method and the command arguments
   would also be passed into the `execute` method for the respective commands in order to properly execute the command
   inputted by the user.

[Return to Table Of Contents](#table-of-contents)
   
### 3.3. Loading of save data

![LoadFile Diagram](https://user-images.githubusercontent.com/57165946/114254030-ad594e80-99df-11eb-8c03-730630b57d49.png)

As seen form the sequence diagram above (note that some trivial details are removed from the diagram), when `loadFile` 
method in the `SaveData` class is being executed,
1. Show the user a message that it is looking for save data.
2. Creates a `File` object with pathname of the save file.   
3. Check whether the save file exists through the `File` object previously created.
4. If the save file does not exist, it will terminate the `loadFile` method and show the user that no save data was found.
5. If the save file exists, it will show the user a message that it is loading the save data.
6. Create a `Scanner` object using the save file.
7. Read the first line in the save data.
8. Process the line of input from the save data.
9. Repeat step 6 and 7 until there no more lines to be read from the save data.
10. Show the user that the save data has been successfully loaded.

[Return to Table Of Contents](#table-of-contents)

### 3.4. Items Add
![itemsAdd Diagram](https://user-images.githubusercontent.com/77385307/114296774-a7e32d80-9adf-11eb-9def-9fe89db8f5fc.png)
The `items add` feature is designed to allow users to add items to the system, including the item name, price and stock
of each item. As seen from the sequence diagram above (note that some trivial details are removed from the diagram),
when an item is added into the system:
1. User executes the `itemsAddcommand` by typing `items add <item_name>`.
2. easyLog invokes `itemsParser` and calls the `promptAndProcessItemPriceAndStock(String)`method to ask user the
   `itemPrice` and `itemStock` of this item.
3. easyLog will keep asking user the `itemPrice` and `itemStock` by calling
   `itemPriceInStringToBigDecimalFormat(String)`and `itemStockInStringToIntegerFormat(String)` methods, until the
   `itemPrice` and `itemStock` given by the user are both valid.
4. Then, `itemsParser` creates a new `Item` object, which would be returned to `itemsAddCommand`.
5. easyLog then invokes `itemsManager` and calls the `addItem(Item)` method to add this item into the system.
6. After the item is added successfully, `UI` sends back the confirmation message to user by calling `showAddItem(Item)`
   method.

[Return to Table Of Contents](#table-of-contents)

### 3.5. Items Update
Please note that less important details are omitted for better comprehensibility. For instance, in the first diagram of this section, 
only the interactions after `ItemsUpdateCommand.execute()` is modelled. In the second diagram of this section, 
details of `itemsPromptPriceCommand` and `itemsPromptPriceCommand` are omitted.

![Items Update Figure 1](https://user-images.githubusercontent.com/75139323/114384288-1a780a00-9bc1-11eb-99c1-5c4af2e119f3.png)
The diagram above shows the first stage of `itemsUpdateCommand`, after the user executes the `itemUpdateCommand` 
by typing `items update` and easyLog invokes `itemsParser`.

1. `ItemUpdateCommand` first gets the item size from `ItemManager`.
2. `ItemUpdateCommand` calls askForItemIndex from `UI` to print a message that an item index is required.
3. `ItemUpdateCommand` creates a new `ItemsListCommand` object and uses `ItemsListCommand.execute()` to get the item list
for the user.
4. `ItemUpdateCommand` prompts the user for input by calling `askForUserInput()` from `UI`.
5. `ItemUpdateCommand` gets the item size from `ItemManager` again.
6. If the input given by the user is invalid (not a valid item index), start from step 2 again.
7. `ItemUpdateCommand` calls `askForItemFieldToBeUpdated` and askForUserInput() from `UI` to print a question message 
   and get the user input.
8. If the input given by the user is invalid (not `p` or `s`), start from step 7 again.

![Items Update Figure 2](https://user-images.githubusercontent.com/75139323/114397749-9a0dd500-9bd1-11eb-9cff-72275205458f.png)
Next,

9. `ItemUpdateCommand` calls `processUpdateAttributeInput` of `ItemsParser`.

If the user input is "p":

10. `ItemsParser` calls `askForRevisedItemPrice` from `UI`. `ItemsParser` creates an object of 
`ItemsPromptPriceCommand` and its `execute()` method is executed to ask the user for a valid `revisedItemPrice`. 
The details are omitted to increase comprehensibility. If the item price given is not valid, the user needs to keep 
entering it until it is valid. 
11. `ItemsParser` calls `ItemManager` to set the revised price, getting the item of interest before calling `UI` to show
it is updated correctly.

If the user input is "s", the logic is largely similar to when it is "p". The explanations are omitted here to avoid repetition.

[Return to Table Of Contents](#table-of-contents)

### 3.6. Orders Add

![Orders add diagram](https://user-images.githubusercontent.com/60378963/114283955-4d19e980-9a7f-11eb-9d54-6762938de6bb.png)

As seen from the sequence diagram above, when user wants to add an Order.
1. User input "Orders add Yiwen" string.
2. Ui will send the userInput to the parser to process it.
3. A new OrdersAddCommand object is been created and its execute method is being called.
4. A new ItemManger object is been created and its execute method is being called.
5. Ui shows a list of items.
6. Ui prompts the user to add items in the item list to order.
7. Ui ask for user input.
8. user enter the item index.
9. Repeat step 6 to 8 until stop command is keyed in.
10. Orders added to order list.
11. Ui shows order is added.

[Return to Table Of Contents](#table-of-contents)

### 3.7. Orders Delete
![OrdersDelete Diagram](https://user-images.githubusercontent.com/60382244/114287343-b528f980-9a98-11eb-8b65-c654d25f7ee9.png)
As seen form the sequence diagram above (note that some trivial details are removed from the diagram), when an order is
deleted
1. The Ui reads the input from user.
2. The main class receives the input from ui.
3. The main class sends the input to Parser.
4. The Parser parse the input and sends it to OrdersParser.
5. The OrdersParser parse the input and sends it to OrdersDeleteCommand.
6. The OrdersDeleteCommand execute to delete the selected order.
7. The ItemManager update the quantity of items in deleted order.
8. The OrdersManager delete the order selected.
9. The deleted order message is sent to the user.

[Return to Table Of Contents](#table-of-contents)

### 3.8. Marking an order as done and generation of receipts

The `orders done` feature and generation of receipts are split into 2 parts where the first sequence diagram shows the 
implementation for `orders done` feature, and the second sequence diagram shows the implementation when generating a
receipt.

![Orders Done Command Diagram (1)](https://user-images.githubusercontent.com/57165946/114294627-8465b600-9ad2-11eb-9ace-c4b603834216.png)

As seen from the sequence diagram above, when the `execute` method in `OrdersDoneCommand` class is executed,
1. Processes user's input to determine the order index that the user wants to mark as done.
2. Show a message to the user that the order has been marked as done.
3. Mark the order as done using the `OrderManager` class.
4. Generate a receipt using the details in the order that has been marked as done. (Implementation of generation of
   receipt will be explained in the next sequence diagram).
5. Delete the order from the current list of orders. This is so as to keep the list of orders with just orders that are
not yet done or fulfilled as the user can view the done orders using the receipts generated.

![Generating receipt Diagram](https://user-images.githubusercontent.com/57165946/114278283-a5da8980-9a61-11eb-9e90-8a15900c890f.png)

As seen from the sequence diagram above, when the `generateReceipt` method from the `Receipt` class is called,
1. It gets the customer name of the order that was marked as done using the `getCustomerName method `from the 
   `OrderManager` class.
2. Shows the user that the receipt is being generated.
3. Create a new directory named `Receipts` if the directory does not already exist in the folder that the `easyLog.jar`
file is being executed from using the `File` class.
4. Create a new receipt file to contain the details of the order also using the `File` class.
5. `FileWriter` object called `fw` is then created to write the relevant order details into the receipt file that was 
   previously created in step 4.
6. Close the `fw` object using the `close` method when the order details are written finish into the receipt file.
7. Show the user that the receipt has been generated.

[Return to Table Of Contents](#table-of-contents)

### 3.9. Exit command and creating and/or saving of save data

![Exit and SaveFileDiagram (1)](https://user-images.githubusercontent.com/57165946/114295168-07d4d680-9ad6-11eb-8cb2-be6b09073112.png)

As seen from the above sequence diagram, when the execute method of the `ExitCommand` class is being called,
1. It calls the `saveFile` method from `SaveData` class.
2. The `saveFile` method then creates a new `File` object called `saveData`.
3. `saveData` object then checks if a save file previously exists, if the save file does not exists, it creates the
save file using the `saveData` object.
4. `FileWriter` object called `fw` is then called to write details like item details, orders details and receipt counter
into the save file.
5. Close the `fw` object using the `close` method when the order details are written finish into the save file.
6. Show the user a message that the data has been saved into the save file.
7. Exit the program using `System.exit(0)` method.

[Return to Table Of Contents](#table-of-contents)

***

## 4. Documentation

All documentation can be found under the `docs/` folder. Alternatively, visit
https://ay2021s2-cs2113t-t09-4.github.io/tp/ to browse all the document.

* [Jekyll](https://jekyllrb.com/) is used to manage the documentation.
* [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/) is used to write the documentation.
* [diagrams.net](https://draw.io/) (formerly draw.io) is used to create various UML diagrams. <br>

[Return to Table Of Contents](#table-of-contents)

***

## 5. Testing

In this section, we present different types of tests and how they can be run.

[Return to Table Of Contents](#table-of-contents)

### 5.1. Types of Tests
There are primarily three types of tests:

1. Unit tests. Tests are conducted on the fundamental level methods/classes. <br>
   e.g. `seedu.easyLog.commons.ConstantsTest`

2. Integration tests. Tests are conducted on checking the integration of multiple code units. <br>
   e.g. `seedu.easyLog.storage.OrderManagerTest`

3. Hybrids of unit and integration tests. Tests are conducted on multiple code units as well as their logic connections. <br>
   e.g. `seedu.easyLog.parser.ItemsParserTest`

[Return to Table Of Contents](#table-of-contents)

### 5.2. Running Tests
There are multiple ways to run tests for easyLog. Two of them are listed below:

**Method 1: Using IntelliJ JUnit test runner**

- To run all tests, right-click the `src/test/java` folder and choose `Run 'Tests in tp.test'`.
- To run a subset of tests, you can right-click a test test class before choosing `Run <test.java>`, where 
  `<test.java>` is the name of the test class (e.g., `itemsAddCommandTest`).

Method 2: Using Gradle <br> 
* Open a console and run the command gradlew clean test (Mac/Linux: ./gradlew clean test)

🔗 **Link**: Read [this Gradle Tutorial from the se-edu/guides](https://se-education.org/guides/tutorials/gradle.html) to learn more about using Gradle.

- To run all tests, open a console and run the command `gradlew clean test` if you are a Windows user. For macOS or 
  Linux users, please run the command `./gradlew clean test` instead.

> **Note:** If you are new to Gradle, refer to this [Gradle Tutorial](#https://se-education.org/guides/tutorials/gradle.html) to learn more about how to use Gradle commands.

We invite you to visit [Appendix E: Instructions for Manual Testing](#appendix-e-instructions-for-manual-testing) to 
learn more about manual testing for easyLog.

[Return to Table Of Contents](#table-of-contents)

***

## 6. Dev Ops

Int this section, we discuss several important aspects of Dev Ops which can shorten the system development life cycle 
and provide continuous delivery with high software quality.

[Return to Table Of Contents](#table-of-contents)

### 6.1. Build Automation
We use Gradle for tasks related to build automation such as running tests and checking code for style compliance.

To run all build-related tasks:

1. Open a terminal in the project’s root directory.
2. Run the command:
  - Windows: `gradlew build`
  - macOS / Linux: `./gradlew build`
3. A message stating `BUILD SUCCESSFUL` will be shown in the terminal if all tasks are run successfully. Otherwise, 
   refer to the error report provided to resolve the issues before trying again.

[Return to Table Of Contents](#table-of-contents)

### 6.2. Continuous Integration
We use Github Actions for continuous integration. No setup will be required for users who fork from the 
AY2021S2-CS2113T-T09-4/tp repository.

Whenever you create a pull request to the master branch of AY2021S2-CS2113T-T09-4/tp:
- Various checks will automatically be executed for your pull request.
- If any checks fail, please view the cause of any errors shown and fix them in your branch before pushing it again.
- Ensure that all checks pass before the reviewer merges your pull request.

[Return to Table Of Contents](#table-of-contents)

### 6.3. Coverage Report
We use the IntelliJ IDEA’s coverage analysis tool for coverage reporting. A tutorial on how to install and use this tool
can be found [here](https://www.youtube.com/watch?v=yNYzZvyA2ik).

[Return to Table Of Contents](#table-of-contents)

### 6.4. Making a Release

You can follow the steps below to make a new release:
1. Generate the JAR file using Gradle by opening a terminal in the project’s root directory, and run the command:
  - Windows: `gradlew clean shadowJar`
  - macOS / Linux: `./gradlew clean shadowJar`
2. Find the JAR file in the `build/libs` directory.
3. Tag the repository with the new version number (e.g. `v2.1`).
4. Create a new release using Github and upload the JAR file found in step 3.

[Return to Table Of Contents](#table-of-contents)

### 6.5. Managing Dependencies
Currently, the [Gson library](#https://github.com/google/gson) is being used for JSON parsing, and the 
[Apache Commons Lang](#https://commons.apache.org/proper/commons-lang) is being used for string processing 
in easyLog. Below are 2 ways to manage these dependencies.
- Use Gradle to manage and automatically download dependencies (recommended).
- Manually download and include those libraries in the repo (this requires extra work and bloats the repository size).

[Return to Table Of Contents](#table-of-contents)

***

## Appendices

### Appendix A: Product Scope

### Target User Profile

- IT savvy home-based businessmen
- Have a need to manage numerous sales data
- The inventory list gets constantly updated (add & delete items/orders)
- Prefer typing over mouse/handwritten
- Can type fast
- Enjoy using CLI software

### Value Proposition

A simple database application that helps target user to store and access a collection of data electronically from a
computer system.

[Return to Table Of Contents](#table-of-contents)

### Appendix B: User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|add new items|track the items added to the warehouse|
|v1.0|user|view the items in the warehouse|track the items that are added or not added to the warehouse|
|v1.0|user|remove items|remove the items that are no longer required to be tracked|
|v1.0|user|add new orders|track the orders added to the system|
|v1.0|user|view the orders in the system|track the orders that are added or not added to the system|
|v1.0|user|remove orders|remove the orders that are no longer required to be tracked|
|v1.0|user|clear all items|re-track all the items if there are any problems|
|v1.0|user|clear all orders|re-track all the orders if there are any problems|
|v1.0|user|view all available commands|refer to them when I forget how to use the application|
|v1.0|user|view all items-related commands|refer to them when I forget how to use the items feature|
|v1.0|user|view all orders-related commands|refer to them when I forget how to use the orders feature|
|v2.0|user|create, save data and load existing data|work on another device with the saved data|
|v2.0|expert user|create, save data and load existing data|edit the data file directly|
|v2.0|user|find relevant items|save time by looking through relevant items|
|v2.0|user|find relevant orders|save time by looking through relevant orders|
|v2.0|user|add a new item with a specified unit price|calculate order price more easily|
|v2.0|user|update the unit price of an item|revise unit price or correct mistaken unit price entered earlier|
|v2.0|user|add a new item with its stock|keep track of total number of stock and calculate order price more easily|
|v2.0|user|update the stock of an item|Correct mistaken stock number entered earlier|
|v2.0|user|specify the quantity of a item to add to the order|calculate the total price of the order and update the item inventory correctly.|
|v2.0|user|check the total price of a specific order|feedback to customer when they ask for it and do not have to look through the order list.|
|v2.0|user|update the status of an order|differentiate the orders by their status.|
|v2.0|user|view receipt of a order that is done|check done orders and deal with taxes.|
|v2.1|user|view sales statistics |know what is my most popular items and update stocks accordingly.|

[Return to Table Of Contents](#table-of-contents)

### Appendix C: Non-Functional Requirements

- A user should be able to work on any mainstream OS as long as it has Java 11 or above installed.
- A user should be able to respond to any command in less than 2 seconds.
- A user should be able to complete majority of tasks faster using CLI than GUI.

[Return to Table Of Contents](#table-of-contents)
  
### Appendix D: Glossary

Abbreviation | Full Title | Definition
-------- | ---------- | ----------
**CI**   | Continuous Integration | Combining parts of a software product to form a whole
**IntelliJ** | IntelliJ | An Integrated Development Environment written in Java
**CLI** | Command Line Interface | A program that accepts text inputs to execute operating system functions
**GUI** | Graphical User Interface | An interface that allows users to interact through graphical icons
**Mainstream OS** | Windows, Linux, Unix, OS-X | Operating systems

[Return to Table Of Contents](#table-of-contents)

### Appendix E: Instructions for Manual Testing
Given below are instructions to test easyLog manually.

> **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

**Launching easyLog** <br>
1. Initial launch of easyLog <br><br>
   i. Download the jar file here and copy into an empty folder. <br><br>
   ii. Open up a command window to that folder with the jar file. <br><br>
   iii. Run the command java -jar easyLog.jar<br><br>
   *Expected*: easyLog will be loaded, and a welcome message will be shown.
   Ensure that the version number in the welcome matches version of the jar file downloaded. <br>

**Check Items**<br>
1. Check if a new item is added in the item list.<br><br>
   *Prerequisite*: The item to be added is not found in item list.<br><br>
   *Testcase*: `items add pen` followed by `13 12`.<br><br>
   *Expected*: Item 'pen' is added in item list with price $13 and quantity 12.<br><br>

2. Check if repeated item is updated.<br><br>
   *Prerequisite*: The item list already contains item.<br><br>
   *Testcase*: `items update` followed by `1` followed by `p` and followed by `15`.<br><br>
   *Expected*: When input `item list`, the first item is priced at 15 with original quantity.<br><br>

3. Check it item list is cleared.<br><br>
   *Prerequisite*: The item list already contains item.<br><br>
   *Testcase*: `items clear`.<br><br>
   *Expected*: When input `item list`, there is a message informing no item in the system.<br><br>

4. Check if item is deleted.<br><br>
   *Prerequisite*: The item list already contains item.<br><br>
   *Testcase*: `items delete 1`.<br><br>
   *Expected*: When input `item list`, the first item in the original list is deleted.<br><br>

5. Check if item can be found in list.<br><br>
   *Prerequisite*: The item list already contains item, e.g. "PS1".<br><br>
   *Testcase*: `items find PS`.<br><br>
   *Expected*: A list of item containing "PS" will be shown.<br><br>

6. Check if all items can be listed.<br><br>
   *Prerequisite*: The item list already contains item.<br><br>
   *Testcase*: `items list`.<br><br>
   *Expected*: A list of items added to item list will be shown.<br><br>

**Check Orders**<br>
1. Check if a new order is added.<br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list does not contain the same order name.<br><br>
   *Testcase*: `orders add yw` followed by `1 2` followed by `stop`.<br><br>
   *Expected*: A message showing cunstomer [yw] is added.<br><br>

2. Check if correct items are added. <br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list does not contain the same order name.<br><br>
   *Testcase*: `orders add yw` followed by `1 2` followed by `stop` followed by `orders list`.<br><br>
   *Expected*: In the list of orders, under yw, two of the first item in item list are added and the
   total price is reflected.<br><br>

3. Check if the orders are cleared.<br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list contains some orders, e.g. yw.<br><br>
   *Testcase*: `orders clear` followed by `orders list`.<br><br>
   *Expected*: A message showing no order at the moment.<br><br>

4. Check if order deleted.<br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list contains some orders, e.g. yw.<br><br>
   *Testcase*: `orders delete 1` followed by `orders list`.<br><br>
   *Expected*: The first order in the original order list is deleted.<br><br>

5. Check if an order can be found.<br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list contains some orders, e.g. yw.<br><br>
   *Testcase*: `orders find yw`.<br><br>
   *Expected*: A list of orders relating to yw will be shown.<br><br>

6. Check if status of order can be updated.<br><br>
   *Prerequisite*:<br>
   i. The item list contains some items.<br>
   ii. The order list contains some orders, e.g. yw.<br><br>
   *Testcase*: `orders done 1`.<br><br>
   *Expected*: A message showing the order is completed will be shown. In addition, a receipt will be generated.<br><br>

**Help**<br>
1. Viewing help for easyLog.<br><br>
   *Testcase*: Input `help`.<br><br>
   *Expected*: A list of commands for easyLog will be shown.<br><br>

2. Viewing help for items commands.<br><br>
   *Testcase*: Input `items help`.<br><br>
   *Expected*: A list of commands for items will be shown.<br><br>

3. Viewing help for orders commands.<br><br>
   *Testcase*: Input `orders help`.<br><br>
   *Expected*: A list of commands for orders will be shown.<br><br>

**Exit easyLog**<br>
1. Exit easyLog.<br><br>
   *Testcase*: Input `exit`.<br><br>
   *Expected*: easyLog exits with exit message.<br><br>

[Return to Table Of Contents](#table-of-contents)
   
***