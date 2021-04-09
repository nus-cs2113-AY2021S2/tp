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

### New Features

#### Implemented most features under the `employee` package

* `Employee` class
    * Defined all variables in the class(`name`, `schedules`, all other constants).
    * Created the class constructor(`Employee`) and all get/set methods (`getName`, `setName`, `getSchedules`).
    * Created `addSchedule` to add a new schedule for an employee to the system (handles internal logic).
    * Created `dropSchedule` to drop an existing schedule from an employee (handles internal logic).
    * Created `isScheduleValid` to ensure the schedule entered is in a valid format.
    * Created `isInteger` for variable checking within the class.
* `EmployeeController` class
    * Created `addEmployee` to add a new employee to the system.
    * Created `addSchedule` to add a new schedule for an employee to the system (handles external logic).
    * Created `dropSchedule` to drop an existing schedule from an employee (handles external logic).
    * Created `getEmployeeObjectByName` to return an `Employee` based on a name.
    * Created `isEmployeeDuplicate` and `isScheduleDuplicate` to prevent duplicated employee or schedule from being added to the system.
    
### Implemented the `Ui` class and all its methods
* `printWelcomeMessage`
* `printExitMessage`
* `printHelpMessage`
* `printInvalidScheduleFeedbackMessage`

### Built the skeleton of the `AppController` class, and contributed to its final implementation.

*Justification:* This feature is essential in allowing the user to store data locally and load them, saving the trouble
to re-enter the data.

*Highlights:* This feature is coded in an OOP way that makes use of a Parser to parse the data to be stored/loaded. This
is very challenging as the FileManager has to be able to handle any sorts of data, and able to store the objects in a
text file.

---

#### Implemented `DataParser` class

Contains:

* `parseData` and `parseShift` methods
    * *What it does:* converts the employee and shift objects with their attributes to data that can be written to a
      text file.

*Justification:* This feature is essential to store the objects into a save file where all its attributes can be loaded.

*Highlights:* This feature is coded in an OOP way that allows the FileManager to use its methods to store the converted
data. This feature is very challenging as not only does it convert objects into Strings, but also their attributes of
various data types such as LocalDate.

---

### Enhancements implemented

#### Implemented `formatData()` methods in all entity classes

This method formats all the entities into a string data format that contains all their attributes.

*Considerations*: Have to take into account the various data types and how can the arraylist of data can be stored.

---

### Loading of Shifts in the `AppController` on start up

This allows the Shifts objects to be initialised with the Employees that are assigned to them, along with vacancies and
shift date.

*Considerations*: This is pretty tricky as the shift objects have to be initialised along with their respective data
using the Shift Date as an identifier.

___

#### Implemented Assertions

Created the Asserter class to allow testing of methods.

___

#### Formatted all the codes to fit Java coding standards

Made sure the format of all the codes pass the JavaCI tests.

---

### Contributions to documentation

#### User Guide

For the user guide, I have transferred over what our team has discussed on Google Docs into the User Guide, along with
updated commands. I have formatted the guide to make it more readable too.

___

### Contributions to DG

For the developer guide, my main contributions are the sequence diagrams **loadEmployees** and **loadShifts**. For
the **Design** and **Implementation** sections of the DG, I contributed to the **Saving of Data** and **Loading of
Data**.
___

### Contributions to team-based tasks

* Helping with Bug fixes
* Supplying ideas for implementation and solution for Bugs

___
