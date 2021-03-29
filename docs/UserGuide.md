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
