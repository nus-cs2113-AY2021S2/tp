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

### Search: `search`
Checks if a certain food item is inside the fridge, and if the item is found, informs user of the food's storage location.

Format: `search FOOD_NAME`

* The `FOOD_NAME` can be the name of a food but not an empty description.
* The command requires the user to input the exact name of the food item `FOOD_NAME` to be searched for.
  The names of food items stored in the fridge can be determined with `list`. 
* If there are multiple items with the same name in the fridge, only the first item added to the fridge
  in order of the output of `list` will be returned.

Example of usage:

*In this example, Fridge contains only one item `grouper` stored in the `FREEZER` location.*

Input: `search grouper`

Output: `You have grouper stored in FREEZER of your fridge.`

Input: `search oyster`

Output: `You do not have oyster in your fridge.`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
