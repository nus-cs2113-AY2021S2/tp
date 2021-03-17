# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `FridgeFriend` from [here](update_link_here_after_release).

## Features

### Display the list of all foods: `list`
Displays the full list of food items stored in the fridge.

Format: `list`

* There should not be any descriptions after keyword `list`.  

Example of usage: 

Input: `list`

Output: 
```
Here are the items in your fridge:
  	1. chicken [MEAT]
   	2. grouper [SEAFOOD]
```

### Display the list of foods by category: `list <CATEGORY>`
Displays the list of food items under specified category stored in the fridge.

Format: `list CATEGORY_NAME`

* The `CATEGORY_NAME` can only be recognized if it is in the pre-defined categories:
`VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER`
* The `CATEGORY_NAME` is case-insensitive
* If other category names are detected, it would give an error message

Example of usage: 

*Situation 1: There is one food called chicken under MEAT category.*

Input: `list MEAT`

Output: 
```
These are the MEAT in your fridge:
	1. chicken
```
*Situation 2: There are no foods under READY_TO_EAT category.*

Input: `list ready_to_eat`

Output: 
```
These are the READY_TO_EAT in your fridge:
```

### List expiring foods: `expiring`

Displays a list of food items that are expiring within a week.

Format: `expiring`

```
>> expiring
These are the food expiring in the next week:
1. Food name: chicken wings, category: MEAT, expiry: 21-03-2021, stored in: MIDDLE_SHELF

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with `save` folder to the target computer.
As long as the target computer satisfies our project prerequisites, it can run with the saved data as before.

**Q**: What if I forget the correct format of a command?

**A**: You will get a tip if you use any of the command keywords incorrectly. 
Plus, you are always welcomed to use `help` command.

**Q**: How do I report a bug?

**A**: You can either create a pull request or state in the issues.

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
