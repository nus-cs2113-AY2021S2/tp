# Mark Low Seng Keong's Project Portfolio Page

---

## Overview
Finux is a Command-Line Interface (CLI) application that allows you to record your expenses, savings and loans all in one consolidated platform.
It enhances the user experience by integrating of different features into one to remove the hassle of constantly using different applications.

---

## Summary of Contributions

### Code Contribution

Contributions can be found on [RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=marklowsk&tabRepo=AY2021S2-CS2113T-W09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code).

---

### Contribution to Implementation

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
