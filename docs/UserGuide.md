# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Display the list of all foods: `list`
Displays the full list of food items stored in the fridge.

Format: `list`

* There should not be any descriptions after keyword `list`.  

Example of usage: 

`list`

### Display the list of foods by category: `list <CATEGORY>`
Displays the list of food items under specified category stored in the fridge.

Format: `todo CATEGORY_NAME`

* The `CATEGORY_NAME` can only be recognized if it is in the pre-defined categories:
`VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER`
* The `CATEGORY_NAME` is case-insensitive
* If other category names are detected, it would automatically be recorded as `OTHER`

Example of usage: 

`list MEAT`

`list ready_to_eat`

`list idontknow`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Copy the `.jar` file along with `data` folder to the target computer.
As long as the target computer satisfies our project prerequisites, it can run with the saved data as before.

**Q**: What if I forget the correct format of a command?

**A**: You will get a tip if you use any of the command keywords incorrectly. 
Plus, you are always welcomed to use `help` command.

**Q**: How do I report a bug?

**A**: You can either create a pull request or state in the issues.

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
