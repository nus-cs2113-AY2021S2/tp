# Healthier | User Guide

## Introduction

Healtheir targets people who care about fitness, who exercise regularly (at least 3 times/week) and have diet plans. It is designed for users of age group 18-30.  
This app is used via **Command Line Interface (CLI)**. If the user is proficient in using command-line tools & typing, then it could be very efficient to use. This app also provides several shortcut commands for advanced users for further efficient operations.

---
## Table of Content
* [Quick start](README.md#quick-start)
* [Features](README.md#features)
* [Command summary](README.md#command-summary)


## Quick Start
This is a cross-platform application, you can run it on any operating system as long as **Java 11** is installed. 
> To verify if you have **Java 11** installed, simply type command `java --version` in your terminal.
1. Download the `tp.jar` file from the [latest release](https://github.com/AY2021S2-CS2113-F10-2/tp/releases).
1. Open a new terminal at the folder where the `Tp.jar` file is located.
1. Run the applictaion use command `java -jar Tp.jar`
1. Refer to the [Features](README.md#features) section below for more info on commands.

## Features 

> **Note:**
> * All commands should be input in `lower_case`. It is always the first word supplied by the user.
> 
>   e.g. `add`, `view`, `delete` etc.
> 
> 
> * Parameters of a command are denoted in `UPPER_CASE`. They must be supplied by the user, otherwise the command will not be recognized.
>   The actual input of the parameters can be in any case. 
>   
>   e.g. in `add XXX`, `XXX` is a parameter which can be used as ``.
> 
> 
> * Redundant parameters for single-word commands (e.g. `help`) will be ignored. 
> 
>    e.g. if the command `help hahahaha` is input, it is equivalent to `help`.
> 
> * After the appliction starts running, it checks if a `data` folder exists in the same directory where `tp.jar` is located.
>   If the folder does not exist, the application will create a new folder `data`, 
>   which is used to store the `data.txt` file which contains details of the user's data.
>
> * The text file `data.txt` will be automatically updated after each operation of the app. 
>

### Get help from instructions on how to use this app : `help`
Adds a to-do type of task to the task list.

Format: `help`

Example: `help`

Expected outcome:
```
```

### Input Exercise Data: `add`
Add one exercise activity with the duration and the date.

Format: `add  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]`

* Add one exercise record. The name of exercise activity `a/ACTIVITY_NAME` and duration `d/DURATION` **MUST** be specified. 
* The name of the exercise should be a `String`.
* The tag value should be `E` in the upper case, which specifies that the current record is for **exercise data**.
* The default unit of duration is in **minutes**. An `integer` is expected for the duration, other formats are **not acceptable**.
* The date of the exercise activity `[date/DD-MM-YYYY]` is optional. If not provided, the system date will be used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.


Example of usage:  
`add t/E a/running d/40 add one exercise record of running for 40 minutes. `  

Output:  
```
A new exercise activity record is added successfully!
Record summary: 40 minutes running exercise on XX-XX-XXXX(Today).
```
  
`add t/E a/football d/60 date/05-01-2020 add the exercise record of football for 60 mins at the date of 05-01-2020.`  

Output:  
```
A new exercise activity record is added successfully!
Record summary: 60 minutes football exercise on 05-01-2020.
```

## FAQ

**Q**: {?}

**A**: {your answer here}

## Command summary

Action | Format, Examples
--- | ---
Help | `help`

