# Li Haoyang - Project Portfolio Page

## Overview

```FastScheduler (FS)``` is a desktop app for restaurant managers to schedule employees for work, optimised for use via
a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast
and prefer typing, FS can help you manage the schedules of employees and shifts faster than traditional GUI apps.

## Summary of Contributions

* **Code
  contributed:** [RepoSense link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=lihaoyangML&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)

___
Given below are details of my contributions to the project.

### Contributions to coding

---
#### Implemented most features under the `employee` package as shown below:

* `Employee` class
    * Defined all variables in the class(`name`, `schedules`, all other constants).
    * Created the class constructor(`Employee`) and all get/set methods (`getName`, `setName`, `getSchedules`).
    * Created `addSchedule` to add a new schedule for an employee to the system (handles internal logic).
    * Created `dropSchedule` to drop an existing schedule from an employee (handles internal logic).
    * Created `isScheduleValid` to ensure the schedule entered is in a valid format.
    * Created `isInteger` for variable checking within the class.

*Justification:* This `Employee` Class is essential because our entire APP is about managing an employee's 
schedules and shifts. Hence, each employee must be defined clearly through his/her own attributes.
Also, the `addSchedule`, `dropSchedule`, `isScheduleValid` methods are needed to define the internal behaviours
of the class, such as what is the format of a valid schedule.

---
* `EmployeeController` class
    * Created `addEmployee` to add a new employee to the system.
    * Created `addSchedule` to add a new schedule for an employee to the system (handles external logic).
    * Created `dropSchedule` to drop an existing schedule from an employee (handles external logic).
    * Created `getEmployeeObjectByName` to return an `Employee` based on a name.
    * Created `isEmployeeDuplicate` and `isScheduleDuplicate` to prevent a duplicated employee or schedule from being added to the system.

*Justification:* `EmployeeController` aims to make our code more OOP by handling the logic between an user and his interaction with an 
employee

---
### Implemented the `Ui` class and all its methods
* `printWelcomeMessage`
* `printExitMessage`
* `printHelpMessage`
* `printInvalidScheduleFeedbackMessage`

*Justification:* `Ui` aims to make our code more OOP by taking the responsibility to hold important messages to be displayed to an user.

---
### Built the overall structure of the `AppController` class, and contributed to its final implementation.

Below are the structures/ideas that I came up with for `AppController`:
* The class holds the common variables to be used by all programmers (eg. `employees`, `shifts`)
* The class interacts with the user and passes control to other parts of the program by using 'while' and 'switch' 
statements.

*Justification:* This feature aims to make the code more OOP by serving as a platform that interacts with an user, 
identifies his commands and passes responsibility to other relevant parts of the program



### Contributions to documentation

#### User Guide

Features I wrote in the final version:
* Add an employee: add employee
* Add new employee’s schedules: add schedule
* Drop existing employee’s schedules: drop schedule

Other joint contributions to our google doc (outdated version):
* user stories
* command summary

___

### Contributions to DG

* Under Implementation, I wrote the section titled 'add schedule to employee feature', which includes:
  * A brief overview of the Employee Class, along with a simple class diagram titled 'employee class diagram v2'
  * A detail explanation of our addSchedule feature, along with a detail sequence diagram
  titled 'add schedule sequence diagram v2'
___

### Contributions to team-based tasks

* Contributed to bug finding and fixing
* Creating and releasing of all jar files
* Setting up github team and repo
* Clarifying tp doubts on behalf of the group

___
