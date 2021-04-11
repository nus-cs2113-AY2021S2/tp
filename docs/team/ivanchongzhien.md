[<== Back to About Us](../AboutUs.md)

# Ivan Chong Zhi En - Project Portfolio Page

## Overview
We designed GULIO, a CLI-based module planner intended to help users keep track of tasks and assignment deadlines for the modules they are taking. GULIO also stores information like online lesson links and contact information of the module teaching staff, serving as a one stop location for essential module information.


## Summary of Contributions

[View code contribution](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=ivanchongzhien&tabRepo=AY2021S2-CS2113T-W09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

### Enhancements contributed

1. Implemented a parser to parse inputs to GULIO
   > Since the Parser class had a rather large scope where many other classes relied on it, I only focused on the Parser for v1.0 to ensure that the Parser was working reliably before we proceeded with more features.
   > As we made progress and the parser seemed stable, I also refactored the parser code with Isa to improve its flow and logic.
   
1. Implemented the edit lesson functionality
   > For version 2.0, I implemented the command which allowed users to edit the values of previously entered lessons.
1. Shortened GULIO commands
   > For version 2.1, we decided that some commands were too long and slowed the process of navigating and using GULIO.
   > I shortened several of the long commands words (e.g. "lesson" to "lsn") to improve the speed at which the user can enter inputs.

### Contributions to Documentation
1. As the one who implemented the edit lesson command, I covered the explanations and sample inputs for the edit lesson instruction.
1. I also updated the shortened commands in the User Guide to ensure consistency with our program.

### Contributions to the Developer Guide
1. Parser component in Design section.
   >I wrote the description for the Parser component under Design in the DG as I was the one who implemented it in our codebase.
1. Description and class diagram for the Model component in Design section.
   > I drew the class diagram for the Model component and contributed to its description.
1. Add lesson command class in Implementation section. 
   > I worked with Hemrish on describing the implementation of the add lesson command under the Implementation section.
   > I drew one of the sequence diagrams for this implementation.

### Contributions to team-based tasks
1. Did the release for v2.0.
1. Maintained issue tracker by adding issues found during discussion with the appropriate labels.

### Review/mentoring contributions
1. Full list of PRs approved or commented on by me can be found [here](https://github.com/AY2021S2-CS2113T-W09-3/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3A%40me).

2. Example of reviews where I communicated with teammates on Github:
   1. [Communication with Alicia and Hemrish regarding my PR](https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/77)
   1. [Review on Wen Hao's PR to use singleton class](https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/123)

### Contributions beyond the project team
1. [Raised question on forum](https://github.com/nus-cs2113-AY2021S2/forum/issues/15)
1. [Reported bugs during PE Dry Run](https://github.com/ivanchongzhien/ped/issues)

<div style="page-break-after: always;"></div>

## [Optional] Contribution to User Guide
Extract of contributions:

### Editing a lesson : _edit lsn_

Lists all lessons for the module and asks the user for the index of the lesson to edit. Then, lists all editable fields and asks the user for the indices of the fields to edit. Lastly, for each selected field, the user inputs a new value.

**Format:**<br>
`edit lsn`

**Example:**

| Step | When You Enter This: | You Get This: |
| --- | --- | --- |
| 1 | edit lsn | Which lessons would you like to edit?<br>1. lecture - Wed 10am<br>&nbsp;&nbsp;&nbsp;&nbsp;www.zoom.com <br>&nbsp;&nbsp;&nbsp;&nbsp;Prof Isa<br>&nbsp;&nbsp;&nbsp;&nbsp;isa@gmail.com |
| 2 | 1 | Editing: LECTURE<br>Which fields would you like to edit?<br>1. Time and day<br>2. Lesson link<br>3. Teaching staff name<br>4. Teaching staff email<br><br>Separate indices with a blank space. |
| 3 | 1 2 | Enter new time and day: |
| 4 | Thursday 9am | Updated time and day.<br>Enter new lesson link: |
| 5 | www.googleclassroom.com | Updated lesson link. |

**Result** - Edits time and day, as well as lesson link of "lecture".

> 💡 While only one lesson can be edited at a time, you can edit multiple fields simultaneously. As such, separate multiple indices with a space. Invalid indices will be ignored.

<div style="page-break-after: always;"></div>

## [Optional] Contributions to Developer Guide
Extract of contributions:

### Model component

<p align="center">
    <img width="973" src="../developerGuideImages/designModel.png" alt="Class Diagram of Model"><br>
    Figure 5 - Class Diagram of Model
</p>

The Model component consists of classes that represent real-world objects related to the program. `ModuleList` represents the various modules that a typical SOC student may be taking within the semester. Each of these modules is encapsulated in the `Module` class which contains an ArrayList of `Lesson` and `Task` objects representing the lessons that would be conducted for the module and tasks that students have to complete for the modules they are taking.

#### ModuleList:

`ModuleList` is responsible for managing loaded modules in the program and keeping track if a user is at the dashboard or within a selected module. `ModuleList` interacts with instances of the `Loader` and `Writer` class to load and write data respectively to the storage files. It also contains methods to sort data.

The `ModuleList` class contains the attributes:

* ArrayList of module code strings
* Class-level member storing `Module`

#### Module:

The `Module` class contains the attributes:

* Module code string
* ArrayList of `Lesson`
* ArrayList of `Task`

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

The `Task` class contains attributes related to an assignment, deadline or task in a university setting

* Description of task
* Deadline of task
* Remarks
* Done status
* Graded status

&nbsp;

---

### Add Lesson

The `AddLessonCommand` class is responsible for the creation and addition of a new `Lesson` object to the lesson list of a given module. The following sequence diagrams shows how a new `Lesson` is created and added to the lesson list.

<p align="center">
    <img width="973" src="../developerGuideImages/addLesson1.png" alt="parse() Sequence Diagram"><br>
    Figure 7 - parse() Sequence Diagram
</p>

The creation process is facilitated by the `Parser` class, which parses the appropriate arguments from the user input and initialises the `Lesson` object attributes with the parsed values.