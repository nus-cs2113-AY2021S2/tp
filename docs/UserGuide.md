# User Guide

## Introduction

FastScheduler (FS) is a desktop app for restaurant managers to schedule employees for work, optimised for use via a
Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast
and prefer typing, FS can help you manage the schedules of employees and shifts faster than traditional GUI apps.

## Quick Start

1. Ensure you have Java 11 or above installed on your computer.
2. Download the latest FastScheduler.jar [here](https://github.com/AY2021S2-CS2113-F10-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for your FastScheduler APP.
4. Double-click the file to start the APP.

## Features

### Add an employee: `add employee`

Adds an employee to the restaurant’s database<br>

Step 1: `add employee`<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. `Tom`)<br>
System feedback: Employee added

### Add new employee’s schedules: `add schedule`

Adds the employees schedule to the restaurant’s database
(A valid schedule has the following restrictions: Year is between 2021 and 2099. Month is between 1 and 12. Day is
between 1 and 31)

Step 1: `add schedule`<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. `Tom`)<br>
System feedback: enter Employee schedule<br>
Step 3: dd/mm/yyyy (eg. `28/08/2021`)<br>
System feedback: schedule added

### Drop existing employee’s schedules: `drop schedule`

Drops existing employee’s schedule from the restaurant’s database

Step 1: `drop schedule`<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. `Tom`)<br>
System feedback: enter Employee schedule<br>
Step 3: dd/mm/yyyy (eg. `28/08/2021`)<br>
System feedback: schedule dropped

### Add a shift: `add shift`

Adds a shift to the restaurant’s database.

Each shift consists of the employees on a shift, shift date, shift index and vacancy (number of slots remaining).

A valid shift date has the following restrictions: Year is between 2021 and 2099. Month is between 1 and 12. Day is
between 1 and 31.

Each shift represents a 4-hour block and there are 6 shift indexes from 1 to 6, meaning there are 6 shifts in a day,
where shift index 1 represents 0000h to 0400h, shift index 2 represents 0400h to 0800h, etc.

Step 1: `add shift`<br>
System feedback: Enter Shift date (in dd/MM/yyyy):<br>
Step 2: dd/MM/yyyy (e.g. `28/08/2021`)<br>
System feedback: Enter Shift index:<br>
Step 3: shift_index (e.g. `3`)<br>
System feedback: Enter Vacancy:<br>
Step 4: vacancy (e.g. `1`)<br>
System feedback: Enter an employee name to assign to this shift:<br>
Step 5: employee_name (e.g. `Tom`)<br>
System feedback: Employee Tom is available to work!<br>
System feedback: Employee Tom is successfully assigned to this shift.<br>
System feedback: Shift created.<br>

### Assign employees to shift: `assign employee`

Assigns an employee who is available according to schedule to a stipulated shift.

Step 1: `assign employee`<br>
System feedback: Enter Shift date (in dd/MM/yyyy):<br>
Step 2: dd/MM/yyyy (e.g. `28/08/2021`)<br>
System feedback: Enter Shift index:<br>
Step 3: shift_index (e.g. `3`)<br>
System feedback: Enter an employee name to assign:<br>
Step 4: employee_name (e.g. `Tom`)<br>
System feedback: Employee Tom is available to work!<br>
System feedback: Employee Tom is successfully assigned to this shift.<br>

### Unassign employees from an assigned shift: `unassign employee`

Unassign a specific employee from a shift he was assigned to

Step 1: `unassign employee`<br>
System feedback: Enter Shift date (in dd/MM/yyyy):<br>
Step 2: dd/MM/yyyy (e.g. `28/08/2021`)<br>
System feedback: Enter Shift index:<br>
Step 3: shift_index (e.g. `3`)<br>
System feedback: Enter an employee name to unassign:<br>
Step 4: employee_name (e.g. `Tom`)<br>
System feedback: Employee Tom is successfully unassigned from this shift.<br>

### View employee’s schedule: `view employee schedule`

Views a specific employee’s schedules

Step 1: `view employee schedule`<br>
System feedback: enter Employee name<br>
Step 2: employee_name (e.g. `Tom`)<br>
System feedback: employee_schedule(e.g. `21/05/2021`)

### View employees assigned for a particular shift: `view one shift`

View all the employee names who are assigned for a particular shift

Step 1: `view one shift`<br>
System feedback: Enter Shift date (in dd/MM/yyyy):<br>
Step 2: shift_index (e.g. `1`)<br>
System feedback: The people assigned ot the shift are: (employee_names e.g. Tom, Jerry)

* SHIFT_DATE must be in DDMMYYYY format
* SHIFT_INDEX must be an integer from 1 to 6

### View restaurant’s shift schedule: `view shift status`

View the restaurant’s shift schedule for the current week

Step 1: `view shift status`<br>
System feedback:<br>
On 21/05/2021 shift index 1, the employees on shift are: (employee_names e.g. Tom, Jerry)<br>
Vacancy left: (vacancy e.g. 3)

### View list of all employees: `list`

View the list of all employees in the restaurant

System feedback:
<br>Here is the employee list:
<br>1) (employee 1 name)
<br>2) (employee 2 name)

### View list of commands: `help`

View the list of commands for the application

Format: `help`

### Close application and save state: `quit`

Closes the application and saves the state of employees and shifts into 2 separate text files

Format: `quit`

## FAQ

**Q**: What is the difference between schedule and shift?

**A**: Schedule belongs to the employee, i.e. employee's availability. Shift refers to the restaurant's work shifts.

**Q**: What is shift index?

**A**: Shift index refers to a 4-hour block on a particular shift date. Shift index can be integer values 1 to 6, where
1 refers to 4-hour block from 0000 to 0400, 2 refers to 4-hour block from 0400 to 0800 and etc.

## Command Summary

* Add employee `add employee`
* Add schedule `add schedule`
* Drop schedule `drop schedule`
* Add shift `add shift`
* Assign employee to a shift `assign employee`
* Unassign employee from a shift `unassign employee`
* View employee schedule `view employee schedule`
* View employees in the shift `view one shift`
* View the shift schedule `view shift status`
* Lists all employees `list`
* Help `help`
* Quit `quit`
