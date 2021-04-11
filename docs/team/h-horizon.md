[<== Back to About Us](../AboutUs.md)

# Hemrish Bundhoo - Project Portfolio Page

## Overview

GULIO is a module planner designed for efficiency when used by someone that can type fast. It is capable of storing lessons and tasks for individual modules, as well as lesson notes via cheat-sheets.

## Summary of Contributions

[Click here to view code contribution.](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=CS2113T-W09-3&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=H-horizon&tabRepo=AY2021S2-CS2113T-W09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

### Enhancements Contributed:

1. Implemented commands involved in manipulating Lesson objects, excluding edit lesson.<br>
   > I implemented AddLessonCommand, DeleteLessonCommand and ListLessonsCommand to add, remove and view lesson objects.
1. Implemented OpenLessonListCommand.
   > I implemented this class that allows the user to open the link, inputted when creating a lesson, in a web browser. The issue I had to resolve was that the default command to open a link in a browser was platform dependent. 
1. Implemented ViewTeachingStaffCommand
   > I implemented the command needed to view the tutor's name and email address for a particular lesson.
1. Implemented ModuleInfoCommand
   > I implemented this command to print a summary about a module. 
1. Implemented commands involved in manipulating Cheat-sheet files.<br>
   > I implemented AddCheatSheetCommand, DeleteCheatSheetCommand, EditCheatSheetCommand and ListCheatSheetCommand to add, remove, edit and view Cheat-sheet files of a particular module.
1. Implemented TextEditor.
   > I implemented the TextEditor class to allow the user to input and edit cheat-sheets. A problem I faced when implementing the editor was that if the editor was used multiple times for one Gulio Session, it didn't flush data from previous files after they were closed. I then had to append the text area to null each time the text editor was invoked.

### Contributions to Documentation:

1. Documented Lesson and Cheat-sheet commands
   > For each command I implemented, I added a brief description, the command format, a sample input and the expected output.
1. Added text editor section.
   > As the one responsible for the text editor, I did the part explaining to the user how GULIO's text editor works and what he/she can do with it. 

### Contributions to Developer Guide:
1. Text Editor component in Design section.
   >I wrote the description for the text editor component under Design in the DG as I was the one who implemented it in our codebase.
1. Add lesson command class in Implementation section.
   > I drew two of the sequence diagrams describing the implementation of the add lesson command under the Implementation section.

   
### Contribution to Team-Based Tasks:

1. Fixed minor bugs for some components.
1. Maintained issue tracker.

### Review/mentoring contributions:
1. Full list of PRs approved or commented on by me can be found [here](https://github.com/AY2021S2-CS2113T-W09-3/tp/pulls?q=is%3Apr+reviewed-by%3AH-horizon+is%3Aclosed+).

### Contributions Beyond the Team
1. [Sharing useful information in the forum](https://github.com/nus-cs2113-AY2021S2/forum/issues/26#issuecomment-770166991)
1. [Bugs reported in other team's products during dry-run](https://github.com/H-horizon/ped)

<div style="page-break-after: always;"></div>

## Contributions to the User Guide (Extracts)[Optional]
Extract of contributions:

### Adding a lesson : _add lsn_

Adds a new lesson with specified lesson type and information to the current module.

**Format:**<br>
`add lsn <lesson type>`<br>
`add lsn <lesson type> ;; <day & time>`<br>
`add lsn <lesson type> ;; <day & time> ;; <link>`<br>
`add lsn <lesson type> ;; <day & time> ;; <link> ;; <teaching staff name>`<br>
`add lsn <lesson type> ;; <day & time> ;; <link> ;; <teaching staff name> ;; <email>`

**Example:**

| Step | When You Enter This: | You Get This: |
| --- | --- | --- |
| 1 | add lsn tutorial ;; Wednesday 9 am - 10am ;; https://nus-sg.zoom.us/j/abc | Added tutorial to lesson list. |

**Result** - Adds “tutorial” to the module's list of lessons, with specified details.

> ⚠ Only accepts 3 lesson types: “lecture”, “lab” and “tutorial”.

> 💡 To skip an input, leave a blank in between the field separators. For example,
>
> `add lesson tutorial ;; ;; ;; Prof Akshay ;; akshay@email.com`
>
> will add “tutorial” to the module's list of lessons with only the given teaching staff name and email. The fields “day & time” and “link” were skipped.
>
> Note: “lesson type” cannot be skipped.

&nbsp;

<div style="page-break-after: always;"></div>

### Contributions to the Developer Guide (Extracts)[Optional]

Extract of contributions:

### Editor component

**API**: `TextEditor.java`

The _Editor_ component is responsible for opening the text editor to add or edit cheat-sheets/notes. It consists of two classes:

#### Text Editor

* Sets up the text editor
* Loads existing file from Cheatsheet directory within a module for the edit cheat-sheet command
* Flushes out the text from the editor when a different or new file is opened.
* Adjusts the font size of the text within the editor
* Detects mouse input to change font style and save the text
* Saves the text from the text editor into a file

#### ShortcutListener

* Detects keyboard input for shortcuts

&nbsp;

<p align="center">
    <img width="973" src="../developerGuideImages/addLessonCommand.png" alt="AddLessonCommand Constructor Sequence Diagram"><br>
    Figure 8 - AddLessonCommand Constructor Sequence Diagram
</p>

The newly created `Lesson` object is then passed to a new `AddLessonCommand` object as an argument.

<p align="center">
    <img width="973" src="../developerGuideImages/add_lesson_to_lesson_list.png" alt="execute() AddLessonCommand Sequence Diagram"><br>
    Figure 9 - execute() AddLessonCommand Sequence Diagram
</p>

`AddLessonCommand` then adds the `Lesson` object to the lesson list of a module. The lessons in the list are sorted by their lesson types each time a new lesson is added. `AddLessonCommand` also calls the `writeLesson()` method of `ModuleList` to update the change locally.

&nbsp;



