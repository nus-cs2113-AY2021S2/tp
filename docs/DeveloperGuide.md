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
`
GULIO requires input from the user which is handled by the `UI` component, the `UI` then interacts with the `Parser` component to validate user input before returning a `Command` object which executes the appropriate command. The `Command` component interacts with the `Model` and `Storage` component to reflect the state of the application data.

The interaction of the components can be visualized in a sequence diagram as follows:

[Placeholder for sequence diagram]

By design, the user is greeted with a dashboard upon launching GULIO. The commands, available in the dashboard, differ from those within a module. Consequently, there is a different help page for the dashboard and when the user has entered a module. Once the user has added modules, the user can issue a command to enter that specific module and have access to commands relating to tasks, lessons, etc. for a module. Each time a user invokes a command that modifies the data, GULIO will auto-save by writing to the .txt file for that module.

[Class diagram for DashboardCommands, ModuleCommands]

###UI component
**API**: UI.java

* Facilitates the CLI interface
* Methods to display general messages, prompt messages and error messages
* Reads in user’s input, and used by Command classes to react to user’s inputs
* The UI object created as an attribute in Duke is passed into each command to be executed
* Instances of UI are used by tests in general

&nbsp;&nbsp;
###Model component

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
