# Developer Guide

## Design 

### Project overview

NUSFOODREVIEW is built using java. It has cross platform ability that allows it to run on Windows, MAC-OS and Linux. 
When the application is running it has to ability to display a number of canteens around NUS and all their stores available.
The application allow users to read/enter reviews and ratings on the chosen store. User is also able to view some sample 
menus of the stores. The application will record the timestamp whenever a new review is entered and print it out together 
with the review when requested. Admin must verify themselves using password given by the application developer and change 
it once they logged in as admin. Admin has the ability to add/delete canteen, store and review. NUSFOODREVIEW has a storage file
that allows the saving and loading of data. This allows all parameters of the data to be stored and read whenever is needed.

##Implementation
This section describes some noteworthy details on how certain features are implemented.

###[Proposed] delete feature 
####Proposed Implementation
Step 1. The admin launches the application for the first time. Admin must enter a password to verify identity.

Step 2. The user selects to delete a canteen from the list of tasks admin can do.

Step 3. The user selects a canteen from the canteen list and canteen is deleted.

## Product scope
### Target user profile

{Describe the target user profile}
The target user would be NUS students/staffs who wish 
to get updated reviews about the food places in NUS.

### Value proposition

{Describe the value proposition: what problem does it solve?}
By consolidating food reviews from NUS canteens from students/staffs, 
it aims to allow new students/staffs to have a better experience at these food stores.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|see list of stores|to find good food|
|v1.0|user|read reviews|decide on where to eat|
|v1.0|user|view menu and price of items|know the type of food sold|
|v1.0|user|add reviews and rating|provide feedback on store|
|v1.0|admin|login|verify myself|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list



## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
