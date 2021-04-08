# Lee Yang Peng- Project Portfolio Page

## Overview
This is a student project for university software development course.

I am one of the contributors to the FridgeFriend project.

## Project: FridgeFriend

FridgeFriend is an app for managing food in the fridge, optimised for use via a Command Line Interface (CLI).
If you can type fast, FridgeFriend can track your cold or frozen groceries faster and easier than any other apps.
It is written in Java.


## Summary of Contributions
Given below are my contributions to the project:

`v1.0 tasks`: In charge of implementing the skeletal version of FridgeFriend.

`v2.0 tasks`: Convert Food category into classes, Added History Command, Added List by Storage Location Command,
as well as associated JUnit tests and helper function code.

**Code contributed**: More than 1300 lines of code: [RepoSense Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=leeyp)

### New Features Implemented


**Version 1.0**
- Implemented the skeletal version of FridgeFriend.
- Created preliminary J-Unit tests for the `Food` Class.
- Contributed to defensive code by adding logging and assertion statements.

**Version 2.0**
- Converted Food category into classes
  - What it does: Reorganizes code architecture internally to differentiate different Food objects into 
    their various categories.
  - Justification: Useful for scalability when every food class has different attributes and behaviours, to be 
    explored in future work.
  - Pull request: ([#93](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/93))  

- Added the ability to list all Food by Storage Location
  - What it does: Given a user-specified and valid storage location in the Fridge, the program will display a 
    list of Food in that storage location.
  - Justification: Allows the user to view the all items stored in a specific storage location without opening the 
    fridge.
  - Pull request: ([#93](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/93))

- Added the ability to view a history of past additions of food to the fridge.
  - What it does: Displays a log that shows every addition of food to the fridge in chronological order.
  - Justification: Allows the user to track the food they have added to the fridge, which can help to plan and control 
    dietary habits.
  - Pull request: ([#131](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/131)), 
    ([#143](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/143))

**Version 2.1**
- Overhauled the `Storage` class in the `Utilities` component to improve input validation
  - What it does: Loads the data from the `fridgeData.txt`according to the appropriate format.
  - Justification: Allows users to input a wider range of characters as input strings (Food Name) while
    protecting the application from unexpected behaviour with modified data files.
  - Pull request: ([#208](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/208))

- Improved the validation of Food Category and Food Storage Location when user inputs data.
  - What it does: Invalid Food Category or Food Storage Location inputted by users will be rejected.
  - Justification: Improves clarity in application usage and reduces confusion by users.
  - Pull request: ([#207](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/207))

- Fine-tuned the ability to search by 'Others' category or storage location when user invokes `list` command.
  - What it does: Fixed the issue where user uses `list other` and the list only searches by Food category 'Other'.
  - Justification: Improves accuracy in the `list` command.
  - Pull request: ([#212](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/212))
  
**Enhancements to existing features**  
- Created JUnit tests & defensive code for:
  - Add Command
  - List Command
  - Search Command
  - History Command

- Refactored and improved Code Quality for:
  - Storage Class
  - Add Command
  - List Command


### Contributions to Documentation


- **User Guide**
    - Added documentation for the command `search` ([#72](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/72))
    - Added documentation for `list` by storage location ([#93](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/93))  
    - Updated Contents Page ([#130](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/130))
    - Updated List Command ([#130](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/130))
    - Updated Command Summary ([#130](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/130))  
    - Added documentation for the command `history` ([#131](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/131))
    - Added documentation for the command `history clear` ([#131](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/131))
- **Developer Guide**
    - Added Overall Architecture Section ([#94](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/94))
    - Added Exception Section ([#119](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/119))
    - Added Design and Implementation Section ([#129](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/129))
    - Added Instructions for Manual Testing Section ([#142](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/142))
        - Includes detailed testing instructions for all features in `FridgeFriend`
    - Added List Sequence Diagram and Implementation ([#148](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/148))

### Contributions to Team-based Tasks

- **Review/Mentoring Contributions**
  - Pull Requests reviewed with non-trivial review comments (non-exhaustive):
    - [#38](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/38),
    - [#41](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/41),
    - [#45](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/45),
    - [#58](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/58),
    - [#64](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/64),
    - [#66](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/66),
    - [#69](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/69),
    - [#108](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/108),
    - [#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134),
    - [#141](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/141),
    - [#147](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/147),
- Consolidated issues created during PE-D for the team and labelled issue trackers.
- Gave suggestions and help debug in weekly meetings

### Contributions beyond the project team:
- [Contributed to Class forum discussions](https://nus-cs2113-ay2021s2.github.io/dashboards/contents/forum-activities.html#1-lee-peng-leeyp-21-posts)
  - Rank 1 on Class Leaderboard as of 5 April 2021.
    - Examples of Class Forum Contributions:
        - [Helping others](https://github.com/nus-cs2113-AY2021S2/forum/issues/3#issuecomment-762286714)
        - [Contributing to Discussion](https://github.com/nus-cs2113-AY2021S2/forum/issues/13#issuecomment-766749214)
        - [Raising Public issues to Prof so that all can benefit](https://github.com/nus-cs2113-AY2021S2/forum/issues/42)
- Contributing with correct answers frequently in tutorials
- Discovered many bugs in peers' Team Project during PE-Dry Run