### Adding a cheat-sheet : _add cheat-sheet_

Adds a new cheat-sheet with specified name to the module.

**Format:**<br>
`add cheat-sheet <cheat-sheet name>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | add cheat-sheet lecture notes | |
| 2 | | lecture notes has been added to your Cheatsheet folder. |

**Result** - Adds new cheat-sheet “lecture notes” and opens it in the text editor.

> ⚠ Please do not include any file extension in the cheat-sheet name.

&nbsp;

### Deleting a cheat-sheet : _delete cheat-sheet_

Deletes the specified cheat-sheet from the module.

**Format:**<br>
`delete cheat-sheet <cheat-sheet name>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | delete cheat-sheet lecture notes | |
| 2 | | lecture notes has been deleted! |

**Result** - Deletes cheat-sheet “lecture notes”.

> ⚠ Please do not include any file extension in the cheat-sheet name.

&nbsp;

### Editing a cheat-sheet : _edit cheat-sheet_

Opens the specified cheat-sheet in the text editor.

**Format:**<br>
`edit cheat-sheet <cheat-sheet name>`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | edit cheat-sheet lecture notes | |
| 2 | | Opened lecture notes. |

**Result** - Opens cheat-sheet “lecture notes” in text editor.

> ⚠ Please do not include any file extension in the cheat-sheet name.

&nbsp;

### Listing all cheat-sheets : _cheat-sheets_

Lists all cheat-sheets for the module.

**Format:**<br>
`cheat-sheets`

**Example:**

| Step | Users Input | GULIOs Output |
| --- | --- | --- |
| 1 | cheat-sheets | |
| 2 | | Here is your list of cheat-sheets:<br><br>1. lecture notes |

&nbsp;

----

## Data & Storage

### Automatic Saving

Data for each module is stored in their respective module’s text file, located in a folder called “Data” created in the same directory as the GULIO.jar file. When moving this folder, please ensure that it is placed in the same directory as your GULIO.jar file. After every modification, changes are automatically saved to the file. 

### Manual Editing Outside of GULIO

Files can be modified outside of the program. Invalid inputs will not be loaded when the program is run and will be removed from the file. To ensure that your data loads properly, please follow the format stated in the data files strictly.

#### Format for Lessons:

1. `lesson | <type> | <Day & Time>`
1. `lesson | <type> | <Day & Time> | <Link>`
1. `lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name>`
1. `lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name> | <Teaching Staff Email>`

> ⚠ Only accepts 3 lesson types: “lecture”, “lab” and “tutorial”.

#### Format for Tasks:

1. `task | <description> | <deadline> | <is done> | <is graded>`
1. `task | <description> | <deadline> | <is done> | <is graded> | <remarks>`

> ⚠ For `<is done>` and `<is graded>`, use ‘T’ for true and ‘F’ for false.

&nbsp;

----

## Text Editor

GULIO comes with a built-in text-editor that allows you to edit cheat sheets directly. This text editor can be accessed via the add and edit cheat sheet commands. Cheat-sheets are stored in the “Cheatsheet” directory within their respective module directories as “.txt” files.

In the text editor, you can type in your notes in the text field. When done, remember to save any changes via the “ctrl-s” shortcut. To close the text editor, simply press the escape key on your keyboard. Using “ctrl-up” and “ctrl-down”, you can enlarge or shrink text respectively.

| Shortcuts | Actions |
| --- | --- |
| ctrl-s | Save cheat-sheet. | 
| ctrl-up | Enlarge text. |
| ctrl-down | Shrink text. |
| esc | Exit test editor |

> ⚠ Do not include file extension (e.g. .”.txt”) when creating or editing the cheat-sheet.

&nbsp;

----

## Command Summary

> 💡 Fields surrounded by "[]" are optional.

### Dashboard Commands Summary

| Keyword | Format |
| --- | --- |
| help | `help` |
| exit | `exit` |
| open | `open <module code>`|
| add | `add <module code>` |
| delete | `add  <module name>` |
| modules | `modules` |

### Module Commands Summary

| Keyword | Format |
| --- | --- |
| help | `help` |
| close | `close` |
| info | `info` | 
| add lesson | `add lesson <lesson type> ;; <day & time> ;; [link] ;; [teaching staff name] ;; [email]` |
| delete lesson | `delete lesson` |
| edit lesson | `edit lesson` |
| link | `link` |
| teacher | `teacher` |
| lessons | `lessons` |
| add task | `add task <name> ;; <deadline> ;; [remarks]` |
| delete task | `delete task` |
| edit task | `edit task` |
| mark | `mark` |
| unmark | `unmark` |
| tasks | `tasks` |
| add cheat-sheet | `add cheat-sheet <cheat-sheet name>` |
| delete cheat-sheet | `delete cheat-sheet <cheat-sheet name>` |
| edit cheat-sheet | `edit cheat-sheet <cheat-sheet name>` |
| cheat-sheets | `cheat-sheets` |

&nbsp;

----
