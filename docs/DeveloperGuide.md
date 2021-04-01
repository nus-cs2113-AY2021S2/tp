# Healthier Developer Guide

Group `F10-2`  
Last update on `31 Mar 2021`

## Table of Content

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



## Getting Started



## Design



## Implementation

This section describes some details on how certain features are implemented.

### [Proposed] Add record feature

#### Proposed implementation

Adding a record to record list is achieved by `AddCommand` and `RecordList`. Records of the same category are stored as a `RecordList`. A `ReocrdList` supports the following operation:

* `RecordList#addRecord(Record newRecord)` —  Add a new record of the specified type to the list.

All `Record` in a `RecordList` are of the same type so each user has 4 `RecordList` to hold `EXERCISE`, `DIET`, `BODY_WEIGHT`, `SLEEP` records respectively.

`FitCenter` is a uniform interface to manipulate all the `RecordList` and provide interface `FitCenter#addRecordToList(CommandRecordType type, Record record)`

Given below is an example of interaction among classes to add a new exercise record:

Step 1. The user enters a valid `add` command. An `AddCommand` will be initialized with the parsed parameters from user input.

Step 2. The `AddCommand` initializes a `Record` and calls `FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)` to add the record.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a any of the parameters passed in are invalid, `AddCommand` will throw an error and will not call `FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)`, so the record will not be saved into the `RecordList`.

</div>

Step 3.`FitCenter#FitCenter#addRecordToList(CommandRecordType type, Record record)` calls `RecordList#addRecord(Record newRecord)` to modify the list.

The following sequence diagram shows how the `add` command works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)


## Appendix: Requirements

### Product Scope

#### Target User Profile

{Describe the target user profile}

#### Value proposition

{Describe the value proposition: what problem does it solve?}

### User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

### Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
