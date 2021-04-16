# Ong Wei Sheng - Project Portfolio Page

## Overview

easyLog helps home-based business owners better manage their item inventory and orders through a carefully optimized 
Command Line Interface(CLI). easyLog can manage logistics related matters faster than using just pen and paper.

## Summary of Contributions

The following are different sections to my contributions.

### Features implemented

The features that I have implemented are the following:

1. App Initialization.
2. Structure to process user input through `Parser`, `ItemsParser` and `OrdersParser` classes.
3. Structure for model components(classes that handle and manipulate related data inputted by the user)
4. Orders add feature.
5. Loading, creating and saving of save data.
6. Generation of receipt when an order done.
7. Logging class that provides the logging for easyLog.

### Code contributed

RepoSenes code contribution:
[Link to RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/#breakdown=true&search=ongweisheng)


### Enhancements implemented

The enhancements that I have implemented are the following:

1. Allowed users to continue inputting item number and quantity to input into the order while executing orders add
command when encountering an error due to formatting errors instead of exiting the command causing confusion.
2. Implementing `ItemsParser` and `OrdersParser` class so that the `Parser` class does not need to handle all user
inputs, which minimizes bugs due to the possible overlapping of commands related to items and orders features.
3. Ensured all exceptions are caught, even unknown exceptions that we do not have custom exceptions and code to handle,
such that the program does not crash or quit unexpectedly unless the user closes the app/program in correctly.
   
### Contributions to user guide

I contributed to the following sections in the user guide:

1. Table of contents
2. Section 2.3.2. (Orders add feature)
3. Section 2.4. (Storage related features)
4. Contributed to the overall formatting and proofreading of the User Guide.

### Contributions to developer guide

I contributed to the following sections in the developer guide:

1. Section 1. (Introduction)
2. Section 2.1. (Architecture design)
3. Section 2.2. (EasyLog Component design)
4. Section 2.3. (Ui component design)
5. Section 2.4. (Parser component design)
6. Section 2.7. (Storage component)
7. Section 3.1. (App Initialization implementation)
8. Section 3.2. (Processing of user inputs implementation)
9. Section 3.3. (Loading of data implementation)
10. Section 3.8. (Orders Done and generation of receipts implementation)
11. Section 3.9. (Exit command and creating and/or saving of save data implementation)    
12. Appendix B (User stories)

### Contributions to team-based tasks

I contributed to the following team-based tasks in the project:

1. Setting up the GitHub team org/repo.
2. Proofread and improved all code whenever necessary.
3. Setting up tools e.g., GitHub, Gradle.
4. Maintaining the issue tracker e.g. adding the necessary tags, assigning issues to the correct group member, closing
issues when completed.
5. Managed releases `v1.0` - `v2.1` (3 releases) on GitHub.   
6. Updating user/developer docs that are not specific to a feature.
7. Setup CI to work properly on GitHub to allow more errors e.g., checkstyle errors, compile errors to be automatically
caught and has to be resolved first before merging of pull requests are allowed.

### Review/mentoring contributions

1. Reviewed, approved and merged all PRs. (Links to PR [here](https://github.com/AY2021S2-CS2113T-T09-4/tp/pulls?q=is%3Apr+is%3Aclosed+no%3Aassignee+reviewed-by%3A%40me) 
   PRs not shown on this link here is before I started to use the review feature when merging PRs).
2. Helped group members to plan and implement their features. Answered any questions that they may have when
implementing their features.

### Contributions beyond the project team

Link to contributions [here](https://github.com/ongweisheng/ped/issues).
