# Owen Yip's Project Portfolio Page


## Overview
HealthVault is a hospital information recording system made for nurses. HealthVault is a desktop app for managing doctor, nurse, patient and inventory information, optimised for use through the command line interface. A user with fast typing skills would be able to navigate through the application with ease and at greater efficiency as compared to a normal database application. The program is written entirely in Java.

### Summary of Contributions

Given below are my contributions to the project

- **New Feature**: Created the Staff menu and functionality from scratch
    - What it does: To allow users to be able to manage the staff information within the hospital.
    - Justification: This functionality is created to optimize managing administrative tasks of coordinating personnel information in the hospital.
    - Highlights: This feature has been developed such that staff information is easily accessible by the user and desired information is displayed in a easily readable and user-friendly format. 

- **New Feature**: Added the feature of save and load
    - What it does: Data added or deleted from the staff list is instantaneously saved in a text file.
    - Justification: In the event of a system malfunction, the data from staff list would not be lost if the program was not exited properly. In addition, it would be terribly inconvenient for nurses to manually update the database each time there is a change in staff information. This feature solves the issue.
    - Highlights: There is no need to manually update the database. It has been automated for easy usage by the users.

- **New Feature**: Checking corruption of data
    - What it does: Data loaded from a text file is validated before added into the system.
    - Justification: In the event that the text file is corrupted by accident, the system will not display corrupted data. This prevents users from being misled by false information displyed by the application. 
    - Highlights: Due to the vulnerabilities of corrupted data files in this enhancement, extra data validation components had to be added to the reading of files. A safety checker is added in place to examine the data from the files to make sure that corrupted data is not registered by the system. 

- **New Feature**: Created the Smart Command Recognition feature from scratch
    - What it does: Reads in a certain input from the user and tries to match the user input with a relevant commands (All possible commands within a menu) for that particular menu. If the user input does not match any commands exactly, it will try to guess the user's intended input and prompt the user. If the user confirms the intended command (Command that is guessed by the algorithm), the menu will continue execution based on the intended command. Otherwise, it will register the user input as a unrecognised input.
    - Justification: Under high stress situation in the hospital, it is easy to make simple typing errors. Even if one is very skilled using the Command Line Interface (CLI), one will make errors. This feature tries to reduce situations that the whole line of data had to be re-entered due to a single error when typing the command. It save time and boost efficiency.
    - Highlights: There is even a feature to determine how strict the algorithm should be when determining the intended command. For example, if the allowance is set to a higher number, the feature will be less strict in its conditions for guesing the intended command. The algorithm design is orginal and created from scratch. As a result, the feature has been made to be able to be very flexible in its application. It is currently used in every single menu within HealthVault to enhance usability.


- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=blank-bank).

- **Contributions to documentation**:
    - User Guide:
        - Added documentation for the features `add`, `delete`, `list`, `return`, `help` in Staff. 
        - Edited Content Page.
        - Edited section "How to use the User Guide".
        - Edited section "Command Summary".
        - Edited section "Start Menu".
        - Edited section "Interpreting help commands".

    - Developer Guide:
        - Added implementation details of Staff, including all of its features.
        - Added section "Getting Started". 
        - Added section "Architecture"
        - Added Architecture Diagram.
        - Added Sequence Diagram for Staff Add.
        - Added Glossary Component.
        - Helped to vet the UML diagrams. 

- **Contributions to Team-Based Tasks**:
    - Leading project goals and deadlines
    - Coordinating project to-dos between members: #304, #300
    - Contributing common classes and functions: #163, #145, #141, #136, #130, #92, #76
    - General code enhancements: #311
    - Adjusting code for Java CI: #371
    - Release management: Released both v1.0 and v2.0. #204, #60
    - Maintained issue tracker with creation of labels 
    - Hardcore testing for everyone's code

- **Review/Mentoring contributions**:
    - PR's reviewed: 
    - Managing code structure for the entire project: #92. #20
    - Looking through other's code and bugfixed other's code: #205, #127
    - Help to vet UML diagrams and Sequence diagrams.

- **Contributions beyond the team**:
    - Helped find and reported bugs in other team's application
    - Sharing common mistakes made by other team's program
