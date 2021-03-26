# Developer Guide

## Table of Contents
{to be added}

## Introduction

Patient Manager is a _Command Line Interface_ (CLI) application for _general practitioners_ (GP)
who work in clinics to manage their patient list. This includes a recording/retrieval of
past record of visit, scheduling of the next appointment, and some other features listed below.
With the Patient Manager, GPs will be able to reduce paperwork and have a more efficient way
to organize the records of their patients.

## Setting up the project in your computer

First, fork this repo, and clone the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):
1. Configure the JDK: Follow the guide [se-edu/guides] IDEA: Configuring the JDK to ensure Intellij is configured 
   to use JDK 11.
2. Import the project as a Gradle project: Follow the guide [se-edu/guides] IDEA: Importing a Gradle project to import 
   the project into IDEA.
   ❗ Note: Importing a Gradle project is slightly different from importing a normal Java project.
3. Verify the setup: Run the `seedu.duke` and try a few commands. 
   Run the tests to ensure they all pass.

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

## Product scope

### Target user profile

{Describe the target user profile}

### Value proposition

Through Patient Manager, general practitioners are able to manage patients faster than a typical mouse/GUI driven app.

{Describe the value proposition: what problem does it solve?}

{more to be added}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|GP in a polyclinic|add a new patient|record a patient|
|v1.0|GP in a polyclinic|view the list of patients|track the list of patients|
|v1.0|GP in a polyclinic|select a specific patient's records|access the patient's records|
|v1.0|GP in a polyclinic|add new record for a patient|refer to them during future consultations|
|v1.0|GP in a polyclinic|retrieve the patient's past records|refer to them during the current consultation|
|v1.0|new User|view list of available commands|refer to them if I have any problems|
|v2.0|GP in a polyclinic|delete a patient|remove patients are no longer required to be tracked|
|v2.0|GP in a polyclinic|delete a patient's records|remove records that I no longer need|
|v2.0|GP in a polyclinic|know if I entered a invalid Patient ID|make sure no mistake is made recording the patient's ID|
|v2.0|GP in a polyclinic|load and save existing data|work on the data on another device|

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed. 
2. Should be able to hold up to 1000 patients without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should 
   be able to accomplish most of the tasks faster using commands than using the mouse. 
   
{more to be added}

## Glossary

* *glossary item* - Definition

## Testing

### Automated Testing
We have both JUnit Test and IO Redirection Test. To run these tests, execute these commands in a shell or CMD:
```
### For JUnit tests
# *nix OS and MacOSX bash
./gradlew check
# Windows CMD
gradlew.bat check

### For I/O redirection tests
cd text-ui-test
# *nix OS and MacOSX bash
./runtest.sh
# Windows CMD
runtest.bat
```

### Manual Testing
The current version does not support storing the data on the local drive. To start with the manual testing process, you may refer to the "QuickStart" section of the [User Guide](UserGuide.md).
