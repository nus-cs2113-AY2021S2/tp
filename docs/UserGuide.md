# User Guide

## Table of Contents

[1. Introduction](#1-introduction)

[2. Quick Start](#2-quick-start)  
&nbsp;&nbsp;&nbsp;&nbsp;[2.1 System Requirements](#21-system-requirements)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.1.1 Windows 7 and above](#211-windows-7-and-above)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.1.2 Mac OS](#212-mac-os)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.1.3 Linux](#213-linux)

[3. Features](#3-features)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.1 Module Information](#31-module-information)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.1. Add/View Module Description](#311-addview-module-description)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.2. Add/View Components and Their Weightages](#312-addview-components-and-their-weightages)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.3. View All Modules](#313-view-all-modules)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.4. Add a Review](#314-add-a-review)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.5. View All Reviews](#315-view-all-reviews)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.6. Delete a Module](#316-delete-a-module)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.2 CAP Simulator/Calculator](#32-cap-simulatorcalculator)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.1 Add CAP and Number of MCs graded taken](#321-add-cap-and-number-of-mcs-graded-taken)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.2 View CAP and Number of MCs graded taken](#322-view-cap-and-number-of-mcs-graded-taken)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.3 Simulate future CAP](#323-simulate-future-cap)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.3 Task Manager](#33-task-manager)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.1 Add New Task](#331-add-new-task)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.2 Delete a Task](#332-delete-a-task)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3 View All Tasks](#333-view-all-tasks)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4 Pin a Task](#334-pin-a-task)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.4 Links](#34-links-menu)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.1. External Links](#341-external-links)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.2. Add an External Link](#342-add-external-link)    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.3. Remove an External Link](#343-remove-external-link)   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.4. View all Links](#344-view-external-links)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.5. Add a Zoom Link](#345-add-zoom-link)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.4.6. View Zoom Links](#346-view-zoom-links)

[4. Command Summary](#4-command-summary)

---

## 1. Introduction

UniTracker is a one-stop application for NUS students to keep track of their work in school. It
comprises 4 key features [Refer to Section 3. Features] that helps to organise all information they
need in one place. Users are allowed to add and edit module information, tasks, zoom links to suit
their needs. This product is optimal for students who prefer Command Line Interface (CLI) over
Graphical User Interface (GUI).

---

## 2. Quick Start

### 2.1 System Requirements

- Operating system should be: Windows 7 and above, macOS or Linux.
- Ensure that Java 11 is installed on your computer.
  - You can download the latest version of Java 11
    from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).

#### 2.1.1 Windows 7 and above

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-F08-4/tp/releases).
2. Save the Jar file into your desired folder.
3. Open your windows search bar and type `cmd` to open command prompt.
4. Navigate to the folder you stored your Jar file in.
  - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar duke.jar` to run the application.

#### 2.1.2 Mac OS

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-F08-4/tp/releases).
2. Save the Jar file into your desired folder.
3. Open the terminal by clicking on `Launchpad`, then `Utilities`, then `terminal`.
4. Navigate to the folder you stored your Jar file in.
  - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar duke.jar` to run the application.

#### 2.1.3 Linux

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-F08-4/tp/releases).
2. Save the Jar file into your desired folder.
3. Open the terminal on linux.
4. Navigate to the folder you stored your Jar file in.
  - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar duke.jar` to run the application.

### 2.2 Start Up

- Upon successful installation of your Jar file, you should see this welcome message after running
  the Jar file:
  ````  
   Hello from
    ____        _        
   |  _ \ _   _| | _____
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|

  ````

---

## 3. Features

This section gives a detailed description of each feature.

### 3.1 Module Information

The Module Information feature allows you to add/edit/delete modules,  
and add information or review for the module of your choice.

Module Information menu:

```
Welcome to the module information menu ^~^
Please choose which action you would like to do and enter the number:
[1] --- Add/View Module Description
[2] --- Add/View Components and Their Weightages
[3] --- View All Modules
[4] --- Add a Review
[5] --- View All Reviews
[6] --- Delete modules
[7] --- Exit to main menu
```
#### 3.1.1 Add/View Module Description

Adds user-defined module description.  
User can view module description added previously.

* Example for adding a module description:  
  Input:  
  `1`  
  Output:
  ````
  What module would you like to modify? [moduleName e.g. CS2113T]
  ````
  Input:  
  `CS2113T`   
  Output:
  ````
  This module does not exist, would you like to add it? [Y/N]
  ````
  Input:  
  `Y`  
  Output:
  ````
  Key in the module description for CS2113T:
  ````
  Input:  
  `Y`  
  Output:
  ````
  Key in the module description for CS2113T:
  ````
  Input: [Retrieved from NUSMods]  
  `This module introduces the necessary skills for systematic and rigorous development of software systems. It covers requirements, design, implementation, quality assurance, and project management aspects of small-to-medium size multi-person software projects`  
  Output:
  ````
  Module description for CS2113T added:
  This module introduces the necessary skills for systematic and rigorous development of software systems. 
  It covers requirements, design, implementation, quality assurance,  
  and project management aspects of small-to-medium size multi-person software projects.
  Returning to module information menu...
  ````
* Example for viewing module description  
  Input:
  `1`  
  Output:
  ````
  What module would you like to modify? [moduleName e.g. CS2113T]
  ````
  Input:  
  `CS2113T`  
  Output:
  ````
  Module exist!
  Here is a description of the module you have added previously
  
  This module introduces the necessary skills for systematic and rigorous development of software systems. 
  It covers requirements, design, implementation, quality assurance, 
  and project management aspects of small-to-medium size multi-person software projects.
  
  Returning to module information menu...
  ````
#### 3.1.2 Add/View Components and Their Weightages
* Example for adding components and weightage to a module
  Input:  
  `2`  
  Output:
  ````
  Would you like to add/view component(s) to a module? [Y/N]
  ````
  Input:  
  `Y`  
  Output:
  ````
  Key in 1 to add component and 2 to view component
  ````
  Input:  
  `1`  
  Output:
  ````
  Module Name?
  ````
  Input:  
  `CS2113T`  
  Output:  
  ````
  Please key in your component and percentage of the component.
  Leave space between component and percentage only.
  Example: FinalExam 20
  ````
  Input:  
  `FinalExam 20`  
  Output:
  ````
  Component and weightage added!
  ````
* Example for viewing the components and weightage of an existing module
  Input:  
  `2`  
  Output:
    ````
    Would you like to add/view component(s) to a module? [Y/N]
    ````
  Input:  
  `Y`  
  Output:
    ````
    Key in 1 to add component and 2 to view component
    ````
  Input:  
  `2`  
  Output:
    ````
    Module Name?
    ````
  Input:  
  `CS2113T`  
  Output:
    ````
  {FinalExam=20}
    ````

#### 3.1.3 View all modules

Lists out all the modules added to UniTracker.

* Example for listing all the modules:  
  Input:   
  `3`  
  Output:
  ```
  Here are the modules in your Modules List:  
  --------------------------------------------  
  [1] --- CS3243  
  [2] --- CS2113T  
  --------------------------------------------
  ```

#### 3.1.4 Add a review

Adds a review for the module of your choice.

* Format: Once you have finished typing your review, type `/end` and hit `Enter`
* Example for adding a review:  
  Input:   
  `4`  
  Output:  
  `Here are the modules in your Modules List:`  
  `--------------------------------------------`  
  `[1] --- CS3243`  
  `[2] --- CS2113T`  
  `--------------------------------------------`  
  `Please choose which module you would like to review and enter the number:`

  Input:  
  `1`  
  Output:

  `You have already added a review:`  
  `Very very very difficult for me:( But, very important to know!`  
  `5/5`

  `Would you like to replace this with another review? [Y/N]`  
  Input:  
  `Y`  
  Output:  
  `After you finish your review, type '/end' to finish reviewing.`  
  `Enter your review for CS3243 below:`

  Input:  
  `The lectures were very entertaining. I have learnt a lot of`   
  `important algorithms.`  
  `Assignments and quizzes helped me learn concepts faster.`  
  `Overall: 5/5`  `/end`  
  Output:
    ```
  Woohoo~ Review added:  
  The lectures were very entertaining. I have learnt a lot of important algorithms.  
  Assignments and quizzes helped me learn concepts faster.  
  Overall: 5/5
  
  Returning to module information menu...
  ```

#### 3.1.5 View all reviews

Lists out all the reviews for all modules added to UniTracker.

* Example for listing all the modules' reviews:  
  Input:   
  `5`  
  Output:  
  ```  
  --------------------------------------------  
  For CS3243:  
  The lectures were very entertaining. I have learnt a lot of important algorithms.  
  Assignments and quizzes helped me learn concepts faster.  
  Overall: 5/5  
  --------------------------------------------  
  For CS2113T:  
  Very fun! We learnt a lot of important programming concepts.  
  Java is also a fun language:)  
  GitHub is difficult but very important to know about it.  
  Overall: 5/5   
  
  --------------------------------------------  
  Returning to module information menu...

  ```

#### 3.1.6 Delete a module

Deletes a module from the list of modules.

* Format: enter the index (integer) of the module that you want to delete.
* Example for deleting a module:  
  Input:  
  `6`  
  Output:  
  `Here are the modules in your Modules List:`  
  `--------------------------------------------`  
  `[1] --- CS3243`  
  `[2] --- CS2113T`  
  `--------------------------------------------`  
  `Enter the module number to be deleted:`  
  Input:  
  `1`  
  Output:
  ```
  You've deleted this: CS3243  
  NOTE: You are deleting your review
  The lectures were very entertaining. I have learnt a lot of important algorithms.
  Assignments and quizzes helped me learn concepts faster.
  Overall: 5/5
  NOTE: You are deleting your module description
  Intro to AI
  --------------------------------------------
  Returning to module information menu...
  ```

---

### 3.2 CAP Simulator/Calculator

The CAP Simulator/Calculator allows you to calculate your future CAP base on your current CAP and
modules you have taken before.

CAP Simulator/Calculator menu:

````
Please choose which action you would like to do and enter the number:
[1] --- Add CAP and Number of MCs graded taken
[2] --- View CAP and Number of MCs graded taken
[3] --- Simulate future CAP
[4] --- Exit
````

#### 3.2.1 Add CAP and Number of MCs graded taken

Adds current CAP and MCs counted into the CAP.  
Exits program if CAP is invalid (to be rectified later).  
[i.e. negative CAP or CAP > 5.0]

Input:  
`1`  
Output:

````
Please key in your current CAP: [e.g. 4.33]
````  

Input:  
`5`  
Output:

````
Please key in the number of MCs graded you have taken so far: 
````  

Input:  
`20`  
Output:

````
Current CAP: 5.0  
Number of Graded MCs Taken: 20
````  

#### 3.2.2 View CAP and Number of MCs graded taken

Views current CAP and MCs counted into the CAP.

Input:  
`2`  
Output:

````
Current CAP: 5.0  
Number of Graded MCs Taken: 20
````

#### 3.2.3 Simulate future CAP

Simulates future CAP base on the current CAP and MCs counted into the CAP.  
Once done, enter `ok` when prompt with entering a new grade again.

Input:  
`3`  
Output:

````
You may key in your letter grades and MCs associated with the letter grade.
Key in a grade: [e.g. A+, B, B-]
````  

Input:  
`C`  
Output:

````
Key in MCs for the associated module: 
````  

Input:  
`4`  
Output:

````
Key in a grade: [e.g. A+, B, B-] 
````  

Input:  
`ok`  
Output:

````
The simulated cumulative average point you have is:  
4.5
````  

---

### 3.3 Task Manager

The task manager feature allows you to add, delete, pin or view your tasks.

Task Manager menu:

````
Welcome to the Task Manager menu ^o^
Please choose which action you would like to do and enter the number:\n"
[1] --- Add New Task
[2] --- Delete a Task
[3] --- View All Tasks
[4] --- Pin a Task
[5] --- Exit
````

#### 3.3.1 Add New Task

Adds a task of type `task`, `assignment`, `midterm` or `final exam` into the task list.

* `Add New Task` menu:
  ````
  Please choose which type of task you would like to add and enter the number:
  [1] --- Task
  [2] --- Assignment
  [3] --- Midterm
  [4] --- Final Exam
  ````
* Example for adding a `task`:  
  Input:  
  `1`  
  Output:  
  `What is the module of the task you want to add?`  
  Input:  
  `CS2113T`  
  Output:  
  `What is the description of the task you want to add?`  
  Input:  
  `Work on user guide`  
  Output:  
  `What is the message you would like to see after completing this?`  
  Input:  
  `Wow yay~`  
  Output:
  ````
  You've added this: [CS2113T] Work on User Guide
  Returning back to TaskManager menu now!
  ````
* For adding an `assignment`, `midterm` or `task`, there will be an additional date and time option.
  * Format for date: `yyyy-mm-dd`
  * Format for time (24-h clock): `hh:mm`
  * Example:  
    Output:  
    `What is the date of the assignment you want to add?`  
    Input:  
    `2021-03-14`
    Output:  
    `What is the time of the assignment you want to add?`  
    Input:  
    `23:59`  
    Output:
    ````
    You've added this: [CS2113T] Work on User Guide (by: Mar 14 2021, 11:59 PM)
    Returning back to TaskManager menu now!
    ````

#### 3.3.2 Delete a Task

Deletes a task of type `task`, `assignment`, `midterm` or `final exam` from the task list.

* `Delete a Task` menu:
  ````
  Please choose which type of task you would like to delete and enter the number:
  [1] --- Task
  [2] --- Assignment
  [3] --- Midterm
  [4] --- Final Exam
  ````
* Example for deleting a `task`:  
  Input:  
  `1`    
  Output:
  ````
  This is the list of your tasks:
  1. [CS2113T] Work on User Guide
  
  What is the number of the task you want to delete?
  ```` 
  Input:    
  `1`  
  Output:
  ````
  You've deleted this: [CS2113T] Work on User Guide
  NOTE: Wow yay~
  Returning back to TaskManager menu now!
  ````

#### 3.3.3 View All Tasks

Prints all existing tasks of type `task`, `assignment`, `midterm` and `final exam` from the task
list.

* Example Output:
  ````
  This is the list of your pinned tasks:

  This is the list of your tasks:
  1. [CS2113T] Work on User Guide

  This is the list of your assignments:
  1. [CS2113T] Work on User Guide (by: Mar 14 2021, 11:49 PM)

  This is the list of your midterms:

  This is the list of your final exams:
  ````

#### 3.3.4 Pin a Task

Pins a task of type `task`, `assignment`, `midterm` or `final exam` from the task list.

* `Pin a Task` menu:
  ````
  Please choose which type of task you would like to pin and enter the number:
  [1] --- Task
  [2] --- Assignment
  [3] --- Midterm
  [4] --- Final Exam
  ````
* Example for pinning a `task`:  
  Input:  
  `1`    
  Output:
  ````
  This is the list of your tasks:
  1. [CS2113T] Work on User Guide
  
  What is the number of the task you want to pin?
  ```` 
  Input:    
  `1`  
  Output:
  ````
  You've pinned this: [CS2113T] Work on User Guide
  Returning back to TaskManager menu now!
  ````

---

### 3.4 Links Menu

The Links feature allows you to add and keep track of http and https links. It also allows users to
keep their zoom links separately.

Links menu:

````
Welcome to the links menu ^~^
Please choose which action you would like to do and enter the number:
[1] --- External links menu
[2] --- Add Zoom links
[3] --- View Zoom links
[4] --- Exit to main menu
````

#### 3.4.1 External Links

Add, remove or view all your links (except zoom links) here.

````
Welcome to the external links menu!
Please choose which action you would like to do and enter the number:
[1] --- add link
[2] --- remove link
[3] --- view links
[4] --- exit to links menu
````

#### 3.4.2 Add External Link

Adds an external link that follows the format to the external links list.

Format: `<scheme>www.<domain name>.<TLD>/<path name>`

Supported schemes include: https, http only

Supported Top Level Domain(TLD) include: .com, .org only

Example for adding an external link:

Input: `1`

Output:

````
Please enter the link in this format:
<scheme>www.<domain name>.<TLD>/<path name>
supported schemes: https, http for now... Sorry!
supported TLD: .com, .org for now... we will work on it!
````

Input: `https://www.youtube.com/java`

Output:

````
Alright! I have added the following link ---  https://www.youtube.com/java

Welcome to the external links menu!
Please choose which action you would like to do and enter the number:
[1] --- add link
[2] --- remove link
[3] --- view links
[4] --- exit to links menu
````

#### 3.4.3 Remove External Link

Removes an external link from the external links list.

Input: `2`

Output:

````
Please choose which link you would like to delete and enter the number

These are the links you have added --->
[1] --- https://www.youtube.com/java
[2] --- https://www.facebook.com
````

Input: `2`

Output:

````
You have deleted --- https://www.facebook.com
Welcome to the external links menu!
Please choose which action you would like to do and enter the number:
[1] --- add link
[2] --- remove link
[3] --- view links
[4] --- exit to links menu
````

#### 3.4.4 View External Links

Allows the user to view all external links added.

Input: `3`

Output:

````
These are the links you have added --->
[1] --- https://www.youtube.com/java
[2] --- https://www.google.com
[3] --- https://www.yahoo.com

Welcome to the external links menu!
Please choose which action you would like to do and enter the number:
[1] --- add link
[2] --- remove link
[3] --- view links
[4] --- exit to links menu
````

#### 3.4.5 Add Zoom Link

Adds a zoom link, and tags it to a module of your choice together with the meeting password (if
available).

Input: `2`

Output:

````
Please enter the zoom link and the module it is for in this format:
<zoom link> <module code>
````

Input: `https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09 cs2101`

Output:

````
Does your meeting have password which you would like to add? [Y/N]
````

Input: `Y`

Output:

````
Please enter your password below!
````

Input: `open sesame`

Output:

````
Woohoo~ Zoom link added:
https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09 for cs2101
Welcome to the links menu ^~^
Please choose which action you would like to do and enter the number:
[1] --- External links menu
[2] --- Add Zoom links
[3] --- View Zoom links
[4] --- Exit to main menu
````

#### 3.4.6 View Zoom Links

View all zoom links stored in the application

Input: `3`

Output:

````
Here are your zoom links! Study hard :)

[https://nus-sg.zoom.us/j/82190325074?pwd=M2NjZTRtQVpRc0loMnVIaUpsRU5TZz09, cs2101, open sesame]
Welcome to the links menu ^~^
Please choose which action you would like to do and enter the number:
[1] --- External links menu
[2] --- Add Zoom links
[3] --- View Zoom links
[4] --- Exit to main menu
````

---

## 4. Command Summary

Features|Menu | Command to enter from the Main Menu
----|-----|-------
[Add/View Module Description](#311-addview-module-description) | Module Information | 1, 1
[Add/View Components and Their Weightages](#312-addview-components-and-their-weightages) | Module Information| 1, 2
[View All Modules](#313-view-all-modules) | Module Information | 1, 3
[Add a Review](#314-add-a-review) | Module Information | 1, 4
[View All Reviews](#315-view-all-reviews) | Module Information | 1, 5
[Delete a Module](#316-delete-a-module) | Module Information | 1, 6
[Add CAP and Number of MCs graded taken](#321-add-cap-and-number-of-mcs-graded-taken) | Cap Simulator / Calculator | 2,1
[View CAP and Number of MCs graded taken](#322-view-cap-and-number-of-mcs-graded-taken) | Cap Simulator / Calculator | 2,2
[Simulate future CAP](#323-simulate-future-cap) | Cap Simulator / Calculator | 2.3
[Add a new Task](#331-add-new-task) | Task Manager | 3, 1
[Delete a new Task](#332-delete-a-task) | Task Manager | 3, 2
[View all Tasks](#333-view-all-tasks) | Task Manager | 3, 3
[Pin a Task](#334-pin-a-task) | Task Manager | 3, 4
[Add an External Link](#342-add-external-link) | External Links | 4, 1, 1
[Remove an External Link](#343-remove-external-link) | External Links | 4, 1, 2
[View all Links](#344-view-external-links) | External Links | 4, 1 , 3
[Add a Zoom Link](#345-add-zoom-link) | Links | 4, 2
[View Zoom Links](#346-view-zoom-links) | Links | 4, 3

