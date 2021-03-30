# Finux User Guide
By: `Jonah Tham`, `Gerard Tan`, `Lee Han Yong Andy`, `Mark Low`, `Tan Tze Xern`

Since: `March 2021`

---

# Table of Contents

---

1. [Introduction](#1-introduction)
1. [Quick Start](#2-quick-start)
1. [Features](#3-features)\
    3.1 [Add a record: `add`](#31-add-a-record-add)\
    3.2 [List the records details: `list`](#32-list-the-records-details-list)\
    3.3 [View category total amount: `view`](#33-view-category-total-amount-view)\
    3.4 [Set a loan as return: `return`](#34-mark-a-loan-as-returned-return)\
    3.5 [Remove a record: `remove`](#35-remove-a-record-remove)\
    3.6 [Check a person credit score: `creditscore`](#36-check-a-persons-credit-score-creditscore)\
    3.7 [Exit the program: `exit`](#37-exit-the-program-exit)\
    3.8 [Help function: `help`](#38-help-function-help)\
    3.9 [Records Storage](#39-records-storage)
1. [Frequently Asked Questions](#4-frequently-asked-questions)
1. [Command Summary](#5-command-summary)


## 1. Introduction

---

Finux is a Command-Line Interface (CLI) application that allows you to record your expenses, savings and loans all in
one consolidated platform. With these information made readily available at your fingertips, it will allow you to 
better adjust your expenditure or work harder towards your savings goal. Finux also includes a way for you to keep
track of the loans you have made to your friends, or the tabs for the dinners you have paid for first. 

As the Finux application is inspired entirely by the *Nix operating systems, and if you are familiar with the CLI
command interface, you will definitely enjoy the benefits of the application. You will also be able to speed up your
financial management and planning with the Finux application as compared to the traditional finance management 
applications in the market.

## 2. Quick Start

---

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `finux.jar` from [here](https://github.com/AY2021S2-CS2113T-W09-1/tp/releases/tag/v1.0).
3. Copy the `finux.jar` file to the folder you want to use as the *home folder* of Finux.
4. For Windows users, pull up your **Command Prompt**.\
   For Mac users, pull up your **Terminal**.\
   Navigate to the directory containing the `finux.jar` file.\
   i.e. `cd FILEPATH`, `FILEPATH` is the absolute address to the home folder of Finux.
5. Run the `finux.jar` file by executing the command `java -jar finux.jar`.

---

### 2.1 Understanding the guide
If you are here, congratulations on embarking on your money management journey. But before you proceed, there are a
few tips and tricks to better understanding our guide. 

Throughout the guide, you will come across various symbols, each has a different meaning:

> 💡: The light bulb will precede information that may be important when using the app.

> ❗: The exclamation will precede warnings for commands and inputs that may hinder your use of the app.

> 📝: The notepad will precede information that may improve the flexibility of using the app. 

---

> 💡 **Explanation for Command formats:**
>> Commands in Finux follow these argument orders (depending on the command):
>> * `CMD -OPT <FIELD> [-OPT <FIELD>...]`
>> * `CMD -OPT`
>> * `CMD { -OPT_1 ... | -OPT_2 ... | ... } ...`
>> * `CMD <FIELD>`
>> * `CMD [<FIELD>]`
>> * `CMD`
>
>> Argument types and notation:\
>> `CMD` - a valid command.\
>> `-OPT` - an option, a letter preceded by a dash. E.g. "-i".\
>> `<FIELD>` - an area where data is required.\
>> `[...]` - optional argument(s).\
>> `{ ... | ... | ... }` - mutually exclusive arguments,
>> * e.g. `{ -e | -l | -s }` means that `view -e -s` has a conflict with options `-e` and `-s`.
>
> ❗ **Commands and options are case-sensitive:**\
> E.g. `exit` will work, whereas `Exit`, `EXIT` or other variations
> will not be recognised.\
> E.g. `view -s` will work, but using `-S` will not be recognised as
> a valid option.

> 💡 **Date and Date formats:**
>> Date input is required when you specify the option `-d`.\
>> You are required enter a date that follows a valid Date format.\
>> Finux supports multiple Date formats, for ease of use:
>> * `DDMMYYYY`
>> * `D.M.YYYY`
>> * `D-M-YYYY`
>> * `D/M/YYYY`
>> * `YYYY.M.D`
>> * `YYYY-M-D`
>> * `YYYY/M/D`
>>
>> 📝 `today` keyword specifies today's date, replacing the need for you to type in the actual date for date inputs.

## 3. Features

---

### 3.1 Add a record: `add`

---

> 📝 For the `add` command, there is no strict ordering for options.\
> i.e. options `-a` can come before/after option `-d`.

#### 3.1.1 Add an expense record

Suppose you bought a plain loaf of bread for $2.90 on 3rd March 2021, you would want to enter
your `expense` as the example shown below.

Format: `add -e <description> -a <amount> -d <date>`

Example: `add -e Plain bread loaf -a 2.90 -d 20.3.2021`

Output:

![add expense example output](img/AddExpenseExampleOutput.jpg)


#### 3.1.2 Add a loan record

It is the 20th of March 2021, and your friend Mark borrows a large sum of $200 from you . You will
have to enter the following into Finux to record this `loan`.

You may want to add a _description_ of the `loan`, in this scenario, it will be `1st loan to Mark`
and to include his _name_ as to keep track of Mark's `loan`.

Format: `add -l <description> -a <amount> -d <date> -p <person>`

Example: `add -l 1st loan to Mark -a 200 -d 20.3.2021 -p Mark`

Output:

![add loan example output](img/AddLoanExampleOutput.jpg)

#### 3.1.3 Add a saving record

Lastly, you may have saved a sum of money over the past month of March and you recorded your `saving`
on the 5th of April.

Format: `add -s <description> -a <amount> -d <date>`

Example: `add -s Savings from March -a 1000 -d 05/04/2021`

Output:

![add saving example output](img/AddSavingExampleOutput.jpg)

> 💡 Do note that for an `expense`, you will have to use `-e` as the option. This follows for `loan` with `-l` and
> `saving` with `-s`.

### 3.2 List the records details: `list`

---

#### 3.2.1 List all expense records

You may want to list all your expense records in Finux. By entering the `list` command
with the `expense` option `-e`, Finux will display all your expenses.

Format: `list -e`

Output:

![list example output](img/ListExpenseExampleOutput.jpg)

#### 3.2.2 List all loan records

Similarly, with listing your expenses, Finux is also able to list all loans. You will have
to use the `loan` option `-l` in this scenario.

Format: `list -l`

Output:

![add loan example output](img/ListLoanExampleOutput.jpg)

#### 3.2.3 List all saving records

Lastly, all your savings can also be listed with the `saving` option `-s`. 

Format: `list -s`

Output:

![add saving example output](img/ListSavingExampleOutput.jpg)

### 3.3 View category total amount: `view`

---

#### 3.3.1 View total expenses

At this point, you may also want to `view` your total expenses incurred till now. 
So instead of listing as explained above, you would have to use the `view` command instead.

Format: `view -e`

Output:

![view expense example output](img/ViewExpenseExampleOutput.jpg)

#### 3.3.2 View total unreturned loans

You can also view your total **unreturned** loan using `view` and the option `-l`.

> 📝 The total amount shown only includes the unreturned loans

Format: `view -l`

Output:

![view loan example output](img/ViewLoanExampleOutput.jpg)

#### 3.3.3 View total savings

Your total savings can also be calculated using `view` and the option `-s`.

Format: `view -s`

Output:

![view saving example output](img/ViewSavingExampleOutput.jpg)

### 3.4 Mark a loan as returned: `return`

---

Let's say Mark returns the loan he borrowed on 20th March 2021, and his `loan` record is the third record in the list.
Then the _index_ to be included is `3` and the `date` is the date of return which is `28/03/21`.

Format: `return -i <index_of_loan> -d <date>`
* `<index_of_loan>` refers to the index number shown on the displayed list of records.
* `<index_of_loan>` must be a **positive integer** 1, 2, 3,...
* `<index_of_loan>` must be referring to an existing loan in the list.
* `<date>` refers to the date that the borrower has returned the money.

Example: `return -i 2 -d 28/03/2021`\
This example shows that you have entered a command that translates to the following:\
"The second entry(presumably a loan) on the record list is returned on 28/03/2021."

Output:

![return example output](img/ReturnExampleOutput.jpg)

### 3.5 Remove a record: `remove`

---

In a scenario that you realised that the `expense` record of Plain bread loaf added on 20th March 2021 was wrong,
you can `remove` the record by entering the `remove` command with the _index_ of the `expense`, this is case, it would
be the first record in the list.

Format: `remove -i <index>`
* `<index>` refers to the index number shown on the record list.
* `<index>` must be a **positive integer** 1,2,3...
* `<index>` must be referring to an existing record.

Example: `remove -i 1`\
This example shows that you have entered a command that translates to the following:\
"Remove the first record on the list."

Output:

![remove example output](img/RemoveExampleOutput.jpg)

> 💡 To find the index of a record, you can simply `list` the record type (`-e`, `-l`, `-s`) and the number that
> precedes the record is the index.

### 3.6 Check a person's credit score: `creditscore`

---


Let's say that Mark wants to borrow money from you again, but you will want to know his "credit-worthiness" 
(`creditScore`) before lending him money again, you can simply enter his _name_ after the `creditScore` command.

Format: `creditscore <person>`

> - `<person>` refers to existing borrower in the loan list
> - `<person>` is case-insensitive, e.g. `jason` is the same as `Jason`


Format: `creditscore <person>`

* `<person>` refers to any person including those in the list and not in the list.
* `<person>` is case-insensitive, e.g. `jason` is the same as `Jason`

Example: `creditscore mark`\
This example shows that you have entered a command that translates to the following:\
"Show Mark's credit score."

Output:

![creditscore example output](img/CreditScoreExampleOutput.jpg)

### 3.7 Exit the program: `exit`

---

You can exit the application by typing the `exit` command.

Format: `exit`

Output:

![exit example output](img/ExitExampleOutput.jpg)

### 3.8 Help function: `help`

---

If you do not know how to use any of the features in Finux, and would like to know their specifications, simply type
`help` followed by the command name of the available features.

> Available Features:
>* `add`: view the help section for `add` command.
>* `list`: view the help section for `list` command.
>* `view`: view the help section for `view` command.
>* `return`: view the help section for `return` command.
>* `remove`: view the help section for `remove` command.
>* `creditscore`: view the help section for `creditscore` command.
>* `exit`: view the help section for `exit` command.
>* `all`: view entire help section.

> 💡 Just typing `help` will allow you to view the entire help section.
 
Each help section is divided into three parts:
> 1. `NAME` will show you the feature name and its brief description. <br>
> 2. `SYNOPSIS` will show you the format to follow. <br>
> 3. `DESCRIPTION` will explain the usage of any arguments or options. <br>

> 📝 The `exit` section will only show the `NAME` and `SYNOPSIS` as no argument is needed.

Format: `help <FEATURE>`

Example: `help remove`

Output:

![help example output](img/HelpExampleOutput.jpg)

### 3.9 Records storage

---

#### 3.9.1 Automatically saving all records into a file

* All your records are automatically saved after the following commands: `add`, `remove`, `return`.
* Records will **NOT** be saved after the following commands: `help`, `list`, `view`, `creditscore`, `exit`.

> ❗ Do ensure that permissions are given for Finux to write into the folder it is in,
> Finux will exit upon unsuccessful file creation.

#### 3.9.2 Automatically loading data from an existing file into Finux

* Finux will automatically load your data from "finux.txt" when it finds the text
  file in the same home folder as mentioned in the [Quick Start](#2-quick-start). <br><br>

* Expected output for new file creation: <br>
  ![new_file_creation_output](img/NewFileCreationExampleOutput.jpg)

* Expected output if successful load: <br>
  ![load success example output](img/SuccessfulLoadExampleOutput.jpg)

* Expected output if not successfully loaded: <br>
  ![load fail example output](img/FailedLoadExampleOutput.jpg)

#### 3.9.3 Editing the saved file directly

* The Finux team encourages more tech-proficient users to edit the save directly.

> ❗ Any minor mistakes in the syntax will lead to the termination of Finux.

## 4. Frequently Asked Questions

---

**Q1**: How can I transfer my saved tasks information to another computer?
> Run Finux on the other computer and overwrite the empty `finux.txt` created, with the `finux.txt` that
> contains the data of your previous Finux usage.

**Q2**: Does the `view -l` shows the total loan amount? <br>
> No. `view -l` only shows the total amount of unreturned loans.

**Q3**: What happens if Finux crashes unexpectedly? <br>
> All records are saved upon addition, deletion or returned, so no worries!

**Q4**: Finux keeps having a `bad init` error message, but it is my first time launching Finux. <br>
> Do check and ensure that Finux has the proper write permissions in the directory.

## 5. Command Summary

---

| Feature                                | Command                                                  | Example                                              |
| -------------------------------------- | -------------------------------------------------------- |------------------------------------------------------|
| Add an expense record                  | `add -e <description> -a <amount> -d <date>`             | `add -e Plain bread loaf -a 2.90 -d 20.3.2021`       |
| Add a loan record                      | `add -l <description> -a <amount> -d <date> -p <person>` | `add -l 1st loan to Mark -a 200 -d 20.3.2021 -p Mark`|
| Add a saving record                    | `add -s <description> -a <amount> -d <date>`             | `add -s Savings from March -a 1000 -d 05/04/2021`    |
| List all expense records               | `list -e`                                                | -                                                    |
| List all loan records                  | `list -l`                                                | -                                                    |
| List all saving records                | `list -s`                                                | -                                                    |
| View total expenditure                 | `view -e`                                                | -                                                    |
| View total amount of unreturned loans  | `view -l`                                                | -                                                    |
| View total savings amount              | `view -s`                                                | -                                                    |
| Mark a loan as returned                | `return -i <loan_index> -d <return_date>`                | `return -i 3 -d 28/03/2021`                          |
| Remove a record (expense/savings/loan) | `remove -i <index>`                                      | `remove -i 1`, `remove -i 2`                         |
| Check a person's credit score          | `creditscore <person>`                                   | `creditscore jason`, `creditscore mark`              |
| Exit the application                   | `exit`                                                   | -                                                    |
| Help (selected command)                | `help <feature>`                                         | `help exit`, `help list`                             |
| Help (all commands)                    | `help`                                                   | -                                                    |

