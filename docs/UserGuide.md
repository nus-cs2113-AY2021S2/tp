# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Reading reviews of a store: `read`
Display reviews of the current store the user is viewing.

Format: `read`

* There should be no arguments after `read`

Example of usage:

`review`

### Viewing the highlight menu of a store: `menu`
View the highlight menu items of current store that the user is viewing, along with their prices.

Format: `menu`

* There should be no arguments after `menu`

Example of usage:

`menu`

### Select a new canteen to view: `home`
Allows the user to re-enter which canteen and store they wish to look at.
The application will prompt the user for the canteen and store by
1. Displaying a list of canteens
2. Wait for user canteen selection by index
3. Displaying a list of stores in the chosen canteen
4. Wait for user store selection by index

Format: `home`

* There should be no arguments after `home`

Example of usage:

`home`

### Select new store to view: `list`
Allows the user to re-enter which store they wish to look at in their current canteen.
The application will prompt the user for the store by
1. Displaying a list of stores in the current canteen
2. Wait for user store selection by index

Format: `list`

* There should be no arguments after `list`

Example of usage:

`list`


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
