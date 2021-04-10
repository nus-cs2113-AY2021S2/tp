# Kwek Ming Shun's Project Portfolio Page

## Overview
HealthVault is a hospital information recording system made for nurses. HealthVault is a desktop app for managing doctor, nurse, patient and inventory information, optimised for use through the command line interface. A user with fast typing skills would be able to navigate through the application with ease and at greater efficiency as compared to a normal database application. The program is written entirely in Java.

### Summary of Contributions

Given below are my contributions to the project

- **New Feature**: Created the Doctors' Appointment menu and functionality from scratch
    - What it does: To allow current and new patients to make a doctor's appointment with a doctor registered in the hospital.
    - Justification: This functionality is created to optimize the appointment making process in hospital
    - Highlights: This feature has been developed as a database where appointment information is easily accessible by the user and desired information is displayed in a easily readable and user-friendly format.

- **New Feature**: Added the feature of save and load
    - What it does: Data added or deleted from the appointment list is instantaneously saved in a text file.
    - Justification: In the event of a system malfunction, the data from appointments would not be lost if the program was not exited properly. In addition, it would be terribly inconvenient for nurses to manually take down and upload all appointments of the day. This feature solves the issue.
    - Highlights: Due to the vulnerabilities of corrupted data files in this enhancement, extra data validation components had to be added to the reading of files. A safety checker is added in place to examine the data from the files to make sure that corrupted data is not registered by the system.

- **New Feature**: Added Cross-Validation
    - What it does: Ensures that all appointments added into the system is assigned to a doctor that is registered and present in the hospital (i.e present within the database). The system will reject the addition of an appointment if the Doctor's ID is not found in the staff database.
    - Justification: This is to prevent as miscommunication between the hospitals and the patients, ensuring that all appointments made will be seen through without issues (i.e the doctor is not on duty that day or the desired doctor is not working at the queried hospital).
    - Highlights: The program includes a staff database that is implemented by other team members, making the use of cross validation easier to implement and more applicable to today's issue. This demonstrates a cohesive system. However, this feature depends on the staff data in the system and will prevent addition of appointment if there is corrupted staff data.

- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=MingShun98).

- **Contributions to documentation**:
    - User Guide:
        - Added documentation for the features `add`, `delete`, `list`, `return`, `help` in Doctors' Appointment. [\#9710558](), [\#51fa4c6](), [\#0e513a6](), [\#943977e]()
        - Edited command summary. [\#2c516c9]()

    - Developer Guide:
        - Added implementation details of Doctors' Appointment, including all of its features. [\#1b1a7c2](), [\#6d353a7]()
        - Added UI component / diagram. [\#f4f6e62](), [\#088bff6]()
        - Added Non-functional requirements Component. [\#ac6f3eb]()

- **Contributions to Team-Based Tasks**:
    - Weekly meeting host
    - General code enhancements
    - Adjusting code for Java CI
    - Maintained issue tracker with creation of labels
    - Setting Milestones
    - Creating team organisation/ repository.

- **Review/Mentoring contributions**:
    - PR's reviewed: #66, #76, #143, #171, #304, #310, #317, #320, #327

- **Contributions beyond the team**:
    - Helped find and reported bugs in other team's application
    - Sharing common mistakes made by other team's program
