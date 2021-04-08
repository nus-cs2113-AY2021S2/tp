# User Guide

## Introduction

`FridgeFriend` is an app for managing food in the fridge that is optimised for use via a Command Line Interface (CLI) and is targeted at new homeowners who cook.
If you can type fast, `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
It is written in Java, and has more than 5500 lines of code.

## Contents

* [Quick Start](#quick-start)
* [Features](#features)
  * [Help](#get-help-message-help)
  * [Add](#adding-a-food-item-add)
  * [List](#display-the-list-of-all-foods-list)
  * [List by Category](#display-the-list-of-foods-by-category-list-category)
  * [List by Location](#display-the-list-of-foods-by-storage-location-list-location)
  * [Remove](#remove-a-food-item-by-quantity-remove)
  * [Search](#search-search)
  * [Expiring](#list-expiring-foods-expiring)
  * [Runninglow](#list-categories-with-food-running-low-runninglow)
  * [Setlimit](#modify-the-minimum-quantity-limits-setlimit)
  * [History](#list-history-of-items-added-history)
  * [Clear history](#clear-list-history-of-items-added-history-clear)
  * [Clear](#empty-fridge-clear)
  * [Bye](#exit-the-application-bye)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `FridgeFriend` from [here](https://github.com/AY2021S2-CS2113-T10-1/tp/releases/latest).
3. Copy the file to the folder you want to use as the home folder for your `FridgeFriend`.  
4. Open your Command Line Terminal in the folder where the `jar` file is located, and run `FridgeFriend` with `java -jar FridgeFriend_vx.x.jar` where `vx.x` is the `FridgeFriend` version that you have downloaded.
5. Type the command in the command box and press Enter to execute it. For example, typing `list` and pressing Enter will show a list of all current food. Some example commands you can try:
   * `help`: Displays a help message
   * `list`: Lists all food.
   * `bye`: Exits the app.
6. Refer to the **Features** below for details of each command.

:warning: Do ***NOT*** modify any of text files in the `/data` folder in order to prevent errors and loss of data.

## Features

:information_source: Words in UPPER_CASE are the parameters to be supplied by the user. For example, `add FOOD_NAME` should be executed as `add chicken` where `FOOD_NAME` is a parameter.

:information_source: Extraneous parameters for commands that do not take in parameters will be ignored. For example, `help me` will execute as `help`.

### Get help message: `help`

Prints a list of available commands and formats.

Format: `help`

Example of usage:

```lang-none
>> help
These are the list of available commands:
        help
        add foodName /cat categoryName /exp dd-mm-yyyy /loc storageLocation /qty foodQuantity
        list
        list categoryName
        remove foodName /qty removeQuantity
        search searchString
        expiring
        runninglow
        setlimit foodCategory /qty newLimit
        history
        history clear
        clear
        bye

This is the list of food categories:
        [VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER]

This is the list of storage locations:
        [FREEZER, UPPER_SHELF, MIDDLE_SHELF, LOWER_SHELF, DRAWERS, FRIDGE_DOOR, OTHER]
```
  
### Adding a food item: `add`

Adds a food item into the fridge.

If a particular FOOD_NAME is in the fridge, the other fields have to be same in order to
add the quantity. Otherwise, a unique FOOD_NAME has to be used to add the food into the FridgeFriend.

Format: `add FOOD_NAME /cat FOOD_CATEGORY /exp EXPIRY_DATE /loc LOCATION_IN_THE_FRIDGE /qty FOOD_QUANTITY`

* The `FOOD_NAME` can be the name of a food but not an empty description.
* The `FOOD_CATEGORY` can be the basic food groups otherwise it will be categorised as others.
* The `EXPIRY_DATE` must be in the format `dd-mm-yyyy`.
* The `LOCATION_IN_THE_FRIDGE` can be a general compartment in a fridge.
* The `FOOD_QUANTITY` must be a positive integer.

:bulb: **Tip:**

* If you want to add more to the same batch of food (same category, same location and same
expiry date), you should specify exactly the same `FOOD_NAME`,`FOOD_CATEGORY`,`EXPIRY_DATE`,
`LOCATION_IN_THE_FRIDGE` and the new quantity in `QUANTITY` field.
* The food names should not repeat unless it is the same batch as described above.
Otherwise, you will be prompted to retry the `add` command.

:information_source: Additional info:

* Basic Food Groups: `MEAT`, `SEAFOOD`, `EGG`, `DAIRY`, `VEGETABLE`, `FRUIT`,
  `BEVERAGE`, `COOKED_DISH`, `READY_TO_EAT`, `FROZEN`, `OTHERS`
* Basic Fridge Location: `FREEZER`, `UPPER_SHELF`, `MIDDLE_SHELF`, `LOWER_SHELF`,
  `DRAWERS`, `FRIDGE_DOOR`, `OTHERS`

Example of usage:

```lang-none
>> add chicken /cat meat /exp 30-06-2021 /loc lower_shelf /qty 800
Great! I have added chicken into your fridge.
Details: Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 800

>> add chicken /cat meat /exp 07-10-2021 /loc freezer /qty 200
Sorry my friend, you have added this food before but in a different location or have different expiry dates. Please specify another foodname.

>> add chicken /cat meat /exp 30-06-2021 /loc lower_shelf /qty 200
Great! I have added chicken into your fridge.
Details: Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 1000

>> add pork /cat meat /exp 04-07-2021 /loc freezer /qty 500
Great! I have added pork into your fridge.
Details: Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500

>> add chicken wings /cat ready_to_eat /exp 17-04-2021 /loc upper_shelf /qty 500
Great! I have added chicken wings into your fridge.
Details: Food name: chicken wings, category: READY_TO_EAT, expiry: 17-04-2021, stored in: UPPER_SHELF, quantity: 500
```

### Display the list of all foods: `list`

Displays the full list of food items stored in the fridge.

Format: `list`

* There should not be any descriptions after keyword `list`.  

Example of usage:

```lang-none
>> list
Here are the items in your fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 1000
        2. Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500
        3. Food name: chicken wings, category: READY_TO_EAT, expiry: 17-04-2021, stored in: UPPER_SHELF, quantity: 500
```

### Display the list of foods by category: `list <CATEGORY>`

Displays the list of food items under specified category stored in the fridge.

Format: `list CATEGORY_NAME`

* The `CATEGORY_NAME` can only be recognised if it is in the pre-defined categories:
`VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER`
* The `CATEGORY_NAME` is case-insensitive.
* If invalid input detected, `FridgeFriend` would give an error message.

Example of usage:

```lang-none
>> list meat
These are the MEAT in your fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 1000
        2. Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500

>> list dairy
These are the DAIRY in your fridge:
```

### Display the list of foods by storage location: `list <LOCATION>`

Displays the list of food items under specified category stored in the fridge.

Format: `list STORAGE_LOCATION_NAME`

* The `STORAGE_LOCATION_NAME` can only be recognised if it is in the pre-defined categories:
  `FREEZER, UPPER_SHELF, MIDDLE_SHELF, LOWER_SHELF, DRAWERS, FRIDGE_DOOR, OTHER`
* The `STORAGE_LOCATION_NAME` is case-insensitive.
* If invalid input detected, `FridgeFriend` would give an error message.

Example of usage:

```lang-none
>> list freezer
These are the food stored in FREEZER:
        1. Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500

>> list drawers
These are the food stored in DRAWERS:
```

### Remove a food item by quantity: `remove`

Removes a food item based on its index. Additionally, if a removal results in a food category falling below the specified limit (as per in [`setlimit`](modify-the-minimum-quantity-limits-setlimit)), this command will also give a warning that the category is [`runninglow`](list-categories-with-food-running-low-runninglow) on food.

Format: `remove FOODNAME /qty QUANITTY_TO_REMOVE`

* The `FOODNAME` must be an existing food name (same with the first parameter during `add`) in the fridge.
* If the `FOODNAME` is not found, `FridgeFriend` will give an error message.
* The `QUANTITY_TO_REMOVE` must be lower than or equal to the current quantity of the food.
* If the `QUANTITY_TO_REMOVE` is larger than current quantity of the food, `FridgeFriend` will give an error message.
* If the `QUANTITY_TO_REMOVE` is equal to current quantity of the food, it means food is depleted and thus the whole
food item will be deleted by `FridgeFriend` (it will not appear on list either).
* If the `QUANTITY_TO_REMOVE` is lower than current quantity of the food, it means there is still some food left
of this item. The quantity of food will be updated.

Example of usage:

```lang-none
>> list
Here are the items in your fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 1000
        2. Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500
        3. Food name: chicken wings, category: READY_TO_EAT, expiry: 17-04-2021, stored in: UPPER_SHELF, quantity: 500

>> remove chicken /qty 200
Noted! I've removed 200 of the food chicken from your fridge.
New quantity: 800

>> remove pork /qty 700
Not enough in fridge to remove!

>> remove pork /qty 500
Noted! I've removed pork from your fridge.
Now you have 2 food in the fridge.

>> remove chicken /qty 500
Noted! I've removed 500 of the food chicken from your fridge.
New quantity: 300
WARNING! You are running low on MEAT
Total MEAT quantity: 300
```

### Search: `search`

Checks if a certain food item is inside the fridge, and if the item is found, informs user of the food that matches the search query.

Format: `search FOOD_NAME`

* The `FOOD_NAME` can be the name of a food but not an empty description.
* The command requires the user to input the name of the food item `FOOD_NAME` to be searched for.
  The names of food items stored in the fridge can be determined with `list`.
* If there are multiple items that contain the food name, the search function will display all of those food items.

Example of usage:

```lang-none
>> search chicken
These are the chicken in your fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 800
        2. Food name: chicken wings, category: READY_TO_EAT, expiry: 17-04-2021, stored in: UPPER_SHELF, quantity: 500

>> search oyster
You do not have oyster in your fridge.
```

### List expiring foods: `expiring`

Displays a list of food items that are expiring within a week.

Format: `expiring`

Example of usage:

```lang-none
>> expiring
These are the food expiring in the next week:
1. Food name: chicken wings, category: READY_TO_EAT, expiry: 17-04-2021, stored in: UPPER_SHELF, quantity: 500
```

### List categories with food running low: `runninglow`

Displays a list of food categories which total quantity is below a specified minimum limit. This command also displays the existing quantities along with its limits for each category. Note that these limits can be modified with the [`setlimit`](#modify-the-minimum-quantity-limits-setlimit) command.

Format: `runninglow`

Example of usage:

```lang-none
>> runninglow
You are running low on food in these categories:
1. VEGETABLE quantity: 0 out of 500
2. FRUIT quantity: 0 out of 500
3. SEAFOOD quantity: 0 out of 500
4. EGG quantity: 0 out of 500
5. DAIRY quantity: 0 out of 500
6. BEVERAGE quantity: 0 out of 500
7. COOKED_DISH quantity: 0 out of 500
8. FROZEN quantity: 0 out of 500
9. OTHER quantity: 0 out of 500
```

### Modify the minimum quantity limits: `setlimit`

Changes the minimum quantity limit for a specific food category. To set remove a limit for a category, set its limit to -1.

Format: `setlimit FOOD_CATEGORY /qty QUANTITY`

Example of usage:

```lang-none
>> runninglow
You are running low on food in these categories:
1. VEGETABLE quantity: 0 out of 500
2. FRUIT quantity: 0 out of 500
3. SEAFOOD quantity: 0 out of 500
4. EGG quantity: 0 out of 500
5. DAIRY quantity: 0 out of 500
6. BEVERAGE quantity: 0 out of 500
7. COOKED_DISH quantity: 0 out of 500
8. FROZEN quantity: 0 out of 500
9. OTHER quantity: 0 out of 500

>> setlimit ready_to_eat /qty 600 
Okie dokie! The new minimum quantity for category 'READY_TO_EAT' is 600

>> setlimit vegetable /qty -1
Okie dokie! The new minimum quantity for category 'VEGETABLE' is -1

>> runninglow
You are running low on food in these categories:
1. FRUIT quantity: 0 out of 500
2. SEAFOOD quantity: 0 out of 500
3. EGG quantity: 0 out of 500
4. DAIRY quantity: 0 out of 500
5. BEVERAGE quantity: 0 out of 500
6. COOKED_DISH quantity: 0 out of 500
7. READY_TO_EAT quantity: 500 out of 600
8. FROZEN quantity: 0 out of 500
9. OTHER quantity: 0 out of 500
```

### List history of items added: `history`

Displays a history of food items that have been added to the Fridge
since it was last cleared.

* The Fridge keeps track of all Food items added in its lifetime automatically.
* Unlike adding Food to a Fridge, which merges the quantity of duplicate Foods together,
  the history command will not merge the quantities of food.
  * Thus, the user can use this command to keep track of all occurrences where Food
  has been added to the Fridge.

:information_source: The data is saved to disk in a text file, with default location as `data/historyData.txt`.

:warning: Do NOT modify the data file as this might lead to corruption.

* In the event that the data in the text file is corrupted or in an unreadable format, the   `history` command may fail to output the contents of the file. Users may have to manually inspect the file to delete the invalid content, or wipe the contents of the file with the [`history clear`](#clear-list-history-of-items-added-history-clear) command, to resume normal function.
  * The execution of the FridgeFriend program, however, will not be interrupted.

Format: `history`

Example of usage:

```lang-none
>> history
This is the full history of items you've added in the fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 800
        2. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 1000
        3. Food name: pork, category: MEAT, expiry: 04-07-2021, stored in: FREEZER, quantity: 500
        4. Food name: chicken wings, category: READY_TO_EAT, expiry: 09-04-2021, stored in: UPPER_SHELF, quantity: 500
```

### Clear list history of items added: `history clear`

Wipes the data from the history text file.

:warning: This command will permanently erase the entire history log and this action ***cannot*** be reversed.

Format: `history clear`

Example of usage:

```lang-none
>> history clear
History successfully cleared!

>> history 
This is the full history of items you've added in the fridge:
```

### Empty fridge: `clear`

Removes all food items in the fridge.

:warning: This command will permanently empty the fridge and this action ***cannot*** be reversed.

Format `clear`

Example of usage:

```lang-none
>> list
Here are the items in your fridge:
        1. Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF, quantity: 300
        2. Food name: chicken wings, category: READY_TO_EAT, expiry: 09-04-2021, stored in: UPPER_SHELF, quantity: 500

>> clear
Fridge has been cleared!

>> list
Here are the items in your fridge:
```

### Exit the application: `bye`

Exits the application.

Format: `bye`

Example of usage:

```lang-none
>> bye
Bye! Hope to see you again soon!
```

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with `data` folder to the target computer and place them together into an empty folder. As long as the target computer satisfies the application prerequisites, it can execute with the saved data as before.

**Q**: What if I forget the correct format of a command?

**A**: You will get a tip if you use any of the command keywords incorrectly.
Plus, you are always welcome to use `help` command.

**Q**: How do I report a bug?

**A**: You can create a new issue [here](https://github.com/AY2021S2-CS2113-T10-1/tp/issues).

## Command Summary

* Get help message `help`
* Add food `add FOOD_NAME /cat FOOD_CATEGORY /exp EXPIRY_DATE /loc LOCATION_IN_THE_FRIDGE /qty FOOD_QUANTITY`
* List food `list`
* List food by category `list CATEGORY_NAME`
* List food by storage location `list STORAGE_LOCATION_NAME`  
* Remove food `remove FOODNAME /qty QUANITTY_TO_REMOVE`
* Search for food `search FOOD_NAME`
* List expiring foods `expiring`
* List categories with food running low: `runninglow`
* Modify the minimum quantity limits: `setlimit FOOD_CATEGORY /qty QUANTITY`
* List history of items added: `history`  
* Clear list history of items added: `history clear`
* Empty fridge: `clear`
* Exit application `bye`
