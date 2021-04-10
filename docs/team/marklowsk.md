# Mark Low Seng Keong's Project Portfolio Page

---

## Overview
Finux is a Command-Line Interface (CLI) application that allows you to record your expenses, savings and loans all
in one consolidated platform. With these information made readily available at your fingertips, it will allow you to
better adjust your expenditure or work harder towards your savings goal. Finux also includes a way for you to keep
track of the loans you have made to your friends, or the tabs for the dinners you have paid for first.

As the Finux application is inspired entirely by the *Nix operating systems, and if you are familiar with the CLI
command interface, you will definitely enjoy the benefits of the application. You will also be able to speed up your
financial management and planning with the Finux application as compared to the traditional finance management
applications in the market.

Finux was designed with the intention of speeding up one's finance management by integrating the usual fields in
finance management applications with a new loan and creditscore feature that is implemented by us. Coupled with the
fact that Finux is also made to be cross-platform, users can easily use and port their data over should they decide to
use another personal computer.

---

## Summary of Contributions

### Code Contribution

Contributions can be found on [RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=marklowsk&tabRepo=AY2021S2-CS2113T-W09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code).

---

### Contribution to Implementation

* Code contributions
    * Class `CommandHandler.java`
    * Class `Command.java` (abstract) and its child classes (base version)
    * Class `AddCommand.java`
    * Class `Utils.java`
    * Enumerations `ArgumentType.java` and `RecordType.java`
    * others

#### CommandHandler class
To kick off the coding of the project, Andy and I started early by planning on the 
style of parsing user input and command handling. We decided to follow the parsing 
style similar to the [Apache Commons CLI 1.4](https://commons.apache.org/proper/commons-cli/).
We initially tested the Commons CLI library, but it was rather basic, and we rather 
have our own control over parsing and command handling. Andy was in-charged of the
ParserHandler, while I started with CommandHandler and Command classes. With Andy's 
parsing technique being refined over the iterations, the CommandHandler had much 
more reliable parsed data to handle. By separating the parser and command creation, 
this increases cohesion.

#### Command classes
Following what I've learnt in iP, I applied the same strategy to the Command class 
structure. This is the cleanest and simplest implementation, inspiration from AB-3. 
Discussed this implementation with Jonah.

#### AddCommand class
To re-distribute the workload, I decided to do less on the logic of each command, 
and decided to help contribute to the AddCommand class, focusing on the validation 
of the arguments.

#### Utils class
By focusing more on argument validation, I've decided to place the commonly used 
validation methods into the Utils class. These validation methods are to ensure 
that argument types are properly enforced, like option validation and option value 
validation.

#### Others
Most notably, the DateFormat and Command validation process.

---

### Contributions to UG
Add explanations for the command formats and notation, date format, and the add feature. 
Was in-charged of the command summary, later edited and refined by Gerard.

---

### Contributions to the DG
Documented the Architecture, and the Command handler and Command Components.
Also worked on the AddCommand Implementation. This includes the UML class,
object and sequence diagrams.

Other contributions to the DG are:
* Starting off with the PlantUML diagrams, using it as our documentation
  standard.

---

### Contributions to Team-based Tasks

1. Vetting of UG & DG.
1. General code enhancements.
1. Bug hunting the team's features and components.
1. Discussing bugs and fixes with teammates.
1. Maintained a small portion of issues in the issue tracker.
1. Maintaining early communication with teammates, regarding features.

---

### Contributions Beyond Project Team

1. Bug hunting on other team's applications.
1. Discussed with other teams on better ways to improve both our application.
