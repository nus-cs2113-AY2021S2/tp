
## Design

### Architecture

<p align="center">
    <img width="973" src="developerGuideImages/architecture.png" alt="Architecture Diagram"><br>
    Figure 2 - GULIO Architecture Diagram
</p>

`Duke` contains the main method which is required by Java to run the application. It is responsible for instantiating and calling methods from the `UI`, `Parser` and `Command` components.

Apart from `Duke`, the application consists of the following components:

* `UI`: Handles reading and printing
* `Parser`: Validates and checks user input
* `Command`: Executes commands
* `Model`: Consists of data related to the application
* `Storage`: Handles loading and storing of data into text files
* `Editor`: Graphical interface for users to type
* `Common`: collection of classes used by multiple components.


GULIO is a local application that stores its application data using readable text files, allowing users the flexibility of viewing and editing data locally.

The way GULIO runs and handles user input can be described as follows:

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="Sequence Diagram"><br>
    Figure 3 - GULIO Sequence Diagram
</p>

Upon start, the main class calls run() which enters a while loop and reads in user input. In the loop, the Parser component processes the user input into various commands implemented in GULIO. The loop ends when the user enters exit.

&nbsp;

### UI component

**API**: `UI.java`

* Facilitates the CLI interface
* Methods to display general messages, prompt messages and error messages
* Reads in user’s input, and used by Command classes to react to user’s inputs
* The UI object created as an attribute in Duke is passed into each command to be executed
* Instances of UI are used by tests in general

&nbsp;

### Parser component

**API**: `Parser.java`

* Determines the command entered by the user

* Parses the parameters needed by the `Command` object (for commands which require additional details)

* Checks the validity of parsed parameters, in some instances calling methods from other relevant classes, e.g. calling a method from the `Lessons` class to verify parsed lesson links.

* May instruct `UI` to print warnings and prompts to users, e.g. when users enter invalid parameters.

* Returns a new `Command` object with all the necessary attributes filled

&nbsp;

### Command component

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="Dual Layer Command System"><br>
    Figure 4 - Visualisation of Dual Layer Command System
</p>

**API**: `Command.java`

The `Command` component is an abstract class with methods that all commands inherit from. They can be further distinguished by commands that are used when the user is at the dashboard or when the user is within a module specified.

Steps for command execution:

1. The `Parser` after validating user input returns a `Command` object
1. Each `Command` object has an execute method and gets executed by `Duke`
1. Depending on the command, it may make changes to the objects within `Model`
1. If there are changes, `Model` then updates application data via the `Storage` component
1. The `UI` prints user information related to the command executed


&nbsp;

### Model component

<p align="center">
    <img width="973" src="developerGuideImages/file.png" alt="Class Diagram of Model"><br>
    Figure 5 - Class Diagram of Model
</p>

The Model component consists of classes that represent real-world objects related to the program. `ModuleList` represents the various modules that a typical SOC student may be taking within the semester. Each of these modules is encapsulated in the `Module` class which contains an ArrayList of `Lesson` and `Task` objects representing the lessons that would be conducted for the module and tasks that students have to complete for the modules they are taking.

#### ModuleList:

`ModuleList` is responsible for managing loaded modules in the program and keeping track if a user is at the dashboard or within a selected module. `ModuleList` interacts with the `Loader` and `Writer` components to load and write data respectively to the storage files. It also contains methods to sort data that after loading and before writing.

The `ModuleList` class contains the attributes:

* ArrayList of module code strings
* Class-level member storing `Module`

#### Module:

The `Module` class contains the attributes:

* Module code string
* ArrayList of `Lesson`
* ArrayList of `Task`