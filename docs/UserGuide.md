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
        * [Listing all module commands : **help**](#listing-all-module-commands--help)
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


> 💡 Commands will be presented in the following format:
>
>> ### Command function : *keyword*
>>
>> Summary of actions involved.
>>
>> **Format:**<br>
>> `command format`
>>
>> **Example:** (if any)<br>
>> _table of interaction_
>>
>> **Result** - _outcome of command_ (if any)

&nbsp;

----

### Dashboard Commands
These are commands used on the dashboard layer, when no modules have been selected. Commands here deal with the creation of modules, as well as accessing modules.

&nbsp;

### Listing all dashboard commands : _help_

Lists out all commands that are available from the dashboard layer. Includes format and description for each command.

**Format:**<br>
`help`

&nbsp;

### Exiting the program : _exit_

Exits the program.

**Format:**<br>
`exit`

&nbsp;

### Opening a module : _open_

Opens the specified module.

**Format:**<br>
`open <module code>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | open CS2113T | |
|2| | Opening CS2113T.<br><br>\<Overview for CS2113T><br>Lecture - Friday 4pm - 6pm<br>Tutorial - Wednesday 9am - 10am<br><br>Undone tasks:<br>1. iP increments<br>2. Weekly exercises |

**Result** - GULIO moves from dashboard to module layer and the module CS2113T is loaded.

> 💡 Module name is auto-converted to uppercase, hence is not case-sensitive.

&nbsp;

### Adding a module : _add_

Adds a module with the specified module name.

**Format:**<br>
`add <module code>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | add CS2113T | |
| 2 | | Added CS2113T to the module list. |

**Result** - A new module called CS2113T is added.

> 💡 Module name is auto-converted to uppercase, hence is not case-sensitive.

&nbsp;

### Deleting a module : _delete_

Lists all modules and asks the user for indices of modules to delete. Then, deletes modules corresponding to indices specified.

**Format:**<br>
`delete`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | delete | |
| 2 | | Which modules would you like to delete?<br>1. CS2107<br>2. CS2113T<br>3. CS2101<br><br>Please enter the indices of the modules you would like to delete.<br>Separate indices with a blank space.
| 3 | 1 3 | |
| 4 | | Removed CS2107 from the module list.<br>Removed CS2101 from the module list. |

**Result** - Modules CS2107 and CS2101 are removed from the module list.

> 💡 Separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Listing all modules : _modules_

Lists all modules.

**Format:**<br>
`modules`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | modules | |
| 2 | | Modules in your list:<br>1. CS2101<br>2. CS2113T |

&nbsp;

----

### Module Commands

These are commands used on the module layer, when a module has been selected. Commands here deal with modifying the data corresponding to the specified module.

&nbsp;

### Listing all module commands : _help_

Lists out all commands that are available from the module layer.
Includes format and description for each command.

**Format:**<br>
`help`

&nbsp;

### Closing a module : _close_

Closes the current module and returns the user to the dashboard layer.

**Format:**<br>
`close`

&nbsp;

### Showing module information : _info_

Displays a summary of lessons and undone tasks for the module.

**Format:**<br>
`info`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | info | |
| 2 | | \<Overview for CS2113T><br>Lecture - Friday 4pm - 6pm<br>Tutorial - Wednesday 9am - 10am<br><br>Undone tasks:<br>1. iP increments - 22 Feb 2021 (Overdue by 32 days)

&nbsp;

### Adding a lesson : _add lesson_

Adds a new lesson with specified lesson type and information to the current module.

**Format:**<br>
`add lesson <lesson type> ;; <day & time>`<br>
`add lesson <lesson type> ;; <day & time> ;; <link>`<br>
`add lesson <lesson type> ;; <day & time> ;; <link> ;; <teaching staff name>`<br>
`add lesson <lesson type> ;; <day & time> ;; <link> ;; <teaching staff name> ;; <email>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | add lesson tutorial ;; Wednesday 9 am - 10am ;; https://nus-sg.zoom.us/j/abc | |
| 2 | | Added tutorial to lesson list. |

**Result** - Adds “tutorial” to the module's list of lessons, with specified details.

> ⚠ Only accepts 3 lesson types: “lecture”, “lab” and “tutorial”.

&nbsp;

### Deleting a lesson : _delete lesson_

Lists all lessons for the module and asks the user for indices of lessons to delete. Then, deletes lessons corresponding to the indices specified.

**Format:**<br>
`delete lesson`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | delete lesson | |
| 2 | | Which lessons would you like to delete?<br>1. lecture<br>2. tutorial<br><br>Please enter the indices of the lessons you would like to delete.<br>Separate indices with a blank space.
| 3 | 1 2 | |
| 4 | | Removed lecture.<br>Removed tutorial. |


**Result** - The lessons “lecture” and “tutorial” are removed from the list of lessons.

> 💡 Separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Editing a lesson : _edit lesson_

Lists all lessons for the module and asks the user for the index of the lesson to edit. Then, lists all editable fields and asks the user for the indices of the fields to edit. Lastly, for each selected field, the user inputs a new value.

**Format:**<br>
`edit lesson`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | edit lesson | |
| 2 | | Which lessons would you like to edit?<br>1. lecture - Wed 10am<br>&nbsp;&nbsp;&nbsp;&nbsp;www.zoom.com <br>&nbsp;&nbsp;&nbsp;&nbsp;Prof Isa<br>&nbsp;&nbsp;&nbsp;&nbsp;isa@gmail.com<br>2. Tutorial - Thursday 9am<br>&nbsp;&nbsp;&nbsp;&nbsp;www.zoom2.com <br>&nbsp;&nbsp;&nbsp;&nbsp;Hemrish Bundhoo<br>&nbsp;&nbsp;&nbsp;&nbsp;hemrish@nus.com |
| 3 | 1 | |
| 4 | | Editing: LECTURE<br>Which fields would you like to edit?<br>1. Time and day<br>2. Lesson link<br>3. Teaching staff name<br>4. Teaching staff email<br><br>Separate indices with a blank space. |
| 5 | 1 2 | |
| 6 | | Enter new time and day: | 
| 7 | Thursday 9am | |
| 8 | | Updated time and day.<br>Enter new lesson link |
| 9 | www.googleclassroom.com | |
| 10 | | Updated lesson link. |

**Result** - Edits time and day, as well as lesson link of "lecture".

> 💡 While only one lesson can be edited at a time, you can edit multiple fields simultaneously. As such, separate multiple indices with a space. Invalid indices will be ignored.

&nbsp;

### Opening lesson link : _link_

Lists all lessons in the module and asks the user for the indices of lesson links to open.
Then, opens the links of the lessons specified.

**Format:**<br>
`link`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | link | |
| 2 | | Which lesson’s link would you like to open?<br>1. lecture<br>2. tutorial |
| 3 | 1 | |
| 4 | | Opening lecture link in browser. |

**Result** - Opens the Zoom link used for lectures in a browser.

> 💡 Multiple links can be opened at once. As such, separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Listing all teaching staff : _teacher_

Lists all teaching staff for the module.

**Format:**<br>
`teacher`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | teacher | |
| 2 | | Teaching staff for CS2113T:<br>1. Prof Akshay - profakshay@email.com<br>2. Cheng Xianhao - cxh@email.com |

&nbsp;

### Listing all lessons : _lessons_

Lists all lessons for the module.

**Format:**<br>
`lessons`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | lessons | |
| 2 | | Lessons for CS2113T:<br>1. lecture - Friday 4pm - 6pm<br>&nbsp;&nbsp;&nbsp;&nbsp;https://nus-sg.zoom.us/j/def <br>&nbsp;&nbsp;&nbsp;&nbsp;Prof Akshay<br>&nbsp;&nbsp;&nbsp;&nbsp;profakshay@email.com<br>2. tutorial - Wednesday 9am - 10am<br>&nbsp;&nbsp;&nbsp;&nbsp;https://nus-sg.zoom.us/j/abc <br>&nbsp;&nbsp;&nbsp;&nbsp;meeting - Wednesday 2pm - 4pm |

&nbsp;

### Adding a task : _add task_

Adds a new task with specified name and information to the current module.

**Format:**<br>
`add task <name> ;; <deadline>`<br>
`add task <name> ;; <deadline> ;; <remarks>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | add task iP submission ;; 3-3-2021 ;; Remember to attach the jar file. | |
| 2 | | Is this task graded? (Y / N) |
| 3 | Y | |
| 4 | | Added iP submission to task list. | 

**Result** - Adds “iP submission” to the module’s  list of tasks, with the specified details.

> 💡 Deadline has to be in the DD-MM-YYYY format.

&nbsp;

### Deleting a task : _delete task_

Lists all tasks for the module and asks the user for indices of tasks to delete. Then, deletes tasks corresponding to the indices specified.

**Format:**<br>
`delete task`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | delete task | |
| 2 | | Which tasks would you like to delete?<br>1. weekly exercise<br>2. watch video snippets<br>3. lecture quiz<br>4. read up notes<br>5.  iP submission<br><br>Please enter the indices of the tasks you would like to delete.<br>Separate indices with a blank space. |
| 3 | 1 5 | |
| 4 | | Removed weekly exercise.<br>Removed iP submission. |

**Result** - The tasks “weekly exercise” and “iP submission” are removed from the list of tasks.

> 💡 Separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Editing a task : _edit task_

Lists all tasks for the module and asks the user for the index of the task to edit. Then, lists all editable fields and asks the user for the indices of fields to edit. Lastly, for each selected field, the user inputs a new value.

**Format:**<br>
`edit task`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | edit task | |
| 2 | | Which task would you like to edit?<br>1. weekly exercise - 23 Feb 2021<br>&nbsp;&nbsp;&nbsp;&nbsp;Do before 2359.<br>&nbsp;&nbsp;&nbsp;&nbsp;Graded<br>2. watch video snippets - 25 Feb 2021<br>&nbsp;&nbsp;&nbsp;&nbsp;Not graded<br>3. lecture quiz - 26 Feb 2021<br>&nbsp;&nbsp;&nbsp;&nbsp;Complete before next lecture.<br>&nbsp;&nbsp;&nbsp;&nbsp;Not graded |
| 3 | 3 | |
| 4 | | Editing: lecture quiz<br>Which fields?<br>1. Description<br>2. Deadline<br>3. Remarks<br>4. Graded/not graded<br><br>Separate indices with a blank space. |
| 5 | 2 3 | |
| 6 | | New deadline: |
| 7 | 2-3-2021 | |
| 8 | | Updated deadline.<br>New remarks: |
| 9 | Both quizzes 1 and 2. | |
| 10 | | Updated remarks. |

**Result** - Edits the deadline and remarks fields for the task “lecture quiz”.

> 💡 While only one task can be edited at a time, you can edit multiple fields simultaneously. As such, separate multiple indices with a space. Invalid indices will be ignored.

&nbsp;

### Marking task as done : _mark_

Lists undone tasks for the module and asks the user for the indices of tasks to mark as done. Then, marks all tasks corresponding to indices specified as done.

**Format:**<br>
`mark`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | mark | |
| 2 | | Which undone tasks have you completed?<br>1. weekly exercise<br>2. lecture quiz<br>3. read up notes<br><br>Please enter the indices of the tasks you would like to mark as done.<br>Separate indices with a blank space.
| 3 | 1 2 | |
| 4 | | Marked weekly exercise as done.<br>Marked lecture quiz as done. |

**Result** - The tasks “weekly exercise” and “lecture quiz” are marked as done.

> 💡 Separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Marking task as undone : _unmark_

Lists done tasks for the module and asks the user for the indices of tasks to mark as undone. Then, mark all tasks corresponding to indices specified as undone.

**Format:**<br>
`unmark`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | unmark | |
| 2 | | Which done tasks have you completed?<br>1. watch video snippets<br>2. iP submission<br><br>Please enter the indices of the tasks you would like to mark as done.<br>Separate indices with a blank space.
| 3 | 1 | |
| 4 | | Marked watch video snippets as undone. |

**Result** - The task “watch video snippets” is marked as undone.

> 💡 Separate indices with a space. Invalid indices will be ignored.

&nbsp;

### Listing all tasks : _tasks_

Lists all tasks for the module, where done and undone tasks are separated. Undone tasks are sorted by earliest deadline.

**Format:**<br>
`tasks`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | tasks | |
| 2 | | Tasks for CS2113T:<br><br>\[Undone]<br>You have completed all your tasks.<br><br>\[Done]<br>1.  iP Increment - 22 Feb 2021

&nbsp;
