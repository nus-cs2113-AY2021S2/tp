# User Guide

___

## Introduction

***

All-in-OneNUS is a **desktop application for making university life easier in NUS.** 
It has 4 different tools, and is optimized for use via a Command Line Interface (CLI). 
- The TeamPlanner feature allows for quick and easy management of team members and the tasks 
  assigned to each team member. 
- The ModulePlanner feature is a module management tool to allow students gain more insights
  into the modules that they are interested in. 
- The CapCalculator feature is a calculation tool that has the ability to assign a module to 
  be non-graded during the calculation and simulate your grades to maximize your desired CAP. 
- The FoodRecommendation feature allows users to review food choices at a single glance and 
  recommends the user a food store accordingly.

___

## Table of Contents
 
  
***

* [1. Quick Start](#1quick-start)
  * [1.1 System Requirements](#11-system-requirements)
    * [1.1.1 Windows 7 and Above](#111-windows-7-and-above)
    * [1.1.2 Mac OS](#112-mac-os)

* [2. Features](#2features)
  * [2.1 How to use user guide](#21-how-to-use-user-guide)
  * [2.2 Main Menu](#22-main-menu)
  * [2.3 Team Planner](#23-team-planner)
    * [2.3.1 Initialisation](#231-Initialisation)
    * [2.3.2 Add team member](#232-add-team-member-(requires-password))
    * [2.3.3 Delete team member](#233-delete-team-member-(requires-password))
    * [2.3.4 Show team](#234-show-team)
    * [2.3.5 Clear team](#235-clear-team-(requires-password))
    * [2.3.6 Show commands](#236-show-commands)
    * [2.3.7 Add a task to a team member](#237-add-a-task-to-a-team-member)
    * [2.3.8 Delete a task from a team member](#238-delete-a-task-from-a-team-member)
    * [2.3.9 Mark task as done](#239-mark-task-as-done)
    * [2.3.10 Show tasks](#2310-show-tasks)
    * [2.3.11 Quit](#2311-quit)
  * [2.4 CAP Calculator](#24-cap-calculator)
    * [2.4.1 Add](#241-add)
    * [2.4.2 Delete](#242-delete)
    * [2.4.3 List](#243-list)
    * [2.4.4 Edit](#244-edit)
    * [2.4.5 View](#245-view)
    * [2.4.6 Show](#246-show)
    * [2.4.7 Goal](#247-goal) 
    * [2.4.8 Update](#248-update)
    * [2.4.9 Exit](#249-exit)      
    * [2.4.10 Help](#2410-help)
  * [2.5 Module Planner](#25-module-planner)
    * [2.5.1 Module](#251-module)
    * [2.5.2 Student](#252-student)
    * [2.5.3 List down](#253-list-down)
    * [2.5.4 Recommendation](#254-recommendation)
    * [2.5.5 Delete student](#255-delete-student)
    * [2.5.6 Exit module planner](#256-exit-module-planner)
  * [2.6 Food Recommendation app](#26-food-recommendation-app)
    * [2.6.1 Add Food Store](#261-add-food-store)
    * [2.6.2 Delete Food Store](#262-delete-food-store)
    * [2.6.3 List Food Stores](#263-list-food-stores)
    * [2.6.4 Clear Food Stores](#264-clear-food-stores)
    * [2.6.5 Recommend Food Store](#265-recommend-food-store)
    * [2.6.6 Halal Food Store](#266-toggle-food-store-halal-status)
    * [2.6.7 Find Food Store](#267-find-food-store)
    * [2.6.8 Food Store Help](#268-food-store-help)
    * [2.6.9 Food Store Bye](#269-food-store-bye)
  * [3.FAQ](#3faq)
  * [4.Command Summary](#4command-summary)
  
---
## 1.Quick Start

***
#### 1.1 System Requirements
* Ensure that you have Java 11 or above installed. You can download the latest version of Java
   11 from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).


##### 1.1.1 Windows 7 and Above

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).
2. Save the Jar file into your desired folder.
3. Open your windows search bar and type `cmd` to open command prompt.
4. Navigate to the folder you stored your Jar file in.
   - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar All-in-One-NUS.jar` to run the application.

##### 1.1.2 Mac OS

1. Download the latest Jar file from [here](https://github.com/AY2021S2-CS2113T-T09-3/tp/releases).
2. Save the Jar file into your desired folder.
3. Open the terminal by clicking on `Launchpad`, then `Utilities`, then `terminal`.
4. Navigate to the folder you stored your Jar file in.
   - You can open a folder by typing `cd` followed by space then the name of your folder.
5. Once you are in the folder, enter `java -jar All-in-One-NUS.jar` to run the application.


---
## 2.Features
***

### 2.1 How to use user guide
1. Single sentences in code blocks `like this` are meant to be written on the Command Line Interface (CLI)
2. Words that are in brackets [**Like this**] are your own personal inputs. 
   Keep in mind they have to be there for the command to work
> **IMPORTANT**: Certain features may contain **similar commands**. However, as long as you are in one feature while using 
> **All-in-One-NUS** you may just refer to that section of the user guide
> 
> ***Example:***  If you are currently using the Team Planner refer to the instruction section [2.3 Team Planner](#23-team-planner)
 etc. The summary of all commands can be found here [4.Command Summary](#4command-summary)
___

### 2.2 Main Menu

***

This is the first thing you will see upon opening the app. It allows you the access to the respective tools

````
Welcome to All-in-OneNUS app!
Enter 1 to access Team Planner
Enter 2 to access Cap Calculator
Enter 3 to access Module Planner
Enter 4 to access Food Recommendation app
Enter bye to exit app
````

Format: `[NUMBER]`

* Entering `1` directs you to the Team Planner
* Entering `2` directs you to the Module Planner
* Entering `3` directs you to the Cap Calculator
* Entering `4` directs you to the Food Recommendation app
* Entering `bye` enables you to exit the app 
* Below is a sample output when you type "bye" (not case-sensitive):

````
Welcome to All-in-OneNUS app!
Enter 1 to access Team Planner
Enter 2 to access Cap Calculator
Enter 3 to access Module Planner
Enter 4 to access Food Recommendation app
Enter bye to exit app
BYE
Thank you for using All-in-oneNUS, we hope to see you again!
````

___
### 2.3 Team Planner
___

The TeamPlanner interface is a **team management** application that provides a team with the ability to track the
team and individual progress by **providing a macroscopic overview of the team and tasks**. 

In general, the commands that handles the modification of the team members requires only a single line of input 
while the commands that handles the modification of tasks assigned to each team member will require 
multiple lines of input (guided by prompts) as you will be required to specify the team member as well as 
the relevant task index(As compared to keying in the exact task, the use of a task index is simpler).

In the TeamPlanner interface, you will be able to add/delete team members as well as assign tasks to each
team member. The exact specifics of each command can be found in this section.
___

#### 2.3.1 Initialisation

Please take note that if you are a first time user that have not used the TeamPlanner inteface before, 
you will be required to provide inputs in the following fields before gaining full access to the TeamPlanner interface:

- Name of the team leader
- Size of the team excluding the leader
- Password

Sample output:

````
Welcome to All-In-One-NUS team manager
No saved file found
Please enter the name of the team lead (No spaces)
Aaron
Please enter the size of your team (excluding the team lead)
2
Please enter the names of your team members,one per line (No spaces)
Barry
Larry
The team details are as follows:
1. [L] Aaron
2. [M] Barry
3. [M] Larry
[Team Lead] Please enter a password (No spaces)
password
[Team Lead] Please re-enter the password
password
The password has been set
Here are the list of commands available :
1. add member [member] - adds a member (requires password)
2. delete member [member] - deletes a member (requires password)
3. show members - shows current members
4. clear members - clears the current team and resets the password (requires password)
5. help - lists the commands available
6. add task
7. delete task
8. mark done
9. show tasks
10. quit - quits the program
````
>Take note:
> 
> **[M]** Denotes the individual is a team member
> 
> **[L]** Denotes the individual is a team lead

#### 2.3.2 Add team member (Requires Password)
>**IMPORTANT NOTE**: Avoid adding a team member with the same name as a member on the team.

Adds a team member to the team. A password prompt will appear and user will have to input the password for the team
member to be added.

Format: `add member [member]`

Example: `add member Bob`

Sample output:
````
add member Bob
Please enter the password
password
[M] Bob has been added to the team
````

#### 2.3.3 Delete team member (Requires Password)
>**IMPORTANT NOTES**: 
> - If two or more members on the team have the same name, the member that is higher up the team list will be deleted.
> - The team leader can be deleted, but can only be added again by clearing the team, in the initialisation phase.

Deletes a team member from the team. A password prompt will appear and user will have to input the password for the team
member to be deleted.

Format: `delete member [member]`

Example: `delete member Barry`

Sample output:
````
[M] Bob has been added to the team
delete member Barry
Please enter the password
password
[M] Barry has been removed
````

#### 2.3.4 Show team
Shows the current members in the team.

Format: `show members`

Example: `show members`

Sample output:
````
show members
The team details are as follows:
1. [L] Aaron
2. [M] Larry
3. [M] Bob
````

#### 2.3.5 Clear team (Requires Password)
>**IMPORTANT NOTE:**
> This command will clear all the members(including the team leader) as well as the tasks assigned to each member.

Clears all the members in the team and all the tasks in the team. A password prompt will appear and user will have to 
input the password for the team details to be cleared.
This will prompt the user to re-enter all information fields, such as
the team leader, size of the team, team members, as well as the password.

Format: `clear members`

Example: `clear members`

Sample output:
````
clear members
Please enter the password
password
Please enter the name of the team lead (No spaces)
Gary
Please enter the size of your team (excluding the team lead)
6
Please enter the names of your team members,one per line (No spaces)
Alex
Bob
Tom
John
Keith
Tim
The team details are as follows:
1. [L] Gary
2. [M] Alex
3. [M] Bob
4. [M] Tom
5. [M] John
6. [M] Keith
7. [M] Tim
[Team Lead] Please enter a password (No spaces)
passWord
[Team Lead] Please re-enter the password
passWord
The password has been set
````


#### 2.3.6 Show commands
Lists the commands available

Format: `help`

Example: `help`

Sample output:
````
help
Here are the list of commands available :
1. add member [member] - adds a member (requires password)
2. delete member [member] - deletes a member (requires password)
3. show members - shows current members
4. clear members - clears the current team and resets the password (requires password)
5. help - lists the commands available
6. add task
7. delete task
8. mark done
9. show tasks
10. quit - quits the program
````
#### 2.3.7 Add a task to a team member
>**IMPORTANT NOTES**:
> - The options for the priority level of the task can only be HIGH/MED/LOW (fully capitalised).
> - If two or more members on the team have the same name,
    the task will be added to the member that is higher up the team list.

Adds a task to a team member on the team. The output will show the task added to the member with a priority level.
 The lower the priority level value, the higher the priority of the task.

When the command is entered into the CLI, the following prompts will appear:
1. Member to add task to: Key in a team member on the team to assign the task to.
2. Task to be added: Key in the task to assign to the team member.
3. Priority level of the task: Key in the priority level of the task(HIGH/MED/LOW). Take note that the input has to
be capitalised.

Format: `add task`

Example: `add task`

Sample output:
````
add task
Member to add task to:
Gary
Task to be added:
Read book
Priority level of the task(HIGH/MED/LOW):
HIGH
Read book has been assigned to [L] Gary with a priority level of 1
````

#### 2.3.8 Delete a task from a team member
>**IMPORTANT NOTE**:
> If two or more members on the team have the same name,
the specified task will be deleted from the member that is higher up the team list.

Deletes a task from a team member on the team.

When the command is entered into the CLI, the following prompts will appear:
1. Member to delete task from: Key in the member the relevant task has been assigned to.
2. Index of task to be deleted: Key in the index of the task to be deleted. The task index can be retrieved by using 
   the show tasks command.
   
Format: `delete task`

Example: `delete task`

Sample output:
````
delete task
Member to delete task from:
Gary
Index of task to be deleted:
1
 [ ] Read book has been removed
````

#### 2.3.9 Mark task as done
>**IMPORTANT NOTE**:
> If two or more members on the team have the same name,
the specified task from the member that is higher up the team list will be marked as done.

Marks a task assigned to a team member as done

When the command is entered into the CLI, the following prompts will appear:
1. Member the task is assigned to: Key in the member the relevant task has been assigned to.
2. Index of task to be marked as done: Key in the index of the task to be marked as done. 
   The task index can be retrieved by using the show tasks command.

Format: `mark done`

Example: `mark done`

Sample output :
````
mark done
Member the task is assigned to:
Gary
Index of task to be marked as done:
1
 [X] Read book has been marked as done for [L] Gary
````

#### 2.3.10 Show tasks
Displays the tasks assigned to each team member. Tasks with a higher priority for a member will be
higher up the list while tasks with a lower priority will be lower down the list.

Format: `show tasks`

Example: `show tasks`

Sample output:
````
show tasks
1. [L] Gary
  1. [HIGH] [X] Read book
  2. [HIGH] [ ] Buy bookmark
  3. [MED]  [ ] Go library
  4. [LOW]  [ ] Organize bookshelf
2. [M] Alex
  1. [HIGH] [ ] Go Town
  2. [LOW]  [ ] Organize books
3. [M] Bob
  1. [HIGH] [ ] Build Library
4. [M] Tom
  1. [LOW]  [ ] Meet with Jerry
5. [M] John
6. [M] Keith
  1. [LOW]  [ ] Go library
7. [M] Tim
  1. [MED]  [ ] Return book
````

#### 2.3.11 Quit
Quits the Team Planner interface and brings you back to the main interface.
Format: `quit`

Example: `quit`

Sample output:
````
quit
Welcome to All-in-OneNUS app!
Press 1 to access Team Planner
Press 2 to access Cap Calculator
Press 3 to access Module Planner
Press 4 to access Food Recommendation app
````

___
### 2.4 CAP Calculator
***
In the CAP Calculator interface you will be able to:

1. Store all your module data and grades in one neat platform
2. Know what CAP you have to reach in the current semester to reach your overall CAP 
3. Be able to strategise how you will be able to maximize CAP  by exploring
    different permuations of SUing, dropping or getting a better grade for all
   your different modules in the current semester.
 ***

#### 2.4.1 Add
Adds your module data

>**IMPORTANT!**
>Do take note of the eligible grades of the modules you input:
> 
>![image](https://user-images.githubusercontent.com/77471508/114297698-bf70e500-9ae4-11eb-838c-fc9975cc228a.png)
>
> Pass/Fail Modules such as GEQ1000 are labelled as CS/CU Modules. CS (Completed Satisfactorily) if you pass
> and CU (Completed Unsatisfactorily) if you fail
> 
> If you have "S/Ued" a module indicate the grade as a S(Satisfactory)
> if you pass or U(Unsatisfactory) if you fail.
> Do keep track of the numbers of "S/Us" you use and ensure that
> the module you have "S/Ued" is eligible for the "S/U" option
> 

Format: `add [Module Code] [Grade] [MCs]`

Example:

Indicate your desired grade:

1. `add CS1231 A- 4`
   
For pass/fail modules indicate a CS or CU

2. `add GES1035 CS 4`
   
For modules you have "S/Ued" indicate an S or a U

3. `add GET1028 S 4`

Sample Output:
````
Your profile: Year 2 Semester 2 student
You are viewing: Year 2 Semester 2
Please enter command: add CS2113T A- 4
------------------------------------------------------------------------
Added CS2113T
------------------------------------------------------------------------
````

***

#### 2.4.2 Delete
Delete specified module data

Format: `delete [Module code]`

Example: `delete CS1010`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: delete CS2040C
------------------------------------------------------------------------
Deleted CS2040C
------------------------------------------------------------------------
````

***
#### 2.4.3 List
Lists your current semester's module data, CAP for your current semester
and overall CAP for Sem 1 to your current semester

>**IMPORTANT NOTE**: 
>Please fill all your semesters (From sem 1 to current sem) with modules you have taken
>or will be taking. This includes grades you predict you will get this semester.


Format: `list`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: list
------------------------------------------------------------------------
[MODULES] [GRADEs] [MCs]
[CG1112 ]   [A-]    [6]
[GEQ1000]   [CS]    [4]
[MA1508E]   [A-]    [4]
[EE2026 ]   [A ]    [4]
[GEH1032]   [S ]    [4]
CAP for this semester is 4.64
Overall CAP is: 4.50
------------------------------------------------------------------------
````

***
#### 2.4.4 Edit
Make edits to your grades for a module

Format: 
1. `edit [Module code]` 

2. `[new grade]`

Example: 
1. `edit CS1231`

2. `A-`



Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: edit MA1508E
------------------------------------------------------------------------
Enter your desired grade:
A
Edited. New data:
[MA1508E] [A] [4]
------------------------------------------------------------------------
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: 
````

***
#### 2.4.5 View
View module and CAP information for Year a Semester b

Format: `view Y[a]S[b]`

Example: `view Y1S1`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: view Y1S1
------------------------------------------------------------------------
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 1
Please enter command:
````

***

#### 2.4.6 Show
Show all modules from semester 1 to your current sem

Format: `show`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 1
Please enter command: show
------------------------------------------------------------------------
Modules for Year 1 Semester 1:
[MODULES] [GRADEs] [MCs]
[CG1111 ]   [A-]    [6]
[CS1010 ]   [B+]    [4]
[CS1231 ]   [S ]    [4]
[GER1000]   [A-]    [4]
[MA1511 ]   [A ]    [2]
[MA1512 ]   [B+]    [2]
------------------------------------------------------------------------
Modules for Year 1 Semester 2:
[MODULES] [GRADEs] [MCs]
[CG1112 ]   [A-]    [6]
[GEQ1000]   [CS]    [4]
[MA1508E]   [A ]    [4]
[EE2026 ]   [A ]    [4]
[GEH1032]   [S ]    [4]
------------------------------------------------------------------------
````


***

#### 2.4.7 Goal
Simulate the CAP you should get in order to attain your desired overall CAP

>**IMPORTANT NOTE**: Please fill your current semester with modules you are currently taking
>This includes arbitrary grades and the number of MCs of the modules

Format: `goal [Desired Overall CAP]`

Example: `goal 4.60`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: goal 4.60
------------------------------------------------------------------------
You should aim to get a CAP of 4.87 for your graded modules this semester
in order to get an overall CAP of 4.60
------------------------------------------------------------------------
````

***

#### 2.4.8 Update
Update your current student status should you commence to the next semester

Format: `update Y[a]S[b]`

If you are going to be a year 2 sem 1 student, you will have to type:

Example: `update Y2S1`

Sample Output:
````
Your profile: Year 1 Semester 2 student
You are viewing: Year 1 Semester 2
Please enter command: update Y2S1
------------------------------------------------------------------------
You are now viewing Year 2 Semester 1
Your profile: Year 2 Semester 1 student
You are viewing: Year 2 Semester 1
Please enter command: 
------------------------------------------------------------------------
````


***

#### 2.4.9 Exit
Exit CAP Calculator

Format: `exit`

Sample Output:
````
Your profile: Year 2 Semester 1 student
You are viewing: Year 2 Semester 1
Please enter command: exit
------------------------------------------------------------------------
Exiting CAP Calculator
````

***

#### 2.4.10 Help

Lists out all options available

Format: `help`

Sample Output:
````
You are now viewing Year 2 Semester 1
Your profile: Year 2 Semester 1 student
You are viewing: Year 2 Semester 1
Please enter command: help
------------------------------------------------------------------------
Here are the list of commands available :
------------------------------------------------------------------------
1. [add] - adds your module data
   Format: add [Module Code] [Grade] [MCs]
   Example: add CS1231 A- 4
------------------------------------------------------------------------
2. [delete] - delete specified module data
   Format: delete [Module Code]
   Example: delete CS1231
------------------------------------------------------------------------
3. [list] - lists your current semester's module data, CAP for your
   current semester and overall CAP for Sem 1 to your current semester
   Format: list
------------------------------------------------------------------------
4. [edit] - make edits to your module data
   Format: 1. edit [Module code]
           2. [new grade]
   Example: edit CS1231
        A+
------------------------------------------------------------------------
5. [view] - view module and CAP information for Year a Semester b
   Format: view YaSb
   Example: as a Year 2 sem 2 student you will have to type:
   view Y2S2
------------------------------------------------------------------------
6. [show] - Show all modules from semester 1 to your current sem
   Format: show
------------------------------------------------------------------------
7. [goal] - simulate the CAP you should get in order to attain your desired overall CAP
   IMPORTANT NOTE: Please fill your current semester with modules you are currently taking
   This includes arbitrary grades and the number of MCs of the modules
   Format: goal [Desired overall CAP]
   Example: goal 4.5
-----------------------------------------------------------------------
8. [update] - update your current student status should you commence to the next semester
   Format: update YaSb
   Example: if you are going to be a year 3 sem 1 student you will have to type:
   update Y3S1
-----------------------------------------------------------------------
9. [exit] - exit CAP Calculator
   Format: exit
-----------------------------------------------------------------------
10.[help] - lists out all options available
   Format: help
-----------------------------------------------------------------------
Your profile: Year 2 Semester 1 student
You are viewing: Year 2 Semester 1
Please enter command: 
-----------------------------------------------------------------------
````


___

### 2.5 Module Planner

***

#### 2.5.1 Module
Enter the module code followed by the number of slots available.

Format: `module [module code],[slots]`


#### 2.5.2 Student
Enter the student information and the rank they want to put for bidding the module. 

Enter [true]/[false] for [graduation requirement] to indicate whether the module is required for graduation.

Format: `student [name],[year],[graduation requirement],[rank]`

#### 2.5.3 List down
Lists down the students and their priority who want to get the module. 

It is sorted in descending order by their priority score.

Format: `list`

#### 2.5.4 Recommendation
Shows the number of students who have higher priority and predicts the chances of getting that module (High, medium or low)

Format: `recommendation [name]`

#### 2.5.5 Delete student
Removes the student from the list.

Format: `delete [index]`

#### 2.5.6 Exit module planner
Exit module planner

Format: 'bye'
***
### 2.6 Food Recommendation app

#### 2.6.1 Add Food Store

Adds a food store with the desired description and location
>**NOTE**: Every food store's  default status is non-halal.
> More information about halal/non-halal status can be found at the [Halal Command](#266-toggle-food-store-halal-status)
> 

Format: `add [Name] d/[Description]`

Example: `add Chicken Rice d/Roasted Chicken`

Sample Output:
````
add Chicken Rice d/Roasted Chicken
____________________________________________________________
Please choose a location
The locations available for choice are: 
1. Frontier Canteen(Located near Science)
2. The Deck (Located near FASS)
3. University Town
4. Techno Edge (Located near Engineering)
____________________________________________________________
````
You will then have to input another command to set the location of the food store.
 The location can be chosen from the output that the app provides. 
Additionally, you can enter `help` to show all available locations again.

Format: `[Location index]`

Example: `1`

Sample Output:
````
1
____________________________________________________________
This food store has been added to the list:
Location: Frontier [Non-Halal] Chicken Rice: Roasted Chicken
____________________________________________________________
````
>**IMPORTANT NOTE** : The location index input has to be valid before the add command is complete.
> This is regardless of whether the add command is valid. 

#### 2.6.2 Delete Food Store

Deletes a food store with the indicated store index
>**IMPORTANT**: Please get the store index of each food store from the [List Command](#263-list-food-stores) 

Format: `delete [store index]`

Example: `delete 1`

Sample Output:
````
delete 1
____________________________________________________________
This store has been removed:
Location: Techno Edge [Halal] chicken rice: white chicken
____________________________________________________________
````

#### 2.6.3 List Food Stores

Prints the list of food stores that are stored in the app

Format: `list`

Sample Output:
````
list
____________________________________________________________
Here is the list of food stores:
1. Location: Techno Edge [Non-Halal] western: chicken chop
2. Location: Techno Edge [Non-Halal] taiwan food: chicken cutlet
3. Location: Techno Edge [Non-Halal] curry rice: pork cutlet
4. Location: Techno Edge [Non-Halal] muslim food: nasi lemak
5. Location: Frontier [Non-Halal] Chicken Rice: Roasted Chicken
____________________________________________________________
````

#### 2.6.4 Clear Food Stores

Clears the entire list of food stores

Format: `clear`

Sample output:
````
clear
____________________________________________________________
All food stores have been cleared from the list.
____________________________________________________________
````

#### 2.6.5 Recommend Food Store

Prints a random food store from the list to recommend to the user

Format: `recommend`

Sample Output:
````
recommend
____________________________________________________________
Please choose a location
The locations available for choice are: 
1. Frontier Canteen(Located near Science)
2. The Deck (Located near FASS)
3. University Town
4. Techno Edge (Located near Engineering)
5. Everything
____________________________________________________________
````
You will then have to input another command to set the location of the food store.
The location can be chosen from the output that the app provides.
Additionally, you can enter `help` to show all available locations again

Format: `[Location index]`

Example: `5`

Sample Output:
````
5
____________________________________________________________
I recommend this store for you to try!
Location: Techno Edge [Halal] chicken rice: white chicken
____________________________________________________________
````
>**IMPORTANT NOTE** : The location index input has to be valid before the recommend command is complete.

#### 2.6.6 Toggle Food Store Halal Status

Sets the status of the store to halal if the current status is non-halal,
 and sets it to non-halal if the current status is halal.

Format: `halal [Store index]`

Example: `halal 1`

Sample Output:
````
halal 1
____________________________________________________________
I have updated the following food store:
Location: Techno Edge [Non-Halal] chicken rice: white chicken
____________________________________________________________
halal 1
____________________________________________________________
I have updated the following food store:
Location: Techno Edge [Halal] chicken rice: white chicken
____________________________________________________________
````

#### 2.6.7 Find Food Store

Searches the food store list for any store that contains the keyword and prints it out

Format: `find [keyword]`

Example: `find chicken`

Sample Output:
````
find chicken
____________________________________________________________
These are the food stores that contains the keyword: 
1: Location: Techno Edge [Halal] chicken rice: white chicken
2: Location: Techno Edge [Non-Halal] western: chicken chop
3: Location: Techno Edge [Non-Halal] taiwan food: chicken cutlet
````

#### 2.6.8 Food Store Help

Shows the list of available commands for the food recommendation bot

Format: `help`

Sample Output:
````
help
____________________________________________________________
Here are the list of commands: 
1. help - Displays the list of commands available
2. add [store name] d/[store description] - Adds a new food store
3. list - Displays out all the food stores
4. delete [store index] - Deletes the store with that index
5. recommend - Recommends a random food store
6. clear - Clears all the food stores in the list
7. find [keyword] - Displays all the food stores that contains the keyword
8. halal [store index] - Sets a food store to halal status if it is non-halal, and vice versa
9. bye - Exits the Food Recommendation bot and returns to the Main Menu
____________________________________________________________
````

#### 2.6.9 Food Store Bye

Exits the food recommendation bot and returns to the main menu of the program

Format: `bye`

Sample Output:
````
bye
____________________________________________________________
Goodbye, hope to see you again!
____________________________________________________________
Welcome to All-in-OneNUS app!
Enter 1 to access Team Planner
Enter 2 to access Cap Calculator
Enter 3 to access Module Planner
Enter 4 to access Food Recommendation app
Enter bye to exit app
````

***
## 3.FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with the `team.txt`, `Food Recommendation.txt`, `ModulePlanner.txt` and
`ModuleStorage.txt` to the destination folder.


## 4.Command Summary
***

  Features|From | Command to enter
----|-----|-------
[2.3 Enter Team Planner](#23-team-planner) | Main Menu | `1`
[2.4 CAP Calculator](#24-cap-calculator) | Main Menu | `2`
[2.3.2 Add Team Member](#232-add-team-member-(requires-password)) | Team Planner | `add member [member]`
[2.3.3 Delete Team Member](#233-delete-team-member-(requires-password)) | Team Planner | `delete member [member]`
[2.3.4 Show team](#234-show-team) | Team Planner | `show members`
[2.3.5 Clear team](#235-clear-team-(requires-password)) | Team Planner | `clear members`
[2.3.6 Show commands](#236-show-commands) | Team Planner | `help`
[2.3.7 Add a task to a team member](#237-add-a-task-to-a-team-member) | Team Planner | `add task`
[2.3.8 Delete a task from a team member](#238-delete-a-task-from-a-team-member) | Team Planner | `delete task`
[2.3.9 Mark task as done](#239-mark-task-as-done) | Team Planner | `mark done`
[2.3.10 Show tasks](#2310-show-tasks) | Team Planner | `show tasks`
[2.3.11 Quit](#2311-quit) | Team Planner | `quit`
[2.4.1 Add](#241-add) | CAP Calculator | `add [Module Code] [Grade] [MCs]`
[2.4.2 Delete](#242-delete)| CAP Calculator | `delete [Module code]`
[2.4.3 List](#243-list) | CAP Calculator | `list`
[2.4.4 Edit](#244-edit)| CAP Calculator | 1. `edit [Module code]` 2. `[new grade]`
[2.4.5 View](#245-view) | CAP Calculator | `view Y[a]S[b]`
[2.4.6 Show](#246-show)| CAP Calculator | `show`
[2.4.7 Goal](#247-goal)  | CAP Calculator | `goal`
[2.4.8 Update](#248-update) | CAP Calculator | `update Y[a]S[b]`
[2.4.9 Exit](#249-exit)  | CAP Calculator | `exit`
[2.4.10 Help](#2410-help) | CAP Calculator | `help`
[2.6.1 Add Food Store](#261-add-food-store) | Food Recommendation | `add [Name] d/[Description]`,`[Location Index]`
[2.6.2 Delete Food Store](#262-delete-food-store) | Food Recommendation | `delete [Store Index]`
[2.6.3 List Food Stores](#263-list-food-stores) | Food Recommendation | `list`
[2.6.4 Clear Food Stores](#264-clear-food-stores) | Food Recommendation | `clear`
[2.6.5 Recommend Food Store](#265-recommend-food-store) | Food Recommendation | `recommend`, `[Location index]`
[2.6.6 Halal Food Store](#266-toggle-food-store-halal-status) | Food Recommendation | `halal [Store Index]`
[2.6.7 Find Food Store](#267-find-food-store) | Food Recommendation | `find [keyword]`
[2.6.8 Food Store Help](#268-food-store-help) | Food Recommendation | `help`
[2.6.9 Food Store Bye](#269-food-store-bye) | Food Recommendation | `bye`