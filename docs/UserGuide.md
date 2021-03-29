# GULIO User guide

**GULIO (Get Ur Life In Order)**  is a desktop app that provides a single consolidated and personalised workspace for NUS SOC students to organize their modules. GULIO is optimized for use via a Command Line Interface (CLI) which SOC students will be familiar with typing in, instead of a Graphical User Interface (GUI).

If you are having difficulties managing your schedule, lesson links and notes, GULIO is the app for you. With the ability to store lesson details, tasks, notes and more, GULIO is a one-stop solution for all your university scheduling needs.

> Icons used in this guide:<br>
> <br>
> 💡 - Indicates a tip that may be useful to you.<br>
> ⚠ - indicates a warning that you should take note of.

&nbsp;

----

## Table of Content

* [Quick Start](#quick-start)
* [Features](#features)
    * [Overview](#overview)
    * [Dashboard Commands](#dashboard-commands)
        * [Listing all dashboard commands : **help**](#listing-all-dashboard-commands--help)
        * [Exiting the program : **exit**](#exiting-the-program--exit)
        * [Opening a module : **open**](#opening-a-module--open)
        * [Adding a module : **add**](#adding-a-module--add)
        * [Deleting a module : **delete**](#deleting-a-module--delete)
        * [Listing all modules : **modules**](#listing-all-modules--modules)
    * [Module Commands](#module-commands)
        * [Listing all module commands : **help**](#listing-all-modules--modules)
        * [Closing a module : **close**](#closing-a-module--close)
        * [Showing module information : **info**](#showing-module-information--info)
        * [Adding a lesson : **add lesson**](#adding-a-lesson--add-lesson)
        * [Deleting a lesson : **delete lesson**](#deleting-a-lesson--delete-lesson)
        * [Editing a lesson : **edit lesson**](#editing-a-lesson--edit-lesson)
        * [Opening lesson link : **link**](#opening-lesson-link--link)
        * [Listing all teaching staff : **teacher**](#listing-all-teaching-staff--teacher)
        * [Listing all lessons : **lessons**](#listing-all-lessons--lessons)
        * [Adding a task : **add task**](#adding-a-task--add-task)
        * [Deleting a task : **delete task**](#deleting-a-task--delete-task)
        * [Editing a task : **edit task**](#editing-a-task--edit-task)
        * [Marking task as done : **mark**](#marking-task-as-done--mark)
        * [Marking task as undone : **unmark**](#marking-task-as-undone--unmark)
        * [Listing all tasks : **tasks**](#listing-all-tasks--tasks)
        * [Adding a cheat-sheet : **add cheat-sheet**](#adding-a-cheat-sheet--add-cheat-sheet)
        * [Deleting a cheat-sheet : **delete cheat-sheet**](#deleting-a-cheat-sheet--delete-cheat-sheet)
        * [Editing a cheat-sheet : **edit cheat-sheet**](#editing-a-cheat-sheet--edit-cheat-sheet)
        * [Listing all cheat-sheets : **cheat-sheets**](#listing-all-cheat-sheets--cheat-sheets)
    * [Data & Storage](#data--storage)
        * [Automatic Saving](#automatic-saving)
        * [Manual Editing Outside GULIO](#manual-editing-outside-of-gulio)
    * [Text Editor](#text-editor)
    * [Command Summary](#command-summary)

&nbsp;

----

## Quick Start

Download the latest version of GULIO from here:
https://github.com/AY2021S2-CS2113T-W09-3/tp/releases

### Requirements

java 11 and above<br>

> 💡 Verify this by running the command “java --version” in command prompt (for Windows users) or Terminal (for Mac and Linux users).

### Steps:

1. Move the GULIO.jar file to your preferred directory.
1. Open command prompt (for Windows users) or Terminal (for Mac and Linux users),
1. Navigate to the directory of your GULIO.jar file.
1. Run the command “java -jar gulio.jar” to start GULIO.

> 💡 The file name is not case-sensitive, so both gulio.jar and GULIO.jar work here.

&nbsp;

<p align="center">
    <img width="973" src="userGuideImages/StartGULIO.png" alt="Command Line GULIO"><br>
    Figure 1 - Example of Opening GULIO in Command Prompt
</p>

&nbsp;

----

## Features

### Overview

GULIO has a 2-layer system, consisting of the dashboard layer and the module layer. In both layers, you have access to a different set of commands. On start up, you will be on the dashboard layer where you have an overview of all your modules. You have access to module management commands like adding, deleting or opening a particular module.

Opening a module will put you on the module layer, where you can interact with the data within the module.

> 💡 Please refer to the section [Dashboard Commands](#dashboard-commands) for information regarding commands at the dashboard layer.<br>

> 💡 Please refer to the section [Module Commands](#module-commands) for information regarding commands at the module layer.

To identify which layer you are on, simply check the tag beside your input.

* “GULIO” indicates that you are at the dashboard layer.
* A module code (e.g. “CS2113T”) indicates that you are within that module.

<table>
    <tr>
        <td>
            <p align="center">
                <img width="400" src="userGuideImages/Dashboard.png" alt="Dashboard Label"><br>
                Figure 2a - Dashboard Layer
            </p>
        </td>
        <td>
            <p align="center">
                <img width="400" src="userGuideImages/Module.png" alt="Module Label"><br>
                Figure 2b - Module Layer
            </p>
        </td>
    </tr>
</table>

Each module can store two types of data: lesson and task. Lessons refer to your lectures, labs and tutorials, which are all recurring events. Meanwhile, tasks are used to store one-time events, like your homework, quizzes and any other activities with a deadline.

#### Fields in a lesson:

| Field | Description |
| --- | --- |
| Lesson type | Lecture, lab or tutorial. |
| Day & time | Information on when the lesson happens. |
| Link | Online meeting link for lesson. |
| Teaching staff name | Name of the lesson's teacher. |
| Teaching staff email | Email of the lesson's teacher. |

#### Fields in a task:

| Field | Description |
| --- | --- |
| Task name | A short title for the task. |
| Deadline | Deadline of task in DD-MM-YYYY format. |
| Remarks | Additional information on the task. |
| Graded status | True or false, whether the task is graded. |
| Done status | True or false, whether the task is done. |

Additionally, you can store your lecture notes in GULIO using the cheat-sheet feature. Cheat-sheets are stored as text files and GULIO has a built-in text editor that can be used to edit them. Cheat-sheets are unformatted so that users can focus on writing the content.<br>