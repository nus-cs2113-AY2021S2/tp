
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
