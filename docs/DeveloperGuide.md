# Developer Guide

## Table of Contents

[1. Introduction](#1-introduction)  

&nbsp;&nbsp;&nbsp;&nbsp;[1.1 About This Developer Guide](#11-about-this-developer-guide)  
&nbsp;&nbsp;&nbsp;&nbsp;[1.2 How to Use This Developer Guide](#12-how-to-use-this-developer-guide)  
&nbsp;&nbsp;&nbsp;&nbsp;[1.3 Conventions in This Developer Guide](#13-conventions-in-this-developer-guide)

[2. Setting Up](#2-setting-up)

[3. Design](#3-design)  

&nbsp;&nbsp;&nbsp;&nbsp;[3.1 Architecture](#31-architecture)    
&nbsp;&nbsp;&nbsp;&nbsp;[3.2 UI Component](#32-ui-component)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.3 Features Component](#33-features-component)    
&nbsp;&nbsp;&nbsp;&nbsp;[3.4 Storage Component](#34-storage-component)    

[4. Implementation](#4-implementation)  

&nbsp;&nbsp;&nbsp;&nbsp;[4.01 Add New Module](#401-add-new-module)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.02 View a Module](#402-view-a-module)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.03 View All Modules](#403-view-all-modules)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.04 Delete a Module](#404-delete-a-module)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.05 Add New Review](#405-add-new-review)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.06 Delete a Review](#406-delete-a-review)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.07 Add New Task](#407-add-new-task)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.08 Mark/Unmark a Task as Done](#408-markunmark-a-task-as-done)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.09 Delete a Task](#409-delete-a-task)   
&nbsp;&nbsp;&nbsp;&nbsp;[4.10 View All Tasks](#410-view-all-tasks)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.11 Pin A Task](#411-pin-a-task)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.12 Add Zoom Link](#412-add-zoom-link)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.13 Add Module Components](#413-add-module-components)  
&nbsp;&nbsp;&nbsp;&nbsp;[4.14 View Module Components](#414-view-module-components)  

[5. Product scope](#5-product-scope)    

&nbsp;&nbsp;&nbsp;&nbsp;[5.1 Target user profile](#51-target-user-profile)   
&nbsp;&nbsp;&nbsp;&nbsp;[5.2 Value proposition](#52-value-proposition)

[6. User Stories](#6-user-stories)

[7. Non-Functional Requirements](#7-non-functional-requirements)

[8. Glossary](#8-glossary)

[9. Instructions for manual testing](#9-instructions-for-manual-testing)

---

## 1. Introduction

- UniTracker is a one-stop application for NUS students to keep track of their work in school.

- It comprises 4 key features (ModuleInfo, SU Calculator/Simulator, TaskManager, Links) that helps
  to organise all information they need in one place.

- Users are allowed to add and edit module information, tasks, zoom links to suit their needs.

- This product is optimal for NUS students who prefer Command Line Interface (CLI) over Graphical
  User Interface (GUI).

### 1.1 About This Developer Guide

This developer guide was made to help you set up UniTracker on your computer for usage, testing and further implementations. It also provides you with
all the information you need to use UniTracker alongside detailed diagrams on the implementation of our different features and how they integrate together.

### 1.2 How to Use This Developer Guide

Firstly, refer to [Section 2. Setting Up](#2-setting-up) for instructions on setting up UniTracker
on and IDE on your local computer.

Once UniTracker is up and running, you can refer to the [table of contents](#table-of-contents) to
navigate to specific sections to explore and learn about our different features and how they were implemented.

### 1.3 Conventions in This Developer Guide

In this developer guide, all text that appears on the CLI or in code will be written in a `code block`.

> 📝 **Note!**  
> This is a note section. Additional useful information will be written in sections such as this one.

> ⚠️ **<span style="color: red"> WARNING! </span>**  
> This is a warning section. Any user interaction with UniTracker that may result in issues or unintended results will be written in sections such as this one.


---

# 2. Setting Up

1. Ensure you have version 11 of Java. You can install it
   from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).
2. Fork the UniTracker repo from [here](https://github.com/AY2021S2-CS2113T-F08-4/tp).
3. Clone the fork on to your computer. We recommend using Sourcetree for this. You can download
   Sourcetree from [here](https://www.sourcetreeapp.com/).
4. Download and open Intellij. You can download Intellij
   from [here](https://www.jetbrains.com/idea/)
5. If you are not in the welcome screen, click `File` -> 'Close project' to close the existing
   project dialog.
6. Set up the correct JDK version for Gradle.
    1. Click `Configure` -> `Project Defaults` -> `Project Structure`
    2. Click `New...` and set it to the directory of the JDK.
7. Click `Open or Import` in Intellij.
8. Locate the `build.gradle` file, select it and click `OK`.
9. If asked, choose to `Open as Project`.
10. Click `OK` to accept the default settings.
11. Right-click on the `Duke.java` file and select `Run Duke.main()`.
12. If the set up was done right, you should see this welcome message:
    ````  
     Welcome to 
       _   _               _      _____                                _
      | | | |   _ _       (_)    |_   _|     _ _    __ _      __      | |__     ___       _ _
      | |_| |  | ' \      | |      | |      | '_|  / _` |    / _|     | / /    / -_)     | '_|
       \___/   |_||_|    _|_|_    _|_|_    _|_|_   \__,_|    \__|_    |_\_\    \___|    _|_|_
     _|"""""| _|"""""| _|"""""| _|"""""| _|"""""| _|"""""| _|"""""| _|"""""| _|"""""| _|"""""|
     "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-' "`-0-0-'
  
    This is the list of your pinned tasks:
  
    Main Menu:
    [1] Module Information
    [2] CAP Simulator/Calculator
    [3] Task Manager
    [4] External Links
    [5] Exit Program
    ````

---

## 3. Design

### 3.1 Architecture

![Diagram](diagrams/MainArchitecture.png)  
*Figure 1*

The Architecture Design in figure 1 above shows the design of UniTracker.

Given below are quick overviews of UniTracker's 4 main components:

1. The `Duke` class contains the main method of our application.
    - At the start of the application, it initializes all the classes in sequence.

2. The Ui component handles interactions with the user and contains the methods for system output.

3. The Features component contains the main classes our 4 key features.
    - `ModuleInfo`: contains methods for our module information features.
    - `HelpGraduation`: contains methods for our SU calculator/simulator.
    - `TaskManager`: contains methods for our task management features.
    - `Links`: contains methods for our links features.

4. The Storage component writes data to, and loads data from the hard disk.


### 3.2 UI Component

![Diagram](diagrams/uiArchitecture.png)    
*Figure 2*

The class diagram of the Ui component can be seen in figure 2.

The Ui class handles user input and also contains the methods for user interface.
- `longHorizontalLine` organises our system output by distinguishing user input and system output.
- `readCommand()` reads user input and returns it in the form of a string.
- `readCommandToInt` also reads user input but returns it in the form of an integer.
- `printMainMenu()` prints the main menu for UniTracker. The Ui class also contains all the menus for our other features.
- `printInvalidInputMessage()` prints the error message for invalid user inputs. The Ui class also contains other error messages.

### 3.3 Features Component

blank

### 3.4 Storage Component

![Diagram](diagrams/storageArchitecture.png)    
*Figure 4*

The storage component, as seen in figure 3, stores data in a folder named `UniTracker Data` on the user's hard disk.
It also loads the data upon startup. 
- `saveAllFiles()` saves all the data from the features component into its respective text files in `UniTracker Data`.
  This method is called at the end of every execution of a command.
- `loadAllFiles()` loads the data from the text files in `UniTracker Data` folder from the user's hard disk. If the folder and text files does not exist, it will be created for the user.

---

## 4. Implementation

### 4.01 Add New Module
This feature is for users to add any modules from their university course into the list of modules.  
All modules are stored in an `ArrayList` called `modules`.  
Given below is the sequence diagram for the feature:  
![Diagram](diagrams/moduleInfo/module/addNewModule.png)  
A general explanation of how this feature works:  

1. When user types in a `module name`, it will be checked for:
   1. illegal characters entered,  
   1. if it is an empty string, and  
   1. if a module with that exact name exists in the `ArrayList` of `modules`
1. When `module name` is valid, and when user types in a `module description`, it will be checked if it is an empty string.

### 4.02 View a Module
This feature allows users to view all the important information regarding a particular `module` (e.g. `MCs`, `Grade`, `Links`, `Tasks`, etc. ).

A general explanation of how this feature works:  

1. When a `module` is chosen from the list, there will be a method within the `Module` class itself that gets the relevant class-level attributes. 
1. This will print the important information regarding the module.

### 4.03 View all Modules
This feature prints out the `name` String attribute of the `module` objects in the `ArrayList` of `modules`.  

### 4.04 Delete a Module
This feature deletes a `module` object from the `ArrayList` of `modules`.  
Just before a successful deletion, the deleted `module`'s relevant information (e.g. `reviews`, `module description`, etc.) will be printed out for the user's reference.

### 4.05 Add New Review
This feature allows user to `add a review` for any of the modules they have taken.

> 📝 **Note!**  
> This action will **overwrite** any existing reviews with the new review.


```
> CS2113T is very fun:) I have learnt so many important concepts.
> Overall 10/10 :)
> /end
Woohoo~ Review added:  
CS2113T is very fun:) I have learnt so many important concepts.  
Overall 10/10 :) 

Returning to module information menu...
  ```
Given below is the sequence diagram for the feature:  
![Diagram](diagrams/moduleInfo/addNewReview.png)    
A general explanation of how this feature works:

A `while` loop is used to take in multiple lines of input until the input contains
the `/end` symbol. Anything typed after this `/end` symbol will be erased.

**When overwriting this review with a new review**: The old review will be printed for user
reference. The user will also be alerted that this action will delete his/her old review.


### 4.06 Delete a Review  
This feature allows user to delete a `review` from the `module`.

A general explanation of how this feature works:

Deleting a `review` would __reset__ the `review` *String* attribute of a `module` to a default value
of:  
`"You have not reviewed this module yet."`  

If this default string value already existed when `deleteAReview` is called (i.e. if the user has not reviewed the module yet), 
this same string will be printed out as a warning to the user. 

### 4.07 Add New Task

This feature allows the user to add tasks of type `normal task`, `assignment`, `midterm`, `final exam` to a
task list.

All task types (except `normal task`, which contains arguments 1, 2 and 5 only) contain 5 arguments upon
creation:

1) Module Code <br> Example: `CS2113T`  
2) Task Description <br> Example: `Finish v2.0`  
3) Date <br> Example: `2021-03-21`  
4) Time <br> Example: `23:59`  
5) Message <br> Example: `Good job!`  

Given below is the sequence diagram for the feature:  
![Diagram](diagrams/tasks/addNewTask1.png)

A general explanation of how this feature works:

1. When the user calls this feature, the application will prompt them to input the arguments required
for task creation.
2. If there are no existing modules, the user can either exit the command or create a new module. Otherwise, the user can select the module from the existing list of modules. ![Diagram](diagrams/tasks/getModuleListRef1.png)  *Figure ?*
3. The user has to input a valid format for the __date__ and __time__ field (refer to section 3.3.1 of User
Guide or the example above), and our application will convert it to a more readable format for the
user. Using the example above,
    - `2021-03-21` will be outputted as `Mar 21 2021`
    - `23:59` will be outputted as `11:59 PM`
4. The user input for __message__ (argument 5 above) will be printed out when the user marks the task as done,
signalling completion.
5. This new task will then be stored into an `ArrayList` for its task type for future reference.

### 4.08 Mark/Unmark a Task as Done

This feature allows the user to mark or unmark tasks of type `task`, `assignment`, `midterm`, `final exam` as done.

Given below is the sequence diagram for this feature:
![Diagram](diagrams/tasks/markUnmarkTask1.png)

A general explanation of how this feature works:

1. When the user calls this feature, the application will prompt them to choose the __task
type__ (`normal task`, `assignment`, `midterm`, `final exam`) of the task they want to mark/unmark. 
2. All existing tasks in the ArrayList for the task type they chose will then be printed out, and the user has to
input the index of the task they want to mark/unmark. 
3. Depending on the current status of the task, the user will be informed of the current status of the task and be asked if they want to change it.
4. Upon marking a task as done, the message that the user inputted upon creation of this particular task will then be printed out.


### 4.09 Delete a Task

This feature allows the user to delete a task of type `normal task`, `assignment`, `midterm`, `final exam`
from a task list.

Given below is the sequence diagram for this feature:
![Diagram](diagrams/tasks/deleteATask1.png)

A general explanation of how this feature works:

1. When the user calls this feature, the application will prompt them to choose the __task
type__ (`normal task`, `assignment`, `midterm`, `final exam`) of the task they want to delete.
2. All existing tasks in the `ArrayList` for the task type they chose will then be printed out, and the user has to
input the index of the task they want to delete. 
3. The task they select will then be deleted from the `ArrayList`.

### 4.10 View All Tasks

This feature allows the user to view all their existing tasks for all task types.

Given below is the sequence diagram for this feature:
![Diagram](diagrams/tasks/viewAllTasks1.png)

A general explanation of how this feature works:

1. When the user calls this feature, the application will first iterate through and print out the pinned task list.
2. This is then followed by the `normal task` list, `assignment` list, `midterm` list and `final exam` list.

### 4.11 Pin a Task

This feature allows the user to pin a task of type `normal task`, `assignment`, `midterm`, `final exam`
from a task list.

Given below is the sequence diagram for this feature:
![Diagram](diagrams/tasks/pinTask1.png)

A general explanation of how this feature works:

1. When the user calls this feature, the application will prompt them to choose the __task
type__ (`task`, `assignment`, `midterm`, `final exam`) of the task they want to pin.
2. All existing tasks in the `ArrayList` for the task type they chose will then be printed out, and the user has to
input the index of the task they want to pin. 
3. The pinned task list is stored using a HashMap, with the key being the __task type__ and value being an ArrayList.
The task the user selected will then be added to the respective pinned task
ArrayList corresponding to the __task type__ they chose.

### 4.12 Add Zoom Link

Given below is the sequence diagram for the feature:  
![Diagram](diagrams/links/addZoomLink.png)

A general 4-step explanation of how this feature works is shown below:

Step 1. The ZoomLinkInfo#addZoomLink() method calls AddTask#printAndGetModule() which asks the user
to input the number corresponding to the module code they want, and returns the module code.

Step 2. The ZoomLinkInfo#addZoomLink() method calls other methods in the Ui class to determine the
link, and whether a password is required for the Zoom meeting.

> 📝 **Note!**  
> If the user does not require the zoom link to be tagged to a module,
> AddTask#printAndGetModule() in Step 1 would return an empty string, and the module code would be
> initialised to "Zoom link has no module code".

Step 3. The ZoomLinkInfo#addZoomLink() method then calls ModuleInfo#getModule() in order to retrieve
the module object which is stored in the ModuleInfo class.

Step 4. Module#setZoomLink then sets the `zoomLink` attribute of the module object to the zoom link
that was entered.

### 4.13 Add External Links 

This feature allows users to add and store their favourite links.

Given below is the sequence diagram for the feature:
![Diagram](diagrams/links/addLink.png)

A general 2-step explanation of how this feature works is shown below:

Step 1. The Ui#printEnterLinkMessage() method prompts the user to enter the link and Ui#readCommand captures the input.

Step 2. If the link is valid and is not a duplicate, then LinkInfo#addLink() is called, which creates an object LinkInfo with the link description and adds it into the links list.

> 📝 **Note!**
> The program is case-sensitive and only accepts links that start with https and http, followed by "://www." + domain name + top level domain
> 
> For example: https://www.youtube.com or http://www.imf.org would be accepted. Other variations that do not follow these guidelines might not work!

The program checks for duplicates by doing a simple linear search of all LinkInfo objects in the links list. If the object can be found within the list, then a duplicate link must exist.

### 4.4 CAP Simulator/Calculator

This section explains the implementation and design considerations of the
set of features under CAP Simulator/Calculator. 
For more information on CAP Simulator/Calculator, you may refer to __Section 3.2__ under [*User Guide*](UserGuide.md).

#### 4.4.1 Add CAP and Number of MCs graded taken
This feature allows user to add cumulative average point, that ranges between 0 - 5,
with 2 decimal places of precision, and total number of graded modular credits.

Given below is the sequence diagram for the feature:  

![Diagram](diagrams/capCalculator/addCapAndMcs.png)

How the feature works:
The feature is facilitated by the `AddCapAndMcs` method in the `HelpGraduationManager` class, and a call to the class is performed
upon entering this sequence of numbers from the main menu:  
`2`, `1`.

A general 2-step explanation of how this feature works is shown below:

Step 1.

Step 2.

### 4.10 Add Module Components
This feature allows user to add user-defined module components and its related weightage for an
existing module.

![Diagram](diagrams/moduleInfo/addComponent.png)  
How the feature works:  
The feature is facilitated by the `Component` class and a call to `addComponent()` is performed upon
expected user input to add a new component to a module.

First, a call to `Ui` is performed to find out what module* the user wishes to add a component (and
its weightage). Secondly, a `for` loop is run to find whether the module entered by the user is
stored in the system.  
Here, there are two possible routes:

- If the module is present, a call to `Ui` is performed to find out the component name and the
  associated weightage for that component.
- If the module is not present, the call to `addComponent()` returns to `ModuleInfo` class (main
  class for module-related commands).

Assuming the first route is well executed, the component (and its weightage) is stored in a
Hashtable format in the `Module` object specified by the user previously*.

### 4.11 View Module Components

How the feature works:  
The feature is an extension of the `Component` feature.

It allows user to view all the module components under a module specified by the user input.

Improvement: the total weightage (in whole numbers) of the module should not exceed 100.


---

## 5. Product scope

### 5.1 Target user profile

This product is for NUS students to help them to keep track/add/edit module information, and
deadlines. This product is for users who prefer CLI to GUI.

### 5.2 Value proposition

Our product is user-specific as it allows users to customize and personalize their own module
information and deadlines to suit their needs. Our product allows users to organize their own daily
schedules and keep track of their deadlines all on one platform.

Information and materials of our various modules are on varying platforms; some could be on Luminus,
or the professor's personal websites, or sent to us via email, or on Wiki.nus. We want to solve the
issue of being disorganized and confused over not knowing or remembering where certain information
is.

By using UniTracker, users will be able to store all necessary details on one platform so that they
can keep track of commonly accessed information while keeping track of the tasks they have.

---

## 6. User Stories  
  
|Version| As a ... | I want to ... | So that I can ...  
|--------|----------|---------------|------------------  
|v1.0|new user|have a list of command suggestions to choose from|navigate the platform easily  
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application  
|v1.0|student|add zoom links| find them more quickly without always having to log into LumiNUS or checking the email  
|v1.0|student|add external links| refer to them more easily  
|v1.0|student|add deadlines to some tasks|record when a task needs to be done  
|v1.0|student|categorize my tasks|know whether a task is a normal task, assignment or exam  
|v1.0|student|add messages that will print when I complete a task|encourage or remind myself of what I need to do next    
|v1.0|student|add personal reviews on modules I have taken|know what to recommend to my peers  
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list    
|v2.0|user| store my information | view them later without having to re-type them again  

---

## 7. Non-Functional Requirements  

1. Must be able to work on any Mainstream OS as long as Java 11 (or above) is installed.  
2. Must be able to work completely offline.  

---

## 8. Glossary  

* Mainstream OS: Windows, Linux, macOS  
* Domain name: The actual name of the website. For example, 'google' in 'google.com' is the domain name  
* Top-level domain: .com , .net, .org , .edu etc.  
---

## 9. Instructions for manual testing

###Initial Launch  
1. Download the jar file and copy into an empty folder.  
1. Refer to [this website](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#2-quick-start) to set up the application.  

###Adding/Deleting a Module  
1. You may add a module by the following commands: `1`, `1` (from main menu). Enter the `module name` and `description`. You may choose to keep illegal characters in your module name.  
    1. For example, by entering `CS2113T@NUS` as the `module name`, the `@` symbol is seen as a non-alphanumeric character. You will be prompted to confirm the use of such characters.    
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#311-add-a-module) for more instructions.  
1. You may delete a module by the following commands: `1`,`4` (from main menu). Enter the number of the `module` from the list you want to delete.    
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#314-delete-a-module) for more instructions.    
###Adding/Deleting a Task  
1. You may add a `task` to a `module` by the following commands: `1`, `11` OR `3`, `1` (from main menu). Select the `task type` and the `module`.     
   1. If you want to add a `task` to a **new** `module`, type a number that is NOT in the list of modules.  
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#331-add-new-task) for more instructions.  
1. You may delete a task by the following commands: `1`, `12` OR `3`, `3` (from main menu).  
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#333-delete-a-task)  
###Adding/Deleting Zoom Links  
1. You may add a `zoom link` to a `module` by the following commands: `1`, `13` OR `4`, `2` (from main menu). Select the `module` and enter the `zoom link` (and password).    
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#345-add-zoom-link) for more instructions.    
1. You may delete a `zoom link` by the following commands: `1`, `14` OR `4`, `3` (from main menu).   
    1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#346-delete-zoom-link) for more instructions.  

###Calculating CAP  
1. To calculate **actual** `CAP` score - enter `1`, `2`, `1` (from main menu). This will calculate your CAP based on the grades you have entered for each `module`.  
1. To simulate **expected** `CAP` score - enter `1`, `2`, `2` (from main menu). This will prompt you to enter the `grade` and `MCs` for the simulated `modules`.  
    1. Type `ok` to end simulation and print out your simulated `CAP` score.  
1. Refer to this [link](https://ay2021s2-cs2113t-f08-4.github.io/tp/UserGuide.html#323-simulate-future-cap) for more instructions.  

###Saving Data  
1. All information related to UniTracker will be stored in the root folder of the jar file, under the `UniTracker Data` folder.  
1. In the event of a corrupted file or if a file is tampered with, UniTracker will print an `error` message, and you may not be able to run the application. To resolve this, please delete the `UniTracker Data` folder. The program will create a **new** `UniTracker Data` folder.  
