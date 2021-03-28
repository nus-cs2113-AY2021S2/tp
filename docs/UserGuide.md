# User Guide

## Introduction

HealthVault is a desktop app for managing doctor, nurse and patient information, optimised for use through the command line interface. This app is for the head nurse of a hospital, if the user can type fast, it is better than a traditional GUI app.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/drugsDuke).

## Features 

{Give detailed description of each feature}

### Nurse Schedule

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

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
