<style type="text/css">
ol {
    counter-reset: item
}
ol > li {
    counter-increment: item;
}
ol ol > li {
    display: block
}
ol ol > li:before {
    content: counters(item, ".") ". "; counter-increment: item
}
</style>

# Patient Manager User Guide

Patient Manager is a **Command Line Interface** (CLI) application for **general practitioners** (GP)
to manage their patient list. Patient Manger allows you to easily register new patients to your clinic with their NRIC
or FIN number. Once a patient's records have been loaded, you can easily add new medical records and retrieve a summary
of past records

With the Patient Manager, GPs will be able to reduce paperwork and have a more efficient way to organize the records of
their patients.

<!-- TODO: Explain How to use this guide -->

---

## Table of Contents

<!-- TODO: Description -->

1. [User Guide Information](#user-guide-information)
1. [Quick Start](#quick-start)
1. [Features](#features)
    1. [Print a help message: `help`](#print-a-help-message-help)
    1. [Adding a patient: `add`](#adding-a-patient-add)
    1. [Deleting a patient or a patient's consultation details: `delete`](#deleting-a-patient-or-a-patients-consultation-details-delete)
    1. [Listing all patients: `list`](#listing-all-patients-list)
    1. [Loading a patient's medical records: `load`](#loading-a-patients-medical-records-load)
    1. [Displaying the current loaded patient: `current`](#displaying-the-current-loaded-patient-current)
    1. [Recording a patient's consultation details: `record`](#recording-a-patients-consultation-details-record)
    1. [Retrieving a patient's consultation details: `retrieve`](#retrieving-a-patients-consultation-details-retrieve)
    1. [Exiting the program: `exit`](#exiting-the-program-exit)
1. [Frequently Asked Questions](#frequently-asked-questions)
1. [Command Summary](#command-summary)

---

## User Guide Information

The aim of this user guide is to familiarise you with the features of Patient Manager, and to guide you on how to set up
and start using Patient Manager.

You may refer to [Quick Start](#quick-start) for help on setting up and getting started with Patient Manager

The [Features](#features) section contains a detailed explanation of the commands that are available in Patient Manager,
as well as their input formats.

If you have any questions about Patient Manager, please check
out [Frequently Asked Questions](#frequently-asked-questions)
for a list of common questions.

Finally, for returning users who are not sure about the input format for a command, you can check
[Command Summary](#command-summary) for a table of valid commands, and their input format.


> Please take note of the following symbols and formatting in this User Guide
>
> `Code blocks` are used to denote commands in the command line, user input, output from Patient Manager and file names.
>
> 💡 The light bulb denotes tips and tricks for using Patient Manager.
>
> ℹ️ The information symbol highlights useful information to take note of.
>
> ❗ The exclamation mark highlights important things to take note of.

---

## Quick Start

> ℹ️ Patient Manager is a Command-Line application, and all commands need to be run from the
> console (e.g. Terminal/Command Prompt/PowerShell). For reference, a guide to open the Windows
> Powershell in Windows 10 is shown below:
>
> <img src="./images/WindowsPowerShell.png" width="600">

1. Ensure that you have Java 11 installed on your local computer. If you do not have the correct version of Java
   installed, Java 11 can be downloaded from
   [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html). \
   > 💡 You can check the version of Java installed on your local computer by entering\
   > `java -version` into your console and then pressing `ENTER`.
1. Obtain a copy of the latest version of Patient Manager (`PatientManager.jar`) from
   [here](https://github.com/AY2021S2-CS2113T-W09-4/tp/releases) and place it in an empty folder.
   > ❗ The folder should not be read-only. Otherwise, Patient Manager may encounter issues when saving
   > records to disk.
1. Open the console, enter `java -jar PatientManager.jar`, and press `ENTER` to start Patient Manager.
1. Once the welcome message appears, simply type in a command (e.g. [`help`](#print-a-help-message-help))
   and hit `ENTER` at the end to execute the command.
1. Please refer to [Features](#features) below for more detailed explanations and usage of the available commands.

## Features

> ℹ️ Notes about the command format:
>
> - Words in `UPPER_CASE` are parameters supplied by the user.\
> e.g. in `add IC_NUMBER`, `IC_NUMBER` is a parameter that has to be specified.\
> Parameters in square brackets (`[]`) are optional.\
> - e.g. for the `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]` command,
> both `record 26/03/2021 /s coughing` and `record /s fever /p panadol` are valid commands.
> - Parameters with `...` allow multiple parameters (including zero) to be specified.\
> e.g. for `help [OPTIONAL_COMMAND]...` both `help` and `help add delete` are valid commands.
> - Parameters starting with a slash (`/`) can be given in any order.\
> e.g. if a command specifies `/s SYMPTOMS /p PRESCTIPTION` as its parameters,
> `/p PRESCTIPTION /s SYMPTOMS` is also acceptable.\
> However, for `record DATE /s SYMPTOMS`, `record /s SYMPTOMS DATE` is not acceptable.\
> For first-time users, we recommend that you follow the sequence given in this section.
> - If a parameter is expected only once in the command, but you specify it multiple times,
> only the last occurrence of the parameter will be taken.\
> e.g. if you specify `/s coughing /s fever`, only `/s fever` will be taken.
> - Extraneous parameters for commands that do not take in parameters (such as `list`
> and `exit`) will be ignored.\
> e.g. if the command given is `list 123`, it will be interpreted as `list`.


> ❗ Notes on valid and invalid user input:
>
> - Due to how Patient Manager stores its records to disk, the following ASCII characters are not allowed
> to be used as part of any input:\
```
~`%#@!
```
> If any of these characters are used as an input value, they will be replaced with a space when saving to
> disk, and will not show up if Patient Manager is closed and reopened.
> - Dates must be specified in the format `dd/mm/yyyy` with leading zeroes, for example, `05/03/2021`.
> All dates given must be valid, according to the rules of the
> [Gregorian Calendar](https://en.wikipedia.org/wiki/Gregorian_calendar).
<!-- TODO: Order | explain why help command is the 1st -->

### Print a help message: `help`

If you need help at any point in time, you may use the `help` command. \
This prints out the help message with a brief explanation of the available commands.

Furthermore, you may request for the help messages for specific command(s) by
providing one or more valid commands as arguments. If invalid commands are provided as
arguments, `help` will show an error message to inform you which commands are invalid.

Usage: `help [OPTIONAL_COMMAND]...`

Example of usage:

```
help list load exit
```

Expected output:

```
----------------------------------------------------------------------
Show the list of all patients
Usage: list

Select a specified patient to add and retrieve records
Command prefix: load
Arguments(s): IC number
Usage: load IC_NUMBER
Example: load S1234567D

Exit the program
Usage: exit
----------------------------------------------------------------------
```

### Adding a patient: `add`

Adds a patient to the system based on their NRIC/FIN number so that consultation details for the
patient can be recorded.

If the patient already exists in the system, the `add` command will not add the patient in and
it will display a message to inform you that the patient already exists in the system.

<!-- So that ..., This means that ... -->

> ❗ Note: Patient Manager will automatically validate the NRIC/FIN number based on the check digit
> before it adds the patient. For testing purposes, you may want to use an NRIC/FIN number generator to
> create valid NRIC/FIN numbers, like [this one](https://samliew.com/nric-generator).

Usage: `add IC_NUMBER`

Example of usage:

```
add S1234567D
```

Expected output:

```
----------------------------------------------------------------------
Patient S1234567D has been added!
----------------------------------------------------------------------
```

### Loading a patient's medical records: `load`

Finds the patient whose IC number matches the given search query and loads their medical records
for editing. If none of the patients' IC numbers match the search query, Patient Manager will display
an error message to inform you that the patient was not found.

Usage: `load IC_NUMBER`

Example of usage:

```
load S1234567D
```

Expected output:

```
----------------------------------------------------------------------
Patient S1234567D's data has been found and loaded.
----------------------------------------------------------------------
```

### Deleting a patient or a patient's consultation details: `delete`

Deletes a patient from the list or deletes a patient's consultation details for a specific date.\
The `/p` flag is used to delete patients based on their NRIC/FIN number, while the `/r` flag
is used to delete records from a certain date. Exactly one of the `/p` or `/r` flags and their 
corresponding arguments must be specified.

> ❗ Note: Before deleting a patient's record, you must have previously loaded a patient with the
> [`load`](#loading-a-patients-medical-records-load) command. If no patient has been loaded, Patient Manager
> will print an error message.

Usage: `delete [/p IC_NUMBER] [/r DATE]`

Example of usage:

```
delete /p S1234567D
```

Expected output:
```
----------------------------------------------------------------------
Patient S1234567D has been deleted!
----------------------------------------------------------------------
```

Example of usage:

```
delete /r 10/04/2021
```

Expected output:
```
----------------------------------------------------------------------
Record for 10/04/2021 has been deleted!
----------------------------------------------------------------------
```

### Listing all patients: `list`

Shows a list of all patients in alphanumeric order.

Usage: `list`

Example output:

```
----------------------------------------------------------------------
List of patients (in alphanumeric order):
1. S1234567D
2. S7654321F
----------------------------------------------------------------------
```

### Displaying the current loaded patient: `current`

Displays the patient that has been loaded through the [`load`](#loading-a-patients-medical-records-load) command. If no
patient has been loaded, it will display a message to inform the user that there is no loaded patient.

Usage: `current`

Example output:

```
----------------------------------------------------------------------
The currently loaded patient's ID is S1234567D.
----------------------------------------------------------------------
```

### Recording a patient's consultation details: `record`

Adds a patient's consultation details to the patient's records. At least one symptom, diagnosis or prescription
has to be specified by using the `/s`, `/d` or `/p` flags with a non-empty input.

An optional `DATE` argument may be provided to modify previous visit records, or to create a new record with the
specified date. This date has to be equal to or earlier than the current system date. If the no date is specified,
Patient Manager will execute the command with the current system date. 

> ❗ Note: Before adding a medical record to a patient, you must have previously loaded a patient with the
> [`load`](#loading-a-patients-medical-records-load) command. If no patient has been loaded, Patient Manager
> will print an error message.

Usage: `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]`

Example of usage:

```
record 26/03/2021 /s fever and slight cough
```

Expected output:

```
----------------------------------------------------------------------
Added new record to patient S1234567D:
Symptom: fever and slight cough
----------------------------------------------------------------------
```

### Retrieving a patient's consultation details: `retrieve`

Retrieves all consultation details of a patient.

An optional `DATE` argument may be provided to retrieve the records from a specific date. If no records were
found for the patient at the specified date, Patient Manager will inform you that no records were found.

> ❗ Note: Before retrieving the  medical record(s) to a patient, you must have previously loaded a patient
> with the [`load`](#loading-a-patients-medical-records-load) command. If no patient has been loaded, Patient
> Manager will print an error message.

Usage: `retrieve [DATE]`

Example output:

```
----------------------------------------------------------------------
Here are S1234567D's records:
30/03/2021:
Symptoms:
	head pain, dizziness
Diagnoses:
	heat stroke
Prescriptions:
	cooling packs, medicine

31/03/2021:
Symptoms:
	fainting
Diagnoses:
	severe heat stroke
Prescriptions:
	referral to hospital

----------------------------------------------------------------------
```

### Exiting the program: `exit`

Exits the program

Usage: `exit`

---

## Frequently Asked Questions

**Q**: Can I transfer the data to a different device? \
**A**: Yes, simply copy the `save.pm` file that is found in the same folder as `PatientManager.jar` from the
original device and place it in the folder `PatientManager.jar` is found in on the new device.

**Q**: Will I have to manually save? \
**A**: No, the data is saved automatically after every command that modifies the data.

**Q**: Can I edit the data file? \
**A**: Patient Manager data is saved as a text file. While it is possible to edit the data file, it is not recommended
to do so as invalid formats in the data file will result in errors.

---

## Command Summary

Listed below are all currently implemented commands in alphabetical order.\
Click on the commands to navigate to specific feature details.

| Command                                                                 | Usage                              |
|-------------------------------------------------------------------------|------------------------------------|
| [add](#adding-a-patient-add)                                            | `add IC_NUMBER`                    |
| [current](#displaying-the-current-loaded-patient-current)               | `current`                          |
| [delete](#deleting-a-patient-or-a-patients-consultation-details-delete) | `delete [/p IC_NUMBER]  [/r DATE]` |
| [exit](#exiting-the-program-exit)                                       | `exit`                             |
| [help](#print-a-help-message-help)                                      | `help [OPTIONAL_COMMAND]...`       |
| [list](#listing-all-patients-list)                                      | `list`                             |
| [load](#loading-a-patients-medical-records-load)                        | `load IC_NUMBER`                   |
| [record](#recording-a-patients-consultation-details-record)             | `record [DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]`|
| [retrieve](#retrieving-a-patients-consultation-details-retrieve)        | `retrieve [DATE]`                  |