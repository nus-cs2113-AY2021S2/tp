---

# Ho Wei Yi Stanley - Project Portfolio Page

---

---

## Overview

```FastScheduler (FS)``` is a desktop app for restaurant managers to schedule employees for work, optimised for use via
a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast
and prefer typing, FS can help you manage the schedules of employees and shifts faster than traditional GUI apps.

---

### Summary of Contributions


* **Code
  contributed:** [RepoSense link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=beaniestanley&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)
  

Given below are details of my contributions to the project.

---

### New Features


#### Implemented `Shift` class and its methods

Essential methods implemented:

* `Shift` constructor
* `get` and `set` methods
* `assignEmployee` and `unassignEmployee`
    * `assignEmployee`: assigns an employee to a shift and updates the vacancy of the shift 
    * `unassignEmployee`: unassigns an employee from a shift and updates the vacancy of the shift
    
*Justification:* This class is an essential class that represents a work shift using date, period (in 4 hour blocks 
using indexing), employees on the shift and number of vacancies remaining to be filled.

---

#### Implemented `ShiftController` class and its methods

Essential methods implemented:

* `addShift`: creates a new `Shift` object
* `assignEmployee`: control logic that assigns an `Employee` to a `Shift` 
* `unassignEmployee`: control logic that unassigns an `Employee` from a `Shift`

*Justification:* These methods are essential to satisfy the functional requirements of the application. 

*Highlights:* These features are challenging in the sense that they must be bug-free and are able to handle all sorts 
of inputs that the user may make. They are coded with numerous exception cases and error-handling, and many 
applications of proper control logic flow so that the order of inputs and outputs make sense to the user.

---

### Enhancements implemented


#### Implemented reusable methods in `ShiftController` class

Methods Implemented:
* `getShiftDate`: obtain user's date input and returns a `LocalDate` object
* `getShiftIndex`: obtain user's integer input and returns `shiftIndex`
* `getVacancy`: obtain user's integer input and returns `vacancy`
* `getShift`: find whether a `Shift` object from all the shifts have the same `shiftDate` and `shiftIndex`, then
  returns the `Shift` object, else return null
* `getEmployee`: find whether an `Employee` object from all the employees has the same `name`, then
  returns the `Employee` object, else return null
* `employeeAvailable`: find whether an `Employee`'s `Schedule` is free on the `shiftDate` and returns a boolean value
* `viewSelectedShift`: passes in a `Shift` object and prints the status of the `Shift`

*Justifications*: These methods are highly reusable as almost every essential feature that address the functional
requirement in this class will use at least one method that is implemented. They can even be used for future upgrades 
of the application to fulfil more functional requirements.

---

#### Implemented error-handling in methods

Coming up with the error-handling with exceptions has solved a lot of the bugs that were pointed out during the Practical Exam Dry Run. This also helped to test the
methods written and ensure that the logic flow is correct.

---

### Contributions to documentation

#### User Guide

For the user guide, I have filled in the methods for `add shift`, `assign employee`, `unassign employee`, `help` and
`quit` commands, as well as their step-by-step usage and explanation of certain terms. I have also answered 2 questions
that may be commonly asked by new users or may be confusing to users who may not be familiar with our application. 
Lastly, I tallied the command summary with our `AppController` and added the missing commands.

---

### Developer Guide


For the developer guide, my main contribution is the elaboration of **Design** and **Implementation**, as well as the 
sequence diagram of the **assignEmployee** section. I have also contributed by filling in the user stories section.

---

### Team-based tasks

* Fixed all the bugs related to `Shift` and `ShiftController` classes
* Supplying ideas for implementation and bugs
* Filling up the Q&A and Command Summary sections in UG
* Filling up the user stories section in DG

---
