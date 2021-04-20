# Jalvin Chan's Project Portfolio Page

## Overview: Project MojoHr
MojoHr is a command line interface that allow the user, HR personnel to clear
emails more efficiently by streamlining the process.
This will help reduce the time spent on clearing emails and allow the user to focus on more productive things.

## Summary of Contributions

### Code Contributed
Refer to this [link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=jalvinchan&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)
to see the contributed code.

### Enhancements implemented
#### 1. ReadCommand: Opens email to see their content
The ReadCommand prints the email content when a user opens the email and set email as read
* Added the read variable to the email class
* Ensured that the read field is saved into data file.

#### 2. TagCommand: Ability to label email
The tag command allows users to label a single email with multiple tags
* Added tag variable to the email class
* Ensured that multiple tags are added correctly.
* Ensured that the tag field is saved into data file correctly.

#### 3. Change email from single to multiple recipients
Emails should be able to be sent to multiple users.
* Change recipient variable to array.
* Change data file to be able to contain multiple recipients.
* Ensure that recipients are saved into data file correctly.
* As this feature is only implemented in v2.0, a lot of changes is needed to ensure that existing 
  features still function correctly.
* As other team members are working on the product at the same time, their features is implemented
  according to the single recipient email, resulting in quite a few merge conflicts when we merge 
  all the pull request.


### Contributions to documentation
* Add table of contents
* Add documentations for the following features: `read`, `tag`.

### Contributions to DG
* Add table of contents
* Add Architecture descriptions and UML diagrams.
* Add TagCommand implementation and UML diagram.

### Contributions to Team-based Task
* Include data files into jar file. Add code to handle resource.