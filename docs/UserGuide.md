# HealthVault User Guide

## Opening Words

## Content Page
* [Introduction](#1-introduction)
* [Installation Guide](#2-installation-guide)
* [How to use this guide](#3-how-to-use-the-guide)
  * [Technical terms](#31-technical-terms)
  * [Symbols & Icons](#32-symbols--icons)

## 1. Introduction

HealthVault is a desktop app for managing doctor, nurse and patient information, optimised for use through the command line interface. This app is for the head nurse of a hospital, if the user can type fast, it is better than a traditional GUI app.

## 2. Installation Guide

1. Ensure system has Java 11

2. Download the latest JAR file from this [website](https://github.com/AY2021S2-CS2113T-F08-2/tp/releases)

3. Open the command window 
   - Click the search icon in the bottom left side of the screen 
   - Type ‘command prompt’ in the search bar
   - Select the application called ‘Command Prompt’

4. Cd into the folder containing the JAR file
   - Locate the file path of the JAR file that you have downloaded
   - For example, (C:\Users\JohnDoe\Downloads, where JohnDoe is the user’s name)

   - Then, run the following command: `cd [File Path]`
   
   - Example: `cd C:\Users\JohnDoe\Downloads`
	
   - Run the following command: `java -jar jar [JAR file name]`

## 3. How to use the guide

### 3.1 Technical Terms

**Command Line Interface** - Accessing the functionalities of a computer program in the form of lines of text.

**Graphical User Interface** - Allows users to interact with the functionalities of a computer program through graphical icons and audio indicators, instead of text-based user interfaces, typed command labels or text navigation.

**Case Sensitive** - Differentiating between capital and lower-case letters.

**User Input** - Any information or data sent to a computer by the user using the application.

### 3.2 Symbols & Icons

**[]** - Square brackets for compulsory user inputs.

**<>** - Optional inputs.

:information_source:  All instances of commands and code will be highlighted in grey and will have a different font.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/drugsDuke).

## Features 

{Give detailed description of each feature}

### Nurse Schedule

The functions in the nurse schedule menu allows you, the head nurse, to add, view, and delete schedules of your nurses

#### Adding a new schedule: `add`
Adds a new schedule to the list of nurse schedules.

Format: `add [Nurse ID] [Patiend ID] [Date (DDMMYYYY)]`

Example of usage:

```
NSchedule --> add N1 P1 30012020
Trip to P1 on 30012020 added!
```

#### Delete a schedule: `delete`
Deletes a schedule from the list of nurse schedules.

Format: `delete [Nurse ID] [Date (DDMMYYYY)]`

Example of usage:

```
NSchedule --> delete N1 30012020
Trip to P1 on 30/01/2020 has been cancelled!
```

#### Listing schedules: `list`
List either all schedules or specified Nurse ID's schedule.

Format: `list [Nurse ID/all]`

Example of usage:

```
NSchedule --> list all
N1
	30/01/2020 P1
N2
	31/01/2020 P2
```

```
NSchedule --> list N2
N2
	31/01/2020 P2
```

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

| Command             | Example                                                                                                    |
|---------------------|------------------------------------------------------------------------------------------------------------|
| **Start Menu**      |                                                                                                            |
| staff               | `staff`                                                                                                    |
| patient             | `patient`                                                                                                  |
| appointments        | `appointments`                                                                                             |
| schedules           | `schedules`                                                                                                |
| inventory           | `inventory`                                                                                                |
| help                | `help`                                                                                                     |
| **Staff**           |                                                                                                            |
| add                 | `add/[Staff ID]/[Name]/[Age]/[Specialisation]`<br/><br/>`add/D12345/A12345/Alex/M 21012021`                |
| delete              | `delete/[Staff ID]`<br/><br/>`delete/D12345`                                                               |
| list                | `list`                                                                                                     |
| help                | `help`                                                                                                     |
| return              | `return`                                                                                                   |
| **Patient**         |                                                                                                            |
| add                 | `add/[Patient ID]/[Name] [Age]/[Gender]/[Illness]/[Drugs needed]`<br/><br/>`add/P55555/Sam/40/Male Fever/Paracetamol`   |
| delete              | `delete/[Patient ID]`<br/><br/>`delete/P55555`                                                                          |
| find                | `find/[Patient ID]`<br/><br/>`find/P55555`                                                                              |
| list                | `list`                                                                                                     |
| help                | `help`                                                                                                     |
| return              | `return`                                                                                                   |
| **Doctor Appointments** |                                                                                                        |
| add                 | `add/[Doctor ID]/[Appointment ID]/[Patient’s Name]/[Gender]/[DDMMYYYY]`<br/><br/>`add/D12345/Mingshun/ Pediatrician`    |
| delete              | `delete/[Appointment ID]`<br/><br/>`delete/A369`                                                                        |
| list                | `list`                                                                                                     |
| help                | `help`                                                                                                     |
| return              | `return`                                                                                                   |
| **Nurse Schedules** |                                                                                                            |
| add                 | `add/[Nurse ID]/[Patient ID]/[DDMMYYYY]`<br/><br/>`add/N12345/P56789/30012020`                             |
| delete              | `delete/[Nurse ID]/[DDMMYYYY]`<br/><br/>`delete/N12345/30012020`                                           |
| list                | `list/[Nurse ID/all]`<br/><br/>`list/N12345/list/all`                                                      |
| help                | `help`                                                                                                     |
| return              | `return`                                                                                                   |
| **Drugs Inventory** |                                                                                                            |
| add                 | `add/[Name]/[Price]/[Quantity]`<br/><br/>`add/paracetamol/$3/90`                                           |
| delete              | `delete/[Name]`<br/><br/>`delete/paracetamol`                                                              |
| list                | `list`                                                                                                     |
| help                | `help`                                                                                                     |
| return              | `return`                                                                                                   |
