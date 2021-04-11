# Healthier Developer Guide

Group `F10-2`  
Last update on `31 Mar 2021`
---

## Table of Contents

- [Getting Started](#getting-started)
- [Design](#design)
    - []()
    - []()
    - []()
- [Implementation](#implementation)
    - []()
    - []()
    - []()
- [Appendix: Requirements](#appendix-requirements)
    - [Product Scope](#product-scope)
        - [Target User Profile](#target-user-profile)
        - [Value Proposition](#value-proposition)
    - [User Stories](#user-stories)
    - [Non-Functional Requirements](#non-functional-requirements)
- [Glossary](#glossary)
- [Instructions for manual testing](#instructions-for-manual-testing)

---

## Getting Started

1. Fork [this repo](https://github.com/AY2021S2-CS2113-F10-2/tp) to your GitHub account
1. Clone the forked repo into your machine
1. Ensure you have **Java SE 11** installed
1. Import the repo in your Java IDE as project
1. Start hacking!

> Note that you are strongly recommended choosing Intellij IDEA as your IDE.

[**Get back to Table of Contents**](#table-of-contents)

---

## Design

[**Get back to Table of Contents**](#table-of-contents)

---

## Implementation

This section describes some details on how certain features of Healthier are implemented.

### [Proposed] Add record feature

#### Proposed implementation

Adding a record to record list is achieved by `AddCommand` and `RecordList`. Records of the same category are stored as
a `RecordList`. A `ReocrdList` supports the following operation:

* `RecordList#addRecord(Record newRecord)` — Add a new record of the specified type to the list.

All `Record` in a `RecordList` are of the same type so each user has 4 `RecordList` to hold `EXERCISE`, `DIET`
, `BODY_WEIGHT`, `SLEEP` records respectively.

`FitCenter` is a uniform interface to manipulate all the `RecordList` and provide
interface `FitCenter#addRecordToList(CommandRecordType type, Record record)`

Given below is an example of interaction among classes to add a new exercise record:

Step 1. The user enters a valid `add` command. An `AddCommand` will be initialized with the parsed parameters from user
input.

Step 2. The `AddCommand` initializes a `Record` and
calls `FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)` to add the record.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a any of the parameters passed in are invalid, `AddCommand` will throw an error and will not call `FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)`, so the record will not be saved into the `RecordList`.

</div>

Step 3.`FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)`
calls `RecordList#addRecord(Record newRecord)` to modify the list.

The following sequence diagram shows how the `add` command works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once
to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such
as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`.
Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not
pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be
purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern
desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

[**Get back to Table of Contents**](#table-of-contents)

---

## Appendix: Requirements

### Product Scope

#### Target User Profile

* People who care about fitness
* People who exercise regularly (at least 3 times/week) and have diet plans
* Age group:18-30
* People who are proficient in using CLI tools& typing.

#### Value proposition

* Help users record and analyze daily diet data.
* Help users record sleeping data.
* Help users record exercise data such as calorie burned.
* Help users record basic information (gender, weight, etc).
* Help users set/manage fitness goals (e.g. body-weight, exercise).

[**Get back to Table of Contents**](#table-of-contents)

### User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v1.0|user|upload/delete my workout exercise/duration data|keep track of my exercise history daily|
|v1.0|user|upload/delete my diet details|keep track of the food I eat daily|
|v1.0|user|upload/delete my sleeping data|keep track of my sleeping hours daily|
|v1.0|user|upload/delete my body weight|keep track of my body weight daily|
|v1.0|user|view my history workout exercise/duration data|know the progress of my strength|
|v1.0|user|view my diet details|know my daily/weekly calorie intake|
|v1.0|user|view my history sleeping data|see my past sleeping hours daily/weekly|
|v1.0|user|view my history body weight data|monitor the weight change|
|v2.0|user|set goals for exercises|have a reference and try to reach my exercise goals|
|v2.0|user|set goals for diet|have a reference and try to reach my diet goals|
|v2.0|user|set goals for body weight|have a reference and try to reach my exercise goals|
|v2.0|user|set goals for sleeping hours|have a reference and try to reach my weight goals|
|v2.0|user|check existing goals set|view the list of achieved goals and know the progress of unachieved goals|
|v2.0|user|cancel a goal set previously|stop tracking a goal that I am no longer interested in achieving|
|v2.1|user|use the app without encountering bugs|ensure my data are correctly recorded|

### Non-Functional Requirements

* Cross-platform and high compatibility.
* User-friendly and bug-free experience.
* Detailed and easy-to-follow user guide.
* Boost efficiency for people who are familiar with CLI tools.
* Easy maintenance.
* Scalable for additional features.
* Responsive interface.

[**Get back to Table of Contents**](#table-of-contents)

---

## Glossary

* *CLI* - Command-line Interface.
* *Record* - Contains all important data of a particular health activity, such as activity name, date, etc.
* *Goal* - A reminder with desired target that can be completed by adding records.

[**Get back to Table of Contents**](#table-of-contents)

---

## Instructions for manual testing

[**Get back to Table of Contents**](#table-of-contents)
