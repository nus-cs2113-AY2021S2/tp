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

Step 1: add employee<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. Tom)<br>
System feedback: Employee added

### Add new employee’s schedules: `add schedule`

Adds the employees schedule to the restaurant’s database
(A valid schedule has the following restrictions: Year is between 2021 and 2099. Month is between 1 and 12. Day is
between 1 and 31)

Step 1: add schedule<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. Tom)<br>
System feedback: enter Employee schedule<br>
Step 3: dd/mm/yyyy (eg. 28/08/2021)<br>
System feedback: schedule added

### Drop existing employee’s schedules: `drop schedule`

Drops existing employee’s schedule from the restaurant’s database

Step 1: drop schedule<br>
System feedback: enter Employee name<br>
Step 2: employee_name (eg. Tom)<br>
System feedback: enter Employee schedule<br>
Step 3: dd/mm/yyyy (eg. 28/08/2021)<br>
System feedback: schedule dropped

### Add a shift: `add shift`

Adds a shift to the restaurant’s database

Step 1: add shift<br>

### Assign employees to shift: `assign employee`

Assigns an employee who is available for the duration of the shift to a stipulated shift. Each shift represents a 4-hour
block and there are 6 shift indexes from 1 to 6, where shift index 1 represents 0000h to 0400h, shift index 2 represents
0400h to 0800h, etc.

Format: `assign employee`

* SHIFT_DATE must be in DDMMYYYY format
* SHIFT_INDEX must be an integer from 1 to 6

### Unassign employees from an assigned shift: `unassign employee`

Unassign a specific employee from a shift he was assigned to

Format: `unassign employee`

* SHIFT_DATE must be in DDMMYYYY format
* SHIFT_INDEX must be an integer from 1 to 6

### View employee’s schedule: `view employee schedule`

Views a specific employee’s schedules

Format: `view employee schedule`

### View employees assigned for a particular shift: `view one shift`

View all the employee names who are assigned for a particular shift

Format: `view one shift`

* SHIFT_DATE must be in DDMMYYYY format
* SHIFT_INDEX must be an integer from 1 to 6

### View restaurant’s shift schedule: `view shift status`

View the restaurant’s shift schedule for the current week

Format: `view shift status`

### View list of all employees: `list`

View the list of all employees in the restaurant

Format: `list`

## FAQ

**Q**: How do I make french fries?

**A**: Install french fries.jar into your C drive.

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
