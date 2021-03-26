# Patient Manager User Guide

Patient Manager is a _Command Line Interface_ (CLI) application for _general practitioners_ (GP)
who work in government polyclinics to manage their patient list. This includes a recording/retrieval of
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

1. Obtain a copy of the latest version of the Patient Manager (tp.jar) from
   [here](https://github.com/AY2021S2-CS2113T-W09-4/tp/releases) and place it in an empty folder.

1. Open a terminal/command line (cmd)/powershell. A Windows 10 OS' screenshot is here:\
   \
   ![PowerShell](./images/WindowsPowerShell.png)

1. Execute `java -jar tp.jar` to start Patient Manager.

1. Once the welcome message appears, simply type in a command (e.g. [`help`](#print-a-help-message-help)) and hit `ENTER` at the end.

1. Refer to the Features section below for more detailed explanations and usage of the available commands.

---

## Features

> ❗ Notes about the command format
> - Words in `UPPER_CASE` are parameters supplied by the user\
e.g. in `add IC_NUMBER`, `IC_NUMBER` is a parameter that has to be specified\
(sample command: `add S1234567D`)
> - Parameters in square brackets are optional\
e.g. for the `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]` command,
both `record 26/03/2021 /s coughing` and `record /s fever /p panadol` are valid commands
> - Parameters with `...` allow multiple parameters (including zero) to be specified\
e.g. for `help [OPTIONAL_COMMAND]...` both `help` and `help add delete` are valid commands
> - Parameters can be given in any order\
e.g. if a command specifies `/s SYMPTOMS /p PRESCTIPTION` as its parameters,
`/p PRESCTIPTION /s SYMPTOMS` is also acceptable
> - If a parameter is expected only once in the command, but you specify it multiple times, only the last occurrence of
the parameter will be taken.\
e.g. if you specify `/s coughing /s fever`, only `/s fever` will be taken
> - Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be ignored\
e.g. if the command given is `list 123`, it will be interpreted as `list`.
> - Dates must be specified in the format `dd/MM/yyyy`, for example, `05/03/2021`. All dates given must be valid,
according to the rules of the [Gregorian Calendar](https://en.wikipedia.org/wiki/Gregorian_calendar).

### Print a help message: `help`

Prints out the help message with a brief explanation of the available commands. If one or more
commands are provided as arguments, the info messages for the indicated commands will be printed.
If invalid commands are given as arguments, Patient Manager will print an error message to inform the user
that the command does not exist.

Usage: `help [OPTIONAL_COMMAND]...`

Example of usage:

```
help list load exit
```

### Adding a patient: `add`

Adds a patient to the list by entering their IC number.

Usage: `add IC_NUMBER`

Example of usage:

```
add S1234567D
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
load S1234567D
```

### Displaying the current loaded patient: `current`

Displays the patient that has been loaded through the [`load`](#loading-a-patients-medical-records-load) command.
If no patient has been loaded, it will inform the user that there is no loaded patient.

Usage: `current`

### Recording a patient's consultation details: `record`

Adds a patient's consultation details to the patient's records.
This command requires that a patient has been loaded with the
[`load`](#loading-a-patients-medical-records-load) command.
If no patient has been loaded, Patient Manager will print an error message.

An optional `DATE` argument may be provided to modify previous visit records,
or to create a new record with the specified date. If the `DATE` parameter is
not specified, Patient Manager will execute the command with the current system date.

Usage: `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]`

Example of usage:

```
record 26/03/2021 /s fever and slight cough
```

### Retrieving a patient's consultation details: `retrieve`

Retrieves all consultation details of a patient.
This command requires that a patient has been loaded with the
[`load`](#loading-a-patients-medical-records-load) command.
If no patient has been loaded, Patient Manager will print an
error message.

Usage: `retrieve`

### Exiting the program: `exit`

Exits the program

Usage: `exit`

---

## Command Summary

Listed below are all currently implemented commands in alphabetical order.\
Click on the commands to navigate to specific feature details.

| Command                                                          | Usage                         |
|------------------------------------------------------------------|-------------------------------|
| [add](#adding-a-patient-add)                                     | `add IC_NUMBER`               |
| [current](#displaying-the-current-loaded-patient-current)        | `current`                     |
| [exit](#exiting-the-program-exit)                                | `exit`                        |
| [help](#print-a-help-message-help)                               | `help [OPTIONAL_ARGUMENTS]...`|
| [list](#listing-all-patients-list)                               | `list`                        |
| [load](#loading-a-patients-medical-records-load)                 | `load IC_NUMBER`              |
| [record](#recording-a-patients-consultation-details-record)      | `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]`            |
| [retrieve](#retrieving-a-patients-consultation-details-retrieve) | `retrieve`                    |



