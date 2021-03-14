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
&nbsp;&nbsp;&nbsp;&nbsp;[3.2 CAP Simulator/Calculator](#32-cap-simulatorcalculator)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.3 Task Manager](#33-task-manager)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.1 Add New Task](#331-add-new-task)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.2 Delete a Task](#332-delete-a-task)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3 View All Tasks](#333-view-all-tasks)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.4 Pin a Task](#334-pin-a-task)  
&nbsp;&nbsp;&nbsp;&nbsp;[3.4 External Links](#34-external-links)

[4. Command Summary](#4-command-summary)

## 1. Introduction

{Give a product intro}

## 2. Quick Start

### 2.1 System Requirements
- Operating system should be: Windows 7 and above, Mac OS or Linux.
- Ensure that Java 11 is installed on your computer. 
    - You can download the latest version of Java 11 from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).
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
- Upon successful installation of your Jar file, you should see this welcome message after running the Jar file:
  ````  
   Hello from
    ____        _        
   |  _ \ _   _| | _____
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
  ````

## 3. Features 

{Give detailed description of each feature}

### 3.1 Module Information

### 3.2 CAP Simulator/Calculator

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
Prints all existing tasks of type `task`, `assignment`, `midterm` and `final exam` from the task list.

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

### 3.4 External Links

## 4. Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
