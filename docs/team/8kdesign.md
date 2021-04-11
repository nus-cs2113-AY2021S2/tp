[<== Back to About Us](../AboutUs.md)

# Chong Wen Hao - Project Portfolio Page

## Overview

GULIO is a module planner designed for efficiency for people that can type fast. It is capable of storing lessons and tasks for individual modules, as well as lesson notes via cheat-sheets. 

## Summary of Contributions

[Click here to view code contribution.](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=CS2113T-W09-3&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=8kdesign&tabRepo=AY2021S2-CS2113T-W09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

### Enchancements Contributed:

1. Implemented ModuleList class and storage system, excluding cheat-sheets.<br>
1. Implemented shortcut listener for text editor.
   > Using KeyListener, I implemented shortcuts such as "ctrl-s" to save. The shortcuts would call methods that Hemrish created in the TextEditor class.
1. Cleaned up code for most components.<br>
   > I cleaned up the code after we merged our parts for V1.0 as there were inconsistencies and duplicates. This includes shifting of constants and messages to their respective classes, removing of duplicate methods, etc...
1. Added days remaining for undone task and used it for sorting.

### Contributions to Documentation:

1. Added data & storage section.
1. Created skeleton for the command section.
1. Converted user guide from Google Docs into Markdown.
   > The team originally did the user guide on Google Docs. I converted it to markdown before we split it up and pushed our respective portions. It was really tedious, but not difficult.

### Contributions to Developer Guide:

1. Created the architecture diagram and did the parts relating to storage.
1. Added instruction for manual testing.
1. Converted developer guide from Google Docs into Markdown.
   > Like the user guide, we did the developer guide on Google Docs. I converted it into markdown before splitting it up with the others.

### Contribution to Team-Based Tasks:

1. Did the release for V1.0.
1. Fixed minor bugs for some components.
   > Examples include [fixing the formatting of various list commands](https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/74/files), as well as [getting focus for the text editor](https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/130/files).  
1. Created issues and added labels on the issue tracker.

### Review/mentoring contributions:

1. Reviewed pull requests.<br>
   > Examples: 
   > 1. https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/129
   > 1. https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/125
   > 1. https://github.com/AY2021S2-CS2113T-W09-3/tp/pull/43
1. Helped Hemrish resolve some issues regarding cheat-sheets.

### Contributions Beyond the Team
1. Identified bugs during dry run PE. Click [here](https://github.com/8kdesign/ped/issues) to view.
1. Answered a few question on the forum.
   > Examples:
   > 1. https://github.com/nus-cs2113-AY2021S2/forum/issues/2
   > 1. https://github.com/nus-cs2113-AY2021S2/forum/issues/11

<div style="page-break-after: always;"></div>

## [Optional] Contributions to User Guide

Example of parts that I wrote:

> # Data & Storage
>
> ### Automatic Saving
>
> Data for each module is stored in their respective module’s text file, located in a folder called “Data” created in the same directory as the GULIO.jar file. When moving this folder, please ensure that it is placed in the same directory as your GULIO.jar file. After every modification, changes are automatically saved to the file.
>
> ### Manual Editing Outside of GULIO
> 
> Files can be modified outside of the program. Invalid inputs will not be loaded when the program is run and will be removed from the file. To ensure that your data loads properly, please follow the format stated in the data files strictly.
> 
> #### Format for Lessons:
>
> 1. `lesson | <type> | <Day & Time>`
> 1. `lesson | <type> | <Day & Time> | <Link>`
> 1. `lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name>`
> 1. `lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name> | <Teaching Staff Email>`
> 
> > ⚠ Only accepts 3 lesson types: “lecture”, “lab” and “tutorial”.
> 
> #### Format for Tasks:
> 
> 1. `task | <description> | <deadline> | <is done> | <is graded>`
> 1. `task | <description> | <deadline> | <is done> | <is graded> | <remarks>`
> 
> > ⚠ For `<is done>` and `<is graded>`, use ‘T’ for true and ‘F’ for false.

<div style="page-break-after: always;"></div>

## [Optional] Contributions to Developer Guide

Example of parts that I wrote:

> ### Loading & Storing of Data
> 
> This section covers how the _Storage_ component works, from the loading of all module codes to the loading of individual module and creation of data files.
> 
> #### Saving of Data
> 
> The `Writer` class is responsible for writing any changes to the module’s data file, as well as creating the file itself. Interaction with the `Writer` class is done through the `ModuleList` class, whose methods are called by the other components of the app.
> 
> <p align="center">
>    <img width="973" src="../developerGuideImages/writeModule.png" alt="writeModule() Sequence Diagram"><br>
>    Figure 11 - writeModule() Sequence Diagram
> </p>
> 
> Whenever some data in a module changes, the command that made those changes would call the method `writeModule()` in `ModuleList` to update the change in the data file. This method would then call a method of the same name in the `Writer` class, which overwrites the existing data in the file with the new data.
> 
> Due to how much data needs to be written each time, we decided to split the data file by module. That way, we only need to overwrite the module's data when changes are made.
> 
> #### Loading of Data
> 
> The `Loader` class is responsible for identifying all the modules currently added, as well as loading the data file of the selected class. Methods in the `Loader` class are accessed by the other components via the `ModuleList` class.
> 
> <p align="center">
>    <img width="973" src="../developerGuideImages/loadModuleCode.png" alt="loadModuleCodes() Sequence Diagram"><br>
>    Figure 12 - loadModuleCodes() Sequence Diagram
> </p>
> 
> To identify modules in the “Data” directory, Duke would call `loadModuleCodes()` method in the `ModuleList`. This method would then call the `getModules()` method in `Loader`, which returns a list of module codes. For each of the identified module code, `ModuleList` would call its own `insertModule()` method to add it to the module list.
> 
> <p align="center">
>    <img width="973" src="../developerGuideImages/setSelectedModule.png" alt="setSelectedModule() Sequence Diagram"><br>
>    Figure 13 - setSelectedModule() Sequence Diagram
> </p>
>
> When a module is selected via the `setSelectedModule()` method, the specified module code would be searched for in the module list. If it is inside, `loadModule()` method in the `Loader` would be called. This method reads the module’s data file for data and adds them into a new instance of `Module` class. This `Module` is then returned to `ModuleList` and set as the selected module.
>
> If the `Loader` failed to load the file, null would be returned. If null is not returned, `ModuleList` would sort the data and then use `Writer` to override the existing file. This is done to remove invalid entries that were initially in the file.
