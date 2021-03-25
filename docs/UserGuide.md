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

> 💡 **Explanation for Command formats:**
>> Commands in Finux follow these argument orders (depending on the command):
>> * `CMD -OPT <FIELD> [-OPT <FIELD>...]`
>> * `CMD -OPT`
>> * `CMD { -OPT_1 ... | -OPT_2 ... | ... } ...`
>> * `CMD <FIELD>`
>> * `CMD [<FIELD>]`
>> * `CMD`
>>
>> Argument types and notation:\
>> `CMD` - a valid command.\
>> `-OPT` - an option, a letter preceded by a dash. E.g. "-i".\
>> `<FIELD>` - an area where data is required.\
>> `[...]` - optional argument(s).\
>> `{ ... | ... | ... }` - mutually exclusive arguments.
>>
> ❗ **Commands and options are case-sensitive:**\
> E.g. `exit` will work, whereas `Exit`, `EXIT` or other variations
> will not be recognised.\
> E.g. `view -s` will work, but using `-S` will not be recognised as
> a valid option.

> 💡 **Date and Date formats:**
>> Finux supports multiple Date formats, for ease of use:
>> * `DDMMYYYY`
>> * `D.M.YYYY`
>> * `D-M-YYYY`
>> * `D/M/YYYY`
>> * `YYYY.M.D`
>> * `YYYY-M-D`
>> * `YYYY/M/D`
>>
>> 📝 `today` keyword specifies today's date, replacing the need to type in the actual date for date inputs.

### 3.1 Add a record: `add`
> For the `add` command, there is no strict ordering for options.\
> i.e. options `-a` can come before/after option `-d`.
#### 3.1.1 Add an expense record

This operation will add an expense record to the list.

Format: `add -e <description> -a <amount> -d <date>`

Examples: `add -e Plain bread loaf -a 2.90 -d 20.3.2021`

Output:

![add expense example output](https://via.placeholder.com/100.png?text=Photo)

#### 3.1.2 Add a loan record

This operation will add a loan record to the list.

Format: `add -l <description> -a <amount> -d <date> -p <person>`

Examples: `add -l 1st loan to Mark -a 200 -d 20.3.2021 -p Mark`

Output:

![add loan example output](https://via.placeholder.com/100.png?text=Photo)

#### 3.1.3 Add a saving record

This operation will add a saving record to the list.

Format: `add -s <description> -a <amount> -d <date>`

Examples: `add -s Savings from March -a 1000 -d 05/04/2021`

Output:

![add saving example output](https://via.placeholder.com/100.png?text=Photo)

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

![view example output](img/View_Example_Output.jpg)

### 3.4 Set a loan as return: `return`

This operation will set a loan record as returned by the loanee.

Format: `insert format`

Examples: `insert example`, `insert example`

Output:

![return example output]()

### 3.5 Remove a record: `remove`

This operation will remove a record from the record list.

Format: `remove -i <index>`
> - The `<index>` refers to the index number shown on the record list
> - `<index>` must be a **positive integer** 1,2,3...
> - `<index>` must be referring to an existing record

Examples: `remove -i 1`, `remove -i 2`

Output:

![remove example output](https://github.com/AY2021S2-CS2113T-W09-1/tp/blob/master/docs/img/Remove%5FExample%5FOutput.jpg?raw=true)

### 3.6 Check a person's credit score: `creditscore`

This operation will check the credit score of a person.

Format: `creditscore <person>`

> - `<person>` refers to existing loanees in the loan list
> - `<person>` is case-insensitive, e.g. `jason` is the same as `Jason`

Examples: `creditscore jason`, `creditscore andy`

Output:

![creditscore example output]()

### 3.7 Exit the program: `exit`

This operation exit the program.

Format: `exit`

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

![help example output](img/Help_Example_Output.jpg)

### 3.9 Records storage

#### 3.9.1 Automatically saving all records into a file.

* All records are automatically saved after the following commands: `add`, `remove`, `return`.
* Records will **NOT** be saved after the following commands: `help`, `list`, `view`, `creditscore`.

> ❗ **WARNING:** Do ensure that permissions are given for FINUX to write into the folder it is in,
> FINUX will exit upon unsuccessful file creation.

#### 3.9.2 Automatically loading data from an existing file into FINUX.

* FINUX will automatically load the data from "finux.txt" when it finds the text
file in the same directory. <br><br>

* Expected output for new file creation:
![new_file_creation_output](img/New_File_Creation_Example.jpg)

* Expected output if successful load:
![load success example output](img/Successful_Load_Example.jpg)

* Expected output if not successfully loaded:
![load fail example output](img/Failed_Load_Example_Output.jpg)
  
#### 3.9.3 Editing the saved file directly
* The FINUX team encourages higher leveled users to edit the save directly.

> 💡 **NOTE:** Any minor mistakes in the syntax will lead to the termination of FINUX. 
> The team highly suggests that users only make minor changes like
> spelling errors instead of inserting new Records into the save file.

## 4. FAQ

**Q**: {Insert question}? 

**A**: {your answer here}

>**Q**: Does the `view -l` shows the total loan amount? <br>
>**A**: No. `view -l` only shows the total unreturned loans amount.

>**Q**: What happens if FINUX crashes unexpectedly? <br>
>**A**: All records are saved upon addition or deletion or returned, no worries!

>**Q**: FINUX keeps having a `bad init` error message, but it is my first time launching FINUX. <br>
>**A**: Do check and ensure that FINUX has the proper write permissions in the directory.

## 5. Command Summary

| Feature                                | Command                                                  |
| -------------------------------------- | -------------------------------------------------------- |
| Add an expense record                  | `add -e <description> -a <amount> -d <date>`             |
| Add a savings record                   | `add -s <description> -a <amount> -d <date>`             |
| Add a loan record                      | `add -l <description> -a <amount> -d <date> -p <person>` |
| List all expense records               | `list -e`                                                |
| List all savings records               | `list -s`                                                |
| List all loan records                  | `list -l`                                                |
| View total expenditure                 | `view -e`                                                |
| View total savings amount              | `view -s`                                                |
| View total amount of unreturned loans  | `view -l`                                                |
| Mark a loan as returned                | `return -i <loan_index> -d <return_date>`                |
| Remove a record (expense/savings/loan) | `remove -i <index>`                                      |
| Print a person's credit score          | `creditscore <person>`                                   |
| Help (selected command)                | `help <feature>`                                         |
| Help (all commands)                    | `help`                                                   |
| Exit the application                   | `exit`                                                   |

#### _List of command formats_
```
list { -e | -s | -l }

add { -e | -s | -l } <description> -a <amount> -d <date> [-p <person>]

creditscore <person>

return -i <loan_index> -d <return_date>

remove -i <index>

view { -e | -s | -l }

help [<feature>]

exit
```
