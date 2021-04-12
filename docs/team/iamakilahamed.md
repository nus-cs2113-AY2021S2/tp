# A Akil Ahamed - Project Portfolio
## PROJECT: Control Your Crowd

## Overview
Control Your Crowd (CYC) is a desktop application used for managing crowd levels at any location or events.
The user interacts with it using a Command Line Interface (CLI). It is written in Java using the
Object-oriented programming (OOP) paradigm, and has about 5 kLoC.

Given below are my contributions to the project.

## Summary of contributions
* **New Features:** Added a function that requires the user to pass the maximum capacity of a location as a Command Line
argument.
  * What it does: allows the user to pass the maximum capacity of a location as a Command Line argument.
  * Justification: This feature helps to set the maximum capacity of the location instead of making the user set
  the maximum capacity later after CYC has started. This feature helps to quicken the starting process.
  * Highlights: This enhancement was challenging yet crucial in loading CYC. It poses a great difficulty as illegal 
  characters have to be taken into account in order to make sure the program does not crash.
  

* **Code contributed:** [RepoSense Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=iamakilahamed&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=AY2021S2-CS2113T-T09-1%2Ftp%5Bmaster%5D&groupSelect=groupByRepos&breakdown=true&since=2021-03-05&tabOpen=true&tabType=authorship&tabAuthor=iamakilahamed&tabRepo=AY2021S2-CS2113T-T09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&checkedFileTypes=docs~functional-code~test-code~other)


* **Enhancements to existing features:**
    * Added a first time registration feature for `checkin` command.
        * What it does: A visitor getting checked in for the first time has to be checked in using their ID, name and
          optionally phone number. Then, the next time the visitor can be checked in using just their ID.
        * Justification: This enhancement to the `checkin` command further improves the speed at which visitors would be
          checked in.
        * Highlights: This enhancement uses the data stored in the `LogFile.txt` to check if a visitor has already
          registered. The implementation depends on how the `LogFile.txt` is read and stored.


* **Project management:**
    * Collaborated with the team to manage releases of v1.0, v2.0 and v2.1 on GitHub.
    

* **Documentation:**
    * User Guide:
        * Added Table of Contents in the user guide
        * Added Introduction section in the user guide
        * Added Quick Start section in the user guide
    * Developer Guide:
        * Added Logic component in the developer guide
        * Added Instructions for manual testing section in the developer guide
        * Added Logic component sequence diagram and Logic component structure diagram
        * Added sequence diagram for the overall component interaction
    

* **Community:**
    * PRs reviewed (with non-trivial review comments): [#41](https://github.com/AY2021S2-CS2113T-T09-1/tp/pull/41), [#109](https://github.com/AY2021S2-CS2113T-T09-1/tp/pull/109), [#142](https://github.com/AY2021S2-CS2113T-T09-1/tp/pull/142)
    * Contributed to the user stories development
    * Released the second build, v2.0