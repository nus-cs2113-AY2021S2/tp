# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}
**Notes about the command format:**

* Words in UPPER_CASE are the parameters to be supplied by the user.\
  e.g. `add FOOD_NAME`, `FOOD_NAME` is a parameter which can be used as `add chicken`.
  
### Adding a food item: `add`
Adds a food item to the fridge.

Format: `add FOOD_NAME /cat FOOD_CATEGORY /exp EXPIRY_DATE /loc LOCATION_IN_THE_FRIDGE

* The `FOOD_NAME` can be the name of a food but not an empty description. 
* The `FOOD_CATEGORY` can be the basic food groups otherwise it will be categorised as others.
* The `EXPIRY_DATE` must be in the format `dd-mm-yyyy`.
* The `LOCATION_IN_THE_FRIDGE` can be a general compartment in a fridge.
  
Additional info:
**Basic Food Groups**:
* MEAT 
* SEAFOOD 
* EGG 
* DAIRY 
* VEGETABLE 
* FRUIT
* BEVERAGE 
* COOKED_DISH 
* READY_TO_EAT 
* FROZEN
* OTHERS

**Basic fridge location**
* FREEZER 
* UPPER_SHELF
* MIDDLE_SHELF
* LOWER_SHELF
* DRAWERS
* FRIDGE_DOOR
* OTHERS

Example of usage: 

`add chicken /cat meat /exp 30-06-2021 /loc lower_shelf`

`add grouper /cat seafood /exp 04-05-2021 /loc freezer`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
