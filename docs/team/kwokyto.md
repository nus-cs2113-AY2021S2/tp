# Ryan Kwok - Project Portfolio Page

## Overview

This is a student project for university software development course.
I am one of the contributors to the `FridgeFriend` project.

## Project: `FridgeFriend`

`FridgeFriend` is an app for managing food in the fridge, optimised for use via a Command Line Interface (CLI).
If you can type fast, `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
It is written in Java, and has more than 4.3kLoC.

## Summary of Contributions

Given below are my contributions to the project

### New Features

- Added the ability to display a help message
  - What it does: Provides the user with a list of available commands and formats.
  - Justification: Allows the user the ease of using commands without having to memorise them.
  - Pull request: ([#49](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/49))

- Added the ability to search for items that are expiring
  - What it does: Allows the user to get a list of all food items that are going to expire in a week.
  - Justification: Improves the product signicantly because a user can effectively track the status of all food items in the fridge with a single command.
  - Pull request: ([#66](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/66))

- Added a warning feature for food that is running low
  - What it does: Sends the user a warning if a removal of a food item brings the total food quanitity of that category below a specified limit.
  - Justification: Allows the user to better track the relative quantity of food in the fridge.
  - Pull request: ([#112](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/112))

- Added the ability to list all food categories that are running low
  - What it does: Provides the user with a list of food categories that have food quanities below the specified limit
  - Justification: Allows the user to easily create a shopping list of items based on food categories
  - Pull request: ([#114](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/114))

- Added the ability for users to specify the minimum quantity of food for each category
  - What it does: Allows the user to modify the lower quantity limit for each category
  - Justification: Allows for personalisation of fridge, since different users have differing requirements and preferences for the quantity of each food category
  - Pull request: ([#115](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/115))

- Code contributed: more than 1900 lines of code ([RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=kwokyto))

### Enhancements to Existing Features

- Wrote and refactored major classes ([#44](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/45))
  - `Fridge`
  - `Parser`
  - `Ui`
  - `ByeCommand`
  - `InvalidIndexException`
  - `InvalidInputException`
- Wrote additional tests for `Parser` class ([#47](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/47))
- Wrote `Logger` class ([#51](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/51))
- Wrote logging for `FridgeFriend` ([#52](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/52))
- Improve Coding Standards for `Storage` class ([#68](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/68))

### Documentation

- User Guide
  - Added introduction ([#75](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/75/))
  - Added documentation for the feature `expiring` ([#69](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/69))
  - Added documentation for the features `remove`, `help`, and `bye` ([#75](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/75/))
  - Standardised input/output format for existing documentation of all features ([#75](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/75/))
  - Added documentation for the features `runninglow` and `setlimit` ([#106](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/106))
- Developer Guide
  - Added implementation details of the `Utilities` component ([#106](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/106))
    - [Utilities Class Diagram](../diagrams/diagram_images/UtilitiesClassDiagram.png)
  - Added implementation details of the main application logic ([#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134))
    - [Main Logic Sequence Diagram](../diagrams/diagram_images/MainLogicSequenceDiagram.png)
  - Added User Stories ([#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134))
  - Added a contents list ([#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134))
  - Adjusted Diagram Sizes ([#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134))
- README.md
  - Wrote all project details and contents ([#134](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/134))

### Community

- Pull Requests reviewed with non-trivial review comments (
    [#38](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/38),
    [#54](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/54),
    [#56](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/56)
    [#61](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/61),
    [#93](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/93),
    [#94](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/94),
    [#108](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/108),
    [#110](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/110),
    [#119](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/119),
    [#131](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/131),
    [#140](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/140),
    [#202](https://github.com/AY2021S2-CS2113-T10-1/tp/pull/202))
- Contributed to forum discussions (
    [1](https://github.com/nus-cs2113-AY2021S2/forum/issues/23),
    [2](https://github.com/nus-cs2113-AY2021S2/forum/issues/30),
    [3](https://github.com/nus-cs2113-AY2021S2/forum/issues/45),
    [4](https://github.com/nus-cs2113-AY2021S2/forum/issues/49),
    [5](https://github.com/nus-cs2113-AY2021S2/forum/issues/53))
- Reported bugs and suggestions for other teams in the class (
    [1](https://github.com/nus-cs2113-AY2021S2/tp/pull/64))
