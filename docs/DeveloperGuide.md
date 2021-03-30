#### Lesson:

In SOC, lessons are conducted by a combination of lectures, tutorials or labs. To enforce this constraint, the Enum class `LessonType` contains a set of constants for lecture, tutorial and lab.

The `Lesson` class contains attributes related to a typical course lesson:

* Lesson Type, e.g. lab, tutorial or lecture
* Time and day of the lesson (stored as a String for flexibility)
* Link for online lessons
* Teaching Staff information encapsulated in `TeachingStaff`

#### Teaching staff:

Being enrolled in several modules, it would be useful for students to store names of the teaching staff the way they prefer to be addressed along with their email addresses in events that require the student to call upon or inquire a teaching staff for a module.

The `TeachingStaff` class contains the attributes related to the teacher(s) of a particular lesson:

* Name of the teacher
* Email address of the teacher

#### Task:

The Task class contains attributes related to an assignment, deadline or task in a university setting

* Description of task
* Deadline of task
* Remarks
* Done status
* Graded status

&nbsp;

### Storage component

<p align="center">
    <img width="973" src="developerGuideImages/storage.png" alt="Storage Structure"><br>
    Figure 6 - Illustration of Storage Structure
</p>

The storage component is responsible for creating and loading modules and their respective data, as well as saving the data each time a change is made. It consists of two components: Loader and Writer. At every moment, the loader only loads up to 1 module at a time and data for each module is stored separately. This is done to ensure fast loading and writing of files.

#### Loader:

* Loads the list of modules from the “Data” directory
* Loads lesson and task data from the selected module’s “.txt” file

#### Writer:

* Creates all the directories required
* Deletes files and directories
* Creates the “.txt” file that saves the module’s lessons and tasks
* Writes changes to the “.txt” file that saves the module’s lessons and tasks

&nbsp;

### Editor component

**API**: `TextEditor.java`

The editor component is responsible for opening the text editor to add or edit cheat-sheets/notes. It consists of two components:

#### Text Editor

* Sets up the editor
* Loads existing file from Cheatsheet directory within a module for the edit cheat-sheet command
* Flushes out the text from the editor when a different or new file is opened.
* Adjusts the font size of the text within the editor
* Detects mouse input to change font style and save the text
* Saves the text from the text editor into a file

#### ShortcutListener

* Detects keyboard input for shortcuts

&nbsp;

### Common classes

Classes that are used by multiple components:
* CommonMethods: Stores methods that are used by multiple components
* Constants: Stores constants
* Messages: Stores strings that are printed by the UI
* DashboardCommands: Enum of commands that can be used outside a module
* ModuleCommands: Enum of commands that can be used inside a module

&nbsp;

----

## Implementation

In this section, we highlight a few of the key features whose implementations are reflective of most of the commands available, as well as those that are more unique to GULIO.

### Add Lesson

The AddLessonCommand class is responsible for the creation and addition of a new Lesson object to the lesson list of a given module. The following sequence diagrams shows how a new Lesson is created and added to the lesson list.

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="parse() Sequence Diagram"><br>
    Figure 7 - parse() Sequence Diagram
</p>

The creation process is facilitated by the Parser class, which parses the appropriate arguments from the user input and initialises the Lesson object attributes with the parsed values.

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="AddLessonCommand Constructor Sequence Diagram"><br>
    Figure 8 - AddLessonCommand Constructor Sequence Diagram
</p>

The newly created Lesson object is then passed to a new AddLessonCommand object as an argument.

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="execute() AddLessonCommand Sequence Diagram"><br>
    Figure 9 - execute() AddLessonCommand Sequence Diagram
</p>

AddLessonCommand then adds the Lesson object to the lesson list of a module. The lessons in the list are sorted by their lesson types each time a new lesson is added. AddLessonCommand also calls the writeLesson method of ModuleList to update the change locally.

&nbsp;
