# Patient Manager User Guide

Patient Manager is a _Command Line Interface_ (CLI) application for _general practitioners_ (GP) 
who work in clinics to manage their patient list. This includes a recording/retrieval of 
past record of visit, scheduling of the next appointment, and some other features listed below. 
With the Patient Manager, GPs will be able to reduce paperwork and have a more efficient way 
to organize the records of their patients.

---

## Table of Contents

* [Quickstart](#quickstart)
* [Features](#features)
    * [Print a help message: `help`](#print-a-help-message-help)
    * [Adding a patient: `add`](#adding-a-patient-add)
    * [Listing all patients: `list`](#listing-all-patients-list)
    * [Loading a patient's medical records: `load`](#loading-a-patients-medical-records-load)
    * [Displaying the current loaded patient: `current`](#displaying-the-current-loaded-patient-current)
    * [Recording a patient's consultation details: `record`](#recording-a-patients-consultation-details-record)
    * [Retrieving a patient's consultation details: `retrieve`](#retrieving-a-patients-consultation-details-retrieve)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
* [Command summary](#command-summary)

---

## Quickstart

1. Ensure that you have Java 11 installed on your local computer. If you do not have the correct version
   of Java installed, `Java 11` can be downloaded from 
   [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).
   

2. Obtain a copy of the latest version of the Patient Manager (tp.jar) from 
   [here](https://github.com/AY2021S2-CS2113T-W09-4/tp/releases) and place it in an empty folder.
   

3. Open a terminal/command line (cmd)/powershell. A Windows 10 OS' screenshot is here:\
   \
   ![PowerShell](./images/WindowsPowerShell.png)
   

4. Execute `java -jar tp.jar` to start the Patient Manager.


5. Once the welcome message appears, simply type in a command (e.g. [`help`](#print-a-help-message-help)) and hit `ENTER` at the end.


6. Refer to the Features section below for more detailed explanations and usage of the available commands.

---

## Features

### Print a help message: `help`
Prints out the help message with a brief explanation of the available commands. If one or more
commands are provided as arguments, the info messages for the indicated commands will be printed.

Usage: `help` `OPTIONAL_COMMAND(S)`

Example of usage:
```
help list load exit
```

### Adding a patient: `add`
Adds a patient to the list by entering their IC number.

Usage: `add` `IC_NUMBER`

Example of usage:
```
add S1234567A
```

### Listing all patients: `list`
Shows a list of all patients.

Usage: `list`

### Loading a patient's medical records: `load`
Finds the patient whose IC number matches the given search query and loads their medical records.
If none of the patients' IC numbers match the search query, it will print an error message.

Usage: `load` `IC_NUMBER`

Example of usage:
```
load S1234567A
```

### Displaying the current loaded patient: `current`
Displays the patient that has been loaded through the [`load`](#loading-a-patients-medical-records-load) command.
If no patient has been loaded, it will inform the user that there is no loaded patient.

Usage: `current`

### Recording a patient's consultation details: `record`
Adds a patient's consultation details to the patient's records.
This command requires that a patient has been loaded with the 
[`load`](#loading-a-patients-medical-records-load) command. 
If no patient has been loaded, it will print an error message.

Usage: `record` `DETAILS`

Example of usage:
```
record fever and slight cough
```

### Retrieving a patient's consultation details: `retrieve`
Retrieves all consultation details of a patient.
This command requires that a patient has been loaded with the
[`load`](#loading-a-patients-medical-records-load) command.
If no patient has been loaded, it will print an error message.

Usage: `retrieve`

### Exiting the program: `exit`
Exits the program

Usage: `exit`

---

## Command Summary
Listed below are all currently implemented commands in alphabetical order.\
Click on the commands to navigate to specific feature details.

| Command                                                          | Usage              |
|------------------------------------------------------------------|--------------------|
| [add](#adding-a-patient-add)                                     | `add` `IC_NUMBER`  |
| [current](#displaying-the-current-loaded-patient-current)        | `current`          |
| [exit](#exiting-the-program-exit)                                | `exit`             |
| [help](#print-a-help-message-help)                               | `help`             |
| [list](#listing-all-patients-list)                               | `list`             |
| [load](#loading-a-patients-medical-records-load)                 | `load` `IC_NUMBER` |
| [record](#recording-a-patients-consultation-details-record)      | `record` `DETAILS` |
| [retrieve](#retrieving-a-patients-consultation-details-retrieve) | `retrieve`         |



