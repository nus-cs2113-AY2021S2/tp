# User Guide

## Introduction

NUSFOODREVIEW is a console-based Java application that displays menus of food places 
in NUS. The application allow users to read/addreviews and ratings on the chosen store. User is also able to view some sample
menus of the stores. The application will record the timestamp whenever a new review is entered and print it out together
with the review when requested. Admin must verify themselves using password given by the application developer and change
it once they logged in as admin. Admin has the ability to add/delete canteen, add/delete store and delete review. NUSFOODREVIEW has a storage file
that allows the saving and loading of data. This allows all parameters of the data to be stored and read whenever is needed.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features

### Help function: `help`
Display commands that users can enter

Format: `help`

*There should be no arguments after `help`

Expected outcome:
```text
Enter 'menu' to view sample menu
Enter 'reviews' to show reviews of that particular store
Enter 'add' to add a new review
Enter 'home' to select a new canteen
Enter 'list' to select a new store
Enter 'exit' to exit the application
```

### Viewing the highlight menu of a store: `menu`
View the highlight menu items of current store that the user is viewing, along with their prices.

Format: `menu`

* There should be no arguments after `menu`

Example of usage:

`menu`

### Reading reviews of a store: `reviews`
Display reviews of the current store the user is viewing.

Format: `reviews`

* There should be no arguments after `reviews`

Example of usage:

`reviews`

### Adding reviews of a store: `add `
Adding reviews of the current store the user is viewing.

Format: `add`

* There should be no arguments after `add`

Example of usage:

`reviews`
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

### Exiting the application: `exit`
Exit from the application

Format: `exit`

* There should be no arguments after `exit`

Example of usage:

`exit`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
