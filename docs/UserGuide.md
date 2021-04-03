# User Guide

## Introduction

NUSFOODREVIEW is a console-based Java application that displays menus of food places 
in NUS. The application allow users to read/addreviews and ratings on the chosen store. User is also able to view some sample
menus of the stores. The application will record the timestamp whenever a new review is entered and print it out together
with the review when requested. Admin must verify themselves using password given by the application developer and change
it once they logged in as admin. Admin has the ability to add/delete canteen, add/delete store and delete review. NUSFOODREVIEW has a storage file
that allows the saving and loading of data. This allows all parameters of the data to be stored and read whenever is needed.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `nusfoodreviews.jar` from [here](https://github.com/AY2021S2-CS2113-T10-4/tp/releases).
3. Download the data folder from [here](https://github.com/AY2021S2-CS2113-T10-4/tp).
4. Copy the `nusfoodreviews.jar` file and data folder to the same folder
5. For Windows users, open up **Command Prompt**.
   
   For Mac users, open up **Terminal**.
   
   Navigate to the directory containing the `nusfoodreviews.jar` file.

## Brief Explanation
Our application is quite easy to use, mostly navigating to canteens, stores
and menus through numbers with some commands needed when accessing certain 
features as shown below.

## ! Very important
Password for Admin is `Password`. With that, have fun!

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

## Admin Functions: `admin`

Password for admin is "Password".

Admin has the following functions:
1. View canteens
2. Add canteen
3. Add store in canteen
4. Add Menu
5. Delete canteen
6. Delete store in canteen
7. Delete reviews
8. Delete menu
9. Exit

### View canteens: `view canteens`
This function displays all the canteens in the system.

### Add canteens: `add canteen`
This function allows admin to add a new canteen to the application.

### Add store in canteen: `add store`
This function allows admin to add a new store to the chosen canteen.

### Add menu in store: `add menu`
This function allows admin to add a new menu to the chosen store.

### Delete Canteen: `delete canteen`
This function allows admin to delete a chosen canteen.

### Delete store in canteen: `delete store`
This function allows admin to delete a store in the chosen canteen.

### Delete review: `delete review`
This function allows admin to delete a review in a chosen store.

### Delete menu: `delete menu`
This function allows admin to delete a menu in a chosen store.

## FAQ

**Q**: There are red words that appear right after I opened the application,
why is that so?

**A**: Those are just for logging purposes, no worries!

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add review `add`
* Read reviews `reviews`
* View list of stores in canteen `list`
* Goes back to main selection `home`
* Exit from application `exit`
* View menu of store `menu`
