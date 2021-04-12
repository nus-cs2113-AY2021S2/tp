# Farm Zheng Hao's Project Portfolio Page

## Overview: Project MojoHr
MojoHr is a command line interface that allow the user, HR personnel to clear
emails more efficiently by streamlining the process.
This will help reduce the time spent on clearing emails and allow the user to focus on more productive things.

## Summary of Contributions
Given below are Farm's contribution to the project.

### Code Contributed
Refer to this [link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=farmzh98&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=FarmZH98&tabRepo=AY2021S2-CS2113-W10-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)
to see the contributed code.

### Enhancements implemented
#### 1. ComposeCommand: Composes email to be sent.
The ComposeCommand allows user to write an email which will be saved as Draft upon completion

#### 2. SendCommand: 
The SendCommand allows users to send Draft emails 
* Ensure that email addresses sent to must be of correct form (with Jalvin).
* Ensure that the Draft email list must be listed out first to prevent error on user's side.

#### 3. EditCommand: 
The EditCommand allows user to edit Draft emails
* Allows user to choose which part of the email he/she wants to edit
* Saves the timestamp of edited email
* Ensure that the Draft email list must be listed out to first to prevent error on user's side.

#### 4. SortCommand:
The SortCommand sorts emails according to time or Lexicographic order of sender's email address
* Implemented a comparator for sorting

#### 5. NumberCommand:
* The NumberCommand counts the number of emails according to type and prints it out to the user

### 6. Implemented checking of email validity

### Contributions to team-based tasks
* Actively provide suggestions for implementation of features
* Facilitate weekly meetings on completing weekly tasks

### Contributions to documentation
#### 1. User Guide
* Add user stories
* Add documentations for the following features: `compose`, `send`, `edit`, `sort`, `number`.

<div style="page-break-after: always;"></div>

#### 2. Developer Guide
* Add Implementation for the following features: `compose`, `send`, `sort`.