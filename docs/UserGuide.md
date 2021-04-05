# Healthier | User Guide

## Introduction

Healthier targets people who care about fitness, who exercise regularly (at least 3 times/week) and have diet plans. It
is designed for users of age group 18-30.  
This app is used via **Command Line Interface (CLI)**. If the user is proficient in using command-line tools & typing,
then it could be very efficient to use. This app also provides several shortcut commands for advanced users for further
efficient operations.

---

## Table of Content

* [Quick start](#quick-start)
* [Features](#features)
* [Command summary](#command-summary)

## Quick Start

This is a cross-platform application, you can run it on any operating system as long as **Java 11** is installed.
> To verify if you have **Java 11** installed, simply type command `java --version` in your terminal.

1. Download the `tp.jar` file from the [latest release](https://github.com/AY2021S2-CS2113-F10-2/tp/releases).
1. Open a new terminal at the folder where the `tp.jar` file is located.
1. Run the application use command `java -jar tp.jar`
1. Refer to the [Features](#features) section below for more info on commands.

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
    >   e.g. in `add XXX`, `XXX` is a parameter which can be used as `xxx`.
>
>
> * Redundant parameters for single-word commands (e.g. `help`) will be ignored.
    >
    >    e.g. if the command `help hahahaha` is input, it is equivalent to `help`.
>
> * After the application starts running, it checks if a `data` folder exists in the same directory where `tp.jar` is located.
    >   If the folder does not exist, the application will create a new folder `data`,
    >   which is used to store the app system files which contains details of the user's data.
>
> * The text files will be automatically updated after each operation of the app.
>

### Get help from instructions on how to use this app : `help`

Displays syntax for all commands.

Format: `help`

Example of Usage:

Input:
`help`

Expected Output:

```
--------------------------------------------------------------------
Thank you for choosing to be healthier with us.
The current version of this application is: V2.0
You can use the app by using command ADD, VIEW, and DELETE.

The syntax for add command is:
1. Add exercise record
	add t/E a/ACTIVITY_NAME d/DURATION [date/DD-MM-YYYY]
   The duration is with unit of minute.
2. Add diet record
	add t/D f/FOOD_TYPE w/WEIGHT [date/DD-MM-YYYY]
   The amount is with unit of gram.
3. Add sleep record
	add t/S d/DURATION [date/DD-MM-YYYY]
   The duration is with unit of hour.
4. Add body weight record
	add t/W w/WEIGHT [date/DD-MM-YYYY]
   The weight is with unit of kilogram.
Please note the type must be in uppercase.

The syntax for view command is:
1. View exercise records
	view t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]
2. View diet records
	view t/D [f/FOOD_NAME] [date/DD-MM-YYYY]
3. View sleep records
	view t/S [date/DD-MM-YYYY]
4. View body weight records
	view t/W [date/DD-MM-YYYY]

The syntax for delete command is:
1. Delete exercise records
	delete t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]
2. Delete diet records
	delete t/D i/index
3. Delete sleep records
	delete t/S i/index
4. Delete body weight records
	delete t/W i/index

The syntax for set command is:
1. Set exercise goals
	set t/E p/INTERVAL_TYPE target/TARGET_ENERGY
2. Set diet goals
	set t/D p/INTERVAL_TYPE target/TARGET_ENERGY
3. Set sleep goals
	set t/S p/INTERVAL_TYPE target/TARGET_DURATION
4. Set body weight goals
	set t/W p/INTERVAL_TYPE target/TARGET_WEIGHT

The syntax for check command is:
1. check exercise goals
	check t/E [p/INTERVAL_TYPE]
2. check diet goals
	check t/D [p/INTERVAL_TYPE]
3. check sleep goals
	check t/S [p/INTERVAL_TYPE]
4. check body weight goals
	check t/W [p/INTERVAL_TYPE]

The syntax for cancel command is:
1. cancel exercise goals
	cancel t/E i/INDEX
2. cancel diet goals
	cancel t/D i/INDEX
3. cancel sleep goals
	cancel t/S i/INDEX
4. cancel body weight goals
	cancel t/W i/INDEX

The syntax for exit command is:
	exit
--------------------------------------------------------------------
```

### Exit the app : `exit`

Stop the execution of this application.

Format: `exit`

Example of Usage:

Input:
`exit`

Expected Output:

```
--------------------------------------------------------------------
Thank you for using this app. The app is exiting...
--------------------------------------------------------------------
--------------------------------------------------------------------
Nice work today!
You are one step closer to ultimate fitness!
See you again soon :)
--------------------------------------------------------------------
```

### Input Exercise Data: `add`

Add one exercise record with workout activity, duration and date (optional).

Format: `add  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]`

* The name of workout activity `a/ACTIVITY_NAME` and duration `d/DURATION` **MUST** be specified.
* The name of the workout should be a `String`.
* The tag value should be `E` in the upper case, which specifies that the current record is for **exercise data**.
* The default unit of duration is in **minutes**. An `integer` is expected for the duration, other formats are **not
  acceptable**.
* The date of the exercise record `[date/DD-MM-YYYY]` is optional. If not provided, the system date of today will be
  used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

> **Note:**
> Only the following workout activity names are acceptable:  
> `WALKING`, `RUNNING`, `CYCLING`, `ELLIPTICAL`, `ROWER`, `STAIRSTEPPER`  
> `HIKING`, `HIIT`, `YOGA`, `DANCE`, `COOLDOWN`, `SWIMMING`, `CORETRAINING`

Examples of Usage:

Input:
`add t/E a/running d/40`

Expected Output:

```
--------------------------------------------------------------------
A new EXERCISE record is added successfully!
Record summary:
40 minute(s) of RUNNING exercise on 03-04-2021
--------------------------------------------------------------------
```

Input:
`add t/E a/cycling d/60 date/05-01-2020`

Expected Output:

```
--------------------------------------------------------------------
A new EXERCISE record is added successfully!
Record summary:
60 minute(s) of CYCLING exercise on 05-01-2020
--------------------------------------------------------------------
```

### View Exercise Data: `view`

View existing exercise records. The result can be filtered by specifying the workout activity name and/or date.

Format: `view  t/E  [a/ACTIVITY_NAME]  [date/DD-MM-YYYY]`

* The tag value should be `E` in the upper case, which specifies the output for records of exercise data.
* The name and date of the exercise activity are optional fields used for filtering the records that will be displayed.
  If not specified, all existing records will be displayed.
* The name of the workout activity may be specified to view records of the specified exercise activity. It should be a
  String.
* The optional date field can be specified to view records on the given date.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are **not acceptable**.

Examples of Usage:

Input:
`view t/E`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible exercise records:
Index        Date          Activity        Duration        Calories
1            05-01-2020    CYCLING         60 minute(s)    414.0 cal
2            31-03-2021    WALKING         1440 minute(s)  8640.0 cal
3            01-04-2021    WALKING         1440 minute(s)  8640.0 cal
4            01-04-2021    YOGA            40 minute(s)    208.0 cal
5            01-04-2021    STAIRSTEPPER    50 minute(s)    175.0 cal
6            03-04-2021    RUNNING         40 minute(s)    264.0 cal

--------------------------------------------------------------------
```

Input:
`view t/E a/cycling`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible exercise records:
Index        Date          Activity        Duration        Calories
1            05-01-2020    CYCLING         60 minute(s)    414.0 cal

--------------------------------------------------------------------
```

Input:
`view t/E date/03-04-2021`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible exercise records:
Index        Date          Activity        Duration        Calories
1            03-04-2021    RUNNING         40 minute(s)    264.0 cal

--------------------------------------------------------------------
```

### Delete Exercise Data: `delete`

Delete an existing exercise record.

Format: `delete  t/E i/INDEX`

* Delete a single exercise record using the index of the record.
* The tag value should be `E` in the upper case, which specifies that the operation is for exercise data.
* The index of the record **must** be specified.
* The index must be an `integer` within the range of the total number of records, index out of range or other formats
  are **not acceptable**.

Examples of Usage:

Input:
`delete t/E i/1`

Expected Output:

```
--------------------------------------------------------------------
You have successfully deleted the EXERCISE record of index 1!
Record summary: 60 minute(s) of CYCLING exercise on 05-01-2020
Displaying current EXERCISE records:
1            31-03-2021    WALKING         1440 minute(s)  8640.0 cal
2            01-04-2021    WALKING         1440 minute(s)  8640.0 cal
3            01-04-2021    YOGA            40 minute(s)    208.0 cal
4            01-04-2021    STAIRSTEPPER    50 minute(s)    175.0 cal
5            03-04-2021    RUNNING         40 minute(s)    264.0 cal

--------------------------------------------------------------------
```

### Input Diet Data: `add`

Add one diet record with food category, food weight and date (optional).

Format: `add  t/D f/FOOD_CATEGORY  w/WEIGHT  [date/DD-MM-YYYY]`

* The category and weight of the food must be specified. The category of the food should be a String.
* The tag value should be `D` in the upper case, which specifies that the current record is for diet data.
* The default unit of weight is in grams. An `integer` is expected for the duration, other formats are not acceptable.
* The date of the diet record is optional. If not provided, the system date will be used.
* The date should be less than or equal to the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

> **Note:**
> Only the following food categories are acceptable:  
> `VEGETABLE`, `PROTEIN`, `FRUIT`, `GRAIN`

Examples of Usage:

Input:
`add t/D f/grain w/400`

Expected Output:

```
--------------------------------------------------------------------
A new DIET record is added successfully!
Record summary:
400.0g grain on 03-04-2021
--------------------------------------------------------------------
```

### View Diet Data: `view`

View existing diet records. The result can be filtered by specifying the food category and/or date.

Format: `view  t/D  [a/FOOD_CATEGORY]  [date/DD-MM-YYYY]`

* The tag value should be `D` in the upper case, which specifies the output for records of diet data.
* The food category and date are optional fields used for filtering the records that will be displayed. If not
  specified, all existing records will be displayed.
* The food category may be specified to view records of the given food category. The food category should be a `String`.
* The date should be less than or equal to the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Examples of Usage:

Input:
`view t/D`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible diet records:
Index        Date          Food Category       Weight      Calories
1            31-03-2021    FRUIT               500.0 g     20000.0 K cal
2            31-03-2021    PROTEIN             200.0 g     28000.0 K cal
3            01-04-2021    GRAIN               2000.0 g    700000.0 K cal
4            01-04-2021    FRUIT               100.0 g     4000.0 K cal
5            03-04-2021    GRAIN               400.0 g     140000.0 K cal

--------------------------------------------------------------------
```

Input:
`view t/D f/grain`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible diet records:
Index        Date          Food Category       Weight      Calories
1            01-04-2021    GRAIN               2000.0 g    700000.0 K cal
2            03-04-2021    GRAIN               400.0 g     140000.0 K cal
--------------------------------------------------------------------
```

Input:
`view t/D date/03-04-2021`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible diet records:
Index        Date          Food Category       Weight      Calories
1            03-04-2021    GRAIN               400.0 g     140000.0 K cal

--------------------------------------------------------------------
```

### Delete Diet Data: `delete`

Delete an existing diet record.

Format: `delete t/D i/INDEX`

* Delete a single diet record using the Index of the record.
* The tag value should be `D` in the upper case, which specifies that the operation is for diet records.
* The index of the record **must** be specified.
* The index must be an `integer` within the range of the total number of records, index out of range or other formats
  are **not acceptable**.

Examples of Usage:

Input:
`delete t/D i/1`

Expected Output:

```
--------------------------------------------------------------------
You have successfully deleted the DIET record of index 1!
Record summary: 500.0g fruit on 31-03-2021
Displaying current DIET records:
1            31-03-2021    PROTEIN             200.0 g     28000.0 K cal
2            01-04-2021    GRAIN               2000.0 g    700000.0 K cal
3            01-04-2021    FRUIT               100.0 g     4000.0 K cal
4            03-04-2021    GRAIN               400.0 g     140000.0 K cal

--------------------------------------------------------------------
```

### Input Sleep Data: `add`

Add one sleep record with duration and date (optional).

Format: `add  t/S  d/DURATION  [date/DD-MM-YYYY]`

* The duration of the sleep record `d/DURATION` **MUST** be specified.
* The tag value should be `S` in the upper case, which specifies that the current record is for **sleep data**.
* The default unit of duration is in **hours**. An `integer` is expected for the duration, other formats are **not
  acceptable**.
* The date of the sleep record `[date/DD-MM-YYYY]` is optional. If not provided, the system date of today will be used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Examples of Usage:

Input:
`add t/S d/8`

Expected Output:

```
--------------------------------------------------------------------
A new SLEEP record is added successfully!
Record summary:
8.0 hour(s) of sleep on 03-04-2021
--------------------------------------------------------------------
```

Input:
`add t/S d/9 date/05-01-2020`

Expected Output:

```
--------------------------------------------------------------------
A new SLEEP record is added successfully!
Record summary:
9.0 hour(s) of sleep on 05-01-2020
--------------------------------------------------------------------
```

### View Sleep Data: `view`

View existing sleep records. The result can be filtered by specifying date.

Format: `view  t/S  [date/DD-MM-YYYY]`

* The tag value should be `S` in the upper case, which specifies the output for records of sleep data.
* The optional date field can be specified to view records on the given date.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are **not acceptable**.

Examples of Usage:

Input:
`view t/S`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible sleep records:
Index        Date              Duration
1            05-01-2020        9.0 hour(s)
2            31-03-2021        6.0 hour(s)
3            01-04-2021        10.0 hour(s)
4            01-04-2021        5.0 hour(s)
5            03-04-2021        8.0 hour(s)

--------------------------------------------------------------------
```

Input:
`view t/S date/01-04-2021`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible sleep records:
Index        Date              Duration
1            01-04-2021        10.0 hour(s)
2            01-04-2021        5.0 hour(s)

--------------------------------------------------------------------
```

### Delete Sleep Data: `delete`

Delete an existing sleep record.

Format: `delete t/S i/INDEX`

* Delete a single sleep record using the index of the record.
* The tag value should be `S` in the upper case, which specifies that the operation is for sleep data.
* The index of the record **must** be specified.
* The index must be an `integer` within the range of the total number of records, index out of range or other formats
  are **not acceptable**.

Examples of Usage:

Input:
`delete t/S i/1`

Expected Output:

```
--------------------------------------------------------------------
You have successfully deleted the SLEEP record of index 1!
Record summary: 9.0 hour(s) of sleep on 05-01-2020
Displaying current SLEEP records:
1            31-03-2021        6.0 hour(s)
2            01-04-2021        10.0 hour(s)
3            01-04-2021        5.0 hour(s)
4            03-04-2021        8.0 hour(s)

--------------------------------------------------------------------
```

### Input Body Weight Data: `add`

Add one body weight record with current body weight and date (optional).

Format: `add  t/W  w/WEIGHT  [date/DD-MM-YYYY]`

* The weight of the body weight record `d/DURATION` **MUST** be specified.
* The tag value should be `W` in the upper case, which specifies that the current record is for **bodyweight data**.
* The default unit of duration is in **Kilogram**.
* The date of the bodyweight record `[date/DD-MM-YYYY]` is optional. If not provided, the system date of today will be
  used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Examples of Usage:

Input:
`add t/W w/64`

Expected Output:

```
--------------------------------------------------------------------
A new BODYWEIGHT record is added successfully!
Record summary:
Body weight 64.0 Kg on 03-04-2021
--------------------------------------------------------------------
```

Input:
`add t/W w/40 date/05-01-2020`

Expected Output:

```
--------------------------------------------------------------------
A new BODYWEIGHT record is added successfully!
Record summary:
Body weight 40.0 Kg on 05-01-2020
--------------------------------------------------------------------
```

### View Body Weight Data: `view`

View existing bodyweight records. The result can be filtered by specifying date.

Format: `view  t/W  [date/DD-MM-YYYY]`

* The tag value should be `W` in the upper case, which specifies the output for records of body weight data.
* The optional date field can be specified to view records on the given date.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are **not acceptable**.

Examples of Usage:

Input:
`view t/W`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible body weight records:
Index        Date              Body Weight
1            05-01-2020        40.0 Kg
2            03-04-2021        64.0 Kg

--------------------------------------------------------------------

```

Input:
`view t/W date/01-04-2021`

Expected Output:

```
--------------------------------------------------------------------
Displaying all eligible body weight records:
Index        Date              Body Weight
1            03-04-2021        64.0 Kg

--------------------------------------------------------------------
```

### Delete Body Weight Data: `delete`

Delete an existing bodyweight record.

Format: `delete t/W i/INDEX`

* Delete a single body weight record using the index of the record.
* The tag value should be `W` in the upper case, which specifies that the operation is for bodyweight data.
* The index of the record **must** be specified.
* The index must be an `integer` within the range of the total number of records, index out of range or other formats
  are **not acceptable**.

Examples of Usage:

Input:
`delete t/W i/1`

Expected Output:

```
--------------------------------------------------------------------
You have successfully deleted the BODY_WEIGHT record of index 1!
Record summary: Body weight 67.0 Kg on 01-04-2021
Displaying current BODY_WEIGHT records:
Sorry, no records found.
You can try adding records by using command 'add'.
--------------------------------------------------------------------
```

### Set a daily or weekly goal for exercise: `set`

Set a daily/weekly exercise goal with a target energy (in calories) to burn.

Format: `set  t/E p/INTERVAL_TYPE target/ENERGY`

* The tag value should be `E` in the upper case, which specifies that the current goal is for **exercise data**.
* The interval type can be `D`, and `W` corresponding to **daily and weekly**.
* The default unit of energy is in **kcal**. A **float number** is expected for the energy to burn, other formats are **
  not acceptable**.

Example of usage:

Input:
`set t/E p/D target/0.5`

Expected Output:

```
--------------------------------------------------------------------
A new exercise goal is set successfully!
Date Set: 03-04-2021
Goal Type: DAILY exercise
Target: 0.5 Kcal
Progress: 264.0 Kcal
--------------------------------------------------------------------
```

Input:  
`set t/E p/W target/10`

Expected Output:

```
--------------------------------------------------------------------
A new exercise goal is set successfully!
Date Set: 03-04-2021
Goal Type: WEEKLY exercise
Target: 10.0 Kcal
Progress: 264.0 Kcal
--------------------------------------------------------------------
```

### Set a daily or weekly goal for sleep: `set`

Set a daily/weekly sleep goal with a target duration (in hours).

Format: `set  t/S p/INTERVAL_TYPE target/DURATION`

* The tag value should be `S` in the upper case, which specifies that the current goal is for **sleep data**.
* The interval type can be `D`, and `W` corresponding to **daily and weekly**.
* The default unit of duration is in **hours**. The format of the duration should be either `X` or `X.5`, where `X` is
  an integer between `0` and `23` and `0.5` means half an hour. Other formats are **not acceptable**.

Examples of Usage:

Input:
`set t/S p/D target/8.5`

Expected Output:

```
--------------------------------------------------------------------
A new sleep goal is set successfully!
Date Set: 03-04-2021
Goal Type: DAILY sleep
Target: 8.5 hour(s)
Progress: 0.0 hour(s)
--------------------------------------------------------------------
```

Input:  
`set t/S p/W target/24`

Expected Output:

```
--------------------------------------------------------------------
A new sleep goal is set successfully!
Date Set: 03-04-2021
Goal Type: WEEKLY sleep
Target: 24.0 hour(s)
Progress: 0.0 hour(s)
--------------------------------------------------------------------
```

### Set a daily or weekly goal for diet: `set`

Set a daily/weekly diet goal with a target energy (in calories) to take in.

Format: `set  t/D p/INTERVAL_TYPE target/ENERGY`

* The tag value should be `D` in the upper case, which specifies that the current goal is for **diet data**.
* The interval type can be `D`, and `W` corresponding to **daily and weekly**.
* The default unit of energy is in **kcal**. A **float number** is expected for the energy take in, other formats are **
  not acceptable**.

Examples of Usage:

Input:
`set t/D p/D target/0.2`

Expected Output:

```
--------------------------------------------------------------------
A new diet goal is set successfully!
Date Set: 03-04-2021
Goal Type: DAILY diet
Target: 0.2 Kcal
Progress: 140000.0 Kcal
--------------------------------------------------------------------
```

Input
`set t/D p/W target/5`

Expected Output:

```
--------------------------------------------------------------------
A new diet goal is set successfully!
Date Set: 03-04-2021
Goal Type: WEEKLY diet
Target: 5.0 Kcal
Progress: 140000.0 Kcal
--------------------------------------------------------------------
```

### Set a daily or weekly goal for body weight: `set`

Set a daily/weekly body weight goal with a target weight (in kg).

Format: `set  t/W p/INTERVAL_TYPE target/WEIGHT`

* The tag value should be `W` in the upper case, which specifies that the current goal is for **body weight data**.
* The interval type can be `D`, and `W` corresponding to **daily and weekly**.
* The default unit of weight is in **kg**. A **float number** is expected for the weight, other formats are **not
  acceptable**.

Examples of Usage:

Input:
`set t/W p/D target/50`

Expected Output:

```
--------------------------------------------------------------------
A new bodyweight goal is set successfully!
Date Set: 03-04-2021
Goal Type: DAILY bodyweight
Target: 50.0 Kg
Progress: 67.0Kg
--------------------------------------------------------------------
```

Input:  
`set t/W p/W target/50`

Expected Output:

```
--------------------------------------------------------------------
A new bodyweight goal is set successfully!
Date Set: 03-04-2021
Goal Type: WEEKLY bodyweight
Target: 50.0 Kg
Progress: 67.0Kg
--------------------------------------------------------------------
```

### Check the progress of goals: `check`

Check the current progress of goals set by the user.

Format: `check  t/TAG [p/INTERVAL_TYPE]`

* The tag value should only be `E`, `S`, `D`, `W`. It specifies the kind of goal (exercise, sleep, diet and body weight)
  to check.
* The interval type can be `D`, and `W`corresponding to **daily and weekly**. It is optional.

Examples of Usage:

Input:
`check t/E`

Expected Output:

```
--------------------------------------------------------------------
Checking the progress of eligible exercise goals:
Index        Date Set        Goal Type        Target        Progress
1        01-04-2021        daily           20.0 Kcal       264.0 Kcal(achieved)
2        03-04-2021        daily           0.5 Kcal        264.0 Kcal(achieved)
3        03-04-2021        weekly          10.0 Kcal       264.0 Kcal(achieved)

--------------------------------------------------------------------

```

Input:  
`check t/E p/W`

Expected Output:

```
--------------------------------------------------------------------
Checking the progress of eligible exercise goals:
Index        Date Set        Goal Type        Target        Progress
1        03-04-2021        weekly          10.0 Kcal       264.0 Kcal(achieved)

--------------------------------------------------------------------
```

### Cancel a goal: `cancel`

Cancel a goal set by the user.

Format: `cancel  t/TAG i/INDEX`

* The tag value should only be `E`, `S`, `D`, `W`. It specifies the kind of goal (exercise, sleep, diet and body weight)
  to check.
* The index of the record **must** be specified.
* The index must be an `integer` within the range of the total number of records, index out of range or other formats
  are not acceptable.

Examples of Usage:

Input:
`cancel t/E i/1`

Expected Output:

```
--------------------------------------------------------------------
You have successfully canceled a goal for exercise!
Goal canceled:
Date Set: 01-04-2021
Goal Type: DAILY exercise
Target: 20.0 Kcal
Progress: 264.0 Kcal
Displaying current exercise goals available:
Index        Date Set        Goal Type        Target        Progress
1        03-04-2021        daily           0.5 Kcal        264.0 Kcal(achieved)
2        03-04-2021        weekly          10.0 Kcal       264.0 Kcal(achieved)

--------------------------------------------------------------------
```

## FAQ

**Q**: {What is the format of date?}

**A**: {The date format should be DD-MM-YYYY}

## Command summary

Action | Format | Examples
--- | --- | --- |
Help | `help` | `help`
Exit | `exit` | `exit`
Input Exercise Data: `add` | `add  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]` | `add t/E a/running d/40`
View Exercise Data: `view` | `view  t/E  [a/ACTIVITY_NAME]  [date/DD-MM-YYYY]` | `view t/E a/cycling`
Delete Exercise Data: `delete` | `delete  t/E i/INDEX` | `delete t/E i/1`
Input Diet Data: `add` | `add t/D f/FOOD_CATEGORY w/WEIGHT [date/DD-MM-YYYY]` | `add t/D f/grain w/400`
View Diet Data: `view` | `view  t/D  [a/FOOD_CATEGORY]  [date/DD-MM-YYYY]` | `view t/D f/grain`
Delete Diet Data: `delete` | `delete  t/D i/INDEX` | `delete t/E i/1`
Input Sleep Data: `add` | `add  t/S  d/DURATION  [date/DD-MM-YYYY]` | `add t/S d/7`
View Sleep Data: `view` | `view  t/S  [date/DD-MM-YYYY]` | `view t/S`
Delete Sleep Data: `delete` | `delete  t/S i/INDEX` | `delete t/S i/1`
Input bodyweight Data: `add` | `add  t/W w/WEIGHT [date/DD-MM-YYYY]` | `add t/W w/68.5 date/10-01-2021`
View bodyweight Data: `view` | `view  t/W  [date/DD-MM-YYYY]` | `view t/W date/05-01-2020`
Delete bodyweight Data: `delete` | `delete  t/W i/INDEX` | `delete t/W i/1`
Set a Goal `set` | `set t/TAG p/[INTERVAL_TYPE] target/GOAL_TARGET` | `set t/S p/D target/8`
Check Existing Goals: `check` | `check t/TAG p/[INTERVAL_TYPE]` | `check t/E p/D`
Cancel a Goal: `cancel` | `cancel t/TAG i/INDEX` | `cancel t/E i/1`
