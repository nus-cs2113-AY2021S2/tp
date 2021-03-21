# Finux User Guide
By: `Jonah Tham`, `Gerard Tan`, `Lee Han Yong Andy`, `Mark Low`, `Tan Tze Xern` 

Since: `March 2021`

- [Finux User Guide](#finux-user-guide)
    * [1. Introduction](#1-introduction)
    * [2. Quick Start](#2-quick-start)
    * [3. Features](#3-features)
        + [3.1 Add a record: `add`](#31-add-a-record-add)
        + [3.2 List the records details: `list`](#32-list-the-records-details-list)
        + [3.3 View category total amount: `view`](#33-view-category-total-amount-view)
        + [3.4 Set a loan as return: `return`](#34-set-a-loan-as-return-return)
        + [3.5 Remove a record: `remove`](#35-remove-a-record-remove)
        + [3.6 Check a person credit score: `creditscore`](#36-check-a-person-credit-score-creditscore)
        + [3.7 Exit the program: `exit`](#37-exit-the-program-exit)
        + [3.8 Help function: `help`](#38-help-function-help)
        + [3.9 Task Storage](#39-task-storage)
    * [4. Frequently Asked Question (FAQ)](#4-faq)
    * [5. Command Summary](#5-command-summary)


## 1. Introduction

Finux is a CLI Style application that allows the user to make better financial
decisions based on the information recorded in the application. If you’re familiar
with the CLI command interface, you will enjoy the benefit of speeding up your
finance management rather than using the traditional management system.


## 2. Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `finux.jar` from [here](https://github.com/AY2021S2-CS2113T-W09-1/tp/releases/tag/v1.0).
3. Copy the file to the folder you want to use as the *home folder* for your Duke.
4. For Windows users, pull up your **Command Prompt**.\
   For Mac users, pull up your **Terminal**.\
   Navigate to the directory containing the `finux.jar` file.\
   i.e. `cd FILEPATH`, `FILEPATH` is the address of your file.
5. Run the Duke.jar file by using the `java -jar finux.jar` command.


## 3. Features
> ❗ **CAUTION:** Insert any warning.
> * _Finux_ supports multiple Date formats, for ease of use:
>   * `DDMMYYYY`
>   * `D.M.YYYY`
>   * `D-M-YYYY`
>   * `D/M/YYYY`
>   * `YYYY.M.D`
>   * `YYYY-M-D`
>   * `YYYY/M/D`
> * `today` keyword specifies today's date, replacing the need to type in the actual date.
### 3.1 Add a record: `add`
> For the `add` command, there is no strict ordering for options.
<br>
> i.e. options `-a` can come before/after option `-d`.
#### 3.1.1 Add an expense record

This operation will add an expense record to the list.

Format: `add -e <description> -a <amount> -d <date>`

Examples: `add -e Plain bread loaf -a 2.90 -d 20.3.2021`

Output:

![add expense example output](https://via.placeholder.com/100.png?text=Photo)

#### 3.1.2 Add a loan record

This operation will add a loan record to the list.

Format: `add -l <description> -a <amount> -d <date> -p <borrower>`

Examples: `add -l 1st loan to Mark -a 200 -d 20.3.2021 -p Mark`

Output:

![add loan example output]()

#### 3.1.3 Add a saving record

This operation will add a saving record to the list.

Format: `add -s <description> -a <amount> -d <date>`

Examples: `add -s Savings from March -a 1000 -d 05/04/2021`

Output:

![add saving example output]()

### 3.2 List the records details: `list`

This operation will list the details of chosen record type.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![list example output]()

### 3.3 View category total amount: `view`

This operation will view the total amount of chosen record type.

Format: `view <OPTION>`

> Available Options:
>* `-e`: view the total amount of expenditure.
>* `-l`: view the total amount of unreturned loans.
>* `-s`: view the total amount of saving.

Examples: `view -e`, `view -l`

Output:

![view example output](https://github.com/AY2021S2-CS2113T-W09-1/tp/blob/master/docs/img/View%20Example%20Output.jpg?raw=true)

### 3.4 Set a loan as return: `return`

This operation will set a loan record as returned by the loanee.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![return example output]()

### 3.5 Remove a record: `remove`

This operation will remove a record from the list.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![remove example output]()

### 3.6 Check a person credit score: `creditscore`

This operation will check the credit score of a person.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![creditscore example output]()

### 3.7 Exit the program: `exit`

This operation exit the program.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![exit example output]()

### 3.8 Help function: `help`

This operation lists the help page for the application.

Format: `help <FEATURE>`

> Available Features:
>* `add`: view the help page for `add` command.
>* `list`: view the help page for `list` command.
>* `view`: view the help page for `view` command.
>* `return`: view the help page for `return` command.
>* `remove`: view the help page for `remove` command.
>* `creditscore`: view the help page for `creditscore` command.
>* `exit`: view the help page for `exit` command.
>* `all`: view entire help page.
>* 💡 **Tip**: Just type `help` and you can view the entire help page.

Examples: `help exit`, `help list`

Output:

![help example output]()

### 3.9 Task Storage

#### 3.9.1 Automatically load data from an existing file to the program.

* Expected Outcome if successful:
  ![load success example output]()

* Expected outcome if not successful:
  ![load fail example output]()
  
#### 3.9.2 Automatically save the current task list to a file.

* After entering `exit`, program will automatically store all the tasks into a task_logs.txt file.


## 4. FAQ

**Q**: {Insert question}? 

**A**: {your answer here}

**Q**: Does the `view -l` shows the total loan amount?

**A**: No. `view -l` only shows the total unreturned loans amount.


## 5. Command Summary

Command | Format | Example |
------- | ------- | ------- | 
add | `insert format` | `insert example` |
list | `insert format` | `insert example` |
view | `view <OPTION>` | `view -e` |
return | `insert format` | `insert example` |
remove | `insert format` | `insert example` |
creditscore | `insert format` | `insert example` |
exit | `help <FEATURE>` | `help exit` |
help | `insert format` | `insert example` |
