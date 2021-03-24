# GULIO Developer Guide

## Introduction

**Purpose**

This document describes the architecture and implementation details of the command line application, GULIO.

**Overview**

GULIO is a command line application for NUS students to organize their modules. The application separates commands into 2 categories: those allowed on the dashboard and those allowed only when a module has been selected (the user is in a module). As such, the commands are similarly structured to command-line shell commands. For example, the command `open cs2113t` mimics `cd` into the folder named “CS2113T”, and the commands `modules`, `lessons`, `tasks` or `cheat-sheets` are similar to `ls` in power shell.

## Design

### Architecture

[Placeholder class diagram]

The application consists of the following components:
* `UI`: Handles reading and printing
* `Parser`: Validates and checks user input
* `Command`: Executes commands
* `Model`: Consists of data related to the application
* `Storage`: Handles loading and storing of data into text files

GULIO requires input from the user which is handled by the `UI` component, the `UI` then interacts with the `Parser` component to validate user input before returning a `Command` object which executes the appropriate command. The `Command` component interacts with the `Model` and `Storage` component to reflect the state of the application data.

The interaction of the components can be visualized in a sequence diagram as follows:

[Placeholder for sequence diagram]

By design, the user is greeted with a dashboard upon launching GULIO. The commands, available in the dashboard, differ from those within a module. Consequently, there is a different help page for the dashboard and when the user has entered a module. Once the user has added modules, the user can issue a command to enter that specific module and have access to commands relating to tasks, lessons, etc. for a module. Each time a user invokes a command that modifies the data, GULIO will auto-save by writing to the .txt file for that module.

[Class diagram for DashboardCommands, ModuleCommands]

### UI component
**API**: UI.java

* Facilitates the CLI interface
* Methods to display general messages, prompt messages and error messages
* Reads in user’s input, and used by Command classes to react to user’s inputs
* The UI object created as an attribute in Duke is passed into each command to be executed
* Instances of UI are used by tests in general

&nbsp;&nbsp;

## Parser component
**API**: `Parser.java`

* Determines the command entered by the user

* Parses the parameters needed by the `Command` object (for commands which require additional details)

* Checks the validity of parsed parameters, in some instances calling methods from other relevant classes, e.g. calling a method from the `Lessons` class to verify parsed lesson links.

* May instruct `UI` to print warnings and prompts to users, e.g. when users enter invalid parameters.

* Returns a new `Command` object with all the necessary attributes filled

&nbsp;&nbsp;

### Model component

[Class diagram for all these objects - include attributes for each of them]

**ModuleList:**

* The ModuleList class keeps an ArrayList of module code strings, 
  and if a user is in a module, the selected module’s code
* Mainly handles operations related to Module objects such as loading
* Also contains methods to sort the other data types in this component
* Acts as a facade between storage and the other components

**Module:**

* The Module class contains attributes related to a course module in NUS
* It also holds an ArrayList for the Lesson and Task model

**Lesson:**

The `Lesson` class contains attributes related to a typical course lesson

* Lesson type, e.g. Lab, Tutorial or Lecture
* Time and day of the lesson
* Link to the lesson session
* Teaching staff information

**Teaching staff:**

The `TeachingStaff` class contains attributes related to the teacher(s) of a particular lesson

* Name of the teacher
* Email address of the teacher

**Task:**

The Task class contains attributes related to an assignment, deadline or task in a university setting

* Description of task
* Deadline of task
* Remarks
* Done status
* Graded status

&nbsp;&nbsp;
### Storage component
The storage component is responsible for creating and loading modules and their respective data, as well as saving the data each time a change is made. It consists of two components:

**Loader:**

* Loads the list of modules from the “Data” directory
* Loads lesson and task data from the selected module’s “.txt” file

**Writer:**

* Creates all the directories required 
* Deletes files and directories
* Creates the “.txt” file that saves the module’s lessons and tasks
* Writes changes to the “.txt” file that saves the module’s lessons and tasks

**Structure of storage:**

* Data directory
    * Module directory
        * Module data text file
        * Cheat-sheet directory
            * Cheat-sheet text file
    
&nbsp; &nbsp;
### Common classes
Classes that are used by multiple components:
* CommonMethods: Stores methods that are used by multiple components
* Constants: Stores constants
* Messages: Stores strings that are printed by the UI
* DashboardCommands: Enum of commands that can be used outside a module
* ModuleCommands: Enum of commands that can be used inside a module
