# Alexander Tan's Portfolio Page

### Project: HealthVault

HealthVault is a hospital management system designed to help nurses manage their workflow. It is a desktop app capable of managing doctor, nurse, patient and inventory information, optimised for use through the command line interface. A user with fast typing skills will be able to navigate through the application with ease and greater efficiency as compared to a normal Graphical User Interface application. This program is written entirely in Java and has about 6 kLoC.

Given below are my contributions to the project.

- **New Feature**: Created the Schedules for Nurses menu and functionalities.
  - What it does: Provides the ability to add/delete/list schedules for different nurses. Schedules are sorted by date.
  - Justification: Being able to efficiently add/delete/list schedules allows nurses to quickly get into their workflow with minimal disruption, reducing downtime and wait-time of patients.
  - Highlights: The NurseSchedule Class implements the Comparable Interface allows the ordering of the Schedules to be sorted based on the compareTo() function. The sorting is so that the nurses will be able to view their next closest schedule on the application.

- **New Feature**: Added the ability to store and load data
  - What it does: Provides the ability for continuous usage, even after the program is terminated.
  - Justification: Nurses need to quickly get to work and it would not make sense for them to re-enter all their relevant schedules after terminating the program
  - Highlights: Due to the vulnerabilities of corrupted data files in this enhancement, extra data validation components had to be added to the reading of files. This ensures that the program does not deviate to far from normal operation should somebody tamper with the file.

- **New Feature**: Added Cross-Validation
  - What it does: Ensures that all schedules added are with valid Nurse ID's and Patient ID's (i.e present within the database)
  - Justification: If no checking is done across the different data files, schedules with non-existent Nurse ID's or Patient ID's will be added in to the system. This results in wasted resources and poor scheduling for nurses, something that this program aims to minimize.
  - Highlights: Due to the modular nature of our application, the loading of data files of other types was easy to implement. However, extra care had to be taken to ensure that these files were not corrupted as well.

- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=AlexanderTanJunAn).

- **Contributions to documentation**:
  - User Guide:
    - Added documentation for the features `add`, `delete`, `list`, `return`, `help` in Schedules for Nurses. [\#196](), [\#188](), [\#187](), [\#98]()
    - Added command summary. [\#117]()
    - Added application logo

  - Developer Guide:
    - Added implementation details of Nurse Schedules, including all of its features. [\#330](), [\#305](), [\#288]()
    - Added User Stories table [\#324]()
    - Added Model Component with diagram [\#324]()
    - Added Proposed Features section [\#364]()

- **Contributions to Team-Based Tasks**:
  - General code enhancements
  - Fixed Java CI
  - Maintained issue tracker with creation of some labels
  - Participated in rigorous testing of team members codebase to weed out potential bugs

- **Review/Mentoring contributions**:
  - PR's reviewed: #35, #171, #334, #333, #343, #349, #371, #401, #404, #407
  - Helped clarify teammates doubts on Version Control offline

- **Contributions beyond the team**:
  - Helped find and reported bugs on other products such as [iGraduate](https://github.com/AY2021S2-CS2113T-W09-2/tp)
  - Recommended possible solutions for bugs
  - Peer reviewed User Guides and Developer Guides of other teams and provided constructive feedback for improvement
